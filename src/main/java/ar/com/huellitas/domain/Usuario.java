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
	@Column(name = "MAIL", unique = true)
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
		setNombre(nombre);
		setApellido(apellido);
		setMail(mail);
		setTelefono(telefono);
		
	}
	public void setNombre(String nombre) {
		if(!ValidationUtils.nombreValido(nombre)) {
			throw new IllegalArgumentException("Debe ingresar un nombre válido");
		}
		this.nombre = nombre;
	}
	
	public void setApellido(String apellido) {
		if(!ValidationUtils.apellidoValido(apellido)) {
			throw new IllegalArgumentException("Debe ingresar un apellido válido");
		}
		this.apellido = apellido;
	}
	
	public void setMail(String mail) {
		if(!ValidationUtils.mailValido(mail)) {
			throw new IllegalArgumentException("Debe ingresar un mail válido");
		}
		this.mail = mail;
	}
	
	public void setTelefono(String telefono) {
		if(!ValidationUtils.telefonoValido(telefono)) {
			throw new IllegalArgumentException("Debe ingresar un telefono válido");
		}
		this.telefono = telefono;
	}
	
	public void agregarPublicacion(Publicacion publicacion) {
		 if (publicacion == null) {
		        throw new IllegalArgumentException("La publicación no puede ser nula");
		    }
		 publicaciones.add(publicacion);
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

