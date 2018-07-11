/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

/**
 *
 * @author franc
 */
public class Nodo_201701055 {
    protected Nodo_201701055 siguiente;
	protected Nodo_201701055 anterior;
	private Object objeto;
	
	public Nodo_201701055(Object objeto, Nodo_201701055 anterior, Nodo_201701055 siguiente) {//d
		this.siguiente=siguiente;
		this.objeto=objeto;
		this.anterior=anterior;
	}
	
	public Nodo_201701055(Object objeto) {	//c
		this.objeto=objeto;
		setSiguiente(null);
	}
	public Nodo_201701055(Object objeto, Nodo_201701055 siguiente) { //S
		this.siguiente=siguiente;
		this.objeto=objeto;
	}

	public Nodo_201701055 getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo_201701055 siguiente) {
		this.siguiente = siguiente;
	}

	public Nodo_201701055 getAnterior() {
		return anterior;
	}

	public void setAnterior(Nodo_201701055 anterior) {
		this.anterior = anterior;
	}

	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto=objeto;
	}	
    
}
