package br.com.aciolecontabilidade.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

	
	@GetMapping
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
}
