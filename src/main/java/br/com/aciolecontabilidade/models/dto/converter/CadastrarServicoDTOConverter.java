package br.com.aciolecontabilidade.models.dto.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.aciolecontabilidade.models.Servico;
import br.com.aciolecontabilidade.models.dto.CadastrarServicoDTO;

@Component
public class CadastrarServicoDTOConverter implements Converter<Servico, CadastrarServicoDTO> {

	@Override
	public CadastrarServicoDTO convert(Servico servico) {
		return CadastrarServicoDTO.builder().id(servico.getId()).valor(servico.getValor().toString())
				.anoReferencia(servico.getAnoReferencia()).observacoes(servico.getObservacoes())
				.cliente(servico.getCliente()).build();
	}

}
