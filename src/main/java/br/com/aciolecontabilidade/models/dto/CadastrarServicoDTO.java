package br.com.aciolecontabilidade.models.dto;

import javax.validation.constraints.NotEmpty;

import br.com.aciolecontabilidade.models.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarServicoDTO {

	@NotEmpty
	private String valor;
	@NotEmpty
	private String anoReferencia;
	private String observacoes;
	private Cliente cliente;

}
