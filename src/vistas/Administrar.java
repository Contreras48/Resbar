/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Personalizacion.RedondearBorde;
import Personalizacion.RenderColor;
import java.awt.Color;
import java.util.Enumeration;
import javax.swing.DefaultListModel;
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

        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstAdminCategorias = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(Color.decode("#2A3132"));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/nueva32.jpg"))); // NOI18N
        btnNuevo.setFocusPainted(false);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setText("ModificaR");
        btnModificar.setFocusPainted(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusPainted(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setForeground(Color.decode("#90AFC5"));
        jLabel1.setText("Administrar");

        jScrollPane1.setViewportView(lstAdminCategorias);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(Color.decode("#90AFC5"));
        jLabel5.setText("Categorias");

        tblProducto.setBackground(Color.decode("#90AFC5"));
        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblProducto);

        jLabel2.setText("Administrar Categoria");

        jLabel3.setText("Administrar Productos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)))
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(58, 58, 58)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed


       
//        AMProducto amp;
//        AMCategoria amc;
//        int pestaña = jtpContenedorAdministrar.getSelectedIndex();
        
//        if(pestaña == 0){
//            amp = new AMProducto("Agregar producto");
//            amp.setVisible(true);
//            
//            
//            amp.setBackground(Color.decode("#2A3132"));
//        }else{
//            amc = new AMCategoria("Agregar categoria");
//            amc.setVisible(true);
//            
//            amc.setBackground(Color.decode("#2A3132"));
//        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        AMProducto amp;
        AMCategoria amc;
//        int pestaña = jtpContenedorAdministrar.getSelectedIndex();
        
//        if(pestaña == 0){
//            amp = new AMProducto("Modificar producto");
//            amp.setVisible(true);
//        }else{
//            amc = new AMCategoria("Modificar categoria");
//            amc.setVisible(true);
//        }
    }//GEN-LAST:event_btnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstAdminCategorias;
    private javax.swing.JTable tblProducto;
    // End of variables declaration//GEN-END:variables
}
