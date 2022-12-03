package br.com.aciolecontabilidade.services.cliente;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import br.com.aciolecontabilidade.enums.FlagFixoEnum;
import br.com.aciolecontabilidade.enums.TipoClienteEnum;
import br.com.aciolecontabilidade.exceptions.ClienteEncontradoException;
import br.com.aciolecontabilidade.exceptions.EntidadeNaoEncontradaException;
import br.com.aciolecontabilidade.models.Cliente;
import br.com.aciolecontabilidade.models.dto.ClienteDTOOut;
import br.com.aciolecontabilidade.models.dto.ClienteIRCadastroDTO;
import br.com.aciolecontabilidade.models.dto.DetalharClienteIRDTO;
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
	public void cadastrar(ClienteIRCadastroDTO dto) throws ClienteEncontradoException {
		String documento = StringUtil
				.removerMascara(dto.getTipoCliente().equals(TipoClienteEnum.PF) ? dto.getCpfIR() : dto.getCnpjIR());

		dto.setNumContatoIR(StringUtil.removerMascara(dto.getNumContatoIR()));

		this.validarDadosExistentes(dto, documento);
		cRepository.save(new Cliente(null, null, dto.getNomeIR(), documento, dto.getRgIR().isBlank() ? null : dto.getRgIR(),
				dto.getTituloIR().isBlank() ? null : dto.getTituloIR(), dto.getNumContatoIR(),
				dto.getEmailIR().isBlank() ? null : dto.getEmailIR(), dto.getDtNascimentoIR(), null,
				FlagFixoEnum.NAO.getChave(), dto.getTipoCliente(), null));

	}

	private void validarDadosExistentes(ClienteIRCadastroDTO dto, String documento) throws ClienteEncontradoException {

		if (cRepository.existsByCpfCnpj(documento))
			throw new ClienteEncontradoException(
					dto.getTipoCliente().equals(TipoClienteEnum.PF) ? "CPF: " : "CNPJ: " + documento);

		if (cRepository.existsByRg(dto.getRgIR()))
			throw new ClienteEncontradoException("RG: " + dto.getRgIR());

		if (cRepository.existsByTituloEleitor(dto.getTituloIR()))
			throw new ClienteEncontradoException("Título de Eleitor: " + dto.getTituloIR());

		if (cRepository.existsByEmail(dto.getEmailIR()))
			throw new ClienteEncontradoException("E-mail: " + dto.getEmailIR());

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
	public DetalharClienteIRDTO buscarPorIdPraDetalhe(Long id) {
		return dcDTOConverter.convert(this.buscarPorId(id));
	}

	@Override
	public boolean validarFormClienteIR(BindingResult result, ClienteIRCadastroDTO dto) {
		return (result.hasErrors()
				&& (dto.getTipoCliente() != null && dto.getTipoCliente().equals(TipoClienteEnum.PF)
						&& result.hasFieldErrors("cpfIR"))
				|| (dto.getTipoCliente() != null && dto.getTipoCliente().equals(TipoClienteEnum.PJ)
						&& result.hasFieldErrors("cnpjIR"))
				|| (!dto.getTituloIR().isBlank() && result.hasFieldErrors("tituloIR")))
				|| (result.hasErrors() && result.getErrorCount() > 2);
	}

}
