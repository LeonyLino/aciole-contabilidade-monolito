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

	@GetMapping("form")
	public String index(ClienteDTO clienteDTO) {

		return "cliente/form";
	}

	@GetMapping("/menu/{itemMenu}")
	public ModelAndView menuPage(@PathVariable("itemMenu") String itemMenu, ClienteDTO clienteDTO, BindingResult resul,
			Principal principal) {

		ModelAndView mv = new ModelAndView("cliente/".concat(itemMenu));
		mv.addObject("itemMenu", itemMenu);
		mv.addObject("nomeUser", principal.getName());

		return mv;
	}

//	@GetMapping("/menu")
//	public ModelAndView ModelAndView(Principal principal, ClienteDTO clienteDTO) {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("nomeUser", principal.getName());
//		return mv;
//	}

	@PostMapping("novo")
	public ModelAndView salvar(@Valid ClienteDTO clienteDTO, BindingResult result, Model model) {
		ModelAndView mv = new ModelAndView();
		try {
			if (result.hasErrors()) {
				return this.menuPage("cadCliente", null, result, null);
			}

			cService.cadastrar(clienteDTO);
		} catch (ClienteEncontradoException e) {
			model.addAttribute("errorMessage", e.getMessage());
		}

		return mv;
	}

}