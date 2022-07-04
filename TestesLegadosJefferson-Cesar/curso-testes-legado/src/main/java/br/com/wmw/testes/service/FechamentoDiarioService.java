package br.com.wmw.testes.service;

import java.util.Date;

import br.com.wmw.testes.AppConfig;
import br.com.wmw.testes.Messages;
import br.com.wmw.testes.ValidationException;
import br.com.wmw.testes.domain.FechamentoDiario;

public class FechamentoDiarioService {

	private void validaDataFechamentoDiario(final Date dtFechamento) {
		if (dtFechamento == null) {
			throw new ValidationException(Messages.FECHAMENTO_DIARIO_MSG_SEM_DATA_FECHAMENTO);
		}
	}
	
	private void validateKilometragemVeiculo(final double kmInicialVeiculo, double kmFinalVeiculo) {
		if (kmInicialVeiculo == 0) {
			throw new ValidationException(Messages.FECHAMENTO_DIARIO_MSG_ERRO_INICIAL_MAIOR_ZERO);
		}
		if (kmFinalVeiculo == 0) {
			throw new ValidationException(Messages.FECHAMENTO_DIARIO_MSG_ERRO_FINAL_MAIOR_ZERO);
		}
		if (kmInicialVeiculo < 0) {
			throw new ValidationException(Messages.FECHAMENTO_DIARIO_MSG_ERRO_INICIAL_NEGATIVO);
		}
		if (kmFinalVeiculo < 0) {
			throw new ValidationException(Messages.FECHAMENTO_DIARIO_MSG_ERRO_FINAL_NEGATIVO);
		}
		if (kmInicialVeiculo > kmFinalVeiculo) {
			throw new ValidationException(Messages.FECHAMENTO_DIARIO_MSG_ERRO_INICIAL_MAIOR_FINAL);
		}
		if (kmInicialVeiculo == kmFinalVeiculo) {
			throw new ValidationException(Messages.FECHAMENTO_DIARIO_MSG_ERRO_INICIAL_IGUAL_FINAL);
		}
	}

	public void validate(final FechamentoDiario fechamentoDiario) {
		validaDataFechamentoDiario(fechamentoDiario.getDtFechamento());

		validateKilometragemVeiculo(fechamentoDiario.getKmInicialVeiculo(), fechamentoDiario.getKmFinalVeiculo());
		
		final int countAbertos = PedidoService.getInstance().countPedidosEmAberto();
		final int countNaoTransmitidos = AppConfig.isBloqueiaFechamentoDiarioPedidosNaoTransmitidos() ? PedidoService.getInstance().countPedidosNaoTransmitidosFechamentoDiario() : 0;
		if ((countAbertos > 0) && (countNaoTransmitidos > 0)) {
			throw new ValidationException(Messages.FECHAMENTO_DIARIO_MSG_PEDIDOS_ABERTOS_E_NAO_TRANSMITIDOS);
		} else if (countAbertos > 0) {
			throw new ValidationException(Messages.FECHAMENTO_DIARIO_MSG_PEDIDO_ABERTO);
		} else if (countNaoTransmitidos > 0) {
			throw new ValidationException(Messages.FECHAMENTO_DIARIO_MSG_PEDIDO_NAO_TRANSMITIDO);
		}
	}

}
