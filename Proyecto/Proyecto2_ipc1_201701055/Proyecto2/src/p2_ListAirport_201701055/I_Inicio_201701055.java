/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_ListAirport_201701055;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author franc
 */
public class I_Inicio_201701055 extends JFrame{
    private ImageIcon nuevo;	
	
	
	public I_Inicio_201701055(ImageIcon nuevo, String titulo) {
		super("Graphviz");
                this.getContentPane().setBackground(Color.white);
		this.nuevo=nuevo;		
		add(getTitulo(titulo));
		JScrollPane scroll = new JScrollPane(new JLabel(nuevo));
                scroll.setBackground(Color.white);
                scroll.setOpaque(true);
		scroll.setBounds(20, 100, 700, 450);
		add(scroll);
		init();
	}
        
        public JLabel getTitulo(String title) {
		JLabel titulo = new JLabel(title);
		titulo.setBounds(220, 10, 200, 70);
		titulo.setForeground(Color.black);
		titulo.setOpaque(true);
		titulo.setFont(new Font("Tahoma",1,16));
		titulo.setVerticalAlignment(JLabel.CENTER);
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setVisible(true);
		return titulo;
	}
	
	public void setIcon(ImageIcon nuevo) {
		this.nuevo = nuevo;
	}

	public void init() {
		setLayout(null);
		setResizable(false);
		setSize(750,600);
		setLocationRelativeTo(null);		
		setVisible(true);
	}
	
        public ImageIcon getIcon() {
            return nuevo;
        }		
		

}
