package br.com.wmw.cleancode.excecoes.tratamentodeerros;

public class ErroArquivoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ErroArquivoNaoEncontradoException(String message, Throwable cause) {
		super("Arquivo: " + message + " Não foi encontrado!", cause);
		
	}
	
}

