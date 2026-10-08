package ar.com.huellitas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ar.com.huellitas.domain.Publicacion;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion,Long>{

	List<Publicacion> findByPublicadoPorId(Long id);

}
