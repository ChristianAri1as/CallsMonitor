/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Conexion.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ChristianArias
 */
public class Alerta {
    
    Conector conector = new Conector();
    static  Connection cn = Conector.conexion();
    
    public static void main(String ext){
        try{
            String res = "";
            int c = 0;
            boolean b = false;
            String sql = "SELECT DATE_FORMAT(calldate,'%h:%i:%s %p') AS calltime,src,dst,disposition,substring(dstchannel,5,5) as dstchannel FROM cdr "
                + "where dst in ("+ext+") "
                + "and disposition in ('BUSY','FAILED','NO ANSWER') "
                + "and (calldate BETWEEN concat('"+Reloj.Reloj.newHora+"',date(now())) "
                + "and concat(date(now()),' "+Reloj.Reloj.hour_24+"'))";
            
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                b = true;
                c+=1;
                if(rs.getString("src").length() >= 6){
                    res += c+"-. "+Reloj.Reloj.date+" "+rs.getString("calltime")+" LLamada perdida del "+rs.getString("src")+" al destino "+rs.getString("dstchannel")+"\n";
                    Logs.Logs l = new Logs.Logs(res);
                    Principal.pantalla.jTextField1.setText(res);
                    Logs.emergen.mostrar(res, "Llamada perdida");
                }
            }
        }catch(SQLException e){
            Logs.Logs l = new Logs.Logs(Reloj.Reloj.date+Reloj.Reloj.hour_24+" "+e.getMessage());
        }
    }
    
}

/*
String res = "";
        int c = 0;
        boolean b = false;
        String sql = "SELECT DATE_FORMAT(calldate,'%h:%i:%s %p') AS calltime,src,dst,disposition,substring(dstchannel,5,5) as dstchannel FROM cdr "
                + "where dst in ("+ext+") "
                + "and disposition in ('BUSY','FAILED','NO ANSWER') "
                + "and (calldate BETWEEN concat(date(now()),' "+Reloj.Reloj.newHora+"') "
                + "and concat(date(now()),' "+Reloj.Reloj.hour_24+"'))";
        
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                b = true;
                c+=1;
                if(rs.getString("src").length() >= 6){
                    res += c+"-. "+Reloj.Reloj.date+" "+rs.getString("calltime")+" LLamada perdida del "+rs.getString("src")+" al destino "+rs.getString("dstchannel")+"\n";
                    Logs.Logs l = new Logs.Logs(res);
                    Principal.pantalla.jTextField1.setText(res);
                    Logs.emergen.mostrar(res, "Llamada perdida");
                }
            }
*/
