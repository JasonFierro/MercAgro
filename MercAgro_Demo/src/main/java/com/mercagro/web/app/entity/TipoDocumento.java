package com.mercagro.web.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class TipoDocumento {
	
	private static final long serialVersionUID = 1671417246199538663L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private int id_tipodocumento;
	
	@Column
	private String descripcion;

	public int getId_tipodocumento() {
		return id_tipodocumento;
	}

	public void setId_tipodocumento(int id_tipodocumento) {
		this.id_tipodocumento = id_tipodocumento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + id_tipodocumento;
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
		TipoDocumento other = (TipoDocumento) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id_tipodocumento != other.id_tipodocumento)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoDocumento [id_tipodocumento=" + id_tipodocumento + ", descripcion=" + descripcion + "]";
	}

	
}
