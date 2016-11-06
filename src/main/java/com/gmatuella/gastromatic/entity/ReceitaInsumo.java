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
import com.gmatuella.gastromatic.entity.ReceitaInsumo.ReceitaInsumoPK;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

@Entity
@Table(name = "receita_insumo")
@IdClass(ReceitaInsumoPK.class)
@XmlRootElement
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class ReceitaInsumo {

	@Column(nullable = false, name = "qtd_insumo")
	private Double qtdInsumo;

	@Id
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE })
	private Receita receita;

	@Id
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE })
	private Insumo insumo;

	public Double getQtdInsumo() {
		return qtdInsumo;
	}

	public void setQtdInsumo(Double qtdInsumo) {
		this.qtdInsumo = qtdInsumo;
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

	public static class ReceitaInsumoPK implements Serializable {

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

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((insumo == null) ? 0 : insumo.hashCode());
			result = prime * result + ((receita == null) ? 0 : receita.hashCode());
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
			ReceitaInsumoPK other = (ReceitaInsumoPK) obj;
			if (insumo == null) {
				if (other.insumo != null)
					return false;
			} else if (!insumo.equals(other.insumo))
				return false;
			if (receita == null) {
				if (other.receita != null)
					return false;
			} else if (!receita.equals(other.receita))
				return false;
			return true;
		}

	}
}
