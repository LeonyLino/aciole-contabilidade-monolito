package br.com.aciolecontabilidade.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping
	@RequestMapping("/menu")
	public String menu() {
		return "sliderbar";
	}
	
	@GetMapping
	@RequestMapping("/menu/{itemMenu}")
	public String menuPage(@PathVariable("itemMenu") String itemMenu,  Model model) {
		model.addAttribute("itemMenu", itemMenu);
		return "sliderbar";
	}
}
