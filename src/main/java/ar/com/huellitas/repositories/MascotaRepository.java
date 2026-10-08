package ar.com.huellitas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.huellitas.domain.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long>{
	

}
