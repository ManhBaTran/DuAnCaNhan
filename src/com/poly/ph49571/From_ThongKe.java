/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.poly.ph49571;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author manh9
 */
public class From_ThongKe extends javax.swing.JPanel {
  ArrayList<ModeThongKe> list = new ArrayList<>();
    DefaultTableModel mode = new DefaultTableModel();
    ThongKeServices tksv = new ThongKeServices();
    public From_ThongKe() throws SQLException {
        initComponents();
         getdatathongke();
//        load();
        capNhatThongTinDichVu();
        loadtkdoanhthu();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        rdongaybatdau.setDateFormat(dateFormat);
        rdongayketthuc.setDateFormat(dateFormat);
//        cbbload();
    }
 public void getdatathongke() throws SQLException {
        list = tksv.getdata();
        this.displaytotable(tksv.getdata());
        this.displaytotbaledoanhthu(tksv.loadthongketheonam());
        this.displaytable3(tksv.doanhthungay());
        this.displaytotable4(tksv.doanhthuthang());
    }
    public void displaytotable(ArrayList<ModeThongKe> list){
        DefaultTableModel model = (DefaultTableModel) tbtable.getModel();
        model.setRowCount(0);
        for (ModeThongKe modeThongKe : list) {
            Object[] row = {modeThongKe.getIddichvu() , modeThongKe.getTendichvu() , modeThongKe.getMota() , modeThongKe.getChiphi() , modeThongKe.getDoanhthu(),modeThongKe.getTrangthai() };
            model.addRow(row);
        }
    }
    public void displaytotbaledoanhthu(ArrayList<ModeThongKe> list){
        DefaultTableModel model = (DefaultTableModel) table2.getModel();
        model.setRowCount(0);
        for (ModeThongKe modeThongKe : list) {
            Object[] row = {modeThongKe.getNam() ,modeThongKe.getDoanhthu(),modeThongKe.getThangcodoanhthucaonhat(), modeThongKe.getDoanhthuthangcaonhat() ,modeThongKe.getThangcodoanhthuthapnhat(), modeThongKe.getDoanhthuthangthapnhat() , modeThongKe.getTrungbinhdoanhthu()};
            model.addRow(row);
        }
    }
    public void displaytable3(ArrayList<ModeThongKe> list){
        DefaultTableModel model = (DefaultTableModel) table3.getModel();
        model.setRowCount(0);
        for (ModeThongKe modeThongKe : list) {
            Object[] row = {modeThongKe.getNgay() , modeThongKe.getSohoadon() , modeThongKe.getThunhapngay()};
            model.addRow(row);
        }
    }
    public void displaytotable4(ArrayList<ModeThongKe> list){
        DefaultTableModel model = (DefaultTableModel) table4.getModel();
        model.setRowCount(0);
        for (ModeThongKe modeThongKe : list) {
            Object[] row = {modeThongKe.getNam() , modeThongKe.getThang() , modeThongKe.getSohoadon() , modeThongKe.getDoanhThuThang()};
            model.addRow(row);
        }
    }
//    public void cbbload() {
//        cbbnam.removeAllItems();
//        try {
//            List<ModeThongKe> years = tksv.loadcbb(); // Gọi phương thức loadcbb()
//            for (ModeThongKe year : years) {
//                cbbnam.addItem(String.valueOf(year.getNamcbb()));  // Thêm từng năm vào JComboBox
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ViewThongKe.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

//    public void load() throws SQLException{
//        ArrayList<ModeThongKe> thongKeList = tksv.getsoluongtrangthai();
//        int soLuongHoatDong = 0;
//        int soLuongKhongHoatDong = 0;
//        int tongso = 0;
//
//        // Duyệt qua danh sách và lấy số liệu
//        for (ModeThongKe tk : thongKeList) {
//            soLuongHoatDong += tk.getSoluonght();
//            soLuongKhongHoatDong += tk.getSoluongkht();
//            tongso += tk.getTongso();
//        }
//
//        // Cập nhật JLabel
//        lblhoatdong.setText(String.valueOf(soLuongHoatDong));
//        lblkhonghoatdong.setText(String.valueOf(soLuongKhongHoatDong));
//        lbltongso.setText(String.valueOf(tongso));
//    }
    public void capNhatThongTinDichVu() {
        try {
            // Lấy tổng số dịch vụ
            int tongSoDichVu = tksv.getTongSoDichVu();
            lbltongso.setText(String.valueOf(tongSoDichVu));

            // Lấy số lượng dịch vụ theo trạng thái
            ArrayList<ModeThongKe> thongKeList = tksv.getsoluongtrangthai();
            int soLuongHoatDong = 0;
            int soLuongKhongHoatDong = 0;

            // Duyệt qua danh sách và lấy số liệu
            for (ModeThongKe tk : thongKeList) {
                soLuongHoatDong += tk.getSoluonght();
                soLuongKhongHoatDong += tk.getSoluongkht();
            }

            // Cập nhật JLabel
            lblhoatdong.setText(String.valueOf(soLuongHoatDong));
            lblkhonghoatdong.setText(String.valueOf(soLuongKhongHoatDong));
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void loadtkdoanhthu() {
        try {
            ModeThongKe thongKe = tksv.getDoanhThu();

            lbldoanhthunam.setText(String.valueOf(thongKe.getDoanhThuNam()));
            lbldoanhthuthang.setText(String.valueOf(thongKe.getDoanhThuThang()));
            lbldoanhthungay.setText(String.valueOf(thongKe.getDoanhThuHomNay()));
            lbldoanhthu7ngay.setText(String.valueOf(thongKe.getDoanhThu7Ngay()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblhoatdong = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblkhonghoatdong = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbltongso = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cbbtrangthai = new javax.swing.JComboBox<>();
        txttimkiem = new javax.swing.JTextField();
        btntimkiem = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbbsapxep = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lbldoanhthunam = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lbldoanhthungay = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lbldoanhthuthang = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        lbldoanhthu7ngay = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        table4 = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        rdongaybatdau = new de.wannawork.jcalendar.JCalendarComboBox();
        jLabel14 = new javax.swing.JLabel();
        rdongayketthuc = new de.wannawork.jcalendar.JCalendarComboBox();
        btnloc = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        cbbthang = new javax.swing.JComboBox<>();
        cbbnam = new javax.swing.JComboBox<>();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 255));
        jLabel3.setText("Thống Kê");

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setForeground(new java.awt.Color(204, 255, 204));

        jLabel1.setText("Dịch Vụ Đang Hoạt Động ");

        lblhoatdong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblhoatdong.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(61, 61, 61))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(lblhoatdong)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblhoatdong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(27, 27, 27))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setText("Dịch Vụ Không Hoạt Động");

        lblkhonghoatdong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblkhonghoatdong.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(lblkhonghoatdong)
                        .addGap(122, 122, 122))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblkhonghoatdong, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(22, 22, 22))
        );

        tbtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Dịch Vụ", "Tên  Dịch Vụ", "Mô Tả", "Chi Phí", "Doạnh Thu", "Trạng Thái"
            }
        ));
        jScrollPane1.setViewportView(tbtable);

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));

        jLabel4.setText("Tổng Số Dịch Vụ");

        lbltongso.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbltongso.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lbltongso)
                        .addGap(111, 111, 111))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lbltongso, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(24, 24, 24))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        cbbtrangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoạt động", "Không hoạt động" }));
        cbbtrangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbtrangthaiActionPerformed(evt);
            }
        });

        btntimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search2.png"))); // NOI18N
        btntimkiem.setText("Tìm Kiếm");
        btntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemActionPerformed(evt);
            }
        });

        jLabel5.setText("Chọn Hình Thức Thống Kê:");

        cbbsapxep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Top những dịch vụ có doanh thu cao nhất", "Top những dịch vụ có doanh thu thấp nhất" }));
        cbbsapxep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbsapxepActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/refresh.png"))); // NOI18N
        jButton1.setText("Làm Mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btntimkiem)
                .addGap(45, 45, 45)
                .addComponent(jButton1)
                .addGap(70, 70, 70)
                .addComponent(cbbtrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(cbbsapxep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbtrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntimkiem)
                    .addComponent(jLabel5)
                    .addComponent(cbbsapxep, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("Dịch Vụ", jPanel6);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel5.setBackground(new java.awt.Color(153, 255, 153));

        lbldoanhthunam.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbldoanhthunam.setText("0");

        jLabel7.setText("Doanh Thu Cả Năm Nay");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel7)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbldoanhthunam, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lbldoanhthunam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(31, 31, 31))
        );

        jPanel9.setBackground(new java.awt.Color(204, 204, 255));

        lbldoanhthungay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbldoanhthungay.setText("0");

        jLabel11.setText("Doanh Thu Hôm Nay");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(lbldoanhthungay, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbldoanhthungay)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(33, 33, 33))
        );

        jPanel8.setBackground(new java.awt.Color(255, 204, 204));

        lbldoanhthuthang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbldoanhthuthang.setText("0");

        jLabel9.setText("Doanh Thu Tháng Này");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldoanhthuthang, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbldoanhthuthang)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(31, 31, 31))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 153));

        lbldoanhthu7ngay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbldoanhthu7ngay.setText("0");

        jLabel13.setText("Doanh Thu 7 Ngày Gần Nhất");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbldoanhthu7ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbldoanhthu7ngay)
                .addGap(27, 27, 27)
                .addComponent(jLabel13)
                .addGap(31, 31, 31))
        );

        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Ngày", "Số Lượng Hóa Đơn ", "Doanh Thu"
            }
        ));
        jScrollPane3.setViewportView(table3);

        table4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Năm", "Tháng", "Số Hóa Đơn", "Doanh Thu"
            }
        ));
        jScrollPane4.setViewportView(table4);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Theo Ngày"));

        jLabel14.setText("Đến");

        btnloc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/filter-filled-tool-symbol.png"))); // NOI18N
        btnloc.setText("Lọc");
        btnloc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(rdongaybatdau, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdongayketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnloc))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnloc)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(rdongayketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(rdongaybatdau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        cbbthang.setBackground(new java.awt.Color(204, 204, 255));
        cbbthang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10 ", "Tháng 11", "Tháng 12" }));
        cbbthang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbthangActionPerformed(evt);
            }
        });

        cbbnam.setBackground(new java.awt.Color(204, 204, 255));
        cbbnam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", " " }));
        cbbnam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbnamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(cbbnam, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(cbbthang, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbnam, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbthang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Năm", "Tổng Doanh Thu", "Tháng Có Doanh Thu Cao Nhất", "Doanh Thu Tháng Cao Nhất", "Tháng Có Doanh Thu Thấp Nhất", "Doanh Thu Tháng Thấp Nhất", "Trung Bình Doanh Thu Các Tháng"
            }
        ));
        jScrollPane2.setViewportView(table2);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1221, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/refresh.png"))); // NOI18N
        jButton2.setText("Làm Mới");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4)
                .addGap(41, 41, 41))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)))
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(73, 73, 73))
        );

        jTabbedPane2.addTab("Doanh Thu", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(542, 542, 542)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbtrangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbtrangthaiActionPerformed
        // TODO add your handling code here:
        String hd=cbbtrangthai.getSelectedItem().toString();
        String hoatDong = null;
        if(hd.equals("Hoạt động")){
            hoatDong="Hoạt động";

        }
        else if(hd.equals("Không hoạt động")){
            hoatDong="Không hoạt động";
        }
        try {

            //            displayToTable(dvsv.timcb(hoatDong));
            ArrayList<ModeThongKe> searchResult = tksv.timtrangthai(hoatDong);
            displaytotable(searchResult);
            System.out.println("size" +searchResult.size());
        } catch (SQLException ex) {
            Logger.getLogger(ViewDichVu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbbtrangthaiActionPerformed

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
        // TODO add your handling code here:
        try {
            String searchText = txttimkiem.getText();
            int id = 0;
            String  name  = null;
            // TODO add your handling code here:
            //            globalList  = svcthd.tim(Integer.parseInt(txttimkiem.getText()));
            try {
                id = Integer.parseInt(searchText);
            } catch (NumberFormatException e) {
                name  = searchText;
            }
            list = tksv.tim(id, searchText);
        } catch (SQLException ex) {
            Logger.getLogger(ViewCTHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        displaytotable(list);
    }//GEN-LAST:event_btntimkiemActionPerformed

    private void cbbsapxepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbsapxepActionPerformed
        // TODO add your handling code here:
        String tt = cbbsapxep.getSelectedItem().toString();
        String thutu = null;

        if (tt.equals("Top những dịch vụ có doanh thu cao nhất")) {
            thutu = "DESC";
        } else if (tt.equals("Top những dịch vụ có doanh thu thấp nhất")) {
            thutu = "ASC";
        }

        try {
            ArrayList<ModeThongKe> searchResult = tksv.loadthutu(thutu);
            displaytotable(searchResult);
            System.out.println("size" + searchResult.size());
        } catch (SQLException ex) {
            Logger.getLogger(ViewDichVu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbbsapxepActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            displaytotable(tksv.getdata());
        } catch (SQLException ex) {
            Logger.getLogger(ViewThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnlocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlocActionPerformed
        // TODO add your handling code here:
        Date startDate = rdongaybatdau.getDate();
        Date endDate = rdongayketthuc.getDate();

        // Kiểm tra nếu ngày bắt đầu và ngày kết thúc không null
        if (startDate != null && endDate != null) {
            // Chuyển đổi từ java.util.Date sang java.sql.Date
            java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
            java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());

            // Gọi phương thức timTheoNgay để lấy danh sách hóa đơn trong khoảng ngày
            ArrayList<ModeThongKe> tklist = null;
            try {
                tklist = tksv.timtheongay(sqlStartDate, sqlEndDate);
            } catch (SQLException ex) {
                Logger.getLogger(ViewThongKe.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Xử lý danh sách hóa đơn để hiển thị trong bảng hoặc nơi bạn muốn
            DefaultTableModel model = (DefaultTableModel) table3.getModel();
            model.setRowCount(0); // Xóa tất cả các dòng hiện tại
            for (ModeThongKe modeThongKe : tklist) {
                Object[] row = {modeThongKe.getNgay() , modeThongKe.getSohoadon() , modeThongKe.getThunhapngay()};
                model.addRow(row);
            }
        } else {
            // Thông báo lỗi nếu ngày bắt đầu hoặc ngày kết thúc null
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày bắt đầu và ngày kết thúc hợp lệ.");
        }
    }//GEN-LAST:event_btnlocActionPerformed

    private void cbbthangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbthangActionPerformed
        // TODO add your handling code here:
        try {
            String selectthang = (String) cbbthang.getSelectedItem(); // Lấy giá trị từ ComboBox
            int thangvalue = Integer.parseInt(selectthang.replace("Tháng", "").trim()); // Chuyển đổi String thành Integer

            // Gọi phương thức thống kê theo tháng
            ArrayList<ModeThongKe> searchResult = tksv.tktheothang(thangvalue);
            displaytotable4(searchResult); // Hiển thị kết quả lên bảng
            System.out.println("size: " + searchResult.size());
        } catch (NumberFormatException ex) {
            // Xử lý lỗi khi chuyển đổi không thành công
            System.err.println("Lỗi chuyển đổi tháng: " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(ViewThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbbthangActionPerformed

    private void cbbnamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbnamActionPerformed
        // TODO add your handling code here:
        try {
            String selectedYear = (String) cbbnam.getSelectedItem(); // Lấy giá trị String từ ComboBox
            int namvalue = Integer.parseInt(selectedYear); // Chuyển đổi String thành Integer

            // Gọi phương thức thống kê theo năm với giá trị đã chuyển đổi
            ArrayList<ModeThongKe> searchResult = tksv.tktheonam(namvalue);
            displaytotbaledoanhthu(searchResult);
            searchResult =tksv.tktheonamthang(namvalue);
            displaytotable4(searchResult);
            System.out.println("size" + searchResult.size());

        } catch (NumberFormatException ex) {
            // Xử lý lỗi khi chuyển đổi không thành công
            System.err.println("Lỗi chuyển đổi năm: " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(ViewThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_cbbnamActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            getdatathongke();
        } catch (SQLException ex) {
            Logger.getLogger(ViewThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnloc;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JComboBox<String> cbbnam;
    private javax.swing.JComboBox<String> cbbsapxep;
    private javax.swing.JComboBox<String> cbbthang;
    private javax.swing.JComboBox<String> cbbtrangthai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lbldoanhthu7ngay;
    private javax.swing.JLabel lbldoanhthunam;
    private javax.swing.JLabel lbldoanhthungay;
    private javax.swing.JLabel lbldoanhthuthang;
    private javax.swing.JLabel lblhoatdong;
    private javax.swing.JLabel lblkhonghoatdong;
    private javax.swing.JLabel lbltongso;
    private de.wannawork.jcalendar.JCalendarComboBox rdongaybatdau;
    private de.wannawork.jcalendar.JCalendarComboBox rdongayketthuc;
    private javax.swing.JTable table2;
    private javax.swing.JTable table3;
    private javax.swing.JTable table4;
    private javax.swing.JTable tbtable;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}
