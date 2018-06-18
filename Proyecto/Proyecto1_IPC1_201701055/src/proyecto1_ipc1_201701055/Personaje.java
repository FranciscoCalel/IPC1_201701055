/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_ipc1_201701055;

import java.awt.Image;
import javax.swing.ImageIcon;
import ventanas.Plataforma;

/**
 *
 * @author franc
 */
public class Personaje {
    private Plataforma in = new Plataforma();
    public int posponerx=0,posponery=0;
    private String nombre="";
 
    public ImageIcon princesa_1(int tamy, int tamx){
        /*if(in.jper1.getSelectedIndex()==0||in.jper2.getSelectedIndex()==0||in.jper3.getSelectedIndex()==0){
            nombre ="/imagenes/princesa1.png";
        }else if(in.jper1.getSelectedIndex()==1||in.jper2.getSelectedIndex()==1||in.jper3.getSelectedIndex()==1){
            nombre ="/imagenes/mago1.png";
        }else if(in.jper1.getSelectedIndex()==2||in.jper2.getSelectedIndex()==2||in.jper3.getSelectedIndex()==2){
            nombre ="/imagenes/guerrero1.png";
        }*/
       ImageIcon per =new ImageIcon(getClass().getResource("/img/princesa_1.png"));
       Image imagen= per.getImage();
       Image tamimagen=imagen.getScaledInstance(tamx, tamy, Image.SCALE_SMOOTH);
       per= new ImageIcon(tamimagen);
       return per;
    }
    public ImageIcon princesa_2(int tamy, int tamx){
        
       ImageIcon per =new ImageIcon(getClass().getResource("/img/princesa_2.png"));
       Image imagen= per.getImage();
       Image tamimagen=imagen.getScaledInstance(tamx, tamy, Image.SCALE_SMOOTH);
       per= new ImageIcon(tamimagen);
       return per;
    }
    public ImageIcon mago_1(int tamy, int tamx){
       ImageIcon per =new ImageIcon(getClass().getResource("/img/mago_1.png"));
       Image imagen= per.getImage();
       Image tamimagen=imagen.getScaledInstance(tamx, tamy, Image.SCALE_SMOOTH);
       per= new ImageIcon(tamimagen);
       return per;
    }
    public ImageIcon mago_2(int tamy, int tamx){
       ImageIcon per =new ImageIcon(getClass().getResource("/img/mago_2.png"));
       Image imagen= per.getImage();
       Image tamimagen=imagen.getScaledInstance(tamx, tamy, Image.SCALE_SMOOTH);
       per= new ImageIcon(tamimagen);
       return per;
    }
    public ImageIcon cab_1(int tamy, int tamx){
       ImageIcon per =new ImageIcon(getClass().getResource("/img/cab_1.png"));
       Image imagen= per.getImage();
       Image tamimagen=imagen.getScaledInstance(tamx, tamy, Image.SCALE_SMOOTH);
       per= new ImageIcon(tamimagen);
       return per;
    }
    public ImageIcon cab_2(int tamy, int tamx){
       ImageIcon per =new ImageIcon(getClass().getResource("/img/cab_2.png"));
       Image imagen= per.getImage();
       Image tamimagen=imagen.getScaledInstance(tamx, tamy, Image.SCALE_SMOOTH);
       per= new ImageIcon(tamimagen);
       return per;
    }
    public ImageIcon bomba(int tamy, int tamx){
       ImageIcon per =new ImageIcon(getClass().getResource("/img/bomba.png"));
       Image imagen= per.getImage();
       Image tamimagen=imagen.getScaledInstance(tamx, tamy, Image.SCALE_SMOOTH);
       per= new ImageIcon(tamimagen);
       return per;
    }
    public ImageIcon vida(int tamy, int tamx){
       ImageIcon per =new ImageIcon(getClass().getResource("/img/vida.png"));
       Image imagen= per.getImage();
       Image tamimagen=imagen.getScaledInstance(tamx, tamy, Image.SCALE_SMOOTH);
       per= new ImageIcon(tamimagen);
       return per;
    }
}
