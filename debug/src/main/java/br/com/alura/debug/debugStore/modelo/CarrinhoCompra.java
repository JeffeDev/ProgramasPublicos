package br.com.alura.debug.debugStore.modelo;

import java.math.BigDecimal;
import java.util.List;

public class CarrinhoCompra {
	
	private FormaPagamento formaPagamento;
	
	public CarrinhoCompra(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	
	public BigDecimal calcularPrecoFinal(List<Produto> produtos) {
		BigDecimal total = new BigDecimal(0);
		for (Produto produto : produtos) {
			BigDecimal preco = produto.getPreco();
			double porcentagemDesconto = this.getFormaPagamento().getPorcentagemDesconto();
			BigDecimal valorComDesconto = preco.multiply(new BigDecimal(porcentagemDesconto)).divide(new BigDecimal("100"));
			BigDecimal valorProdutoComDesconto =  preco.subtract(valorComDesconto);
			total = total.add(valorProdutoComDesconto);
		}
		return total;
	}

	
}
