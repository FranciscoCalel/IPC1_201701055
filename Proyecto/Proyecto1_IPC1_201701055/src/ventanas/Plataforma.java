/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import proyecto1_ipc1_201701055.Tablero;


/**
 *
 * @author franc
 */
public class Plataforma extends javax.swing.JFrame {

    public static int opciones;
    public Tablero tabjuego;
    public boolean tablerocreado = false;
    public Opciones opci;

    /**
     * Creates new form Plataforma
     */
    public Plataforma() {
        initComponents();
        this.tablero.setOpaque(false);
        this.tablero.removeAll();
        this.tablero.repaint();
        int tam=tamMatriz();
        this.tabjuego= new Tablero(tam,tablero);
        tablerocreado=true;
        this.fondotablero.setIcon(new ImageIcon("/img/fondotablero0.jpg"));
    }
      public int tamMatriz(){
        int tam=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese tamaño del tablero:", JOptionPane.QUESTION_MESSAGE));
        return tam;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        j1 = new javax.swing.JLabel();
        j2 = new javax.swing.JLabel();
        j3 = new javax.swing.JLabel();
        j4 = new javax.swing.JLabel();
        j5 = new javax.swing.JLabel();
        j6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        nj1 = new javax.swing.JLabel();
        nj2 = new javax.swing.JLabel();
        tablero = new javax.swing.JPanel();
        fondotablero = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("TIEMPO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, -1));

        jLabel2.setText("JUGADOR 1");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, -1));

        jLabel3.setText("JUGADOR 2");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, -1, -1));

        j1.setText("jLabel4");
        getContentPane().add(j1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, -1, -1));

        j2.setText("jLabel5");
        getContentPane().add(j2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, -1, -1));

        j3.setText("jLabel6");
        getContentPane().add(j3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, -1, -1));

        j4.setText("jLabel7");
        getContentPane().add(j4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 230, -1, -1));

        j5.setText("jLabel8");
        getContentPane().add(j5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 260, -1, -1));

        j6.setText("jLabel9");
        getContentPane().add(j6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 290, -1, -1));

        jLabel10.setText("VIDAS");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, -1, -1));

        jLabel11.setText("VIDAS");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, -1, -1));

        jButton1.setText("jButton1");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, -1, -1));

        jButton2.setText("jButton2");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, -1, -1));

        jButton3.setText("jButton3");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, -1, -1));

        jButton4.setText("jButton4");
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, -1, -1));

        jButton5.setText("jButton5");
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 410, -1, -1));

        nj1.setText("jLabel12");
        getContentPane().add(nj1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, -1, -1));

        nj2.setText("jLabel12");
        getContentPane().add(nj2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 200, -1, -1));

        tablero.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout tableroLayout = new javax.swing.GroupLayout(tablero);
        tablero.setLayout(tableroLayout);
        tableroLayout.setHorizontalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );
        tableroLayout.setVerticalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );

        getContentPane().add(tablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 450, 390));
        getContentPane().add(fondotablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 473, 474));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Plataforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Plataforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Plataforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Plataforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Plataforma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondotablero;
    public javax.swing.JLabel j1;
    public javax.swing.JLabel j2;
    public javax.swing.JLabel j3;
    public javax.swing.JLabel j4;
    public javax.swing.JLabel j5;
    public javax.swing.JLabel j6;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel nj1;
    public javax.swing.JLabel nj2;
    public javax.swing.JPanel tablero;
    // End of variables declaration//GEN-END:variables
}
