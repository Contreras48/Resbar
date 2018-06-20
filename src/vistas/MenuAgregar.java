/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Personalizacion.MiEditor;
import Personalizacion.MiRender;
import Personalizacion.RedondearBorde;
import Personalizacion.RenderColor;
import java.awt.Color;
import java.util.Enumeration;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author mateo
 */
public class MenuAgregar extends javax.swing.JFrame {
    DefaultTableModel modelo;
    DefaultListModel modeloLista; 
    Object[] titulos = {"Nombre", "Precio", "Cantidad"};
    Object[][] bebidas = {{"Pepsi", "$0.75", ""},
                          {"Café", "$0.75", ""}};
    Object[][] postres = {{"Tres leches", "$1.50", ""},
                          {"Pastel de Chocolate", "$1.75", ""}};
    Object[][] PlatoFuerte = {{"Pollo asado", "$2.00", ""}};
    
//    modeloLista.

    /**
     * Creates new form Productos
     */
    public MenuAgregar() {
        initComponents();
        setLocationRelativeTo(null);
        
        modelo= new DefaultTableModel(bebidas, titulos);
        tblMenuProductos.setModel(modelo);
        modeloLista=new DefaultListModel();
        lstCategorias.setModel(modeloLista);
        ListaCategoria();
        perzonalizarComponentes();
        setIconImage(new ImageIcon(getClass().getResource("/Recursos/resbarICON_.png")).getImage());
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
        DefaultListModel modeloLista= new DefaultListModel();       
        this.lstCategorias.setModel(modeloLista);        
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
    public void limpiarModelo(){
        for (int i = modelo.getRowCount(); i > 0; i--) {
            modelo.removeRow(i-1);  
        }
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
        lblNuevaOrden = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu | Agregar");
        setAutoRequestFocus(false);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpFondo.setBackground(Color.decode("#2A3132")
        );
        jpFondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpFondo.setOpaque(false);

        btnContinuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosNew/AGREGARALAORDEN.png"))); // NOI18N
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        txtBuscarProducto.setBackground(Color.decode("#AF4425"));
        txtBuscarProducto.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        txtBuscarProducto.setForeground(java.awt.Color.white);

        tblMenuProductos.setBackground(Color.decode("#662E1C"));
        tblMenuProductos.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        tblMenuProductos.setForeground(java.awt.Color.white);
        tblMenuProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblMenuProductos);

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel2.setForeground(Color.decode("#662E1C"));
        jLabel2.setText("Buscar");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosNew/busqueda.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel4.setForeground(Color.decode("#662E1C"));
        jLabel4.setText("Agregar a la Orden");

        lstCategorias.setBackground(Color.decode("#AF4425"));
        lstCategorias.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        lstCategorias.setForeground(java.awt.Color.white);
        lstCategorias.setOpaque(false);
        jScrollPane1.setViewportView(lstCategorias);

        jLabel5.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel5.setForeground(Color.decode("#662E1C"));
        jLabel5.setText("Categorias");

        javax.swing.GroupLayout jpFondoLayout = new javax.swing.GroupLayout(jpFondo);
        jpFondo.setLayout(jpFondoLayout);
        jpFondoLayout.setHorizontalGroup(
            jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFondoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFondoLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jpFondoLayout.createSequentialGroup()
                            .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(46, 46, 46))
        );
        jpFondoLayout.setVerticalGroup(
            jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFondoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addGroup(jpFondoLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel2)))
                .addGap(30, 30, 30)
                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFondoLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        getContentPane().add(jpFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 750));

        lblNuevaOrden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background/Backgrund_05.png"))); // NOI18N
        getContentPane().add(lblNuevaOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        NuevaOrden no =new NuevaOrden();
        no.setVisible(true);
        this.dispose();
        //        no.btnAgregagarProducto.setVisible(false);
    }//GEN-LAST:event_btnContinuarActionPerformed

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
    private javax.swing.JLabel lblNuevaOrden;
    private javax.swing.JList<String> lstCategorias;
    private javax.swing.JTable tblMenuProductos;
    private javax.swing.JTextField txtBuscarProducto;
    // End of variables declaration//GEN-END:variables
}
