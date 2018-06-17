/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_ipc1_201701055;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author franc
 */
public class Tablero extends JPanel{

    public int fichas = 6;
    public Integer tam;
    public JPanel fondo;
    public JLabel[][] vecG;
    public Integer[][] vecL;

    public boolean mago_1 = true;
    public boolean mago_2 = true;
    public boolean princesa_1 = true;
    public boolean princesa_2 = true;
    public boolean caba_1 = true;
    public boolean caba_2 = true;

    public Tablero(int tam, JPanel Fondo) {
        this.tam = tam;
        this.fondo = Fondo;
        mostrartablero(tam);
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public void mostrartablero(int tam) {
        this.tam = tam;
        vecG = new JLabel[tam][tam];
        vecL = new Integer[tam][tam];
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                vecG[i][j] = new JLabel();
                Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
                vecG[i][j].setBorder(border);
                add(vecG[i][j]);
                vecL[i][j] = 2;
            }
        }
    }

    public void inFichas(int tam) {
        while (fichas != 0) {
            int fila = (int) Math.floor(Math.random() * (tam));
            int columna = (int) Math.floor(Math.random() * (tam));
            if (vecL[fila][columna] == 2 && mago_1) {
                vecG[fila][columna].setIcon(new ImageIcon(getClass().getResource("/imagenes/mago.png")));
                vecG[fila][columna].setHorizontalAlignment(JLabel.CENTER);
                vecG[fila][columna].setVerticalAlignment(JLabel.CENTER);
                vecL[fila][columna] = 31;
                mago_1 = false;
                fichas--;
            } else if (vecL[fila][columna] == 2 && mago_2) {
                vecG[fila][columna].setIcon(new ImageIcon(getClass().getResource("/imagenes/mago1.png")));
                vecG[fila][columna].setHorizontalAlignment(JLabel.CENTER);
                vecG[fila][columna].setVerticalAlignment(JLabel.CENTER);
                vecL[fila][columna] = 32;
                mago_2 = false;
                fichas--;
            } else if (vecL[fila][columna] == 2 && princesa_1) {
                vecG[fila][columna].setIcon(new ImageIcon(getClass().getResource("/imagenes/princesa.png")));
                vecG[fila][columna].setHorizontalAlignment(JLabel.CENTER);
                vecG[fila][columna].setVerticalAlignment(JLabel.CENTER);
                vecL[fila][columna] = 11;
                princesa_1 = false;
                fichas--;
            } else if (vecL[fila][columna] == 2 && princesa_2) {
                vecG[fila][columna].setIcon(new ImageIcon(getClass().getResource("/imagenes/princesa1.png")));
                vecG[fila][columna].setHorizontalAlignment(JLabel.CENTER);
                vecG[fila][columna].setVerticalAlignment(JLabel.CENTER);
                vecL[fila][columna] = 12;
                princesa_2 = false;
                fichas--;
            } else if (vecL[fila][columna] == 2 && caba_1) {
                vecG[fila][columna].setIcon(new ImageIcon(getClass().getResource("/imagenes/caballero.png")));
                vecG[fila][columna].setHorizontalAlignment(JLabel.CENTER);
                vecG[fila][columna].setVerticalAlignment(JLabel.CENTER);
                vecL[fila][columna] = 21;
                caba_1 = false;
                fichas--;
            } else if (vecL[fila][columna] == 2 && caba_2) {
                vecG[fila][columna].setIcon(new ImageIcon(getClass().getResource("/imagenes/caballero1.png")));
                vecG[fila][columna].setHorizontalAlignment(JLabel.CENTER);
                vecG[fila][columna].setVerticalAlignment(JLabel.CENTER);
                vecL[fila][columna] = 22;
                caba_2 = false;
                fichas--;
            }
        }
    }
}
