package br.com.aciolecontabilidade.models.dto;

import javax.validation.constraints.NotEmpty;

import br.com.aciolecontabilidade.models.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CadastrarServicoDTO {

	private Long id;
	@NotEmpty
	private String valor;
	@NotEmpty
	private String anoReferencia;
	private String observacoes;
	private Cliente cliente;

}
