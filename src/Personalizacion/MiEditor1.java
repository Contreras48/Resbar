
package Personalizacion;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.TableCellEditor;
import vistas.MenuAgregar;
import vistas.NuevaOrden;

/**
 *
 * @author mateo
 */
public class MiEditor1 extends AbstractCellEditor implements TableCellEditor, ActionListener{
    Boolean currentValue;
    JSpinner spinner;
    JButton button;

    private final JTable jTable1;
    int c;
    
    public MiEditor1(JTable jTable1, int c, String comando) {
        this.spinner = new JSpinner();
        SpinnerNumberModel spn = new SpinnerNumberModel(0, 0, 100, 1);
        this.spinner.setModel(spn);
        button = new JButton();
        button.setActionCommand(comando);
        button.addActionListener(this);
        button.setBorderPainted(false);
        this.jTable1 = jTable1;
        this.c = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
        //System.out.println(button.getActionCommand());
        int fila = NuevaOrden.tblDetalleOrden.getSelectedRow();
        int valor = 0;
        if(NuevaOrden.tblDetalleOrden.getValueAt(fila, c) != null){
            valor = Integer.parseInt(String.valueOf(NuevaOrden.tblDetalleOrden.getValueAt(fila, c)));
            if (button.getActionCommand().equals("+")) {
                valor += 1;
            } else {
                if (valor > 0) {
                    valor -= 1;
                }
            }
        }
        NuevaOrden.tblDetalleOrden.setValueAt(valor, fila, c);
    }

    @Override
    public Object getCellEditorValue() {
        return currentValue;
    }

    //Implement the one method defined by TableCellEditor.
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        currentValue = (Boolean) value;
        return button;

    }
}
