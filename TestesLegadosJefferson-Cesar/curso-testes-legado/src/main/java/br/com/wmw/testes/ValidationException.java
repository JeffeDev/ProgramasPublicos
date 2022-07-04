package br.com.wmw.testes;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValidationException(final String message) {
		super(message);
	}

}
