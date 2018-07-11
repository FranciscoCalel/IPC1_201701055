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
public class Cola_Pasajero_201701055 extends Cola_201701055{
    
    public Cola_Pasajero_201701055() {
	super();
    }
		
    public int getMaletas() {
	if(tamanoCola()!=0) {
            Pasajero_201701055 p = (Pasajero_201701055)obtenerComponente(tamanoCola()-1);
            return p.getMaletas();
	}
        return 0;
    }
        
    public void setPasajero(int numero,int maletas, int documentos, int turnos) {
	Pasajero_201701055 pasajero = new Pasajero_201701055(numero,maletas,documentos,turnos);
	insertar(pasajero);
    }
	
    public void setPasajero(Pasajero_201701055 nuevo) {
	insertar(nuevo);
    }	
	
    public void eliminarPasajero() {
	quitar();
    }

	
    public void imprimirPasajero(JTextArea txt) {
	for (int i = tamanoCola()-1; i >= 0; i--) {
            Pasajero_201701055 p = (Pasajero_201701055)obtenerComponente(i);
            txt.append("\nPASAJERO: " + p.getNumero() +  "\n");
            txt.append("	MALETAS: " + p.getMaletas() + "\n 	DOCUMENTOS: " + p.getDocumentos() + "\n"+ "\n 	TURNOS REGISTRO: " + p.getTurnos() + "\n");
	}
    }
}
