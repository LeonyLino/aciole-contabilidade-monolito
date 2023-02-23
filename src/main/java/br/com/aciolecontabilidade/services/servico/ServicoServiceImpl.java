package br.com.aciolecontabilidade.services.servico;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.aciolecontabilidade.exceptions.EntidadeNaoEncontradaException;
import br.com.aciolecontabilidade.models.Servico;
import br.com.aciolecontabilidade.models.dto.CadastrarServicoDTO;
import br.com.aciolecontabilidade.models.dto.converter.CadastrarServicoDTOConverter;
import br.com.aciolecontabilidade.repository.ServicoRepository;
import br.com.aciolecontabilidade.utils.StringUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicoServiceImpl implements ServicoService {

	private final ServicoRepository sRepository;
	private final CadastrarServicoDTOConverter csDTOConverter;

	@Override
	@Transactional
	public void salvar(CadastrarServicoDTO dto) {
		sRepository
				.save(new Servico(dto.getId(), new BigDecimal(Double.valueOf(StringUtil.substituirPorPonto(dto.getValor()))),
						dto.getAnoReferencia(), LocalDate.now(), dto.getObservacoes(), dto.getCliente()));
	}
	
	private Servico buscarPorId(Long id) {
		return sRepository.findById(id).orElseThrow(EntidadeNaoEncontradaException::new);
	}

	@Override
	public CadastrarServicoDTO retornaDtoPorId(Long id) {
		return csDTOConverter.convert(buscarPorId(id));
	}

}
