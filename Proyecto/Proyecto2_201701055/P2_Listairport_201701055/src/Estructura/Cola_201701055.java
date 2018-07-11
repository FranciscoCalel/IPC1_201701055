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
public class Cola_201701055 extends Lista_201701055{
    int tam=size;
	
	public Cola_201701055() {
		super();		
		tam=size;
                
	}
		
	public void display() {
		
	}
			
	public void insertar(Object objeto) {
		
		if(estaVacia()) {
			inicio = new Nodo_201701055(objeto);
			fin=inicio;
		}
		else {
			fin = fin.siguiente = new Nodo_201701055(objeto);
		}		
		tam++; //T
	}
	
	public Object quitar() {
		if(estaVacia()) {
			return null;
		}		
		Object aux = inicio.getObjeto();
		inicio = inicio.siguiente;
		tam--; //T
		return aux;
	}
	
	public Object inicioCola() {
		if(inicio==null) {
			return null;
		}		
		return inicio.getObjeto();
			
	}
	
	public Object getElemento(int indice) {
		indice = tam-indice-1;
		int cont =0;
		Nodo_201701055 temp = inicio;
		
		while(cont<indice) {
			temp = temp.getSiguiente();
			cont++;
		}
		return temp.getObjeto();
	}
	
	public int tamCola() {
		return tam;
	}
    
}
