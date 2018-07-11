/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import javax.swing.JTextArea;
import p_listairport_201701055.*;


/**
 *
 * @author franc
 */
public class Lista_Mantenimiento_201701055 extends Lista_Simple_201701055{
    private boolean x;
	
	public Lista_Mantenimiento_201701055() {
		super();
	}
	
	public void setMantenimiento(boolean estado, Avion_201701055 avion) {
		          Mantenimiento_201701055 nuevo = new Mantenimiento_201701055(estado,avion);
	}
	
	public void addAviones(Avion_201701055 avion) {
		for(int i=0 ; i<getSize();i++) {
			x=false;
			Mantenimiento_201701055 m = (Mantenimiento_201701055)getElemento(i);
			if(m.getEstado()) {
				m.setEstado(false);
				m.setAvion(avion);
				x=true;
				return;
			}
			else {
				x=false;
			}
		}
	}	
	
	public void iniciarLista() {
		Mantenimiento_201701055 nuevo = new Mantenimiento_201701055(true,null);
		insertarInicio(nuevo);
	}
	
	public void bajarTurno() {
		for(int i=0 ; i<getSize();i++) {
			Mantenimiento_201701055 m = (Mantenimiento_201701055)getElemento(i);
			if(m.getAvion()!=null)
			m.getAvion().setTurnosMantenimiento(m.getAvion().getTurnosMantenimiento()-1);
		}
	}
	
	public void terminaMantenimiento() {
		for(int i=0 ; i<getSize();i++) {
			Mantenimiento_201701055 m = (Mantenimiento_201701055)getElemento(i);
			if(m.getAvion()!=null) {
				if(m.getAvion().getTurnosMantenimiento()<=0) {
					m.setAvion(null);
					m.setEstado(true);
				}
			}
		}
	}
	
	public boolean getEstado() {
		return x;
	}
        public boolean estaVacio() {
		compruebaMantenimiento();
		return estaVacio;
	}
	boolean estaVacio=false;
        
        public void compruebaMantenimiento() {
		if(inicio!=null) {
			Nodo_201701055 aux = inicio;
			while(aux!=null) {
				Mantenimiento_201701055 m = (Mantenimiento_201701055)aux.getObjeto();
				if(m.getEstado()) {
					estaVacio=true;
				}
				aux = aux.siguiente;
			}
		}
	}
			
	public void printListaMantenimiento(JTextArea txt) {
		for(int i=0 ; i<getSize();i++) {
			Mantenimiento_201701055 m = (Mantenimiento_201701055)getElemento(i);
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
