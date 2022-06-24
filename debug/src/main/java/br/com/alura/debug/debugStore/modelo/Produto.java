package br.com.alura.debug.debugStore.modelo;

import java.math.BigDecimal;

public class Produto {
	
	private String descricao;
	
	private BigDecimal preco;
	
	private Categoria categoria;
	
	private Integer quantidade;
	
	public Produto(String descricao, BigDecimal preco, Categoria categoria) {
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}
	
	public Produto(String descricao, BigDecimal preco, Categoria categoria, Integer quantidade) {
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}
	
	

	
}
