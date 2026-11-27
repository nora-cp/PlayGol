package es.deusto.ingenieria.prog3.playgol.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PanelPartidos extends JPanel{
	
	private JTable tablaPartidos;
	private DefaultTableModel modelo;	
	private static DefaultTableModel modeloCompartido;
	
	public PanelPartidos() {
		
		setLayout(new BorderLayout(10,10));
		
		JLabel lblTitulo = new JLabel("GESTIÓN DE PARTIDOS");
		
		JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelSuperior.add(lblTitulo);
		
		String[] columnas = {"ID", "Torneo", "Local", "Visitante", "Fecha", "Resultado", "Estado"};
		
		modelo = new DefaultTableModel(null, columnas) {
			@Override
			public boolean isCellEditable(int fila, int columna) {
				return false;
			}
		};
		
		modeloCompartido = modelo;
	
		tablaPartidos = new JTable(modelo);
		
		JScrollPane scroll = new JScrollPane(tablaPartidos);
		
		JButton btnAñadir = new JButton("Añadir");
		JButton btnResultado = new JButton("Registrar resultados");
		JButton btnEliminar = new JButton("Eliminar");
		
		JPanel panelBotones = new JPanel();
		panelBotones.add(btnAñadir);
		panelBotones.add(btnResultado);
		panelBotones.add(btnEliminar);
		
		// añadir
		btnAñadir.addActionListener(e -> {
			
			//IAG
			DialogoPartido dialogo = new DialogoPartido(
					(javax.swing.JFrame) javax.swing.SwingUtilities
                    .getWindowAncestor(this)
                    );
			dialogo.setVisible(true);
			
			if (dialogo.isAceptado()) {
				
				int id = modelo.getRowCount() + 1;
				
				modelo.addRow(new Object[] {
						id,
						"-",
						dialogo.getEquipoLocal(),
						dialogo.getEquipoVisitante(),
						"-",
						"Pendiente"
				});
			}
		});
		
		// registrar resultado
		btnResultado.addActionListener(e -> {
			
			int fila = tablaPartidos.getSelectedRow();
			
			if(fila == -1) {
				JOptionPane.showMessageDialog(this, "Selecciona un partido");
				return;
			}
			
			if (modelo.getValueAt(fila, 5).equals("Jugado")) {
				JOptionPane.showMessageDialog(this, "Este partido ya tiene resultado");
				return;
			}
			
			String golesLocal = JOptionPane.showInputDialog(this, "Goles del equipo local");
			
			if (golesLocal == null) {
				return;
			}
			
			String golesVisitante = JOptionPane.showInputDialog(this, "Goles del equipo visitante");
			
			if (golesVisitante == null) {
				return;
			}
			
			try {
				int gl = Integer.parseInt(golesLocal);
				int gv = Integer.parseInt(golesVisitante);
				
				if(gl < 0 || gv < 0) {
					JOptionPane.showMessageDialog(this, "Los goles no pueden ser negativos");
					return;
				}
				modelo.setValueAt(gl + " - " + gv, fila, 4);
				modelo.setValueAt("Jugado", fila, 5);
			
			}catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Introduce números válidos");
			}
		});
		
		//Eliminar
		
		btnEliminar.addActionListener(e -> {
			
			int fila = tablaPartidos.getSelectedRow();
			
			if(fila == -1) {
				JOptionPane.showMessageDialog(this, "Selecciona un partido");
				return;
			}
			
			 int respuesta = JOptionPane.showConfirmDialog(
		                this,
		                "¿Eliminar el partido seleccionado?",
		                "Confirmar",
		                JOptionPane.YES_NO_OPTION
		            );
			 
			 if (respuesta == JOptionPane.YES_OPTION) {
				 modelo.removeRow(fila);
			 }
		});
		
		
		add(panelSuperior,BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		add(panelBotones, BorderLayout.SOUTH);


		
	}
	public static DefaultTableModel getModeloCompartido() {
		return modeloCompartido;
	}
}
