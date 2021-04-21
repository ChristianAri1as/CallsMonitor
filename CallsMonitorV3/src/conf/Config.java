/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conf;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author ChristianArias
 */
public class Config {
    
    public static Image imagen(){
        Image icon = Toolkit.getDefaultToolkit().getImage(Conexion.Conector.conexion()+"Logo.png");
        return icon;
    }
    
}
