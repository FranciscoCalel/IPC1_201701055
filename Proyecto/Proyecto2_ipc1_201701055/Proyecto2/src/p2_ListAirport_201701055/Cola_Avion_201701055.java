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
public class Cola_Avion_201701055 extends Cola_201701055{
    public Cola_Avion_201701055() {
		super();
	}
	
	public void setAvion(int num, String tipo, int pasajeros, int turnosDesabordaje, int turnosMantenimiento) {
		Avion_201701055 nuevo = new Avion_201701055(num,tipo,pasajeros,turnosDesabordaje,turnosMantenimiento);		
		insertar(nuevo);
	}
	
	public void setAvion(Avion_201701055 nuevo) {		
			insertar(nuevo);									
	}	
	
	public void pasarPorMantenimiento(Lista_Man_201701055 lMantenimiento) {
		if(inicioCola()==null) 
			return ;
		
		lMantenimiento.addAviones((Avion_201701055) inicioCola());
		if(lMantenimiento.getEstado()) {
			saleAvion();
		}		
	}
	
	public void saleAvion() {
		quitar();
	}
	
	public void imprimirColaAviones(JTextArea txt) {
		for (int i = tamanoCola()-1; i >= 0; i--) {
			Avion_201701055 a = (Avion_201701055)obtenerComponente(i);			
			txt.append("	AVION: " + a.getNumero() + "\n	TIPO: " + a.getTipo() + "\n 	PASAJEROS: " + a.getPasajeros()  + "\n 	TURNOS DESABORDAJE: " + a.getTurnosDesabordaje() + "\n 	TURNOS MANTENIMIENTO " + a.getTurnosMantenimiento() + "\n");
		}
	}
}
