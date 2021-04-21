/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logs;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author ChristianArias
 */
public class emergen extends javax.swing.JFrame {

    /**
     * Creates new form emergen
     */
    static float opacidad = 0.3f; 
    Thread hilo ;
    public static String mnsj = "";
    int tiempo = 6000;
    private SimpleAttributeSet attrib; 
    
    public emergen() {
        initComponents();
        hilo = new Thread();
        attrib = new SimpleAttributeSet();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTextPane1.setEditable(false);
        jScrollPane1.setViewportView(jTextPane1);

        jButton1.setText("Cerra ventana");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        hilo = new Thread(() -> {
            try {
                ubicacion();
                set_mensaje(new Random().nextInt(3));                
                Thread.sleep(tiempo);
                desvanecer();
                this.dispose();
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
                Logs l = new Logs(Reloj.Reloj.date+Reloj.Reloj.hour_24+" "+ex.getMessage());
            }
        });
        hilo.start();
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(emergen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(emergen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(emergen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(emergen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new emergen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables

    public static void mostrar(String mensaje, String titulo){
        emergen e = new emergen();
        e.setTitle(titulo);
        mnsj = mensaje;
        e.setVisible(true);
    }
    
    void set_mensaje(int tipoColor){
        try{
            StyleConstants.setForeground(attrib, getColorTexto(tipoColor)); 
            StyledDocument sd = jTextPane1.getStyledDocument();
            if (!jTextPane1.getText().isEmpty()) { 
                sd.insertString(sd.getLength(), "n", attrib); 
            } 
            sd.insertString(sd.getLength(), mnsj, attrib);
        }catch (Exception e) { 
            JOptionPane.showMessageDialog(null,e.getMessage());
            Logs l = new Logs(Reloj.Reloj.date+Reloj.Reloj.hour_24+" "+e.getMessage());
        } 
    }
    
    void ubicacion(){
        int tamanioX = getWidth(); 
        int tamanioY = getHeight(); 
        int maxX = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(); 
        int maxY = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight(); 
        setLocation(maxX - tamanioX - 30 , maxY - tamanioY - 50);         
        repaint(); 
    }
    
    void desvanecer(){
        try{
            opacidad = 1.0f;
            while(opacidad > 0){
                //AWTUtilities.setWindowOpacity(this, opacidad);
                //setOpaque(false);                
                setOpacity(opacidad);
                opacidad -= 0.03f;
            }
            Thread.sleep(20);
        }catch(InterruptedException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
            Logs l = new Logs(Reloj.Reloj.date+Reloj.Reloj.hour_24+" "+e.getMessage());
        }
    }
    
    private Color getColorTexto(int tipo) { 
        switch (tipo) { 
            case 0:     // Verde 
                return new Color(0, 130, 0); 
            case 1:     // ROJO 
                return new Color(255, 0, 0); 
            default:    // Negro 
                return new Color(0, 0, 0); 
        } 
    }
}