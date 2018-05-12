
package Personalizacion;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author mateo
 */
public class RenderColor extends DefaultTableCellRenderer implements TableCellRenderer{
    Color color;
    
    public RenderColor(Color color){
        this.color = color;
    }
    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //establecemos el fondo blanco o vacío
        setBackground(null);
        //COnstructor de la clase DefaultTableCellRenderer
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
 
        //Establecemos las filas que queremos cambiar el color. == 0 para pares y != 0 para impares
        boolean oddRow = (row % 2 == 0);
 
        //Si las filas son pares, se cambia el color a gris
        if (oddRow) {
            setBackground(color);
        }
        return this;
    }
}
