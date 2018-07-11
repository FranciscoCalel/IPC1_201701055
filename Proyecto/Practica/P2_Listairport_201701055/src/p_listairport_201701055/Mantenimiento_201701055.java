/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_listairport_201701055;

/**
 *
 * @author franc
 */
public class Mantenimiento_201701055 {
    private boolean estado;
	private Avion_201701055 avion;
	
	public Mantenimiento_201701055(boolean estado, Avion_201701055 avion) {
		this.estado=estado;
		this.avion=avion;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Avion_201701055 getAvion() {
		return avion;
	}
	
	
	public void setAvion(Avion_201701055 avion) {
		this.avion = avion;
	}
	
	public String getDisponible() {
		if(getEstado()) {
			return "Disponible";
		}
		else {
			return "Ocupado";
		}
	}
    
}
