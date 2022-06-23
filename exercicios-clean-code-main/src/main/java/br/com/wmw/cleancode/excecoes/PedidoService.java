package br.com.wmw.cleancode.excecoes;

import br.com.wmw.cleancode.excecoes.tratamentodeerros.ErroEspecificoException;

public class PedidoService {

	public void validarPreco(final Double valor) throws Exception{
		if (valor < 0) {
			throw new ErroEspecificoException("Valor deve ser maior que zero");
		}
	}

}
