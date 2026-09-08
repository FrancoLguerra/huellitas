package ar.com.huellitas.domain;

import java.time.LocalDateTime;
import java.util.Random;

import ar.com.huellitas.enums.EstadoPublicacion;
import ar.com.huellitas.helpers.ValidationUtils;
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
	@ManyToOne(optional = false)
	@JoinColumn(name= "USUARIO_ID")
	private Usuario publicadoPor;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "MASCOTA_ID", nullable = false)
	private Mascota mascota;
	
	Publicacion() {};
	
	public Publicacion(Usuario publicadoPor,Mascota mascota) {
		setMascota(mascota);
		setPublicadoPor(publicadoPor);
		setFecha(LocalDateTime.now());
		setEstado(EstadoPublicacion.ACTIVA);
		
		
		
	}
	
	public void setFecha(LocalDateTime fecha) {
		if(fecha == null) {
			throw new IllegalArgumentException("La fecha es invalida");
		}
		this.fecha = fecha;
	}

	public void setTextoAdicional(String textoAdicional) {
		if(ValidationUtils.stringMayorA(textoAdicional, 255) ) {
			throw new IllegalArgumentException("El texto excede el tamaño permitido");
			
		}
		this.textoAdicional = textoAdicional;
	}

	public void setUbicacion(String ubicacion) {
		if(!ValidationUtils.stringValido(ubicacion)) {
			throw new IllegalArgumentException("La ubicación tiene un formato incorrecto");
		}
		this.ubicacion = ubicacion;
	}

	public void setEstado(EstadoPublicacion estado) {
		this.estado = estado;
	}

	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}

	public void setPublicadoPor(Usuario publicadoPor) {
		this.publicadoPor = publicadoPor;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public Long getId() {
		return this.id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public String getTextoAdicional() {
		return textoAdicional;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public EstadoPublicacion getEstado() {
		return estado;
	}

	public Imagen getImagen() {
		return imagen;
	}

	public Usuario getPublicadoPor() {
		return publicadoPor;
	}

	public Mascota getMascota() {
		return mascota;
	}
	

}
