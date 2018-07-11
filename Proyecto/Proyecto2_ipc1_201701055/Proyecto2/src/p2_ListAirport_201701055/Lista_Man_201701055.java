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
public class Lista_Man_201701055 extends Lista_S_201701055{
    private boolean est;
	
	public Lista_Man_201701055() {
		super();
	}
	
	public void setMantenimiento(int numero, boolean estado, Avion_201701055 avion) {
		Mantenimiento_201701055 mantenimiento = new Mantenimiento_201701055(numero,estado,avion);
	}
	
	public void addAviones(Avion_201701055 avion) {
		for(int i=0 ; i<getTamano();i++) {
			est=false;
			Mantenimiento_201701055 mantenimiento = (Mantenimiento_201701055)getComponente(i);
			if(mantenimiento.getEstatus()) {
				mantenimiento.setEstatus(false);
				mantenimiento.setAvion(avion);
				est=true;
				return;
			}
			else {
				est=false;
			}
		}
	}	
	
	public void iniciarLista(int numero) {
		Mantenimiento_201701055 nuevo = new Mantenimiento_201701055(numero,true,null);
		insertarInicio(nuevo);
	}
	
	public void disminuirTurno() {
		for(int i=0 ; i<getTamano();i++) {
			Mantenimiento_201701055 m = (Mantenimiento_201701055)getComponente(i);
			if(m.getAvion()!=null)
			m.getAvion().setTurnosMantenimiento(m.getAvion().getTurnosMantenimiento()-1);
		}
	}
	
	public void finalizaMantenimiento() {
		for(int i=0 ; i<getTamano();i++) {
			Mantenimiento_201701055 m = (Mantenimiento_201701055)getComponente(i);
			if(m.getAvion()!=null) {
				if(m.getAvion().getTurnosMantenimiento()<=0) {
					m.setAvion(null);
					m.setEstatus(true);
				}
			}
		}
	}
	
	public boolean getEstado() {
		return est;
	}
			
	public void imprimirListaMantenimiento(JTextArea txt) {
		for(int i=0 ; i<getTamano();i++) {
			Mantenimiento_201701055 m = (Mantenimiento_201701055)getComponente(i);
			if(m.getAvion()==null) {
				txt.append("\nESTACION " + (i+1));
				txt.append("\n	ESTADO: " + m.getDisponible() + "\n");
			}
			else {
				txt.append("\nESTACION " + (i+1));
				txt.append("\n	ESTADO: " + m.getDisponible() + m.getAvion());
			}
		}
	}
}
