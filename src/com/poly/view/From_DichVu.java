/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.poly.view;

import com.poly.entity.DichVu;
import com.poly.repository.RepoDichVu;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author manh9
 */
public class From_DichVu extends javax.swing.JPanel {
 ArrayList<DichVu> list = new ArrayList<>();
    DefaultTableModel mode = new DefaultTableModel();
    RepoDichVu dvsv = new RepoDichVu();
    /**
     * Creates new form From_DichVu
     */
    public From_DichVu() throws SQLException {
        initComponents();
         getdatadichvu();
    }
     public void getdatadichvu() throws SQLException {
        list = dvsv.getdata();
        this.displayToTable();
    }

    public void displayToTable() {
        DefaultTableModel model = (DefaultTableModel) tbtbale.getModel();
        model.setRowCount(0);
        for (DichVu dichvu : list) {
            Object[] row = {  dichvu.getTen_dichvu() , dichvu.getMota() , dichvu.getChiphi() , dichvu.getNgaytao() , dichvu.getTrangthai()};
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbtbale = new javax.swing.JTable();

        tbtbale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ten_dichvu", "mota", "chiphi", "ngaytao", " trangthai"
            }
        ));
        jScrollPane1.setViewportView(tbtbale);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbtbale;
    // End of variables declaration//GEN-END:variables
}
