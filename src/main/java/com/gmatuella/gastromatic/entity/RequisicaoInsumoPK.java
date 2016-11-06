package com.gmatuella.gastromatic.entity;

import java.io.Serializable;

public class RequisicaoInsumoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long requisicao;
	private Long insumo;
	private Long solicitacao;

	public Long getRequisicao() {
		return requisicao;
	}

	public Long getInsumo() {
		return insumo;
	}

	public Long getSolicitacao() {
		return solicitacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((insumo == null) ? 0 : insumo.hashCode());
		result = prime * result + ((requisicao == null) ? 0 : requisicao.hashCode());
		result = prime * result + ((solicitacao == null) ? 0 : solicitacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequisicaoInsumoPK other = (RequisicaoInsumoPK) obj;
		if (insumo == null) {
			if (other.insumo != null)
				return false;
		} else if (!insumo.equals(other.insumo))
			return false;
		if (requisicao == null) {
			if (other.requisicao != null)
				return false;
		} else if (!requisicao.equals(other.requisicao))
			return false;
		if (solicitacao == null) {
			if (other.solicitacao != null)
				return false;
		} else if (!solicitacao.equals(other.solicitacao))
			return false;
		return true;
	}

}
