/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ThanhToan1;


import com.poly.ph49571.ModeChiTietHoaDon;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author manh9
 */
public class TT extends javax.swing.JFrame {
 
     private List<ThanhToan> listTT = new ArrayList<>();
     private Repo_ThanhToan repo = new Repo_ThanhToan();
     private DefaultTableModel dtm = new DefaultTableModel();
    public TT() {
        initComponents();
        listTT = repo.getAllDichVu();
        loadTableDv(listTT);
        
      listTT = repo.getAllBn();
      loadTableBn(listTT);
      
         DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        cboNgayThanhToan7.setDateFormat(dateFormat);
        cboNgayTao.setDateFormat(dateFormat);
        
        rdTienMat = new javax.swing.JRadioButton();
        rdTienMat.setText("Tiền mặt");
    
      // Gọi hàm lắng nghe sự thay đổi của tiền khách đưa
        setupTienKhachDuaListener();
    }   
//Dịch vụ
    public void loadTableDv(List<ThanhToan> list){
       DefaultTableModel dtm = (DefaultTableModel) this.tbl_dichVu.getModel();
       dtm.setRowCount(0);
       for (ThanhToan tt : list) {
           dtm.addRow(tt.rowdtDv());
       }
   }
    
    //Hóa đơn bn
     public void loadTableBn(List<ThanhToan> list){
       DefaultTableModel dtm = (DefaultTableModel) this.tbl_benhNhan.getModel();
       dtm.setRowCount(0);
       for (ThanhToan tt : list) {
           dtm.addRow(tt.rowdtHd());
       }
   }
     
     private void loadDichVuDDTable(List<ThanhToan> danhSachDichVu) {
    DefaultTableModel model = (DefaultTableModel) tbl_goiDaChon.getModel();
    model.setRowCount(0); // Xóa tất cả các dòng hiện tại

    for (ThanhToan dichVu : danhSachDichVu) {
        Object[] row = {
            dichVu.getIdDv(),
            dichVu.getTen(),
            dichVu.getMotaDv(),
            dichVu.getChiPhiDv(),
            dichVu.getSoLuong(),
            dichVu.getDonVitinhDv(),
            dichVu.getChiPhiDv(),
            
          
        };
        model.addRow(row);
    }
}
     
public Object[] getRowDataDv(int rowIndex) {
    return new Object[]{
        tbl_dichVu.getValueAt(rowIndex, 0), // idDv
        tbl_dichVu.getValueAt(rowIndex, 1), // tenDv
        tbl_dichVu.getValueAt(rowIndex, 2), // motaDv
        tbl_dichVu.getValueAt(rowIndex, 3), // chiPhiDv
        tbl_dichVu.getValueAt(rowIndex, 4), // soLuong
        tbl_dichVu.getValueAt(rowIndex, 5), // donVitinhDv
        tbl_dichVu.getValueAt(rowIndex, 6), // trangThaiDv
    };
}

public Object[] getRowDataHd(int rowIndex) {
    return new Object[]{
        tbl_benhNhan.getValueAt(rowIndex, 0), // idHd
        tbl_benhNhan.getValueAt(rowIndex, 1), // idBn
        tbl_benhNhan.getValueAt(rowIndex, 2), // idBS
        tbl_benhNhan.getValueAt(rowIndex, 3), // tenKhachHang
        tbl_benhNhan.getValueAt(rowIndex, 4), // DiaChi
        tbl_benhNhan.getValueAt(rowIndex, 5), // soDienThoai
        tbl_benhNhan.getValueAt(rowIndex, 6), // trangThai
    };
}

public Object[] getRowDataDvdd(int rowIndex) {
    return new Object[]{
        tbl_goiDaChon.getValueAt(rowIndex, 0), // idDv
        tbl_goiDaChon.getValueAt(rowIndex, 1), // tenDv
        tbl_goiDaChon.getValueAt(rowIndex, 2), // motaDv
        tbl_goiDaChon.getValueAt(rowIndex, 3), // chiPhiDv
        tbl_goiDaChon.getValueAt(rowIndex, 4), // donVitinhDv
        tbl_goiDaChon.getValueAt(rowIndex, 5), // thanhtien
    };
}

private void setThongTinHoaDonVaChiTiet() {
    // Lấy thông tin hóa đơn từ các trường văn bản
    long benhNhanId = Long.parseLong(txtIdBN.getText());
    long bacSiId = Long.parseLong(txtIdBS.getText());
    long letanId = Long.parseLong(txtIdLT.getText());
    String tenKhachHang = txtTenBn.getText();
    String diaChi = txt_diaChi1.getText();
    String soDienThoai = txt_sdt1.getText();
    String phuongThucTT = rdTienMat.isSelected() ? "Tiền mặt" : "Chuyển khoản"; // Sử dụng radio button
    BigDecimal tienKhDua = new BigDecimal(txt_tienKhachDua.getText());
    BigDecimal tienThua = new BigDecimal(txt_tienThua.getText());
    BigDecimal thanhTien = new BigDecimal(txt_thanhTien.getText());
    String trangThai = cboTrangThaiHoaDon.getSelectedItem().toString(); // Sử dụng JComboBox

    // Tạo đối tượng hóa đơn
    ThanhToan hoaDon = new ThanhToan();
    hoaDon.setBenhnhanid(benhNhanId);
    hoaDon.setBacSiId(bacSiId);
    hoaDon.setLeTanID(letanId);
    hoaDon.setTenKhachHang(tenKhachHang);
    hoaDon.setDiaChi(diaChi);
    hoaDon.setSoDienThoai(soDienThoai);
    hoaDon.setPhuongThucTT(phuongThucTT);
    hoaDon.setTienKhDua(tienKhDua);
    hoaDon.setTienThua(tienThua);
    hoaDon.setThanhtien(thanhTien);
    hoaDon.setTrangThai(trangThai);

    // Lấy thông tin chi tiết hóa đơn từ các trường văn bản
    long dichVuId = Long.parseLong(txtIdDichVu.getText());
    String tenDichVu = txt_tenDV3.getText();
    String moTa = txt_moTa3.getText();
    BigDecimal donGia = new BigDecimal(txt_donGia.getText());
    int soLuong = Integer.parseInt(txt_soLuong.getText());
    String donViTinh = txt_donViTinh3.getText();
    BigDecimal thanhTienChiTiet = donGia.multiply(BigDecimal.valueOf(soLuong)); // Tính tổng tiền chi tiết
    String trangThaiChiTiet = cboTrangThaiHoaDon.getSelectedItem().toString();

    // Tạo đối tượng chi tiết hóa đơn
    ThanhToan chiTiet = new ThanhToan();
    chiTiet.setIdDv(dichVuId);
    chiTiet.setTendichvu(tenDichVu);
    chiTiet.setMotaDv(moTa);
    chiTiet.setDongia(donGia);
    chiTiet.setSoLuong(soLuong);
    chiTiet.setDonvitinh(donViTinh);
    chiTiet.setThanhtien(thanhTienChiTiet);
    chiTiet.setTrangThai(trangThaiChiTiet);

    // Có thể thêm chi tiết vào hóa đơn hoặc xử lý khác nếu cần
    // hoaDon.addChiTiet(chiTiet);
}

 private void setupTienKhachDuaListener() {
        txt_tienKhachDua.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calculateTienThuaAndThanhTien();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calculateTienThuaAndThanhTien();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                calculateTienThuaAndThanhTien();
            }
        });
    }

    private void calculateTienThuaAndThanhTien() {
        try {
            // Lấy số tiền khách đưa từ trường nhập liệu
            float tienKhachDua = Float.parseFloat(txt_tienKhachDua.getText().trim());

            // Tính tổng thành tiền từ bảng dịch vụ đã chọn
            float thanhTien = calculateTotalThanhTien();
            txt_thanhTien.setText(String.valueOf(thanhTien));

            // Tính toán tiền thừa (số tiền khách đưa trừ đi tổng thành tiền)
            float tienThua = tienKhachDua - thanhTien;
            if(tienThua < 0){
                return;
            }
            txt_tienThua.setText(String.valueOf(tienThua));
        } catch (NumberFormatException e) {
            // Xử lý ngoại lệ nếu có lỗi định dạng số
            txt_thanhTien.setText("0.00");
            txt_tienThua.setText("0.00");
        }
    }

    private float calculateTotalThanhTien() {
        float total = 0;
        DefaultTableModel modelGoi = (DefaultTableModel) tbl_goiDaChon.getModel();
        for (int i = 0; i < modelGoi.getRowCount(); i++) {
            float donGia = Float.parseFloat(modelGoi.getValueAt(i, 3).toString());
            int soLuong = Integer.parseInt(modelGoi.getValueAt(i, 4).toString());
            total += donGia * soLuong;
        }
        return total;
    }

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_dichVu = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_benhNhan = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_goiDaChon = new javax.swing.JTable();
        jLabel42 = new javax.swing.JLabel();
        btTimKiem = new javax.swing.JButton();
        txt_timDV = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtIdLT = new javax.swing.JTextField();
        txtIdBS = new javax.swing.JTextField();
        txtIdBN = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt_diaChi1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txt_sdt1 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtTenBn = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        cboNgayTao = new de.wannawork.jcalendar.JCalendarComboBox();
        jPanel9 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txt_soLuong = new javax.swing.JTextField();
        txt_donViTinh3 = new javax.swing.JTextField();
        txt_moTa3 = new javax.swing.JTextField();
        txt_tenDV3 = new javax.swing.JTextField();
        txtIdHoaDon = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIdDichVu = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txt_donGia = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        btn_thanhToan = new javax.swing.JButton();
        btResset = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        cboTrangThaiHoaDon = new javax.swing.JComboBox<>();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        rdTienMat = new javax.swing.JRadioButton();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        txt_tienKhachDua = new javax.swing.JTextField();
        txt_tienThua = new javax.swing.JTextField();
        txt_thanhTien = new javax.swing.JTextField();
        cboNgayThanhToan7 = new de.wannawork.jcalendar.JCalendarComboBox();
        btn_huy = new javax.swing.JButton();
        btChon = new javax.swing.JButton();
        cboTrangThai = new javax.swing.JComboBox<>();
        btXoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 204, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bill.png"))); // NOI18N
        jLabel1.setText("THANH TOÁN");

        tbl_dichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên dịch vụ", "Mô tả", "Chi phí", "SL", "Đơn vị tính", "Chi Phí", "Trạng thái"
            }
        ));
        tbl_dichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dichVuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_dichVu);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Dịch Vụ khám");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Các Gói Đã Chọn");

        tbl_benhNhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Hóa Đơn", "ID Bệnh Nhân", "ID Bác Sĩ", "Tên Bệnh Nhân", "Địa chỉ", "Số Điện thoại", "Trạng Thái "
            }
        ));
        tbl_benhNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_benhNhanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_benhNhan);

        tbl_goiDaChon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Dịch Vụ", "Gói dịch vụ", "Mô tả", "Chi phí", "SL", "Đơn vị tính", "Chi phí"
            }
        ));
        tbl_goiDaChon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_goiDaChonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_goiDaChon);

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel42.setText("Đơn Đợi");

        btTimKiem.setText("Tìm Kiếm Dịch Vụ");
        btTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel18.setText("Mã Lễ Tân");

        jLabel8.setText("Mã Bệnh Nhân");

        jLabel13.setText("Mã Bác Sĩ");

        txtIdLT.setText(" ");

        txtIdBS.setText(" ");

        txtIdBN.setText(" ");

        jLabel15.setText("Tên Bệnh Nhân");

        jLabel23.setText("Địa Chỉ");

        jLabel24.setText("Số Điện Thoại");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel31.setText("Hóa Đơn");

        txtTenBn.setText(" ");

        jLabel25.setText("Ngày tạo");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel31)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdBN)
                                    .addComponent(txtIdBS)
                                    .addComponent(txtIdLT)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_diaChi1)
                                    .addComponent(txtTenBn)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cboNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txt_sdt1))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtIdBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtIdLT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTenBn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txt_diaChi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_sdt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel35.setText("Tên Dịch Vụ");

        jLabel36.setText("Mô Tả");

        jLabel37.setText("Đơn Vị Tính");

        jLabel38.setText("Số Lượng");

        txt_soLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soLuongActionPerformed(evt);
            }
        });

        txt_donViTinh3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_donViTinh3ActionPerformed(evt);
            }
        });

        txt_moTa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_moTa3ActionPerformed(evt);
            }
        });

        txtIdHoaDon.setText(" ");

        jLabel2.setText("Id Hóa Đơn");

        txtIdDichVu.setText(" ");
        txtIdDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdDichVuActionPerformed(evt);
            }
        });

        jLabel33.setText("ID Dịch Vụ");

        jLabel39.setText("Đơn Giá");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel21.setText("Dịch Vụ");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel36)
                            .addGap(40, 40, 40)
                            .addComponent(txt_moTa3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel21))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_tenDV3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addComponent(jLabel33)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtIdDichVu))
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtIdHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel37)
                                    .addComponent(jLabel38))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_donGia, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_donViTinh3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel39))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGap(29, 29, 29)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtIdHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtIdDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(txt_tenDV3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_moTa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_donViTinh3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(txt_donGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        btn_thanhToan.setBackground(new java.awt.Color(102, 255, 204));
        btn_thanhToan.setForeground(new java.awt.Color(60, 63, 65));
        btn_thanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/10.png"))); // NOI18N
        btn_thanhToan.setText("Thanh Toán");
        btn_thanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thanhToanActionPerformed(evt);
            }
        });

        btResset.setBackground(new java.awt.Color(102, 255, 204));
        btResset.setForeground(new java.awt.Color(60, 63, 65));
        btResset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/refresh.png"))); // NOI18N
        btResset.setText("Làm Mới");
        btResset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRessetActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel40.setText("Trạng Thái");

        cboTrangThaiHoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã Thanh Toán", "Chưa Thanh Toán" }));

        jLabel108.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel108.setText("Chỉ Nhận Tiền Mặt");

        jLabel109.setText("Phương thức TT");

        buttonGroup1.add(rdTienMat);
        rdTienMat.setText("Tiền Mặt");

        jLabel110.setText("Tiền Khách Đưa");

        jLabel111.setText("Tiền Thừa");

        jLabel112.setText("Thành Tiền");

        jLabel113.setText("Ngày TT");

        txt_tienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tienKhachDuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel108))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel109)
                                    .addComponent(jLabel110, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel112)
                                    .addComponent(jLabel111)
                                    .addComponent(jLabel40))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(rdTienMat, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_tienKhachDua)
                                            .addComponent(txt_thanhTien)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(txt_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(cboNgayThanhToan7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cboTrangThaiHoaDon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel113)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel108)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel109)
                    .addComponent(rdTienMat))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_tienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel110))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_thanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel112))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel113, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboNgayThanhToan7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTrangThaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addGap(27, 27, 27))
        );

        btn_huy.setBackground(new java.awt.Color(102, 255, 204));
        btn_huy.setForeground(new java.awt.Color(60, 63, 65));
        btn_huy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/11.png"))); // NOI18N
        btn_huy.setText("Hủy");
        btn_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btResset, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_thanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btResset, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_thanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        btChon.setText("Chọn");
        btChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChonActionPerformed(evt);
            }
        });

        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã Thanh Toán", "Chờ Thanh Toán", "Hủy Thanh Toán" }));
        cboTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTrangThaiActionPerformed(evt);
            }
        });

        btXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btXoa.setText("Xóa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_timDV, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btTimKiem)
                        .addGap(38, 38, 38)
                        .addComponent(btChon, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)))
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(585, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_timDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btTimKiem)
                                .addComponent(btChon)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btXoa))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(92, 92, 92)
                    .addComponent(jLabel42)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(539, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_dichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dichVuMouseClicked

    }//GEN-LAST:event_tbl_dichVuMouseClicked

    private void tbl_goiDaChonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_goiDaChonMouseClicked
    int rowIndex = tbl_goiDaChon.getSelectedRow();
    if (rowIndex != -1) {
        Object[] rowData = getRowDataDvdd(rowIndex);
        txtIdDichVu.setText(rowData[0].toString());
        txt_tenDV3.setText(rowData[1].toString());
        txt_moTa3.setText(rowData[2].toString());
        txt_donGia.setText(rowData[3].toString());
        txt_donViTinh3.setText(rowData[5].toString());
        txt_soLuong.setText(rowData[4].toString());
    }
    }//GEN-LAST:event_tbl_goiDaChonMouseClicked

    private void btTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemActionPerformed

    }//GEN-LAST:event_btTimKiemActionPerformed

    private void txtIdDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdDichVuActionPerformed

    }//GEN-LAST:event_txtIdDichVuActionPerformed

    private void txt_moTa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_moTa3ActionPerformed

    }//GEN-LAST:event_txt_moTa3ActionPerformed


    private void btn_thanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thanhToanActionPerformed
      try {
              
        // Tạo đối tượng ThanhToan từ dữ liệu nhập vào
        ThanhToan thanhToan = new ThanhToan();

        // Cập nhật các thông tin của thanhToan từ các trường nhập liệu
        thanhToan.setBenhnhanid(Long.parseLong(txtIdBN.getText().trim()));
        thanhToan.setBacSiId(Long.parseLong(txtIdBS.getText().trim()));
        thanhToan.setLeTanID(Long.parseLong(txtIdLT.getText().trim()));
        thanhToan.setTenKhachHang(txtTenBn.getText().trim());
        thanhToan.setDiaChi(txt_diaChi1.getText().trim());
        thanhToan.setSoDienThoai(txt_sdt1.getText().trim());
        thanhToan.setPhuongThucTT("Tiền mặt");


        // Sử dụng BigDecimal cho các trường số tiền
        thanhToan.setTienKhDua(new BigDecimal(txt_tienKhachDua.getText().trim()));
        thanhToan.setTienThua(new BigDecimal(txt_tienThua.getText().trim()));
        thanhToan.setThanhtien(new BigDecimal(txt_thanhTien.getText().trim()));

        // Lấy dữ liệu từ JCalendar
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        thanhToan.setNgayTaoHd(new java.sql.Date(cboNgayTao.getDate().getTime()));
        thanhToan.setNgaythanhtoan(new java.sql.Date(cboNgayThanhToan7.getDate().getTime()));

        // Lấy dữ liệu từ JComboBox
        thanhToan.setTrangthaiHd(cboTrangThaiHoaDon.getSelectedItem().toString().trim());

        // Thông tin chi tiết hóa đơn
        thanhToan.setIdHoaDon(Long.parseLong(txtIdHoaDon.getText().trim()));
        thanhToan.setIdDv(Long.parseLong(txtIdDichVu.getText().trim()));
        thanhToan.setTenDv(txt_tenDV3.getText().trim());
        thanhToan.setMotaDv(txt_moTa3.getText().trim());
        thanhToan.setDonvitinh(txt_donViTinh3.getText().trim());
        thanhToan.setSoLuong(Integer.parseInt(txt_soLuong.getText().trim()));
        
        
        thanhToan.setDongia(new BigDecimal(txt_donGia.getText().trim()));      
        thanhToan.setThanhtien(new BigDecimal(txt_thanhTien.getText().trim()));

        // Gọi phương thức them để thêm hóa đơn và chi tiết hóa đơn vào cơ sở dữ liệu
        boolean result = repo.them(thanhToan);

        // Hiển thị thông báo kết quả
        if (result) {
            JOptionPane.showMessageDialog(this, "Thanh toán thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Thanh toán thất bại. Vui lòng thử lại.");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Dữ liệu nhập vào không hợp lệ. Vui lòng kiểm tra lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btn_thanhToanActionPerformed

    private void btRessetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRessetActionPerformed
    listTT = repo.getAllBn();
    loadTableBn(listTT);
     
    listTT = repo.getAllDichVu();
    loadTableDv(listTT);
    }//GEN-LAST:event_btRessetActionPerformed

    private void btChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChonActionPerformed
    int selectedRowIndex = tbl_dichVu.getSelectedRow();
    
    if (selectedRowIndex != -1) {
        DefaultTableModel modelDichVu = (DefaultTableModel) tbl_dichVu.getModel();
        Object[] rowData = new Object[modelDichVu.getColumnCount()];
        for (int i = 0; i < modelDichVu.getColumnCount(); i++) {
            rowData[i] = modelDichVu.getValueAt(selectedRowIndex, i);
        }

        DefaultTableModel modelGoi = (DefaultTableModel) tbl_goiDaChon.getModel();
        boolean serviceExists = false;

        for (int i = 0; i < modelGoi.getRowCount(); i++) {
            if (modelGoi.getValueAt(i, 0).equals(rowData[0])) {
                // Dịch vụ đã tồn tại, tăng số lượng
                int currentQuantity = Integer.parseInt(modelGoi.getValueAt(i, 4).toString());
                modelGoi.setValueAt(currentQuantity + 1, i, 4);
                serviceExists = true;
                break;
            }
        }

        if (!serviceExists) {
            // Dịch vụ chưa tồn tại, thêm vào danh sách
            modelGoi.addRow(rowData);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn một dịch vụ từ bảng dịch vụ.");
    }
    }//GEN-LAST:event_btChonActionPerformed

    private void cboTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTrangThaiActionPerformed
     String trangThai = (String) cboTrangThai.getSelectedItem();
    List<ThanhToan> danhSach = new ArrayList<>();

    if (trangThai.equals("Hủy Thanh Toán")) {
        danhSach =  repo.getAllBnByTrangThai("Hủy Thanh Toán");
    } else if (trangThai.equals("Đã Thanh Toán")) {
        danhSach = repo.getAllBnByTrangThai("Đã Thanh Toán");
    }else if (trangThai.equals("Chờ Thanh Toán")) {
        danhSach = repo.getAllBnByTrangThai("Chờ Thanh Toán");
    }

    // Hiển thị danh sách bệnh nhân lên giao diện (table hoặc list)
    // ví dụ:
    loadTableBn(danhSach);
    }//GEN-LAST:event_cboTrangThaiActionPerformed

    private void tbl_benhNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_benhNhanMouseClicked
    int row = tbl_benhNhan.getSelectedRow(); // Lấy chỉ số hàng đã chọn
    if (row >= 0) {
        // Lấy ID bệnh nhân từ cột ID trong bảng
        long benhNhanId = (Long) tbl_benhNhan.getValueAt(row, 0); // Giả sử ID bệnh nhân nằm ở cột 0

        // Gọi phương thức để lấy dịch vụ của bệnh nhân từ cơ sở dữ liệu
        List<ThanhToan> danhSachDichVu = repo.getDichVuByBenhNhanId(benhNhanId);

        
        // Hiển thị danh sách dịch vụ trong một bảng hoặc thành phần giao diện khác
         loadDichVuDDTable(danhSachDichVu);
    } 
    
          int rowIndex = tbl_benhNhan.getSelectedRow();
    if (rowIndex != -1) {
        Object[] rowData = getRowDataHd(rowIndex);
        txtIdHoaDon.setText(rowData[0].toString());
        txtIdBN.setText(rowData[1].toString());
        txtIdBS.setText(rowData[2].toString());
        txtTenBn.setText(rowData[3].toString());
        txt_diaChi1.setText(rowData[4].toString());
        txt_sdt1.setText(rowData[5].toString());
      
    }
    }//GEN-LAST:event_tbl_benhNhanMouseClicked

    private void txt_soLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_soLuongActionPerformed
     int  i = tbl_goiDaChon.getSelectedRow();
        double gia = Double.valueOf(tbl_goiDaChon.getValueAt(i, 3).toString()) * Double.valueOf(txt_soLuong.getText());
        txt_donGia.setText(String.valueOf(gia));
        double gia1 = Double.valueOf(tbl_goiDaChon.getValueAt(i, 3).toString()) * Double.valueOf(txt_soLuong.getText());
        txt_thanhTien.setText(String.valueOf(gia1));
    }//GEN-LAST:event_txt_soLuongActionPerformed

    private void txt_donViTinh3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_donViTinh3ActionPerformed
        
    }//GEN-LAST:event_txt_donViTinh3ActionPerformed

    private void txt_tienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tienKhachDuaActionPerformed
    int   i = tbl_goiDaChon.getSelectedRow();
        double gia = Double.valueOf(tbl_goiDaChon.getValueAt(i, 2).toString()) * Double.valueOf(txt_soLuong.getText());
        txt_donGia.setText(String.valueOf(gia));
        double gia1 = Double.valueOf(tbl_goiDaChon.getValueAt(i, 2).toString()) * Double.valueOf(txt_soLuong.getText());
        txt_thanhTien.setText(String.valueOf(gia1));
   double tienKhachDua = Double.valueOf(txt_tienKhachDua.getText());
        double donGia = Double.valueOf(tbl_goiDaChon.getValueAt(i, 2).toString()) * Double.valueOf(txt_soLuong.getText());
        double tienThua = tienKhachDua - donGia;
        if(tienKhachDua<0){
            tienKhachDua = 0;
            return;
             
        }
        
        txt_tienThua.setText(String.valueOf(tienThua));
    }//GEN-LAST:event_txt_tienKhachDuaActionPerformed

    private void btn_huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyActionPerformed
     
    int selectedRow = tbl_benhNhan.getSelectedRow(); 
    
    if (selectedRow != -1) {
        
        long lichHenId = (Long) tbl_benhNhan.getValueAt(selectedRow, 0); 
        
         
        ThanhToan thanhToan = new ThanhToan();
        thanhToan.setIdHoaDon(lichHenId);  
        thanhToan.setTrangthaiHd("Đã hủy"); 
        
        Repo_ThanhToan repo = new Repo_ThanhToan();
        
         
        boolean success = repo.huyThanhToan(thanhToan);
        
        if (success) {
            JOptionPane.showMessageDialog(this, "Hóa Đơn đã được hủy thành công.");
             
            listTT = repo.getAllBn();  
            loadTableBn(listTT);  
        } else {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi hủy hóa đơn.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn để hủy.");
    }
    }//GEN-LAST:event_btn_huyActionPerformed

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
            java.util.logging.Logger.getLogger(TT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btChon;
    private javax.swing.JButton btResset;
    private javax.swing.JButton btTimKiem;
    private javax.swing.JButton btXoa;
    private javax.swing.JButton btn_huy;
    private javax.swing.JButton btn_thanhToan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private de.wannawork.jcalendar.JCalendarComboBox cboNgayTao;
    private de.wannawork.jcalendar.JCalendarComboBox cboNgayThanhToan7;
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JComboBox<String> cboTrangThaiHoaDon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rdTienMat;
    private javax.swing.JTable tbl_benhNhan;
    private javax.swing.JTable tbl_dichVu;
    private javax.swing.JTable tbl_goiDaChon;
    private javax.swing.JTextField txtIdBN;
    private javax.swing.JTextField txtIdBS;
    private javax.swing.JTextField txtIdDichVu;
    private javax.swing.JTextField txtIdHoaDon;
    private javax.swing.JTextField txtIdLT;
    private javax.swing.JTextField txtTenBn;
    private javax.swing.JTextField txt_diaChi1;
    private javax.swing.JTextField txt_donGia;
    private javax.swing.JTextField txt_donViTinh3;
    private javax.swing.JTextField txt_moTa3;
    private javax.swing.JTextField txt_sdt1;
    private javax.swing.JTextField txt_soLuong;
    private javax.swing.JTextField txt_tenDV3;
    private javax.swing.JTextField txt_thanhTien;
    private javax.swing.JTextField txt_tienKhachDua;
    private javax.swing.JTextField txt_tienThua;
    private javax.swing.JTextField txt_timDV;
    // End of variables declaration//GEN-END:variables

    private int parseInteger(String trim, String id_Bệnh_Nhân) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private float parseFloat(String trim, String tiền_khách_đưa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int parseLong(String trim, String id_Hóa_Đơn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
