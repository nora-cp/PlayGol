package es.deusto.ingenieria.prog3.playgol.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends JFrame{

	private JPanel panelCentral;
	private CardLayout tarjetas;
	
	public VentanaPrincipal() {
		setTitle("PlayGol - Gestión de torneos");
		setSize(1000, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		// Cabecera
		JPanel cabecera = new JPanel();
		cabecera.setBackground(new Color(25, 55, 90));
		
		JLabel titulo = new JLabel("PLAYGOL");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 28));
		
		cabecera.add(titulo);
		add(cabecera, BorderLayout.NORTH);
		
		//Menu Lateral
		JPanel menu = new JPanel();
		menu.setLayout(new GridLayout(4,1,5,15));
		menu.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
		menu.setBackground(new Color(235,240,245));
		
		
		JButton btnTorneos = new JButton("Torneos");
		JButton btnEquipos = new JButton("Equipos");
		JButton btnPartidos = new JButton("Partidos");
		JButton btnClasificacion = new JButton("Clasificacion");
		
		menu.add(btnTorneos);
		menu.add(btnEquipos);
		menu.add(btnPartidos);
		menu.add(btnClasificacion);
		
		add(menu, BorderLayout.WEST);
		
		//Panel Central
		tarjetas = new CardLayout();
		panelCentral = new JPanel(tarjetas);
		
		panelCentral.add(crearInicio(), "inicio");
      
		panelCentral.add(crearTorneos(), "torneos");
        panelCentral.add(crearEquipos(), "equipos");
        panelCentral.add(crearPartidos(), "partidos");
        panelCentral.add(crearClasificacion(), "clasificacion");				
		
		
		add(panelCentral, BorderLayout.CENTER);
	
		//Acciones de los botones
		btnTorneos.addActionListener(e -> tarjetas.show(panelCentral, "torneos"));
		btnEquipos.addActionListener(e -> tarjetas.show(panelCentral, "equipos"));
		btnPartidos.addActionListener(e -> tarjetas.show(panelCentral, "partidos"));
		btnClasificacion.addActionListener(e -> tarjetas.show(panelCentral, "clasificacion"));

		
		
	}
	
	// PANTALLA DE INICIO
		private JPanel crearInicio() {
			
			JPanel panel = new JPanel(new BorderLayout());
			
			JLabel texto = new JLabel("Bienvenido a PlayGol",SwingConstants.CENTER);
			texto.setFont(new Font("Arial", Font.BOLD, 26));
			panel.add(texto, BorderLayout.CENTER);
			
			return panel;

		}
		
		// PANTALLA DE TORNEOS
	    private JPanel crearTorneos() {

	    	JPanel panel = new JPanel(new  BorderLayout(10,10));
	    			    
	    	JLabel encabezado = new JLabel("Gestión de torneos");
			encabezado.setFont(new Font("Arial", Font.BOLD, 24));
			encabezado.setBorder(BorderFactory.createEmptyBorder(20,20,10,10));
	    	
			//Datos torneos
	        String[] columnas = {"ID", "Nombre", "Temporada", "Estado"};

	        Object[][] datos = {
	            {1, "Liga Universitaria", "2026/2027", "Activo"},
	            {2, "Copa Primavera", "2026/2027", "Pendiente"}
	        };
	        
	        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
	        
	        JTable tabla = new JTable(modelo);
	        JScrollPane scroll = new JScrollPane(tabla);
	        
	        //Panel botones
	        JPanel botones = new JPanel();
	        
	        JButton btnAñadir = new JButton("Añadir torneo");
	        JButton btnEliminar = new JButton("Eliminar torneo");
	        JButton btnModificar = new JButton("Modificar torneo");

	        botones.add(btnAñadir);
	        botones.add(btnEliminar);
	        botones.add(btnModificar);
	        
	        //Acción: nuevo torneo
	        btnAñadir.addActionListener(e -> {
	        	String nombre = JOptionPane.showInputDialog(this, "Nombre del torneo:");
	        	
	        	if (nombre != null && !nombre.trim().isEmpty()) {
	        		
	        		String temporada = JOptionPane.showInputDialog(this, "Temporada:");
	        	
	        		if (temporada != null && !temporada.trim().isEmpty()) {
	    	        	int id = modelo.getRowCount() + 1;
	    	        	modelo.addRow(new Object[] {
	    	        			id, nombre, temporada, "Pendiente"});
	        		}
	        	}	
	        });
	        
	        //Acción: modificar torneo
	        btnModificar.addActionListener(e -> {
	        	
	        	int fila = tabla.getSelectedRow();
	        	
	        	if (fila != -1) {
	        		String nombre = JOptionPane.showInputDialog(this, "Nuevo nombre:", 
	        				modelo.getValueAt(fila, 1));
	        		
	        		if (nombre != null && !nombre.trim().isEmpty()) {
	        			
	        			String temporada = JOptionPane.showInputDialog(this, "Nueva temporada: ", 
	        					modelo.getValueAt(fila, 2));
	        			
	        			if (temporada != null && !temporada.trim().isEmpty()) {
	        				
	        				modelo.setValueAt(nombre, fila, 1);
	        				modelo.setValueAt(temporada, fila, 2);
	        			}
	        		}
	        	} else {
	        		JOptionPane.showMessageDialog(this, "Selecciona un torneo primero");
	        	}
	        	
	        });
	        
	        
	        //Acción: eliminar torneo
	        btnEliminar.addActionListener(e -> {
	        	int fila = tabla.getSelectedRow();
	        	
	        	if (fila != -1) {
	        		
	        		int respuesta = JOptionPane.showConfirmDialog(
	        				this, "¿Estas seguro de que quieres eliminar este torneo?",
	        				"Confirmar eliminación", JOptionPane.YES_NO_OPTION);
	        		
	        		if (respuesta == JOptionPane.YES_OPTION) {
	        			modelo.removeRow(fila);
	        		}	
	        	
	        	}else {
	        		JOptionPane.showMessageDialog(this, "Selecciona un torneo primero");
	        	}
	        });

	        panel.add(encabezado, BorderLayout.NORTH);
	        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
	        panel.add(botones, BorderLayout.SOUTH);
	        
	        return panel;
	        
	    }
	    
	    // PANTALLA DE EQUIPOS
	    private JPanel crearEquipos() {
	    	
	    	String[] columnas = {"ID", "Equipo","Ciudad" };
	    	
	    	Object[][] datos = {
	    			{1, "Deusto FC", "Bilbao"},
	    			{2, "Club Sanse", "Donostia"},
	    			{3, "Depor Vitoria", "Vitoria"}
	    	};
	    	
	    	 DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
		        
		     JTable tabla = new JTable(modelo);
		     JPanel panel = new JPanel(new BorderLayout(10,10));
		     
		     JLabel encabezado = new JLabel("Gestión de equipos");
				encabezado.setFont(new Font("Arial", Font.BOLD, 24));
				encabezado.setBorder(BorderFactory.createEmptyBorder(20,20,10,10));
		    	
		     
		     JScrollPane scroll = new JScrollPane(tabla);
		        
		     //Panel botones
		     JPanel botones = new JPanel();
		        
		     JButton btnAñadir = new JButton("Añadir equipo");
		     JButton btnEliminar = new JButton("Eliminar equipo");
		     JButton btnModificar = new JButton("Modificar equipo");

		     botones.add(btnAñadir);
		     botones.add(btnEliminar);
		     botones.add(btnModificar);
		        
		     //Anadir equipo
		     btnAñadir.addActionListener(e -> {
		        String nombre = JOptionPane.showInputDialog(this, "Nombre del equipo:");
		        	
		        if (nombre != null && !nombre.trim().isEmpty()) {
		        		
		        	String ciudad = JOptionPane.showInputDialog(this, "Ciudad:");
		        	
		        	if (ciudad != null && !ciudad.trim().isEmpty()) {
		    	        int id = modelo.getRowCount() + 1;
		    	        modelo.addRow(new Object[] {id, nombre, ciudad});
		        		}
		        	}	
		        });
		     
		     //Modificar equipo
		     btnModificar.addActionListener(e -> {
		        	
		        int fila = tabla.getSelectedRow();
		        	
		        if (fila != -1) {
		        	String nombre = JOptionPane.showInputDialog(this, "Nuevo nombre:", 
		        			modelo.getValueAt(fila, 1));
		        		
		        	if (nombre != null && !nombre.trim().isEmpty()) {
		        			
		        		String ciudad = JOptionPane.showInputDialog(this, "Nueva ciudad: ", 
		        				modelo.getValueAt(fila, 2));
		        			
		        		if (ciudad != null && !ciudad.trim().isEmpty()) {
		        				
		        			modelo.setValueAt(nombre, fila, 1);
		        			modelo.setValueAt(ciudad, fila, 2);
		        			}
		        		}
		        } else {
		        	JOptionPane.showMessageDialog(this, "Selecciona un equipo primero");
		        	}
		        	
		       });
		     
		     //Eliminar equipo
		     btnEliminar.addActionListener(e -> {
		    	 
		    	 int fila = tabla.getSelectedRow();
		    	 
		    	 if (fila != -1) {
		    		 
		    		 int respuesta = JOptionPane.showConfirmDialog(this, 
		    				 "¿Estas seguro de que quieres eliminar este equipo?", "Confirmar eliminación",
		    				 JOptionPane.YES_NO_OPTION);
		    		 
		    		 if (respuesta == JOptionPane.YES_OPTION) {
		    				 modelo.removeRow(fila);
		    		 }
		    		 
		    	 }else {
		        	JOptionPane.showMessageDialog(this, "Selecciona un equipo primero");
		    	 }
		        
		     });
		     
		     panel.add(encabezado, BorderLayout.NORTH);
		     panel.add(scroll, BorderLayout.CENTER);
		     panel.add(botones, BorderLayout.SOUTH);
		     
		     return panel;
   
	    }
	    
		// PANTALLA DE PARTIDOS
	    private JPanel crearPartidos() {
	    	
	    	String[] columnas = {"Local", "Visitante", "Resultado", "Fecha"};
	    	
	    	Object[][] datos = {
	    			{"Deusto FC", "Depor Vitoria", "2 - 1", "10/11/2026"},
	    			{"Club Sanse", "Deusto FC", "0 - 0", "12/11/2026"},
	    	};
	    	
	    	 DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
		        
		     JTable tabla = new JTable(modelo);
		     JPanel panel = new JPanel(new BorderLayout(10,10));
		     
		     JLabel encabezado = new JLabel("Gestión de partidos");
			encabezado.setFont(new Font("Arial", Font.BOLD, 24));
			encabezado.setBorder(BorderFactory.createEmptyBorder(20,20,10,10));
		    	
		     
		     JScrollPane scroll = new JScrollPane(tabla);
		     
		     //Panel botones
		     JPanel botones = new JPanel();
		        
		     JButton btnAñadir = new JButton("Añadir partido");
		     JButton btnEliminar = new JButton("Eliminar partido");
		     JButton btnModificar = new JButton("Modificar partido");

		     botones.add(btnAñadir);
		     botones.add(btnEliminar);
		     botones.add(btnModificar);
		     
		     //Añadir partido
		     btnAñadir.addActionListener(e -> {
			     String local = JOptionPane.showInputDialog(this, "Equipo local:");
			        	
			     if (local != null && !local.trim().isEmpty()) {
			        		
			      	String visitante = JOptionPane.showInputDialog(this, "Equipo visitante:");
			        	
			       	if (visitante != null && !visitante.trim().isEmpty()) {
			       		
			       		String resultado = JOptionPane.showInputDialog(this, "Resultado:");
			       		
			       		if (resultado != null && !resultado.trim().isEmpty()) {
			       			
			       			String fecha = JOptionPane.showInputDialog(this, "Fecha:");
			       		
			       			if (fecha != null && !fecha.trim().isEmpty()) {
			       				modelo.addRow(new Object[] {local, visitante, resultado, fecha});
			       			}
			       		}
			       	}
		        }	
			  });
		     
		    //Modificar partido
		     btnModificar.addActionListener(e -> {
		        	
			     int fila = tabla.getSelectedRow();
			        	
			     if (fila != -1) {
			        String local = JOptionPane.showInputDialog(this, "Equipo Local:", 
			        		modelo.getValueAt(fila, 0));
			        		
			        if (local != null && !local.trim().isEmpty()) {
			        			
			        	String visitante = JOptionPane.showInputDialog(this, "Equipo visitante: ", 
			        			modelo.getValueAt(fila, 1));
			        			
			        	if (visitante != null && !visitante.trim().isEmpty()) {
			        		
			        		String resultado = JOptionPane.showInputDialog(this, "Resultado: ", 
				        			modelo.getValueAt(fila, 2));
			        		
			        		if (resultado != null && !resultado.trim().isEmpty()) {
			        			
			        			String fecha = JOptionPane.showInputDialog(this, "Fecha: ", 
					        			modelo.getValueAt(fila, 3));
			        		
			        			if (fecha != null && !fecha.trim().isEmpty()) {
			        			
			        				modelo.setValueAt(local, fila, 0);
			        				modelo.setValueAt(visitante, fila, 1);
			        				modelo.setValueAt(resultado, fila, 2);
			        				modelo.setValueAt(fecha, fila, 3);
			        			}
			        		}
			        	}
		    		}
			     } else {
			       	JOptionPane.showMessageDialog(this, "Selecciona un partido primero");
			       	}
			        	
			 }); 
	    	
		     // Eliminar partido
		     btnEliminar.addActionListener(e -> {
		    	 
		    	 int fila = tabla.getSelectedRow();
		        	
		        	if (fila != -1) {
		        		
		        		int respuesta = JOptionPane.showConfirmDialog(this, 
			    				 "¿Estas seguro de que quieres eliminar este partido?", "Confirmar eliminación",
			    				 JOptionPane.YES_NO_OPTION);
			    		 
			    		 if (respuesta == JOptionPane.YES_OPTION) {
			    			 modelo.removeRow(fila);
			    		 }
			    		 
		        	}else {
		        		JOptionPane.showMessageDialog(this, "Selecciona un partido primero");
		        	}
		        
		     });
		     
		     panel.add(encabezado, BorderLayout.NORTH);
		     panel.add(scroll, BorderLayout.CENTER);
		     panel.add(botones, BorderLayout.SOUTH);
		     
		     return panel;

	    }
	    
	    
	    // PANTALLA DE CLASIFICACIÓN
	    private JPanel crearClasificacion() {
	    	
	    	String[] columnas = {"Posición", "Equipos", "Puntos", "Jugados"};
	    	
	    	Object[][] datos = {
	    			{1, "Deusto FC", 6, 2},
	    			{2, "Club Sanse", 3, 2},
	    			{3, "Depor Vitoria", 1, 2}	
	    	};
	    	
	    	DefaultTableModel modelo = new DefaultTableModel(datos, columnas) {
	    		@Override
	    		public boolean isCellEditable(int fila, int columna) {
	    			return false;
	    		}
	    	};
	    	
	    	JTable tabla = new JTable(modelo);
	    	
	    	JPanel panel = new JPanel(new BorderLayout(10,10));
	        JScrollPane scroll = new JScrollPane(tabla);

	    	
	    	JLabel encabezado = new JLabel("Clasificación del torneo");
	        encabezado.setFont(new Font("Arial", Font.BOLD, 24));
	        encabezado.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 10));
	        
	        panel.add(encabezado, BorderLayout.NORTH);
	        panel.add(scroll, BorderLayout.CENTER);
	        
	        return panel;
	    	
	    }
	    
	    
	    
		// METODO PARA CREAR TABLAS
	    private JPanel crearPanelTabla(String titulo, String[] columnas, Object[][] datos) {
	    	
	    	JPanel panel = 	new JPanel(new BorderLayout(10,10));
	    
	        JLabel encabezado = new JLabel(titulo);
	        encabezado.setFont(new Font("Arial", Font.BOLD, 24));
	        encabezado.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 10));
	        
	        JTable tabla = new JTable(datos, columnas);
	        JScrollPane scroll = new JScrollPane(tabla);

	        panel.add(encabezado, BorderLayout.NORTH);
	        panel.add(scroll, BorderLayout.CENTER);

	        return panel;
	    }
	    

		
		
	}
	

