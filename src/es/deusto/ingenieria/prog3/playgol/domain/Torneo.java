package es.deusto.ingenieria.prog3.playgol.domain;

import java.util.ArrayList;
import java.util.List;

public class Torneo {

	private int id;
	private String nombre;
	private String temporada;
	private String estado;
	private List<Equipo> equipos;
	private List<Partido> partidos;
	
	public Torneo (int id, String nombre, String Temporada, String estado) {
		this.id = id;
		this.nombre = nombre;
		this.temporada = temporada;
        this.estado = estado;
        this.equipos = new ArrayList<>();
        this.partidos = new ArrayList<>();
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

	public String getTemporada() {
        return temporada;
    }

	public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

	public String getEstado() {
        return estado;
    }

	public void setEstado(String estado) {
        this.estado = estado;
    }

	public List<Equipo> getEquipos() {
        return equipos;
    }

	public List<Partido> getPartidos() {
        return partidos;
    }

	public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

	public void agregarPartido(Partido partido) {
        partidos.add(partido);
    }

	public void eliminarEquipo(Equipo equipo) {
        equipos.remove(equipo);
    }

	public void eliminarPartido(Partido partido) {
        partidos.remove(partido);
    }

	@Override
    public String toString() {
        return nombre + " (" + temporada + ")";
    }


	
}
