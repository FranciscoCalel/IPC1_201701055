/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_listairport_201701055;
import Estructura.*;
/**
 *
 * @author franc
 */
public class Escritorio_201701055 {
    private boolean estado;
	private Pasajero_201701055 pasajero;
	private char nombre;
	private Cola_Pasajero_201701055 colaPasajero;	
	private Pila_201701055 pila;
	
	public Escritorio_201701055(boolean estado, Pasajero_201701055 pasajero,char nombre, Cola_Pasajero_201701055 colaPasajero, Pila_201701055 pila) {
		this.estado=estado;
		this.pasajero=pasajero;
		this.nombre=nombre;
		this.colaPasajero=colaPasajero;		
		this.pila=pila;
	}

	public boolean getEstado() {
		return estado;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Pila_201701055 getPila() {
		return pila;
	}
	
	public void setPila(Pila_201701055 pila) {
		this.pila=pila;
	}
	
	public Cola_Pasajero_201701055 getColaPasajero() {
		return colaPasajero;
	}
	
	public void setColaPasajero(Cola_Pasajero_201701055 colaPasajero) {
		this.colaPasajero=colaPasajero;
	}
	
	public char getNombre() {
		return nombre;
	}
	
	public void setNombre(char nombre) {
		this.nombre=nombre;
	}
	public Pasajero_201701055 getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero_201701055 pasajero) {
		this.pasajero = pasajero;
	}
	
	public String getDisponible() {
		if(getEstado()) {
			return "Disponible";
		}
		else {
			return "Ocupado";
		}
	}
}
