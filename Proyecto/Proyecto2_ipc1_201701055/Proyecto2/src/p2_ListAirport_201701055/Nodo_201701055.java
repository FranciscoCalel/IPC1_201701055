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
public class Nodo_201701055 {
        public Nodo_201701055 sig;
	public Nodo_201701055 ant;
	public Object objeto;
	
	public Nodo_201701055(Object objeto, Nodo_201701055 ant, Nodo_201701055 sig) {
		this.sig=sig;
		this.objeto=objeto;
		this.ant=ant;
	}
        
        public Nodo_201701055(Object objeto, Nodo_201701055 sig) { 
		this.sig=sig;
		this.objeto=objeto;
	
        }
	
	public Nodo_201701055(Object objeto) {
		this.objeto=objeto;
		setSig(null);
	}


    /**
     * @return the sig
     */
    public Nodo_201701055 getSig() {
        return sig;
    }

    /**
     * @param sig the sig to set
     */
    public void setSig(Nodo_201701055 sig) {
        this.sig = sig;
    }

    /**
     * @return the ant
     */
    public Nodo_201701055 getAnt() {
        return ant;
    }

    /**
     * @param ant the ant to set
     */
    public void setAnt(Nodo_201701055 ant) {
        this.ant = ant;
    }

    /**
     * @return the objeto
     */
    public Object getObjeto() {
        return objeto;
    }

    /**
     * @param objeto the objeto to set
     */
    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

}
