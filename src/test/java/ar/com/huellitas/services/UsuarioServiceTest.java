package ar.com.huellitas.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ar.com.huellitas.domain.Usuario;
import ar.com.huellitas.repositories.UsuarioRepository;

@SpringBootTest
@ActiveProfiles(value="test")
public class UsuarioServiceTest {
	@Autowired
	private UsuarioService usuarioService;
	 @Autowired
	private UsuarioRepository usuarioRepository;
	
	 //@Test
		/*
		 * void guardarUsuarioValido() {
		 * 
		 * // Arrange Usuario usuario = new Usuario( "Franco", "Guerra",
		 * "franco@test.com", "123456789" ); // Act Usuario usuarioGuardado =
		 * usuarioService.guardar(usuario);
		 * 
		 * // Assert assertNotNull(usuarioGuardado);
		 * assertNotNull(usuarioGuardado.getId());
		 * 
		 * Usuario usuarioEncontrado = usuarioRepository
		 * .findById(usuarioGuardado.getId()) .orElse(null);
		 * 
		 * assertNotNull(usuarioEncontrado); assertEquals("Franco",
		 * usuarioEncontrado.getNombre()); assertEquals("Guerra",
		 * usuarioEncontrado.getApellido()); assertEquals("franco@test.com",
		 * usuarioEncontrado.getMail()); assertEquals("123456789",
		 * usuarioEncontrado.getTelefono()); }
		 */

}
