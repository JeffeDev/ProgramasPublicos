package br.com.wmw.testes;

public class Messages {

	public static final String FECHAMENTO_DIARIO_MSG_PEDIDOS_ABERTOS_E_NAO_TRANSMITIDOS = "Não foi possível finalizar o dia pois existe(m) pedido(s) abertos e pedidos não transmitido(s) no sistema.";
	public static final String FECHAMENTO_DIARIO_MSG_PEDIDO_ABERTO = "Não foi possível finalizar o dia pois existe(m) pedido(s) em aberto no sistema.";
	public static final String FECHAMENTO_DIARIO_MSG_PEDIDO_NAO_TRANSMITIDO = "Não foi possível finalizar o dia pois existe(m) pedido(s) não transmitido(s) no sistema.";
	public static final String FECHAMENTO_DIARIO_MSG_SEM_DATA_FECHAMENTO = "Informe a data do fechamento diario.";

	public static final String FECHAMENTO_DIARIO_MSG_ERRO_INICIAL_MAIOR_ZERO = "A Kilometragem Inicial do veículo deve ser maior que zero.";
	public static final String FECHAMENTO_DIARIO_MSG_ERRO_FINAL_MAIOR_ZERO = "A kilometragem Final do veículo deve ser maior que zero.";
	public static final String FECHAMENTO_DIARIO_MSG_ERRO_INICIAL_NEGATIVO = "A Kilometragem Inicial do veículo deve ser maior que zero.";
	public static final String FECHAMENTO_DIARIO_MSG_ERRO_FINAL_NEGATIVO = "A Kilometragem final do veículo deve ser maior que zero.";
	public static final String FECHAMENTO_DIARIO_MSG_ERRO_INICIAL_MAIOR_FINAL = "A Kilometragem final do veículo deve ser maior que a inicial.";
	public static final String FECHAMENTO_DIARIO_MSG_ERRO_INICIAL_IGUAL_FINAL = "A Kilometragem final do veículo deve ser maior que a inicial.";

	public static final String DEVE_PERMITIR_DESCONTO_VINTE_PARA_QTDE_MAIOR100 = "Deve permitir desconto de 20% quando quantidade for maior que 100";
	public static final String DEVE_PERMITIR_DESCONTO_DEZ_PARA_QTDE_ENTRE50E99 = "Deve permitir desconto de 10% quando quantidade for entre 50 e 99";
	public static final String DEVE_PERMITIR_DESCONTO_CINCO_PARA_QTDE_ENTRE10E49 = "Deve permitir desconto de 5% quando quantidade for entre 10 e 49";
	public static final String NAO_DEVE_PERMITIR_DESCONTO_PARA_QTDE_MENOR10 = "Não deve permitir desconto de 5% quando quantidade for menor que 10";
	
	public static final String DEVE_PERMITIR_DESCONTO_VINTEPORCENTO_ESTOQUE_MAIORIGUALMIL = "Deve permitir desconto de 20% quando o estoque é maior ou igual a Mil Unidades.";
	public static final String DEVE_PERMITIR_DESCONTO_DEZPORCENTO_ESTOQUE_MAIORIGUAL500 = "Deve permitir desconto de 10% quando o estoque é maior ou igual a 500 Unidades.";
	public static final String DEVE_PERMITIR_DESCONTO_CINCOPORCENTO_ESTOQUEENTRE100E500 = "Deve permitir desconto de 5% quando o estoque maior ouigual 100 e menor que 500.";
	public static final String NAODEVE_PERMITIR_DESCONTO_PARA_ESTOQUEENTRE_MENOR_100 = "Não deve permitir desconto de 5% quando o estoque menor que 100";
}
