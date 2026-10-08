package ar.com.huellitas.forms;

import ar.com.huellitas.enums.EspecieMascota;
import ar.com.huellitas.enums.GeneroMascota;

public class MascotaForm {
	 private String nombre;
	    private EspecieMascota especie;
	    private GeneroMascota genero;
	    private String color;
	    private String raza;
	    private boolean castrado;

	    public MascotaForm() {
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public EspecieMascota getEspecie() {
	        return especie;
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
	}

