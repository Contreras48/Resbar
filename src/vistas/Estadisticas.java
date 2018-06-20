/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Personalizacion.RenderColor;
import java.awt.Color;
import java.util.Enumeration;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author mateo
 */
public class Estadisticas extends javax.swing.JPanel {

    /**
     * Creates new form Estadisticas
     */
    public Estadisticas() {
        initComponents();
        personalizarComponentes();
//        setIconImage(new ImageIcon(getClass().getResource("/Recursos/restaur.png")).getImage());
//                this.setResizable(false);
        dia();
        mes();
        año();
    }

    public void dia() {
        DefaultComboBoxModel dia = new DefaultComboBoxModel();
        for (int i = 1; i <= 31; i++) {
            dia.addElement(i);
            cmbDia.setModel(dia);
        }
    }
    public void mes(){
        cmbMes.addItem("Enero");
        cmbMes.addItem("Febrero");
        cmbMes.addItem("Marzo");
        cmbMes.addItem("Abril");
        cmbMes.addItem("Mayo");
        cmbMes.addItem("Junio");
        cmbMes.addItem("Julio");
        cmbMes.addItem("Agosto");
        cmbMes.addItem("Septiembre");
        cmbMes.addItem("Octubre");
        cmbMes.addItem("Noviembre");
        cmbMes.addItem("Diciembre");
               
    }
    public void año(){
        cmbAño.addItem("2011");
        cmbAño.addItem("2012");
        cmbAño.addItem("2013");
        cmbAño.addItem("2014");
        cmbAño.addItem("2015");
        cmbAño.addItem("2016");
        cmbAño.addItem("2017");
        cmbAño.addItem("2018");
                           
    }
    public final void personalizarComponentes(){
        Enumeration<TableColumn> en = tblEstadisticas.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            //tc.setCellRenderer(new RenderColor(new Color(179, 210, 238)));
        }
        
        tblEstadisticas.setRowHeight(20);
//        TableColumnModel tcm = tblEstadisticas.getColumnModel();
//        tcm.getColumn(0).setPreferredWidth(50);
//        tcm.getColumn(1).setPreferredWidth(30);
//        tcm.getColumn(2).setPreferredWidth(200);
//        tcm.getColumn(3).setPreferredWidth(200);
//        tcm.getColumn(4).setPreferredWidth(100);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filtroEstadisticas = new javax.swing.ButtonGroup();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstadisticas = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        rbtnMes = new javax.swing.JRadioButton();
        rbtnAnio = new javax.swing.JRadioButton();
        rbtnDia = new javax.swing.JRadioButton();
        cmbDia = new javax.swing.JComboBox<>();
        cmbMes = new javax.swing.JComboBox<>();
        cmbAño = new javax.swing.JComboBox<>();
        lblEstadisticas = new javax.swing.JLabel();

        setBackground(Color.decode("#2A3132"));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel10.setForeground(Color.decode("#AF4425"));
        jLabel10.setText("Seleccione:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, -1, 40));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel9.setForeground(Color.decode("#AF4425"));
        jLabel9.setText("Seleccione:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, -1, 40));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel8.setForeground(Color.decode("#AF4425"));
        jLabel8.setText("Seleccione:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 88, -1, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel6.setForeground(Color.decode("#662E1C"));
        jLabel6.setText("Estadisticas de Ventas");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 400, 30));

        tblEstadisticas.setBackground(Color.decode("#662E1C"));
        tblEstadisticas.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        tblEstadisticas.setForeground(new java.awt.Color(255, 255, 255));
        tblEstadisticas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblEstadisticas.setSelectionBackground(Color.decode("#EBDCB2"));
        jScrollPane1.setViewportView(tblEstadisticas);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 207, 668, 339));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel7.setForeground(Color.decode("#662E1C"));
        jLabel7.setText("Filtrar Estadisticas Por:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        filtroEstadisticas.add(rbtnMes);
        rbtnMes.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        rbtnMes.setForeground(Color.decode("#662E1C"));
        rbtnMes.setText("Mes");
        rbtnMes.setOpaque(false);
        add(rbtnMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        filtroEstadisticas.add(rbtnAnio);
        rbtnAnio.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        rbtnAnio.setForeground(Color.decode("#662E1C"));
        rbtnAnio.setText("Año");
        rbtnAnio.setOpaque(false);
        add(rbtnAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, -1, -1));

        filtroEstadisticas.add(rbtnDia);
        rbtnDia.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        rbtnDia.setForeground(Color.decode("#662E1C"));
        rbtnDia.setText("Dia");
        rbtnDia.setOpaque(false);
        add(rbtnDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        cmbDia.setBackground(Color.decode("#C9A66B"));
        cmbDia.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        cmbDia.setForeground(Color.decode("#662E1C"));
        add(cmbDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 97, 34));

        cmbMes.setBackground(Color.decode("#C9A66B"));
        cmbMes.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        cmbMes.setForeground(Color.decode("#662E1C"));
        add(cmbMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 106, 34));

        cmbAño.setBackground(Color.decode("#C9A66B"));
        cmbAño.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        cmbAño.setForeground(Color.decode("#662E1C"));
        add(cmbAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 101, 34));

        lblEstadisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background/34_Spicy_Neutrals02.png"))); // NOI18N
        add(lblEstadisticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 710));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbAño;
    private javax.swing.JComboBox<String> cmbDia;
    private javax.swing.JComboBox<String> cmbMes;
    private javax.swing.ButtonGroup filtroEstadisticas;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEstadisticas;
    private javax.swing.JRadioButton rbtnAnio;
    private javax.swing.JRadioButton rbtnDia;
    private javax.swing.JRadioButton rbtnMes;
    private javax.swing.JTable tblEstadisticas;
    // End of variables declaration//GEN-END:variables
}
