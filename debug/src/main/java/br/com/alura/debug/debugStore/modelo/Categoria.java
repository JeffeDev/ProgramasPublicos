package br.com.alura.debug.debugStore.modelo;

public class Categoria {
	
	private String descricao;
	
	private Double porcentagemDesconto;
	
	public Categoria(String descricao) {
		this.descricao = descricao;
	}
	
	public Categoria(String descricao, Double porcentagemDesconto) {
		this.descricao = descricao;
		this.porcentagemDesconto = porcentagemDesconto;
	}


}
