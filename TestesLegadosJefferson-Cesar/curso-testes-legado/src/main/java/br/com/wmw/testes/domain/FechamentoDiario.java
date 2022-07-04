package br.com.wmw.testes.domain;

import java.util.Date;
import java.util.Objects;

public class FechamentoDiario {

	private String cdEmpresa;
	private String cdRepresentante;
	private Date dtFechamento;
	private double vlTotalPedidos;
	private double vlTotalDesconto;
	private String dsPlacaVeiculo;
	private double kmInicialVeiculo;
	private double kmFinalVeiculo;

	public String getCdEmpresa() {
		return this.cdEmpresa;
	}

	public void setCdEmpresa(final String cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public String getCdRepresentante() {
		return this.cdRepresentante;
	}

	public void setCdRepresentante(final String cdRepresentante) {
		this.cdRepresentante = cdRepresentante;
	}

	public Date getDtFechamento() {
		return this.dtFechamento;
	}

	public void setDtFechamento(final Date dtFechamento) {
		this.dtFechamento = dtFechamento;
	}

	public double getVlTotalPedidos() {
		return this.vlTotalPedidos;
	}

	public void setVlTotalPedidos(final double vlTotalPedidos) {
		this.vlTotalPedidos = vlTotalPedidos;
	}

	public double getVlTotalDesconto() {
		return this.vlTotalDesconto;
	}

	public void setVlTotalDesconto(final double vlTotalDesconto) {
		this.vlTotalDesconto = vlTotalDesconto;
	}

	public String getDsPlacaVeiculo() {
		return this.dsPlacaVeiculo;
	}

	public void setDsPlacaVeiculo(final String dsPlacaVeiculo) {
		this.dsPlacaVeiculo = dsPlacaVeiculo;
	}

	public double getKmInicialVeiculo() {
		return this.kmInicialVeiculo;
	}

	public void setKmInicialVeiculo(final double kmInicialVeiculo) {
		this.kmInicialVeiculo = kmInicialVeiculo;
	}

	public double getKmFinalVeiculo() {
		return this.kmFinalVeiculo;
	}

	public void setKmFinalVeiculo(final double kmFinalVeiculo) {
		this.kmFinalVeiculo = kmFinalVeiculo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.cdEmpresa, this.cdRepresentante, this.dtFechamento);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final FechamentoDiario other = (FechamentoDiario) obj;
		if (!Objects.equals(this.cdEmpresa, other.cdEmpresa)) {
			return false;
		}
		if (!Objects.equals(this.cdRepresentante, other.cdRepresentante)) {
			return false;
		}
		if (!Objects.equals(this.dtFechamento, other.dtFechamento)) {
			return false;
		}
		return true;
	}

}
