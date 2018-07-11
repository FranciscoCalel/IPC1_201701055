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
public class ListaD_201701055 extends Lista_201701055{
    public ListaD_201701055() {
		super();
	}
	
	public void display() {
		
	}
	
	public void insertarInicio(Object objeto) {
		if(inicio==null) {
			inicio = new Nodo_201701055(objeto,null,null);
			fin = inicio;
		}
		else {
			Nodo_201701055 nuevo = new Nodo_201701055(objeto,null,inicio);
			inicio.setAnterior(nuevo);
			inicio = nuevo;
		}
		size++;
	}
	
	public void insertarFin(Object objeto) {
		if(inicio ==null) {
			inicio = new Nodo_201701055(objeto,null,null);
			fin=inicio;
		}
		else {
			Nodo_201701055 nuevo = new Nodo_201701055(objeto,fin,null);
			fin.setSiguiente(nuevo);
			fin = nuevo;
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
	
	public void eliminarElemento(int indice) {
		indice = size - indice-1;
		if(indice==0) {
			inicio = inicio.getSiguiente();
		}
		else {
			int cont =0;
                        Nodo_201701055 temp = inicio;
			while(cont< indice-1) {
				temp = temp.getSiguiente();
				cont++;
			}
			temp.setSiguiente(temp.getSiguiente());
		}
		size--;
	}
    
}
