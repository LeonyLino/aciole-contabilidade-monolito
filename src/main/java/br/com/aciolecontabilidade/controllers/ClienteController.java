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

import br.com.aciolecontabilidade.exceptions.ClienteEncontradoException;
import br.com.aciolecontabilidade.models.dto.ClienteDTO;
import br.com.aciolecontabilidade.services.cliente.ClienteService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("cliente")
public class ClienteController {

	private final ClienteService cService;

	@GetMapping("/home")
	public ModelAndView index(Principal principal) {
		ModelAndView mv = new ModelAndView("cliente/home");
		mv.addObject("itemMenu", "home");
		mv.addObject("nomeUser", principal.getName());

		return mv;
	}

	@GetMapping("/form")
	public ModelAndView cadastrar(ClienteDTO clienteDTO, BindingResult resul, Principal principal) {

		ModelAndView mv = new ModelAndView("cliente/form-cadastro-cliente");
		mv.addObject("itemMenu", "cliente");
		mv.addObject("nomeUser", principal.getName());

		return mv;
	}

	@PostMapping
	public ModelAndView salvar(@Valid ClienteDTO clienteDTO, BindingResult result, Model model, Principal principal) {
		ModelAndView mv = new ModelAndView("redirect:/cliente/listar");
		try {
			if (result.hasErrors()) {
				return this.cadastrar(clienteDTO, result, principal);
			}

			cService.cadastrar(clienteDTO);
		} catch (ClienteEncontradoException e) {
			mv.setViewName("cliente/form-cadastro-cliente");
			mv.addObject("errorMessage", e.getMessage());
		}

		return mv;
	}

	@GetMapping("/listar")
	public ModelAndView listar(Principal principal, ClienteDTO dto) {
		ModelAndView mv = new ModelAndView("cliente/listar");
		mv.addObject("itemMenu", "cliente");
		mv.addObject("nomeUser", principal.getName());
		mv.addObject("clientes", cService.listar());
		return mv;
	}
	
	@GetMapping("/detalhar/{id}")
	public ModelAndView listar(Principal principal, @PathVariable String id) {
		ModelAndView mv = new ModelAndView("cliente/detalhe");
		mv.addObject("itemMenu", "cliente");
		mv.addObject("nomeUser", principal.getName());
		mv.addObject("cliente", cService.buscarPorIdPraDetalhe(Long.valueOf(id)));
		return mv;
	}

}