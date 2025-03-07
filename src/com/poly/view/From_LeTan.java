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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
  
public void defaultTable(int index) {
    NguoiDung nd = list.get(index);
    
    String id = tbNguoiDung.getValueAt(index, 0).toString();
    String ten = tbNguoiDung.getValueAt(index, 1).toString();
    String email = tbNguoiDung.getValueAt(index, 2).toString();
    String sdt = tbNguoiDung.getValueAt(index, 3).toString();
    String mk = tbNguoiDung.getValueAt(index, 4).toString();
    String diaChi = tbNguoiDung.getValueAt(index, 5).toString();
    String ngaySinh = tbNguoiDung.getValueAt(index, 6).toString();
    String gioiTinh = tbNguoiDung.getValueAt(index, 7).toString();
    String ngayTao = tbNguoiDung.getValueAt(index, 8).toString();
    String trangThai = tbNguoiDung.getValueAt(index, 9).toString();

    // Gán các giá trị cho các trường giao diện người dùng
    txtID.setText(id);
    txtHoTen.setText(ten);
    txtEmail.setText(email);
    txtSDT.setText(sdt);
    txtMatKhau.setText(mk);
    txtDiaChi.setText(diaChi);

    // Định dạng ngày tháng
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày
    try {
        Date dateNgaySinh = dateFormat.parse(ngaySinh); // Chuyển đổi chuỗi thành java.util.Date
        cboNgaySinh.setDate(dateNgaySinh); // Đặt giá trị cho JCalendar     
    } catch (ParseException e) {
        e.printStackTrace();
    }

    if ("Nam".equals(gioiTinh)) {
        rdNam.setSelected(true);
        rdNu.setSelected(false);
    } else {
        rdNam.setSelected(false);
        rdNu.setSelected(true);
    }

    // Định dạng ngày tạo và gán cho trường giao diện
    try {
        Date dateNgayTao = dateFormat.parse(ngayTao); // Chuyển đổi chuỗi thành java.util.Date
        txtNgayTao.setText(dateFormat.format(dateNgayTao));
    } catch (ParseException e) {
        e.printStackTrace();
        txtNgayTao.setText("");
    }

    // Đặt trạng thái trong JComboBox
    cboTrangThai.setSelectedItem(trangThai);
}




public NguoiDung getFromDt() {
    String id = txtID.getText().trim();
    String hoTen = txtHoTen.getText().trim();
    String email = txtEmail.getText().trim();
    String sdt = txtSDT.getText().trim();
    String matKhau = txtMatKhau.getText().trim();
    String diaChi = txtDiaChi.getText().trim();
    
    Date utilNgaySinh = cboNgaySinh.getDate();
    java.sql.Date sqlNgaySinh = utilNgaySinh != null ? new java.sql.Date(utilNgaySinh.getTime()) : null;
    
    String gioiTinh = rdNam.isSelected() ? "Nam" : "Nu";
    
    Date utilNgayTao = new Date(); // Hoặc lấy từ một trường khác nếu cần
    java.sql.Date sqlNgayTao = utilNgayTao != null ? new java.sql.Date(utilNgayTao.getTime()) : null;
    
    String trangThai = (String) cboTrangThai.getSelectedItem();

    NguoiDung nd = new NguoiDung();
    nd.setId(id.isEmpty() ? null : Long.parseLong(id));
    nd.setTen(hoTen);
    nd.setEmail(email);
    nd.setSoDienThoai(sdt);
    nd.setMatKhau(matKhau);
    nd.setDiaChi(diaChi);
    nd.setNgaySinh(sqlNgaySinh);
    nd.setGioiTinh(gioiTinh);
    nd.setNgayTao(sqlNgayTao);
    nd.setTrangThai(trangThai);

    return nd;
}
      
      
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label3 = new java.awt.Label();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        cboTrangThai = new javax.swing.JComboBox<>();
        btSearch = new javax.swing.JButton();
        btHuyBoLoc = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
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
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        cboNgaySinh = new de.wannawork.jcalendar.JCalendarComboBox();

        label3.setForeground(new java.awt.Color(51, 102, 255));
        label3.setText("Họ  Tên");

        jPanel1.setForeground(new java.awt.Color(102, 204, 255));

        txtID.setText(" ");
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        txtHoTen.setText(" ");

        txtEmail.setText(" ");

        txtMatKhau.setText(" ");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtTimKiem.setText("Tìm theo tên hoặc số điện thoại");

        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoạt Động", "Không Hoạt Động" }));

        btSearch.setText("Áp dụng bộ lọc");
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });

        btHuyBoLoc.setText("Hủy Bộ Lọc");
        btHuyBoLoc.setEnabled(false);
        btHuyBoLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHuyBoLocActionPerformed(evt);
            }
        });

        jLabel12.setText("Trạng thái");

        jLabel7.setText("Ngày Tạo");

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
                        .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(86, 86, 86)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboTrangThai, 0, 449, Short.MAX_VALUE)
                    .addComponent(txtNgayTao))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btHuyBoLoc)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btSearch)
                        .addComponent(jLabel12)
                        .addComponent(cboTrangThai)))
                .addGap(14, 14, 14))
        );

        btThemNguoiDung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/add.png"))); // NOI18N
        btThemNguoiDung.setText("Thêm Lễ Tân");
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
                " ID Lễ Tân", "Họ và Tên", "Email", "Số điện thoại", "Mật khẩu", "Địa chỉ", "Ngày sinh", "Giới Tính", "Ngày tạo", "Trạng thái"
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
        jLabel5.setText("Địa chỉ");

        jLabel6.setForeground(new java.awt.Color(102, 204, 255));
        jLabel6.setText("Ngày Sinh");

        jLabel8.setForeground(new java.awt.Color(102, 204, 255));
        jLabel8.setText("Giới tính");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 204, 255));
        jLabel10.setText("Quản Lý Lễ Tân");

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

        buttonGroup1.add(rdNam);
        rdNam.setSelected(true);
        rdNam.setText("Nam");

        buttonGroup1.add(rdNu);
        rdNu.setText("Nữ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SDT)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)))
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cboNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                        .addComponent(txtDiaChi))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rdNam)
                        .addGap(26, 26, 26)
                        .addComponent(rdNu))
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btCapNhapNguoidung, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                    .addComponent(btThemNguoiDung, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(486, 486, 486)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(55, 55, 55)
                                                .addComponent(jLabel1))
                                            .addComponent(jLabel10))
                                        .addGap(28, 28, 28)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel6))
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(btCapNhapNguoidung)))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btXoa)
                            .addComponent(jLabel3)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(rdNam)
                            .addComponent(rdNu)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btThemNguoiDung))
                        .addGap(25, 25, 25)
                        .addComponent(cboNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SDT)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btReset))
                .addGap(28, 28, 28)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        String searchQuery = txtTimKiem.getText().trim(); // Giả sử txtTimKiem là trường nhập tìm kiếm

        if (!searchQuery.isEmpty()) {
            List<NguoiDung> searchResults = repo.searchByNameOrPhone(searchQuery); // Gọi phương thức tìm kiếm
            loadTable(searchResults); // Làm mới bảng dữ liệu với kết quả tìm kiếm
            searchActive = true; // Đặt trạng thái tìm kiếm là hoạt động
            btHuyBoLoc.setEnabled(true); // Kích hoạt nút Hủy Bỏ Lọc
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm.");
        }
    }//GEN-LAST:event_btSearchActionPerformed
private boolean searchActive = false; // Biến trạng thái để theo dõi tìm kiếm

    private void btHuyBoLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHuyBoLocActionPerformed
        // Xóa nội dung của trường tìm kiếm
        txtTimKiem.setText(""); // Giả sử txtTimKiem là trường nhập tìm kiếm

        // Tải lại toàn bộ dữ liệu người dùng từ cơ sở dữ liệu
        List<NguoiDung> allUsers = repo.getAll(); // Giả sử phương thức getAll() đã được định nghĩa

        // Làm mới bảng dữ liệu với toàn bộ dữ liệu người dùng
        loadTable(allUsers); // Giả sử phương thức loadTable() đã được định nghĩa

        searchActive = false; // Đặt trạng thái tìm kiếm thành không hoạt động
        btHuyBoLoc.setEnabled(false); // Vô hiệu hóa nút Hủy Bỏ Lọc
    }//GEN-LAST:event_btHuyBoLocActionPerformed

    private void btThemNguoiDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemNguoiDungActionPerformed
        // Lấy dữ liệu từ các trường giao diện người dùng và tạo đối tượng NguoiDung
        NguoiDung nd = getFromDt();

        // Gọi phương thức add để thêm người dùng vào cơ sở dữ liệu
        boolean isSuccess = repo.add(nd);

        // Kiểm tra kết quả và hiển thị thông báo
        if (isSuccess) {
            JOptionPane.showMessageDialog(this, "Thêm người dùng thành công!");
            // Cập nhật lại danh sách hiển thị (nếu cần)
            list = repo.getAll();
            loadTable(list);
        } else {
            JOptionPane.showMessageDialog(this, "Thêm người dùng thất bại.");
        }
    }//GEN-LAST:event_btThemNguoiDungActionPerformed

    private void btCapNhapNguoidungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCapNhapNguoidungActionPerformed
        int selectedRow = tbNguoiDung.getSelectedRow();

        if (selectedRow >= 0) {
            // Lấy ID của người dùng từ danh sách dựa trên chỉ số hàng đã chọn
            long id = list.get(selectedRow).getId();

            // Lấy thông tin người dùng từ các trường văn bản
            NguoiDung updatedNguoiDung = getFromDt(); // Giả sử phương thức getFromDt() đã được định nghĩa

            // Cập nhật thông tin người dùng
            boolean updated = repo.update(id, updatedNguoiDung); // Giả sử phương thức update() đã được định nghĩa

            if (updated) {
                JOptionPane.showMessageDialog(this, "Cập nhật lễ tân thành công!");
                // Làm mới bảng dữ liệu sau khi cập nhật
                list = repo.getAll(); // Lấy lại danh sách người dùng mới
                loadTable(list); // Giả sử phương thức loadTable() đã được định nghĩa
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật lễ tân thất bại!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn lễ tân để cập nhật.");
        }
    }//GEN-LAST:event_btCapNhapNguoidungActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        int selectedRow = tbNguoiDung.getSelectedRow();

        if (selectedRow >= 0) {
            // Lấy ID của người dùng từ danh sách dựa trên chỉ số hàng đã chọn
            long id = list.get(selectedRow).getId();

            // Lấy thông tin người dùng từ các trường văn bản
            NguoiDung deletedNguoiDung = getFromDt(); // Giả sử phương thức getFromDt() đã được định nghĩa

            // Cập nhật thông tin người dùng
            boolean updated = repo.delete(id); // Giả sử phương thức update() đã được định nghĩa

            if (updated) {
                JOptionPane.showMessageDialog(this, "Xóa lễ tân thành công!");
                // Làm mới bảng dữ liệu sau khi cập nhật
                list = repo.getAll(); // Lấy lại danh sách người dùng mới
                loadTable(list); // Giả sử phương thức loadTable() đã được định nghĩa
            } else {
                JOptionPane.showMessageDialog(this, "Xóa lễ tân dùng thất bại!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn lễ tân để xóa.");
        }
    }//GEN-LAST:event_btXoaActionPerformed

    private void tbNguoiDungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNguoiDungMouseClicked
        int row = tbNguoiDung.getSelectedRow();
        if (row >= 0) {
            defaultTable(row);
        }
    }//GEN-LAST:event_tbNguoiDungMouseClicked

    private void btResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResetActionPerformed
        txtID.setText("");
        txtHoTen.setText("");
        txtEmail.setText("");
        txtMatKhau.setText("");
        txtDiaChi.setText("");

        txtNgayTao.setText("");
        txtSDT.setText("");

        list = repo.getAll();
        loadTable(list);
    }//GEN-LAST:event_btResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SDT;
    private javax.swing.JButton btCapNhapNguoidung;
    private javax.swing.JButton btHuyBoLoc;
    private javax.swing.JButton btReset;
    private javax.swing.JButton btSearch;
    private javax.swing.JButton btThemNguoiDung;
    private javax.swing.JButton btXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private de.wannawork.jcalendar.JCalendarComboBox cboNgaySinh;
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label3;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tbNguoiDung;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtSDT;
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
