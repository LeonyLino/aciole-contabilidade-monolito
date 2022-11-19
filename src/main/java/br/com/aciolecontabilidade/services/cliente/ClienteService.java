package br.com.aciolecontabilidade.services.cliente;

import java.util.List;

import br.com.aciolecontabilidade.exceptions.ClienteEncontradoException;
import br.com.aciolecontabilidade.models.Cliente;
import br.com.aciolecontabilidade.models.dto.ClienteDTOOut;
import br.com.aciolecontabilidade.models.dto.ClienteIRCadastroDTO;
import br.com.aciolecontabilidade.models.dto.DetalharClienteDTO;

public interface ClienteService {

	void cadastrar(ClienteIRCadastroDTO dto) throws ClienteEncontradoException;

	List<ClienteDTOOut> listar();
	
	Cliente buscarPorId(Long id);
	
	DetalharClienteDTO buscarPorIdPraDetalhe(Long id);

}
