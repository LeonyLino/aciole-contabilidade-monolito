package br.com.aciolecontabilidade.models.dto.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.aciolecontabilidade.models.AcessoPortal;
import br.com.aciolecontabilidade.models.dto.AcessoPortalCadastroDTO;

@Component
public class AcessoPortalCadastroDTOConverter implements Converter<AcessoPortal, AcessoPortalCadastroDTO> {

	@Override
	public AcessoPortalCadastroDTO convert(AcessoPortal acesso) {
		return AcessoPortalCadastroDTO.builder().id(acesso.getId()).descricao(acesso.getDescricao().toString())
				.codigoAcesso(acesso.getCodigoAcesso()).senha(acesso.getSenha()).cliente(acesso.getCliente()).build();
	}

}
