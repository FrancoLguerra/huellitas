package ar.com.huellitas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.huellitas.domain.Imagen;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Long>{

}
