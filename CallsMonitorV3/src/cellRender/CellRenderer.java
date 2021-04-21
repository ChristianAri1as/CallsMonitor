package cellRender;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class CellRenderer extends DefaultTableCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //establecemos el fondo blanco o vacío
        setBackground(null);
        //COnstructor de la clase DefaultTableCellRenderer
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        //
        int align = DefaultTableCellRenderer.CENTER;
        //Alinea el contenido de la tabla al centro
        ((DefaultTableCellRenderer)cellComponent).setHorizontalAlignment(align);
        //Establecemos las filas que queremos cambiar el color. == 0 para pares y != 0 para impares
        boolean oddRow = (row % 2 != 0);
        //Creamos un color para las filas. 226,226,226 en RGB es un color gris
        Color c = new Color(226,226,226);
        //Establece el tipo de letra y tamaño
        /*
        Tipos de font:
        Dialog  Courier Monospaced
        */
        table.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        //Si las filas son impares, se cambia el color a gris
        if (oddRow) {
            setBackground(c);
        }   
        /*table.setCellSelectionEnabled(true);
        if(isSelected){
            setBackground(Color.blue);
            setForeground(Color.black);
            setBackground((row%2!=0) ? Color.white : c);
        }else{
            setBackground(Color.white);
            setForeground(Color.black);
            setBackground((row%2!=0) ? Color.white : c);
        }*/
        return this;
    }

}