/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Personalizacion.RedondearBorde;
import Personalizacion.RenderColor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Enumeration;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author mateo
 */
public class Administrar extends javax.swing.JPanel {
    
//    int[] anchoProducto = {50, 300, 50};
    int[] anchoCategoria = {50, 600};
    String[] titulosCategoria = {"Id", "Nombre"};
    String[][] datosCategoria = {{"001", "Bebidas"}, {"002", "Bocas"}, {"003", "Entredas"}, {"004", "Plato fuerte"}, {"005", "Postre"}, {"006", "Sopas"}};
    String[] titulosProducto = {"Id", "Nombre", "Precio"};
    String[][] datosProducto = {{"001", "Pepsi", "$0.75"},
                                {"002", "Café", "$0.75"},
                                {"003","Tres leches", "$1.50"},
                                {"004", "Pastel de Chocolate", "$1.75"},
                                {"005", "Pollo asado", "$2.00"}};
    DefaultTableModel modeloCategoria;
    DefaultTableModel modeloProducto;

    /**
     * Creates new form Administrar
     */
    public Administrar() {
        initComponents();
        modeloProducto = new DefaultTableModel(datosProducto, titulosProducto);
        
        ListaCategoria();
        tblProducto.setModel(modeloProducto);
        modeloCategoria = new DefaultTableModel(datosCategoria, titulosCategoria);
//        tblCategoria.setModel(modeloCategoria);
//        personalizarComponentes(tblProducto, anchoProducto);
        personalizarComponentes(tblProducto, anchoCategoria);
//////        this.setResizable(false);
    }
    public final void personalizarComponentes(JTable tabla, int[] ancho){
        //Tabla Productos
        Enumeration<TableColumn> en = tabla.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new RenderColor(new Color(179, 210, 238)));
        }
         tabla.setRowHeight(20);
        TableColumnModel tcm = tabla.getColumnModel();
        for (int i = 0; i < ancho.length; i++) {
            tcm.getColumn(i).setPreferredWidth(ancho[i]);
        }
    }
    public void ListaCategoria(){
        DefaultListModel modeloLista= new DefaultListModel();       
        this.lstAdminCategorias.setModel(modeloLista);        
        modeloLista.addElement("Entradas");
        modeloLista.addElement("plato Fuerte");        
        modeloLista.addElement("Sopas");
        modeloLista.addElement("Bebidas");
        modeloLista.addElement("Bocas");
        modeloLista.addElement("Postres");
        modeloLista.addElement("------------------------");  
        modeloLista.addElement("--------------"); 
        modeloLista.addElement("--------------"); 
        modeloLista.addElement("--------------"); 
        modeloLista.addElement("--------------"); 
        modeloLista.addElement("--------------"); 
        modeloLista.addElement("--------------"); 
        modeloLista.addElement("--------------"); 
        modeloLista.addElement("--------------"); 
        modeloLista.addElement("--------------"); 
        modeloLista.addElement("--------------"); 
        modeloLista.addElement("--------------"); 
        modeloLista.addElement("--------------"); 
        modeloLista.addElement("--------------"); 
        
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        lstAdminCategorias = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnAdmNuevoProductos = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnAdmNuevoProductos1 = new javax.swing.JButton();
        lblFondo__ = new javax.swing.JLabel();

        setBackground(Color.decode("#2A3132"));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel4.setForeground(Color.decode("#662E1C"));
        jLabel4.setText("Administrar");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 340, 30));

        lstAdminCategorias.setBackground(Color.decode("#662E1C"));
        lstAdminCategorias.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        lstAdminCategorias.setForeground(new java.awt.Color(255, 255, 255));
        lstAdminCategorias.setSelectionBackground(Color.decode("#EBDCB2"));
        lstAdminCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstAdminCategoriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstAdminCategorias);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 94, 126, 322));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel6.setForeground(Color.decode("#662E1C"));
        jLabel6.setText("Categorias");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        tblProducto.setBackground(Color.decode("#AF4425"));
        tblProducto.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        tblProducto.setForeground(new java.awt.Color(255, 255, 255));
        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProducto.setSelectionBackground(Color.decode("#EBDCB2"));
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProducto);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 94, 520, 322));

        jLabel2.setForeground(Color.decode("#90AFC5"));
        jLabel2.setText("Nueva Categoria");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 517, -1, -1));

        btnAdmNuevoProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmNuevoProductosActionPerformed(evt);
            }
        });
        add(btnAdmNuevoProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 436, 120, 75));

        jLabel3.setForeground(Color.decode("#90AFC5"));
        jLabel3.setText("Nuevo Producto");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 520, -1, -1));

        btnAdmNuevoProductos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmNuevoProductos1ActionPerformed(evt);
            }
        });
        add(btnAdmNuevoProductos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 436, 120, 75));

        lblFondo__.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background/34_Spicy_Neutrals02.png"))); // NOI18N
        add(lblFondo__, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 580));
    }// </editor-fold>//GEN-END:initComponents

    private void lstAdminCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstAdminCategoriasMouseClicked
//         public void poputTable(){
    
        JPopupMenu popupMenu = new JPopupMenu ();
        
        JMenuItem menuItem1 = new JMenuItem("Modificar Categoria", new ImageIcon(getClass().getResource("/Recursos/modificarProductos.png")));
        JMenuItem menuItem2 = new JMenuItem("Eliminar Categoria", new ImageIcon(getClass().getResource("/Recursos/imprimir.png")));
//        JMenuItem menuItem3 = new JMenuItem("Modificar Cuenta", new ImageIcon(getClass().getResource("/Recursos/modificarOrden.png")));
//        JMenuItem menuItem4 = new JMenuItem("Cobrar", new ImageIcon(getClass().getResource("/Recursos/cobrar.png")));
        
        menuItem1.addActionListener((ActionEvent e) -> {            
//            MenuAgregar p = new MenuAgregar();
//            p.setVisible(true);   
        });
        
        menuItem2.addActionListener((ActionEvent e) -> {            
//            NuevaOrden nvo = new NuevaOrden();
//            nvo.setVisible(true);   
        });
        
//        menuItem4.addActionListener((ActionEvent e) -> {            
//            Cobrar co = new Cobrar();
//            co.setVisible(true);   
//        });
//        
        popupMenu.add(menuItem1);
        popupMenu.add(menuItem2);
//        popupMenu.add(menuItem3);
//        popupMenu.add(menuItem4);
        lstAdminCategorias.setComponentPopupMenu(popupMenu);
        tblProducto.setComponentPopupMenu(popupMenu);
//    }
    }//GEN-LAST:event_lstAdminCategoriasMouseClicked

    private void btnAdmNuevoProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmNuevoProductosActionPerformed
        AMCategoria nuCat = new AMCategoria();
        nuCat.setVisible(true);
        
    }//GEN-LAST:event_btnAdmNuevoProductosActionPerformed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        JPopupMenu popupMenu = new JPopupMenu ();
        
        JMenuItem menuItem1 = new JMenuItem("Modificar Producto", new ImageIcon(getClass().getResource("/Recursos/modificarProductos.png")));
        JMenuItem menuItem2 = new JMenuItem("Eliminar Producto", new ImageIcon(getClass().getResource("/Recursos/imprimir.png")));
//        JMenuItem menuItem3 = new JMenuItem("Modificar Cuenta", new ImageIcon(getClass().getResource("/Recursos/modificarOrden.png")));
//        JMenuItem menuItem4 = new JMenuItem("Cobrar", new ImageIcon(getClass().getResource("/Recursos/cobrar.png")));
        
        menuItem1.addActionListener((ActionEvent e) -> {            
            AMProducto p = new AMProducto();
            p.setVisible(true);   
        });
        
        menuItem2.addActionListener((ActionEvent e) -> {            
//            NuevaOrden nvo = new NuevaOrden();
//            nvo.setVisible(true);   
        });
        
//        menuItem4.addActionListener((ActionEvent e) -> {            
//            Cobrar co = new Cobrar();
//            co.setVisible(true);   
//        });
//        
        popupMenu.add(menuItem1);
        popupMenu.add(menuItem2);
//        popupMenu.add(menuItem3);
//        popupMenu.add(menuItem4);
//        lstAdminCategorias.setComponentPopupMenu(popupMenu);
        tblProducto.setComponentPopupMenu(popupMenu);
    }//GEN-LAST:event_tblProductoMouseClicked

    private void btnAdmNuevoProductos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmNuevoProductos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdmNuevoProductos1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmNuevoProductos;
    private javax.swing.JButton btnAdmNuevoProductos1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFondo__;
    private javax.swing.JList<String> lstAdminCategorias;
    private javax.swing.JTable tblProducto;
    // End of variables declaration//GEN-END:variables
}
