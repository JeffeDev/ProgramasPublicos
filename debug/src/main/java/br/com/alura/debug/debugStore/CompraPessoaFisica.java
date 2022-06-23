package br.com.alura.debug.debugStore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.debug.debugStore.modelo.CarrinhoCompra;
import br.com.alura.debug.debugStore.modelo.Categoria;
import br.com.alura.debug.debugStore.modelo.FormaPagamento;
import br.com.alura.debug.debugStore.modelo.Produto;

public class CompraPessoaFisica {
	
	public static void main(String[] args) {
		Categoria informatica = new Categoria("Informatica");
		List<Produto> produtos = criarProdutos(informatica);
		CarrinhoCompra carrinho = new CarrinhoCompra(FormaPagamento.BOLETO);
		BigDecimal valorFinalDaCompra = carrinho.calcularPrecoFinal(produtos);
		System.out.println("Valor da compra: " + valorFinalDaCompra);
	}

	

	private static List<Produto> criarProdutos(Categoria categoria) {
		List<Produto> produtos = new ArrayList<Produto>();
		Produto mouse = new Produto("Mouse sem fio Microsoft",new BigDecimal(("120")), categoria);
		produtos.add(mouse);
		Produto teclado = new Produto("Teclado de Gamer Alien", new BigDecimal("350"), categoria);
		produtos.add(teclado);
		Produto monitor = new Produto("Monitor Lg 17 Widescreen", new BigDecimal("250"), categoria);
		produtos.add(monitor);
		Produto processador = new Produto("Processador Intel Core I7", new BigDecimal("1500"), categoria);
		produtos.add(processador);
		Produto cadeira = new Produto("Cadeira Racing Gamer", new BigDecimal("759"), categoria);
		produtos.add(cadeira);
		return produtos;
	}
	
}
