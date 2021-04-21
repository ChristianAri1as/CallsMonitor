package Reloj;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JPanel;

public class RelojAnalogo extends JPanel {
 
    private int horas;
    private int minutos;
    private int segundos;
 
    private static final int   espacio = 10;
    private static final float dosPi = (float)(2.0 * Math.PI);
    private static final float tresPi = (float)(3.0 * Math.PI);
    private static final float rad = (float)(Math.PI / 30.0);
 
    private int tamano;
    private int xCentro;
    private int yCentro;
    private BufferedImage muestra;
    private javax.swing.Timer t;
    
    
    String hour,date;
    
    public RelojAnalogo() {
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(250,250));
        t = new javax.swing.Timer(1000, (ActionEvent e) -> {
            update();
        });
    }
 
    public void update() {
        this.repaint();
    }
 
    public void start() {
        t.start();
    }
    public void stop() {
        t.stop();
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
 
        int ancho = getWidth();
        int alto = getHeight();
        
        tamano = ((ancho < alto) ? ancho : alto) - 2*espacio;
        xCentro = tamano/2 + espacio;
        yCentro = tamano/2 + espacio;
        
        if (muestra == null
                || muestra.getWidth() != ancho
                || muestra.getHeight() != alto) {
            
            muestra = (BufferedImage)(this.createImage(ancho, alto));
            Graphics2D gc = muestra.createGraphics();
            gc.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);
            caraReloj(gc);
        }
 
        Calendar now = Calendar.getInstance();
        horas   = now.get(Calendar.HOUR);
        minutos = now.get(Calendar.MINUTE);
        segundos = now.get(Calendar.SECOND); 
        
        String ampm = now.get(Calendar.AM_PM)==Calendar.AM?"a.m.":"p.m.";
        SimpleDateFormat reloj = new SimpleDateFormat("hh:mm:ss");
        SimpleDateFormat fecha = new SimpleDateFormat("EEEE, dd"+"' de '"+"MMMM"+" 'del' "+"yyyy");
        hour = reloj.format(now.getTime())+" "+ampm;
        char[] caracteres = fecha.format(now.getTime()).toCharArray();
             for (int i = 0; i < fecha.format(now.getTime()).length()- 2; i++)
                if (caracteres[i] == ' ' || caracteres[i] == '.' || caracteres[i] == ',')
                    caracteres[i + 1] = Character.toUpperCase(caracteres[i + 1]);
             
        date = String.valueOf(caracteres).toUpperCase();
        
        g2.drawImage(muestra, null, 0, 0);
 
        Manecillas(g);
    }
    
    private void caraReloj(Graphics g) {
        
        g.setColor(Color.white);
        g.fillOval(espacio-5, espacio-5, tamano+10, tamano+10);
        g.setColor(Color.black);
        g.drawOval(espacio-5, espacio-5, tamano+10, tamano+10);
        
        g.setColor(new Color(238,238,238));
        g.fillOval(espacio, espacio, tamano, tamano);
        g.setColor(Color.black);
        g.drawOval(espacio, espacio, tamano, tamano);
        
        g.setColor(Color.black);
        g.fillOval(tamano/2+7, tamano/2+6, 6,6);
        g.setColor(Color.black);
        g.drawOval(tamano/2+7, tamano/2+6, 6,6);
        
        
        for (int seg = 0; seg<60; seg++) {
            int inicio;
            
            if (seg%5 == 0) {
                g.setColor(Color.BLACK);
                Graphics2D g2d = (Graphics2D)g;
                g2d.setStroke(new BasicStroke(2));
                inicio = tamano/2-8;
                
                //g.drawString(""+numero, (int) (rad*seg), inicio);
            } else {
                g.setColor(Color.gray);
                Graphics2D g2d = (Graphics2D)g;
                g2d.setStroke(new BasicStroke(1));
                inicio = tamano/2-3;
            }
            diseno(g, xCentro, yCentro, rad*seg, inicio , tamano/2);
        }
    }
        private void Manecillas(Graphics g) {
        int radioSegundero = tamano/2;
        int radioMinutero = radioSegundero * 3/4;
        int radioHora   = radioSegundero/2 + 8;
        
        g.setColor(Color.GRAY);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(1));
        float fsegundos = segundos;
        float anguloSegundero = tresPi - (rad * fsegundos);
        diseno(g, xCentro, yCentro, anguloSegundero, -15, radioSegundero-10);
        
        Graphics2D gd = (Graphics2D)g;
        gd.setStroke(new BasicStroke(2));
        
        g.setColor(Color.darkGray);
        float fminutos = (float)(minutos + fsegundos/60.0);
        float anguloMinutero = tresPi - (rad * fminutos);
        diseno(g, xCentro, yCentro, anguloMinutero, -10, radioMinutero+5);
 
        g.setColor(Color.black);
        float fhours = (float)(horas + fminutos/60.0);
        float anguloHora = tresPi - (5 * rad * fhours);
        diseno(g, xCentro, yCentro, anguloHora, -5, radioHora);
        
        g.drawString("12", tamano/2+4 , 32 );
        g.drawString("3", tamano-15 , tamano/2+14 );
        g.drawString("6", tamano/2+6 , getHeight()-25);
        g.drawString("9", (+tamano-tamano)+25 , tamano/2+14 );
        
        
        g.setColor(Color.BLACK);
        Font font2 = new Font("Arial", Font.BOLD, 18);
        g.setFont(font2);
        g.drawString( hour ,( tamano / 2 ) - 45 , getHeight() - 80 );
        this.setToolTipText(hour);
        }
 
    private void diseno(Graphics g, int x, int y, double angulo, int minRadius, int maxRadius) {
        float sine   = (float)Math.sin(angulo);
        float cosine = (float)Math.cos(angulo);
 
        int dxmin = (int)(minRadius * sine);
        int dymin = (int)(minRadius * cosine);
 
        int dxmax = (int)(maxRadius * sine);
        int dymax = (int)(maxRadius * cosine);
        g.drawLine( x+dxmin, y+dymin, x+dxmax, y+dymax);
    }
}