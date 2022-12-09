package br.com.aciolecontabilidade.models.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.aciolecontabilidade.enums.PortalEnum;
import br.com.aciolecontabilidade.enums.TipoClienteEnum;
import br.com.aciolecontabilidade.models.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcessoPortalCadastroDTO {

	@NotEmpty(message = "Favor selecionar um valor!")
	private String descricao;
	@Size(max = 12, message = "Campo suporta até 12 números")
	private String codigoAcesso;
	@NotEmpty(message = "Campo Obrigatório!")
	private String senha;
	private Cliente cliente;

	public PortalEnum getDescicaoPortal() {
		for (PortalEnum pe : PortalEnum.values()) {
			if (pe.toString().equals(descricao)) {
				return pe;
			}
		}
		return null;
	}
}