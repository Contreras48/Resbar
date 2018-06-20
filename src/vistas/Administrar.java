/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Modelo.Categoria;
import Modelo.ErrorAplicacion;
import Modelo.ManejadorCategorias;
import Modelo.ManejadorProductos;
import Modelo.Producto;
import Personalizacion.RedondearBorde;
import Personalizacion.RenderColor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
//import java.awt.event.ActionEvent;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
//import javax.swing.DefaultListModel;
//import javax.swing.ImageIcon;
//import javax.swing.JMenuItem;
//import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author mateo
 */
public class Administrar extends javax.swing.JPanel {
    int[] anchoProducto = {50, 300, 300, 50};
    int[] anchoCategoria = {50, 600};
    String[] titulosCategoria = {"Id", "Nombre"};
    String[][] datosCategoria = {{"001", "Bebidas"}, {"002", "Bocas"}, {"003", "Entredas"}, {"004", "Plato fuerte"}, {"005", "Postre"}, {"006", "Sopas"}};
    String[] titulosProducto = {"Id_Prod", "Nombre", "Categoria", "Precio"};
    String[][] datosProducto = {{"001", "Pepsi", "Bebidas", "$0.75"},
    {"002", "Café", "Bebidas", "$0.75"},
    {"003", "Tres leches", "Postre", "$1.50"},
    {"004", "Pastel de Chocolate", "Postre", "$1.75"},
    {"005", "Pollo asado", "Plato fuerte", "$2.00"}};
    public static DefaultTableModel modeloCategoria;
    public static DefaultTableModel modeloProducto;
    public static List<Categoria> listaCategoria = new ArrayList<>();
    public static List<Categoria> listaProducto = new ArrayList<>();

    /**
     * Creates new form Administrar
     */
    public Administrar() {
        
        initComponents();
        modeloProducto = new DefaultTableModel(new Object[0][0], titulosProducto) {
            @Override
            public final boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblProducto.setModel(modeloProducto);
        modeloCategoria = new DefaultTableModel(new Object[0][0], titulosCategoria) {
            @Override
            public final boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        modeloCategoria = new DefaultTableModel(new Object[0][0], titulosCategoria) {
            boolean[] editable = {false, false, true};
            
            @Override
            public final boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tblCategoria.setModel(modeloCategoria);
        modeloCategoria = new DefaultTableModel(new Object[0][0], titulosCategoria) {
            @Override
            public final boolean isCellEditable(int row, int column) {
                return false;
            }
        };
         
        tblProducto.setModel(modeloProducto);
        tblCategoria.setModel(modeloCategoria);
        personalizarComponentes(tblProducto, anchoProducto);
        personalizarComponentes(tblCategoria, anchoCategoria);
        try {
            listaCategoria = ManejadorCategorias.obtener(true);
        } catch (ErrorAplicacion ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        cargarCategorias();
        cargarProductos();
        }
    
    public final void personalizarComponentes(JTable tabla, int[] ancho){
        //Tabla Productos
        Enumeration<TableColumn> en = tabla.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
//            tc.setCellRenderer(new RenderColor(new Color(179, 210, 238)));
        }
        tabla.setRowHeight(20);
        TableColumnModel tcm = tabla.getColumnModel();
        for (int i = 0; i < ancho.length; i++) {
//            tcm.getColumn(i).setPreferredWidth(ancho[i]);
        }
        poputTable();
    }

    public static void cargarProductos() {
        for (int i = 0; i < listaCategoria.size(); i++) {
            for (int j = 0; j < listaCategoria.get(i).productos.size(); j++) {
                Object[] fila = new Object[4];
                fila[0] = listaCategoria.get(i).productos.get(j).idProducto;
                fila[1] = listaCategoria.get(i).productos.get(j).nombre;
                fila[3] = listaCategoria.get(i).productos.get(j).precio;
                fila[2] = listaCategoria.get(i).productos.get(j).categoria.nombre;
                modeloProducto.addRow(fila);
            }
        }

    // Instanciamos el TableRowSorter y lo añadimos al JTable
    TableRowSorter<TableModel> sortProd = new TableRowSorter<TableModel>(Administrar.modeloProducto);
    Administrar.tblProducto.setRowSorter(sortProd);
    
    sortProd.toggleSortOrder(0);
    
        
    }
    
    public static void cargarCategorias(){
        for (int i = 0; i < listaCategoria.size(); i++) {
            Object[] fila = new Object[2];
            fila[0] = listaCategoria.get(i).idCategoria;
            fila[1] = listaCategoria.get(i).nombre;
            modeloCategoria.addRow(fila);
        }
    }
    
    public void filtrarCategoria(String consulta, JTable tblJTable){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(modeloCategoria);
        tblJTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }
    
    public void filtrarProducto(String consulta, JTable tblJTable){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(modeloProducto);
        tblJTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }
    
       public void poputTable() {

        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem menuItem1 = new JMenuItem("Modificar", new ImageIcon(getClass().getResource("/Recursos/modificarOrden.png")));
        JMenuItem menuItem2 = new JMenuItem("Eliminar", new ImageIcon(getClass().getResource("/Recursos/imprimir.png")));;

        menuItem1.addActionListener((ActionEvent e) -> {
            AMProducto amp;
            AMCategoria amc;
            int pestaña = jtpContenedorAdministrar.getSelectedIndex();

            if (pestaña == 0) {
                if (tblProducto.getRowSelectionAllowed()) {
                    int fila = tblProducto.getSelectedRow();
                    int columna= tblProducto.getSelectedColumn();
                    
                    amp = new AMProducto("Modificar categoria");
                    amp.setVisible(true);
                    
                    AMProducto.txtId.setText((tblProducto.getValueAt(fila, 0).toString()));
                    AMProducto.txtNombre.setText(tblProducto.getValueAt(fila, 1).toString());
                    AMProducto.txtPrecio.setText(tblProducto.getValueAt(fila, 3).toString());
                    
                    for (int i = 0; i < AMProducto.cmbCategoria.getItemCount(); i++) {
                        if(AMProducto.cmbCategoria.getItemAt(i).equals(tblProducto.getValueAt(fila, 2).toString())){
                            AMProducto.cmbCategoria.setSelectedIndex(i);
                        }
                    }
                    
                    
                }

            } else {
                if (tblCategoria.getRowSelectionAllowed()) {
                    int fila = tblCategoria.getSelectedRow();
                    int columna= tblCategoria.getSelectedColumn();
                    
                    amc = new AMCategoria("Modificar categoria");
                    amc.setVisible(true);
                    
                    AMCategoria.txtId.setText((tblCategoria.getValueAt(fila, 0).toString()));
                    AMCategoria.txtNombre.setText(tblCategoria.getValueAt(fila, 1).toString());
                    
                }
            }
       
        });

        menuItem2.addActionListener((ActionEvent e) -> {
            AMProducto amp;
            AMCategoria amc;
            int pestaña = jtpContenedorAdministrar.getSelectedIndex();

            if (pestaña == 0) {
                if(tblProducto.getRowSelectionAllowed()){
                    int fila= tblProducto.getSelectedRow();
                    
                    Producto pro= new Producto();
                    pro.idProducto=fila+1;
                    
                    try {
                        ManejadorProductos.eliminar(pro);
                        modeloProducto.removeRow(fila);
                    } catch (ErrorAplicacion ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                    
                    
                }

            } else {
                if(tblCategoria.getRowSelectionAllowed()){
                    int fila= tblCategoria.getSelectedRow();
                    
                    Categoria cat= new Categoria();
                    cat.idCategoria=fila+1;
                    
                    try {
                        ManejadorCategorias.eliminar(cat);
                        modeloCategoria.removeRow(fila);
                    } catch (ErrorAplicacion ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                    
                    
                }
            }
   
        });

        popupMenu.add(menuItem1);
        popupMenu.add(menuItem2);
        tblCategoria.setComponentPopupMenu(popupMenu);
        tblProducto.setComponentPopupMenu(popupMenu);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jtpContenedorAdministrar = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtBuscarProducto = new RedondearBorde("/Recursos/buscar.png");
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtBuscarCategoria = new RedondearBorde("/Recursos/buscar.png");
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCategoria = new javax.swing.JTable();
        btnNuevaCategoria = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblFondo2 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel4.setForeground(Color.decode("#662E1C"));
        jLabel4.setText("Administrar");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 240, 30));

        txtBuscarProducto.setBackground(Color.decode("#AF4425"));
        txtBuscarProducto.setForeground(java.awt.Color.white);
        txtBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProductoKeyReleased(evt);
            }
        });

        tblProducto.setAutoCreateRowSorter(true);
        tblProducto.setBackground(Color.decode("#C9A66B"));
        tblProducto.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        tblProducto.setForeground(java.awt.Color.white);
        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Categoria", "Precio"
            }
        ));
        tblProducto.setSelectionBackground(Color.decode("#EBDCB2"));
        jScrollPane1.setViewportView(tblProducto);

        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel3.setForeground(Color.decode("#90AFC5"));
        jLabel3.setText("Nuevo Producto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3))
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addGap(19, 19, 19))
        );

        jtpContenedorAdministrar.addTab("Productos", jPanel1);

        txtBuscarCategoria.setBackground(Color.decode("#AF4425"));
        txtBuscarCategoria.setForeground(java.awt.Color.white);
        txtBuscarCategoria.setText("Buscar categoria");
        txtBuscarCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarCategoriaKeyReleased(evt);
            }
        });

        tblCategoria.setBackground(Color.decode("#C9A66B")
        );
        tblCategoria.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        tblCategoria.setForeground(java.awt.Color.white);
        tblCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nombre"
            }
        ));
        jScrollPane2.setViewportView(tblCategoria);

        btnNuevaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaCategoriaActionPerformed(evt);
            }
        });

        jLabel2.setForeground(Color.decode("#90AFC5"));
        jLabel2.setText("Nueva Categoria");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(0, 143, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(23, 23, 23))
        );

        jtpContenedorAdministrar.addTab("Categorias", jPanel2);

        add(jtpContenedorAdministrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 640, 480));

        lblFondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background/34_Spicy_Neutrals02.png"))); // NOI18N
        add(lblFondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 710));
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        AMProducto amp;
        AMCategoria amc;
        int pestaña = jtpContenedorAdministrar.getSelectedIndex();

        if(pestaña == 0){
            amp = new AMProducto("Agregar producto");
            amp.setVisible(true);

            amp.setBackground(Color.decode("#2A3132"));
        }else{
            amc = new AMCategoria("Agregar categoria");
            amc.setVisible(true);

            amc.setBackground(Color.decode("#2A3132"));
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnNuevaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaCategoriaActionPerformed

AMCategoria nuProd= new AMCategoria("");
                nuProd.setVisible(true);

    }//GEN-LAST:event_btnNuevaCategoriaActionPerformed

    private void txtBuscarCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCategoriaKeyReleased
        filtrarCategoria(txtBuscarCategoria.getText(), tblCategoria);
    }//GEN-LAST:event_txtBuscarCategoriaKeyReleased

    private void txtBuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductoKeyReleased
        filtrarProducto(txtBuscarProducto.getText(), tblProducto);
    }//GEN-LAST:event_txtBuscarProductoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevaCategoria;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jtpContenedorAdministrar;
    private javax.swing.JLabel lblFondo2;
    public static javax.swing.JTable tblCategoria;
    public static javax.swing.JTable tblProducto;
    private javax.swing.JTextField txtBuscarCategoria;
    private javax.swing.JTextField txtBuscarProducto;
    // End of variables declaration//GEN-END:variables

    
        //To change body of generated methods, choose Tools | Templates.
    
}
