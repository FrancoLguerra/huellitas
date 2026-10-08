package ar.com.huellitas.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;
import org.springframework.stereotype.Service;

import ar.com.huellitas.domain.Usuario;
import ar.com.huellitas.dtos.UsuarioDTO;
import ar.com.huellitas.forms.RegistracionForm;
import ar.com.huellitas.repositories.UsuarioRepository;
import ar.com.huellitas.security.InfoUserAuthenticationToken;
import exceptions.MultipleUsersFoundException;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	private ModelMapper mapper = new ModelMapper(); 
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
		
		Optional<Usuario> usuario = repositorio.findById(id);
		return usuario.isPresent()?usuario.get() : null;
	}

	public Usuario actualizar(Long id,
	        String nombre,
	        String apellido,
	        String mail,
	        String telefono) {
		Usuario usuarioBase = buscarPorId(id);
		 usuarioBase.setNombre(nombre);
		 usuarioBase.setApellido(apellido);
		 usuarioBase.setMail(mail);
		 usuarioBase.setTelefono(telefono);
		
		return this.repositorio.save(usuarioBase);
	}
	
	public void eliminar(Long id) {
		
		Usuario usuario = buscarPorId(id);
		this.repositorio.delete(usuario);
	}
	public List<UsuarioDTO> exponer(){
		
		List<Usuario> entities = repositorio.findAll();
		List<UsuarioDTO> dtos = new ArrayList<>();
		for (Usuario usuario : entities) {
			UsuarioDTO dto2 = mapper.map(usuario, UsuarioDTO.class);
			UsuarioDTO dto = usuario.asDTO();
			dtos.add(dto);
		}
		//dtos = entities.stream().map(u -> u.asDTO()).collect(Collectors.toList());
		return dtos;
	}
	public Usuario obtenerPorMail(String mail) {
		List<Usuario> usuarios = this.repositorio.findByMail(mail);
		Usuario encontrado = null;
		if(usuarios != null && !usuarios.isEmpty()) {
			if(usuarios.size() == 1) {
				encontrado = usuarios.get(0);
			}else throw new MultipleUsersFoundException(mail);
		}
		return encontrado;
	}

	@Override
	public void login(String mail) {
		Usuario usuario = obtenerPorMail(mail);
		InfoUserAuthenticationToken token = new InfoUserAuthenticationToken(usuario.getId(), usuario.getMail(), usuario.collectAuthorities());
		token.setUserName(usuario.getNombre());
		SecurityContext context = SecurityContextHolder.getContext();
		context.setAuthentication(token);
	}
	
	
	
}
