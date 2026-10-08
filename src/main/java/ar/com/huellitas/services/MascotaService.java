package ar.com.huellitas.services;

import java.util.List;

import ar.com.huellitas.domain.Mascota;
import ar.com.huellitas.enums.EspecieMascota;
import ar.com.huellitas.enums.GeneroMascota;

public interface MascotaService {
	Mascota guardar(Mascota mascota);
	
	Mascota registrar( String nombre,
            EspecieMascota especie,
            GeneroMascota genero,
            String color,
            String raza,
            boolean castrado);
	
	List<Mascota> listar();
	
	 Mascota buscarPorId(Long id);
	 
	 Mascota actualizar(
	            Long id,
	            String nombre,
	            EspecieMascota especie,
	            GeneroMascota genero,
	            String color,
	            String raza,
	            boolean castrado
	    );
	 void eliminar(Long id);
}


