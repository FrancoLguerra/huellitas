package domain;

import java.util.Random;

public class Mascota {
	
	private Long id;
	private String nombre;
	private String especie;
	private String genero;
	private String color;
	private String raza;
	private boolean castrado;
	
	
	public Mascota(String especie, String color) {
		id = new Random().nextLong();
		this.especie = especie;
		this.color = color;
		
	}

}
