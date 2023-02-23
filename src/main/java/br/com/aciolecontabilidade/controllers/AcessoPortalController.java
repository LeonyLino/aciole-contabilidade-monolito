package br.com.aciolecontabilidade.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import br.com.aciolecontabilidade.enums.PortalEnum;
import br.com.aciolecontabilidade.models.Cliente;
import br.com.aciolecontabilidade.models.dto.AcessoPortalCadastroDTO;
import br.com.aciolecontabilidade.services.acessoportal.AcessoPortalService;
import br.com.aciolecontabilidade.services.cliente.ClienteService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Controller
@RequiredArgsConstructor
@RequestMapping("acessoPortal")
public class AcessoPortalController {

	private final ClienteService cService;
	private final AcessoPortalService apService;
	@Getter
	@Setter
	private Cliente cliente;

	@GetMapping("form/{idCliente}")
	public ModelAndView formCadastrar(@PathVariable String idCliente, AcessoPortalCadastroDTO dto, BindingResult resul,
			Principal principal) {
		ModelAndView mv = new ModelAndView("cliente/acesso-portal/form-cadastro-acesso-portal");
		mv.addObject("tiposEnum", PortalEnum.values());
		setCliente(cService.buscarPorId(Long.valueOf(idCliente)));
		mv.addObject("acessoPortalCliente", getCliente());
		return mv;
	}

	@PostMapping
	public ModelAndView salvar(@Valid AcessoPortalCadastroDTO dto, BindingResult result, Model model,
			Principal principal) {
		dto.setCliente(getCliente());
		ModelAndView mv = new ModelAndView("redirect:/cliente/detalhar/" + dto.getCliente().getId());

		try {
			if (result.hasErrors()) {
				return this.formCadastrar(cliente.getId().toString(), dto, result, principal);
			}

			apService.salvar(dto);
		} catch (Exception e) {
			e.getStackTrace();
		}

		return mv;
	}

	@GetMapping("editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("cliente/acesso-portal/form-cadastro-acesso-portal");
		AcessoPortalCadastroDTO dto = apService.retornaDtorPorId(id);
		setCliente(dto.getCliente());
		mv.addObject("acessoPortalCadastroDTO", dto);
		mv.addObject("tiposEnum", PortalEnum.values());
		mv.addObject("acessoPortalCliente", getCliente());
		return mv;
	}

	@GetMapping("remover/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void remover(@PathVariable Long id) {
		apService.remover(id);
	}

}
