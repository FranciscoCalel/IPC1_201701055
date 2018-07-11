/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_ListAirport_201701055;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author franc
 */
public class Inicio_201701055 extends JFrame {

    private JTextArea areaImpresion;
    private int cantAviones, turno = 0, n = 1, contador, cantEstaciones, cantEscritorios;
    private int pasajeros, desabordaje, mantenimiento, maletas, documentos, turnos;
    private String tamano;
    private Cola_Avion_201701055 colaAvion;
    private Lista_Man_201701055 listaMante;
    private Lista_Esc_201701055 listaEscri;
    private Lista_Avion_201701055 listaAvion;
    private Cola_Pasajero_201701055 colaPasajero;
    private int contadorMaletas, numeroMaleta = 1;
    private Lista_Eq_201701055 listaMaletas;
    private JPanel panel1, panel2;
    private JTextField numAviones, numEstaciones, numEscritorios;
    public static final String pequeño = "Pequeño", mediano = "Mediano", grande = "Grande";
    public static final int salidaPasajero = 5;
    private JButton iniciar, turnoSiguiente, llegAvion, desbordaje, escritorios, mantenimient, equipaje;
    private JButton complete;
    private String ruta, ruta1, ruta2, ruta3, ruta4;

    public Inicio_201701055() {
        super("LISTAIRPORT");
        initComponents();
    }

    public void initComponents() {
        this.getContentPane().setBackground(Color.white);
        setLayout(null);
        setSize(700, 600);
        add(panel1());
        add(panel2());
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public JPanel panel1() {
        panel1 = new JPanel();
        panel1.setBounds(0, 0, 250, 650);
        panel1.setLayout(null);
        panel1.setBackground(Color.white);
        panel1.setVisible(true);

        JLabel labelAviones = new JLabel("No. Aviones");
        labelAviones.setBounds(40, 70, 170, 20);
        labelAviones.setVisible(true);
        panel1.add(labelAviones);

        numAviones = new JTextField();
        numAviones.setBounds(210, 70, 40, 20);
        numAviones.setVisible(true);
        panel1.add(numAviones);

        JLabel labelEstaciones = new JLabel("No. Estaciones");
        labelEstaciones.setBounds(40, 120, 170, 20);
        labelEstaciones.setVisible(true);
        panel1.add(labelEstaciones);

        numEstaciones = new JTextField();
        numEstaciones.setBounds(210, 120, 40, 20);
        numEstaciones.setVisible(true);
        panel1.add(numEstaciones);

        JLabel labelEscritorios = new JLabel("No. Escritorios");
        labelEscritorios.setBounds(40, 170, 170, 20);
        labelEscritorios.setVisible(true);
        panel1.add(labelEscritorios);

        numEscritorios = new JTextField();
        numEscritorios.setBounds(210, 170, 40, 20);
        numEscritorios.setVisible(true);
        panel1.add(numEscritorios);
        
        JLabel Lgraficas = new JLabel("GRAFICAS");
        Lgraficas.setBounds(40, 300, 170, 40);
        Lgraficas.setFont(new java.awt.Font("Tahoma", 0, 36)); 
        Lgraficas.setVisible(true);
        panel1.add(Lgraficas);

        iniciar = new JButton("Inicio");
        iniciar.setBounds(40, 220, 85, 25);
        iniciar.setVisible(true);
        iniciar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                turno = 0;
                n = 1;
                contador = 0;
                numeroMaleta = 1;
                areaImpresion.setText("");
                listaAvion = new Lista_Avion_201701055();
                colaPasajero = new Cola_Pasajero_201701055();
                listaMaletas = new Lista_Eq_201701055();
                listaMante = new Lista_Man_201701055();
                colaAvion = new Cola_Avion_201701055();
                listaEscri = new Lista_Esc_201701055();
                iniciado = false;
                try {
                    cantAviones = Integer.parseInt(numAviones.getText());
                    cantEstaciones = Integer.parseInt(numEstaciones.getText());
                    cantEscritorios = Integer.parseInt(numEscritorios.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese numeros", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                anadirEstaciones();
                anadirEscritorios();
            }
        });
        panel1.add(iniciar);

        turnoSiguiente = new JButton("Turno");
        turnoSiguiente.setBounds(160, 220, 85, 25);
        turnoSiguiente.setVisible(true);
        turnoSiguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listaAvion.bajaTurno();
                listaMante.disminuirTurno();
                listaEscri.bajarTurno(listaMaletas);
                for (int i = 0; i < 5; i++) {
                    listaAvion.eliminaAvion(colaAvion);
                    listaMante.finalizaMantenimiento();
                    colaAvion.pasarPorMantenimiento(listaMante);
                }
                if (!iniciado) {
                    anadirAviones();
                    turno++;
                    imprimir();
                    iniciado = true;
                    graficar();
                    return;
                }
                sacarPasajeros(salidaPasajero);
                listaEscri.addPasajeros();
                listaEscri.estaDisponible();
                anadirAviones();
                turno++;
                imprimir();
                comprobarLista();
                graficar();
            }
        });
        panel1.add(turnoSiguiente);
        
        

        llegAvion = new JButton("Aviones");
        llegAvion.setBounds(20, 400, 80, 25);
        llegAvion.setVisible(true);
        llegAvion.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                ruta = "C:\\Users\\franc\\Desktop\\curos java\\Proyecto2\\src\\imagenes\\ListaDoble.png";
                ImageIcon icono = new ImageIcon(ruta);
                icono.getImage().flush();
                String titulo = "AVIONES";
                
                I_Inicio_201701055 frameGraficas = new I_Inicio_201701055(icono, titulo);
                
                frameGraficas.setVisible(true);
                
            }
        });
        panel1.add(llegAvion);

        desbordaje = new JButton("Desbordaje");
        desbordaje.setBounds(120, 400, 120, 25);
        desbordaje.setVisible(true);
        desbordaje.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                ruta = "C:\\Users\\franc\\Desktop\\curos java\\Proyecto2\\src\\imagenes\\PasajeroCola.png";
                ImageIcon icono = new ImageIcon(ruta);
                icono.getImage().flush();
                String titulo = "DESBORDAJE";
                I_Inicio_201701055 frameGraficas = new I_Inicio_201701055(icono, titulo);
                frameGraficas.setVisible(true);
            }
        });
        panel1.add(desbordaje);

        escritorios = new JButton("Escritorios");
        escritorios.setBounds(20, 450, 80, 25);
        escritorios.setVisible(true);
        escritorios.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                ruta = "C:\\Users\\franc\\Desktop\\curos java\\src\\imagenes\\EscritorioLista.png";
                ImageIcon icono = new ImageIcon(ruta);
                icono.getImage().flush();
                String titulo = "ESCRITORIOS";
                I_Inicio_201701055 frameGraficas = new I_Inicio_201701055(icono, titulo);
                frameGraficas.setVisible(true);
            }
        });
        panel1.add(escritorios);

        mantenimient = new JButton("MANTENIMIENTO");
        mantenimient.setBounds(120, 450, 120, 25);
        mantenimient.setVisible(true);
        mantenimient.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                ruta = "C:\\Users\\franc\\Desktop\\curos java\\src\\imagenes\\MantenimientoLista.png";
                ImageIcon icono = new ImageIcon(ruta);
                icono.getImage().flush();
                String titulo = "MANTENIMIENTO";
                I_Inicio_201701055 frameGraficas = new I_Inicio_201701055(icono, titulo);
                frameGraficas.setVisible(true);
            }
        });
        panel1.add(mantenimient);

        equipaje = new JButton("Equipaje");
        equipaje.setBounds(20, 500, 80, 25);
        equipaje.setVisible(true);
        equipaje.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                ruta = "C:\\Users\\franc\\Desktop\\curos java\\Proyecto2\\src\\imagenes\\EquipajeLista.png";
                ImageIcon icono = new ImageIcon(ruta);
                icono.getImage().flush();
                String titulo = "EQUIPAJE";
                I_Inicio_201701055 frameGraficas = new I_Inicio_201701055(icono, titulo);
                frameGraficas.setVisible(true);
            }
        });
        panel1.add(equipaje);

        complete = new JButton("Completo");
        complete.setBounds(120, 500, 120, 25);
        complete.setVisible(true);
        complete.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                ruta = "C:\\Users\\franc\\Desktop\\curos java\\Proyecto2\\src\\imagenes\\ListaDoble.png";
                ImageIcon icono = new ImageIcon(ruta);
                icono.getImage().flush();
                ruta1 = "C:\\Users\\franc\\Desktop\\curos java\\Proyecto2\\src\\imagenes\\PasajeroCola.png";
                ImageIcon icono1 = new ImageIcon(ruta1);
                icono1.getImage().flush();
                ruta2 = "C:\\Users\\franc\\Desktop\\curos java\\Proyecto2\\src\\imagenes\\EscritorioLista.png";
                ImageIcon icono2 = new ImageIcon(ruta2);
                icono2.getImage().flush();
                ruta3 = "C:\\Users\\franc\\Desktop\\curos java\\Proyecto2\\src\\imagenes\\MantenimientoLista.png";
                ImageIcon icono3 = new ImageIcon(ruta3);
                icono3.getImage().flush();
                ruta4 = "C:\\Users\\franc\\Desktop\\curos java\\Proyecto2\\src\\imagenes\\EquipajeLista.png";
                ImageIcon icono4 = new ImageIcon(ruta4);
                icono4.getImage().flush();
                I_Completa_201701055 frameGraficas = new I_Completa_201701055(icono, icono1, icono2, icono3, icono4);
                frameGraficas.setVisible(true);
            }
        });
        panel1.add(complete);

        return panel1;
    }

    public JPanel panel2() {
        panel2 = new JPanel();
        panel2.setBounds(270, 0, 500, 650);
        panel2.setLayout(null);
        panel2.setBackground(Color.white);
        panel2.setVisible(true);

        areaImpresion = new JTextArea();
        areaImpresion.setBackground(Color.white);
        areaImpresion.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        areaImpresion.setForeground(Color.black);
        areaImpresion.setEditable(false);

        JScrollPane scroll = new JScrollPane(areaImpresion);
        scroll.setBounds(10, 50, 380, 400);
        scroll.setVisible(true);
        panel2.add(scroll);

        return panel2;
    }
    boolean iniciado = false;

    public void anadirAviones() {
        if (cantAviones > 0) {
            determinarTamano();
            listaAvion.setAvion(n, tamano, pasajeros, desabordaje, mantenimiento);
            n++;
            cantAviones--;
            anadirPasajeros();
            anadirMaletas();
        }
    }

    public void anadirEstaciones() {
        while (cantEstaciones != 0) {
            listaMante.iniciarLista(cantEstaciones);
            cantEstaciones--;
        }
    }

    public void sacarPasajeros(int cantidad) {
        if (cantidad > 0) {
            if (listaEscri.determinaEspacio()) {
                listaEscri.agregarPasajerosCola((Pasajero_201701055) colaPasajero.quitar());
            } else {
                listaMaletas.eliminarMaleta(colaPasajero.getMaletas());
                colaPasajero.eliminarPasajero();
            }
            sacarPasajeros(cantidad - 1);
        }
    }

    public void anadirPasajeros() {
        contador += pasajeros;
        for (int i = (contador - pasajeros + 1); i < (contador + 1); i++) {
            determinarDoc();
            colaPasajero.setPasajero(i, maletas, documentos, turnos);
            contadorMaletas += maletas;
        }
    }

    public void anadirMaletas() {
        while (contadorMaletas != 0) {
            listaMaletas.setMaleta(numeroMaleta);
            numeroMaleta++;
            contadorMaletas--;
        }
    }

    public void determinarTamano() {
        int x = (int) (Math.random() * 3 + 1);
        if (x == 1) {
            tamano = "Pequeño";
            desabordaje = 1;
            pasajeros = (int) Math.floor(Math.random() * (10 - 5 + 1) + 5);
            mantenimiento = (int) (Math.random() * 3 + 1);
        } else if (x == 2) {
            tamano = "Mediano";
            desabordaje = 2;
            pasajeros = (int) Math.floor(Math.random() * (25 - 15 + 1) + 15);
            mantenimiento = (int) Math.floor(Math.random() * (4 - 2 + 1) + 2);
        } else if (x == 3) {
            tamano = "Grande";
            desabordaje = 3;
            pasajeros = (int) Math.floor(Math.random() * (40 - 30 + 1) + 30);
            mantenimiento = (int) Math.floor(Math.random() * (6 - 3 + 1) + 3);
        }
    }

    public void anadirEscritorios() {
        while (cantEscritorios != 0) {
            listaEscri.iniciarLista();
            cantEscritorios--;
        }
    }

    public void determinarDoc() {
        maletas = (int) (Math.random() * 4 + 1);
        documentos = (int) (Math.random() * 10 + 1);
        turnos = (int) (Math.random() * 3 + 1);
    }

    public void comprobarLista() {
        if (listaAvion.estaVacia() && listaMaletas.estaVacia() && colaPasajero.estaVacia() && colaAvion.estaVacia()) {
            System.out.println("Esta vacio");
        }
    }

    public void graficar() {
        Graph_201701055 g = new Graph_201701055();
        g.crearDocumento(listaAvion.getPrimero(), "listaDoble.dot");
        g.generarImagen("listaDoble.dot", "C:\\Users\\franc\\Desktop\\curos java\\Proyecto2\\src\\imagenes\\ListaDoble.png");

        g.crearDocumentoDesbordaje(colaPasajero.getInicioNodo(), "colaPasajero.dot");
        g.generarImagen("colaPasajero.dot", "C:\\Users\\franc\\Desktop\\curos java\\Proyecto2\\src\\imagenes\\PasajeroCola.png");

        g.crearDocumentoMantenimiento(listaMante.getInicioNodo(), "listaMantenimiento.dot", colaAvion.getInicioNodo());
        g.generarImagen("listaMantenimiento.dot", "C:\\Users\\franc\\Desktop\\curos java\\Proyecto2\\src\\imagenes\\MantenimientoLista.png");

        g.crearDocumentoEscritorio(listaEscri.getInicioNodo(), "listaEscritorio.dot");
        g.generarImagen("listaEscritorio.dot", "C:\\Users\\franc\\Desktop\\curos java\\Proyecto2\\src\\imagenes\\EscritorioLista.png");

        g.crearDocumentoListaMaleta(listaMaletas.getInicioNodo(), listaMaletas.getInicioNodo(), "colaMaleta");
        g.generarImagen("colaMaleta.dot", "C:\\Users\\franc\\Desktop\\curos java\\Proyecto2\\src\\imagenes\\EquipajeLista.png");
    }

    public void imprimir() {
        areaImpresion.append("\n+++++++++++++++++ TURNO " + turno + "++++++++++++++++\n");
        areaImpresion.append("----------- AVIONES -----------\n");
        listaAvion.imprimirAviones(areaImpresion);
        areaImpresion.append("----------- PASAJEROS -----------\n");
        colaPasajero.imprimirPasajero(areaImpresion);
        areaImpresion.append("---------MALETAS---------\n");
        listaMaletas.imprimirMaleta(areaImpresion);
        areaImpresion.append("\n---------ESTACIONES---------\n");
        listaMante.imprimirListaMantenimiento(areaImpresion);
        areaImpresion.append("\n---------COLA---------\n");
        colaAvion.imprimirColaAviones(areaImpresion);
        areaImpresion.append("\n-----------ESCRITORIOS---------\n");
        listaEscri.printListaEscritorio(areaImpresion);
        areaImpresion.append("\n+++++++++++++++++ FIN TURNO " + turno + "++++++++++++++++\n");
    }
}
