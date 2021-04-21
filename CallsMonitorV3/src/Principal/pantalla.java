/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Conexion.Conector;
import cellRender.CellRenderer;
import com.toedter.calendar.JCalendar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ChristianArias
 */
public final class pantalla extends javax.swing.JFrame {

    /**
     * Creates new form pantalla
     */
    Dimension _pantalla,_pantalla2;
    String ext = "";
    String  perdidas = "",
            ocupadas = "",
            contestadas = "",
            noContestadas = "";
    boolean con = false;
    String sql = "";
    int t = 0,sel = 3;
    
    public static Icon icono;
    
    Conector conector = new Conector();
    static  Connection cn = Conector.conexion();
    
    ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();
    
    public pantalla() {
        initComponents();
        jMenuBar1.add(Box.createHorizontalGlue());
        jMenuBar1.add(jLabel2);
        jMenuBar1.add(Box.createHorizontalGlue());
        jMenuBar1.add(jLabel1);
        _pantalla2 = Toolkit.getDefaultToolkit().getScreenSize();        
        setSize(_pantalla2.width-200,580);
        
        jSplitPane2.setDividerLocation((_pantalla2.width-200)/2);
        //jSplitPane1.setDividerLocation(_pantalla2.height/4);
        
        modelo(jTable1);
        setLocationRelativeTo(null);
        Reloj.Reloj.reloj();
        actualizar();
            timer.scheduleAtFixedRate(tarea, 1, 30, TimeUnit.SECONDS);
            //jCheckBox6.setVisible(false);
            //jMenuItem1.setVisible(false);
            
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
        jSplitPane1 = new javax.swing.JSplitPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jCheckBox6 = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setText("jLabel1");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Contact Center");

        jSplitPane1.setDividerLocation(150);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jSplitPane2.setDividerLocation(460);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 147, Short.MAX_VALUE)
        );

        jSplitPane2.setLeftComponent(jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 147, Short.MAX_VALUE)
        );

        jSplitPane2.setRightComponent(jPanel2);

        jSplitPane1.setTopComponent(jSplitPane2);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtrar llamadas por", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 8))); // NOI18N

        jCheckBox1.setText("Seleccionar todas");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Perdidas");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setText("Ocupadas");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox4.setText("Contestadas");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jCheckBox5.setText("No contestadas");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox5)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Llamadas entrantes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Llamadas salientes");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Todas las llamadas");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jCheckBox6.setSelected(true);
        jCheckBox6.setText("Alertas llamadas perdidas");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jCheckBox6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jCheckBox6)
                .addContainerGap())
        );

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel3.setText(" ");

        jTextField1.setEditable(false);
        jTextField1.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jSplitPane1.setRightComponent(jPanel3);

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Consulta");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem3.setText("Terminar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Herramientas");

        jMenuItem2.setText("Exportar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected()){
            for(int x = 1; x<jPanel5.getComponentCount();x++){
                if(jPanel5.getComponent(x)instanceof JCheckBox){
                    JCheckBox check = (JCheckBox) jPanel5.getComponent(x);
                    check.setSelected(true);
                    switch(x){
                        case 1:perdidas         = "FAILED";
                        case 2:ocupadas         = "BUSY";
                        case 3:contestadas      = "ANSWERED";
                        case 4:noContestadas    = "NO ANSWER";
                            break;
                        default:break;                            
                    }
                }
            }
        }else{
            for(int x = 1; x<jPanel5.getComponentCount();x++){
                if(jPanel5.getComponent(x)instanceof JCheckBox){
                    JCheckBox check = (JCheckBox) jPanel5.getComponent(x);
                    check.setSelected(false);
                    switch(x){
                        case 1:perdidas         = "";
                        case 2:ocupadas         = "";
                        case 3:contestadas      = "";
                        case 4:noContestadas    = "";
                            break;
                        default:break;                            
                    }
                }
            }
        } 
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        consultar(0);
        jButton1.setForeground(Color.red);
        jButton2.setForeground(Color.darkGray);
        jButton3.setForeground(Color.darkGray);        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        consultar(1);
        jButton1.setForeground(Color.darkGray);
        jButton2.setForeground(Color.red);
        jButton3.setForeground(Color.darkGray); 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        consultar(2);
        jButton1.setForeground(Color.darkGray);
        jButton2.setForeground(Color.darkGray);
        jButton3.setForeground(Color.red); 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        if(jCheckBox2.isSelected())perdidas = "FAILED";else perdidas = "";
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        if(jCheckBox3.isSelected())ocupadas = "BUSY";else ocupadas = "";
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        if(jCheckBox4.isSelected())contestadas = "ANSWERED";else contestadas = "";
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        if(jCheckBox5.isSelected())noContestadas = "NO ANSWER";else noContestadas = "";
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new Thread(() -> {            
            Consultas.Consultas c = new Consultas.Consultas();
            c.setVisible(true);
        }).start();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new Thread(() -> {
            Exportar.Exportar.toExcel((DefaultTableModel) jTable1.getModel());
        }).start();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Reloj.RelojAnalogo c = new Reloj.RelojAnalogo();
        JCalendar cal = new JCalendar();
            cal.setTodayButtonVisible(true);
            cal.setTodayButtonText(Reloj.Reloj.date);
            cal.setWeekOfYearVisible(true);
                
        JPopupMenu p = new JPopupMenu();
        JPanel panel = new JPanel();
            panel.setSize(new Dimension(450,156));
            panel.setLayout(new BorderLayout());
        JPanel r = new JPanel();
            r.setLayout(new BorderLayout());
            r.add(c,BorderLayout.CENTER);
        JPanel calendario = new JPanel();
            calendario.setLayout(new BorderLayout());
            calendario.add(cal,BorderLayout.CENTER);
        c.start();
        panel.add(r,BorderLayout.CENTER);
        panel.add(calendario,BorderLayout.SOUTH);
        p.add(panel);
        Dimension size = p.getPreferredSize();
        int x = jLabel1.getWidth() - 270;
        int y = ((jLabel1.getHeight() - size.height) / 2) + 240;
        p.show(jLabel1,x,y);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        new Thread(() -> {
            new Extenciones.Extencion().setVisible(true);
        }).start();
    }//GEN-LAST:event_jLabel2MouseClicked

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
                if ("GTKLookAndFeel".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new pantalla().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    Runnable tarea = () -> {
        jLabel2.setText("Extenciones "+cargar_ext.Extenciones.extenciones());
        entrantes();
        salientes();
        logo();
        System.gc();
        if(jCheckBox6.isSelected()){
            jCheckBox6.setToolTipText("Se mostraran alertas de llamadas perdidas,no contestadas u ocupadas de las extenciones "+cargar_ext.Extenciones.extenciones());
            //Consultas.Alerta.main(cargar_ext.Extenciones.extenciones());
        }
    };
    
    void actualizar(){
        new Timer(10000, (ActionEvent e) -> {
            consultar(sel);
            //if(!sql.isEmpty())try{ consulta(sql); }catch(Exception ex){}
        }).start();
    }
    
    void setCellRenderer(JTable jTable1) {
        Enumeration<TableColumn> en = jTable1.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new CellRenderer());
        }
    }
    
    final void modelo(JTable tabla){
        try{
            String [] titulo = {"Hora","ID","Origen","Destino","Extencion interna","Duración","Disposición"};
            DefaultTableModel model = new DefaultTableModel(null,titulo);
            tabla.setModel(model);
            tabla.setFillsViewportHeight(true);            
            for(int i = 0; i < tabla.getColumnCount(); i++) {
                tabla.getColumn(tabla.getColumnName(i)).setWidth(0);
                setCellRenderer(tabla);
            } 
            tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            //tabla.getTableHeader().setReorderingAllowed(false);
            tabla.getTableHeader().setResizingAllowed(true);
        }catch(Exception e){
            Logs.emergen.mostrar("Modelo: "+e.getMessage(), "Error");
        }
    }
    
    void consultar(int c){
        switch(c){
            case 0:
                busqueda("dst");
                sel = 0;
                break;
            case 1:
                busqueda("src");
                sel = 1;
                break;
            case 2:
                todas();
                break;
            default:
                //Sin seleccion
                break;
        }
        consulta(sql);
    }
    
    void busqueda(String s){
        sql = "SELECT DATE_FORMAT(calldate,'%h:%i:%s %p') AS calldate,clid,src,dst,SEC_TO_TIME(duration) AS duracion,"
                + "case disposition "
                + "when 'ANSWERED' then 'Contestadas' "
                + "when 'NO ANSWER' then 'No contestadas' "
                + "when 'FAILED' then 'Perdidas' "
                + "when 'BUSY' then 'Ocupada' "
                + "end as disposition,cnam,substring(dstchannel,5,5) as dstchannel "
                + "FROM cdr where date(calldate) = date(now()) "
                + "and "+s+" in("+cargar_ext.Extenciones.extenciones()+") "
                + "and disposition in('"+noContestadas+"','"+contestadas+"','"+ocupadas+"','"+perdidas+"') "
                + "order by time(calldate) desc";
    }
    
    void todas(){
        sql = "SELECT DATE_FORMAT(calldate,'%h:%i:%s %p') AS calldate,clid,src,dst,SEC_TO_TIME(duration) AS duracion,"
                + "case disposition "
                + "when 'ANSWERED' then 'Contestadas' "
                + "when 'NO ANSWER' then 'No contestadas' "
                + "when 'FAILED' then 'Perdidas' "
                + "when 'BUSY' then 'Ocupada' "
                + "end as disposition,cnam,substring(dstchannel,5,5) as dstchannel "
                + "FROM cdr where date(calldate) = date(now()) "
                + "and (dst in("+cargar_ext.Extenciones.extenciones()+") OR src in ("+cargar_ext.Extenciones.extenciones()+")) "
                + "and disposition in('"+noContestadas+"','"+contestadas+"','"+ocupadas+"','"+perdidas+"') "
                + "order by time(calldate) desc";
        sel = 2;
    }
    
    void consulta(String sql){
        jTable1.repaint();
        
        String [] registros = new String [jTable1.getColumnCount()];
        int x = 0;
        String aux = null;
        DefaultTableModel model =(DefaultTableModel)jTable1.getModel();
        model.setRowCount(0);
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                t += 1;
                registros[0] = rs.getString("Calldate");
                registros[1] = rs.getString("cnam");
                registros[2] = rs.getString("src");
                registros[3] = rs.getString("dst");
                if(rs.getString("dst").equals("602"))registros[4] = rs.getString("dstchannel");else registros[4] = "--";
                registros[5] = rs.getString("Duracion");
                registros[6] = rs.getString("disposition");
                
                model.addRow(registros);
                x = rs.getRow();
                aux = Integer.toString(x);
            }
            jTable1.setModel(model);
            model.fireTableDataChanged();
            jLabel3.setText("Total de registros "+t);
            t = 0;
        }catch(SQLException e){
            Logs.Logs l = new Logs.Logs(e.getMessage()+" consulta");
        }
    }

    //--------------------------------------------------------------------------
    
    final void entrantes(){
        int contestada  =   entrantes_contestadas();
        int perdida    =   entrantes_perdidas();        
        int total = contestada+perdida;
        try{
            jPanel1.removeAll();
            jPanel1.repaint();
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                dataset.setValue(contestada,contestada+" Contestadas.",contestada+" Contestadas.");
                dataset.setValue(perdida,perdida+" Perdidas.",perdida+" Perdidas.");
                dataset.setValue(total,total+" Total.",total+" Total."   );
            JFreeChart chart = ChartFactory.createBarChart3D("Llamadas Recibidas","Total de Llamadas "+total+" Efectividad "+getPercent(contestada,total)+" %", " ",dataset, PlotOrientation.VERTICAL, false,true,true);
                chart.setBackgroundPaint(Color.white);
                chart.getTitle().setPaint(Color.black); 
            
            CategoryPlot p = chart.getCategoryPlot(); 
                p.setRangeGridlinePaint(Color.black); 
            // Mostrar Grafico
            ChartPanel chartPanel = new ChartPanel(chart);
                    chartPanel.setMouseWheelEnabled(true);
                
            chartPanel.setPreferredSize(_pantalla);
                jPanel1.setLayout(new java.awt.BorderLayout());
                jPanel1.add(chartPanel,BorderLayout.CENTER);
                jPanel1.validate();
        
        }catch(Exception e){
            Logs.Logs l = new Logs.Logs(e.getMessage()+" entrantes");
        }
    }
    
    int entrantes_contestadas(){
        String consulta = "SELECT count(*) as total FROM cdr where (dst in ("+cargar_ext.Extenciones.extenciones()+")) and date(calldate) = date(now()) and disposition like '%ANSWERED%'";
        return consultar(consulta);        
    }
    
    int entrantes_perdidas(){
        String consulta = "SELECT count(*) as total FROM cdr where (dst in ("+cargar_ext.Extenciones.extenciones()+")) and date(calldate) = date(now()) and disposition like '%NO ANSWER%'";
        return consultar(consulta);        
    }
    
    //--------------------------------------------------------------------------
    
    final void salientes(){
        int contestada      = salientes_contestadas();
        int no_contestada   = salientes_no_contestadas();
        int ocupado         = salientes_ocupado();
        int total = contestada+no_contestada+ocupado;
        
        try{
            jPanel2.removeAll();
            jPanel2.repaint();
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                dataset.setValue(contestada,contestada+" Contestadas.",contestada+" Contestadas.");
                dataset.setValue(no_contestada,no_contestada+" No Contestadas.",no_contestada+" No Contestadas.");
                dataset.setValue(ocupado,ocupado+" Ocupado.",ocupado+" Ocupado.");
                dataset.setValue(total,total+" Total.",total+" Total.");
            JFreeChart chart = ChartFactory.createBarChart3D("Llamadas Realizadas","Total de Llamadas "+total+" Efectividad "+getPercent(contestada,total)+" %", "",dataset, PlotOrientation.VERTICAL, false,true,true);
                chart.setBackgroundPaint(Color.white);
                chart.getTitle().setPaint(Color.black); 
            
            CategoryPlot p = chart.getCategoryPlot(); 
                p.setRangeGridlinePaint(Color.black); 
            // Mostrar Grafico
            ChartPanel chartPanel = new ChartPanel(chart);
                    chartPanel.setMouseWheelEnabled(true);
                
            chartPanel.setPreferredSize(_pantalla);
                jPanel2.setLayout(new java.awt.BorderLayout());
                jPanel2.add(chartPanel,BorderLayout.CENTER);
                jPanel2.validate();
        }catch(Exception e){
            Logs.Logs l = new Logs.Logs(e.getMessage()+" Salientes");
        }
    }
    
    int salientes_contestadas(){
        String consulta = "SELECT count(*) as total FROM cdr where (src in ("+cargar_ext.Extenciones.extenciones()+")) and date(calldate) = date(now()) and disposition like '%ANSWERED%'";
        return consultar(consulta);        
    }
    
    int salientes_no_contestadas(){
        String consulta = "SELECT count(*) as total FROM cdr where (src in ("+cargar_ext.Extenciones.extenciones()+")) and date(calldate) = date(now()) and disposition like '%NO ANSWER%'";
        return consultar(consulta); 
    }
    
    int salientes_ocupado(){
        String consulta = "SELECT count(*) as total FROM cdr where (src in ("+cargar_ext.Extenciones.extenciones()+")) and date(calldate) = date(now()) and disposition in('BUSY','FAILED')";
        return consultar(consulta);        
    }
    
    //--------------------------------------------------------------------------
    
    int consultar(String sql){
        int result = 0;
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                result = rs.getInt("total");
            }
        }catch(SQLException e){
            Logs.Logs l = new Logs.Logs(e.getMessage()+" Consultar");
        }
        return result;
    }//
    
    double getPercent(int total,int value){
        double result = 0.0;
        try{
            if(total > 0){
                result = (double)(total * 100 /value );
            }else{
                result = 0.0;
            }
        }catch(Exception e){
            Logs.Logs l = new Logs.Logs(e.getMessage()+" getPercent");
        }
        return result;
    }
    
    final void logo(){
        File carpeta = new File(Principal.Ubicacion.main());
        File[] listFiles = carpeta.listFiles();
        for (File listFile : listFiles) {
            if (listFile.isFile()) {
                String nombre = listFile.getName();
                if (nombre.contains("logo")) {
                    ImageIcon icon = new ImageIcon(listFile.getAbsolutePath());
                    icono = new ImageIcon(icon.getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH));
                    jLabel2.setIcon(icono);
                    this.setIconImage(Toolkit.getDefaultToolkit().getImage(listFile.getAbsolutePath()));
                }
            }
        }
    }
    
}