package ar.com.huellitas.domain;

import java.util.ArrayList;

import ar.com.huellitas.helpers.ValidationUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "IMAGENES")
public class Imagen {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "TIPO_CONTENIDO")
	private String tipoContenido;
	@Column(name = "CONTENIDO")
	private byte[] contenido;
	
	Imagen(){};
	public Imagen(String nombre, String tipo, byte[] contenido) {
		setNombre(nombre);
		setTipoContenido(tipo);
		setContenido(contenido);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(!ValidationUtils.nombreValido(nombre)) {
			throw new IllegalArgumentException("Debe ingresar un nombre válido");
		}
		this.nombre = nombre;
	}
	public String getTipoContenido() {
		return tipoContenido;
	}
	public void setTipoContenido(String tipoContenido) {
		if(!ValidationUtils.tipoImagenValido(tipoContenido)) {
			throw new IllegalArgumentException("Debe ingresar un tipo de imagen válido");
		}
		this.tipoContenido = tipoContenido;
	}
	public byte[] getContenido() {
		return contenido;
	}
	public void setContenido(byte[] contenido) {
		if(!ValidationUtils.contenidoImagenValido(contenido)) {
			throw new IllegalArgumentException("Debe ingresar un contenido de imagen válido");
		}
		this.contenido = contenido;
	}
	public Long getId() {
		return id;
	}
	

}
