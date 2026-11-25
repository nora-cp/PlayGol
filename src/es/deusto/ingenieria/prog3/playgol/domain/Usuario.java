package es.deusto.ingenieria.prog3.playgol.domain;

public class Usuario {
	private int id;
	private String nombre;
	private String nombreUsuario;
	private String contrasena;

	public Usuario(int id, String nombre, String nombreUsuario, String contrasena) {
		this.id = id;
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return nombreUsuario;
	}

}
