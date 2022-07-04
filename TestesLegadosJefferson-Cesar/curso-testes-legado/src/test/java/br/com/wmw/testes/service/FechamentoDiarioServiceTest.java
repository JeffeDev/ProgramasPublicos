package br.com.wmw.testes.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.wmw.test.method.MethodTestUtils;
import br.com.wmw.testes.Messages;
import br.com.wmw.testes.ValidationException;

class FechamentoDiarioServiceTest {
	final FechamentoDiarioService fechamentoDiarioService = new FechamentoDiarioService();
	
	@Test
	void naoDevePermitirKilometrageminicialIgualaZero() {
		final ValidationException validationException = assertThrows(ValidationException.class, () -> {
			MethodTestUtils.invokePrivateMethod(fechamentoDiarioService, "validateKilometragemVeiculo", 0, 1);
		});
		assertEquals(Messages.FECHAMENTO_DIARIO_MSG_ERRO_INICIAL_MAIOR_ZERO, validationException.getMessage());
	}

	@Test
	void naoDevePermitirKilometragemFinalIgualaZero() {
		final ValidationException validationException = assertThrows(ValidationException.class, () -> {
			MethodTestUtils.invokePrivateMethod(fechamentoDiarioService, "validateKilometragemVeiculo", 1, 0);
		});
		assertEquals(Messages.FECHAMENTO_DIARIO_MSG_ERRO_FINAL_MAIOR_ZERO, validationException.getMessage());
	}

	@Test
	void naoDevePermitirKilometragemInicialMenorqueZero() {
		final ValidationException validationException = assertThrows(ValidationException.class, () -> {
			MethodTestUtils.invokePrivateMethod(fechamentoDiarioService, "validateKilometragemVeiculo", -1, 1);
		});
		assertEquals(Messages.FECHAMENTO_DIARIO_MSG_ERRO_INICIAL_NEGATIVO, validationException.getMessage());
	}

	@Test
	void naoDevePermitirKilometragemFinalMenorqueZero() {
		final ValidationException validationException = assertThrows(ValidationException.class, () -> {
			MethodTestUtils.invokePrivateMethod(fechamentoDiarioService, "validateKilometragemVeiculo", 1, -1);
		});
		assertEquals(Messages.FECHAMENTO_DIARIO_MSG_ERRO_FINAL_NEGATIVO, validationException.getMessage());
	}

	@Test
	void naoDevePermitirKilometragemFinalMenorQueInicial() {
		final ValidationException validationException = assertThrows(ValidationException.class, () -> {
			MethodTestUtils.invokePrivateMethod(fechamentoDiarioService, "validateKilometragemVeiculo", 2, 1);
		});
		assertEquals(Messages.FECHAMENTO_DIARIO_MSG_ERRO_INICIAL_MAIOR_FINAL, validationException.getMessage());
	}

	@Test
	void naoDevePermitirKilometragemInicialIgualaFinal() {
		final ValidationException validationException = assertThrows(ValidationException.class, () -> {
			MethodTestUtils.invokePrivateMethod(fechamentoDiarioService, "validateKilometragemVeiculo", 2, 2);
		});
		assertEquals(Messages.FECHAMENTO_DIARIO_MSG_ERRO_INICIAL_IGUAL_FINAL, validationException.getMessage());
	}

	@Test
	void devePermitirKilometragemFinalMaiorQueInicial() {
		final FechamentoDiarioService fechamentoDiarioService = new FechamentoDiarioService();
		assertDoesNotThrow( () -> {
			MethodTestUtils.invokePrivateMethod(fechamentoDiarioService, "validateKilometragemVeiculo", 1, 2);
		});
	}
}
