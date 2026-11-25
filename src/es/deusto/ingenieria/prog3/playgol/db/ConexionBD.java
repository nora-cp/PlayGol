package es.deusto.ingenieria.prog3.playgol.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	
	private static final String URL = "jdbc:sqlite:playgol.db";
	
	public static Connection conectar() throws SQLException {
		return DriverManager.getConnection(URL);
	}
	
	public static void cerrar(Connection conexion) {
		if (conexion != null) {
			try {
				conexion.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
	}

}
