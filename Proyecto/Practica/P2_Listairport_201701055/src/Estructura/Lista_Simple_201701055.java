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
public class Lista_Simple_201701055 extends Lista_201701055{
    public Lista_Simple_201701055() {
		super();
	}
	
	public void display() {
		System.out.println("Lista Simple");
	}
	
	public void insertarInicio(Object objeto) {
		Nodo_201701055 nodo = new Nodo_201701055(objeto,inicio);		
		inicio = nodo;
		if(fin == null) {
			fin = inicio;
		}		
		size++;
	}	
	
	public Object getElemento(int indice) {
		indice = size - indice-1;
		int cont = 0;
		Nodo_201701055 temporal = inicio;
		
		while(cont< indice) {
			temporal = temporal.getSiguiente();
			cont++;
		}
		return temporal.getObjeto();
	}
	
	public void eliminar() {
		
	}
	
	public void eliminarElemento(int indice) {
		indice = size - indice-1;
		if(indice==0) {
			inicio = inicio.siguiente;
		}
		else {
			int cont =0;
			Nodo_201701055 temp = inicio;
			while(cont< indice-1) {
				temp = temp.siguiente;
				cont++;
			}
			temp.setSiguiente(temp.siguiente.siguiente);
		}
		size--;
	}	
}
