package br.com.aciolecontabilidade.services.cliente;

import java.util.List;

import br.com.aciolecontabilidade.exceptions.ClienteEncontradoException;
import br.com.aciolecontabilidade.models.dto.ClienteDTO;
import br.com.aciolecontabilidade.models.dto.ClienteDTOOut;

public interface ClienteService {

	void cadastrar(ClienteDTO dto) throws ClienteEncontradoException;

	List<ClienteDTOOut> listar();

}
