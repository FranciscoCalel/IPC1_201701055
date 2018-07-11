/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import javax.swing.JTextArea;
import p_listairport_201701055.Avion_201701055;

/**
 *
 * @author franc
 */
public class Lista_Avion_201701055 extends ListaD_201701055 {

    public Lista_Avion_201701055() {
        super();
    }

    public void setAvion(int numero, String tipo, int pasajeros, int turnosDesabordaje, int turnosMantenimiento) {
        Avion_201701055 nuevo = new Avion_201701055(numero, tipo, pasajeros, turnosDesabordaje, turnosMantenimiento);
        insertarInicio(nuevo);
    }

    public void setAvion(Avion_201701055 nuevo) {
        insertarFin(nuevo);
    }

    public Avion_201701055 getAvion(int index) {
        Avion_201701055 a = (Avion_201701055) getElemento(index);
        return a;
    }

    public void bajaTurno() {
        for (int i = 0; i < getSize(); i++) {
            Avion_201701055 a = (Avion_201701055) getElemento(i);
            a.setTurnosDesabordaje(a.getTurnosDesabordaje() - 1);
        }
    }

    public void eliminaAvion(Cola_Avion_201701055 cAvion) {
        for (int i = 0; i < getSize(); i++) {
            Avion_201701055 a = (Avion_201701055) getElemento(i);
            if (a.getTurnosDesabordaje() <= 0) {
                eliminarElemento(i);
                cAvion.setAvion(a);
            }
        }

    }

    public void printAviones(JTextArea txt) {
        for (int i = 0; i < getSize(); i++) {
            Avion_201701055 a = (Avion_201701055) getElemento(i);
            txt.append("\nAVION: " + a.getNumero() + "\n");
            txt.append("	TIPO: " + a.getTipo() + "\n 	PASAJEROS: " + a.getPasajeros() + "\n 	TURNOS DESABORDAJE: " + a.getTurnosDesabordaje() + "\n 	TURNOS MANTENIMIENTO " + a.getTurnosMantenimiento() + "\n");
        }
    }
}
