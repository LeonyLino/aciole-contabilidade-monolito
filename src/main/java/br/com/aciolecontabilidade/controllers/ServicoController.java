package br.com.aciolecontabilidade.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.aciolecontabilidade.enums.TipoServicoEnum;
import br.com.aciolecontabilidade.models.Cliente;
import br.com.aciolecontabilidade.models.dto.CadastrarServicoDTO;
import br.com.aciolecontabilidade.services.cliente.ClienteService;
import br.com.aciolecontabilidade.services.servico.ServicoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Controller
@RequiredArgsConstructor
@RequestMapping("servico")
public class ServicoController {

	private final ServicoService sService;
	private final ClienteService cService;
	@Getter
	@Setter
	private Cliente cliente;

	@GetMapping("form/{idCliente}")
	public ModelAndView cadastrar(@PathVariable String idCliente, CadastrarServicoDTO dto, BindingResult resul,
			Principal principal) {
		ModelAndView mv = new ModelAndView("cliente/servico/form-cadastro-servico");
		mv.addObject("itemMenu", "cliente");
		mv.addObject("nomeUser", principal.getName());
		mv.addObject("tiposEnum", TipoServicoEnum.values());
		this.cliente = cService.buscarPorId(Long.valueOf(idCliente));
		mv.addObject("servicoAddCliente", cliente);
		return mv;
	}

	@PostMapping
	public ModelAndView salvar(@Valid CadastrarServicoDTO dto, BindingResult result, Model model, Principal principal) {
		dto.setCliente(cliente);
		ModelAndView mv = new ModelAndView("redirect:/cliente/detalhar/" + dto.getCliente().getId());
		
		try {
			if (result.hasErrors()) {
				return this.cadastrar(cliente.getId().toString(), dto, result, principal);
			}
			sService.salvar(dto);
		} catch (Exception e) {
			e.getStackTrace();
		}

		return mv;
	}

}
