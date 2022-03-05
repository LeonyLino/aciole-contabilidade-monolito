package br.com.aciolecontabilidade.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoServicoEnum {
	
	DECLARACAO_IRPF("Declaração IRPF"), DECLARACAO_IRPJ("Declaração IRPJ");

	private String descricao;

}
