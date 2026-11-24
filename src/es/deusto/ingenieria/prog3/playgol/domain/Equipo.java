package es.deusto.ingenieria.prog3.playgol.domain;

public class Equipo {

	private int id;
	private String nombre;
	private String ciudad;
	private Torneo torneo;
	
	public Equipo (int id, String nombre, String ciudad, Torneo torneo) {
		this.id = id;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.torneo = torneo;
		
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

	 
	 public String getCiudad() {
	        return ciudad;
	    }

	 public void setCiudad(String ciudad) {
	        this.ciudad = ciudad;
	    }

	 public Torneo getTorneo() {
	        return torneo;
	    }

	 public void setTorneo(Torneo torneo) {
	        this.torneo = torneo;
	    }

	  @Override
	    public String toString() {
	        return nombre;
	    }

}
