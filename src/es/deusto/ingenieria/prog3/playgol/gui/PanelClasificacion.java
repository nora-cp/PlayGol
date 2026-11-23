package es.deusto.ingenieria.prog3.playgol.gui;

import es.deusto.ingenieria.prog3.playgol.gui.renderer.RendererClasificacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PanelClasificacion extends JPanel{
	
	private JTable tablaClasificacion;
	
	public PanelClasificacion() {
		
		setLayout(new BorderLayout(10,10));
		
		JLabel lblTitulo = new JLabel("CLASIFICACION");	
		
		JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelSuperior.add(lblTitulo);
		
		String[] columnas = { "Posición", "Equipo", "PJ", "PG", "PE", "PP", "GF", "GC", "DG", "Puntos"				
		};
		
		tablaClasificacion = new JTable(new DefaultTableModel(null,columnas));
		
		tablaClasificacion.setDefaultRenderer(Object.class, new RendererClasificacion());
		
		JScrollPane scroll = new JScrollPane(tablaClasificacion);
		
		add(panelSuperior,BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		
	}

	public JTable getTablaClasificacion() {
		return tablaClasificacion;
	}
}
