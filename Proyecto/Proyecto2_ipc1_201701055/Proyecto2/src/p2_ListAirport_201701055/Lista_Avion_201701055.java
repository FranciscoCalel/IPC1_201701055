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
public class Lista_Avion_201701055 extends ListaD_201701055{
    
	
	public Lista_Avion_201701055() {
		super();
	}	
	
	public void setAvion(int numero, String tipo, int pasajeros, int turnosDesabordaje, int turnosMantenimiento) {
		Avion_201701055 nuevo = new Avion_201701055(numero,tipo,pasajeros,turnosDesabordaje,turnosMantenimiento);		
		insertarInicio(nuevo);
	}
	
	public void setAvion(Avion_201701055 nuevo) {
		insertarFinal(nuevo);
	}
	
	public Avion_201701055 getAvion(int index) {
		Avion_201701055 avion = (Avion_201701055)obtenerComponente(index);
		return avion;
	}
        
        public void eliminaAvion(Cola_Avion_201701055 colaAvion) {
            for(int i = 0; i<getTamano(); i++) {
		Avion_201701055 avion = (Avion_201701055)obtenerComponente(i);
		if(avion.getTurnosDesabordaje()<=0) {
                    eliminarComponente(i);
                    colaAvion.setAvion(avion);
		}
            }
	}
	
	public void bajaTurno() {
		for(int i=0 ; i<getTamano();i++) {
			Avion_201701055 avion = (Avion_201701055)obtenerComponente(i);
			avion.setTurnosDesabordaje(avion.getTurnosDesabordaje()-1);
		}
	}
        
        public Nodo_201701055 getPrimero() {
            return ini;
	}
	
	public void imprimirAviones(JTextArea txt) {
		for(int i=0 ; i<getTamano(); i++) {
			Avion_201701055 avion = (Avion_201701055)obtenerComponente(i);
			txt.append("\nAVION: " + avion.getNumero() + "\n");
			txt.append("	TIPO: " + avion.getTipo() + "\n 	PASAJEROS: " + avion.getPasajeros()  + "\n 	TURNOS DESABORDAJE: " + avion.getTurnosDesabordaje() + "\n 	TURNOS MANTENIMIENTO " + avion.getTurnosMantenimiento() + "\n");		
		}
	}
}
