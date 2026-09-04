package ar.com.huellitas.domain;

import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MASCOTAS")
public class Mascota {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "ESPECIE")
	private String especie;
	@Column(name = "GENERO")
	private String genero;
	@Column(name = "COLOR")
	private String color;
	@Column(name = "RAZA")
	private String raza;
	@Column(name = "CASTRADO")
	private boolean castrado;
	
	Mascota(){};
	public Mascota(String especie, String color) {
		id = new Random().nextLong();
		this.especie = especie;
		this.color = color;
		
	}

}
