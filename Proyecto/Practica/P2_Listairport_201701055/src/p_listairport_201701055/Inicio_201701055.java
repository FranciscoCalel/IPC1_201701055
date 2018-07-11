/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_listairport_201701055;

import Estructura.Cola_Avion_201701055;
import Estructura.Cola_Pasajero_201701055;
import Estructura.Lista_Avion_201701055;
import Estructura.Lista_Maleta_201701055;
import Estructura.Lista_Mantenimiento_201701055;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Estructura.*;

/**
 *
 * @author franc
 */
public class Inicio_201701055 extends JFrame implements ActionListener {

    private JPanel panelFunciones, panelConsola;//1
    private JTextField cAviones, cEstaciones, cEscritorios;//2
    private JButton bEmpezar, bPasarTurno;//3
    private JTextArea aConsola;//4
    private Lista_Avion_201701055 lAvion;//5
    private Cola_Pasajero_201701055 cPasajero;//6
    private Lista_Maleta_201701055 lMaletas;//7
    private Lista_Escritorio_201701055 lEscritorio;//8
    private Cola_Avion_201701055 cAvion;//9
    private Lista_Mantenimiento_201701055 lMantenimiento;//10
    private int cantAviones, turno = 0, n = 1, contador, cantEstaciones;
    private int pasajeros, desabordaje, mantenimiento, maletas, documentos, turnosRegistro, cantEscritorios;
    public static final String pequeño = "Pequeño", mediano = "Mediano", grande = "Grande";
    public static final int salidaPasajero = 5;
    private String tam;

    public Inicio_201701055() {
        super("LISTAIRPORT");
        init();
    }

    public void init() {
        this.getContentPane().setBackground(Color.white);

        setLayout(null);
        setSize(700, 600);
        add(panelFunciones());
        add(panelConsola());
        setVisible(true);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public JPanel panelFunciones() {
        panelFunciones = new JPanel();
        panelFunciones.setBounds(0, 0, 250, 650);
        panelFunciones.setLayout(null);
        panelFunciones.setVisible(true);

        JLabel labelAviones = new JLabel("No. Aviones");
        labelAviones.setBounds(90, 70, 170, 20);
        labelAviones.setVisible(true);
        panelFunciones.add(labelAviones);

        JLabel labelEstaciones = new JLabel("No. de Estaciones");
        labelEstaciones.setBounds(70, 120, 170, 20);
        labelEstaciones.setVisible(true);
        panelFunciones.add(labelEstaciones);

        JLabel labelEscritorios = new JLabel("Cantidad de Escritorios");
        labelEscritorios.setBounds(40, 170, 170, 20);
        labelEscritorios.setVisible(true);
        panelFunciones.add(labelEscritorios);

        cAviones = new JTextField();
        cAviones.setBounds(100, 100, 40, 20);
        cAviones.setVisible(true);
        panelFunciones.add(cAviones);

        cEstaciones = new JTextField();
        cEstaciones.setBounds(100, 150, 40, 20);
        cEstaciones.setVisible(true);
        panelFunciones.add(cEstaciones);

        cEscritorios = new JTextField();
        cEscritorios.setBounds(210, 170, 40, 20);
        cEscritorios.setVisible(true);
        panelFunciones.add(cEscritorios);

        bEmpezar = new JButton("Inicio");
        bEmpezar.setBounds(40, 220, 85, 25);
        bEmpezar.setVisible(true);
        bEmpezar.addActionListener(this);
        panelFunciones.add(bEmpezar);

        bPasarTurno = new JButton("Turno");
        bPasarTurno.setBounds(160, 220, 85, 25);
        bPasarTurno.setVisible(true);
        bPasarTurno.addActionListener(this);
        panelFunciones.add(bPasarTurno);

        return panelFunciones;
    }

    public JPanel panelConsola() {
        panelConsola = new JPanel();
        panelConsola.setBounds(270, 0, 500, 650);
        panelConsola.setLayout(null);
        panelConsola.setVisible(true);

        aConsola = new JTextArea();
        aConsola.setBackground(Color.white);
        aConsola.setForeground(Color.black);
        aConsola.setEditable(false);

        JScrollPane scroll = new JScrollPane(aConsola);
        scroll.setBounds(10, 50, 380, 480);
        scroll.setVisible(true);
        panelConsola.add(scroll);

        return panelConsola;
    }
    boolean iniciado = false;

    public void determinaTam() {
        int x = (int) (Math.random() * 3 + 1);
        if (x == 1) {
            tam = pequeño;
            desabordaje = 1;
            pasajeros = (int) Math.floor(Math.random() * (10 - 5 + 1) + 5);
            mantenimiento = (int) (Math.random() * 3 + 1);
        } else if (x == 2) {
            tam = mediano;
            desabordaje = 2;
            pasajeros = (int) Math.floor(Math.random() * (25 - 15 + 1) + 15);
            mantenimiento = (int) Math.floor(Math.random() * (4 - 2 + 1) + 2);
        } else if (x == 3) {
            tam = grande;
            desabordaje = 3;
            pasajeros = (int) Math.floor(Math.random() * (40 - 30 + 1) + 30);
            mantenimiento = (int) Math.floor(Math.random() * (6 - 3 + 1) + 3);
        }
    }

    public void agregarAviones() {
        if (cantAviones > 0) {
            determinaTam();
            lAvion.setAvion(n, tam, pasajeros, desabordaje, mantenimiento);
            n++;
            cantAviones--;
            agregarPasajeros();
            agregarMaletas();
        }
    }

    public void agregarEstaciones() {
        while (cantEstaciones != 0) {
            lMantenimiento.iniciarLista();
            cantEstaciones--;
        }
    }

    public void agregarEscritorios() {
        while (cantEscritorios != 0) {
            lEscritorio.iniciarLista();
            cantEscritorios--;
        }
    }

    public void sacaPasajeros(int cantidad) {
        if (cantidad > 0) {
            //lMaletas.eliminarMaleta(cPasajero.getMaletas());
            if (lEscritorio.determinaEspacio()) {
                lEscritorio.agregarPasajerosCola((Pasajero_201701055) cPasajero.quitar());
            } else {
                lMaletas.eliminarMaleta(cPasajero.getMaletas());
                cPasajero.eliminarPasajero();
            }
            sacaPasajeros(cantidad - 1);
        }
    }

    public void agregarPasajeros() {
        contador += pasajeros;
        for (int i = (contador - pasajeros + 1); i < (contador + 1); i++) {
            determinarDoc();
            cPasajero.setPasajero(i, maletas, documentos, turnosRegistro);
            contadorMaletas += maletas;
        }
    }

    public void agregarMaletas() {
        while (contadorMaletas != 0) {
            lMaletas.setMaleta(numeroMaleta);
            numeroMaleta++;
            contadorMaletas--;
        }
    }

    public void determinarDoc() {
        maletas = (int) (Math.random() * 4 + 1);
        documentos = (int) (Math.random() * 10 + 1);
    }

    public void imprimir() {
        aConsola.append("\n+++++++++++++++++ TURNO " + turno + "++++++++++++++++\n");
        aConsola.append("************ AVIONES *************\n");
        lAvion.printAviones(aConsola);
        aConsola.append("************* PASAJEROS *************\n");
        cPasajero.printPasajero(aConsola);
        aConsola.append("*************MALETAS*************\n");
        lMaletas.printMaletas(aConsola);
        aConsola.append("\n*************ESTACIONES*************\n");
        lMantenimiento.printListaMantenimiento(aConsola);
        aConsola.append("\n*************COLA*************\n");
        cAvion.printColaAviones(aConsola);
        aConsola.append("\n-----------ESCRITORIOS---------\n");
        lEscritorio.printListaEscritorio(aConsola);
        aConsola.append("\n+++++++++++++++++ FIN TURNO " + turno + "++++++++++++++++\n");
    }

    public void comprobarVacio() {
        if (lAvion.estaVacia() && cAvion.estaVacia() && lMaletas.estaVacia() && cPasajero.estaVacia() && lMantenimiento.estaVacio()) {
            JOptionPane.showMessageDialog(null, "Simulacion finalizada con Exito", "Fin", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void actionPerformed(ActionEvent e) {
        //if("".equals(cAviones.getText())||"".equals(cEstaciones.getText())){
        // JOptionPane.showMessageDialog(null, "Ingrese los datos");

        if (e.getSource() == bEmpezar) {
            turno = 0;
            n = 1;
            contador = 0;
            numeroMaleta = 1;
            aConsola.setText("");
            lAvion = new Lista_Avion_201701055();
            cPasajero = new Cola_Pasajero_201701055();
            lMaletas = new Lista_Maleta_201701055();
            lMantenimiento = new Lista_Mantenimiento_201701055();
            cAvion = new Cola_Avion_201701055();
            lEscritorio = new Lista_Escritorio_201701055();
            iniciado = false;
            try {

                cantAviones = Integer.parseInt(cAviones.getText());
                cantEstaciones = Integer.parseInt(cEstaciones.getText());
                cantEscritorios = Integer.parseInt(cEscritorios.getText());
            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(null, "Unicamente se permiten numeros", "ERROR", JOptionPane.ERROR_MESSAGE);

            }
            agregarEstaciones();
            agregarEscritorios();

        } else if (e.getSource() == bPasarTurno) {
            if (!iniciado) {
                agregarAviones();
                turno++;
                imprimir();
                iniciado = true;
                //graficar();
                return;
            }
            lAvion.bajaTurno();
            lMantenimiento.bajarTurno();
            lEscritorio.bajarTurno(lMaletas);

            int x = 5;
            while (x != 0) {
                lAvion.eliminaAvion(cAvion);
                lMantenimiento.terminaMantenimiento();
                cAvion.pasarMantenimiento(lMantenimiento);
                x--;
            }

        
        //sacaPasajeros();
        agregarAviones();
        turno++;
        imprimir();
        comprobarVacio();
    }
}

private int contadorMaletas, numeroMaleta = 1;

}
