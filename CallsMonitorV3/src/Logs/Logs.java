/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ChristianArias
 */
public final class Logs {
    
    File dir;
    
    public Logs(String s){
        try {
            String so = System.getProperty("os.name");
                if(so.contains("Windows")){
                    dir = new File(new File(".").getCanonicalPath().replace("\\", "\\\\")+"\\\\Logs.txt");  
                }else if(so.contains("Linux")){
                    dir = new File(new File(".").getCanonicalPath().replace("\\", "\\\\")+"/Logs.txt");
                }
            if(dir.exists()){
                escribir(Reloj.Reloj.date+" "+Reloj.Reloj.hour_24+" "+s);
            }else{
                dir.createNewFile();
                escribir(Reloj.Reloj.date+" "+Reloj.Reloj.hour_24+" "+s);
            }
        } catch (IOException ex){}
    }
    
    void escribir(String s){
        FileWriter fichero = null; 
        PrintWriter pw = null; 
        try{
            fichero = new FileWriter(dir.getAbsolutePath(),true);
            pw = new PrintWriter(fichero);
            pw.println(s);
        }catch(Exception e){}finally{
            try {
                if (null != fichero)
                    fichero.close();
            } catch (IOException ex) {}
        }
    }
    
}
