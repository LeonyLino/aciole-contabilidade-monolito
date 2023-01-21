package br.com.aciolecontabilidade.models.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.aciolecontabilidade.enums.PortalEnum;
import br.com.aciolecontabilidade.models.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AcessoPortalCadastroDTO {

	private Long id;
	@NotEmpty(message = "Favor selecionar um valor!")
	private String descricao;
	@Size(max = 12, message = "Campo suporta até 12 números")
	private String codigoAcesso;
	@NotEmpty(message = "Campo Obrigatório!")
	@Size(max = 15, message = "Campo suporte até 15 caractéres")
	private String senha;
	private Cliente cliente;

	public PortalEnum getDescricaoPortal() {
		for (PortalEnum pe : PortalEnum.values()) {
			if (pe.toString().equals(descricao)) {
				return pe;
			}
		}
		return null;
	}
}