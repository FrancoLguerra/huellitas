package ar.com.huellitas.helpers;

public class ValidationUtils {
	
	public static boolean nombreValido(String nombre) {
	return nombre != null 
			&& !nombre.isBlank()
			&& nombre.length() >= 2
            && nombre.length() <= 50;
	}

}
