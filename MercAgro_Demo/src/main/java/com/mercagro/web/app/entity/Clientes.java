package com.mercagro.web.app.entity;

import java.util.Set;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Clientes {
	
	private static final long serialVersionUID = -6833167247955613395L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@Column
	private Long id_ciudad;
	
	@Column
	private Long id_tipoDocumento;
	
	@Column
	private Long id_estado;
	
	@Column 
	@NotEmpty(message = "Ingrese el nombre")
	private String nombre;
	
	@Column 
	@NotEmpty(message = "Ingrese el Apellido")
	private String apellido;
	
	@Column
	@NotEmpty(message = "Ingrese el documento")
	private String documento;
	
	
	@Column
	@NotEmpty(message = "Ingrese el correo")
	@Email
	private String correo;
	
	@Column
	@NotEmpty(message = "Ingrese el celular")
	private String celular;
	
	@Column
	@NotEmpty(message = "Ingrese el telefono")
	private String telefono;
	
	@Column
	@NotEmpty(message = "Ingrese la dirección")
	private String direccion;
	
	@Column()
	@NotEmpty(message = "Ingrese el usuario")
	@Size(min = 5, max = 15)
	private String usuario;
	
	@Column
	@NotEmpty(message = "Ingrese la contraseña")
	private String contrasena;
	
	@Transient 
	private String confirmContrasena;
	
	@Column
	private boolean enabled;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="user_roles"
		,joinColumns=@JoinColumn(name="user_id")
		,inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles;
	
	public Clientes() {
		super();
	}
	
	
	public Clientes(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_ciudad() {
		return id_ciudad;
	}

	public void setId_ciudad(Long id_ciudad) {
		this.id_ciudad = id_ciudad;
	}

	public Long getId_tipoDocumento() {
		return id_tipoDocumento;
	}

	public void setId_tipoDocumento(Long id_tipoDocumento) {
		this.id_tipoDocumento = id_tipoDocumento;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getConfirmContrasena() {
		return confirmContrasena;
	}

	public void setConfirmContrasena(String confirmContrasena) {
		this.confirmContrasena = confirmContrasena;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	@Override
	public String toString() {
		return "Clientes [id=" + id + ", id_ciudad=" + id_ciudad + ", id_tipoDocumento=" + id_tipoDocumento
				+ ", id_estado=" + id_estado + ", nombre=" + nombre + ", apellido=" + apellido + ", documento="
				+ documento + ", correo=" + correo + ", celular=" + celular + ", telefono=" + telefono + ", direccion="
				+ direccion + ", usuario=" + usuario + ", contrasena=" + contrasena + ", confirmContrasena="
				+ confirmContrasena + ", enabled=" + enabled + ", roles=" + roles + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((confirmContrasena == null) ? 0 : confirmContrasena.hashCode());
		result = prime * result + ((contrasena == null) ? 0 : contrasena.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_ciudad == null) ? 0 : id_ciudad.hashCode());
		result = prime * result + ((id_estado == null) ? 0 : id_estado.hashCode());
		result = prime * result + ((id_tipoDocumento == null) ? 0 : id_tipoDocumento.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
		Clientes other = (Clientes) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (confirmContrasena == null) {
			if (other.confirmContrasena != null)
				return false;
		} else if (!confirmContrasena.equals(other.confirmContrasena))
			return false;
		if (contrasena == null) {
			if (other.contrasena != null)
				return false;
		} else if (!contrasena.equals(other.contrasena))
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (enabled != other.enabled)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_ciudad == null) {
			if (other.id_ciudad != null)
				return false;
		} else if (!id_ciudad.equals(other.id_ciudad))
			return false;
		if (id_estado == null) {
			if (other.id_estado != null)
				return false;
		} else if (!id_estado.equals(other.id_estado))
			return false;
		if (id_tipoDocumento == null) {
			if (other.id_tipoDocumento != null)
				return false;
		} else if (!id_tipoDocumento.equals(other.id_tipoDocumento))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
