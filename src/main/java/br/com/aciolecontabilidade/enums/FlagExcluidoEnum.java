package br.com.aciolecontabilidade.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FlagExcluidoEnum {
	
	SIM('S', "Sim"), NAO('N', "Não");

	private Character chave;
	private String descricao;
}
