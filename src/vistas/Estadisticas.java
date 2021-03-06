/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Personalizacion.RenderColor;
import java.awt.Color;
import java.util.Enumeration;
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
    }
    
    public final void personalizarComponentes(){
        Enumeration<TableColumn> en = tblEstadisticas.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new RenderColor(new Color(179, 210, 238)));
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstadisticas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        rbtnMes = new javax.swing.JRadioButton();
        rbtnAnio = new javax.swing.JRadioButton();
        rbtnDia = new javax.swing.JRadioButton();

        setBackground(Color.decode("#2A3132"));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setForeground(Color.decode("#90AFC5"));
        jLabel1.setText("Estadisticas de ventas");

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
        jScrollPane1.setViewportView(tblEstadisticas);

        jLabel2.setForeground(Color.decode("#90AFC5"));
        jLabel2.setText("Filtrar por:");

        filtroEstadisticas.add(rbtnMes);
        rbtnMes.setForeground(Color.decode("#90AFC5"));
        rbtnMes.setText("Mes");

        filtroEstadisticas.add(rbtnAnio);
        rbtnAnio.setForeground(Color.decode("#90AFC5"));
        rbtnAnio.setText("Año");

        filtroEstadisticas.add(rbtnDia);
        rbtnDia.setForeground(Color.decode("#90AFC5"));
        rbtnDia.setText("Dia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtnDia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtnMes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtnAnio)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rbtnMes)
                    .addComponent(rbtnAnio)
                    .addComponent(rbtnDia))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup filtroEstadisticas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnAnio;
    private javax.swing.JRadioButton rbtnDia;
    private javax.swing.JRadioButton rbtnMes;
    private javax.swing.JTable tblEstadisticas;
    // End of variables declaration//GEN-END:variables
}
