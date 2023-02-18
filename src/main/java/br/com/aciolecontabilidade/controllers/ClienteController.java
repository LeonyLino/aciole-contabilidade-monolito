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

import br.com.aciolecontabilidade.enums.TipoClienteEnum;
import br.com.aciolecontabilidade.exceptions.ClienteEncontradoException;
import br.com.aciolecontabilidade.models.dto.ClienteIRCadastroDTO;
import br.com.aciolecontabilidade.services.cliente.ClienteService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("cliente")
public class ClienteController {

	private final ClienteService cService;
	private static final String ITEM_MENU_CLIENTE = "cliente";

	@GetMapping("/home")
	public ModelAndView index(Principal principal) {
		ModelAndView mv = new ModelAndView("cliente/home");
		mv.addObject("itemMenu", "home");
		mv.addObject("nomeUser", principal.getName());

		return mv;
	}

	@GetMapping("/form")
	public ModelAndView cadastrar(ClienteIRCadastroDTO clienteDTO, BindingResult resul, Principal principal,
			String mensagem) {

		ModelAndView mv = new ModelAndView("cliente/form-cadastro-cliente");
		mv.addObject("itemMenu", ITEM_MENU_CLIENTE);
		mv.addObject("nomeUser", principal.getName());
		mv.addObject("tiposClientes", TipoClienteEnum.values());
		if (mensagem != null)
			mv.addObject("errorMessage", mensagem);

		return mv;
	}

	@PostMapping
	public ModelAndView salvar(@Valid ClienteIRCadastroDTO clienteDTO, BindingResult result, Model model,
			Principal principal) {
		ModelAndView mv = new ModelAndView("redirect:/cliente/listar");
		try {
			if (cService.validarFormClienteIR(result, clienteDTO)) {
				return this.cadastrar(clienteDTO, result, principal, null);
			}

			cService.cadastrar(clienteDTO);
		} catch (ClienteEncontradoException e) {
			return this.cadastrar(clienteDTO, result, principal, e.getMessage());
		}

		return mv;
	}

	@GetMapping("/listar")
	public ModelAndView listar(Principal principal, ClienteIRCadastroDTO dto) {
		ModelAndView mv = new ModelAndView("cliente/listar");
		mv.addObject("itemMenu", ITEM_MENU_CLIENTE);
		mv.addObject("nomeUser", principal.getName());
		mv.addObject("clientes", cService.listar());
		return mv;
	}

	@GetMapping("/detalhar/{id}")
	public ModelAndView detalhar(Principal principal, @PathVariable String id) {
		ModelAndView mv = new ModelAndView("cliente/detalhe");
		mv.addObject("itemMenu", ITEM_MENU_CLIENTE);
		mv.addObject("nomeUser", principal.getName());
		mv.addObject(ITEM_MENU_CLIENTE, cService.buscarPorIdPraDetalhe(Long.valueOf(id)));
		return mv;
	}
	
	@GetMapping("/remover/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void remover(Principal principal, @PathVariable String id) {
 		cService.removerPorId(Long.valueOf(id));
 		this.listar(principal, null);
	}

}