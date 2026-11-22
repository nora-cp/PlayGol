package es.deusto.ingenieria.prog3.playgol.domain;

import java.time.LocalDate;

public class Partido {
	
	private int id;
	private Torneo torneo;
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private LocalDate fecha;
	private int golesLocal;
	private int golesVisitante;
	private boolean jugado;
	
	public Partido(int id, Torneo torneo, Equipo equipoLocal, Equipo equipoVisitante, LocalDate fecha, int golesLocal,
			int golesVisitante, boolean jugado) {
		super();
		this.id = id;
		this.torneo = torneo;
		this.equipoLocal = equipoLocal;
		equipoVisitante = equipoVisitante;
		this.fecha = fecha;
		this.golesLocal = 0;
		this.golesVisitante = 0;
		this.jugado = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

	public Equipo getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getGolesLocal() {
		return golesLocal;
	}

	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}

	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}

	public boolean isJugado() {
		return jugado;
	}

	public void setJugado(boolean jugado) {
		this.jugado = jugado;
	}

	
	
	public void registrarResultado(int golesLocal, int golesVisitante) {
		if (golesLocal < 0 || golesVisitante < 0) {
			throw new IllegalArgumentException("Los goles no pueden ser negativos");
		}
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
		this.jugado = true;
	}
	
	@Override
	public String toString() {
		if (!jugado) {
		return equipoLocal + " - " + equipoVisitante + " (Pentiente)";
		}
		
		return equipoLocal + " " + golesLocal + " - " + golesVisitante + " " + equipoVisitante;
	}
}
