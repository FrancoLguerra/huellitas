package ar.com.huellitas.helpers;

import ar.com.huellitas.enums.TipoDeImagen;

public class ValidationUtils {
	
	public static boolean stringValido(String palabra) {
		return 	
				palabra != null 
				&& !palabra.isBlank();
	}
	
	public static boolean stringMayorA(String palabra, int tamanio) {
		return 
				palabra != null
				&&palabra.length() > tamanio;
	}
	
	public static boolean stringMenorA(String palabra, int tamanio) {
		return 
				palabra != null
				&&palabra.length() < tamanio;
	}
	
	public static boolean nombreValido(String nombre) {
	
			return
				stringValido(nombre)
				&& cadenaConLongitudValida(nombre, 2, 100);
	}
	
	public static boolean apellidoValido(String apellido) {
		return 
				stringValido(apellido)
				&& cadenaConLongitudValida(apellido, 2, 100);
	}
	
	public static boolean cadenaConLongitudValida(String cadena, int minimo, int mayor) {
		return 
				cadena != null
				&& stringMayorA(cadena, minimo)
				&& stringMenorA(cadena, mayor);
		
	}
	
	public static boolean mailValido(String mail) {
		return
				stringValido(mail)
				&& mail.contains("@")
				&& mail.contains(".com")
				&& !mail.startsWith("@")
		        && !mail.endsWith("@")
		        && !mail.startsWith(".")
		        && !mail.endsWith(".");
	}
	
	public static boolean telefonoValido(String telefono) {
		return
				stringValido(telefono)
				&& cadenaConLongitudValida(telefono, 2, 30);
				
	}
	
	public static boolean tipoImagenValido(TipoDeImagen tipo) {
		return
				tipo != null;
		
	}
	
	public static boolean contenidoImagenValido(byte[] contenido) {
		return 
				contenido!= null;
				
	}

	

}
