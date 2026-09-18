package ar.com.huellitas.services;


import java.util.List;

import ar.com.huellitas.domain.Usuario;
import ar.com.huellitas.forms.RegistracionForm;

public interface UsuarioService {

	public Usuario guardar(RegistracionForm registracionForm);
	
	public List<Usuario> listar();
	public Usuario buscarPorId(Long id);
}
