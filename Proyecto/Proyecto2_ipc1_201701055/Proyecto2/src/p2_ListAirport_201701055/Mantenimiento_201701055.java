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
public class Mantenimiento_201701055 {
    private boolean estatus;
    private Avion_201701055 avion;
    private int numero;
	
	public Mantenimiento_201701055(int numero, boolean estado, Avion_201701055 avion) {
		this.estatus=estado;
		this.avion=avion;
                this.numero = numero;
	}

	public boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}
        public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero=numero;
	}

	public Avion_201701055 getAvion() {
		return avion;
	}
	
	
	public void setAvion(Avion_201701055 avion) {
		this.avion = avion;
	}
	
	public String getDisponible() {
		if(getEstatus()) {
			return "Disponible";
		}
		else {
			return "Ocupado";
		}
	}
}
