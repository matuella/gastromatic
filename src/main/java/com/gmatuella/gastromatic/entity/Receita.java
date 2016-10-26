package com.gmatuella.gastromatic.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

/**
 * @author Guilherme Matuella
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "nome" }) })
@XmlRootElement
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class Receita implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SEQ = "receita_seq";

	@Id
	@SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = SEQ)
	private Long id;
	@Column(length = 100, nullable = false)
	private String nome;
	@Column(name = "modo_preparo", length = 2000)
	private String modoPreparo;
	@Column(length = 1000)
	private String observacao;
	@ManyToMany(mappedBy = "receitas", cascade = { CascadeType.REFRESH, CascadeType.MERGE })
	private List<Aula> aulas;
	@OneToMany(mappedBy = "receita", cascade = { CascadeType.ALL })
	private List<ReceitaInsumo> receitaInsumo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModoPreparo() {
		return modoPreparo;
	}

	public void setModoPreparo(String modoPreparo) {
		this.modoPreparo = modoPreparo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public List<ReceitaInsumo> getReceitaInsumo() {
		return receitaInsumo;
	}

	public void setReceitaInsumo(List<ReceitaInsumo> receitaInsumo) {
		this.receitaInsumo = receitaInsumo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aulas == null) ? 0 : aulas.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modoPreparo == null) ? 0 : modoPreparo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((receitaInsumo == null) ? 0 : receitaInsumo.hashCode());
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
		Receita other = (Receita) obj;
		if (aulas == null) {
			if (other.aulas != null)
				return false;
		} else if (!aulas.equals(other.aulas))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modoPreparo == null) {
			if (other.modoPreparo != null)
				return false;
		} else if (!modoPreparo.equals(other.modoPreparo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (receitaInsumo == null) {
			if (other.receitaInsumo != null)
				return false;
		} else if (!receitaInsumo.equals(other.receitaInsumo))
			return false;
		return true;
	}

}
