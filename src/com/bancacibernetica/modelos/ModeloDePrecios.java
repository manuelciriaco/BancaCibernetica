package com.bancacibernetica.modelos;

import com.bancacibernetica.interfaces.VentanaAdminPrecios;

public class ModeloDePrecios {
	
	private float loteria1;
	private float loteria2;
	private float loteria3;
	private float tripleta1;
	private float tripleta2;
	private float tripleta3;
	private float pale1;
	private float pale2;
	private float pale3;
	VentanaAdminPrecios ventana = VentanaAdminPrecios.getInstancia();
	
	public float getLoteria() {
		return loteria1;
	}
	public void setLoterias(float loteria1, float loteria2, float loteria3) {
		this.loteria1 = loteria1;
		this.loteria2 = loteria2;
		this.loteria3 = loteria3;
		VentanaAdminPrecios.lblPrecioLoteria1.setText(getLoteriaString());
		VentanaAdminPrecios.lblPrecioLoteria2.setText(getLoteriaString2());
		VentanaAdminPrecios.lblPrecioLoteria3.setText(getLoteriaString3());
	}
	public float getTripleta() {
		return tripleta1;
	}
	public void setTripletas(float tripleta1, float tripleta2, float tripleta3) {
		this.tripleta1 = tripleta1;
		this.tripleta2 = tripleta2;
		this.tripleta3 = tripleta3;
		VentanaAdminPrecios.lblPrecioTripleta1.setText(getTripletaString());
		VentanaAdminPrecios.lblPrecioTripleta2.setText(getTripletaString2());
		VentanaAdminPrecios.lblPrecioTripleta3.setText(getTripletaString3());
	}
	public float getPale() {
		return pale1;
	}
	public void setPales(float pale1, float pale2, float pale3) {
		this.pale1 = pale1;
		this.pale2 = pale2;
		this.pale3 = pale3;
		VentanaAdminPrecios.lblPrecioPale1.setText(getPaleString());
		VentanaAdminPrecios.lblPrecioPale2.setText(getPaleString2());
		VentanaAdminPrecios.lblPrecioPale3.setText(getPaleString3());
	}
	public String getLoteriaString(){
		String loteriaString = Float.toString(loteria1);
		return loteriaString;
	}
	public String getLoteriaString2(){
		String loteriaString2 = Float.toString(loteria2);
		return loteriaString2;
	}
	public String getLoteriaString3(){
		String loteriaString3 = Float.toString(loteria3);
		return loteriaString3;
	}
	public String getTripletaString(){
		String tripletaString = Float.toString(tripleta1);
		return tripletaString;
	}
	public String getTripletaString2(){
		String tripletaString2 = Float.toString(tripleta2);
		return tripletaString2;
	}
	public String getTripletaString3(){
		String tripletaString3 = Float.toString(tripleta3);
		return tripletaString3;
	}
	public String getPaleString(){
		String paleString = Float.toString(pale1);
		return paleString;
	}
	public String getPaleString2(){
		String paleString2 = Float.toString(pale2);
		return paleString2;
	}
	public String getPaleString3(){
		String paleString3 = Float.toString(pale3);
		return paleString3;
	}

}
