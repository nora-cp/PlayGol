package es.deusto.ingenieria.prog3.playgol.db;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class CrearTablas {
	
	public static void crear() {
		try (Connection con = ConexionBD.conectar();
				Statement stmt = con.createStatement()){
			
			stmt.executeUpdate(
				"CREATE TABLE IF NOT EXISTS usuario ("+
				"id INTEGER PRIMARY KEY AUTOINCREMENT, "+
				"nombre TEXT NOT NULL, "+
				"nombreUsuario TEXT NOT NULL UNIQUE, "+
				"contrasena TEXT NOL NULL)"
			);
			
			stmt.executeUpdate(
				"CREATE TABLE IF NOT EXISTS torneo ("+
				"id INTEGER PRIMARY KEY AUTOINCREMENT, "+
				"nombre TEXT NOT NULL, "+
				"temporada TEXT NOT NULL, "+
				"estado TEXT NOT NULL)"
			);
			
			stmt.executeUpdate(
				"CREATE TABLE IF NOT EXISTS equipo (" +
			    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
			    "nombre TEXT NOT NULL, " +
			    "ciudad TEXT NOT NULL, " +
			    "torneo_id INTEGER, " +
			    "FOREIGN KEY(torneo_id) REFERENCES torneo(id))"
			);
			
			stmt.executeUpdate(
				"CREATE TABLE IF NOT EXISTS partido (" +
	            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
	            "torneo_id INTEGER, " +
	            "equipo_local_id INTEGER, " +
	            "equipo_visitante_id INTEGER, " +
	            "fecha TEXT, " +
	            "goles_local INTEGER DEFAULT 0, " +
	            "goles_visitante INTEGER DEFAULT 0, " +
	            "jugado INTEGER DEFAULT 0, " +
	            "FOREIGN KEY(torneo_id) REFERENCES torneo(id), " +
	            "FOREIGN KEY(equipo_local_id) REFERENCES equipo(id), " +
	            "FOREIGN KEY(equipo_visitante_id) REFERENCES equipo(id))"
	         );

			System.out.println("Tablas creadas correctamente.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
