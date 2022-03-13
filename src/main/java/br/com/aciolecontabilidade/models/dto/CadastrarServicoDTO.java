package br.com.aciolecontabilidade.models.dto;

import javax.validation.constraints.NotEmpty;

import br.com.aciolecontabilidade.enums.TipoServicoEnum;
import br.com.aciolecontabilidade.models.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarServicoDTO {

	@NotEmpty
	private String tipo;
	@NotEmpty
	private String valor;
	private Cliente cliente;

	public TipoServicoEnum getTipoServico() {
		for (TipoServicoEnum tqe : TipoServicoEnum.values()) {
			if (tqe.getId().equals(Integer.valueOf(tipo))) {
				return tqe;
			}
		}
		return null;
	}

}
