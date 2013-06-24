package com.bancacibernetica.conexiones;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.bancacibernetica.flujos.Lectora;
import com.bancacibernetica.modelos.ModeloDePrecios;

public class Conexion {
	
	private java.sql.Statement st;
	private java.sql.Connection con;
	private String tablaDeLaBd;
	private ResultSet rs;
	ModeloDePrecios modelo = null;
	
	/*
	 * Colocamos el Statement en el constructor para que cada vez que sea llamada la clase,
	 * se conecte. 
	 * Indicamos donde esta la clase Driver en la libreria mysql-connector le
	 * Decimos al DriveManager que cree una conexion y la guarde en la variable
	 * tipo Conexion llamada "con".
	 */
	// -------------------------------------------------------------------------------------------------------------
	
	public Conexion() throws IOException{
		
		Lectora lectora = new Lectora();
		// Leemos los datos del archivo llamado config.txt//
		String servidor = lectora.lectorDeLinea(); // Leemos el servidor - config.txt//
		String baseDeDatos = lectora.lectorDeLinea(); // Leemos la base de datos - config.txt//
		String usuario = lectora.lectorDeLinea(); // Leemos el usuario - config.txt//
		String clave = lectora.lectorDeLinea(); // Leemos la clave - config.txt//
		tablaDeLaBd = lectora.lectorDeLinea(); // Leemos el nombre de la tabla de la BD - config.txt//
		lectora.cerrarLector(); //Cerramos el lector//
		
		//Para comprobar si tiene o no clave la base de datos. 		
		clave = (clave == null)? "" :clave;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://"+servidor+"/"+baseDeDatos+"?user="+usuario+"&password="+clave);
			st = con.createStatement();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, "Error:\n " + e.getMessage(), "Error.",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	/* 
	 * Metodo para modificar los precios de las diferentes loterias
	 */
	// -------------------------------------------------------------------------------------------------------------
	public void insertarPrecios(float loteria, float tripleta, float pale, float loteria2, float tripleta2,
			float pale2, float loteria3, float tripleta3, float pale3){
		
		try {
			st.executeUpdate("UPDATE `"+tablaDeLaBd+"` SET `loteria1`="+loteria+",`tripleta1`="+tripleta+",pale1="+pale+
					", loteria2="+loteria2+", tripleta2="+tripleta2+", pale2="+pale2+", " +
							"loteria3="+loteria3+", tripleta3="+tripleta3+", pale3="+pale3+" WHERE 1");
			JOptionPane.showMessageDialog(null, "Guardado con exito ! ", "Precios guardados.",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al insertar los datos:\n " + e.getMessage(), "Error.",
					JOptionPane.ERROR_MESSAGE);
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error:\n " + e.getMessage(), "Error.",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	/* 
	 * Metodo para listar los diferentes precios de la loteria. 
	 */
	// -------------------------------------------------------------------------------------------------------------
	public void listarPrecios(){
		float precioLoteria;
		float precioTripleta;
		float precioPale;
		float precioLoteria2;
		float precioTripleta2;
		float precioPale2;
		float precioLoteria3;
		float precioTripleta3;
		float precioPale3;
		
		try{
			rs = st.executeQuery("select * from "+tablaDeLaBd+"");
			while(rs.next()){
			precioLoteria = rs.getFloat("loteria1");
			precioTripleta = rs.getFloat("tripleta1");
			precioPale = rs.getFloat("pale1");
			precioLoteria2 = rs.getFloat("loteria2");
			precioTripleta2 = rs.getFloat("tripleta2");
			precioPale2 = rs.getFloat("pale2");
			precioLoteria3 = rs.getFloat("loteria3");
			precioTripleta3 = rs.getFloat("tripleta3");
			precioPale3 = rs.getFloat("pale3");
			modelo = new ModeloDePrecios();
			modelo.setLoterias(precioLoteria,precioLoteria2,precioLoteria3);
			modelo.setTripletas(precioTripleta,precioTripleta2,precioTripleta3);
			modelo.setPales(precioPale,precioPale2,precioPale3);
			}
			
			con.close();
			
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al listar los datos:\n " + e.getMessage(), "Error.",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	

}
