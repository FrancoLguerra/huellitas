package ar.com.huellitas.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import ar.com.huellitas.enums.TipoDeImagen;

public class ImagenTest {
	@Test
	public void crearImagenExitosamente() {
		byte[] img = obtenerImagenDePerfil();
		Imagen imagen = new Imagen("img.png", TipoDeImagen.JPG, img);
		assertNotNull(imagen.getNombre());
		
	}

	private byte[] obtenerImagenDePerfil() {
		InputStream stream = getClass().getClassLoader().getResourceAsStream("imagenes/perfilPrueba.jpg");
		byte[] contenido = null;
		try {
			contenido = stream.readAllBytes();
		} catch (IOException e) {
			fail("La imagen no pudo ser recibida exitosamente");
		}
		return contenido;
	}

}
