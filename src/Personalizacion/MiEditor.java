
package Personalizacion;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author mateo
 */
public class MiEditor extends AbstractCellEditor implements TableCellEditor, ActionListener{
    Object currentValue;
    JSpinner spinner;
    private final JTable jTable1;

    public MiEditor(JTable jTable1) {
        this.spinner = new JSpinner();
        SpinnerNumberModel spn = new SpinnerNumberModel(0, 0, 100, 1);
        this.spinner.setModel(spn);
        this.jTable1 = jTable1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
    }

    @Override
    public Object getCellEditorValue() {
        return currentValue;
    }

    //Implement the one method defined by TableCellEditor.
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        currentValue = /*(Boolean)*/ value;
        return spinner;

    }
}
