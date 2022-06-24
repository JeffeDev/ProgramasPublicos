package br.com.alura.debug.debugStore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
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

		Cliente regina = new Cliente("Regina Duarte", 50);
		Cliente Yudi = new Cliente("Yudi Tamashiro", 24);
		List<Cliente> clientes = Arrays.asList(regina, Yudi);
		for (Cliente cliente : clientes) {
			System.out.println("O cliente " + cliente.getNome() + " tem " + cliente.getIdade() + " anos");

		}

	}

	private static List<Produto> criarProdutos(Categoria categoria) {
		List<Produto> produtos = new ArrayList<Produto>();
		Produto mouse = new Produto("Mouse sem fio Microsoft", new BigDecimal(("120")), categoria);
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
