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
public class Lista_CD_201701055 extends Lista_201701055{
    public Lista_CD_201701055() {
		super();		
	}
	
	public void display() {
		
	}
	
	public void ingresar(Object objeto) {
		Nodo_201701055 nuevo = new Nodo_201701055(objeto);
		
		if(inicio==null) {			
			inicio = nuevo;
			inicio.siguiente=inicio;
			nuevo.anterior=fin;
			fin = nuevo;			
		}
		else {
			fin.siguiente=nuevo;
			nuevo.siguiente=inicio;
			nuevo.anterior=fin;	
			fin = nuevo;
			inicio.anterior=fin;
		}
	}
			
	public void eliminar(int p) {
		if(inicio!=null) {
			if(p>0) {
				int cont = 1;
				Nodo_201701055 aux =inicio;				
				while((aux.getSiguiente()!=inicio)&& (cont<p)){
					cont ++;
					aux = aux.getSiguiente();
				}
				if(cont==1) {
					if(aux.getSiguiente()==inicio) {
						inicio=null;
					}
					else {
						Nodo_201701055 ant = aux.getAnterior();
						ant.setSiguiente(aux.getSiguiente());
						aux=aux.getSiguiente();
						aux.setAnterior(ant);
						inicio=aux;
					}
				}
				else {
					Nodo_201701055 ant = aux.getAnterior();
					aux.setAnterior(null);
					ant.setSiguiente(aux.getSiguiente());
					aux=aux.getSiguiente();
					aux.setAnterior(ant);
				}
			}
		}
	}
	
	public void listar() {
		Nodo_201701055 temp = inicio;		
		do {
			System.out.println(temp.getObjeto());
			temp = temp.siguiente;
		}
		while(temp!=inicio);
	}
    
}
