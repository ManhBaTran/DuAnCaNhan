/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.poly.view;

import com.poly.entity.BacSi;
import com.poly.entity.BacSiLichLamViec;
import com.poly.entity.BenhNhan;
import com.poly.entity.NguoiDung;
import com.poly.ph49507.LichHen;
import com.poly.repository.RepoBacSi;
import com.poly.repository.RepoBsLlv;
import com.toedter.calendar.JDateChooser;
import de.wannawork.jcalendar.JCalendarComboBox;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author manh9
 */
public class NewJFrame1lh extends javax.swing.JFrame {
    
    //lich lam viec bs
     private RepoBsLlv repoBsllv = new RepoBsLlv();
    private List<BacSiLichLamViec> listBsLlv = new ArrayList<>();
    private DefaultTableModel dtm = new DefaultTableModel();

    public NewJFrame1lh() throws SQLException {
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
        cboNgaySinh.setDateFormat(dateFormat);

          initComboBox();
    }
 private void initComboBox() {
         cboThoiGianKham.addItem("08:00-12:00");
         cboThoiGianKham.addItem("13:00-17:00");
         cboThoiGianKham.addItem("8:30-12:00");
         cboThoiGianKham.addItem("13:30-17:00");
         cboThoiGianKham.addItem("14:00-17:00");

    }
 
 


    private java.sql.Time convertToSQLTime(String time) {
        // Giả sử định dạng đầu vào là hh:mm-hh:mm và bạn muốn chuyển nó thành hh:mm:ss
        String[] parts = time.split("-");
        if (parts.length == 2) {
            String start = parts[0] + ":00";
            String end = parts[1] + ":00";
            // Chỉ lấy giờ bắt đầu
            return java.sql.Time.valueOf(start);
        }
        throw new IllegalArgumentException("Invalid time format");
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


 private void defaultTable(int index) {
    // Lấy dữ liệu từ hàng được chọn
    String ten = tbNguoiDung.getValueAt(index, 1).toString(); // Cột 2 là tên
    String email = tbNguoiDung.getValueAt(index, 3).toString(); // Cột 4 là email
    String sdt = tbNguoiDung.getValueAt(index, 2).toString(); // Cột 3 là số điện thoại
    String diaChi = tbNguoiDung.getValueAt(index, 4).toString(); // Cột 5 là địa chỉ
    String ngaySinh = tbNguoiDung.getValueAt(index, 5).toString(); // Cột 6 là ngày sinh
    String gioiTinh = tbNguoiDung.getValueAt(index, 6).toString(); // Cột 7 là giới tính

    // Cập nhật các thành phần giao diện với dữ liệu lấy từ bảng
    txtTen.setText(ten);
    txtEmail.setText(email);
    txtSDT.setText(sdt);
    txtDiaChi.setText(diaChi);
    
    // Định dạng ngày tháng
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày
    try {
        Date date = dateFormat.parse(ngaySinh); // Chuyển đổi chuỗi thành java.util.Date
        cboNgaySinh.setDate(date); // Đặt giá trị cho JCalendar
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
}
  
   public BacSiLichLamViec getFromDt() {
    // Lấy dữ liệu từ các trường nhập liệu
    String ten = txtTen.getText().trim();
    String email = txtEmail.getText().trim();
    String sdt = txtSDT.getText().trim();
    String diaChi = txtDiaChi.getText().trim();
    
    // Lấy ngày sinh từ JDateChooser và chuyển đổi thành chuỗi
    JCalendarComboBox dateChooser = cboNgayKham; // Giả sử cboNgaySinh là JDateChooser
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String ngaySinh = "";
    if (dateChooser.getDate() != null) {
        ngaySinh = dateFormat.format(dateChooser.getDate());
    }
    
    String gioiTinh = rdNam.isSelected() ? "Nam" : "Nữ";

    // Tạo và trả về một đối tượng BacSiLichLamViec với các dữ liệu lấy được
    BacSiLichLamViec bacSiLichLamViec = new BacSiLichLamViec();
    bacSiLichLamViec.setTenBN(ten);
    bacSiLichLamViec.setEmail(email);
    bacSiLichLamViec.setSdtBN(sdt);
    bacSiLichLamViec.setDiachi(diaChi);
    bacSiLichLamViec.setNgaysinh(ngaySinh);
    bacSiLichLamViec.setGioitinh(gioiTinh);

    return bacSiLichLamViec;
}

 private void loadBacSiTable() {
    DefaultTableModel model = (DefaultTableModel) tbBacSi.getModel();
    model.setRowCount(0); // Xóa toàn bộ dữ liệu hiện có trong bảng

    // Lấy dữ liệu từ cơ sở dữ liệu (giả sử bạn có phương thức getAllBacSi() để lấy danh sách bác sĩ)
    List<BacSiLichLamViec> listBacSi = repoBsllv.getAllBacSiLichLamViec();
    
    // Thêm dữ liệu vào bảng
    for (BacSiLichLamViec bacSiLlv : listBacSi) {
        model.addRow(new Object[]{bacSiLlv.getIdBS(), bacSiLlv.getTenBacSi(), bacSiLlv.getNgayLamViec(), bacSiLlv.getThoiGianBatDau(), bacSiLlv.getThoiGianKetThuc(), bacSiLlv.getCaLamViec(), bacSiLlv.getTrangThaiBS()});
    }
}

// Phương thức để tải lại dữ liệu bảng người dùng
private void loadNguoiDungTable() {
    DefaultTableModel model = (DefaultTableModel) tbNguoiDung.getModel();
    model.setRowCount(0); // Xóa toàn bộ dữ liệu hiện có trong bảng

    // Lấy dữ liệu từ cơ sở dữ liệu (giả sử bạn có phương thức getAllLichHen() để lấy danh sách lịch hẹn)
    List<BacSiLichLamViec> listLichHen = repoBsllv.getAllLichHen();
    
    // Thêm dữ liệu vào bảng
    for (BacSiLichLamViec lichHen : listLichHen) {
        model.addRow(new Object[]{
            lichHen.getIdLH(), lichHen.getTenBN(), lichHen.getSdtBN(), lichHen.getEmail(), lichHen.getDiachi(), 
            lichHen.getNgaysinh(), lichHen.getGioitinh(), lichHen.getTenBacSi(), lichHen.getNgayHen(), lichHen.getGioHen(),
            lichHen.getNgayDatLich(), lichHen.getTrangThaiLH()
        });
    }
}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTen = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbBacSi = new javax.swing.JTable();
        btChonBacSi = new javax.swing.JButton();
        btHuyBacSi = new javax.swing.JButton();
        txtDiaChi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNguoiDung = new javax.swing.JTable();
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
        cboNgaySinh = new de.wannawork.jcalendar.JCalendarComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtTen.setText(" ");

        txtEmail.setText(" ");

        txtSDT.setText(" ");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbBacSi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Tên Bác Sĩ", "Ngày làm việc", "Thời gian bắt đầu", "Thời gian kết thúc", "Ca làm việc", "TrangThai"
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
        btHuyBacSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHuyBacSiActionPerformed(evt);
            }
        });

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

        tbNguoiDung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Lịch Hẹn", "Tên Bệnh Nhân", "SDT", "Email", "Địa chỉ", "Ngày Sinh", "GioiTinh", "Tên Bác Sĩ", "Ngày hẹn", "Giờ hẹn", "Ngày đặt lịch", "TrangThai"
            }
        ));
        tbNguoiDung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNguoiDungMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbNguoiDung);

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

        rdNam.setSelected(true);
        rdNam.setText("Nam");

        rdNu.setText("Nữ");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 204, 255));
        jLabel10.setText("Đặt Lịch Hẹn");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("Chọn Bác sĩ");

        cboThoiGianKham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn thời gian khám" }));
        cboThoiGianKham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThoiGianKhamActionPerformed(evt);
            }
        });

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
        btHuy.setText("Xóa");

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
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(rdNam)
                                                .addGap(27, 27, 27)
                                                .addComponent(rdNu))
                                            .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                            .addComponent(cboNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(439, 439, 439)
                        .addComponent(jLabel10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(cboNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btDatLich, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btResset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSuaThongTin)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbBacSiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBacSiMouseClicked
            int selectedRow = tbBacSi.getSelectedRow();
   
    }//GEN-LAST:event_tbBacSiMouseClicked

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

    private void tbNguoiDungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNguoiDungMouseClicked
    int index = tbNguoiDung.getSelectedRow();
    if (index >= 0) {
        defaultTable(index);
    }
    }//GEN-LAST:event_tbNguoiDungMouseClicked

    private void cboNgayKhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboNgayKhamMouseClicked

    }//GEN-LAST:event_cboNgayKhamMouseClicked

    private void btDatLichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDatLichActionPerformed
 BacSiLichLamViec newLichHen = getFromDt(); // Lấy dữ liệu từ giao diện người dùng

    // Kiểm tra dữ liệu hợp lệ
    if (validateLichHen(newLichHen)) {
        // Thêm lịch hẹn vào cơ sở dữ liệu
        repoBsllv.addLichHen(newLichHen);

        // Tải lại bảng lịch hẹn
        loadNguoiDungTable();
        JOptionPane.showMessageDialog(this, "Đặt lịch thành công!");
    } else {
        JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!");
    }
}

private boolean validateLichHen(BacSiLichLamViec lichHen) {
    // Kiểm tra dữ liệu hợp lệ (ví dụ: tên không rỗng, email hợp lệ, v.v.)
    if (lichHen.getTenBN().isEmpty() || lichHen.getEmail().isEmpty() || lichHen.getSdtBN().isEmpty() || lichHen.getNgayHen() == null) {
        return false;
    }
    return true;
    }//GEN-LAST:event_btDatLichActionPerformed

    private void btRessetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRessetActionPerformed
//        // Reset tất cả các trường
//    txtTen.setText("");
//    txtEmail.setText("");
//    txtSDT.setText("");
//    txtDiaChi.setText("");
//    
//    // Reset các JComboBox và JDateChooser
//    cboThoiGianKham.setSelectedIndex(0); // Đặt lại JComboBox về lựa chọn đầu tiên
//    
//    // Reset JDateChooser về không có ngày chọn
//    cboNgayKham.setDate(null); // Đặt lại JDateChooser về không có ngày chọn
//
//    // Reset trường ngày sinh (JDateChooser)
//    cboNgaySinh.setDate(null); // Đặt lại JDateChooser về không có ngày chọn hoặc bạn có thể đặt ngày cụ thể nếu cần
//    
//    // Reset trường tìm kiếm
//    txtTimKiem.setText("Tìm theo tên hoặc số điện thoại");
//    
//    // Bỏ chọn các dòng trong bảng nếu có
//    tbBacSi.clearSelection();
//    tbNguoiDung.clearSelection();
//   
//    // Tải lại bảng bác sĩ và người dùng
//    loadBacSiTable();
//    loadNguoiDungTable();
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

    private void btChonNgayKhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChonNgayKhamActionPerformed
       // Lấy ngày từ JCalendar
    Date selectedDate = cboNgayKham.getDate();
    if (selectedDate == null) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày khám.");
        return;
    }
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String ngayLamViec = sdf.format(selectedDate);

    // Lấy giờ từ JComboBox
    String thoiGianBatDauKetThuc = (String) cboThoiGianKham.getSelectedItem();
    if (thoiGianBatDauKetThuc == null) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn thời gian khám.");
        return;
    }

    // Tách chuỗi để lấy thời gian bắt đầu
    String[] parts = thoiGianBatDauKetThuc.split("-");
    if (parts.length != 2) {
        JOptionPane.showMessageDialog(this, "Thời gian khám không hợp lệ.");
        return;
    }

    String thoiGianBatDau = parts[0].trim() + ":00"; // Thêm giây vào định dạng thời gian
    String thoiGianKetThuc = parts[1].trim() + ":00"; // Thêm giây vào định dạng thời gian

    // Truy vấn dữ liệu bác sĩ
    List<BacSiLichLamViec> bacSiList = repoBsllv.getBacSiByNgayGio(ngayLamViec, thoiGianBatDau);

    // Cập nhật bảng tbBacSi với danh sách bác sĩ
    DefaultTableModel model = (DefaultTableModel) tbBacSi.getModel();
    model.setRowCount(0); // Xóa dữ liệu cũ

    if (bacSiList.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Không có bác sĩ nào vào thời gian này.");
    } else {
        for (BacSiLichLamViec bacSi : bacSiList) {
            model.addRow(new Object[]{
                bacSi.getIdBS(),
                bacSi.getTenBacSi(),
                bacSi.getNgayLamViec(),
                bacSi.getThoiGianBatDau(),
                bacSi.getThoiGianKetThuc(),
                bacSi.getCaLamViec(),
                bacSi.getTrangThaiBS()
            });
        }
    }
    }//GEN-LAST:event_btChonNgayKhamActionPerformed

    private void cboThoiGianKhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThoiGianKhamActionPerformed
         
    }//GEN-LAST:event_cboThoiGianKhamActionPerformed

    private void btHuyBacSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHuyBacSiActionPerformed
       // Bỏ chọn dòng hiện tại trong JTable
    tbBacSi.clearSelection();
    
    // Thông báo cho người dùng
    JOptionPane.showMessageDialog(this, "Đã hủy lựa chọn.");
    
    }//GEN-LAST:event_btHuyBacSiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1lh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1lh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1lh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1lh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new NewJFrame1lh().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(NewJFrame1lh.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btChonBacSi;
    private javax.swing.JButton btChonNgayKham;
    private javax.swing.JButton btDatLich;
    private javax.swing.JButton btHuy;
    private javax.swing.JButton btHuyBacSi;
    private javax.swing.JButton btResset;
    private javax.swing.JButton btSuaThongTin;
    private javax.swing.JButton btTimKiem;
    private de.wannawork.jcalendar.JCalendarComboBox cboNgayKham;
    private de.wannawork.jcalendar.JCalendarComboBox cboNgaySinh;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tbBacSi;
    private javax.swing.JTable tbNguoiDung;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    private List<BacSi> fetchInitialBacSiData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private List<NguoiDung> fetchInitialNguoiDungData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
