/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_ListAirport_201701055;

/**
 *
 * @author franc
 */
public class Pila_201701055 extends Lista_201701055{
    private int tam;
	
	public Pila_201701055() {
		super();
		tam = 0;
	}
	
	public void display() {
		
	}
	
	public int getTam() {
		return tam;
	}
	
	public void insertar(Object o) {
		Nodo_201701055 nuevo = new Nodo_201701055(o);
		if(estaVacia()) {
			ini = nuevo;			
		}
		else {
			nuevo.setSig(ini);
			ini = nuevo;
		}
		tam++;
	}
	
	public void eliminar() {
		if(!estaVacia()) {
			ini = ini.getSig();
			tam--;
		}
	}
}
