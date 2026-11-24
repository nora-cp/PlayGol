package es.deusto.ingenieria.prog3.playgol.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class DialogoPartido extends JDialog{
	
	private JTextField txtLocal;
	private JTextField txtVisitante;
	
	private boolean aceptado = false;
	
	public DialogoPartido(JFrame ventana) {
		
		super(ventana, "Nuevo partido", true);
		
		setSize(350, 200);
		setLocationRelativeTo(ventana);
		setLayout(new BorderLayout());
		
		JPanel panelCampos = new JPanel(new GridLayout(2,2,10,10));
		
		panelCampos.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
		
		panelCampos.add(new JLabel("Equipo Local"));
		txtLocal = new JTextField();
		panelCampos.add(txtLocal);
		
		panelCampos.add(new JLabel("Equipo Visiante"));
		txtVisitante = new JTextField();
		panelCampos.add(txtVisitante);
		
		add(panelCampos, BorderLayout.CENTER);
		
		JPanel panelBotones = new JPanel();
		
		JButton btnAceptar = new JButton("Aceptar");
		JButton btnCancelar = new JButton("Cancelar");
		
		btnAceptar.addActionListener(e -> {
			if(txtLocal.getText().trim().isEmpty() || txtVisitante.getText().trim().isEmpty()) {
			
				JOptionPane.showMessageDialog(this, "Introduce los dos equipos");
			}else if (txtLocal.getText().trim().equalsIgnoreCase(txtVisitante.getText().trim())){
				JOptionPane.showMessageDialog(this, "Los equipos debes de ser diferentes");
			}else {
				aceptado = true;
				dispose();
			}
		});
		
		btnCancelar.addActionListener(e -> dispose());
		
		panelBotones.add(btnAceptar);
		panelBotones.add(btnCancelar);
		
		add(panelBotones, BorderLayout.SOUTH);
	}
	
	public boolean isAceptado() {
		return aceptado;
	}
	
	public String getEquipoLocal() {
		return txtLocal.getText().trim();
	}

	public String getEquipoVisitante() {
		return txtVisitante.getText().trim();
	}
}
