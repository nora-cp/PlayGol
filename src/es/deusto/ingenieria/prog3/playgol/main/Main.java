package es.deusto.ingenieria.prog3.playgol.main;

import javax.swing.SwingUtilities;

import es.deusto.ingenieria.prog3.playgol.gui.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SwingUtilities.invokeLater(() -> {
			VentanaPrincipal ventana = new VentanaPrincipal();
			ventana.setVisible(true);
		});
	}

}
