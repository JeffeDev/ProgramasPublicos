package br.com.wmw.testes;

public class AppConfig {

	public static boolean isBloqueiaFechamentoDiarioPedidosNaoTransmitidos() {
		return false;
	}

	public static boolean isUsaDescontoPorQuantidade() {
		return true;
	}

	public static boolean isUsaDescontoPorEstoque() {
		return true;
	}

}
