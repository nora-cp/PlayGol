package es.deusto.ingenieria.prog3.playgol.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame {
	private CardLayout cardLayout;
	private JPanel panelContenido;

	public VentanaPrincipal() {
		setTitle("PlayGol - Gestión de torneos");
		setSize(1000, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		cardLayout = new CardLayout();
		panelContenido = new JPanel(cardLayout);

		// Creamos los paneles
		PanelTorneos panelTorneos = new PanelTorneos();
		PanelEquipos panelEquipos = new PanelEquipos();
		PanelPartidos panelPartidos = new PanelPartidos();
		PanelClasificacion panelClasificacion = new PanelClasificacion();

		// Añadimos los paneles al CardLayout
		panelContenido.add(panelTorneos, "TORNEOS");
		panelContenido.add(panelEquipos, "EQUIPOS");
		panelContenido.add(panelPartidos, "PARTIDOS");
		panelContenido.add(panelClasificacion, "CLASIFICACION");

		// Panel de investigacion
		JPanel panelNavegacion = new JPanel(new FlowLayout());

		JButton btnTorneos = new JButton("Torneos");
		JButton btnEquipos = new JButton("Equipos");
		JButton btnPartidos = new JButton("Partidos");
		JButton btnClasificacion = new JButton("Clasificación");
		JButton btnCerrarSesion = new JButton("Cerrar sesión");

		panelNavegacion.add(btnTorneos);
		panelNavegacion.add(btnEquipos);
		panelNavegacion.add(btnPartidos);
		panelNavegacion.add(btnClasificacion);
		panelNavegacion.add(btnCerrarSesion);

		// Eventos de navegacion
		btnTorneos.addActionListener(e -> cardLayout.show(panelContenido, "TORNEOS"));
		btnEquipos.addActionListener(e -> cardLayout.show(panelContenido, "PARTIDOS"));
		btnPartidos.addActionListener(e -> cardLayout.show(panelContenido, "PARTIDOS"));
		btnClasificacion.addActionListener(e -> cardLayout.show(panelContenido, "CLASIFICACION"));
		btnCerrarSesion.addActionListener(e -> {
			dispose();
			new VentanaLogin().setVisible(true);
		});

		add(panelNavegacion, BorderLayout.NORTH);
		add(panelContenido, BorderLayout.CENTER);

		// Panel inicial
		cardLayout.show(panelContenido, "TORNEOS");

	}
}