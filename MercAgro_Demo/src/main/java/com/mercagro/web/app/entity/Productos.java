package com.mercagro.web.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Productos {
	
	private static final long serialVersionUID = -6833167247955613395L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id_articulo;
	
	@Column
	private Long id_estado;
	
	@Column 
	@NotEmpty(message = "Ingrese el nombre")
	private String nombre;
	
	@Column 
	@NotEmpty(message = "Ingrese la descripción")
	private String descripcion;
	
	@Column
	@NotEmpty(message = "Ingrese el costo")
	private String costo;
	
	
	@Column
	@NotEmpty(message = "Ingrese la cantidad")
	@Email
	private String cantidad;


	public Long getId_articulo() {
		return id_articulo;
	}


	public void setId_articulo(Long id_articulo) {
		this.id_articulo = id_articulo;
	}


	public Long getId_estado() {
		return id_estado;
	}


	public void setId_estado(Long id_estado) {
		this.id_estado = id_estado;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getCosto() {
		return costo;
	}


	public void setCosto(String costo) {
		this.costo = costo;
	}


	public String getCantidad() {
		return cantidad;
	}


	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}


	@Override
	public String toString() {
		return "Productos [id_articulo=" + id_articulo + ", id_estado=" + id_estado + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", costo=" + costo + ", cantidad=" + cantidad + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
		result = prime * result + ((costo == null) ? 0 : costo.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((id_articulo == null) ? 0 : id_articulo.hashCode());
		result = prime * result + ((id_estado == null) ? 0 : id_estado.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Productos other = (Productos) obj;
		if (cantidad == null) {
			if (other.cantidad != null)
				return false;
		} else if (!cantidad.equals(other.cantidad))
			return false;
		if (costo == null) {
			if (other.costo != null)
				return false;
		} else if (!costo.equals(other.costo))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id_articulo == null) {
			if (other.id_articulo != null)
				return false;
		} else if (!id_articulo.equals(other.id_articulo))
			return false;
		if (id_estado == null) {
			if (other.id_estado != null)
				return false;
		} else if (!id_estado.equals(other.id_estado))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	

}
