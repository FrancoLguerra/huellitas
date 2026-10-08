package ar.com.huellitas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ar.com.huellitas.forms.RegistracionForm;
import ar.com.huellitas.services.UsuarioServiceImpl;
import ar.com.huellitas.validators.RegistracionFormValidator;

@Controller
public class RegistracionController {
	public static final String REGISTRACION_URL = "/registracion";
	public static final String REGISTRO_URL = "/registro";
	public static final String REGISTRACION_VIEW = "usuario-form";
	
	@Autowired
	private  UsuarioServiceImpl usuarioService;
	
	@Autowired
	private RegistracionFormValidator validator;

	

	
	
	
	@InitBinder(value="form")
	void initFormValidator(WebDataBinder binder) {
		binder.addValidators(this.validator);
	};
	
	 public RegistracionController(UsuarioServiceImpl usuarioService) {
	        this.usuarioService = usuarioService;
		        
	    }
	 
	@GetMapping(value = REGISTRACION_URL)
	public String init(Model model) {
		model.addAttribute("form",new RegistracionForm());
		return REGISTRACION_VIEW;
	}
	
	@PostMapping(value = REGISTRO_URL)
	public String registracion(@Validated @ModelAttribute("form") RegistracionForm form, BindingResult results) {
		if(results.hasErrors()) return REGISTRACION_VIEW;	
		usuarioService.guardar(form);
		return "redirect:/usuarios";
	}
}
