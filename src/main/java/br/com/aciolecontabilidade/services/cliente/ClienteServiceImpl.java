package br.com.aciolecontabilidade.services.cliente;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.aciolecontabilidade.enums.FlagFixoEnum;
import br.com.aciolecontabilidade.exceptions.ClienteEncontradoException;
import br.com.aciolecontabilidade.exceptions.EntidadeNaoEncontradaException;
import br.com.aciolecontabilidade.models.Cliente;
import br.com.aciolecontabilidade.models.dto.ClienteDTOOut;
import br.com.aciolecontabilidade.models.dto.ClientePFDTO;
import br.com.aciolecontabilidade.models.dto.DetalharClienteDTO;
import br.com.aciolecontabilidade.models.dto.converter.ClienteDTOConverter;
import br.com.aciolecontabilidade.models.dto.converter.DetalharClienteDTOConverter;
import br.com.aciolecontabilidade.repository.ClienteRepository;
import br.com.aciolecontabilidade.utils.StringUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

	private final ClienteRepository cRepository;
	private final ClienteDTOConverter cDTOConverter;
	private final DetalharClienteDTOConverter dcDTOConverter;

	@Override
	@Transactional
	public void cadastrar(ClientePFDTO dto) throws ClienteEncontradoException {

		dto.setCpfCnpjPF(StringUtil.removerMascara(dto.getCpfCnpjPF()));
		dto.setNumContatoPF(StringUtil.removerMascara(dto.getNumContatoPF()));

		this.validarDadosExistentes(dto);
		cRepository.save(new Cliente(null, null, dto.getNomePF(), dto.getCpfCnpjPF(), dto.getRgPF(), dto.getTituloPF(),
				dto.getNumContatoPF(), dto.getEmailPF(), dto.getDtNascimentoPF(), null, FlagFixoEnum.SIM.getChave(),
				dto.getTipoServico(), null));

	}

	private void validarDadosExistentes(ClientePFDTO dto) throws ClienteEncontradoException {

		if (cRepository.existsByCpfCnpj(dto.getCpfCnpjPF())) {
			throw new ClienteEncontradoException("CPF: " + dto.getCpfCnpjPF());
		}

		if (cRepository.existsByRg(dto.getRgPF())) {
			throw new ClienteEncontradoException("RG: " + dto.getRgPF());
		}

		if (cRepository.existsByTituloEleitor(dto.getTituloPF())) {
			throw new ClienteEncontradoException("Título de Eleitor: " + dto.getTituloPF());
		}

		if (cRepository.existsByEmail(dto.getEmailPF())) {
			throw new ClienteEncontradoException("E-mail: " + dto.getCpfCnpjPF());
		}

	}

	@Override
	public List<ClienteDTOOut> listar() {
//		Sort sort = Sort.by("nome");
//		PageRequest paginacao = PageRequest.of(0, 10, sort);
		return cRepository.findAll().stream().map(cDTOConverter::convert).collect(Collectors.toList());

	}

	public Cliente buscarPorId(Long id) {
		return cRepository.findById(id).orElseThrow(EntidadeNaoEncontradaException::new);
	}

	@Override
	public DetalharClienteDTO buscarPorIdPraDetalhe(Long id) {
		return dcDTOConverter.convert(this.buscarPorId(id));
	}

}
