package ar.com.huellitas.controllers;

import java.security.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.com.huellitas.forms.LoginForm;
import ar.com.huellitas.services.UsuarioService;
import ar.com.huellitas.validators.LoginFormValidator;
import exceptions.MultipleUsersFoundException;
import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
@Controller
public class LoginController {

	public static final String SIGN_IN_URL = "/signIn";
	public static final String LOGIN_URL = "/login";
	@Autowired
	private  LoginFormValidator validator;

	
	@InitBinder(value="form")
	void initFormValidator(WebDataBinder binder) {
		binder.addValidators(this.validator);
	};
	
	@Autowired 
	private UsuarioService servicio;
	@GetMapping(value = SIGN_IN_URL)
	public String init(Model model) {
		model.addAttribute("form", new LoginForm());
		return "signIn";
	}
	
	@PostMapping(value = LOGIN_URL)
	public String login(HttpSession session,@Validated @ModelAttribute("form") LoginForm formulario, BindingResult resultados) {
		if(resultados.hasErrors()) return "signIn"; 
		this.servicio.login(formulario.getMail());
		SecurityContext context = SecurityContextHolder.getContext();
		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, context);
		return "redirect:/";
	}
}
