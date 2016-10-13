package com.gmatuella.gastromatic.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Guilherme Matuella
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "nome" }) })
@XmlRootElement
public class Aula implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SEQ = "aula_seq";

	@Id
	@SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = SEQ)
	private Long id;
	@Column(length = 100, nullable = false)
	private String nome;
	@Column(length = 500)
	private String detalhes;
	@ManyToMany(mappedBy = "aulas", cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	private List<Roteiro> roteiros;
	
	// Temp Columns
//	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@ElementCollection
	@CollectionTable(name = "receita")
	private List<String> receitas;
	private String usuario;

	public void addRoteiro(Roteiro roteiro) {
		if (Objects.isNull(this.roteiros)) {
			this.roteiros = new ArrayList<>();
		}
		this.roteiros.add(roteiro);
	}
	
	public void addReceita(String receita) {
		if (Objects.isNull(this.receitas)) {
			this.receitas = new ArrayList<>();
		}
		this.receitas.add(receita);
	}

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

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public List<String> getReceita() {
		return receitas;
	}

	public void setReceita(List<String> receita) {
		this.receitas = receita;
	}

	public List<Roteiro> getRoteiros() {
		return roteiros;
	}

	public void setRoteiros(List<Roteiro> roteiros) {
		this.roteiros = roteiros;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((detalhes == null) ? 0 : detalhes.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((receitas == null) ? 0 : receitas.hashCode());
		result = prime * result + ((roteiros == null) ? 0 : roteiros.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Aula other = (Aula) obj;
		if (detalhes == null) {
			if (other.detalhes != null)
				return false;
		} else if (!detalhes.equals(other.detalhes))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (receitas == null) {
			if (other.receitas != null)
				return false;
		} else if (!receitas.equals(other.receitas))
			return false;
		if (roteiros == null) {
			if (other.roteiros != null)
				return false;
		} else if (!roteiros.equals(other.roteiros))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
