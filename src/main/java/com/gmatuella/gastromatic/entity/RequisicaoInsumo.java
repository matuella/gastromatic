package com.gmatuella.gastromatic.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.gmatuella.gastromatic.entity.RequisicaoInsumo.RequisicaoInsumoPK;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

@Entity
@Table(name = "requisicao_insumo")
@IdClass(RequisicaoInsumoPK.class)
@XmlRootElement
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class RequisicaoInsumo {

	@Id
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE })
	private Requisicao requisicao;

	@Id
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE })
	private Insumo insumo;

	@Id
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE })
	private Solicitacao solicitacao;

	@Column(nullable = false)
	private Double qtd;
	@Column(length = 500)
	private String observacao;

	public Requisicao getRequisicao() {
		return requisicao;
	}

	public void setRequisicao(Requisicao requisicao) {
		this.requisicao = requisicao;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public Double getQtd() {
		return qtd;
	}

	public void setQtd(Double qtd) {
		this.qtd = qtd;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public static class RequisicaoInsumoPK implements Serializable {

		private static final long serialVersionUID = 1L;

		private Requisicao requisicao;
		private Insumo insumo;
		private Solicitacao solicitacao;

		public Requisicao getRequisicao() {
			return requisicao;
		}

		public void setRequisicao(Requisicao requisicao) {
			this.requisicao = requisicao;
		}

		public Insumo getInsumo() {
			return insumo;
		}

		public void setInsumo(Insumo insumo) {
			this.insumo = insumo;
		}

		public Solicitacao getSolicitacao() {
			return solicitacao;
		}

		public void setSolicitacao(Solicitacao solicitacao) {
			this.solicitacao = solicitacao;
		}

	}

}
