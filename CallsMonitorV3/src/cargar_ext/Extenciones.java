/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargar_ext;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author ChristianArias
 */
public class Extenciones {
    
    static String dir = "";
    
    public static String extenciones(){
        String ext = "";
            try{
                String linea = "";
                File archivo = new File(Principal.Ubicacion.main()+"ext.txt");
                if(archivo.exists()){
                    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                        while((linea=br.readLine())!=null){
                            ext = linea;
                        }
                    }
                }else{
                    archivo.createNewFile();
                    try (PrintWriter wr = new PrintWriter(new BufferedWriter( new FileWriter(archivo)))) {
                        String b = (String) JOptionPane.showInputDialog(null, "Extenciones","Extenciones",JOptionPane.QUESTION_MESSAGE,null,null,"011");
                        wr.write(b);
                    }
                    extenciones();
                }
            }catch(IOException | HeadlessException ex){
                Logs.Logs l = new Logs.Logs(Reloj.Reloj.date+Reloj.Reloj.hour_24+" "+ex.getMessage());
            }
        return ext;
    }
}
