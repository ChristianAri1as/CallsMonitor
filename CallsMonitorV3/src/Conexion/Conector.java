package Conexion;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 * @author Christian
 */
public class Conector {
    

    public static Connection conect = null;        

    static public String 
        base                =       "",//"sistemas"          ,
        clave               =       "",//"milenio"           ,
        ip                  =       "",//"192.168.1.226:"    ,
        puerto              =       "",//"3306/"             ,
        usuario             =       "",//"root"              ,
        conector            =       "jdbc:mysql://"     ,
        dateTime            =       "?zeroDateTimeBehavior=convertToNull";
    
    static public String ext = "";    
    static String dir;
    
    public static void cargar_conexion(){        
        try{
            String linea = "";
            String so = System.getProperty("os.name");
            if(so.contains("Windows")){
                dir = new File(".").getCanonicalPath().replace("\\", "\\\\")+"\\\\conexion.txt";
            }else if(so.contains("Linux")){
                dir = new File(".").getCanonicalPath().replace("\\", "\\\\")+"/conexion.txt";
            }
            File archivo = new File(Principal.Ubicacion.main()+"conexion.txt");
            if(archivo.exists()){
                try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                    while((linea=br.readLine())!=null){
                        String[] array = linea.split(",");
                        base        =   array.length          >     0   ?   array[0]          :     "";
                        clave       =   array.length          >     1   ?   array[1]          :     "";
                        ip          =   array.length          >     2   ?   array[2]          :     "";
                        puerto      =   array.length          >     3   ?   array[3]          :     "";
                        usuario     =   array.length          >     4   ?   array[4]          :     "";
                    }
                }
            }else{
                archivo.createNewFile();
                try (PrintWriter wr = new PrintWriter(new BufferedWriter( new FileWriter(archivo)))) {
                    
                    String b = (String) JOptionPane.showInputDialog(null, "Base de datos","Base de datos",JOptionPane.QUESTION_MESSAGE,null,null,"asteriskcdrdb");
                    String c = (String) JOptionPane.showInputDialog(null, "Contraseña","Contraseña",JOptionPane.QUESTION_MESSAGE,null,null,"");
                    String i = (String) JOptionPane.showInputDialog(null, "Direccion ip","Direccion IP",JOptionPane.QUESTION_MESSAGE,null,null,"192.168.1.241");
                    String p = (String) JOptionPane.showInputDialog(null, "Puerto","Puerto",JOptionPane.QUESTION_MESSAGE,null,null,"3306");
                    String u = (String) JOptionPane.showInputDialog(null, "Usuario","Usuario",JOptionPane.QUESTION_MESSAGE,null,null,"root");
                    
                    //wr.write("sistemas,arias,localhost:,3306/,root");
                    wr.write(b+","+c+","+i+":,"+p+"/,"+u);
                }
                cargar_conexion();
            }
        }catch(IOException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            Logs.Logs l = new Logs.Logs(Reloj.Reloj.date+Reloj.Reloj.hour_24+" "+e.getMessage());
        }
    }
    
    public static Connection conexion(){
        cargar_conexion();
        try{        
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conect = DriverManager.getConnection(conector+ip+puerto+base+dateTime,usuario,clave);            
        }catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            Logs.Logs l = new Logs.Logs(Reloj.Reloj.date+Reloj.Reloj.hour_24+" "+e.getMessage());
        }        
        return conect;        
    }
    
    
}
