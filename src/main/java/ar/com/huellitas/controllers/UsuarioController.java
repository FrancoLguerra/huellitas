package ar.com.huellitas.controllers;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	  
	  @GetMapping("/usuarios/{id}/editar")
	  public String editar(@PathVariable("id") Long id, Model model) {
		  	Usuario usuario = usuarioService.buscarPorId(id);
		  	model.addAttribute("usuario",usuario);
		  	return "usuario-editar";
	  }
	  @PostMapping("/usuarios/{id}")
	  public String actualizar(
	          @PathVariable("id") Long id,
	          @ModelAttribute Usuario usuario) {

	      usuarioService.actualizar(id, usuario);

	      return "redirect:/usuarios";
	  }
	  @GetMapping("/usuarios/{id}/eliminar")
	  public String eliminar(@PathVariable("id") Long id) {
		  	usuarioService.eliminar(id);
		  	 return "redirect:/usuarios";
	  }
	  
}
