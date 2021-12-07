package br.com.aciolecontabilidade.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.aciolecontabilidade.models.dto.UserDTO;
import br.com.aciolecontabilidade.services.users.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

	private final UserService uService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(UserDTO dto, BindingResult resul, Principal principal) {
		ModelAndView mv = new ModelAndView("user/cadastrar");
		mv.addObject("itemMenu", "novoUser");
		mv.addObject("nomeUser", principal.getName());
		return mv;
	}

	@PostMapping
	public ModelAndView salvar(UserDTO dto, BindingResult resul, Principal principal) {
		ModelAndView mv = new ModelAndView("");

		return mv;
	}

}
