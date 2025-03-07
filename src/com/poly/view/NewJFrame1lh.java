/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.poly.view;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.poly.database.DBConnect;
import com.poly.entity.BacSi;
import com.poly.entity.BacSiLichLamViec;
import com.poly.entity.NguoiDung;
 
import com.poly.repository.RepoBacSi;
import com.poly.repository.RepoBsLlv;
import com.toedter.calendar.JDateChooser;
import de.wannawork.jcalendar.JCalendarComboBox;
import static java.awt.image.ImageObserver.WIDTH;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
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
 //Bệnh nhân
    
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
          
         // Xóa tất cả các mục khỏi JComboBox trước khi thêm các mục mới
cboDichVu.removeAllItems();

// Giả sử bạn có một danh sách BacSiLichLamViec (listBsLlv)
  for (BacSiLichLamViec bsllv : listBsLlv) {
    // Lấy danh sách tên dịch vụ hoạt động từ repository
    List<String> activeServices = repoBsllv.getActiveServices();

    // Thêm từng dịch vụ vào JComboBox
    for (String serviceName : activeServices) {
        cboDichVu.addItem(serviceName);
    }
}

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
    int columnCount = tbNguoiDung.getColumnModel().getColumnCount();
    if (index < 0 || index >= tbNguoiDung.getRowCount()) {
        System.out.println("Invalid row index: " + index);
        return;
    }

    try {
        String ten = tbNguoiDung.getValueAt(index, 3).toString();  
        String sdt = tbNguoiDung.getValueAt(index, 4).toString();  
        String diaChi = tbNguoiDung.getValueAt(index, 5).toString();  
        String ngaySinh = tbNguoiDung.getValueAt(index, 6).toString();  
        String gioiTinh = tbNguoiDung.getValueAt(index, 7).toString();  
        String ngayKham = tbNguoiDung.getValueAt(index, 9).toString(); 
        String thoiGianKham = tbNguoiDung.getValueAt(index, 10).toString();  
        String phiDichVu = tbNguoiDung.getValueAt(index, 13).toString();  
        String tenDichVu = tbNguoiDung.getValueAt(index,11).toString();
        String idBn = tbNguoiDung.getValueAt(index,1).toString();      
        String idBs = tbNguoiDung.getValueAt(index,2).toString();

        // Cập nhật giao diện
        txtTen.setText(ten);
        txtSDT.setText(sdt);
        txtDiaChi.setText(diaChi);
        txtPhiDichVu.setText(phiDichVu);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateNgaySinh = dateFormat.parse(ngaySinh);
            cboNgaySinh.setDate(dateNgaySinh);

            Date dateNgayKham = dateFormat.parse(ngayKham);
            cboNgayKham.setDate(dateNgayKham);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cboThoiGianKham.setSelectedItem(thoiGianKham);
        cboDichVu.setSelectedItem(ten);
        if ("Nam".equals(gioiTinh)) {
            rdNam.setSelected(true);
            rdNu.setSelected(false);
        } else {
            rdNam.setSelected(false);
            rdNu.setSelected(true);
        }

        txtIdBn.setText(idBn);
     
        txtIdBs.setText(idBs);
    } catch (ArrayIndexOutOfBoundsException e) {
        e.printStackTrace();
        System.out.println("Index out of bounds when accessing table data.");
    }
}

 
 
 
 
    public BacSiLichLamViec getFromDt() {
        // Lấy dữ liệu từ các trường nhập liệu
        String ten = txtTen.getText().trim();
        String sdt = txtSDT.getText().trim();
        String diaChi = txtDiaChi.getText().trim();

         // Kiểm tra tính hợp lệ của tên
    if (ten.isEmpty() || ten.length() < 3) {
        JOptionPane.showMessageDialog(this, "Tên phải có ít nhất 3 ký tự.");
        return null;
    }

    // Kiểm tra tính hợp lệ của số điện thoại
    if (!sdt.matches("\\d{10}")) {
        JOptionPane.showMessageDialog(this, "Số điện thoại phải có 10 chữ số.");
        return null;
    }

    // Kiểm tra tính hợp lệ của địa chỉ
    if (diaChi.isEmpty() || diaChi.length() < 5) {
        JOptionPane.showMessageDialog(this, "Địa chỉ không để trống ");
        return null;
    }

        // Lấy chi phí dịch vụ từ JTextField và chuyển đổi thành BigDecimal
        BigDecimal chiPhi = BigDecimal.ZERO;
        String phiDichVuText = txtPhiDichVu.getText().trim();
        if (!phiDichVuText.isEmpty()) {
            try {
                chiPhi = new BigDecimal(phiDichVuText);
            } catch (NumberFormatException e) {
                e.printStackTrace(); // Xử lý lỗi định dạng chi phí nếu có
                JOptionPane.showMessageDialog(null, "Chi phí dịch vụ không hợp lệ. Vui lòng nhập lại.", "Lỗi định dạng", JOptionPane.ERROR_MESSAGE);
                return null; // Trả về null nếu chi phí không hợp lệ
            }
        }

        // Lấy ngày sinh từ JCalendar và chuyển đổi thành java.sql.Date
        Date ngaySinhDate = cboNgaySinh.getDate(); // Giả sử cboNgaySinh là một JCalendar
        java.sql.Date ngaySinh = null;
        if (ngaySinhDate != null) {
            ngaySinh = new java.sql.Date(ngaySinhDate.getTime());
        }

        // Xác định giới tính
        String gioiTinh = rdNam.isSelected() ? "Nam" : "Nữ";

        // Tạo và trả về một đối tượng BacSiLichLamViec với các dữ liệu lấy được
        BacSiLichLamViec bacSiLichLamViec = new BacSiLichLamViec();
        bacSiLichLamViec.setTenBN(ten);
        bacSiLichLamViec.setSdtBN(sdt);
        bacSiLichLamViec.setDiachi(diaChi);
        bacSiLichLamViec.setNgaysinh(ngaySinh);
        bacSiLichLamViec.setGioitinh(gioiTinh);
        bacSiLichLamViec.setChiPhi(chiPhi); // Cập nhật chi phí dịch vụ

        // Lấy ngày hẹn từ JCalendar và giờ hẹn từ JComboBox
        Date ngayHenDate = cboNgayKham.getDate(); // Giả sử cboNgayKham là một JCalendar
        LocalDate ngayHen = null;
        if (ngayHenDate != null) {
            ngayHen = ngayHenDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }

        bacSiLichLamViec.setNgayHen(ngayHen);
        bacSiLichLamViec.setNgayDatLich(LocalDate.now()); // Ngày đặt lịch là ngày hiện tại

        // Xử lý giờ hẹn từ JComboBox
        String gioHen = (String) cboThoiGianKham.getSelectedItem();
        if (gioHen != null && !gioHen.equals("Chọn thời gian khám") && gioHen.contains("-")) {
            gioHen = gioHen.split("-")[0]; // Lấy giờ bắt đầu trước dấu '-'
        } else {
            gioHen = "00:00"; // Hoặc một giá trị mặc định phù hợp
        }

        // Định dạng và phân tích giờ hẹn
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm");
        LocalTime gioHenLocalTime = null;
        try {
            gioHenLocalTime = LocalTime.parse(gioHen, timeFormatter);
        } catch (DateTimeParseException e) {
            e.printStackTrace(); // Xử lý lỗi phân tích giờ hẹn
            gioHenLocalTime = LocalTime.of(0, 0); // Giá trị mặc định nếu phân tích thất bại
        }

        // Thêm thông tin dịch vụ từ JComboBox
        String tenDichVu = (String) cboDichVu.getSelectedItem();
        if (tenDichVu != null && !tenDichVu.equals("Chọn dịch vụ")) {
            bacSiLichLamViec.setTenDV(tenDichVu); // Phương thức cần có trong lớp BacSiLichLamViec
        } else {
            bacSiLichLamViec.setTenDV(""); // Giá trị mặc định nếu không chọn dịch vụ
        }

        bacSiLichLamViec.setGioHen(gioHenLocalTime);

 

        return bacSiLichLamViec;
    }

   
 








 

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtTen = new javax.swing.JTextField();
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
        btXóa = new javax.swing.JButton();
        btResset = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btTimKiem = new javax.swing.JButton();
        btSuaThongTin = new javax.swing.JButton();
        btChonNgayKham = new javax.swing.JButton();
        cboNgaySinh = new de.wannawork.jcalendar.JCalendarComboBox();
        btHuyLichHen = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cboDichVu = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtPhiDichVu = new javax.swing.JTextField();
        btChonDichVu = new javax.swing.JButton();
        btChoThanhToan = new javax.swing.JButton();
        txtIdBn = new javax.swing.JTextField();
        txtIdBs = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtTen.setText(" ");

        txtSDT.setText(" ");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbBacSi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Tên Bác Sĩ", "Ngày làm việc", "Thời gian bắt đầu", "Thời gian kết thúc", "Ca làm việc", "Số lượng bệnh nhân", "TrangThai"
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
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Lịch Hẹn", "ID Bệnh Nhân", "ID Bác  Sĩ", "Tên Bệnh Nhân", "SDT Bệnh Nhân", "Địa chỉ", "Ngày Sinh", "GioiTinh", "Tên Bác Sĩ", "Ngày hẹn", "Giờ hẹn", "Ngày đặt lịch", "Dịch vụ", "Phí Dịch Vụ", "TrangThai"
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

        btXóa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/delete.png"))); // NOI18N
        btXóa.setText("Xóa");
        btXóa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXóaActionPerformed(evt);
            }
        });

        btResset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/refresh.png"))); // NOI18N
        btResset.setText("Reset");
        btResset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRessetActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(102, 204, 255));
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
        btSuaThongTin.setText("Cập Nhập");
        btSuaThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaThongTinActionPerformed(evt);
            }
        });

        btChonNgayKham.setText("Chọn Ngày Khám");
        btChonNgayKham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChonNgayKhamActionPerformed(evt);
            }
        });

        btHuyLichHen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/return.png"))); // NOI18N
        btHuyLichHen.setText("Hủy Lịch Hẹn");
        btHuyLichHen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHuyLichHenActionPerformed(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(102, 204, 255));
        jLabel11.setText("Dịch Vụ");

        cboDichVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn Dịch Vụ", "Khám răng", "Lấy cao răng", "Trám răng", "Nhổ răng", "Tẩy trắng răng", "Chỉnh nha", "Cấy ghép implant", "Làm cầu răng", "Niềng răng", "Điều trị tủy", "Tẩy trắng răng" }));
        cboDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDichVuActionPerformed(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(102, 204, 255));
        jLabel12.setText("Phí Dịch Vụ");

        txtPhiDichVu.setText(" ");

        btChonDichVu.setText("Chọn Dịch Vụ");
        btChonDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChonDichVuActionPerformed(evt);
            }
        });

        btChoThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/BILL1.png"))); // NOI18N
        btChoThanhToan.setText("Chờ Thanh Toán");
        btChoThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChoThanhToanActionPerformed(evt);
            }
        });

        txtIdBn.setText(" ");

        txtIdBs.setText(" ");

        jLabel14.setForeground(new java.awt.Color(102, 204, 255));
        jLabel14.setText("Id Benh Nhan");

        jLabel16.setForeground(new java.awt.Color(102, 204, 255));
        jLabel16.setText("Id Bác Sĩ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdNam)
                                .addGap(35, 35, 35)
                                .addComponent(rdNu)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel11))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addComponent(cboNgaySinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cboDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btChonDichVu)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtIdBn, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdBs, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel13))
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
                                        .addComponent(btChonNgayKham, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(32, 32, 32)
                                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btTimKiem))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPhiDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(439, 439, 439)
                        .addComponent(jLabel10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(btXóa, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(btResset, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(btSuaThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(btHuyLichHen, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btChoThanhToan)
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdBn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(cboNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdBs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel16))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cboDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btChonDichVu)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(rdNam)
                            .addComponent(rdNu))))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboThoiGianKham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtPhiDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cboNgayKham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btChonNgayKham)
                        .addComponent(jLabel9)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btTimKiem)))
                .addGap(10, 10, 10)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btXóa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btResset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSuaThongTin)
                    .addComponent(btHuyLichHen)
                    .addComponent(btDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btChoThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbNguoiDungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNguoiDungMouseClicked
    int index = tbNguoiDung.getSelectedRow();
    if (index >= 0) {
        defaultTable(index);
    }
    }//GEN-LAST:event_tbNguoiDungMouseClicked

    private void cboNgayKhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboNgayKhamMouseClicked

    }//GEN-LAST:event_cboNgayKhamMouseClicked

    private void btDatLichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDatLichActionPerformed
  // Lấy dữ liệu từ các trường nhập liệu
    BacSiLichLamViec bacSiLichLamViec = getFromDt();
    
    // Kiểm tra dữ liệu đầu vào hợp lệ
    if (bacSiLichLamViec == null) {
        // Nếu không hợp lệ, dừng thực hiện
        return;
    }
 // Kiểm tra trùng số điện thoại
    if (repoBsllv.isSdtDuplicate(bacSiLichLamViec.getSdtBN())) {
        JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại!");
        return;
    }
    // Thực hiện thêm bệnh nhân vào cơ sở dữ liệu
    long benhNhanID = repoBsllv.addBenhNhan(bacSiLichLamViec);

    if (benhNhanID > 0) {
        // Nếu thêm bệnh nhân thành công, tiếp tục thêm lịch hẹn
        try (Connection conn = DBConnect.getConnect()) {
            String sql = """
                INSERT INTO [dbo].[LichHen]
                           ([BenhNhanID]
                           ,[BacSiID]
                           ,[DichVuID]
                           ,[NgayHen]
                           ,[GioHen]
                           ,[NgayDatLich]
                           ,[TrangThai])
                VALUES
                (?,?,?,?,?,?,?)
                """;

            int bacSiColumnIndex = 0; // Đặt đúng chỉ mục cột chứa ID bác sĩ
            int selectedRowBacSi = tbBacSi.getSelectedRow();
            long bacSiID = 0;
            long dichVuID = 0;

            if (selectedRowBacSi >= 0) {
                bacSiID = Long.parseLong(tbBacSi.getValueAt(selectedRowBacSi, bacSiColumnIndex).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn bác sĩ từ bảng.");
                return;
            }

            // Lấy dịch vụ từ ComboBox
            String selectedDichVu = cboDichVu.getSelectedItem().toString();

            // Liên kết dịch vụ với ID tương ứng trong cơ sở dữ liệu
            switch (selectedDichVu) {
                case "Khám răng":
                    dichVuID = 1;
                    break;
                case "Lấy cao răng":
                    dichVuID = 2;
                    break;
                case "Trám răng":
                    dichVuID = 3;
                    break;
                case "Nhổ răng":
                    dichVuID = 4;
                    break;
                case "Tẩy trắng răng":
                    dichVuID = 5;
                    break;
                case "Chỉnh nha":
                    dichVuID = 6;
                    break;
                case "Cấy ghép implant":
                    dichVuID = 7;
                    break;
                case "Làm cầu răng":
                    dichVuID = 8;
                    break;
                case "Niềng răng":
                    dichVuID = 9;
                    break;
                case "Điều trị tủy":
                    dichVuID = 10;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Dịch vụ không hợp lệ.");
                    return;
            }

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setLong(1, benhNhanID);
                pstmt.setLong(2, bacSiID);
                pstmt.setLong(3, dichVuID);
                pstmt.setDate(4, java.sql.Date.valueOf(bacSiLichLamViec.getNgayHen()));
                pstmt.setTime(5, java.sql.Time.valueOf(bacSiLichLamViec.getGioHen()));
                pstmt.setDate(6, java.sql.Date.valueOf(bacSiLichLamViec.getNgayDatLich()));
                pstmt.setString(7, "Đã Xác Nhận");

                int check = pstmt.executeUpdate();
                if (check > 0) {
                    JOptionPane.showMessageDialog(null, "Đặt lịch thành công!");
                    
                    // Tải lại bảng người dùng
                    listBsLlv = repoBsllv.getAllLichHen();
                    loadTableLH(listBsLlv);
                    
                    // Cuộn bảng đến đầu
                    tbNguoiDung.scrollRectToVisible(tbNguoiDung.getCellRect(0, 0, true));
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Đặt lịch thất bại!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } else {
        JOptionPane.showMessageDialog(null, "Thêm bệnh nhân thất bại!");
    }
    }//GEN-LAST:event_btDatLichActionPerformed

    private void btRessetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRessetActionPerformed
        // Reset tất cả các trường
    txtTen.setText("");
    txtSDT.setText("");
    txtDiaChi.setText("");
    
    // Reset các JComboBox và JDateChooser
    cboThoiGianKham.setSelectedIndex(0); // Đặt lại JComboBox về lựa chọn đầu tiên
    
    // Reset JDateChooser về không có ngày chọn
    cboNgayKham.setDate(null); // Đặt lại JDateChooser về không có ngày chọn

    // Reset trường ngày sinh (JDateChooser)
    cboNgaySinh.setDate(null); // Đặt lại JDateChooser về không có ngày chọn hoặc bạn có thể đặt ngày cụ thể nếu cần
    
    // Reset trường tìm kiếm
    txtTimKiem.setText("Tìm theo tên hoặc số điện thoại");
    
    // Bỏ chọn các dòng trong bảng nếu có
    tbBacSi.clearSelection();
    tbNguoiDung.clearSelection();
   
   //Lịch làm việc
        listBsLlv = repoBsllv.getAllBacSiLichLamViec();
        loadTableBSLLV(listBsLlv);
        
        //Lịch hẹn  
         listBsLlv = repoBsllv.getAllLichHen();
        loadTableLH(listBsLlv);
    }//GEN-LAST:event_btRessetActionPerformed

    private void btTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemActionPerformed
    String searchKeyword = txtTimKiem.getText().trim(); // Lấy từ khóa tìm kiếm từ ô nhập liệu

    if (searchKeyword.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa tìm kiếm.");
        return;
    }

    // Gọi phương thức tìm kiếm trong lớp repository
    List<BacSiLichLamViec> searchResults = repoBsllv.searchByNameOrPhone(searchKeyword);

    // Cập nhật giao diện người dùng với kết quả tìm kiếm
    loadTableLH(searchResults); // Thay loadTableLH thành loadTableBenhNhan
    }//GEN-LAST:event_btTimKiemActionPerformed

    private void btChonNgayKhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChonNgayKhamActionPerformed
      // Lấy ngày từ JCalendar
    Date selectedDate = cboNgayKham.getDate();
    if (selectedDate == null) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày khám.");
        return;
    }
    
    // Lấy ngày hiện tại và định dạng chỉ để so sánh ngày mà không có thời gian
    Calendar currentCalendar = Calendar.getInstance();
    currentCalendar.set(Calendar.HOUR_OF_DAY, 0);
    currentCalendar.set(Calendar.MINUTE, 0);
    currentCalendar.set(Calendar.SECOND, 0);
    currentCalendar.set(Calendar.MILLISECOND, 0);
    Date currentDate = currentCalendar.getTime();

    // Kiểm tra nếu ngày được chọn là quá khứ
    if (selectedDate.before(currentDate)) {
        JOptionPane.showMessageDialog(this, "Không thể chọn ngày trong quá khứ. Vui lòng chọn ngày khác.");
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
                bacSi.getSoLuongbn(),
                bacSi.getTrangThaiBS()
            });
        }
    }
 
    }//GEN-LAST:event_btChonNgayKhamActionPerformed

    private void cboThoiGianKhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThoiGianKhamActionPerformed
         
    }//GEN-LAST:event_cboThoiGianKhamActionPerformed
 
    private void btSuaThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaThongTinActionPerformed
    int index = tbNguoiDung.getSelectedRow();

        // Kiểm tra xem có hàng nào được chọn không
        if (index >= 0 && index < listBsLlv.size()) {
            long id = listBsLlv.get(index).getIdBenhNhan();

            // Lấy đối tượng BacSiLichLamViec từ dữ liệu nhập vào
            BacSiLichLamViec bn = getFromDt();
           // Kiểm tra dữ liệu đầu vào hợp lệ
        if (bn == null) {
            // Nếu không hợp lệ, dừng thực hiện
            return;
        }

        // Kiểm tra trùng số điện thoại
        if (repoBsllv.isSdtDuplicate(bn.getSdtBN()) && !bn.getSdtBN().equals(listBsLlv.get(index).getSdtBN())) {
            JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại!");
            return;
        }

            // Cập nhật thông tin bệnh nhân
            boolean isUpdated = repoBsllv.updateBenhNhan(id, bn);

            // Cập nhật danh sách và bảng dữ liệu
            listBsLlv = repoBsllv.getAllLichHen();
            loadTableLH(listBsLlv);

            // Xử lý kết quả cập nhật
            if (isUpdated) {
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin thất bại!");
            }
        } else {
            // Thông báo lỗi nếu không có hàng nào được chọn
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để sửa thông tin.");
        }
    }//GEN-LAST:event_btSuaThongTinActionPerformed

    private void btXóaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXóaActionPerformed
    // Lấy chỉ số hàng được chọn từ JTable
    int selectedRow = tbNguoiDung.getSelectedRow();
    
    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn bản ghi để xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Lấy giá trị ID từ cột ID của hàng được chọn
    Long id = (Long) tbNguoiDung.getValueAt(selectedRow, 0); // Giả sử ID nằm ở cột đầu tiên (chỉ số 0)
    
    // Xác nhận trước khi xóa
    int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa bản ghi này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }
    
    // Thực hiện xóa bản ghi trong cơ sở dữ liệu
    boolean result = repoBsllv.deleteLichHen(id);
    
    if (result) {
        JOptionPane.showMessageDialog(this, "Bản ghi đã được xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        // Cập nhật danh sách và bảng dữ liệu
        listBsLlv = repoBsllv.getAllLichHen();
        loadTableLH(listBsLlv);
    } else {
        JOptionPane.showMessageDialog(this, "Xóa bản ghi thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btXóaActionPerformed

    private void btHuyLichHenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHuyLichHenActionPerformed
       // Lấy chỉ số hàng được chọn từ JTable
    int selectedRow = tbNguoiDung.getSelectedRow(); 
    
    if (selectedRow != -1) {
        // Giả sử ID của lịch hẹn nằm ở cột đầu tiên của JTable
        // Thay đổi cột theo cấu trúc bảng của bạn
        long lichHenId = (Long) tbNguoiDung.getValueAt(selectedRow, 0); 
        
        RepoBsLlv repo = new RepoBsLlv();
        
        // Cập nhật trạng thái của lịch hẹn thành "Đã hủy"
        boolean success = repo.updateLichHenStatus(lichHenId, "Đã hủy");
        
        if (success) {
            JOptionPane.showMessageDialog(this, "Lịch hẹn đã được hủy thành công.");
            // Cập nhật danh sách và bảng dữ liệu
            listBsLlv = repo.getAllLichHen(); // Chú ý tên phương thức có thể cần sửa
            loadTableLH(listBsLlv); // Cập nhật bảng dữ liệu
        } else {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi hủy lịch hẹn.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn lịch hẹn để hủy.");
    }
    }//GEN-LAST:event_btHuyLichHenActionPerformed

    private void cboDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDichVuActionPerformed
      
    }//GEN-LAST:event_cboDichVuActionPerformed

    private void btChonDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChonDichVuActionPerformed
 // Lấy chỉ mục của mục được chọn trong JComboBox
    int index = cboDichVu.getSelectedIndex();
    
    // Mảng giá dịch vụ tương ứng với các mục trong JComboBox
    String[] giaDichVu = {
        "500.000 VNĐ",  // Khám răng
        "450.000 VNĐ",  // Lấy cao răng
        "350.000 VNĐ",  // Trám răng
        "600.000 VNĐ",  // Nhổ răng
        "700.000 VNĐ",  // Tẩy trắng răng
        "800.000 VNĐ",  // Chỉnh nha
        "1.200.000 VNĐ",// Cấy ghép implant
        "1.100.000 VNĐ",// Làm cầu răng
        "900.000 VNĐ",  // Niềng răng
        "600.000 VNĐ"   // Điều trị tủy
    };
    
    // Kiểm tra chỉ mục hợp lệ
    if (index >= 0 && index < giaDichVu.length) {
        // Lấy giá dịch vụ và loại bỏ các ký tự không cần thiết
        String gia = giaDichVu[index].replace(".", "").replace(" VNĐ", "");
        txtPhiDichVu.setText(gia);
    } else {
        // Nếu chỉ mục không hợp lệ, xóa nội dung JTextField
        txtPhiDichVu.setText("");
    }
    }//GEN-LAST:event_btChonDichVuActionPerformed

    private void btHuyBacSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHuyBacSiActionPerformed
        // Bỏ chọn dòng hiện tại trong JTable
        tbBacSi.clearSelection();

        // Thông báo cho người dùng
        JOptionPane.showMessageDialog(this, "Đã hủy lựa chọn.");

    }//GEN-LAST:event_btHuyBacSiActionPerformed

    private void btChonBacSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChonBacSiActionPerformed
      int selectedRow = tbBacSi.getSelectedRow();

    if (selectedRow >= 0 && selectedRow < listBsLlv.size()) { // Kiểm tra chỉ số hợp lệ
        BacSiLichLamViec selectedDoctor = listBsLlv.get(selectedRow);

        // Kiểm tra nếu bác sĩ đã đủ số lượng bệnh nhân
        if (selectedDoctor.getSoLuongbn() >= 3) {
            // Hiển thị thông báo nếu bác sĩ đã đủ số lượng bệnh nhân
            JOptionPane.showMessageDialog(this, "Bác sĩ " + selectedDoctor.getTenBacSi() + " đã đủ số lượng bệnh nhân trong ca làm việc này. Vui lòng chọn bác sĩ khác.");
        } else {
            // Hiển thị thông báo với tên của bác sĩ được chọn
            JOptionPane.showMessageDialog(this, "Bác sĩ được chọn: " + selectedDoctor.getTenBacSi());

            // Thực hiện các hành động khác với bác sĩ được chọn, ví dụ:
            // - Hiển thị thông tin chi tiết của bác sĩ trong các trường văn bản
            // - Lưu bác sĩ được chọn vào biến để sử dụng sau này
            // - ...
        }
    } else {
        // Nếu không có hàng nào được chọn hoặc chỉ số không hợp lệ, hiển thị thông báo
        JOptionPane.showMessageDialog(this, "Vui lòng chọn một bác sĩ từ bảng.");
    }
    }//GEN-LAST:event_btChonBacSiActionPerformed

    private void tbBacSiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBacSiMouseClicked
        int selectedRow = tbBacSi.getSelectedRow();

    }//GEN-LAST:event_tbBacSiMouseClicked
 
    
    private void btChoThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChoThanhToanActionPerformed
        int selectedRow = tbNguoiDung.getSelectedRow(); // Giả sử tbLichHen là bảng hiển thị lịch hẹn

    if (selectedRow >= 0) {
        // Lấy thông tin từ hàng được chọn
        long benhNhanID = (Long) tbNguoiDung.getValueAt(selectedRow, 1); // Giả sử BenhNhanID ở cột 1
        long bacSiID = (Long) tbNguoiDung.getValueAt(selectedRow, 2); // Giả sử BacSiID ở cột 2
        String tenKhachHang = (String) tbNguoiDung.getValueAt(selectedRow, 3); // Giả sử TenKhachHang ở cột 3
        String diaChi = (String) tbNguoiDung.getValueAt(selectedRow, 5); // Giả sử DiaChi ở cột 4
        String soDienThoai = (String) tbNguoiDung.getValueAt(selectedRow, 4); // Giả sử SoDienThoai ở cột 5
  
        // Tạo hóa đơn chờ
        boolean isCreated = repoBsllv.addHoaDon(benhNhanID, bacSiID, tenKhachHang, diaChi, soDienThoai, "Chờ thanh toán");

        if (isCreated) {
            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(this, "Hóa đơn đã được tạo và chuyển sang trạng thái chờ thanh toán.");
            
            // Cập nhật lại bảng hiển thị lịch hẹn nếu cần
            // loadLichHenData(); // Giả sử loadLichHenData() là phương thức để tải lại dữ liệu bảng
        } else {
            // Hiển thị thông báo lỗi
            JOptionPane.showMessageDialog(this, "Lỗi khi tạo hóa đơn.");
        }
    } else {
        // Nếu không có hàng nào được chọn, hiển thị thông báo
        JOptionPane.showMessageDialog(this, "Vui lòng chọn một lịch hẹn từ bảng.");
    }
    }//GEN-LAST:event_btChoThanhToanActionPerformed

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
    private javax.swing.JButton btChoThanhToan;
    private javax.swing.JButton btChonBacSi;
    private javax.swing.JButton btChonDichVu;
    private javax.swing.JButton btChonNgayKham;
    private javax.swing.JButton btDatLich;
    private javax.swing.JButton btHuyBacSi;
    private javax.swing.JButton btHuyLichHen;
    private javax.swing.JButton btResset;
    private javax.swing.JButton btSuaThongTin;
    private javax.swing.JButton btTimKiem;
    private javax.swing.JButton btXóa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboDichVu;
    private de.wannawork.jcalendar.JCalendarComboBox cboNgayKham;
    private de.wannawork.jcalendar.JCalendarComboBox cboNgaySinh;
    private javax.swing.JComboBox<String> cboThoiGianKham;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JTextField txtIdBn;
    private javax.swing.JTextField txtIdBs;
    private javax.swing.JTextField txtPhiDichVu;
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
