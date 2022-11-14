package br.com.aciolecontabilidade.models.dto;

import br.com.aciolecontabilidade.enums.PortalEnum;
import br.com.aciolecontabilidade.models.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcessoPortalDTO {

	private PortalEnum descricao;
	private String codigoAcesso;
	private String senha;
	private Cliente cliente;
}
