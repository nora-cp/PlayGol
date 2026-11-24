package es.deusto.ingenieria.prog3.playgol.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelTorneos extends JPanel {

	private JTable tablaTorneos;
	
	public PanelTorneos() {
		
		setLayout(new BorderLayout(10, 10));
		JLabel lblTitulo = new JLabel ("GESTION DE TORNEOS");
		
		
		JPanel panelSuperior = new JPanel (new FlowLayout(FlowLayout.LEFT));
		
		//Tabla
		
		String[] columnas = {
				"ID", "Nombre", "Temporada", "Estado"
		};
		
		
		tablaTorneos = new JTable(new DefaultTableModel(null, columnas));
		
		
		JScrollPane scroll = new JScrollPane(tablaTorneos);
		
		
		//Botones
		
		JButton btnAnadir = new JButton("Añadir");
		JButton btnModificar = new JButton ("Modificar");
		JButton btnEliminar = new JButton ("Eliminar");
		JButton btnConsultar = new JButton ("Consultar");
		
		JPanel panelBotones = new JPanel ();
		panelBotones.add(btnAnadir);
		panelBotones.add(btnModificar);
		panelBotones.add(btnEliminar);
		panelBotones.add(btnConsultar);
		
		add(panelSuperior, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		add(panelBotones, BorderLayout.SOUTH);
	

	}
	
}
