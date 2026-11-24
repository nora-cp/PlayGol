package es.deusto.ingenieria.prog3.playgol.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaLogin extends JFrame {

	private JTextField txtUsuario;
	private JPasswordField txtContrasena;

	public VentanaLogin() {
		setTitle("PlayGol - Login");
		setSize(400, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));

		JLabel lblTitulo = new JLabel("Bienvenido a PlayGol", JLabel.CENTER);

		JPanel panelDatos = new JPanel(new GridLayout(2, 2, 10, 10));

		panelDatos.add(new JLabel("Usuario: "));
		txtUsuario = new JTextField();
		panelDatos.add(txtUsuario);

		panelDatos.add(new JLabel("COntraseña: "));
		txtContrasena = new JPasswordField();
		panelDatos.add(txtContrasena);

		JButton btnEntrar = new JButton("Entrar");
		JButton btnSalir = new JButton("Salir");

		JPanel panelBotones = new JPanel();
		panelBotones.add(btnEntrar);
		panelBotones.add(btnSalir);

		panelPrincipal.add(lblTitulo, BorderLayout.NORTH);
		panelPrincipal.add(panelDatos, BorderLayout.CENTER);
		panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

		add(panelPrincipal);

		btnEntrar.addActionListener(e -> comprobarLogin());
		btnSalir.addActionListener(e -> System.exit(0));

		// Enter permite iniciar sesion
		txtContrasena.addActionListener(e -> comprobarLogin());
		txtUsuario.addActionListener(e -> txtContrasena.requestFocus());
	}

	private void comprobarLogin() {
		String usuario = txtUsuario.getText();
		String contrasena = new String(txtContrasena.getPassword());

		if (usuario.equals("admin") && contrasena.equals("1234")) {
			JOptionPane.showMessageDialog(this, "Bienvenido a PlayGol");

			VentanaPrincipal ventana = new VentanaPrincipal();
			ventana.setVisible(true);

			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error de acceso",
					JOptionPane.ERROR_MESSAGE);

			txtContrasena.setText("");
		}
	}

}
