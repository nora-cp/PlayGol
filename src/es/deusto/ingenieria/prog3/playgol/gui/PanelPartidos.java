package es.deusto.ingenieria.prog3.playgol.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PanelPartidos extends JPanel{
	
	private JTable tablaPartidos;
	
	public PanelPartidos() {
		
		setLayout(new BorderLayout(10,10));
		
		JLabel lblTitulo = new JLabel("GESTIÓN DE PARTIDOS");
		
		JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelSuperior.add(lblTitulo);
		
		String[] columnas = {"ID", "Torneo", "Local", "Visitante", "Fecha", "Resultado", "Estado"};
	
		tablaPartidos = new JTable(new DefaultTableModel(null, columnas));
		
		JScrollPane scroll = new JScrollPane(tablaPartidos);
		
		JButton btnGenerar = new JButton("Generar partido");
		JButton btnResultado = new JButton("Registrar resultados");
		JButton btnEliminar = new JButton("Eliminar partido");
		
		JPanel panelBotones = new JPanel();
		panelBotones.add(btnGenerar);
		panelBotones.add(btnResultado);
		panelBotones.add(btnEliminar);
		
		add(panelSuperior,BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		add(panelBotones, BorderLayout.SOUTH);


		
	}
}
