package ar.com.huellitas.services;


import java.util.List;

import ar.com.huellitas.domain.Usuario;
import ar.com.huellitas.dtos.UsuarioDTO;
import ar.com.huellitas.forms.RegistracionForm;

public interface UsuarioService {

	public Usuario guardar(RegistracionForm registracionForm);
	
	public List<Usuario> listar();
	public List<UsuarioDTO> exponer();
	public Usuario buscarPorId(Long id);
	Usuario actualizar(
	        Long id,
	        String nombre,
	        String apellido,
	        String mail,
	        String telefono
	);

	void eliminar(Long id);
	public void login(String mail);
	public Usuario obtenerPorMail(String mail);
}
