package ar.com.huellitas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.com.huellitas.domain.Mascota;
import ar.com.huellitas.enums.EspecieMascota;
import ar.com.huellitas.enums.GeneroMascota;
import ar.com.huellitas.repositories.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService{
	
	private final MascotaRepository mascotaRepository;
	
	public MascotaServiceImpl(MascotaRepository mascotaRepository) {
		this.mascotaRepository = mascotaRepository;
	};

	@Override
	public Mascota guardar(Mascota mascota) {
		return mascotaRepository.save(mascota);
	}

	@Override
	public Mascota registrar(String nombre, EspecieMascota especie, GeneroMascota genero, String color, String raza,
			boolean castrado) {
		
		Mascota mascota = new Mascota(especie, color);
		mascota.setNombre(nombre);
		mascota.setGenero(genero);
		mascota.setRaza(raza);
		mascota.setCastrado(castrado);
		return guardar(mascota);
	}

	@Override
	public List<Mascota> listar() {
		
		return mascotaRepository.findAll();
	}

	@Override
	public Mascota buscarPorId(Long id) {
		 return mascotaRepository.findById(id)
	                .orElseThrow(() ->
	                    new IllegalArgumentException("Mascota no encontrada"));
	}

	@Override
	public Mascota actualizar(Long id, String nombre, EspecieMascota especie, GeneroMascota genero, String color,
			String raza, boolean castrado) {
		
		Mascota mascota = buscarPorId(id);
		
		mascota.setNombre(nombre);
		mascota.setEspecie(especie);
		mascota.setColor(color);
		mascota.setGenero(genero);
		mascota.setRaza(raza);
		mascota.setCastrado(castrado);
		return guardar(mascota);
	}
	@Override
	public void eliminar(Long id) {
		Mascota mascota = buscarPorId(id);
		mascotaRepository.delete(mascota);
	}

}
