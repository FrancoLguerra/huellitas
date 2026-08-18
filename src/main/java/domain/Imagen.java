package domain;

import java.util.ArrayList;

public class Imagen {
	String nombre;
	String tipoContenido;
	byte[] contenido;
	
	
	public Imagen(String nombre, String tipo, byte[] contenido) {
		this.nombre = nombre;
		this.tipoContenido = tipo;
		this.contenido = contenido;
	}

}
