/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Modelo.Categoria;
import Modelo.ErrorAplicacion;
import Modelo.ManejadorCategorias;
import Personalizacion.RedondearBorde;
import com.sun.javafx.tk.Toolkit;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import resbar.Validacion;
import static vistas.Administrar.tblCategoria;

/**
 *
 * @author mateo
 */
public class AMCategoria extends javax.swing.JFrame {
    Validacion validar = new Validacion();
    public boolean estado = false;
    DefaultTableModel modeloC;
    Administrar p2;
    int[] anchoProducto = {50, 300, 300, 50};
    int[] anchoCategoria = {50, 600};
    String[] titulosCategoria = {"Id", "Nombre"};
    String[] titulosProducto = {"Categoria", "Id_Prod", "Nombre", "Precio"};

    /**
     * Creates new form AMCategoria
     * @param mensaje
     */
    public AMCategoria(String mensaje) {
        initComponents();
        setLocationRelativeTo(null);
        txtId.setEditable(false);
        lblEtiqueta.setText(mensaje);

        Categoria cat = new Categoria();
        try {
            txtId.setText(String.valueOf(ManejadorCategorias.obtenerId()));
        } catch (ErrorAplicacion ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        txtNombre.requestFocus();
    }
    
    public void limpiar(){
        txtId.setText(" ");
        txtNombre.setText(" ");
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
        Administrar ad = new Administrar();
        ad.poputTable();
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
        btnGuardar = new javax.swing.JButton();
        txtNombre = new RedondearBorde(null);
        btnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtId = new RedondearBorde(null);
        jLabel1 = new javax.swing.JLabel();
        lblEtiqueta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva | Categoria");

        jpFondo.setBackground(Color.decode("#2A3132"));
        jpFondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/guardar16.jpg"))); // NOI18N
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/atras16.jpg"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(Color.decode("#90AFC5"));
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(Color.decode("#90AFC5"));
        jLabel3.setText("Cancelar");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(Color.decode("#90AFC5"));
        jLabel4.setText("Guardar");

        lblNombre.setForeground(Color.decode("#90AFC5"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(Color.decode("#90AFC5"));
        jLabel1.setText("Id:");

        lblEtiqueta.setText("jLabel1");

        javax.swing.GroupLayout jpFondoLayout = new javax.swing.GroupLayout(jpFondo);
        jpFondo.setLayout(jpFondoLayout);
        jpFondoLayout.setHorizontalGroup(
            jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFondoLayout.createSequentialGroup()
                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFondoLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lblEtiqueta))
                    .addGroup(jpFondoLayout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpFondoLayout.createSequentialGroup()
                        .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpFondoLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabel1)
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFondoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpFondoLayout.createSequentialGroup()
                                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpFondoLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel3)))
                                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpFondoLayout.createSequentialGroup()
                                        .addGap(170, 170, 170)
                                        .addComponent(jLabel4))
                                    .addGroup(jpFondoLayout.createSequentialGroup()
                                        .addGap(158, 158, 158)
                                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jpFondoLayout.setVerticalGroup(
            jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFondoLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpFondoLayout.createSequentialGroup()
                        .addComponent(lblEtiqueta)
                        .addGap(18, 18, 18)
                        .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    
        lblNombre.setText("");
        Validacion validar = new Validacion();
        String cadena = txtNombre.getText();
        boolean label = validar.ValidarNulos(cadena);
        if (label == true) {
            lblNombre.setText("campo obligatorio");
        } else {
            if (lblEtiqueta.getText().equals("Modificar categoria")) {
                Categoria cat = new Categoria();
                cat.idCategoria = Integer.parseInt(txtId.getText());
                cat.nombre = String.valueOf(txtNombre.getText());

                try {
                    ManejadorCategorias.actualizar(cat);
                    JOptionPane.showMessageDialog(null, "modificado con exito");
                    Administrar.modeloCategoria.setRowCount(0);
                    Administrar.listaCategoria = ManejadorCategorias.obtener(false);
                    Administrar.cargarCategorias();
                    this.dispose();
                    limpiar();
                } catch (ErrorAplicacion ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            } else {
                Categoria cat = new Categoria();
                cat.idCategoria = Integer.parseInt(txtId.getText());
                cat.nombre = String.valueOf(txtNombre.getText());
                try {
                    ManejadorCategorias.insertar(cat);
                    JOptionPane.showMessageDialog(null, "agregado con exito");
                    Administrar.modeloCategoria.setRowCount(0);
                    Administrar.listaCategoria = ManejadorCategorias.obtener(false);
                    Administrar.cargarCategorias();
                    this.dispose();
                    limpiar();
                } catch (ErrorAplicacion ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
         
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        validar.sololetras(txtNombre);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

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
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AMCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AMCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AMCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AMCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AMCategoria("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jpFondo;
    private javax.swing.JLabel lblEtiqueta;
    private javax.swing.JLabel lblNombre;
    public static javax.swing.JTextField txtId;
    public static javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
