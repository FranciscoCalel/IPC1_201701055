/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_ListAirport_201701055;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 *
 * @author franc
 */
public class I_Completa_201701055 extends JFrame{
    private ImageIcon nuevo, nuevo1, nuevo2, nuevo3, nuevo4;	
	
	
	public I_Completa_201701055(ImageIcon nuevo,ImageIcon nuevo1,ImageIcon nuevo2,ImageIcon nuevo3,ImageIcon nuevo4) {
		super("Grafica Completa");
                this.getContentPane().setBackground(Color.white);
		this.nuevo=nuevo;
                this.nuevo1=nuevo1;
                this.nuevo2=nuevo2;
                this.nuevo3=nuevo3;
                this.nuevo4=nuevo4;
		JScrollPane scroll = new JScrollPane(new JLabel(nuevo));
                scroll.setBorder(BorderFactory.createLineBorder(Color.black, 2));
                JScrollPane scroll1 = new JScrollPane(new JLabel(nuevo1));
                scroll1.setBorder(BorderFactory.createLineBorder(Color.black, 2));
                JScrollPane scroll2 = new JScrollPane(new JLabel(nuevo2));
                scroll2.setBorder(BorderFactory.createLineBorder(Color.black, 2));
                JScrollPane scroll3 = new JScrollPane(new JLabel(nuevo3));
                scroll3.setBorder(BorderFactory.createLineBorder(Color.black, 2));
                JScrollPane scroll4 = new JScrollPane(new JLabel(nuevo4));
                scroll4.setBorder(BorderFactory.createLineBorder(Color.black, 2));
                
		scroll.setBounds(20, 20, 300, 300);
                scroll1.setBounds(350, 20, 300, 300);
                scroll2.setBounds(680, 20, 300, 300);
                scroll3.setBounds(120, 350, 300, 300);
                scroll4.setBounds(450, 350, 300, 300);
		add(scroll);
                add(scroll1);
                add(scroll2);
                add(scroll3);
                add(scroll4);
		init();
	}

	public void init() {
		setLayout(null);
                
		setResizable(false);
		setSize(1000,700);
		setLocationRelativeTo(null);		
		setVisible(true);
                
                JLabel aviones= new JLabel("Aviones");
                aviones.setBounds(100, 03, 100, 20);
                add(aviones);
                
                JLabel desbordaje= new JLabel("Desbordaje");
                desbordaje.setBounds(430, 03, 100, 20);
                add(desbordaje);
                
                JLabel escritorios= new JLabel("Escritorios");
                escritorios.setBounds(760, 03, 100, 20);
                add(escritorios);
                
                JLabel mantenimiento= new JLabel("Mantenimiento");
                mantenimiento.setBounds(200, 333, 100, 20);
                add(mantenimiento);
                
                JLabel equipaje= new JLabel("Equipaje");
                equipaje.setBounds(530, 333, 100, 20);
                add(equipaje);
	}
	
        public void setIcon(ImageIcon nuevo) {
            this.nuevo = nuevo;
	}
                
        public ImageIcon getIcon() {
            return nuevo;
        }		
		

}

