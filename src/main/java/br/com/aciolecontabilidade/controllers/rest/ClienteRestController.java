package br.com.aciolecontabilidade.controllers.rest;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aciolecontabilidade.models.dto.ClienteDTO;
import br.com.aciolecontabilidade.services.cliente.ClienteService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest-cliente")
public class ClienteRestController {

	private final ClienteService cService;

	@PostMapping
	public ResponseEntity<ClienteDTO> salvar(@RequestBody @Valid ClienteDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cService.cadastrar(dto));
	}

}
