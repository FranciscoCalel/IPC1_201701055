/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_ipc1_201701055;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import ventanas.Plataforma;

/**
 *
 * @author franc
 */
public class Tablero {

     public int tam=0,a,b,tambloquey=0,tambloquex=0,diez=0, cinco=0;
    public JPanel fondo=null;
    public int[][] vecL;
    public Personaje per;
    public Plataforma jue;
    public JLabel[][] vecG;
    
    public Tablero(int tam, JPanel panel){
        this.tam=tam;
        this.fondo= panel;
        llenar();
    }
    public void llenar(){
        tambloquey= 440/tam;
        tambloquex= 420/tam;
        vecL= new int[tam][tam];
        vecG= new JLabel[tam][tam];
        //1 persona 0 casillas vacias
       // vecL[0][0]=1;
        per= new Personaje();
        per.posponerx=a;
        per.posponery=b;
        for (int i = 1; i < tam; i++) {
            for(int j=1; j < tam; j++){
                vecL[i][j]=0;
            }
            
        }
        
        for(int p =0; p<=6; ++p){
            a = (int)(Math.random() *tam);
            b = (int)(Math.random() *tam);
            if(vecL[a][b]!=0){
                --p;
            }else{
                vecL[a][b]=p;
            }
        }
        cinco= (int) (tam*tam*0.05);
        diez=(int) (tam*tam*0.1);
        for(int p =0; p<cinco; ++p){
            a = (int)(Math.random() *tam);
            b = (int)(Math.random() *tam);
            if(vecL[a][b]!=0){
                --p;
            }else{
                vecL[a][b]=7;
            }
        }
        for(int p =0; p<diez; ++p){
            a = (int)(Math.random() *tam);
            b = (int)(Math.random() *tam);
            if(vecL[a][b]!=0){
                --p;
            }else{
                vecL[a][b]=8;
            }
        }
        repintar();
    }
    public void repintar(){
        JLabel casilla= null;
        for (int i = 0; i < tam; i++) {
            for(int j=0; j< tam; j++){
                if(vecL[i][j]==0){// 0 es casilla vacia
                    casilla= new JLabel();
                }if(vecL[i][j]==1){// 1 es el primer presonaje seleccionado
                    casilla= new JLabel(this.per.princesa_1(tambloquex,tambloquey));
                    
                }
                if(vecL[i][j]==2){// 2 es el segundo personaje seleccionado
                    casilla= new JLabel(this.per.mago_1(tambloquex,tambloquey));
                }
                if(vecL[i][j]==3){// 3 es el el tercer personaje seleccionado
                    casilla= new JLabel(this.per.cab_1(tambloquex,tambloquey));
                }
                if(vecL[i][j]==4){// 4 es el el cuarto personaje seleccionado
                    casilla= new JLabel(this.per.princesa_2(tambloquex,tambloquey));
                }
                if(vecL[i][j]==5){// 5 es el el quinto personaje seleccionado
                    casilla= new JLabel(this.per.mago_2(tambloquex,tambloquey));
                }
                if(vecL[i][j]==6){// 6 es el el sexto personaje seleccionado
                    casilla= new JLabel(this.per.cab_2(tambloquex,tambloquey));
                }
                if(vecL[i][j]==7){// 7 son las vidas
                    casilla= new JLabel(this.per.vida(tambloquex,tambloquey));
                }
                if(vecL[i][j]==8){// 8 son las bombas
                    casilla= new JLabel(this.per.bomba(tambloquex,tambloquey));
                }
            casilla.setOpaque(false);
            casilla.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
            casilla.setBounds(j*tambloquex, i*tambloquey, tambloquex, tambloquey);
            vecG[i][j]= casilla;
            fondo.add(vecG[i][j],BorderLayout.CENTER);
            fondo.repaint();
        }
        }
        }
}
