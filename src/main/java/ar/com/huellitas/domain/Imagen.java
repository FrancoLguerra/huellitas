package ar.com.huellitas.domain;

import java.util.ArrayList;

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
		this.nombre = nombre;
		this.tipoContenido = tipo;
		this.contenido = contenido;
	}

}
