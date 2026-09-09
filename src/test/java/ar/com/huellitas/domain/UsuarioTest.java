package ar.com.huellitas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.com.huellitas.enums.EspecieMascota;

public class UsuarioTest {

@Test
	public void crearUsuarioExitosamente() {
	Usuario usuario = new Usuario("Franco", "Guerra", "fran@gmail.com", "115551222");
	
	assertEquals("Franco", usuario.getNombre());
	assertEquals("Guerra", usuario.getApellido());
	assertEquals("fran@gmail.com", usuario.getMail());
	assertEquals("115551222", usuario.getTelefono());

}

@Test
	public void crearUsuarioConNombreNulo() {
	IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()-> new Usuario(null, "Guerra", "fran@gmail.com", "115551222"));
	assertEquals(Usuario.ERR_NOMBRE_INVALIDO,ex.getMessage());
}
	
@Test
	public void crearUsuarioConNombreMuyCorto() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()-> new Usuario(" 1", "Guerra", "fran@gmail.com", "115551222"));
		assertEquals(Usuario.ERR_NOMBRE_INVALIDO,ex.getMessage());
}
@Test
public void crearUsuarioConNombreMuyLargo() {
	  String nombre = "a".repeat(100);
	IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()-> new Usuario(nombre, "Guerra", "fran@gmail.com", "115551222"));
	assertEquals(Usuario.ERR_NOMBRE_INVALIDO,ex.getMessage());
}
@Test
public void crearUsuarioConNombreVacio() {
	IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()-> new Usuario("", "Guerra", "fran@gmail.com", "115551222"));
	assertEquals(Usuario.ERR_NOMBRE_INVALIDO,ex.getMessage());
}

@Test
	public void crearUsuarioConMailSinArroba() {
	IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()-> new Usuario("Franco", "Guerra", "frangmail.com", "115551222"));
	assertEquals(Usuario.ERR_MAIL_INVALIDO,ex.getMessage());
}
@Test
	public void crearUsuarioConMailSinPuntoCom() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()-> new Usuario("Franco", "Guerra", "fran@gmail", "115551222"));
		assertEquals(Usuario.ERR_MAIL_INVALIDO,ex.getMessage());
}

@Test
	public void crearUsuarioConMailNulo() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()-> new Usuario("Franco", "Guerra", null, "115551222"));
		assertEquals(Usuario.ERR_MAIL_INVALIDO,ex.getMessage());
}
@Test
	public void crearUsuarioConMailVacio() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()-> new Usuario("Franco", "Guerra", "", "115551222"));
		assertEquals(Usuario.ERR_MAIL_INVALIDO,ex.getMessage());
}

@Test
	public void crearUsuarioConApellidoNulo() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()-> new Usuario("Franco", null, "fran@gmail.com", "115551222"));
		assertEquals(Usuario.ERR_APELLIDO_INVALIDO,ex.getMessage());
}
@Test
	public void crearUsuarioConApellidoVacio() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()-> new Usuario("Franco", "", "fran@gmail.com", "115551222"));
		assertEquals(Usuario.ERR_APELLIDO_INVALIDO,ex.getMessage());
}
@Test
	public void crearUsuarioConApellidoMuyLargo() {
	 String apellido = "a".repeat(100);
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()-> new Usuario("Franco", apellido, "fran@gmail.com", "115551222"));
		assertEquals(Usuario.ERR_APELLIDO_INVALIDO,ex.getMessage());
}
@Test
	public void crearUsuarioConApellidoMuyCorto() {
		
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()-> new Usuario("Franco", "Lo", "fran@gmail.com", "115551222"));
		assertEquals(Usuario.ERR_APELLIDO_INVALIDO,ex.getMessage());
}
@Test
	public void crearUsuarioConTelefonoNulo() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()-> new Usuario("Franco", "Guerra", "fran@gmail.com", null));
		assertEquals(Usuario.ERR_TELEFONO_INVALIDO,ex.getMessage());
}
@Test
	public void crearUsuarioConTelefonoVacio() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()-> new Usuario("Franco", "Guerra", "fran@gmail.com", ""));
		assertEquals(Usuario.ERR_TELEFONO_INVALIDO,ex.getMessage());
}
@Test
	public void crearUsuarioConTelefonoMuyCorto() {
	IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()-> new Usuario("Franco", "Guerra", "fran@gmail.com", "1"));
	assertEquals(Usuario.ERR_TELEFONO_INVALIDO,ex.getMessage());
}
@Test
	public void crearUsuarioConTelefonoMuyLargo() {
		String telefono = "b".repeat(100);
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()-> new Usuario("Franco", "Guerra", "fran@gmail.com", telefono));
		assertEquals(Usuario.ERR_TELEFONO_INVALIDO,ex.getMessage());
}
@Test
	public void agregarPublicacionExitosamente() {

    	Usuario usuario = new Usuario(
    			"Franco",
    			"Guerra",
    			"fran@gmail.com",
    			"115551222"
    			);

    	Mascota mascota = new Mascota(
    			EspecieMascota.PERRO,
    			"Marrón"
    			);

    	Publicacion publicacion =
    			new Publicacion(usuario, mascota);

    	usuario.agregarPublicacion(publicacion);

    	assertEquals(1, usuario.getPublicaciones().size());
    	assertEquals(publicacion, usuario.getPublicaciones().get(0));
    	assertEquals(usuario, publicacion.getPublicadoPor());
}
@Test
	public void agregarPublicacionNula() {

    	Usuario usuario = new Usuario(
    			"Franco",
    			"Guerra",
    			"fran@gmail.com",
    			"115551222"
    			);

    	IllegalArgumentException ex = assertThrows(
    			IllegalArgumentException.class,
    			() -> usuario.agregarPublicacion(null)
    			);

    	assertEquals(
    			Usuario.ERR_PUBLICACION_NULL,
    			ex.getMessage()
    			);
}
@Test
	void agregarPublicacionDeOtroUsuarioDebeFallar() {

    	Usuario usuario = new Usuario(
    			"Franco",
    			"Guerra",
    			"fran@gmail.com",
    			"115551222"
    			);

    	Usuario otroUsuario = new Usuario(
    			"Juan",
    			"Perez",
    			"juan@gmail.com",
    			"116661333"
    			);

    	Mascota mascota = new Mascota(
    			EspecieMascota.PERRO,
    			"Marrón"
    			);

    	Publicacion publicacion = new Publicacion(
    			otroUsuario,
    			mascota
    			);

    	IllegalArgumentException ex = assertThrows(
    			IllegalArgumentException.class,
    			() -> usuario.agregarPublicacion(publicacion)
    			);

    	assertEquals(
    			Usuario.ERR_PUBLICACION_USUARIO_INCORRECTO,
    			ex.getMessage()
    );

    assertTrue(usuario.getPublicaciones().isEmpty());
}
@Test
	public void eliminarPublicacionExitosamente() {

    	Usuario usuario = new Usuario(
    			"Franco",
            	"Guerra",
            	"fran@gmail.com",
            	"115551222"
    			);

    	Mascota mascota = new Mascota(
    			EspecieMascota.PERRO,
    			"Marrón"
    			);

    	Publicacion publicacion =
            new Publicacion(usuario, mascota);

    	usuario.agregarPublicacion(publicacion);
    	usuario.eliminarPublicacion(publicacion);

    	assertTrue(usuario.getPublicaciones().isEmpty());
}
@Test
	public void eliminarPublicacionInexistente() {

    	Usuario usuario = new Usuario(
    			"Franco",
    			"Guerra",
    			"fran@gmail.com",
    			"115551222"
    			);

    Mascota mascota = new Mascota(
            	EspecieMascota.PERRO,
            	"Marrón"
    );

    Publicacion publicacion =
            new Publicacion(usuario, mascota);

    IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> usuario.eliminarPublicacion(publicacion)
    );

    assertEquals(
            Usuario.ERR_PUBLICACION_INEXISTENTE,
            ex.getMessage()
    );
}
}
