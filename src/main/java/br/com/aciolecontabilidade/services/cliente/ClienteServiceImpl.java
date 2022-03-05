package br.com.aciolecontabilidade.services.cliente;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.aciolecontabilidade.enums.FlagAtivoEnum;
import br.com.aciolecontabilidade.exceptions.ClienteEncontradoException;
import br.com.aciolecontabilidade.models.Cliente;
import br.com.aciolecontabilidade.models.dto.ClienteDTO;
import br.com.aciolecontabilidade.models.dto.ClienteDTOOut;
import br.com.aciolecontabilidade.models.dto.converter.ClienteDTOConverter;
import br.com.aciolecontabilidade.repository.ClienteRepository;
import br.com.aciolecontabilidade.utils.StringUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

	private final ClienteRepository cRepository;
	private final ClienteDTOConverter cDTOConverter;

	@Override
	@Transactional
	public void cadastrar(ClienteDTO dto) throws ClienteEncontradoException {

		dto.setCpfCliente(StringUtil.removerMascara(dto.getCpfCliente()));
		dto.setNumContato(StringUtil.removerMascara(dto.getNumContato()));

		this.verificaExistenciaCliente(dto);
		cRepository.save(new Cliente(dto.getNomeCliente(), dto.getNomeFantasia(), dto.getCpfCliente(),
				dto.getCnpj(), dto.getRgCliente(), dto.getTituloEleitorCliente(), dto.getNumContato(), dto.getEmail(),
				dto.getDtNascimento(), dto.getSenhaGov(), FlagAtivoEnum.SIM.getChave()));

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

	@Override
	public List<ClienteDTOOut> listar() {
//		Sort sort = Sort.by("nome");
//		PageRequest paginacao = PageRequest.of(0, 10, sort);
		return cRepository.findAll().stream().map(cDTOConverter::convert).collect(Collectors.toList());

	}

}
