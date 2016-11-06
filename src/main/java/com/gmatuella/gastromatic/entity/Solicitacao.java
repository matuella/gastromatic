package com.gmatuella.gastromatic.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

@Entity
@Table
@XmlRootElement
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class Solicitacao implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SEQ = "solicitacao_seq";

	@Id
	@SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = SEQ)
	private Long id;
	@Lob
	@Column(name = "IMG_NOTA")
	private byte[] imgNota;
	private Boolean recebida = false;
	@OneToMany(mappedBy = "solicitacao", cascade = { CascadeType.REFRESH, CascadeType.MERGE })
	private List<RequisicaoInsumo> requisicoesInsumo;
	private Double valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getImgNota() {
		return imgNota;
	}

	public void setImgNota(byte[] imgNota) {
		this.imgNota = imgNota;
	}

	public Boolean getRecebida() {
		return recebida;
	}

	public void setRecebida(Boolean recebida) {
		this.recebida = recebida;
	}

	public List<RequisicaoInsumo> getRequisicoesInsumo() {
		return requisicoesInsumo;
	}

	public void setRequisicoesInsumo(List<RequisicaoInsumo> requisicoesInsumo) {
		this.requisicoesInsumo = requisicoesInsumo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(imgNota);
		result = prime * result + ((recebida == null) ? 0 : recebida.hashCode());
		result = prime * result + ((requisicoesInsumo == null) ? 0 : requisicoesInsumo.hashCode());
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
		Solicitacao other = (Solicitacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (!Arrays.equals(imgNota, other.imgNota))
			return false;
		if (recebida == null) {
			if (other.recebida != null)
				return false;
		} else if (!recebida.equals(other.recebida))
			return false;
		if (requisicoesInsumo == null) {
			if (other.requisicoesInsumo != null)
				return false;
		} else if (!requisicoesInsumo.equals(other.requisicoesInsumo))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

}
