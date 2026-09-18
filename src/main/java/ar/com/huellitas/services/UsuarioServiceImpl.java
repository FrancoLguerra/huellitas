package ar.com.huellitas.services;


import java.util.List;

import org.springframework.stereotype.Service;

import ar.com.huellitas.domain.Usuario;
import ar.com.huellitas.forms.RegistracionForm;
import ar.com.huellitas.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	private final UsuarioRepository repositorio;

	UsuarioServiceImpl(UsuarioRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Usuario guardar(RegistracionForm registracionForm) {
		Usuario usuario = new Usuario(registracionForm.getNombre(),registracionForm.getApellido(),registracionForm.getMail(),registracionForm.getTelefono());
		return this.repositorio.save(usuario);
		
	}

	public List<Usuario> listar() {
		return repositorio.findAll();
		
	}

	public Usuario buscarPorId(Long id) {
		
		return repositorio.getById(id);
	}

	public Usuario actualizar(Long id, Usuario usuario) {
		Usuario usuarioBase = buscarPorId(id);
		usuarioBase.setNombre(usuario.getNombre());
		usuarioBase.setApellido(usuario.getApellido());
		usuarioBase.setMail(usuario.getMail());
		usuarioBase.setTelefono(usuario.getTelefono());
		
		return this.repositorio.save(usuarioBase);
	}
	
	public void eliminar(Long id) {
		
		Usuario usuario = buscarPorId(id);
		this.repositorio.delete(usuario);
	}
	
	
}
