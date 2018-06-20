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
//            tc.setCellRenderer(new RenderColor(new Color(179, 210, 238)));
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

        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrdenesActivas = new javax.swing.JTable();
        txtBuscar = new RedondearBorde("/Recursos/buscar.png");
        btnNuevaOrden1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblFondo2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(807, 707));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel7.setForeground(Color.decode("#662E1C"));
        jLabel7.setText("Buscar: ");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 52, -1, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel6.setForeground(Color.decode("#662E1C"));
        jLabel6.setText("Ordenes Activas");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 340, 30));

        tblOrdenesActivas.setBackground(Color.decode("#C9A66B"));
        tblOrdenesActivas.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        tblOrdenesActivas.setForeground(new java.awt.Color(255, 255, 255));
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
        tblOrdenesActivas.setSelectionBackground(Color.decode("#EBDCB2"));
        jScrollPane1.setViewportView(tblOrdenesActivas);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 89, 670, 471));

        txtBuscar.setBackground(Color.decode("#AF4425"));
        txtBuscar.setFont(new java.awt.Font("Rockwell", 3, 14)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscar.setSelectionColor(Color.decode("#EBDCB2"));
        add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 58, 357, -1));

        btnNuevaOrden1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosNew/NUEVA_.png"))); // NOI18N
        btnNuevaOrden1.setFocusPainted(false);
        btnNuevaOrden1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaOrden1ActionPerformed(evt);
            }
        });
        add(btnNuevaOrden1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 580, 180, 90));
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 55, -1, 23));

        lblFondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background/34_Spicy_Neutrals02.png"))); // NOI18N
        add(lblFondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 710));
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaOrden1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaOrden1ActionPerformed
        NuevaOrden nueva = new NuevaOrden();
        nueva.setVisible(true);
        //menu.setBackground(Color.decode("#763626"));
        //jLabel1.setForeground(Color.decode("#90AFC5"));  
    }//GEN-LAST:event_btnNuevaOrden1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevaOrden1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFondo2;
    private javax.swing.JTable tblOrdenesActivas;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
