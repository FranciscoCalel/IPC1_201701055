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
public class Pasajero_201701055 {
    
    private int maletas,documentos,numero, turnos;
	
	public Pasajero_201701055(int numero,int maletas, int documentos, int turnos) {
		this.numero=numero;
		this.maletas=maletas;
		this.documentos=documentos;
                this.turnos = turnos;
	}

	public int getMaletas() {
		return maletas;
	}

	public void setMaletas(int maletas) {
		this.maletas = maletas;
	}
	
	public int getNumero(){
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero=numero;
	}
	public int getDocumentos() {
		return documentos;
	}

	public void setDocumentos(int documentos) {
		this.documentos = documentos;
	}
	
	public String toString() {
		return " " + getNumero();				
	}

    /**
     * @return the turnos
     */
    public int getTurnos() {
        return turnos;
    }

    /**
     * @param turnos the turnos to set
     */
    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }
}
