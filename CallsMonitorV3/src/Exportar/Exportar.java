/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exportar;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author black
 */
public class Exportar {
    
    static long t0,t1;
    
    public static void toExcel(DefaultTableModel modelo){
        String ruta = "C:\\Users\\"+System.getProperty("user.name")+"\\desktop";
        JFileChooser seleccionar = new JFileChooser(ruta);
        String sucursal = String.valueOf("Contact Center");
        File archivo;
        if(seleccionar.showDialog(null, "Exportar a Excel") == JFileChooser.APPROVE_OPTION){
            archivo = seleccionar.getSelectedFile();
            int cantFila = modelo.getRowCount();
            int cantColumna = modelo.getColumnCount();
            Workbook wb;
            wb = new XSSFWorkbook();
            
            Sheet hoja = wb.createSheet(sucursal);
            
            try{
                for (int i = -1;i < cantFila;i++){
                    Row fila = hoja.createRow(i+1);
                    for(int j = 0;j<cantColumna;j++){
                        Cell celda = fila.createCell(j);
                        if(i == -1){
                            celda.setCellValue(String.valueOf(modelo.getColumnName(j)));
                        }else{
                            try{
                                celda.setCellValue(Integer.parseInt(String.valueOf(modelo.getValueAt(i, j))));
                            }catch(NumberFormatException e){
                                celda.setCellValue(String.valueOf(modelo.getValueAt(i, j)));
                            }
                        }
                        FileOutputStream export = new FileOutputStream(archivo+".xlsx");
                        wb.write(export);
                    }
                }
                
                t1 = System.currentTimeMillis();
                Logs.emergen.mostrar("El archivo se ah creado\n"+((t1-t0)*100/60)+" s", "");
                Desktop.getDesktop().open(new File(archivo+".xlsx"));                    
                                
            }catch(Exception e){
                Logs.Logs l = new Logs.Logs(Reloj.Reloj.date+Reloj.Reloj.hour_24+" "+e.getMessage());
            }
        }
    }
    
}
