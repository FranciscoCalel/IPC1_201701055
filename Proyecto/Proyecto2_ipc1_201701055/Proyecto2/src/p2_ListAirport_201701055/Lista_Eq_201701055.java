/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_ListAirport_201701055;

import javax.swing.JTextArea;

/**
 *
 * @author franc
 */
public class Lista_Eq_201701055 extends Lista_CD_201701055{
    public Lista_Eq_201701055() {
		super();
	}
	
	public void setMaleta(int numero) {
		ingresar(numero);
	}

	
	public void eliminarMaleta(int cantidad) {
		while(cantidad!=0) {
			eliminar(1);
			cantidad--;
		}
	}
	
	public int getInicio() {
		if(ini!= null)
		return (int) ini.getObjeto();
		else
			return 0;
	}
	
	public int getFinal() {
		return (int) fin.getObjeto();
	}
	
	public void imprimirMaleta(JTextArea txt) {
		Nodo_201701055 temp = ini;
		if(ini!=null) {
			txt.append("\nINICIO: " + getInicio());
			txt.append("\nFIN: " + getFinal()) ;
		do {
			txt.append("\nMALETA: " + temp.getObjeto());			
			temp = temp.sig;
		}
		while(temp!=ini);
		}	
	}
}
