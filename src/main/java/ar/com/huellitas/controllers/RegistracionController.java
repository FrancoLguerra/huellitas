package ar.com.huellitas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.com.huellitas.forms.RegistracionForm;
import ar.com.huellitas.services.UsuarioService;

@Controller
public class RegistracionController {
	
	private final UsuarioService usuarioService;
	
	public static final String REGISTRACION_URL = "/registracion";
	public static final String REGISTRO_URL = "/registro";
	
	 public RegistracionController(UsuarioService usuarioService) {
	        this.usuarioService = usuarioService;
	    }
	 
	@GetMapping(value = REGISTRACION_URL)
	public String init(Model model) {
		model.addAttribute("form",new RegistracionForm());
		return "usuario-form";
	}
	
	@PostMapping(value = REGISTRO_URL)
	public String registracion(@ModelAttribute("form") RegistracionForm form) {
		usuarioService.guardar(form);
		return "home";
	}
}
