/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.poly.view;

import com.poly.entity.BacSi;
import com.poly.entity.BacSiLichLamViec;
import com.poly.entity.BenhNhan;
import com.poly.repository.RepoBacSi;
import com.poly.repository.RepoBsLlv;
import de.wannawork.jcalendar.JCalendarComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author manh9
 */
public class From_QLLichHen extends javax.swing.JPanel {
     private RepoBsLlv repoBsllv = new RepoBsLlv();
    private List<BacSiLichLamViec> listBsLlv = new ArrayList<>();
    private DefaultTableModel dtm = new DefaultTableModel();
 
    
    
    
    public From_QLLichHen() {
        initComponents();
          //Lịch làm việc
        listBsLlv = repoBsllv.getAllBacSiLichLamViec();
        loadTableBSLLV(listBsLlv);
        
        //Lịch hẹn  
         listBsLlv = repoBsllv.getAllLichHen();
        loadTableLH(listBsLlv);
        
        //ĐỊnh dạng
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        cboNgayKham.setDateFormat(dateFormat);
 
 
    }

     public void loadTableBSLLV(List<BacSiLichLamViec> list) {
        DefaultTableModel dtm = (DefaultTableModel) this.tbBacSi.getModel();
        dtm.setRowCount(0);
        for (BacSiLichLamViec llv : list) {
            dtm.addRow(llv.rowDtBsLlv());
        }
    }
   //lich hen
public void loadTableLH(List<BacSiLichLamViec> list) {
        DefaultTableModel dtm = (DefaultTableModel) this.tbNguoiDung.getModel();
        dtm.setRowCount(0);
        for (BacSiLichLamViec llv : list) {
            dtm.addRow(llv.rowDtLH());
        }
    }

    


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtTen = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbBacSi = new javax.swing.JTable();
        btChonBacSi = new javax.swing.JButton();
        btHuyBacSi = new javax.swing.JButton();
        txtDiaChi = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cboThoiGianKham = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cboNgayKham = new de.wannawork.jcalendar.JCalendarComboBox();
        jLabel8 = new javax.swing.JLabel();
        btDatLich = new javax.swing.JButton();
        btHuy = new javax.swing.JButton();
        btResset = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btTimKiem = new javax.swing.JButton();
        btSuaThongTin = new javax.swing.JButton();
        btChonNgayKham = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNguoiDung = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        txtTen.setText(" ");

        txtEmail.setText(" ");

        txtSDT.setText(" ");

        txtNgaySinh.setText(" ");
        txtNgaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaySinhActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbBacSi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Tên Bác Sĩ", "Chuyên Khoa", "Số năm kinh nghiệm", "Số điện thoại", "Email", "TrangThai"
            }
        ));
        tbBacSi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBacSiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbBacSi);

        btChonBacSi.setText("Chọn");
        btChonBacSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChonBacSiActionPerformed(evt);
            }
        });

        btHuyBacSi.setText("Hủy");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btChonBacSi, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btHuyBacSi, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btChonBacSi)
                        .addGap(18, 18, 18)
                        .addComponent(btHuyBacSi)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel1.setForeground(new java.awt.Color(102, 204, 255));
        jLabel1.setText("Họ Tên");

        jLabel2.setForeground(new java.awt.Color(102, 204, 255));
        jLabel2.setText("Email");

        jLabel3.setForeground(new java.awt.Color(102, 204, 255));
        jLabel3.setText("SDT");

        jLabel5.setForeground(new java.awt.Color(102, 204, 255));
        jLabel5.setText("Địa chỉ");

        jLabel6.setForeground(new java.awt.Color(102, 204, 255));
        jLabel6.setText("Ngày sinh");

        jLabel7.setForeground(new java.awt.Color(102, 204, 255));
        jLabel7.setText("Giới Tính");

        buttonGroup1.add(rdNam);
        rdNam.setSelected(true);
        rdNam.setText("Nam");

        buttonGroup1.add(rdNu);
        rdNu.setText("Nữ");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 204, 255));
        jLabel10.setText("Đặt Lịch Hẹn");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("Chọn Bác sĩ");

        cboThoiGianKham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn thời gian khám", "8h-10h", "10h-12h", "12h-14h", "14h-16h", "16h-18h" }));

        jLabel4.setForeground(new java.awt.Color(51, 102, 255));
        jLabel4.setText("Thời gian khám");

        cboNgayKham.setDate(new java.util.Date(1721485023000L));
        cboNgayKham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboNgayKhamMouseClicked(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(51, 102, 255));
        jLabel8.setText("Ngày Khám");

        btDatLich.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/add.png"))); // NOI18N
        btDatLich.setText("Đặt lịch");
        btDatLich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDatLichActionPerformed(evt);
            }
        });

        btHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/delete.png"))); // NOI18N
        btHuy.setText("Hủy");

        btResset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/return.png"))); // NOI18N
        btResset.setText("Reset");
        btResset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRessetActionPerformed(evt);
            }
        });

        jLabel9.setText("Tìm Kiếm");

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtTimKiem.setText("Tìm theo tên hoặc số điện thoại");
        txtTimKiem.setToolTipText("");

        btTimKiem.setText("Search");
        btTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemActionPerformed(evt);
            }
        });

        btSuaThongTin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/clear.png"))); // NOI18N
        btSuaThongTin.setText("Sửa Thông tin");

        btChonNgayKham.setText("Chọn Ngày Khám");
        btChonNgayKham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChonNgayKhamActionPerformed(evt);
            }
        });

        tbNguoiDung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Lịch Hẹn", "ID Bệnh Nhân", "Tên Bệnh Nhân", "SDT", "Email", "Địa chỉ", "Ngày Sinh", "GioiTinh", "ID Bác Sĩ", "Tên Bác Sĩ", "Ngày hẹn", "Giờ hẹn", "Ngày đặt lịch", "TrangThai"
            }
        ));
        tbNguoiDung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNguoiDungMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbNguoiDung);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboThoiGianKham, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cboNgayKham, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(btChonNgayKham, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel9)
                                        .addGap(46, 46, 46))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3))
                                        .addGap(61, 61, 61)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7))
                                        .addGap(32, 32, 32)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(rdNam)
                                                .addGap(27, 27, 27)
                                                .addComponent(rdNu))
                                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(btTimKiem))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel13))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(btDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(btHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(btResset, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)
                        .addComponent(btSuaThongTin)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(77, 77, 77))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(491, 491, 491)
                        .addComponent(jLabel10))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(rdNam)
                        .addComponent(rdNu)))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboThoiGianKham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btTimKiem))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cboNgayKham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addComponent(btChonNgayKham))
                .addGap(10, 10, 10)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDatLich)
                    .addComponent(btHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btResset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSuaThongTin))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNgaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaySinhActionPerformed
        
    }//GEN-LAST:event_txtNgaySinhActionPerformed

    private void tbBacSiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBacSiMouseClicked
       
    }//GEN-LAST:event_tbBacSiMouseClicked

    private void cboNgayKhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboNgayKhamMouseClicked
        
    }//GEN-LAST:event_cboNgayKhamMouseClicked

    private void btDatLichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDatLichActionPerformed
//        BenhNhan bn = getFromData();
//         
//        JOptionPane.showMessageDialog(this, "Đã đặt lịch hẹn cho bệnh nhân: " + bn.getTen());         
    }//GEN-LAST:event_btDatLichActionPerformed

    private void btRessetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRessetActionPerformed
        // Reset all fields
    txtTen.setText("");
    txtEmail.setText("");
    txtSDT.setText("");
    txtDiaChi.setText("");
    txtNgaySinh.setText("");
    buttonGroup1.clearSelection();
    cboThoiGianKham.setSelectedIndex(0);
    cboNgayKham.setDate(new Date());
    txtTimKiem.setText("Tìm theo tên hoặc số điện thoại");
    }//GEN-LAST:event_btRessetActionPerformed

    private void btTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemActionPerformed
//        String keyword = txtTimKiem.getText().trim();
//    if (!keyword.isEmpty()) {
//        List<BenhNhan> searchResults = searchPatient(keyword);
//        DefaultTableModel model = (DefaultTableModel) tbNguoiDung.getModel();
//        model.setRowCount(0); // Clear existing rows
//        for (BenhNhan bn : searchResults) {
//            model.addRow(bn.rowData());
//        }
//    } else {
//        JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa tìm kiếm.");
//    }
    }//GEN-LAST:event_btTimKiemActionPerformed

    private void btChonBacSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChonBacSiActionPerformed
int selectedRow = tbBacSi.getSelectedRow();
    if (selectedRow >= 0) {
        BacSiLichLamViec selectedDoctor = listBsLlv.get(selectedRow);
        // Hiển thị thông báo với tên của bác sĩ được chọn
        JOptionPane.showMessageDialog(this, "Bác sĩ được chọn: " + selectedDoctor.getTenBacSi());
        
        // Thực hiện các hành động khác với bác sĩ được chọn, ví dụ:
        // - Hiển thị thông tin chi tiết của bác sĩ trong các trường văn bản
        // - Lưu bác sĩ được chọn vào biến để sử dụng sau này
        // - ...
    } else {
        // Nếu không có hàng nào được chọn, hiển thị thông báo
        JOptionPane.showMessageDialog(this, "Vui lòng chọn một bác sĩ từ bảng.");
    }     
    }//GEN-LAST:event_btChonBacSiActionPerformed

    private void btChonNgayKhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChonNgayKhamActionPerformed
//      try {
//        // Lấy ngày khám từ bộ chọn ngày
//        java.util.Date ngayKhamDate = cboNgayKham.getDate(); // Sử dụng phương thức phù hợp
//        java.sql.Date ngayKham = new java.sql.Date(ngayKhamDate.getTime());
//
//        // Lấy giờ khám từ bộ chọn giờ (nếu dùng JSpinner)
//        java.util.Date gioKhamDate = (java.util.Date) cboGioKham.getValue();
//        java.sql.Time gioKham = new java.sql.Time(gioKhamDate.getTime());
//
//        // Lấy danh sách bác sĩ có thời gian rảnh
//        List<BacSi> availableDoctors = repoBsllv.getAvailableDoctors(ngayKham, gioKham);
//        
//        // Cập nhật mô hình bảng với danh sách bác sĩ
//        if (dtm == null) {
//            dtm = new DefaultTableModel(new String[]{"ID", "Tên"}, 0);
//            // Giả sử bạn đã có JTable và gán model cho nó
//            tbBacSi.setModel(dtm);
//        }
//        
//        dtm.setRowCount(0); // Xóa dữ liệu cũ trong bảng
//        for (BacSi bacSi : availableDoctors) {
//            dtm.addRow(new Object[]{bacSi.getID(), bacSi.getTen()});
//        }
//        
//    } catch (Exception e) {
//        e.printStackTrace(); // Xử lý lỗi
//    }
    }//GEN-LAST:event_btChonNgayKhamActionPerformed

    private void tbNguoiDungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNguoiDungMouseClicked

    }//GEN-LAST:event_tbNguoiDungMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btChonBacSi;
    private javax.swing.JButton btChonNgayKham;
    private javax.swing.JButton btDatLich;
    private javax.swing.JButton btHuy;
    private javax.swing.JButton btHuyBacSi;
    private javax.swing.JButton btResset;
    private javax.swing.JButton btSuaThongTin;
    private javax.swing.JButton btTimKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private de.wannawork.jcalendar.JCalendarComboBox cboNgayKham;
    private javax.swing.JComboBox<String> cboThoiGianKham;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tbBacSi;
    private javax.swing.JTable tbNguoiDung;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    private void setTitle(String đặt_Lịch_Khám) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void add(jDateChooserNgayKham dateChooserNgayKham) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
