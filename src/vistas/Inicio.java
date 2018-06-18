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
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author mateo
 */
public class Inicio extends javax.swing.JPanel {
    DefaultTableModel modelo;
    String[] titulosColumnas = {"N°", "Mesa", "Mesero", "Cliente", "Total"};
    Object[][] datos = {{"001", "M1", "Eduardo Magaña", "Silvia Lopez", "$50"},
                        {"002", "M2", "William Sanchez", "Sonia Ruiz", "$40"},
                        {"003", "M3", "Sergio Ramos", "Daniel Perez", "$35"},
                        {"004", "M4", "Eduardo Magaña", "Jose Hidalgo", "$25"},
                        {"005", "M5", "Eduardo Magaña", "Elias Trejo", "$45"},
                        {"006", "M6", "william Sanchez", "Saul Castillo", "$35"},
                        {"007", "M7", "Sergio Ramos", "Norma Ascensio", "$30"}};

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
        modelo = new DefaultTableModel(datos, titulosColumnas);
        tblOrdenesActivas.setModel(modelo);
        personalizarComponentes();
        
    }
    
    public final void personalizarComponentes(){
        Enumeration<TableColumn> en = tblOrdenesActivas.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new RenderColor(new Color(179, 210, 238)));
        }
        
        tblOrdenesActivas.setRowHeight(20);
        TableColumnModel tcm = tblOrdenesActivas.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(50);
        tcm.getColumn(1).setPreferredWidth(30);
        tcm.getColumn(2).setPreferredWidth(200);
        tcm.getColumn(3).setPreferredWidth(200);
        tcm.getColumn(4).setPreferredWidth(100);
        
        poputTable();
    }
    
    public void poputTable(){
    
        JPopupMenu popupMenu = new JPopupMenu ();
        
        JMenuItem menuItem1 = new JMenuItem("Agregar Productos", new ImageIcon(getClass().getResource("/Recursos/modificarProductos.png")));
        JMenuItem menuItem2 = new JMenuItem("Imprimir Cuenta", new ImageIcon(getClass().getResource("/Recursos/imprimir.png")));
        JMenuItem menuItem3 = new JMenuItem("Modificar Cuenta", new ImageIcon(getClass().getResource("/Recursos/modificarOrden.png")));
        JMenuItem menuItem4 = new JMenuItem("Cobrar", new ImageIcon(getClass().getResource("/Recursos/cobrar.png")));
        
        menuItem1.addActionListener((ActionEvent e) -> {            
            MenuAgregar p = new MenuAgregar();
            p.setVisible(true);   
        });
        
        menuItem3.addActionListener((ActionEvent e) -> {            
            NuevaOrden nvo = new NuevaOrden();
            nvo.setVisible(true);   
        });
        
        menuItem4.addActionListener((ActionEvent e) -> {            
            Cobrar co = new Cobrar();
            co.setVisible(true);   
        });
        
        popupMenu.add(menuItem1);
        popupMenu.add(menuItem2);
        popupMenu.add(menuItem3);
        popupMenu.add(menuItem4);
        tblOrdenesActivas.setComponentPopupMenu(popupMenu);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrdenesActivas = new javax.swing.JTable();
        txtBuscar = new RedondearBorde("/Recursos/buscar.png");
        btnNuevaOrden1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(Color.decode("#2A3132"));
        setPreferredSize(new java.awt.Dimension(807, 707));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setForeground(Color.decode("#90AFC5")
        );
        jLabel1.setText("Ordenes activas");

        tblOrdenesActivas.setBackground(Color.decode("#90AFC5")
        );
        tblOrdenesActivas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N°", "Mesa", "Mesero", "Cliente", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblOrdenesActivas);

        btnNuevaOrden1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/nueva32.jpg"))); // NOI18N
        btnNuevaOrden1.setFocusPainted(false);
        btnNuevaOrden1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaOrden1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(Color.decode("#90AFC5"));
        jLabel2.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addGap(27, 27, 27)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnNuevaOrden1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 329, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnNuevaOrden1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaOrden1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaOrden1ActionPerformed
        NuevaOrden nueva = new NuevaOrden();
        nueva.setVisible(true);
        //menu.setBackground(Color.decode("#763626"));
        //jLabel1.setForeground(Color.decode("#90AFC5"));  
    }//GEN-LAST:event_btnNuevaOrden1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevaOrden1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrdenesActivas;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
