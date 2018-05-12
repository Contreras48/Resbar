
package Personalizacion;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author mateo
 */
public class MiRender extends JLabel implements TableCellRenderer{

    boolean isBordered = true;

    public MiRender(boolean isBordered) {
        this.isBordered = isBordered;
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object color, boolean isSelected, boolean hasFocus, int row, int column) {
        
        return new JSpinner();

    }
    
}
