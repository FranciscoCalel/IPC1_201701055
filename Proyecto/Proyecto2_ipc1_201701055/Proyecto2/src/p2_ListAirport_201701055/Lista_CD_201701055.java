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
public class Lista_CD_201701055 extends Lista_201701055{
   
    public Lista_CD_201701055() {
	super();		
    }
	
    public void ingresar(Object objeto) {
	Nodo_201701055 nuevo = new Nodo_201701055(objeto);
		
        if(ini==null) {			
            ini = nuevo;
            ini.sig=ini;
            nuevo.ant=fin;
            fin = nuevo;			
	}
	else {
            fin.sig=nuevo;
            nuevo.sig=ini;
            nuevo.ant=fin;	
            fin = nuevo;
            ini.ant=fin;
	}
    }
			
    public void eliminar(int a) {
	if(ini!=null) {
            if(a>0) {
                int cont = 1;
                Nodo_201701055 aux =ini;				
		while((aux.getSig()!=ini)&& (cont<a)){
                    cont ++;
                    aux = aux.getSig();
		}
		if(cont==1) {
                    if(aux.getSig()==ini) {
			ini=null;
                    }
                    else {
			Nodo_201701055 ant = aux.getAnt();
			ant.setSig(aux.getSig());
			aux=aux.getSig();
			aux.setAnt(ant);
			ini=aux;
                    }
		}
		else {
                    Nodo_201701055 ant = aux.getAnt();
                    aux.setAnt(null);
                    ant.setSig(aux.getSig());
                    aux=aux.getSig();
                    aux.setAnt(ant);
		}
            }
	}
    }
	
    public void listar() {
	Nodo_201701055 temp = ini;		
	do {
            System.out.println(temp.getObjeto());
            temp = temp.sig;
	}
	while(temp!=ini);
    }
    public void display() {
		
    }
}
