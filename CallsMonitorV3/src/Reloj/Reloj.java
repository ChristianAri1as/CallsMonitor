/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reloj;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author Christian
 */
public class Reloj {
    
    public static String hour_12,hour_24,date,ampm;
    
    public static String newHora;
    
    public static void reloj(){
        java.util.Calendar calendario = new java.util.GregorianCalendar(); 
        
        Timer timer = new Timer(1000, (ActionEvent e) -> {
            Date actual = new Date();
            calendario.setTime(actual);
            Calendar now = Calendar.getInstance(); 
            ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"a.m.":"p.m.";
            SimpleDateFormat reloj_12 = new SimpleDateFormat("hh:mm:ss");
            SimpleDateFormat reloj_24 = new SimpleDateFormat("HH:mm:ss");
            
            SimpleDateFormat fecha = new SimpleDateFormat("EEEE, dd"+"' de '"+"MMMM"+" 'del' "+"yyyy");
            SimpleDateFormat day = new SimpleDateFormat("EEEE");
            //SimpleDateFormat fechasimple = new SimpleDateFormat("yyyy/MM/dd");
            hour_12 = reloj_12.format(calendario.getTime());
            hour_24 = reloj_24.format(calendario.getTime());
            
            char[] caracteres = fecha.format(calendario.getTime()).toCharArray();
            for (int i = 0; i < fecha.format(calendario.getTime()).length()- 2; i++)
                if (caracteres[i] == ' ' || caracteres[i] == '.' || caracteres[i] == ',')
                    caracteres[i + 1] = Character.toUpperCase(caracteres[i + 1]);
            char[] dia = day.format(calendario.getTime()).toCharArray();
            for (int i = 0;i<String.valueOf(dia).length()-2;i++)
                if(dia[i] == ' ' || dia[i] == '.' || dia[i] == ',')
                    dia[i+1] = Character.toUpperCase(dia[i+1]);
            
            String t[] = hour_24.split(":");
            newHora = t[0]+":"+(Integer.parseInt(t[1])-1)+":"+t[2];
            date = String.valueOf(caracteres).toUpperCase();
            
            Principal.pantalla.jLabel1.setText( date +","+hour_12+" "+ampm );
            Principal.pantalla.jLabel1.setToolTipText(String.valueOf(caracteres));
            
        });
        timer.start();
    }
}
