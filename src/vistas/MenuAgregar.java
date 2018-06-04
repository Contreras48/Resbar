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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author mateo
 */
public class MenuAgregar extends javax.swing.JFrame {
    DefaultTableModel modelo;
    Object[] titulos = {"Nombre", "Precio", "Cantidad"};
    Object[][] bebidas = {{"Pepsi", "$0.75", ""},
                          {"Café", "$0.75", ""}};
    Object[][] postres = {{"Tres leches", "$1.50", ""},
                          {"Pastel de Chocolate", "$1.75", ""}};
    Object[][] PlatoFuerte = {{"Pollo asado", "$2.00", ""}};

    /**
     * Creates new form Productos
     */
    public MenuAgregar() {
        initComponents();
        setLocationRelativeTo(null);
        
        modelo= new DefaultTableModel(bebidas, titulos);
        tblMenuProductos.setModel(modelo);
        perzonalizarComponentes();
    }
    
    public final void perzonalizarComponentes(){
//        Enumeration<TableColumn> en = tblMenuProductos.getColumnModel().getColumns();
//        while (en.hasMoreElements()) {
//            TableColumn tc = en.nextElement();
//            tc.setCellRenderer(new RenderColor(new Color(179, 210, 238)));
//        }
        
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
        btnEntradas = new javax.swing.JButton();
        btnPlatoFuerte = new javax.swing.JButton();
        btnContinuar = new javax.swing.JButton();
        btnBebidas = new javax.swing.JButton();
        txtBuscarProducto = new RedondearBorde("/Recursos/buscar.png");
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMenuProductos = new javax.swing.JTable();
        btnBocas = new javax.swing.JButton();
        btnPostres = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnSopas = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jpFondo.setBackground(Color.decode("#2A3132")
        );
        jpFondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnEntradas.setText("Entradas");
        btnEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntradasActionPerformed(evt);
            }
        });

        btnPlatoFuerte.setText("Plato fuerte");
        btnPlatoFuerte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlatoFuerteActionPerformed(evt);
            }
        });

        btnContinuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/guardar16.jpg"))); // NOI18N
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        btnBebidas.setText("Bebidas");
        btnBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBebidasActionPerformed(evt);
            }
        });

        tblMenuProductos.setBackground(Color.decode("#90AFC5"));
        tblMenuProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Precio", "Cantidad"
            }
        ));
        jScrollPane2.setViewportView(tblMenuProductos);

        btnBocas.setText("Bocas");
        btnBocas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBocasActionPerformed(evt);
            }
        });

        btnPostres.setText("Postres");
        btnPostres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostresActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setForeground(Color.decode("#90AFC5"));
        jLabel1.setText("Menu Agregar");

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/atras16.jpg"))); // NOI18N
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnSopas.setText("Sopas");
        btnSopas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSopasActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(Color.decode("#90AFC5"));
        jLabel2.setText("Buscar");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/buscar.jpg"))); // NOI18N

        javax.swing.GroupLayout jpFondoLayout = new javax.swing.GroupLayout(jpFondo);
        jpFondo.setLayout(jpFondoLayout);
        jpFondoLayout.setHorizontalGroup(
            jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFondoLayout.createSequentialGroup()
                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFondoLayout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jLabel1))
                    .addGroup(jpFondoLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPlatoFuerte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEntradas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBebidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPostres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBocas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSopas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpFondoLayout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpFondoLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(23, 23, 23)
                        .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );
        jpFondoLayout.setVerticalGroup(
            jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFondoLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFondoLayout.createSequentialGroup()
                        .addComponent(btnBebidas)
                        .addGap(6, 6, 6)
                        .addComponent(btnBocas)
                        .addGap(6, 6, 6)
                        .addComponent(btnEntradas)
                        .addGap(6, 6, 6)
                        .addComponent(btnPlatoFuerte)
                        .addGap(6, 6, 6)
                        .addComponent(btnPostres)
                        .addGap(6, 6, 6)
                        .addComponent(btnSopas))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnContinuar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

    private void btnEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntradasActionPerformed
        limpiarModelo();
    }//GEN-LAST:event_btnEntradasActionPerformed

    private void btnPlatoFuerteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlatoFuerteActionPerformed
        limpiarModelo();
        for (Object[] PlatoFuerte1 : PlatoFuerte) {
            modelo.addRow(PlatoFuerte1);
        }
    }//GEN-LAST:event_btnPlatoFuerteActionPerformed

    private void btnBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBebidasActionPerformed
        limpiarModelo();
        for (Object[] bebida : bebidas) {
            modelo.addRow(bebida);
        }
    }//GEN-LAST:event_btnBebidasActionPerformed

    private void btnBocasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBocasActionPerformed
        limpiarModelo();
    }//GEN-LAST:event_btnBocasActionPerformed

    private void btnPostresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostresActionPerformed
        limpiarModelo();
        for (Object[] postre : postres) {
            modelo.addRow(postre);
        }
    }//GEN-LAST:event_btnPostresActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnSopasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSopasActionPerformed
        limpiarModelo();
    }//GEN-LAST:event_btnSopasActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
//        NuevaOrden no =new NuevaOrden();
//        no.setVisible(true);
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
    private javax.swing.JButton btnBebidas;
    private javax.swing.JButton btnBocas;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnEntradas;
    private javax.swing.JButton btnPlatoFuerte;
    private javax.swing.JButton btnPostres;
    private javax.swing.JButton btnSopas;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpFondo;
    private javax.swing.JTable tblMenuProductos;
    private javax.swing.JTextField txtBuscarProducto;
    // End of variables declaration//GEN-END:variables
}
