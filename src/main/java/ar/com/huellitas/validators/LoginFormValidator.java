package ar.com.huellitas.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ar.com.huellitas.domain.Usuario;
import ar.com.huellitas.forms.LoginForm;
import ar.com.huellitas.services.UsuarioService;
import exceptions.MultipleUsersFoundException;

@Component
public class LoginFormValidator implements Validator {

	@Autowired
	private UsuarioService usuarioService;
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return LoginForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LoginForm form = (LoginForm) target;
		if(form.getMail() == null || form.getMail().isBlank() ) {
			errors.rejectValue("mail", "mail.empty");
		}else {
			try {
				Usuario usuario = this.usuarioService.obtenerPorMail(form.getMail());
						if(usuario == null) errors.rejectValue("mail", "mail.not.exists");
			}catch(MultipleUsersFoundException e) {
				errors.rejectValue("mail", "mail.multiple.found");
			}
		}
		
	}

}
