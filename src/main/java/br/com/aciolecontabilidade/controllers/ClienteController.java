package br.com.aciolecontabilidade.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@GetMapping
	@RequestMapping("/menu/{itemMenu}")
	public String menuPage(@PathVariable("itemMenu") String itemMenu, Model model, ClienteDTO clienteDTO,
			BindingResult result) {
		model.addAttribute("itemMenu", itemMenu);
		
		return "sliderbar";
	}

	@PostMapping("novo")
	public String salvar(@Valid ClienteDTO clienteDTO, BindingResult result, Model model) {

		try {
			if (result.hasErrors()) {
				return "cliente/form";
			}

			cService.cadastrar(clienteDTO);
		} catch (ClienteEncontradoException e) {
			model.addAttribute("errorMessage", e.getMessage());
		}

		return "cliente/form";
	}

}