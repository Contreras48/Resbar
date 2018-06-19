/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Modelo.Categoria;
import Modelo.ErrorAplicacion;
import Modelo.ManejadorCategorias;
import Personalizacion.MiEditor;
import Personalizacion.MiRender;
import Personalizacion.RedondearBorde;
import Personalizacion.RenderColor;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author mateo
 */
public class MenuAgregar extends javax.swing.JFrame {
    DefaultTableModel modelo;
    DefaultListModel modeloLista; 
    Object[] titulos = {"Nombre", "Precio", "Cantidad"};
    List<Integer> ids = new ArrayList<>();
    List<Categoria> categoria;

    /**
     * Creates new form Productos
     */
    public MenuAgregar() {
        initComponents();
        setLocationRelativeTo(null);
        
        modelo = new DefaultTableModel(new Object[0][0], titulos){
            boolean[] editable = {false, false, true};
            @Override
            public final boolean isCellEditable(int row, int column) {
                return this.editable[column];
            }
        };
        tblMenuProductos.setModel(modelo);
        modeloLista = new DefaultListModel();
        lstCategorias.setModel(modeloLista);
        try {
            this.categoria = ManejadorCategorias.obtener(true);
        } catch (ErrorAplicacion ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage() );
        }
        ListaCategoria();
        perzonalizarComponentes();
        setIconImage(new ImageIcon(getClass().getResource("/Recursos/restaur.png")).getImage());
        this.setResizable(false);
    }
    
    public final void perzonalizarComponentes(){
      
        TableColumn agregarColumn;
        agregarColumn = tblMenuProductos.getColumnModel().getColumn(2);
        agregarColumn.setCellEditor(new MiEditor(tblMenuProductos));
        agregarColumn.setCellRenderer(new MiRender(true));
        tblMenuProductos.setRowHeight(20);
        
        TableColumnModel tcm = tblMenuProductos.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(300);
        tcm.getColumn(1).setPreferredWidth(50);
        tcm.getColumn(2).setPreferredWidth(50);
    }
    
    public void ListaCategoria(){
        for (int i = 0; i < categoria.size(); i++) {
             modeloLista.addElement(categoria.get(i).nombre);
             ids.add(categoria.get(i).idCategoria);
        } 
    }
    
    public void limpiarModelo(){
        for (int i = modelo.getRowCount(); i > 0; i--) {
            modelo.removeRow(i-1);  
        }
    }
    
    public void actualizarTabla(Integer index){
        limpiarModelo();
        for (int i = 0; i < categoria.get(index).productos.size(); i++) {
            Object[] fila = new Object[2];
            fila[0] = categoria.get(index).productos.get(i).nombre;
            fila[1] = categoria.get(index).productos.get(i).precio;
            modelo.addRow(fila);
        }
    }
    
    public void filtrar(String consulta, JTable tblJTable){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(modelo);
        tblJTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpFondo = new javax.swing.JPanel();
        btnContinuar = new javax.swing.JButton();
        txtBuscarProducto = new RedondearBorde("/Recursos/buscar.png");
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMenuProductos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCategorias = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu | Agregar");
        setAutoRequestFocus(false);
        setResizable(false);

        jpFondo.setBackground(Color.decode("#2A3132")
        );
        jpFondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnContinuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/guardar16.jpg"))); // NOI18N
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        txtBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProductoKeyReleased(evt);
            }
        });

        tblMenuProductos.setBackground(Color.decode("#90AFC5"));
        tblMenuProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblMenuProductos);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(Color.decode("#90AFC5"));
        jLabel2.setText("Buscar");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/buscar.jpg"))); // NOI18N

        jLabel4.setForeground(Color.decode("#90AFC5"));
        jLabel4.setText("Agregar a la Orden");

        lstCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstCategoriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstCategorias);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(Color.decode("#90AFC5"));
        jLabel5.setText("Categorias");

        javax.swing.GroupLayout jpFondoLayout = new javax.swing.GroupLayout(jpFondo);
        jpFondo.setLayout(jpFondoLayout);
        jpFondoLayout.setHorizontalGroup(
            jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFondoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFondoLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addGap(18, 18, 18)
                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpFondoLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(txtBuscarProducto))
                    .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jpFondoLayout.setVerticalGroup(
            jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFondoLayout.createSequentialGroup()
                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFondoLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jpFondoLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2)))
                .addGap(26, 26, 26)
                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFondoLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        NuevaOrden no = new NuevaOrden();
        no.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void lstCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstCategoriasMouseClicked
        actualizarTabla(lstCategorias.getSelectedIndex());
    }//GEN-LAST:event_lstCategoriasMouseClicked

    private void txtBuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductoKeyReleased
        filtrar(txtBuscarProducto.getText(), tblMenuProductos);
    }//GEN-LAST:event_txtBuscarProductoKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAgregar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpFondo;
    private javax.swing.JList<String> lstCategorias;
    private javax.swing.JTable tblMenuProductos;
    private javax.swing.JTextField txtBuscarProducto;
    // End of variables declaration//GEN-END:variables
}
