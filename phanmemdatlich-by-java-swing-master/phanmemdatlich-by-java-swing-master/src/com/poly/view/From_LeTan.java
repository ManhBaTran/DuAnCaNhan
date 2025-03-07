/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.poly.view;

import com.poly.entity.LeTan;
import com.poly.entity.NguoiDung;
import com.poly.repository.RepoLeTan;
import com.poly.repository.RepoNguoiDung;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author manh9
 */
public class From_LeTan extends javax.swing.JPanel {
             private  DefaultTableModel dtm = new DefaultTableModel();
             private  List<NguoiDung> list = new ArrayList<>();
             private  RepoNguoiDung repo = new RepoNguoiDung();
    /**
     * Creates new form From_NguoiDung
     */
    public From_LeTan()   {
        initComponents();
        list = repo.getAll();
        loadTable(list);
    }
  public void loadTable(List<NguoiDung> listNd){
    DefaultTableModel dtm = (DefaultTableModel) this.tbNguoiDung.getModel();
    dtm.setRowCount(0);
    for (NguoiDung nd : listNd) {
        dtm.addRow(nd.rowDt());
    }
}
  
public void defaultTable(int index){
       if (index < 0 || index >= tbNguoiDung.getRowCount()) {
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tbNguoiDung.getModel();

        try {
            String id = model.getValueAt(index, 1) != null ? model.getValueAt(index, 1).toString() : "";
            String hoTen = model.getValueAt(index, 2) != null ? model.getValueAt(index, 2).toString() : "";
            String email = model.getValueAt(index, 3) != null ? model.getValueAt(index, 3).toString() : "";
            String sdt = model.getValueAt(index, 4) != null ? model.getValueAt(index, 4).toString() : "";
            String matKhau = model.getValueAt(index, 5) != null ? model.getValueAt(index, 5).toString() : "";
            String chuyenKhoa = model.getValueAt(index, 6) != null ? model.getValueAt(index, 6).toString() : "";
            String soNamKinhNghiem = model.getValueAt(index, 7) != null ? model.getValueAt(index, 7).toString() : "";
            String vaiTro = model.getValueAt(index, 0) != null ? model.getValueAt(index, 0).toString() : "";
            String trangThai = model.getValueAt(index, 9) != null ? model.getValueAt(index, 9).toString() : "";
            String ngayTao = model.getValueAt(index, 8) != null ? model.getValueAt(index, 8).toString() : "";

            txtID.setText(id);
            txtHoTen.setText(hoTen);
            txtEmail.setText(email);
            txtSDT.setText(sdt);
            txtMatKhau.setText(matKhau);
            txtChuyenKhoa.setText(chuyenKhoa);
            txtSoNamKinhNghiem.setText(soNamKinhNghiem);
            cboVaiTro.setSelectedItem(vaiTro);
            cboTrangThai.setSelectedItem(trangThai);
            txtNgayTao.setText(ngayTao);
        } catch (Exception e) {
            e.printStackTrace();
        }
}

public NguoiDung getFromDt(){
    String id = txtID.getText().trim();
        String hoTen = txtHoTen.getText().trim();
        String email = txtEmail.getText().trim();
        String sdt = txtSDT.getText().trim();
        String matKhau = txtMatKhau.getText().trim();
        String chuyenKhoa = txtChuyenKhoa.getText().trim();
        String soNamKinhNghiem = txtSoNamKinhNghiem.getText().trim();
        String vaiTro = (String) cboVaiTro.getSelectedItem();
        String trangThai = (String) cboTrangThai.getSelectedItem();

        Integer soNamKinhNghiemInt = null;
        if (!soNamKinhNghiem.isEmpty()) {
            try {
                soNamKinhNghiemInt = Integer.parseInt(soNamKinhNghiem);
            } catch (NumberFormatException e) {
                soNamKinhNghiemInt = null;
            }
        }

        NguoiDung nd = new NguoiDung();
        nd.setId(id.isEmpty() ? null : Long.parseLong(id));
        nd.setTenNguoi(hoTen);
        nd.setEmail(email);
        nd.setSoDienThoai(sdt);
        nd.setMatKhau(matKhau);
        nd.setChuyenKhoa(chuyenKhoa);
        nd.setSoNamKinhNghiem(soNamKinhNghiemInt);
        nd.setVaiTro(vaiTro);
        nd.setTrangThai(trangThai);

        return nd;
}
  
        private boolean isValidInput(String id, String hoTen, String email, String sdt, String matKhau, String chuyenKhoa, String soNamKinhNghiem) {
        if (hoTen.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Họ và tên không được để trống", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (email.isEmpty() || !isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ hoặc không được để trống", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (sdt.isEmpty() || !isValidPhoneNumber(sdt)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ hoặc không được để trống", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (matKhau.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không được để trống", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (soNamKinhNghiem.isEmpty() || !isValidNumericField(soNamKinhNghiem)) {
            JOptionPane.showMessageDialog(this, "Số năm kinh nghiệm không hợp lệ hoặc không được để trống", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
      
      
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label3 = new java.awt.Label();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtNgayTao = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JTextField();
        txtSoNamKinhNghiem = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        cboVaiTro = new javax.swing.JComboBox<>();
        cboTrangThai = new javax.swing.JComboBox<>();
        btApDungBoLoc = new javax.swing.JButton();
        btHuyBoLoc = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtChuyenKhoa = new javax.swing.JTextField();
        btThemNguoiDung = new javax.swing.JButton();
        btCapNhapNguoidung = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNguoiDung = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btReset = new javax.swing.JButton();
        SDT = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();

        label3.setForeground(new java.awt.Color(51, 102, 255));
        label3.setText("Họ  Tên");

        jPanel1.setForeground(new java.awt.Color(102, 204, 255));

        txtNgayTao.setText(" ");

        txtID.setText(" ");

        txtHoTen.setText(" ");

        txtEmail.setText(" ");

        txtMatKhau.setText(" ");

        txtSoNamKinhNghiem.setText(" ");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtTimKiem.setText("Tìm theo tên hoặc số điện thoại");

        cboVaiTro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bác Sĩ", "Lễ tân", " ", " " }));

        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoạt Động", "Không Hoạt Động" }));

        btApDungBoLoc.setText("Áp dụng bộ lọc");
        btApDungBoLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btApDungBoLocActionPerformed(evt);
            }
        });

        btHuyBoLoc.setText("Hủy Bộ Lọc");
        btHuyBoLoc.setEnabled(false);
        btHuyBoLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHuyBoLocActionPerformed(evt);
            }
        });

        jLabel11.setText("Vai Trò");

        jLabel12.setText("Trạng thái");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(btHuyBoLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(btApDungBoLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btHuyBoLoc)
                    .addComponent(btApDungBoLoc))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btThemNguoiDung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/add.png"))); // NOI18N
        btThemNguoiDung.setText("Thêm Người Dùng");
        btThemNguoiDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemNguoiDungActionPerformed(evt);
            }
        });

        btCapNhapNguoidung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/clear.png"))); // NOI18N
        btCapNhapNguoidung.setText("Cập Nhập");
        btCapNhapNguoidung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCapNhapNguoidungActionPerformed(evt);
            }
        });

        btXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/delete.png"))); // NOI18N
        btXoa.setText("Xóa");
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        tbNguoiDung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "VaiTro", "ID", "Họ và Tên", "Email", "Số điện thoại", "Mật khẩu", "Chuyên Khoa", "Số năm kinh nghiệm", "Ngày tạo", "Trạng thái"
            }
        ));
        tbNguoiDung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNguoiDungMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbNguoiDung);

        jLabel1.setForeground(new java.awt.Color(102, 204, 255));
        jLabel1.setText("ID");

        jLabel2.setForeground(new java.awt.Color(102, 204, 255));
        jLabel2.setText("Họ Và Tên");

        jLabel3.setForeground(new java.awt.Color(102, 204, 255));
        jLabel3.setText("Email");

        jLabel4.setForeground(new java.awt.Color(102, 204, 255));
        jLabel4.setText("Mật khẩu");

        jLabel5.setForeground(new java.awt.Color(102, 204, 255));
        jLabel5.setText("Chuyên Khoa");

        jLabel6.setForeground(new java.awt.Color(102, 204, 255));
        jLabel6.setText("Số năm kinh nghiệm");

        jLabel8.setForeground(new java.awt.Color(102, 204, 255));
        jLabel8.setText("Ngày tạo");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 204, 255));
        jLabel10.setText("Quản Lý Người Dùng");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("Bộ lọc");

        btReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/refresh.png"))); // NOI18N
        btReset.setText("Reset");
        btReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResetActionPerformed(evt);
            }
        });

        SDT.setForeground(new java.awt.Color(102, 204, 255));
        SDT.setText("SDT");

        txtSDT.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(439, 439, 439)
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel13)))
                .addGap(0, 206, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSoNamKinhNghiem, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtChuyenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SDT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(94, 94, 94))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(494, 494, 494)
                .addComponent(btThemNguoiDung)
                .addGap(47, 47, 47)
                .addComponent(btCapNhapNguoidung, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(btReset, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSoNamKinhNghiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(2, 2, 2))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel5)
                        .addComponent(txtChuyenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(SDT)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThemNguoiDung)
                    .addComponent(btCapNhapNguoidung)
                    .addComponent(btXoa)
                    .addComponent(btReset))
                .addGap(16, 16, 16)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btHuyBoLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHuyBoLocActionPerformed
  txtTimKiem.setText("");
        cboVaiTro.setSelectedItem("All");
        cboTrangThai.setSelectedItem("All");
        loadTable(list);
    }//GEN-LAST:event_btHuyBoLocActionPerformed

    private void btApDungBoLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btApDungBoLocActionPerformed
  // TODO add your handling code here:
         try {
            String search = txtTimKiem.getText();
            String vaiTro = cboVaiTro.getSelectedItem().toString();
            String trangThai = cboTrangThai.getSelectedItem().toString();
            String query = "SELECT * FROM NguoiDung WHERE (HoTen LIKE '%" + search + "%' OR Email LIKE '%" + search
                + "%' OR SDT LIKE '%" + search + "%' OR ID LIKE '%" + search + "%')";
            if (!"All".equals(vaiTro)) {
                query += " AND VaiTro='" + vaiTro + "'";
            }
            if (!"All".equals(trangThai)) {
                query += " AND TrangThai='" + trangThai + "'";
            }
            executeSQL(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
        
    }//GEN-LAST:event_btApDungBoLocActionPerformed

    private void tbNguoiDungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNguoiDungMouseClicked
                int row = tbNguoiDung.getSelectedRow();
        if (row >= 0) {
            defaultTable(row);
        }
    }//GEN-LAST:event_tbNguoiDungMouseClicked

    private void btThemNguoiDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemNguoiDungActionPerformed
      try {
        NguoiDung nguoiDung = getFromDt();
        if (nguoiDung != null && repo.add(nguoiDung)) {
            JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
            // Tải lại dữ liệu từ cơ sở dữ liệu và hiển thị bản ghi mới ở đầu
            loadTable(repo.getAll());
        } else {
            JOptionPane.showMessageDialog(this, "Thêm mới thất bại!");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Có lỗi xảy ra: " + e.getMessage());
    }
    }//GEN-LAST:event_btThemNguoiDungActionPerformed

    private void btResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResetActionPerformed
         txtID.setText("");
        txtHoTen.setText("");
        txtEmail.setText("");
        txtMatKhau.setText("");
        txtChuyenKhoa.setText("");
        txtSoNamKinhNghiem.setText("");
        txtNgayTao.setText("");
        txtSDT.setText("");
    }//GEN-LAST:event_btResetActionPerformed

    private void btCapNhapNguoidungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCapNhapNguoidungActionPerformed
          try {
        NguoiDung nguoiDung = getFromDt();
        if (nguoiDung != null && repo.updateNguoiDung(nguoiDung)) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            loadTable(list); // Tải lại dữ liệu sau khi cập nhật thành công
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Có lỗi xảy ra: " + e.getMessage());
    }
    }//GEN-LAST:event_btCapNhapNguoidungActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
         Long id = Long.parseLong(txtID.getText().trim());
        String vaiTro = cboVaiTro.getSelectedItem().toString();
        if (repo.deleteNguoiDung(id, vaiTro)) {
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
            loadTable(list); // Tải lại dữ liệu sau khi xóa thành công
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại!");
        }
    }//GEN-LAST:event_btXoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SDT;
    private javax.swing.JButton btApDungBoLoc;
    private javax.swing.JButton btCapNhapNguoidung;
    private javax.swing.JButton btHuyBoLoc;
    private javax.swing.JButton btReset;
    private javax.swing.JButton btThemNguoiDung;
    private javax.swing.JButton btXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JComboBox<String> cboVaiTro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label3;
    private javax.swing.JTable tbNguoiDung;
    private javax.swing.JTextField txtChuyenKhoa;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoNamKinhNghiem;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    private boolean isValidNumericField(String soNamKinhNghiem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private boolean isValidPhoneNumber(String sdt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private boolean isValidEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void executeSQL(String query) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void Dialog(From_LeTan aThis, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
