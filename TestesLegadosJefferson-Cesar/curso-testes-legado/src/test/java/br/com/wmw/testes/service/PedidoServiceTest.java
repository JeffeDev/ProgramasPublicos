package br.com.wmw.testes.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import br.com.wmw.test.method.MethodTestUtils;
import br.com.wmw.testes.Messages;
import br.com.wmw.testes.ValidationException;

class PedidoServiceTest {
	final double VINTE_POR_CENTO_DESCONTO = 20.0;
	final double DEZ_POR_CENTO_DESCONTO = 10.0;
	final double CINCO_POR_CENTO_DESCONTO = 5.0;
	final int SEM_DESCONTO =0;
	
	final long ESTOQUE_MAIOR_MIL = 1001;
	final long ESTOQUE_IGUAL_MIL = 1000;
	final long ESTOQUE_MAIOR_QUINHENTOS = 501;
	final long ESTOQUE_IGUAL_QUINHENTOS = 500;
	final long ESTOQUE_MAIOR_CEM = 101;
	final long ESTOQUE_IGUAL_CEM = 100;
	final long ESTOQUE_MENOR_CEM = 99;
	
	final long QUANTIDADE_MAIOR_CEM = 101;
	final long QUANTIDADE_IGUAL_CEM = 100;
	final long QUANTIDADE_MAIOR_CINQUENTA = 51;
	final long QUANTIDADE_IGUAL_CINQUENTA = 50;
	final long QUANTIDADE_MAIOR_DEZ = 11;
	final long QUANTIDADE_IGUAL_DEZ = 10;
	final long QUANTIDADE_MENOR_DEZ = 9;

	@Test
	void devePermitirDescontoDe20ParaEstoqueMaiorMilUnidades() {
		final PedidoService pedidoService = new PedidoService();
		
		final ValidationException validationException = assertThrows(ValidationException.class, ()  -> {
			MethodTestUtils.invokePrivateMethod(pedidoService, "validaCalculoDoDescontoEstoque", ESTOQUE_MAIOR_MIL, VINTE_POR_CENTO_DESCONTO);
		});
		assertEquals(Messages.DEVE_PERMITIR_DESCONTO_VINTEPORCENTO_ESTOQUE_MAIORIGUALMIL,
				validationException.getMessage());
	}
	@Test
	void devePermitirDescontoDe20ParaEstoqueIgualMil() {
		final PedidoService pedidoService = new PedidoService();

		final ValidationException validationException = assertThrows(ValidationException.class, () -> {
			MethodTestUtils.invokePrivateMethod(pedidoService, "validaCalculoDoDescontoEstoque", ESTOQUE_IGUAL_MIL, VINTE_POR_CENTO_DESCONTO);
		});
		assertEquals(Messages.DEVE_PERMITIR_DESCONTO_VINTEPORCENTO_ESTOQUE_MAIORIGUALMIL,
				validationException.getMessage());
	}
	@Test
	void devePermitirDescontoDe10ParaEstoqueMaiorQuinhentasUnidades() {
		final PedidoService pedidoService = new PedidoService();

		final ValidationException validationException = assertThrows(ValidationException.class, () -> {
			MethodTestUtils.invokePrivateMethod(pedidoService, "validaCalculoDoDescontoEstoque", ESTOQUE_MAIOR_QUINHENTOS, DEZ_POR_CENTO_DESCONTO);
		});
		assertEquals(Messages.DEVE_PERMITIR_DESCONTO_DEZPORCENTO_ESTOQUE_MAIORIGUAL500,
				validationException.getMessage());
	}
	@Test
	void devePermitirDescontoDe10ParaEstoqueIgualQuinhentasUnidades() {
		final PedidoService pedidoService = new PedidoService();

		final ValidationException validationException = assertThrows(ValidationException.class, () -> {
			MethodTestUtils.invokePrivateMethod(pedidoService, "validaCalculoDoDescontoEstoque", ESTOQUE_IGUAL_QUINHENTOS, DEZ_POR_CENTO_DESCONTO);
		});
		assertEquals(Messages.DEVE_PERMITIR_DESCONTO_DEZPORCENTO_ESTOQUE_MAIORIGUAL500,
				validationException.getMessage());
	}

	@Test
	void naoDevePermitirDescontoAlgumParaEstoqueMenorQueCemUnidades() {
		final PedidoService pedidoService = new PedidoService();

		final ValidationException validationException = assertThrows(ValidationException.class, () -> {
			MethodTestUtils.invokePrivateMethod(pedidoService, "validaCalculoDoDescontoEstoque", ESTOQUE_MENOR_CEM, SEM_DESCONTO);
		});
		assertEquals(Messages.NAODEVE_PERMITIR_DESCONTO_PARA_ESTOQUEENTRE_MENOR_100, validationException.getMessage());
	}
	
	@Test
	void devePermitirDescontoParaQuantidadeMaior100() {
		final PedidoService pedidoService = new PedidoService();

		final ValidationException validationException = assertThrows(ValidationException.class, () -> {
			MethodTestUtils.invokePrivateMethod(pedidoService, "validaCalculoDoDescontoQuantidade", QUANTIDADE_MAIOR_CEM, VINTE_POR_CENTO_DESCONTO);
		});
		assertEquals(Messages.DEVE_PERMITIR_DESCONTO_VINTE_PARA_QTDE_MAIOR100, validationException.getMessage());
	}	
	@Test
	void devePermitirDescontoParaQuantidadeIgualCemUnidades() {
		final PedidoService pedidoService = new PedidoService();

		final ValidationException validationException = assertThrows(ValidationException.class, () -> {
			MethodTestUtils.invokePrivateMethod(pedidoService, "validaCalculoDoDescontoQuantidade", QUANTIDADE_IGUAL_CEM, VINTE_POR_CENTO_DESCONTO);
		});
		assertEquals(Messages.DEVE_PERMITIR_DESCONTO_VINTE_PARA_QTDE_MAIOR100, validationException.getMessage());
	}
	@Test
	void devePermitirDescontoParaQuantidadeMaior50() {
		final PedidoService pedidoService = new PedidoService();

		final ValidationException validationException = assertThrows(ValidationException.class, () -> {
			MethodTestUtils.invokePrivateMethod(pedidoService, "validaCalculoDoDescontoQuantidade", QUANTIDADE_MAIOR_CINQUENTA, DEZ_POR_CENTO_DESCONTO);
		});
		assertEquals(Messages.DEVE_PERMITIR_DESCONTO_DEZ_PARA_QTDE_ENTRE50E99, validationException.getMessage());
	}	
	@Test
	void devePermitirDescontoParaQuantidadeIgualCinquentaUnidades() {
		final PedidoService pedidoService = new PedidoService();

		final ValidationException validationException = assertThrows(ValidationException.class, () -> {
			MethodTestUtils.invokePrivateMethod(pedidoService, "validaCalculoDoDescontoQuantidade", QUANTIDADE_IGUAL_CINQUENTA, DEZ_POR_CENTO_DESCONTO);
		});
		assertEquals(Messages.DEVE_PERMITIR_DESCONTO_DEZ_PARA_QTDE_ENTRE50E99, validationException.getMessage());
	}
	@Test
	void devePermitirDescontoParaQuantidadeMaiorDezUnidades() {
		final PedidoService pedidoService = new PedidoService();

		final ValidationException validationException = assertThrows(ValidationException.class, () -> {
			MethodTestUtils.invokePrivateMethod(pedidoService, "validaCalculoDoDescontoQuantidade", QUANTIDADE_MAIOR_DEZ, CINCO_POR_CENTO_DESCONTO);
		});
		assertEquals(Messages.DEVE_PERMITIR_DESCONTO_CINCO_PARA_QTDE_ENTRE10E49, validationException.getMessage());
	}	
	@Test
	void devePermitirDescontoParaQuantidadeIgualDezUnidades() {
		final PedidoService pedidoService = new PedidoService();

		final ValidationException validationException = assertThrows(ValidationException.class, () -> {
			MethodTestUtils.invokePrivateMethod(pedidoService, "validaCalculoDoDescontoQuantidade", QUANTIDADE_IGUAL_DEZ, CINCO_POR_CENTO_DESCONTO);
		});
		assertEquals(Messages.DEVE_PERMITIR_DESCONTO_CINCO_PARA_QTDE_ENTRE10E49, validationException.getMessage());
	}
	@Test
	void naoDevePermitirDescontoAlgumParaQuantidadeMenorQueDez() {
		final PedidoService pedidoService = new PedidoService();

		final ValidationException validationException = assertThrows(ValidationException.class, () -> {
			MethodTestUtils.invokePrivateMethod(pedidoService, "validaCalculoDoDescontoQuantidade", QUANTIDADE_MENOR_DEZ, SEM_DESCONTO);
		});
		assertEquals(Messages.NAO_DEVE_PERMITIR_DESCONTO_PARA_QTDE_MENOR10, validationException.getMessage());
	}
	
	@Test
	void deveConcederVintePorCentoDescontoQuandoEstoqueMaiorMil() {
		final PedidoService pedidoService = new PedidoService();
		final double desconto = MethodTestUtils.invokePrivateMethod(pedidoService, "calculaPercentualDescontoEstoque", ESTOQUE_MAIOR_MIL);
		assertEquals(20.0, desconto);
	}
	@Test
	void deveConcederVintePorCentoDescontoQuandoEstoqueMaiorQuinhentos() {
		final PedidoService pedidoService = new PedidoService();
		final double desconto = MethodTestUtils.invokePrivateMethod(pedidoService, "calculaPercentualDescontoEstoque", ESTOQUE_MAIOR_QUINHENTOS);
		assertEquals(10.0, desconto);
	}
	@Test
	void deveConcederVintePorCentoDescontoQuandoEstoqueMaiorCem() {
		final PedidoService pedidoService = new PedidoService();
		final double desconto = MethodTestUtils.invokePrivateMethod(pedidoService, "calculaPercentualDescontoEstoque", ESTOQUE_MAIOR_CEM);
		assertEquals(5.0, desconto);
	}
	
	@Test
	void deveConcederDescontoPorQuantidadeMaiorCem() {
		final PedidoService pedidoService = new PedidoService();
		final double desconto = MethodTestUtils.invokePrivateMethod(pedidoService, "calculaPercentualDescontoQuantidade", QUANTIDADE_MAIOR_CEM, VINTE_POR_CENTO_DESCONTO);
		assertEquals(20.0, desconto);
	}
	@Test
	void deveConcederDescontoPorQuantidadeMaiorCinquenta() {
		final PedidoService pedidoService = new PedidoService();
		final double desconto = MethodTestUtils.invokePrivateMethod(pedidoService, "calculaPercentualDescontoQuantidade", QUANTIDADE_MAIOR_CINQUENTA, DEZ_POR_CENTO_DESCONTO);
		assertEquals(10.0, desconto);
	}
	@Test
	void deveConcederDescontoPorQuantidadeMaiorDez() {
		final PedidoService pedidoService = new PedidoService();
		final double desconto = MethodTestUtils.invokePrivateMethod(pedidoService, "calculaPercentualDescontoQuantidade", QUANTIDADE_MAIOR_DEZ, CINCO_POR_CENTO_DESCONTO);
		assertEquals(5.0, desconto);
	}
	@Test
	void deveConcederDescontoPorQuantidadeMenorDez() {
		final PedidoService pedidoService = new PedidoService();
		final double desconto = MethodTestUtils.invokePrivateMethod(pedidoService, "calculaPercentualDescontoQuantidade", QUANTIDADE_MENOR_DEZ, SEM_DESCONTO );
		assertEquals(0.0, desconto);
	}
	
	@ParameterizedTest
	@CsvSource({"1001, 20",
				"1000, 20",
				"501, 10",
				"500, 10",
				"101, 5",
				"100, 5",
				"99,  0"
	})
	void deveConcederDescontoConformeARespectivaFaixa(final long quantidade, final double descontoesperado) {
		final PedidoService pedidoService = PedidoService.getInstance();
		final double descontoCalculado = MethodTestUtils.invokePrivateMethod(pedidoService, "calculaPercentualDescontoEstoque", quantidade, descontoesperado);
		assertEquals(descontoesperado, descontoCalculado);
	}
	
}
