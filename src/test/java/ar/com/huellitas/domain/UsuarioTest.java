package ar.com.huellitas.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class UsuarioTest {

    @Test
    void nombreValidoNoDebeLanzarExcepcion() {
        
        Usuario usuario = new Usuario();

        assertDoesNotThrow(() -> usuario.setNombre("Franco"));
    }

    @Test
    void nombreVacioDebeLanzarExcepcion() {
        
        Usuario usuario = new Usuario();

        assertThrows(
            IllegalArgumentException.class,
            () -> usuario.setNombre("")
        );
    }

    @Test
    void nombreConEspaciosDebeLanzarExcepcion() {
        
        Usuario usuario = new Usuario();

        assertThrows(
            IllegalArgumentException.class,
            () -> usuario.setNombre("   ")
        );
    }

    @Test
    void nombreNullDebeLanzarExcepcion() {
        
        Usuario usuario = new Usuario();

        assertThrows(
            IllegalArgumentException.class,
            () -> usuario.setNombre(null)
        );
    }
}
