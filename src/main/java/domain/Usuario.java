package domain;

public class Usuario {
	
	private int documento;
	private String nombre;
	private String apellido;
	private String mail;
	private int telefono;
	
	public Usuario(int documento) {
		documento = this.documento;
	}
	
	public Usuario(int documento, String nombre, String apellido, String mail, int telefono ) {
		this.documento = documento;
		this.nombre = nombre ;
		this.apellido = apellido;
		this.mail = mail;
		this.telefono = telefono;
		
	}
	public int getDni() {
		return documento;
	}

}

