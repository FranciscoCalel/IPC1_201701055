/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import javax.swing.JTextArea;
import p_listairport_201701055.*;

/**
 *
 * @author franc
 */
public class Cola_Pasajero_201701055 extends Cola_201701055 {

    public Cola_Pasajero_201701055() {
        super();
    }

    public void setPasajero(int numero, int maletas, int documentos, int turnosRegistro) {
        Pasajero_201701055 pasajero = new Pasajero_201701055(numero, maletas, documentos, turnosRegistro);
        insertar(pasajero);
    }

    public void setPasajero(Pasajero_201701055 nuevo) {
        insertar(nuevo);
    }

    public void eliminarPasajero() {
        quitar();
    }

    public int getMaletas() {
        if (tamCola() != 0) {
            Pasajero_201701055 p = (Pasajero_201701055) getElemento(tamCola() - 1);
            return p.getMaletas();
        }
        return 0;
    }

    public void printPasajero(JTextArea txt) {
        for (int i = tamCola() - 1; i >= 0; i--) {
            Pasajero_201701055 p = (Pasajero_201701055) getElemento(i);
            txt.append("\nPASAJERO: " + p.getNumero() + "\n");
            txt.append("	MALETAS: " + p.getMaletas() + "\n 	DOCUMENTOS: " + p.getDocumentos() + "\n");
        }
    }
}
