package br.com.wmw.cleancode.nomenclaturas;

public class Circulo {
	private final Double PI = 3.14;
	
	public Double CalcularCircunferencia(final Double raioCircunferencia) {
		return (PI * raioCircunferencia * raioCircunferencia);
	}

}
