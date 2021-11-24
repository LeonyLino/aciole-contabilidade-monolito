package br.com.aciolecontabilidade.exceptions;

public class EntidadeNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException() {
		super("Nenhum registro localizado.");
	}
}
