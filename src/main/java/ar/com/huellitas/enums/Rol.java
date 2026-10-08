package ar.com.huellitas.enums;
import ar.com.huellitas.enums.Permiso;
public enum Rol {
ADMIN(new Permiso[] {Permiso.ADMINISTRAR_MASCOTAS,Permiso.CREAR_MASCOTA, Permiso.ADMINISTRAR_PUBLICACIONES, Permiso.ADMINISTRAR_USUARIOS, Permiso.CREAR_PUBLICACION}),
SIMPLE(new Permiso[] {Permiso.ADMINISTRAR_PERFIL, Permiso.ADMINISTRAR_PUBLICACIONES_PROPIAS, Permiso.CREAR_MASCOTA, Permiso.CREAR_MASCOTA});

private Permiso[] permisos;
	
	private Rol (Permiso[] permisos) {
		this.permisos = permisos;
	}
	
	public Permiso[] getPermisos() {
		return this.permisos;
	}
	public String getSecurityName() {
		return "ROLE_"+ name();
	}
}
