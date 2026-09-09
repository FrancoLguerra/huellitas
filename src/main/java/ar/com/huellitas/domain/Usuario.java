package ar.com.huellitas.domain;

import java.util.ArrayList;
import java.util.List;

import ar.com.huellitas.helpers.ValidationUtils;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "USUARIOS")
public class Usuario {
	final static String ERR_NOMBRE_INVALIDO = "Debe ingresar un nombre válido";
	final static String ERR_MAIL_INVALIDO = "Debe ingresar un mail válido";
	final static String ERR_APELLIDO_INVALIDO = "Debe ingresar un apellido válido";
	final static String ERR_TELEFONO_INVALIDO = "Debe ingresar un telefono válido";
	final static String ERR_PUBLICACION_NULL = "La publicación no puede ser nula";
	final static String ERR_PUBLICACION_INEXISTENTE = "La publicación que desea eliminar no existe";
	static final String ERR_PUBLICACION_USUARIO_INCORRECTO = "La publicación no pertenece a este usuario";
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
	@OneToMany(mappedBy = "publicadoPor",cascade = CascadeType.ALL, orphanRemoval = true)
	
	private List<Publicacion> publicaciones = new ArrayList<>();
	

	protected Usuario(){}
	public Usuario( String nombre, String apellido, String mail, String telefono ) {
		setNombre(nombre);
		setApellido(apellido);
		setMail(mail);
		setTelefono(telefono);
		
	}
	public void setNombre(String nombre) {
		if(!ValidationUtils.nombreValido(nombre)) {
			throw new IllegalArgumentException(ERR_NOMBRE_INVALIDO);
		}
		this.nombre = nombre;
	}
	
	public void setApellido(String apellido) {
		if(!ValidationUtils.apellidoValido(apellido)) {
			throw new IllegalArgumentException(ERR_APELLIDO_INVALIDO);
		}
		this.apellido = apellido;
	}
	
	public void setMail(String mail) {
		if(!ValidationUtils.mailValido(mail)) {
			throw new IllegalArgumentException(ERR_MAIL_INVALIDO);
		}
		this.mail = mail;
	}
	
	public void setTelefono(String telefono) {
		if(!ValidationUtils.telefonoValido(telefono)) {
			throw new IllegalArgumentException(ERR_TELEFONO_INVALIDO);
		}
		this.telefono = telefono;
	}
	
	public void agregarPublicacion(Publicacion publicacion) {
		 if (publicacion == null) {
		        throw new IllegalArgumentException(ERR_PUBLICACION_NULL);
		    }
		 if (publicacion.getPublicadoPor() != this) {
		        throw new IllegalArgumentException(ERR_PUBLICACION_USUARIO_INCORRECTO);
		    }
		 publicaciones.add(publicacion);
	}
	
	public void eliminarPublicacion(Publicacion publicacion) {
		if(!publicaciones.contains(publicacion)) {
			throw new IllegalArgumentException(ERR_PUBLICACION_INEXISTENTE);
		}

		publicaciones.remove(publicacion);
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

