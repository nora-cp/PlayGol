package es.deusto.ingenieria.prog3.playgol.main;

import javax.swing.SwingUtilities;

import es.deusto.ingenieria.prog3.playgol.db.CrearTablas;
import es.deusto.ingenieria.prog3.playgol.gui.VentanaLogin;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CrearTablas.crear();
		
		SwingUtilities.invokeLater(() -> {
			VentanaLogin ventana = new VentanaLogin();
			ventana.setVisible(true);
		});
	}

}
