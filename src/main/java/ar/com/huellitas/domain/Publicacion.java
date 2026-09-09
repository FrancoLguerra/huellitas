package ar.com.huellitas.domain;

import java.time.LocalDateTime;
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
	final static String ERR_FECHA_NULL = "La fecha no puede ser null";
	final static String ERR_TEXTO_ADICIONAL_MAYOR = "El texto excede el tamaño permitido";
	final static String ERR_UBICACION_INVALIDA="La ubicación tiene un formato incorrecto";
	final static String ERR_USUARIO_NULL = "El Usuario no puede ser null";
	final static String ERR_MASCOTA_NULL = "La mascota no puede ser null";
	private static final String ERR_ESTADO_NULL = "El estado no puede ser null";
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	@Column(name = "FECHA")
	private LocalDateTime fecha;
	@Column(name = "TEXTO_ADICIONAL", length = 255)
	private String textoAdicional;
	@Column(name = "UBICACION")
	private String ubicacion;
	@Column(name = "ESTADO", nullable = false)
	@Enumerated(EnumType.STRING)
	private EstadoPublicacion estado;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "IMAGEN_ID", nullable = true)
	private Imagen imagen;
	@ManyToOne(optional = false)
	@JoinColumn(name= "USUARIO_ID", nullable = false)
	private Usuario publicadoPor;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "MASCOTA_ID", nullable = false)
	private Mascota mascota;
	
	protected Publicacion() {};
	
	public Publicacion(Usuario publicadoPor,Mascota mascota) {
		setMascota(mascota);
		 if (publicadoPor == null) {
		        throw new IllegalArgumentException(ERR_USUARIO_NULL);
		    }
		this.publicadoPor = publicadoPor;
		setFecha(LocalDateTime.now());
		setEstado(EstadoPublicacion.ACTIVA);
		
		
		
	}
	
	public void setFecha(LocalDateTime fecha) {
		if(fecha == null) {
			throw new IllegalArgumentException(ERR_FECHA_NULL);
		}
		this.fecha = fecha;
	}

	public void setTextoAdicional(String textoAdicional) {
		if(ValidationUtils.stringMayorA(textoAdicional, 255) ) {
			throw new IllegalArgumentException(ERR_TEXTO_ADICIONAL_MAYOR);
			
		}
		this.textoAdicional = textoAdicional;
	}

	public void setUbicacion(String ubicacion) {
		if(!ValidationUtils.stringValido(ubicacion)) {
			throw new IllegalArgumentException(ERR_UBICACION_INVALIDA);
		}
		this.ubicacion = ubicacion;
	}

	public void setEstado(EstadoPublicacion estado) {
		if(estado == null) {
			throw new IllegalArgumentException(ERR_ESTADO_NULL);
		}
		this.estado = estado;
	}

	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}

	public void setMascota(Mascota mascota) {
		if (mascota == null) {
			throw new IllegalArgumentException(ERR_MASCOTA_NULL);
		}
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
