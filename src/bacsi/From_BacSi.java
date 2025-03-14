/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package bacsi;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class From_BacSi extends javax.swing.JPanel {
    private Repositories rp = new Repositories();
    private DefaultTableModel mol = new DefaultTableModel();
    private int i = -1;
    private String trangthai;

    /**
     * Creates new form BacSi1
     */
    public From_BacSi() {
        initComponents();
         this.filltable(rp.getall());
    }
    void filltable(ArrayList<Model_bacsi> list) {
        mol = (DefaultTableModel) tbl_bacsi.getModel();
        mol.setRowCount(0);
        for (Model_bacsi m : list) {
            mol.addRow(m.todatarow());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bacsi = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_timkiem = new javax.swing.JButton();
        txt_timkiem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_chuyenkhoa = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_kinhnghiem = new javax.swing.JTextField();
        txt_ngaytao = new javax.swing.JTextField();
        txt_ten = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        txt_email = new javax.swing.JTextField();
        txt_sdt = new javax.swing.JTextField();
        btn_sua = new javax.swing.JButton();
        txt_matkhau = new javax.swing.JTextField();
        rdo_hd = new javax.swing.JRadioButton();
        rdo_khd = new javax.swing.JRadioButton();
        btn_xoa = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1.png"))); // NOI18N
        jLabel1.setText("Bác Sĩ ");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 255));
        jLabel16.setText("Chuyên Khoa:");

        tbl_bacsi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id ", "Tên", "Email:", "Số Điện Thoại", "Mật Khẩu", "Chuyên Khoa", "Số Năm Kinh Nghiệm", "Ngày Tạo", "Trạng Thái "
            }
        ));
        tbl_bacsi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bacsiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_bacsi);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 255));
        jLabel17.setText("Số Năm Kinh Nghiệm:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 255));
        jLabel12.setText("Tên Bác Sĩ :");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 255));
        jLabel18.setText("Ngày Tạo:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 255));
        jLabel13.setText("Email:");

        btn_timkiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_timkiem.setForeground(new java.awt.Color(0, 102, 255));
        btn_timkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search2.png"))); // NOI18N
        btn_timkiem.setText("Tìm Kiếm Thông Tin");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Form Tìm Kiếm");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(btn_timkiem))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timkiem))
                .addGap(49, 49, 49))
        );

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 255));
        jLabel19.setText("Trạng Thái:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 255));
        jLabel14.setText("Số Điện Thoại:");

        txt_chuyenkhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_chuyenkhoaActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 255));
        jLabel15.setText("Mật Khẩu :");

        txt_ten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenActionPerformed(evt);
            }
        });

        btn_them.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_them.setForeground(new java.awt.Color(0, 102, 255));
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/add.png"))); // NOI18N
        btn_them.setText("Thêm Thông Tin");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_sua.setForeground(new java.awt.Color(0, 102, 255));
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/clear.png"))); // NOI18N
        btn_sua.setText("Sửa Thông Tin");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdo_hd);
        rdo_hd.setSelected(true);
        rdo_hd.setText("Hoạt Động");

        buttonGroup1.add(rdo_khd);
        rdo_khd.setText("Không Hoạt Động");

        btn_xoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_xoa.setForeground(new java.awt.Color(0, 102, 255));
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/delete.png"))); // NOI18N
        btn_xoa.setText("Xóa Thông Tin");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel14)
                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel15))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_ten, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                .addComponent(txt_email)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_matkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(rdo_hd)
                                .addGap(18, 18, 18)
                                .addComponent(rdo_khd))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_chuyenkhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                    .addComponent(txt_kinhnghiem)
                                    .addComponent(txt_ngaytao)))))
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_sua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_them, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                .addGap(85, 85, 85))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(463, 463, 463)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(txt_chuyenkhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_them)
                            .addComponent(jLabel12))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17)
                                .addComponent(txt_kinhnghiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_sua))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(txt_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(btn_xoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_matkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel15)
                    .addComponent(rdo_hd)
                    .addComponent(rdo_khd))
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_bacsiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bacsiMouseClicked
        // TODO add your handling code here:
        i=tbl_bacsi.getSelectedRow();
        txt_ten.setText(tbl_bacsi.getValueAt(i,1).toString());
        txt_email.setText(tbl_bacsi.getValueAt(i,2).toString());
        txt_sdt.setText(tbl_bacsi.getValueAt(i,3).toString());
        txt_matkhau.setText(tbl_bacsi.getValueAt(i,4).toString());
        txt_chuyenkhoa.setText(tbl_bacsi.getValueAt(i,5).toString());
        txt_kinhnghiem.setText(tbl_bacsi.getValueAt(i,6).toString());
        txt_ngaytao.setText(tbl_bacsi.getValueAt(i,7).toString());
        trangthai=tbl_bacsi.getValueAt(i,8).toString();
        if (trangthai.equalsIgnoreCase("Hoạt Động")) {
            rdo_hd.setSelected(true );
        } else {
            rdo_khd.setSelected(true);
        }
    }//GEN-LAST:event_tbl_bacsiMouseClicked

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        // TODO add your handling code here:
        String ID=txt_timkiem.getText().trim();
        if (rp.timkiem(ID).isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tìm Kiếm  Thất Bại ");
        } else {
            JOptionPane.showMessageDialog(this, "Tìm Kiếm Thành  Công ");
            this.filltable(rp.timkiem(ID));
        }
    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void txt_chuyenkhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_chuyenkhoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_chuyenkhoaActionPerformed

    private void txt_tenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        if (this.readform()==null) {
            JOptionPane.showMessageDialog(this, "Thông Tin Trống ");
        } else {
            if (rp.them(this.readform())>0) {
                this.filltable(rp.getall());
                JOptionPane.showMessageDialog(this,"Thêm Thành Công");
            } else {
                JOptionPane.showMessageDialog(this,"Thêm Thất Bại");
            }
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        i=tbl_bacsi.getSelectedRow();
        if (i==-1) {
            JOptionPane.showMessageDialog(this, "Thông Tin Trống ");
        } else {
            int id =Integer.parseInt(tbl_bacsi.getValueAt(i,0).toString());
            if (rp.xoa(id)>0) {
                JOptionPane.showMessageDialog(this, "Xóa Thành Công ");
                this.filltable(rp.getall());
            } else {
                JOptionPane.showMessageDialog(this, "Xóa Thất Bại ");
            }
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        i=tbl_bacsi.getSelectedRow();
        if (this.readform()!=null) {
            int id =Integer.parseInt(tbl_bacsi.getValueAt(i,0).toString());
            if (rp.sapxep(this.readform(), id)>0) {
                JOptionPane.showMessageDialog(this, "sửa  Thành Công ");
                this.filltable(rp.getall());
            } else {
                JOptionPane.showMessageDialog(this, "Sửa  Thất Bại ");
            }
        }
    }//GEN-LAST:event_btn_suaActionPerformed

     public Model_bacsi readform() {

        String ten, enail, sdt, matkhau, chuyenkhoa, sonamkinhnghiem, ngaytao, trangthai;

        ten = txt_ten.getText().trim();
        if (ten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên Trống ");
            txt_ten.requestFocus();
            return null;
        }
        enail = txt_email.getText().trim();
        if (enail.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email Trống ");
            txt_email.requestFocus();
            return null;
        }
        sdt= txt_sdt.getText().trim();
        if (sdt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "sdt Trống ");
            txt_sdt.requestFocus();
            return null;
        }
        matkhau = txt_matkhau.getText().trim();
        if (matkhau.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mật Khẩu  Trống ");
            txt_matkhau.requestFocus();
            return null;
        }
        chuyenkhoa = txt_chuyenkhoa.getText().trim();
        if (chuyenkhoa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chuyên Khoa  Trống ");
            txt_chuyenkhoa.requestFocus();
            return null;
        }
        sonamkinhnghiem = txt_kinhnghiem.getText().trim();
        if (sonamkinhnghiem.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Kinh Nghiệm Trống ");
            txt_kinhnghiem.requestFocus();
            return null;
        }
        ngaytao = txt_ngaytao.getText().trim();
        if (ngaytao.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ngày Tạo Trống  ");
            txt_ngaytao.requestFocus();
            return null;
        }
        if (rdo_hd.isSelected()) {
            trangthai="Hoạt Động";
        } else {
            trangthai="Không Hoạt Động";
        }
        return new Model_bacsi(ten, enail, sdt, matkhau, chuyenkhoa, sonamkinhnghiem, ngaytao, trangthai);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdo_hd;
    private javax.swing.JRadioButton rdo_khd;
    private javax.swing.JTable tbl_bacsi;
    private javax.swing.JTextField txt_chuyenkhoa;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_kinhnghiem;
    private javax.swing.JTextField txt_matkhau;
    private javax.swing.JTextField txt_ngaytao;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_ten;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
