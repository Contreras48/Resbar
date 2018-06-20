
package Personalizacion;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author mateo
 */
public class MiRender extends JLabel implements TableCellRenderer{
    boolean isBordered = true;
    String accion;

    public MiRender(boolean isBordered, String accion) {
        this.isBordered = isBordered;
        this.accion = accion;
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object color, boolean isSelected, boolean hasFocus, int row, int column) {
        
        return new JButton(accion);

    }
    
}
