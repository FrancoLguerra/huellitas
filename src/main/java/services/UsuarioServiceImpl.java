package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.huellitas.domain.Usuario;
import ar.com.huellitas.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository repositorio;

	@Override
	public void guardar(Usuario usuario) {
		this.repositorio.save(usuario);
		
	}
	
	
}
