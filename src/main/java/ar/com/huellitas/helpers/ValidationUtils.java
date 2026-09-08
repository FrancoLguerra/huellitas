package ar.com.huellitas.helpers;

public class ValidationUtils {
	
	public static boolean stringValido(String palabra) {
		return 	
				palabra != null 
				&& !palabra.isBlank();
	}
	
	public static boolean stringMayorA(String palabra, int tamanio) {
		return palabra.length() > tamanio;
	}
	
	public static boolean stringMenorA(String palabra, int tamanio) {
		return palabra.length() < tamanio;
	}
	
	public static boolean nombreValido(String nombre) {
	
			return
				stringValido(nombre)
				&& stringMayorA(nombre, 2)
				&& stringMenorA(nombre, 100);
	}
	
	public static boolean apellidoValido(String apellido) {
		return 
				stringValido(apellido)
				&& stringMenorA(apellido, 2)
				&& stringMenorA(apellido, 100);
	}
	public static boolean mailValido(String mail) {
		return
				stringValido(mail)
				&& mail.contains("@")
				&& mail.contains(".com");
	}
	
	public static boolean telefonoValido(String telefono) {
		return
				stringValido(telefono)
				&& stringMayorA(telefono, 5)
				&& stringMayorA(telefono, 20);
				
	}
	
	public static boolean tipoImagenValido(String tipo) {
		return
				stringValido(tipo)
				&& tipo.equals("jpeg")
				&& tipo.equals("png")
				&& tipo.equals("webp");
				
	}
	
	public static boolean contenidoImagenValido(byte[] contenido) {
		return 
				contenido!= null
				&contenido.length <= 0
				&& contenido.length > 5 * 1024 * 1024;
	}

	

}
