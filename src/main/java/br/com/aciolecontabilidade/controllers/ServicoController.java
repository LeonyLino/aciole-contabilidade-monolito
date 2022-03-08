package br.com.aciolecontabilidade.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.aciolecontabilidade.models.dto.CadastrarServicoDTO;
import br.com.aciolecontabilidade.services.servico.ServicoService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("servico")
public class ServicoController {

	private final ServicoService sService;

	@PostMapping
	public ModelAndView cadastrar(CadastrarServicoDTO dto, BindingResult result, Model model) {
		ModelAndView mv = new ModelAndView();
		sService.salvar(dto);
		mv.setViewName("redirect:/cliente/detalhar/" + dto.getIdCliente());
		
		return mv;

	}

}
