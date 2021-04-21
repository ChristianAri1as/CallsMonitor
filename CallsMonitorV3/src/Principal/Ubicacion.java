/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author ChristianArias
 */
public class Ubicacion {
    
    public static String main(){
        String dir = "";
        try{
            String so = System.getProperty("os.name");
            if(so.contains("Windows")){
                dir = new File(".").getCanonicalPath().replace("\\", "\\\\")+"\\\\";
            }else if(so.contains("Linux")){
                dir = new File(".").getCanonicalPath().replace("\\", "\\\\")+"/";
            }
        }catch(IOException ex){
            Logs.emergen.mostrar(ex.getMessage(), "Error");
            Logs.Logs l = new Logs.Logs(Reloj.Reloj.date+Reloj.Reloj.hour_24+" "+ex.getMessage());
        }
        return dir;
    }    
    
}
