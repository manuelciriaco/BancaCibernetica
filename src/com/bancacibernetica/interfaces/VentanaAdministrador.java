package com.bancacibernetica.interfaces;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

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

	/*Constructor privado, evitamos que accedan a el*/
	private VentanaAdministrador() {
		setResizable(false);
		setTitle("Usuario administrador - Bienvenido -nombreDeUsuario-");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAdministrador.class.getResource("/imagenes/047.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 541);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		ImageIcon img1 = new ImageIcon("C:\\imagenes\\019 (3).png");
		JButton btnAgregarUsuario = new JButton(img1);
		btnAgregarUsuario.setToolTipText("Mantenimiento de usuarios.");
		btnAgregarUsuario.setBackground(Color.WHITE);
		btnAgregarUsuario.setForeground(Color.WHITE);
		btnAgregarUsuario.setForeground(Color.WHITE);
		btnAgregarUsuario.setBounds(59, 89, 73, 49);
		contentPane.add(btnAgregarUsuario);
		
		ImageIcon img2 = new ImageIcon("C:\\imagenes\\006 (5).png");
		JButton btnPrecios = new JButton(img2);
		btnPrecios.setToolTipText("Mantenimiento de precios.");
		btnPrecios.setForeground(Color.WHITE);
		btnPrecios.setBackground(Color.WHITE);
		btnPrecios.setBounds(59, 227, 73, 49);
		contentPane.add(btnPrecios);
		
		ImageIcon img3 = new ImageIcon("C:\\imagenes\\040 (4).png");
		JButton btnNumerosGanadores = new JButton(img3);
		btnNumerosGanadores.setToolTipText("Ingresar los n\u00FAmeros ganadores de las loter\u00EDas");
		btnNumerosGanadores.setForeground(Color.WHITE);
		btnNumerosGanadores.setBackground(Color.WHITE);
		btnNumerosGanadores.setBounds(59, 365, 73, 49);
		contentPane.add(btnNumerosGanadores);
		
		ImageIcon img4 = new ImageIcon("C:\\imagenes\\062.png");
		JButton btnReporteGanadores = new JButton(img4);
		btnReporteGanadores.setToolTipText("Reporte de Ganadores.");
		btnReporteGanadores.setForeground(Color.WHITE);
		btnReporteGanadores.setBackground(Color.WHITE);
		btnReporteGanadores.setBounds(408, 89, 73, 49);
		contentPane.add(btnReporteGanadores);
		
		ImageIcon img5 = new ImageIcon("C:\\imagenes\\047.png");
		JButton btnPagos = new JButton(img5);
		btnPagos.setToolTipText("Pago a ganadores.");
		btnPagos.setForeground(Color.WHITE);
		btnPagos.setBackground(Color.WHITE);
		btnPagos.setBounds(408, 227, 73, 49);
		contentPane.add(btnPagos);
		
		ImageIcon img6 = new ImageIcon("C:\\imagenes\\028 (4).png");
		JButton btnSalir = new JButton(img6);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*Saliendo del sistema*/
				System.exit(0);
			}
		});
		btnSalir.setToolTipText("Pago a ganadores.");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(408, 365, 73, 49);
		contentPane.add(btnSalir);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 579, 26);
		contentPane.add(menuBar);
		
		JMenu mnVistas = new JMenu("Vistas");
		menuBar.add(mnVistas);
		
		JMenuItem mntmUsuario = new JMenuItem("Usuario cajero");
		mntmUsuario.setSelected(true);
		mnVistas.add(mntmUsuario);
		
		JMenu mnInfo = new JMenu("Info");
		menuBar.add(mnInfo);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mnInfo.add(mntmAcercaDe);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 492, 569, 21);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Banca Cibernetica v.1 Todos los derechos reservados 2013.");
		lblNewLabel.setBounds(0, 0, 569, 21);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel);
		
		JLabel lblMantenimientoDeUsuarios = new JLabel("Mantenimiento de usuarios.");
		lblMantenimientoDeUsuarios.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblMantenimientoDeUsuarios.setBounds(59, 137, 205, 34);
		contentPane.add(lblMantenimientoDeUsuarios);
		
		JLabel lblMantenimientoDePrecios = new JLabel("Mantenimiento de precios.");
		lblMantenimientoDePrecios.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblMantenimientoDePrecios.setBounds(59, 276, 205, 34);
		contentPane.add(lblMantenimientoDePrecios);
		
		JLabel lblIngresarLosNmeros = new JLabel("Ingresar los n\u00FAmeros ganadores.");
		lblIngresarLosNmeros.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblIngresarLosNmeros.setBounds(59, 413, 257, 34);
		contentPane.add(lblIngresarLosNmeros);
		
		JLabel lblReporteDeGanadores = new JLabel("Reporte de ganadores.");
		lblReporteDeGanadores.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblReporteDeGanadores.setBounds(393, 137, 176, 34);
		contentPane.add(lblReporteDeGanadores);
		
		JLabel lblPagoAGanadores = new JLabel("Pago a ganadores.");
		lblPagoAGanadores.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblPagoAGanadores.setBounds(393, 280, 154, 26);
		contentPane.add(lblPagoAGanadores);
		
		JLabel lblSalir = new JLabel("Salir.");
		lblSalir.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblSalir.setBounds(393, 418, 154, 26);
		contentPane.add(lblSalir);
	
		
	}
}
