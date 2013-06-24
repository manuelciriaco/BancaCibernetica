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
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static VentanaAdminPrecios instancia = null;
	private JTextField txtLoteria1;
	private JTextField txtTripleta1;
	private JTextField txtPale1;
	public static JLabel lblPrecioLoteria1;
	public static JLabel lblPrecioTripleta1;
	public static JLabel lblPrecioPale1;
	public static JLabel lblPrecioLoteria2;
	public static JLabel lblPrecioLoteria3;
	public static JLabel lblPrecioTripleta2;
	public static JLabel lblPrecioTripleta3;
	public static JLabel lblPrecioPale2;
	public static JLabel lblPrecioPale3;
	public static String loteriaString;
	public static String tripletaString;
	public static String paleString;
	private static JTextField txtLoteria2;
	private static JTextField txtTripleta2;
	private static  JTextField txtPale2;
	private static JTextField txtLoteria3;
	private static JTextField txtTripleta3;
	private static JTextField txtPale3;
	private JLabel lblRd;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLayeredPane layeredPane_1;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	
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
		/* Fin del Listamos los precios para mostrarlo los labels de precios*/
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAdminPrecios.class.getResource("/imagenes/041.png")));
		setTitle("Administradora de precios - Banca Cibernetica.");
		setType(Type.POPUP);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 666, 340);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Banca Cibernetica v.1 Todos los derechos reservados 2013.");
		label.setBounds(10, 298, 640, 14);
		label.setBackground(Color.LIGHT_GRAY);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(label);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 640, 276);
		contentPane.add(tabbedPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Editar precios", new ImageIcon(VentanaAdminPrecios.class.getResource("/imagenes/022 (3).png")),
				layeredPane, null);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(VentanaAdminPrecios.class.getResource("/imagenes/038 (3).png")));
		/*Action listener del boton guardar*/
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Comprobamos que solo sean numeros los ingresados. 
				if (txtLoteria1.getText().matches("[0-9]*") && txtTripleta1.getText().matches("[0-9]*") 
						&& txtPale1.getText().matches("[0-9]*")){
				//Comprobamos que no hallan campos vacios en el formulario. 
				if (txtLoteria1.getText().length() > 0 && txtTripleta1.getText().length() > 0 && txtPale1.getText().length() > 0
						&& txtLoteria2.getText().length() > 0 && txtTripleta2.getText().length() > 0 && txtPale2.getText().length() > 0
						&& txtLoteria3.getText().length() > 0 && txtTripleta3.getText().length() > 0 && txtPale3.getText().length() > 0){
				int i = JOptionPane.showConfirmDialog(VentanaAdminPrecios.this, "Desea realmente guardar estos precios? ",
						"Confirmar", JOptionPane.YES_NO_OPTION);
				//Confirmamos si el usuario eligio aceptar. 
				if (i == 0 ) {
					try {
						// Convierto el valor insertado en los textFields a Float //
						String valorLoteria = txtLoteria1.getText();
						float loteria = Float.parseFloat(valorLoteria);
						String valorTripleta = txtTripleta1.getText();
						float tripleta = Float.parseFloat(valorTripleta);
						String valorPale = txtPale1.getText();
						float pale = Float.parseFloat(valorPale);
						
						// Convierto el valor insertado en los textFields a Float //
						String valorLoteria2 = txtLoteria2.getText();
						float loteria2 = Float.parseFloat(valorLoteria2);
						String valorTripleta2 = txtTripleta2.getText();
						float tripleta2 = Float.parseFloat(valorTripleta2);
						String valorPale2 = txtPale2.getText();
						float pale2 = Float.parseFloat(valorPale2);
						
						// Convierto el valor insertado en los textFields a Float //
						String valorLoteria3 = txtLoteria3.getText();
						float loteria3 = Float.parseFloat(valorLoteria3);
						String valorTripleta3 = txtTripleta3.getText();
						float tripleta3 = Float.parseFloat(valorTripleta3);
						String valorPale3 = txtPale3.getText();
						float pale3 = Float.parseFloat(valorPale3);
						
						//Usamos el metodo INSERTARPRECIOS en la clase conexion para insertarlo en la BD. 
						Conexion con = new Conexion();
						con.insertarPrecios(loteria, tripleta, pale, loteria2, tripleta2, pale2, loteria3, tripleta3, pale3);
						actualizarPrecios();
						
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Error al Conectarse a la BD. Error:\n " + e1.getMessage(), "Error.",
								JOptionPane.ERROR_MESSAGE);
					}
				}				
			}else{
				JOptionPane.showMessageDialog(null, "Tienes que completar todos los campos.", "Error.",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		}});
		
		btnGuardar.setBounds(360, 150, 128, 43);
		layeredPane.add(btnGuardar);
		
		JLabel lblLoteria2 = new JLabel("Loter\u00EDa:\r\n");
		lblLoteria2.setBounds(24, 50, 46, 14);
		layeredPane.add(lblLoteria2);
		
		JLabel lblTripleta2 = new JLabel("Tripleta:");
		lblTripleta2.setBounds(24, 107, 46, 14);
		layeredPane.add(lblTripleta2);
		
		JLabel lblPale2 = new JLabel("Pal\u00E9:");
		lblPale2.setBounds(24, 174, 46, 14);
		layeredPane.add(lblPale2);
		
		txtLoteria1 = new JTextField();
		txtLoteria1.setBounds(93, 47, 53, 20);
		layeredPane.add(txtLoteria1);
		txtLoteria1.setColumns(10);
		
		txtTripleta1 = new JTextField();
		txtTripleta1.setColumns(10);
		txtTripleta1.setBounds(93, 104, 53, 20);
		layeredPane.add(txtTripleta1);
		
		txtPale1 = new JTextField();
		txtPale1.setColumns(10);
		txtPale1.setBounds(93, 171, 53, 20);
		layeredPane.add(txtPale1);
		
		JButton btnCancelar = new JButton("Cancelar\r\n");
		btnCancelar.setIcon(new ImageIcon(VentanaAdminPrecios.class.getResource("/imagenes/046 (2).png")));
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdminPrecios.instancia = null;
				VentanaAdminPrecios.this.setVisible(false);
			}
		});
		
		btnCancelar.setBounds(360, 78, 128, 43);
		layeredPane.add(btnCancelar);
		
		JLabel lblPrimerLugar = new JLabel("1er");
		lblPrimerLugar.setBounds(106, 22, 26, 14);
		layeredPane.add(lblPrimerLugar);
		
		JLabel lblSegundoLugar = new JLabel("2do");
		lblSegundoLugar.setBounds(180, 22, 26, 14);
		layeredPane.add(lblSegundoLugar);
		
		JLabel lblTercerLugar = new JLabel("3er");
		lblTercerLugar.setBounds(263, 22, 26, 14);
		layeredPane.add(lblTercerLugar);
		
		txtLoteria2 = new JTextField();
		txtLoteria2.setColumns(10);
		txtLoteria2.setBounds(168, 47, 53, 20);
		layeredPane.add(txtLoteria2);
		
		txtTripleta2 = new JTextField();
		txtTripleta2.setColumns(10);
		txtTripleta2.setBounds(168, 104, 53, 20);
		layeredPane.add(txtTripleta2);
		
		txtPale2 = new JTextField();
		txtPale2.setColumns(10);
		txtPale2.setBounds(168, 171, 53, 20);
		layeredPane.add(txtPale2);
		
		txtLoteria3 = new JTextField();
		txtLoteria3.setColumns(10);
		txtLoteria3.setBounds(246, 47, 53, 20);
		layeredPane.add(txtLoteria3);
		
		txtTripleta3 = new JTextField();
		txtTripleta3.setColumns(10);
		txtTripleta3.setBounds(246, 104, 53, 20);
		layeredPane.add(txtTripleta3);
		
		txtPale3 = new JTextField();
		txtPale3.setColumns(10);
		txtPale3.setBounds(246, 171, 53, 20);
		layeredPane.add(txtPale3);
		
		layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Listar precios ", new ImageIcon(VentanaAdminPrecios.class.getResource("/imagenes/010 (4).png")), layeredPane_1, null);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon(VentanaAdminPrecios.class.getResource("/imagenes/001 (2).png")));
		btnActualizar.setBounds(365, 157, 123, 39);
		layeredPane_1.add(btnActualizar);
		
		label_8 = new JLabel("RD:$");
		label_8.setBounds(247, 169, 36, 14);
		layeredPane_1.add(label_8);
		
		lblPrecioPale3 = new JLabel();
		lblPrecioPale3.setBounds(282, 169, 36, 14);
		layeredPane_1.add(lblPrecioPale3);
		
		lblPrecioTripleta3 = new JLabel();
		lblPrecioTripleta3.setBounds(282, 116, 36, 14);
		layeredPane_1.add(lblPrecioTripleta3);
		
		label_7 = new JLabel("RD:$");
		label_7.setBounds(247, 116, 36, 14);
		layeredPane_1.add(label_7);
		
		label_6 = new JLabel("RD:$");
		label_6.setBounds(247, 61, 36, 14);
		layeredPane_1.add(label_6);
		
		lblPrecioLoteria3 = new JLabel();
		lblPrecioLoteria3.setBounds(282, 61, 36, 14);
		layeredPane_1.add(lblPrecioLoteria3);
		
		label_3 = new JLabel("RD:$");
		label_3.setBounds(165, 61, 36, 14);
		layeredPane_1.add(label_3);
		
		lblPrecioLoteria2 = new JLabel();
		lblPrecioLoteria2.setBounds(201, 61, 36, 14);
		layeredPane_1.add(lblPrecioLoteria2);
		
		label_4 = new JLabel("RD:$");
		label_4.setBounds(165, 116, 36, 14);
		layeredPane_1.add(label_4);
		
		lblPrecioTripleta2 = new JLabel();
		lblPrecioTripleta2.setBounds(201, 116, 36, 14);
		layeredPane_1.add(lblPrecioTripleta2);
		
		label_5 = new JLabel("RD:$");
		label_5.setBounds(165, 169, 36, 14);
		layeredPane_1.add(label_5);
		
		lblPrecioPale2 = new JLabel();
		lblPrecioPale2.setBounds(201, 169, 36, 14);
		layeredPane_1.add(lblPrecioPale2);
		
		label_2 = new JLabel("RD:$");
		label_2.setBounds(93, 169, 36, 14);
		layeredPane_1.add(label_2);
		
		lblPrecioTripleta1 = new JLabel();
		lblPrecioTripleta1.setBounds(125, 116, 36, 14);
		layeredPane_1.add(lblPrecioTripleta1);
		
		lblPrecioPale1 = new JLabel();
		lblPrecioPale1.setBounds(125, 169, 36, 14);
		layeredPane_1.add(lblPrecioPale1);
		lblPrecioPale1.setBackground(Color.LIGHT_GRAY);
		
		lblPrecioLoteria1 = new JLabel();
		lblPrecioLoteria1.setBounds(125, 61, 36, 14);
		layeredPane_1.add(lblPrecioLoteria1);
		
		lblRd = new JLabel("RD:$");
		lblRd.setBounds(93, 61, 36, 14);
		layeredPane_1.add(lblRd);
		
		label_1 = new JLabel("RD:$");
		label_1.setBounds(93, 116, 36, 14);
		layeredPane_1.add(label_1);
		
		JLabel lblLoteria = new JLabel("Loter\u00EDa:\r\n");
		lblLoteria.setBounds(45, 61, 46, 14);
		layeredPane_1.add(lblLoteria);
		
		JLabel lblTripleta = new JLabel("Tripleta:");
		lblTripleta.setBounds(45, 116, 46, 14);
		layeredPane_1.add(lblTripleta);
		
		JLabel lblPal = new JLabel("Pal\u00E9:");
		lblPal.setBounds(45, 169, 46, 14);
		layeredPane_1.add(lblPal);
		
		JLabel lblPreciosActuales = new JLabel("Precios actuales de la banca ");
		lblPreciosActuales.setBounds(57, 0, 224, 14);
		layeredPane_1.add(lblPreciosActuales);
		lblPreciosActuales.setFont(new Font("Verdana", Font.PLAIN, 15));
		
		label_9 = new JLabel("2do");
		label_9.setBounds(199, 25, 26, 14);
		layeredPane_1.add(label_9);
		
		label_10 = new JLabel("3er");
		label_10.setBounds(282, 25, 26, 14);
		layeredPane_1.add(label_10);
		
		label_11 = new JLabel("1er");
		label_11.setBounds(125, 25, 26, 14);
		layeredPane_1.add(label_11);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					actualizarPrecios();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Error:\n " + e.getMessage(), "Error.",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	/* Metodo que llena los labels de la ventana de los precios con los precios actuales*/
	private void actualizarPrecios() throws IOException{
		Conexion con = new Conexion();
		con.listarPrecios();
	}
}
