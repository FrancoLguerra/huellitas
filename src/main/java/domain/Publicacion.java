package domain;

import java.time.LocalDateTime;
import java.util.Random;

import enums.EstadoPublicacion;

public class Publicacion {
	private Long id;
	private LocalDateTime fecha;
	private String textoAdicional;
	private String ubicacion;
	private EstadoPublicacion estado;
	private Imagen imagen;
	private Usuario publicadoPor;
	private Mascota mascota;
	
	
	public Publicacion(Usuario publicadoPor,Mascota mascota, LocalDateTime fecha, String especie) {
		id = new Random().nextLong();
		this.mascota = mascota;
		this.publicadoPor = publicadoPor;
		this.fecha = fecha;
		
		
	}
	
	public Long getId() {
		return this.id;
	}
	

}
