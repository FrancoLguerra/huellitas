package ar.com.huellitas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.huellitas.domain.Imagen;
import ar.com.huellitas.domain.Mascota;
import ar.com.huellitas.domain.Publicacion;
import ar.com.huellitas.domain.Usuario;
import ar.com.huellitas.dtos.PublicacionDTO;
import ar.com.huellitas.enums.EstadoPublicacion;
import ar.com.huellitas.forms.PublicacionForm;
import ar.com.huellitas.repositories.MascotaRepository;
import ar.com.huellitas.repositories.PublicacionRepository;
import ar.com.huellitas.repositories.UsuarioRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import ar.com.huellitas.security.InfoUserAuthenticationToken;

@Service
public class PublicacionServiceImpl implements PublicacionService{
	
    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    private PublicacionRepository repositorio;
    @Autowired
    private UsuarioRepository usuarioRepositorio;
    @Autowired
    private MascotaRepository mascotaRepositorio;

    @Override
    public Publicacion guardar(PublicacionForm form) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        InfoUserAuthenticationToken token =
                (InfoUserAuthenticationToken) authentication;

        Long usuarioId = token.getId();

        Usuario usuario = usuarioRepositorio.findById(usuarioId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "No existe el usuario autenticado"));


        Mascota mascota = new Mascota(
                form.getEspecie(),
                form.getColor()
        );

        mascota.setNombre(form.getNombreMascota());
        mascota.setGenero(form.getGenero());
        mascota.setRaza(form.getRaza());
        mascota.setCastrado(form.isCastrado());

        mascota = mascotaRepositorio.save(mascota);


        Publicacion publicacion =
                new Publicacion(usuario, mascota);

        publicacion.setTextoAdicional(
                form.getTextoAdicional()
        );

        publicacion.setUbicacion(
                form.getUbicacion()
        );


        return repositorio.save(publicacion);
    }

	@Override
	public List<Publicacion> listar() {
		return repositorio.findAll();
	}


    @Override
    public Publicacion buscarPorId(Long id) {

        Optional<Publicacion> publicacion = repositorio.findById(id);

        return publicacion.isPresent() ? publicacion.get() : null;
    }

	@Override
	public Publicacion actualizar(Long id, PublicacionForm form) {

		Publicacion publicacionBase = buscarPorId(id);

		if (publicacionBase == null) {
        return null;
			}

		publicacionBase.setTextoAdicional(form.getTextoAdicional());
		publicacionBase.setUbicacion(form.getUbicacion());
		/* publicacionBase.setImagen(form.getImagen()); */
		return repositorio.save(publicacionBase);
	}

    @Override
    public void eliminar(Long id) {

        Publicacion publicacion = buscarPorId(id);

        if (publicacion != null) {
            repositorio.delete(publicacion);
        }
    }

    @Override
    public List<PublicacionDTO> exponer() {

        List<Publicacion> entities = repositorio.findAll();

        List<PublicacionDTO> dtos = new ArrayList<>();

        for (Publicacion publicacion : entities) {
            PublicacionDTO dto = mapper.map(publicacion, PublicacionDTO.class);
            dtos.add(dto);
        }

        return dtos;
    }

	

}
