package ar.com.huellitas.controllers;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import ar.com.huellitas.domain.Usuario;
import ar.com.huellitas.services.UsuarioServiceImpl;

@Controller
public class UsuarioController {
	private final UsuarioServiceImpl usuarioService;
	
	  public UsuarioController(UsuarioServiceImpl usuarioService) {
	        this.usuarioService = usuarioService;
	    }

		/*
		 * @PostMapping("/usuarios") public void crear(@RequestBody Usuario usuario) {
		 * Usuario usuarioCreado = usuarioService.guardar(usuario);
		 * System.out.println("Usuario creado: " + usuarioCreado.getId() + " "
		 * +usuarioCreado.getNombre()); }
		 */
	  
	  @GetMapping("/usuarios")
	  public String mostrarTodos(Model model){
		  List<Usuario> usuarios = usuarioService.listar();
		  model.addAttribute("usuarios", usuarios);

	        return "usuarios";
	  }
	  
}
