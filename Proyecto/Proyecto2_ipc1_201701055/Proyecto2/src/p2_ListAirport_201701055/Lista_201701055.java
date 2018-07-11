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
public abstract class Lista_201701055 {
    
	public Nodo_201701055 ini, fin;
	int tamano;
	
	public Lista_201701055() {
		ini = fin = null;
		tamano = 0;
	}
        
        public Nodo_201701055 getInicioNodo(){
            return ini;
        }
        
        public abstract void display();
        
        public boolean estaVacia() {
		return null == ini;
	}
	
	public void insertarAlFinal(Object o) {
		if(estaVacia()) {
			ini = new Nodo_201701055(o);
			fin =ini;
		}
		else {
			fin = fin.sig = new Nodo_201701055(o);
		}
		tamano++;
	}
	
	public Object removerAlInicio() {
		Object aux = ini.getObjeto();
		ini = ini.sig;
		if(ini==null) {
			fin=null;
		}		
		tamano--;
		return aux;
	}
	
	public void listar() {
		Nodo_201701055 temp = ini;
		while(temp!=null) {
			System.out.println(temp.getObjeto());
			temp = temp.sig;
		}
	}
        public Object getIni() {
		return ini.getObjeto();
	}
	
	public int getTamano() {
		return tamano;
        }
    
}
