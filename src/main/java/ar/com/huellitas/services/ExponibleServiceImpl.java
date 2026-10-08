package ar.com.huellitas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.huellitas.domain.Exponible;
import ar.com.huellitas.domain.Usuario;
import ar.com.huellitas.dtos.DTO;
import ar.com.huellitas.dtos.UsuarioDTO;
import ar.com.huellitas.forms.RegistracionForm;
import ar.com.huellitas.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;

public abstract class ExponibleServiceImpl<E extends Exponible<F, DTO>, F extends RegistracionForm> {
	@Autowired
	UsuarioRepository repository;
	
	
	public List<UsuarioDTO> exponer(){
		List<Usuario> entities = repository.findAll();
		List<UsuarioDTO> dtos = new ArrayList<>();
		for (Usuario usuario : entities) {
			UsuarioDTO dto = usuario.asDTO();
			dtos.add(dto);
		}
		
		return dtos;
	}
}
