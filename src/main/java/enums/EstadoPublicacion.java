package enums;

public enum EstadoPublicacion {
	ACTIVA("ACTIVA"),
	SUSPENDIDA("SUSPENDIDA"),
	ELIMINADA("ELIMINADA");
	
	private String estado;
	
	private EstadoPublicacion(String estado) {
		this.estado = estado;
		
	}
	
	public String getEstado() {
		return this.estado;
	}
	

}
