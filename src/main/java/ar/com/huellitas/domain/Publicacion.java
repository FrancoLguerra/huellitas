package ar.com.huellitas.domain;

import java.time.LocalDateTime;
import java.util.Random;

import ar.com.huellitas.enums.EstadoPublicacion;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PUBLICACIONES")
public class Publicacion {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	@Column(name = "FECHA")
	private LocalDateTime fecha;
	@Column(name = "TEXTO_ADICIONAL")
	private String textoAdicional;
	@Column(name = "UBICACION")
	private String ubicacion;
	@Column(name = "ESTADO")
	@Enumerated(EnumType.STRING)
	private EstadoPublicacion estado;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "IMAGEN_ID", nullable = true)
	private Imagen imagen;
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name= "USUARIO_ID")
	private Usuario publicadoPor;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "MASCOTA_ID", nullable = false)
	private Mascota mascota;
	
	Publicacion() {};
	
	public Publicacion(Usuario publicadoPor,Mascota mascota, LocalDateTime fecha, String especie) {
		id = new Random().nextLong();
		this.mascota = mascota;
		this.publicadoPor = publicadoPor;
		this.fecha = fecha;
		this.estado = EstadoPublicacion.ACTIVA;
		
		
	}
	
	public Long getId() {
		return this.id;
	}
	

}
