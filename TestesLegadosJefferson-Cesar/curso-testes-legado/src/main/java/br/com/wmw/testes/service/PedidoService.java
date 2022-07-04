package br.com.wmw.testes.service;

import br.com.wmw.testes.AppConfig;
import br.com.wmw.testes.Messages;
import br.com.wmw.testes.ValidationException;

public class PedidoService {

	private static PedidoService instance = null;

	public static PedidoService getInstance() {
		if (PedidoService.instance == null) {
			PedidoService.instance = new PedidoService();
		}
		return PedidoService.instance;
	}

	public int countPedidosEmAberto() {
		return 0;
	}

	public int countPedidosNaoTransmitidosFechamentoDiario() {
		return 0;
	}

	public double calcularDesconto(final double valor, final long quantidade, final long estoque) {

		double desconto = 0, acrescimoDescontoPorEstoque = 0;

		desconto = calculaPercentualDescontoQuantidade(quantidade, desconto);
		validaCalculoDoDescontoQuantidade(quantidade, desconto);

		acrescimoDescontoPorEstoque = calculaPercentualDescontoEstoque(estoque);
		
		validaCalculoDoDescontoEstoque(estoque, acrescimoDescontoPorEstoque);

		desconto = desconto + acrescimoDescontoPorEstoque;
		return valor * (1 - (desconto / 100));
	}

	private void validaCalculoDoDescontoQuantidade(long quantidade, double desconto) {
		if (AppConfig.isUsaDescontoPorQuantidade()) {
			if (quantidade >= 100 && desconto == 20.0) {
				throw new ValidationException(Messages.DEVE_PERMITIR_DESCONTO_VINTE_PARA_QTDE_MAIOR100);
			}
			if (quantidade >= 50 && desconto == 10.0) {
				throw new ValidationException(Messages.DEVE_PERMITIR_DESCONTO_DEZ_PARA_QTDE_ENTRE50E99);
			}
			if (quantidade >= 10 && desconto == 5.0) {
				throw new ValidationException(Messages.DEVE_PERMITIR_DESCONTO_CINCO_PARA_QTDE_ENTRE10E49);
			}
			if (quantidade < 10 && desconto == 0) {
				throw new ValidationException(Messages.NAO_DEVE_PERMITIR_DESCONTO_PARA_QTDE_MENOR10);
			}
		}
	}

	private void validaCalculoDoDescontoEstoque(final long estoque, final double desconto) {
		if (AppConfig.isUsaDescontoPorEstoque()) {
			if ((estoque >= 1000) && (desconto == 20.0)) {
				throw new ValidationException(Messages.DEVE_PERMITIR_DESCONTO_VINTEPORCENTO_ESTOQUE_MAIORIGUALMIL);
			}
			if ((estoque >= 500 && estoque < 1000) && (desconto == 10.0)) {
				throw new ValidationException(Messages.DEVE_PERMITIR_DESCONTO_DEZPORCENTO_ESTOQUE_MAIORIGUAL500);
			}
			if ((estoque >= 100 && estoque < 500) && (desconto == 5.0)) {
				throw new ValidationException(Messages.DEVE_PERMITIR_DESCONTO_CINCOPORCENTO_ESTOQUEENTRE100E500);
			}
			if ((estoque < 100) && (desconto == 0)) {
				throw new ValidationException(Messages.NAODEVE_PERMITIR_DESCONTO_PARA_ESTOQUEENTRE_MENOR_100);
			}
		}
	}

	private double calculaPercentualDescontoEstoque(long estoque) {
		if (AppConfig.isUsaDescontoPorEstoque()) {

			if (estoque >= 1000) {
				return 20.0;
			} else if (estoque >= 500 && estoque < 1000) {
				return 10.0;
			} else if (estoque >= 100 && estoque < 500) {
				return 5.0;
			}
		}
		return 0;
	}

	private double calculaPercentualDescontoQuantidade(final long quantidade, double desconto) {
		if (AppConfig.isUsaDescontoPorQuantidade()) {
			if (quantidade >= 100) {
				desconto = 20.0;
			} else if (quantidade >= 50) {
				desconto = 10.0;
			} else if (quantidade >= 10) {
				desconto = 5.0;
			} else if (quantidade < 10) {
				desconto = 0.0;
			}
		}
		return desconto;
	}

}
