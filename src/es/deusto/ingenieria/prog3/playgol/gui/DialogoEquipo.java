package es.deusto.ingenieria.prog3.playgol.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogoEquipo extends JDialog {

	private JTextField txtNombre;
    private JTextField txtCiudad;

    private boolean aceptado = false;
    
    super(ventana, "Añadir equipo", true);

    public DialogoEquipo(JFrame ventana) {
    	super(ventana, "Añadir equipo", true);

        setSize(350, 220);
        setLocationRelativeTo(ventana);
        setLayout(new BorderLayout());

        JPanel panelCampos = new JPanel(new GridLayout(2, 2, 5, 10));

        panelCampos.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );
        
        panelCampos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelCampos.add(txtNombre);

        panelCampos.add(new JLabel("Ciudad:"));
        txtCiudad = new JTextField();
        panelCampos.add(txtCiudad);
        
        add(panelCampos, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");

        btnAceptar.addActionListener(e -> {
            if (txtNombre.getText().trim().isEmpty()
                    || txtCiudad.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                    this,
                    "Rellena todos los campos"
                );
                
            } else {
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

    public String getNombreEquipo() {
        return txtNombre.getText().trim();
    }

    public String getCiudadEquipo() {
        return txtCiudad.getText().trim();
    }



    
}
