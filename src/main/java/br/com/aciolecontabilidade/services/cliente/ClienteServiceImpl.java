package br.com.aciolecontabilidade.services.cliente;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.aciolecontabilidade.exceptions.ClienteEncontradoException;
import br.com.aciolecontabilidade.models.Cliente;
import br.com.aciolecontabilidade.models.dto.ClienteDTO;
import br.com.aciolecontabilidade.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

	private final ClienteRepository cRepository;

	@Override
	@Transactional
	public ClienteDTO cadastrar(ClienteDTO dto) throws ClienteEncontradoException {

		this.verificaExistenciaCliente(dto);
		cRepository.save(new Cliente(null, dto.getNomeCliente(), dto.getCpfCliente(), dto.getRgCliente(),
				dto.getTituloEleitorCliente(), dto.getNumContato(), dto.getEmail(), dto.getDtNascimento(),
				BigDecimal.ZERO));

		return null;
	}

	private void verificaExistenciaCliente(ClienteDTO dto) throws ClienteEncontradoException {

		if (cRepository.existsByCpf(dto.getCpfCliente())) {
			throw new ClienteEncontradoException("CPF: " + dto.getCpfCliente());
		}

		if (cRepository.existsByRg(dto.getRgCliente())) {
			throw new ClienteEncontradoException("RG: " + dto.getRgCliente());
		}

		if (cRepository.existsByTituloEleitor(dto.getTituloEleitorCliente())) {
			throw new ClienteEncontradoException("Título de Eleitor: " + dto.getTituloEleitorCliente());
		}

		if (cRepository.existsByEmail(dto.getEmail())) {
			throw new ClienteEncontradoException("E-mail: " + dto.getEmail());
		}

	}

}
