package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import domain.Publicacion;
import domain.Usuario;

public class Main {

	static ArrayList<Usuario> usuarios = new ArrayList<>();
	
	public static void agregarUsuario(Usuario user) {
		usuarios.add(user);
		

	}
	
	public static Usuario armarUsuario(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese DNI:");
		int dni = sc.nextInt();
		System.out.println("Ingrese Nombre: ");
		String nombre = sc.next().toUpperCase();
		System.out.println("Ingrese Apellido");
		String apellido = sc.next().toUpperCase();
		System.out.println("Ingrese Mail");
		String mail = sc.next().toLowerCase();
		System.out.println("ingrese Telefono");
		int telefono =sc.nextInt();
		Usuario usuario = new Usuario(dni, nombre, apellido, mail,telefono);
		
		return usuario;
		
	}

	public static void main(String[] args) {
		int opcion = 0;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Seleccione una de las siguientes opciones:");
			System.out.println("1.REGISTRARSE");
			System.out.println("2.PUBLICACIONES");
			System.out.println("0.SALIR");
			opcion = sc.nextInt();
			
			if(opcion == 1) {
				Usuario usuario = armarUsuario();
				agregarUsuario(usuario);
				for (Usuario user : usuarios) {
				System.out.println(user.getDni());
				
			}
			}
			else if(opcion == 2){
				System.out.println("Aun no tenes publicaciones");
			}
			else if(opcion != 0){
				System.out.println("La opcion no existe");
			}
		

			
		} while (opcion != 0);
		

		

		


		}
	

}
