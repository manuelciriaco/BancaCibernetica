package com.bancacibernetica.interfaces;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaAdministrador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static VentanaAdministrador ventanaAdmin = null;
	
	/*Creamos una unica instancia para la clase VentanaAdministrador*/
	public static synchronized VentanaAdministrador getInstancia(){
		if (ventanaAdmin == null) {
			ventanaAdmin = new VentanaAdministrador();
			ventanaAdmin.setVisible(true);
		}
		return ventanaAdmin;
	}

	
	private VentanaAdministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
