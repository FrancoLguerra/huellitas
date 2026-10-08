package ar.com.huellitas.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

import ar.com.huellitas.domain.Usuario;
import ar.com.huellitas.forms.RegistracionForm;
import ar.com.huellitas.helpers.ValidationUtils;
import ar.com.huellitas.services.UsuarioService;
import exceptions.MultipleUsersFoundException;

@Component 
public class RegistracionFormValidator implements Validator{

	@Autowired
	private UsuarioService service;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return RegistracionForm.class.equals(clazz);
		
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		RegistracionForm form = (RegistracionForm) target;
		if(form.getMail() == null || form.getMail().isBlank() ) {
			errors.rejectValue("mail", "mail.empty");
		}else if(ValidationUtils.stringMayorA(form.getMail(), 100)) {
			errors.rejectValue("mail", "mail.max.length");
		}
		else {
			try {
				Usuario usuario = this.service.obtenerPorMail(form.getMail());
						if(usuario != null) errors.rejectValue("mail", "mail.already.exists");
			}catch(MultipleUsersFoundException e) {
				errors.rejectValue("mail", "mail.multiple.found");
			}
		}
	}

}
