package ar.com.huellitas.domain;

import ar.com.huellitas.enums.EspecieMascota;
import ar.com.huellitas.enums.GeneroMascota;
import ar.com.huellitas.helpers.ValidationUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MASCOTAS")
public class Mascota {
	final static String ERR_NOMBRE_INVALIDO = "Debe ingresar un nombre válido";
	final static String ERR_COLOR_INVALIDO = "Debe ingresar un color válido";
	
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "ESPECIE",nullable = false)
	@Enumerated(EnumType.STRING)
	private EspecieMascota especie;
	@Column(name = "GENERO")
	@Enumerated(EnumType.STRING)
	private GeneroMascota genero;
	@Column(name = "COLOR", nullable = false)
	private String color;
	@Column(name = "RAZA")
	private String raza;
	@Column(name = "CASTRADO")
	private boolean castrado;
	
	protected Mascota(){};
	public Mascota(EspecieMascota especie, String color) {
		setEspecie(especie);
		setColor(color);
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(!ValidationUtils.nombreValido(nombre)) {
			throw new IllegalArgumentException(ERR_NOMBRE_INVALIDO);
		}
		this.nombre = nombre;
	}

	public void setEspecie(EspecieMascota especie) {
		this.especie = especie;
	}
	public GeneroMascota getGenero() {
		return genero;
	}
	public void setGenero(GeneroMascota genero) {
		this.genero = genero;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		if(!ValidationUtils.stringValido(color)) {
			throw new IllegalArgumentException(ERR_COLOR_INVALIDO);
		}
		this.color = color;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public boolean isCastrado() {
		return castrado;
	}
	public void setCastrado(boolean castrado) {
		this.castrado = castrado;
	}
	public Long getId() {
		return id;
	}

}
