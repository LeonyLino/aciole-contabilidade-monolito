package br.com.aciolecontabilidade.exceptions;

import org.springframework.http.HttpStatus;

public class ClienteEncontradoException extends AbstractAcioleContabilidadeRuntimeException {

	private static final long serialVersionUID = 1L;

	public ClienteEncontradoException(String messages) {
		super(messages + " Já foi cadastrado");
	}

	@Override
	public HttpStatus getStatus() {
		return HttpStatus.BAD_REQUEST;
	}

}
