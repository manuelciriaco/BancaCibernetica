package com.bancacibernetica.flujos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Lectora {
	private String linea;
	private File file;
	private FileReader lector;
	private BufferedReader bufferLector;
	private String rutaArchivoConfig = "config.txt";
	
	public Lectora(){
		
		file = new File(rutaArchivoConfig);
		try {
			lector = new FileReader(file);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error:\n " + e.getMessage(), "Error.",
					JOptionPane.ERROR_MESSAGE);
		}
		bufferLector = new BufferedReader(lector);
	}
	
	public String lectorDeLinea() throws IOException{
		linea = bufferLector.readLine();
		return linea;		
	}
	
	public void cerrarLector() throws IOException{
		bufferLector.close();
	}
	
}