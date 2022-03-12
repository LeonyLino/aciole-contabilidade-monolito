package br.com.aciolecontabilidade.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoServicoEnum {
	
	DECLARACAO_IRPF(1, "Declaração IRPF"), DECLARACAO_IRPJ(2, "Declaração IRPJ");

	private Integer id;
	private String descricao;

}
