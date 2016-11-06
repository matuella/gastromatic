package com.gmatuella.gastromatic.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Guilherme Matuella
 */
@Entity
@Table
@XmlRootElement
public class Requisicao implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SEQ = "requisicao_seq";

	@Id
	@SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = SEQ)
	private Long id;
	@Column(name = "DATA_REQUISICAO", nullable = false)
	private LocalDateTime dataRequisicao;
	@Column(length = 100)
	private String nota;
	@Column(length = 50)
	private String tipo;
	private Double valor;
	@OneToMany(mappedBy = "requisicao", cascade = { CascadeType.REFRESH, CascadeType.MERGE })
	private List<RequisicaoInsumo> requisicoesInsumo;

	private String usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataRequisicao() {
		return dataRequisicao;
	}

	public void setDataRequisicao(LocalDateTime dataRequisicao) {
		this.dataRequisicao = dataRequisicao;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public List<RequisicaoInsumo> getRequisicoesInsumo() {
		return requisicoesInsumo;
	}

	public void setRequisicoesInsumo(List<RequisicaoInsumo> requisicoesInsumo) {
		this.requisicoesInsumo = requisicoesInsumo;
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
		result = prime * result + ((dataRequisicao == null) ? 0 : dataRequisicao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nota == null) ? 0 : nota.hashCode());
		result = prime * result + ((requisicoesInsumo == null) ? 0 : requisicoesInsumo.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		Requisicao other = (Requisicao) obj;
		if (dataRequisicao == null) {
			if (other.dataRequisicao != null)
				return false;
		} else if (!dataRequisicao.equals(other.dataRequisicao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nota == null) {
			if (other.nota != null)
				return false;
		} else if (!nota.equals(other.nota))
			return false;
		if (requisicoesInsumo == null) {
			if (other.requisicoesInsumo != null)
				return false;
		} else if (!requisicoesInsumo.equals(other.requisicoesInsumo))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

}
