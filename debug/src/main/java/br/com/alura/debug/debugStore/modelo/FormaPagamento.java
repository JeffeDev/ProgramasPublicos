package br.com.alura.debug.debugStore.modelo;

public enum FormaPagamento {
	
	BOLETO(9.00), CARTAO_DEBITO(5.0), CARTAO_CREDITO(1.5);
	
	private final double porcentagemDesconto;
	
	FormaPagamento(double porcentagemDesconto) {
		this.porcentagemDesconto = porcentagemDesconto;
	}
	
	public double getPorcentagemDesconto(){
		return porcentagemDesconto;
	}

}
