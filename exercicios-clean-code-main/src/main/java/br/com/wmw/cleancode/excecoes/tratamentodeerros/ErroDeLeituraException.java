package br.com.wmw.cleancode.excecoes.tratamentodeerros;

public class ErroDeLeituraException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ErroDeLeituraException(String message, Throwable cause) {
		super("Arquivo: " + message + " está com erro de leitura, danificado ou sem permissão!", cause);
	}
	

}
