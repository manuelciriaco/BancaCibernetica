package com.bancacibernetica.conexiones;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.bancacibernetica.flujos.Lectora;

public class Conexion {
	
	private java.sql.Statement st;
	private java.sql.Connection con;
	private String tablaDeLaBd;
	
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
	public void insertarPrecios(float loteria, float tripleta, float pale){
		
		try {
			st.executeUpdate("insert into "+tablaDeLaBd+"(loteria,tripleta, pale) values ("+loteria+","+tripleta+","+pale+")");
			JOptionPane.showMessageDialog(null, "Guardado con exito ! ", "Precios guardados.",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al insertar los datos:\n " + e.getMessage(), "Error.",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
