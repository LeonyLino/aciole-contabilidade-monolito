package br.com.aciolecontabilidade.services.servico;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.aciolecontabilidade.models.Servico;
import br.com.aciolecontabilidade.models.dto.CadastrarServicoDTO;
import br.com.aciolecontabilidade.repository.ServicoRepository;
import br.com.aciolecontabilidade.utils.StringUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicoServiceImpl implements ServicoService {

	private final ServicoRepository sRepository;

	@Override
	@Transactional
	public void salvar(CadastrarServicoDTO dto) {
		sRepository.save(new Servico(dto.getTipoServico(),
				new BigDecimal(Double.valueOf(StringUtil.substituirPorPonto(dto.getValor()))), dto.getCliente()));
	}

}
