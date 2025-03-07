/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.poly.view;

import com.poly.entity.LichHen;
import com.poly.repository.ReposLichHen;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author manh9
 */
public class From_LichHen1 extends javax.swing.JPanel {
    private ReposLichHen rp = new ReposLichHen();
    private List<LichHen> lichHenlist = new ArrayList<>();
    private DefaultTableModel dtm = new DefaultTableModel();

    public From_LichHen1()   {
        initComponents();
        lichHenlist  = rp.getAll();
        loadTable(lichHenlist);
       
    }
    public void loadTable(List<LichHen> list){
        DefaultTableModel dtm = (DefaultTableModel) this.tbl_lichhen.getModel();
        dtm.setRowCount(0);
        for (LichHen lh : list) {
            dtm.addRow(lh.rowData());
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
        tbl_lichhen = new javax.swing.JTable();

        tbl_lichhen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Bệnh Nhân", " Mã Bác Sĩ", "Ngày Hẹn", "Giờ Hẹn", "Ngày đặt lịch", "Trạng Thái"
            }
        ));
        tbl_lichhen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_lichhenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_lichhen);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_lichhenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_lichhenMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_lichhenMouseClicked

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_lichhen;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
