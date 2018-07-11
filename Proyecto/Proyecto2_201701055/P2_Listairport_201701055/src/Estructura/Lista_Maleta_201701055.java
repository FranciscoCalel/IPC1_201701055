/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import javax.swing.JTextArea;

/**
 *
 * @author franc
 */
public class Lista_Maleta_201701055 extends Lista_CD_201701055{
    public Lista_Maleta_201701055() {
		super();
	}
	
	public void setMaleta(int numero) {
		ingresar(numero);
	}
	
	public int getInicio() {
		if(inicio!= null)
		return (int) inicio.getObjeto();
		else
			return 0;
	}
	
	public int getFinal() {
		return (int) fin.getObjeto();
	}
	
	public void eliminarMaleta(int cantidad) {
		while(cantidad!=0) {
			eliminar(1);
			cantidad--;
		}
	}
	
	public void printMaletas(JTextArea txt) {
		Nodo_201701055 temp = inicio;
		if(inicio!=null) {
			txt.append("\nINICIO: " + getInicio());
			txt.append("\nFIN: " + getFinal()) ;
		do {
			txt.append("\nMALETA: " + temp.getObjeto());			
			temp = temp.siguiente;
		}
		while(temp!=inicio);
		}	
	}
    
    
}
