package ar.com.huellitas.domain;

import java.util.List;

import ar.com.huellitas.helpers.ValidationUtils;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "USUARIOS")
public class Usuario {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "APELLIDO")
	private String apellido;
	@Column(name = "MAIL")
	private String mail;
	@Column(name = "TELEFONO")
	private String telefono;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Publicacion> publicaciones;
	
	public Usuario(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}
	Usuario(){}
	public Usuario( String nombre, String apellido, String mail, String telefono ) {
		this.nombre = nombre ;
		this.apellido = apellido;
		this.mail = mail;
		this.telefono = telefono;
		
	}
	public void setNombre(String nombre) {
		if(!ValidationUtils.nombreValido(nombre)) {
			throw new IllegalArgumentException("Debe ingresar un nombre válido");
		}
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}
	public String getApellido() {
		return apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public String getMail() {
		return mail;
	}
	public String getTelefono() {
		return telefono;
	}
	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}
	public Long getId() {
		return id;
	}


}

