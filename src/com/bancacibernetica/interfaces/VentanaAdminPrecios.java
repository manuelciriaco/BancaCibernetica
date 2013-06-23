package com.bancacibernetica.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import com.bancacibernetica.conexiones.Conexion;

public class VentanaAdminPrecios extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static VentanaAdminPrecios instancia = null;
	private JTextField txtLoteria;
	private JTextField txtTripleta;
	private JTextField txtPale;
	
	/*Creamos una unica instancia para la clase VentanaAdministrador*/
	public static synchronized VentanaAdminPrecios getInstancia(){
		if (instancia == null) {
			instancia = new VentanaAdminPrecios();
			instancia.setVisible(true);
		}
		return instancia;
	}
	
	/*Constructor privado, evitamos que accedan a el*/
	private VentanaAdminPrecios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAdminPrecios.class.getResource("/imagenes/041.png")));
		setTitle("Administradora de precios - Banca Cibernetica.");
		setType(Type.POPUP);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 551, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Banca Cibernetica v.1 Todos los derechos reservados 2013.");
		label.setBounds(0, 258, 444, 14);
		label.setBackground(Color.LIGHT_GRAY);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(label);
		
		JLabel lblPreciosActuales = new JLabel("Precios actuales de la banca ");
		lblPreciosActuales.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblPreciosActuales.setBounds(24, 11, 224, 14);
		contentPane.add(lblPreciosActuales);
		
		JLabel lblTripleta = new JLabel("Tripleta:");
		lblTripleta.setBounds(24, 134, 46, 14);
		contentPane.add(lblTripleta);
		
		JLabel lblLoteria = new JLabel("Loter\u00EDa:\r\n");
		lblLoteria.setBounds(24, 91, 46, 14);
		contentPane.add(lblLoteria);
		
		JLabel lblPal = new JLabel("Pal\u00E9:");
		lblPal.setBounds(24, 177, 46, 14);
		contentPane.add(lblPal);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(258, 11, 277, 236);
		contentPane.add(tabbedPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Editar precios", new ImageIcon(VentanaAdminPrecios.class.getResource("/imagenes/022 (3).png")),
				layeredPane, null);
		
		JButton btnGuardar = new JButton("Guardar");
		/*Action listener del boton guardar*/
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(VentanaAdminPrecios.this, "Desea realmente guardar estos precios? ",
						"Confirmar", JOptionPane.YES_NO_OPTION);
				//Confirmamos si el usuario eligio aceptar. 
				if (i == 0 ) {
					
					try {
						
						/* Convierto el valor insertado en los textFields a Float */
						String valorLoteria = txtLoteria.getText();
						float loteria = Float.parseFloat(valorLoteria);
						String valorTripleta = txtTripleta.getText();
						float tripleta = Float.parseFloat(valorTripleta);
						String valorPale = txtPale.getText();
						float pale = Float.parseFloat(valorPale);
						Conexion con = new Conexion();
						con.insertarPrecios(loteria, tripleta, pale);
						
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Error al Conectarse a la BD. Error:\n " + e1.getMessage(), "Error.",
								JOptionPane.ERROR_MESSAGE);
					}
				}				
			}
		});
		
		btnGuardar.setBounds(173, 148, 89, 23);
		layeredPane.add(btnGuardar);
		
		JLabel lblLoteria2 = new JLabel("Loter\u00EDa:\r\n");
		lblLoteria2.setBounds(10, 31, 46, 14);
		layeredPane.add(lblLoteria2);
		
		JLabel lblTripleta2 = new JLabel("Tripleta:");
		lblTripleta2.setBounds(10, 67, 46, 14);
		layeredPane.add(lblTripleta2);
		
		JLabel lblPale2 = new JLabel("Pal\u00E9:");
		lblPale2.setBounds(10, 107, 46, 14);
		layeredPane.add(lblPale2);
		
		txtLoteria = new JTextField();
		txtLoteria.setBounds(66, 28, 53, 20);
		layeredPane.add(txtLoteria);
		txtLoteria.setColumns(10);
		
		txtTripleta = new JTextField();
		txtTripleta.setColumns(10);
		txtTripleta.setBounds(66, 64, 53, 20);
		layeredPane.add(txtTripleta);
		
		txtPale = new JTextField();
		txtPale.setColumns(10);
		txtPale.setBounds(66, 104, 53, 20);
		layeredPane.add(txtPale);
		
		JButton btnCancelar = new JButton("Cancelar\r\n");
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdminPrecios.instancia = null;
				VentanaAdminPrecios.this.setVisible(false);
			}
		});
		
		btnCancelar.setBounds(66, 148, 89, 23);
		layeredPane.add(btnCancelar);
	}
}
