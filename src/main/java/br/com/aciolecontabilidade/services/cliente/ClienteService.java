package br.com.aciolecontabilidade.services.cliente;

import br.com.aciolecontabilidade.exceptions.ClienteEncontradoException;
import br.com.aciolecontabilidade.models.dto.ClienteDTO;

public interface ClienteService {
	
	ClienteDTO cadastrar(ClienteDTO dto) throws ClienteEncontradoException;

}
