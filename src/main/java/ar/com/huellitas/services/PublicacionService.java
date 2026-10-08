package ar.com.huellitas.services;

import java.util.List;

import ar.com.huellitas.domain.Imagen;
import ar.com.huellitas.domain.Publicacion;
import ar.com.huellitas.dtos.PublicacionDTO;
import ar.com.huellitas.forms.PublicacionForm;

public interface PublicacionService {

    Publicacion guardar(PublicacionForm form);

    List<Publicacion> listar();

    Publicacion buscarPorId(Long id);

    Publicacion actualizar(
            Long id,
            PublicacionForm publicacion
    );

    void eliminar(Long id);

    List<PublicacionDTO> exponer();
}
