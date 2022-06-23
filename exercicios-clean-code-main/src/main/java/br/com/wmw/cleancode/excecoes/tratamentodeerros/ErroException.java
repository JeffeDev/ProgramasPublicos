package br.com.wmw.cleancode.excecoes.tratamentodeerros;

public class ErroException extends Exception {

	private static final long serialVersionUID = 1L;

	public ErroException(String message, Throwable cause) {
		super("Ocorreu um erro no arquivo " + message, cause);
	}

}
