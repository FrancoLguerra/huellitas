package ar.com.huellitas.forms;

import ar.com.huellitas.enums.EspecieMascota;
import ar.com.huellitas.enums.GeneroMascota;

public class PublicacionForm {

    private String nombreMascota;
    private EspecieMascota especie;
    private GeneroMascota genero;
    private String color;
    private String raza;
    private boolean castrado;

    private String textoAdicional;
    private String ubicacion;


    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
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

    public String getTextoAdicional() {
        return textoAdicional;
    }

    public void setTextoAdicional(String textoAdicional) {
        this.textoAdicional = textoAdicional;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
