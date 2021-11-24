package br.com.aciolecontabilidade.exceptions;

import org.springframework.http.HttpStatus;

public abstract class AbstractAcioleContabilidadeRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	protected AbstractAcioleContabilidadeRuntimeException() {
		super();
	}

	protected AbstractAcioleContabilidadeRuntimeException(String message) {
		super(message);
	}
	
	protected AbstractAcioleContabilidadeRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public abstract HttpStatus getStatus();
}
