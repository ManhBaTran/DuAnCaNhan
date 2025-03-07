/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.poly.ph49571;

import com.poly.ph49571.DichVuServices;
import com.poly.ph49571.ModeDichVu;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ASUS
 */
public class ViewDichVuu extends javax.swing.JPanel {
     ArrayList<ModeDichVu> globalist = new ArrayList<>();
    DefaultTableModel mode = new DefaultTableModel();
    DichVuServices dvsv = new DichVuServices();
    ArrayList<ModeDichVu> currentSearchResult = new ArrayList<>();
    /**
     * Creates new form ViewDichVuu
     */
    public ViewDichVuu() throws SQLException {
        initComponents();
        
        getdatadichvu();
//        hienthicuoi();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        cbongaytao.setDateFormat(dateFormat);
        cbongaybatdau.setDateFormat(dateFormat);
        cbongayketthuc.setDateFormat(dateFormat);
    }
    

     public void getdatadichvu() throws SQLException {
        globalist = dvsv.getdata();
        this.displayToTable(globalist);

    }

     public void displayToTable(ArrayList<ModeDichVu> list) {
//        list = globalist;
        System.out.println("displayToTable - Size of list: " + list.size());
            for (ModeDichVu dv : list) {
                System.out.println(dv);
            }
        DefaultTableModel model = (DefaultTableModel) tbtbale.getModel();
        model.setRowCount(0);
        for (ModeDichVu dichvu : list) {
            Object[] row = {
                dichvu.getStt(), 
                dichvu.getTen_dichvu(), 
                dichvu.getMota(), 
                dichvu.getChiphi(),
                dichvu.getSoluong(),
                dichvu.getDonvitinh(), 
                dichvu.getNgaytao(), 
                dichvu.getTrangthai()};
            model.addRow(row);
        }
    }
    
    public void displaycontrol(int index) {
        ModeDichVu dv = globalist.get(index);
        txtstt.setText(Integer.toString(dv.getStt()));
        txttendichvu.setText(dv.getTen_dichvu());
        txtmota.setText(dv.getMota());
        txtchiphi.setText(Double.toString(dv.getChiphi()));
        txtsoluong.setText(Integer.toString(dv.getSoluong()));
        txtngaytao.setText(dv.getNgaytao());
        
        
//        try {
//            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) mode.getValueAt(ViewDichVu, 6));
//            cbongaytao.setDate(date);
//        } catch (Exception e) {
//        }
        txtdonvitinh.setText(dv.getDonvitinh());
        
        if (dv.getTrangthai().equalsIgnoreCase("Hoạt động")) {
            rdohoatdong.setSelected(true);
        } else if (dv.getTrangthai().equalsIgnoreCase("Không hoạt Động")) {
            rdokohoatdong.setSelected(true);
        }
    }

//    public void hienthicuoi(){
//        displaycontrol(0);
//    }
//    public boolean check(){
//        if (txttendichvu.getText().trim().isEmpty() || txtmota.getText().trim().isEmpty() || txtdonvitinh.getText().isEmpty() ||txtchiphi.getText().isEmpty() || (!rdohoatdong.isSelected() && !rdokohoatdong.isSelected())) {
//            JOptionPane.showMessageDialog(this, "ko dc de trong");
//            return false;
//        }
////        if (pwmatkhau.getPassword().length<8 || pwmatkhau.getPassword().length>12) {
////            JOptionPane.showMessageDialog(this, "Mat khau phai co min ki tu 8 den 12");
////            return false;
////        }
//        return true;
//    }
    public boolean check() {
        // Kiểm tra nếu có trường nào bị bỏ trống
        if (txttendichvu.getText().trim().isEmpty() || 
            txtmota.getText().trim().isEmpty() || 
            txtdonvitinh.getText().trim().isEmpty() || 
            txtngaytao.getText().trim().isEmpty() ||
            txtchiphi.getText().trim().isEmpty() || 
            txtsoluong.getText().trim().isEmpty() || // Kiểm tra trường Số Lượng
            (!rdohoatdong.isSelected() && !rdokohoatdong.isSelected())) {
            JOptionPane.showMessageDialog(this, "Không được để trống bất kỳ trường nào!");
            return false;
        }

        // Kiểm tra nếu tên dịch vụ bị trùng
        if (dvsv.isServiceNameDuplicate(txttendichvu.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Tên dịch vụ không được trùng!");
            return false;
        }

        // Kiểm tra chi phí chỉ chứa số và là số dương
        try {
            double cost = Double.parseDouble(txtchiphi.getText().trim());
            if (cost < 0) {
                JOptionPane.showMessageDialog(this, "Chi phí phải là số dương!");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Chi phí chỉ được nhập số!");
            return false;
        }

        // Kiểm tra số lượng chỉ chứa số và là số dương
        try {
            int quantity = Integer.parseInt(txtsoluong.getText().trim());
            if (quantity < 1) {
                JOptionPane.showMessageDialog(this, "Số lượng phải là số dương và lớn hơn 0!");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng chỉ được nhập số!");
            return false;
        }

        // Kiểm tra ngày tạo không nằm trong tương lai
        LocalDate currentDate = LocalDate.now();
        try {
            LocalDate creationDate = LocalDate.parse(txtngaytao.getText().trim());
            if (creationDate.isAfter(currentDate)) {
                JOptionPane.showMessageDialog(this, "Ngày tạo không được là ngày trong tương lai!");
                return false;
            }
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Định dạng ngày không hợp lệ!");
            return false;
        }

        return true;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtchiphi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtdonvitinh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txttendichvu = new javax.swing.JTextField();
        txtmota = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtstt = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        rdohoatdong = new javax.swing.JRadioButton();
        rdokohoatdong = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        txtsoluong = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtngaytao = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        cbcheckhoatdong = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        cbongaybatdau = new de.wannawork.jcalendar.JCalendarComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbongayketthuc = new de.wannawork.jcalendar.JCalendarComboBox();
        btntimtheongay = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtbale = new javax.swing.JTable();
        btntimkiem = new javax.swing.JButton();
        txttimkiem = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        btnxoa = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnthem = new javax.swing.JButton();
        btnlammoi = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi Tiết Dịch Vụ"));

        txtchiphi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtchiphiActionPerformed(evt);
            }
        });

        jLabel4.setText("Chi Phí :");

        jLabel5.setText("Đơn Vị Tính:");

        jLabel1.setText("Tên Dịch Vụ :");

        jLabel3.setText("Mô Tả :");

        jLabel2.setText("Stt :");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Trạng Thái"));

        buttonGroup1.add(rdohoatdong);
        rdohoatdong.setSelected(true);
        rdohoatdong.setText("Hoạt Động");

        buttonGroup1.add(rdokohoatdong);
        rdokohoatdong.setText("Không Hoạt Động");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(rdohoatdong, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(rdokohoatdong)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdohoatdong)
                    .addComponent(rdokohoatdong))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel10.setText("Số Lượng:");

        txtsoluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsoluongActionPerformed(evt);
            }
        });

        jLabel11.setText("Ngày Tạo:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtsoluong)
                        .addComponent(txtmota, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                        .addComponent(txttendichvu)
                        .addComponent(txtstt))
                    .addComponent(txtchiphi, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtdonvitinh, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                            .addComponent(txtngaytao))))
                .addGap(0, 56, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtstt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtdonvitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txttendichvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(txtngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtchiphi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc"));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        cbcheckhoatdong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoạt động", "Không hoạt động" }));
        cbcheckhoatdong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbcheckhoatdongMouseClicked(evt);
            }
        });
        cbcheckhoatdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbcheckhoatdongActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/filter-filled-tool-symbol.png"))); // NOI18N
        jLabel6.setText("Trạng Thái");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(cbcheckhoatdong, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(99, 99, 99))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbcheckhoatdong, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Kiếm Theo Ngày"));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/time (1).png"))); // NOI18N
        jLabel8.setText("Ngày Bắt Đầu :");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/time (1).png"))); // NOI18N
        jLabel9.setText("Ngày Kết Thúc:");

        btntimtheongay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search2.png"))); // NOI18N
        btntimtheongay.setText("Tìm ");
        btntimtheongay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimtheongayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbongaybatdau, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(cbongayketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(btntimtheongay, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbongayketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbongaybatdau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(btntimtheongay))))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 255, 102));
        jLabel7.setText("Dịch Vụ");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Dịch  Vụ"));

        tbtbale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Số Thứ Tự", "Tên Dịch Vụ", "Mô Tả", "Chi Phí", "Số Lượng", "Đơn Vị Tính", "Ngày Tạo", "Trạng Thái"
            }
        ));
        tbtbale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtbaleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbtbale);

        btntimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/filter-filled-tool-symbol.png"))); // NOI18N
        btntimkiem.setText("Tìm Kiếm ");
        btntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(706, 706, 706)
                .addComponent(btntimkiem)
                .addGap(18, 18, 18)
                .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntimkiem)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnxoa.setForeground(new java.awt.Color(255, 51, 51));
        btnxoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/delete.png"))); // NOI18N
        btnxoa.setText("Xóa Dịch Vụ");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnsua.setForeground(new java.awt.Color(51, 51, 0));
        btnsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/refresh.png"))); // NOI18N
        btnsua.setText("Sửa Dịch Vụ");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnthem.setForeground(new java.awt.Color(51, 0, 0));
        btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/add.png"))); // NOI18N
        btnthem.setText("Thêm Dịch Vụ");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnlammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/return.png"))); // NOI18N
        btnlammoi.setText("Làm Mới");
        btnlammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlammoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnxoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnthem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(btnlammoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnlammoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(490, 490, 490)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 125, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtchiphiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtchiphiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtchiphiActionPerformed

    private void txtsoluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsoluongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsoluongActionPerformed

    private void cbcheckhoatdongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbcheckhoatdongMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbcheckhoatdongMouseClicked

    private void cbcheckhoatdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbcheckhoatdongActionPerformed
        String hd=cbcheckhoatdong.getSelectedItem().toString();
        String hoatDong = null;
        if(hd.equals("Hoạt động")){
            hoatDong="Hoạt động";

        }
        else if(hd.equals("Không hoạt động")){
            hoatDong="Không hoạt động";
        }
        try {

            //            displayToTable(dvsv.timcb(hoatDong));
            ArrayList<ModeDichVu> searchResult = dvsv.timcb(hoatDong);
            currentSearchResult = searchResult;
            displayToTable(searchResult);
            System.out.println("size" +searchResult.size());
        } catch (SQLException ex) {
            Logger.getLogger(ViewDichVu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_cbcheckhoatdongActionPerformed

    private void btntimtheongayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimtheongayActionPerformed
        // TODO add your handling code here:
        Date startDate = cbongaybatdau.getDate();
        Date endDate = cbongayketthuc.getDate();

        // Kiểm tra nếu ngày bắt đầu và ngày kết thúc không null
        if (startDate != null && endDate != null) {
            // Chuyển đổi từ java.util.Date sang java.sql.Date
            java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
            java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());

            // Gọi phương thức timTheoNgay để lấy danh sách hóa đơn trong khoảng ngày
            //            List<ModeDichVu> dichvulist =dvsv.timTheoNgay(sqlStartDate, sqlEndDate);
            //
            //            // Xử lý danh sách hóa đơn để hiển thị trong bảng hoặc nơi bạn muốn
            //            DefaultTableModel model = (DefaultTableModel) tbtbale.getModel();
            //            model.setRowCount(0); // Xóa tất cả các dòng hiện tại
            //            for (ModeDichVu modeDichVu : dichvulist) {
                //                Object row[] ={
                    //                    modeDichVu.getStt(),
                    //                    modeDichVu.getTen_dichvu(),
                    //                    modeDichVu.getMota(),
                    //                    modeDichVu.getChiphi(),
                    //                    modeDichVu.getSoluong(),
                    //                    modeDichVu.getDonvitinh(),
                    //                    modeDichVu.getNgaytao(),
                    //                    modeDichVu.getTrangthai()};
                //                model.addRow(row);
                //            }
            ArrayList<ModeDichVu> searchResult = dvsv.timTheoNgay(sqlStartDate, sqlEndDate);
            currentSearchResult = searchResult;
            displayToTable(searchResult);
        }else{
            // Thông báo lỗi nếu ngày bắt đầu hoặc ngày kết thúc null
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày bắt đầu và ngày kết thúc hợp lệ.");
        }
    }//GEN-LAST:event_btntimtheongayActionPerformed

    private void tbtbaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtbaleMouseClicked
         // TODO add your handling code here:
        int index = tbtbale.getSelectedRow();
        displaycontrol(index);
    }//GEN-LAST:event_tbtbaleMouseClicked

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
        try {
            String searchText = txttimkiem.getText().trim();

            ArrayList<ModeDichVu> searchResult;
            if (searchText.matches("\\d+")) {
                // Nếu chuỗi tìm kiếm chỉ chứa số, tìm kiếm theo ID
                searchResult = dvsv.tim(Integer.parseInt(searchText));
            } else {
                // Nếu chuỗi tìm kiếm chứa ký tự, tìm kiếm theo tên
                searchResult = dvsv.timTheoTen(searchText);
            }

            displayToTable(searchResult);
            System.out.println("list " + searchResult.size());
        } catch (SQLException ex) {
            Logger.getLogger(ViewDichVu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btntimkiemActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
          // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa dịch vụ này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
        ModeDichVu dv = new ModeDichVu();
        dv.setStt(Integer.parseInt(txtstt.getText()));
        
        try {
            dvsv.remove(dv);
            JOptionPane.showMessageDialog(this, "ban da xoa thanh cong");
            globalist.clear();
            getdatadichvu();
        } catch (SQLException ex) {
            Logger.getLogger(ViewDichVu.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
            else {
                JOptionPane.showMessageDialog(this, "Thao tác xóa bị hủy.");
            }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:

//        ModeDichVu dv = new ModeDichVu();
        if (!check()) {
            return;
        }
        int result = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn sửa dịch vụ này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            int index = tbtbale.getSelectedRow();
            ModeDichVu dv;
            try {
                dv = dvsv.getdata().get(index);
                dv.setTen_dichvu(txttendichvu.getText());
                dv.setMota(txtmota.getText());
                dv.setChiphi(Double.parseDouble(txtchiphi.getText()));
                dv.setSoluong(Integer.parseInt(txtsoluong.getText()));
                dv.setDonvitinh(txtdonvitinh.getText());
                dv.setNgaytao(txtngaytao.getText());
                if (rdohoatdong.isSelected()) {
                    dv.setTrangthai("Hoạt động");
                }
                if (rdokohoatdong.isSelected()) {
                    dv.setTrangthai("Không hoạt động");
                }
                try {
                    dvsv.update(dv);
                    JOptionPane.showMessageDialog(this, "ban da sua thanh cong");
                    globalist.clear();
                    getdatadichvu();
                } catch (SQLException ex) {
                    Logger.getLogger(ViewDichVu.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ViewDichVu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else {
        JOptionPane.showMessageDialog(this, "Thao tác sửa bị hủy.");
}

    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
          // TODO add your handling code here:
        if (!check()) {
            return;
        }
        int result = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thêm dịch vụ này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
            ModeDichVu dv = new ModeDichVu();
            dv.setTen_dichvu(txttendichvu.getText());
            dv.setMota(txtmota.getText());
            dv.setChiphi(Double.parseDouble(txtchiphi.getText()));
            dv.setSoluong(Integer.parseInt(txtsoluong.getText()));
            dv.setDonvitinh(txtdonvitinh.getText());
            dv.setNgaytao(txtngaytao.getText());
            if (rdohoatdong.isSelected()) {
                dv.setTrangthai("Hoạt Động");
            }
            if (rdokohoatdong.isSelected()) {
                dv.setTrangthai("Không hoạt động");
            }
            try {

                dvsv.add(dv);
                JOptionPane.showMessageDialog(this, "ban da them thanh cong");
                globalist.clear();
                getdatadichvu();
            } catch (SQLException ex) {
                Logger.getLogger(ViewDichVu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Thao tác thêm bị hủy.");
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnlammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlammoiActionPerformed
         try {
            // TODO add your handling code here:
            
            txtstt.setText("");
            txtchiphi.setText("");
            txtdonvitinh.setText("");
            txtmota.setText("");
            txtngaytao.setText("");
            txtsoluong.setText("");
            txttendichvu.setText("");
            txttimkiem.setText("");
            buttonGroup1.clearSelection();
//            displayToTable(dvsv.getdata());
            getdatadichvu();
            JOptionPane.showMessageDialog(this, "Làm Mới Thành Công");
            System.out.println("db : "+globalist.size());
        } catch (SQLException ex) {
            Logger.getLogger(ViewDichVu.class.getName()).log(Level.SEVERE, null, ex);
            
        }

    }//GEN-LAST:event_btnlammoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlammoi;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JButton btntimtheongay;
    private javax.swing.JButton btnxoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbcheckhoatdong;
    private de.wannawork.jcalendar.JCalendarComboBox cbongaybatdau;
    private de.wannawork.jcalendar.JCalendarComboBox cbongayketthuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdohoatdong;
    private javax.swing.JRadioButton rdokohoatdong;
    private javax.swing.JTable tbtbale;
    private javax.swing.JTextField txtchiphi;
    private javax.swing.JTextField txtdonvitinh;
    private javax.swing.JTextField txtmota;
    private javax.swing.JTextField txtngaytao;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JTextField txtstt;
    private javax.swing.JTextField txttendichvu;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables


}
