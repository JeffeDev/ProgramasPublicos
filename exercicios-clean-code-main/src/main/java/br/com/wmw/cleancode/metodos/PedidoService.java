package br.com.wmw.cleancode.metodos;

//TODO: Reduzir a complexidade diminuindo o número de IFs aninhados
//TODO: Separar a responsabilidade de calcular o desconto da responsabilidade de executar o cálculo do desconto
//TODO: Trocar os valores fixos por constantes ou enuns
//TODO: Reduzir o número de parâmetros dos método
//TODO: Melhorar o nome do método conforme seu objetivo
public class PedidoService {
	Double desconto = 0D;

	public Double calcularDesconto(final Double valor, final Integer quantidade, final Integer estoque,
			final boolean descontoPorEstoque, final boolean descontoPorQuantidade) {

		if (descontoPorQuantidade) {
			desconto = CalcularValorDoDesconto(quantidade);
		}
		if (descontoPorEstoque) {
			desconto = AumentarCincoPorCentoSeEstoqueMaior1000(estoque);
		}
		return valor * AplicarDesconto(desconto);
	}

	private Double CalcularValorDoDesconto(Integer quantidade) {
		if (quantidade >= 100) {
			return 30D;
		}
		if (quantidade >= 50) {
			return 15D;
		}
		if (quantidade >= 10) {
			return 10D;
		}
		return 0D;
	}

	private Double AumentarCincoPorCentoSeEstoqueMaior1000(final Integer estoque) {
		if  (estoque > 1000) {
			desconto = desconto + 5D;
		}
		return desconto;
	}

	private double AplicarDesconto(Double desconto) {
		return 1 - (desconto / 100);
	}

}
