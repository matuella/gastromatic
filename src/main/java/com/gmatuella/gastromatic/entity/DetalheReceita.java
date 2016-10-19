package com.gmatuella.gastromatic.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.gmatuella.gastromatic.entity.DetalheReceita.PK;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

@Entity
@Table(name = "detalhe_receita")
@IdClass(PK.class)
@XmlRootElement
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class DetalheReceita {

	@Column(nullable = false, name = "quantidade_insumo")
	private Integer quantidadeInsumo;

	@Id
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE })
	private Receita receita;

	@Id
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE })
	private Insumo insumo;

	public Integer getQuantidadeInsumo() {
		return quantidadeInsumo;
	}

	public void setQuantidadeInsumo(Integer quantidadeInsumo) {
		this.quantidadeInsumo = quantidadeInsumo;
	}

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public static class PK implements Serializable {

		private static final long serialVersionUID = 1L;

		private Receita receita;
		private Insumo insumo;

		public Receita getReceita() {
			return receita;
		}

		public void setReceita(Receita receita) {
			this.receita = receita;
		}

		public Insumo getInsumo() {
			return insumo;
		}

		public void setInsumo(Insumo insumo) {
			this.insumo = insumo;
		}

	}
}
