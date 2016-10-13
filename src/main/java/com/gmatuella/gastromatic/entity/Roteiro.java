package com.gmatuella.gastromatic.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Roteiro implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SEQ = "roteiro_seq";

	@Id
	@SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = SEQ)
	private Long id;
	@Column(length = 100, nullable = false)
	private String nome;
	@Column(length = 500)
	private String detalhes;
	@ManyToMany(mappedBy = "roteiros", cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	private List<Curso> cursos;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	private List<Aula> aulas;

	public void addCurso(Curso curso) {
		if (Objects.isNull(this.cursos)) {
			this.cursos = new ArrayList<>();
		}
		this.cursos.add(curso);
	}

	public void addAula(Aula aula) {
		if (Objects.isNull(this.aulas)) {
			this.aulas = new ArrayList<>();
		}
		this.aulas.add(aula);
		aula.addRoteiro(this);
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

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aulas == null) ? 0 : aulas.hashCode());
		result = prime * result + ((cursos == null) ? 0 : cursos.hashCode());
		result = prime * result + ((detalhes == null) ? 0 : detalhes.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Roteiro other = (Roteiro) obj;
		if (aulas == null) {
			if (other.aulas != null)
				return false;
		} else if (!aulas.equals(other.aulas))
			return false;
		if (cursos == null) {
			if (other.cursos != null)
				return false;
		} else if (!cursos.equals(other.cursos))
			return false;
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
		return true;
	}

}
