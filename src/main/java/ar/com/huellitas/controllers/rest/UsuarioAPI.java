package ar.com.huellitas.controllers.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.huellitas.domain.Usuario;
import ar.com.huellitas.dtos.UsuarioDTO;
import ar.com.huellitas.forms.RegistracionForm;
import ar.com.huellitas.services.UsuarioService;
import ar.com.huellitas.validators.LoginFormValidator;

@RestController
public class UsuarioAPI {
	private static final String LIST_USER_URL = "/api/usuarios";
	private static final String SAVE_USER_URL = "/api/usuarios/registracion";
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private LoginFormValidator validator;
	
	@GetMapping(value = LIST_USER_URL,
				produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UsuarioDTO>> list() {
		List<UsuarioDTO> usuarios = this.usuarioService.exponer();
		
		return ResponseEntity.ok(usuarios);
	}
	
	@PostMapping(value = SAVE_USER_URL,
				 produces = MediaType.APPLICATION_JSON_VALUE,
				 consumes = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<String> registrar(@RequestBody RegistracionForm form){
		ResponseEntity respuesta = null;
		
		Errors errors = this.validator.validateObject(form);
		if(errors.hasErrors()) {
			respuesta = ResponseEntity.badRequest().body("No se puede registrar el usuario");
		}else {
			this.usuarioService.guardar(form);
			respuesta = ResponseEntity.status(HttpStatus.CREATED).build();
		}
		
	
		return respuesta;
	}

}
