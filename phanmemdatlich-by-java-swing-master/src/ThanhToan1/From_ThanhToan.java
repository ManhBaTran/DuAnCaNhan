/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ThanhToan1;

 
import com.poly.repository.RepoBsLlv;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author manh9
 */
public class From_ThanhToan extends javax.swing.JPanel {
     private List<ThanhToan> listTT = new ArrayList<>();
      private Repo_ThanhToan repo = new Repo_ThanhToan();
     private DefaultTableModel dtm = new DefaultTableModel();
     
    public From_ThanhToan() {
        initComponents();
          listTT = repo.getAllDichVu();
        loadTableDv(listTT);
        
      listTT = repo.getAllBn();
      loadTableBn(listTT);
      
         DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        cboNgayThanhToan7.setDateFormat(dateFormat);
        cboNgayTao.setDateFormat(dateFormat);
        
        rdTienMat7 = new javax.swing.JRadioButton();
        rdTienMat7.setText("Tiền mặt");
    
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
    String phuongThucTT = rdTienMat7.isSelected() ? "Tiền mặt" : "Chuyển khoản"; // Sử dụng radio button
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
    int soLuong = Integer.parseInt(txt_soLuong3.getText());
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

        // Tính thành tiền cho dịch vụ được chọn hoặc dịch vụ mới nhất
        float thanhTien = calculateSingleServiceThanhTien();
        txt_thanhTien.setText(String.valueOf(thanhTien));

        // Tính toán tiền thừa (số tiền khách đưa trừ đi thành tiền của dịch vụ)
        float tienThua = tienKhachDua - thanhTien;
        txt_tienThua.setText(String.valueOf(tienThua));
    } catch (NumberFormatException e) {
        // Xử lý ngoại lệ nếu có lỗi định dạng số
        txt_thanhTien.setText("0.00");
        txt_tienThua.setText("0.00");
    }
}

private float calculateSingleServiceThanhTien() {
    DefaultTableModel modelGoi = (DefaultTableModel) tbl_goiDaChon.getModel();
    int selectedRow = tbl_goiDaChon.getSelectedRow();

    // Nếu không có dòng nào được chọn, chọn dịch vụ cuối cùng trong bảng
    if (selectedRow == -1) {
        selectedRow = modelGoi.getRowCount() - 1;
    }

    if (selectedRow >= 0) {
        float donGia = Float.parseFloat(modelGoi.getValueAt(selectedRow, 3).toString());
        int soLuong = Integer.parseInt(modelGoi.getValueAt(selectedRow, 4).toString());
        return donGia * soLuong;
    }
    return 0;
}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_benhNhan = new javax.swing.JTable();
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
        txt_soLuong3 = new javax.swing.JTextField();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        cboTrangThaiHoaDon = new javax.swing.JComboBox<>();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        rdTienMat7 = new javax.swing.JRadioButton();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        txt_tienKhachDua = new javax.swing.JTextField();
        txt_tienThua = new javax.swing.JTextField();
        txt_thanhTien = new javax.swing.JTextField();
        cboNgayThanhToan7 = new de.wannawork.jcalendar.JCalendarComboBox();
        btResset = new javax.swing.JButton();
        btn_thanhToan = new javax.swing.JButton();
        btn_huy = new javax.swing.JButton();
        cboTrangThai = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btChon = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_goiDaChon = new javax.swing.JTable();
        btTimKiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_dichVu = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 204, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bill.png"))); // NOI18N
        jLabel1.setText("THANH TOÁN");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel42.setText("Đơn Đợi");

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
                                .addGap(0, 15, Short.MAX_VALUE))
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
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel35.setText("Tên Dịch Vụ");

        jLabel36.setText("Mô Tả");

        jLabel37.setText("Đơn Vị Tính");

        jLabel38.setText("Số Lượng");

        txt_soLuong3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soLuong3ActionPerformed(evt);
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
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(40, 40, 40)
                                .addComponent(txt_moTa3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
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
                                    .addComponent(txt_soLuong3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_donGia, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_donViTinh3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel39)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel21)))
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
                    .addComponent(txt_soLuong3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(txt_donGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel40.setText("Trạng Thái");

        cboTrangThaiHoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã Thanh Toán", "Chưa Thanh Toán" }));

        jLabel108.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel108.setText("Chỉ Nhận Tiền Mặt");

        jLabel109.setText("Phương thức TT");

        rdTienMat7.setText("Tiền Mặt");

        jLabel110.setText("Tiền Khách Đưa");

        jLabel111.setText("Tiền Thừa");

        jLabel112.setText("Thành Tiền");

        jLabel113.setText("Ngày TT");

        txt_tienThua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tienThuaActionPerformed(evt);
            }
        });

        txt_thanhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_thanhTienActionPerformed(evt);
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

        btn_thanhToan.setBackground(new java.awt.Color(102, 255, 204));
        btn_thanhToan.setForeground(new java.awt.Color(60, 63, 65));
        btn_thanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/10.png"))); // NOI18N
        btn_thanhToan.setText("Thanh Toán");
        btn_thanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thanhToanActionPerformed(evt);
            }
        });

        btn_huy.setBackground(new java.awt.Color(102, 255, 204));
        btn_huy.setForeground(new java.awt.Color(60, 63, 65));
        btn_huy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/11.png"))); // NOI18N
        btn_huy.setText("Hủy");
        btn_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel108)
                .addGap(191, 191, 191))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btResset, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btn_thanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel109, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel110, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel112)
                            .addComponent(jLabel111)
                            .addComponent(jLabel40)
                            .addComponent(jLabel113))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboNgayThanhToan7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_tienKhachDua)
                            .addComponent(txt_thanhTien)
                            .addComponent(cboTrangThaiHoaDon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdTienMat7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(27, 27, 27))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel108)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdTienMat7)
                                    .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_tienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel110))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_thanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel112))
                        .addGap(17, 17, 17)
                        .addComponent(cboNgayThanhToan7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel113))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addComponent(cboTrangThaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btResset, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_thanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã Thanh Toán", "Chờ Thanh Toán", "Đã Hủy" }));
        cboTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTrangThaiActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Các Gói Đã Chọn");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Dịch Vụ khám");

        btChon.setText("Chọn");
        btChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChonActionPerformed(evt);
            }
        });

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

        btTimKiem.setText("Tìm Kiếm Dịch Vụ");
        btTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addComponent(jLabel19)
                                    .addGap(87, 87, 87)
                                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btTimKiem)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                    .addComponent(btChon, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(473, 473, 473)
                        .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btTimKiem)
                                .addComponent(btChon))
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdDichVuActionPerformed

    }//GEN-LAST:event_txtIdDichVuActionPerformed

    private void txt_moTa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_moTa3ActionPerformed

    }//GEN-LAST:event_txt_moTa3ActionPerformed

    private void txt_donViTinh3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_donViTinh3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_donViTinh3ActionPerformed

    private void txt_soLuong3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_soLuong3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_soLuong3ActionPerformed

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

    private void cboTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTrangThaiActionPerformed
          String trangThai = (String) cboTrangThai.getSelectedItem();
    List<ThanhToan> danhSach = new ArrayList<>();

    if (trangThai.equals("Đã Hủy")) {
        danhSach =  repo.getAllBnByTrangThai("Đã Hủy");
    } else if (trangThai.equals("Đã Thanh Toán")) {
        danhSach = repo.getAllBnByTrangThai("Đã Thanh Toán");
    }else if (trangThai.equals("Chờ Thanh Toán")) {
        danhSach = repo.getAllBnByTrangThai("Chờ Thanh Toán");
    }

    // Hiển thị danh sách bệnh nhân lên giao diện (table hoặc list)
    // ví dụ:
    loadTableBn(danhSach);
    }//GEN-LAST:event_cboTrangThaiActionPerformed

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

    private void tbl_goiDaChonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_goiDaChonMouseClicked
        int rowIndex = tbl_goiDaChon.getSelectedRow();
        if (rowIndex != -1) {
            Object[] rowData = getRowDataDvdd(rowIndex);
            txtIdDichVu.setText(rowData[0].toString());
            txt_tenDV3.setText(rowData[1].toString());
            txt_moTa3.setText(rowData[2].toString());
            txt_donGia.setText(rowData[3].toString());
            txt_donViTinh3.setText(rowData[5].toString());
            txt_soLuong3.setText(rowData[4].toString());
        }
    }//GEN-LAST:event_tbl_goiDaChonMouseClicked

    private void btTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemActionPerformed
 
    String keyword = txtTimKiem.getText().trim();

    // Gọi hàm tìm kiếm với từ khóa
    List<ThanhToan> results = repo.searchDichVu(keyword);

    // Xóa các kết quả cũ trong bảng
    DefaultTableModel model = (DefaultTableModel) tbl_dichVu.getModel();
    model.setRowCount(0);

    // Thêm các kết quả tìm kiếm vào bảng
    for (ThanhToan dichVu : results) {
        model.addRow(new Object[]{
            dichVu.getIdDv(),
            dichVu.getTenDv(),
            dichVu.getMotaDv(),
            dichVu.getChiPhiDv(),
            dichVu.getSoLuong(),
            dichVu.getDonVitinhDv(),
            dichVu.getChiPhiDv(),
            dichVu.getTrangThaiDv()
        });
    }

    // Hiển thị thông báo nếu không tìm thấy kết quả
    if (results.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Không tìm thấy dịch vụ với từ khóa \"" + keyword + "\".", "Kết quả tìm kiếm", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_btTimKiemActionPerformed

    private void tbl_dichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dichVuMouseClicked

    }//GEN-LAST:event_tbl_dichVuMouseClicked

    private void btRessetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRessetActionPerformed
        listTT = repo.getAllBn();
        loadTableBn(listTT);

        listTT = repo.getAllDichVu();
        loadTableDv(listTT);
    }//GEN-LAST:event_btRessetActionPerformed

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
        BigDecimal tienKhDua = new BigDecimal(txt_tienKhachDua.getText().trim());
        BigDecimal thanhTien = new BigDecimal(txt_thanhTien.getText().trim());

        // Kiểm tra số tiền khách đưa phải lớn hơn 0 và đủ để thanh toán
        if (tienKhDua.compareTo(BigDecimal.ZERO) <= 0) {
            JOptionPane.showMessageDialog(this, "Số tiền khách đưa phải lớn hơn 0.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (thanhTien.compareTo(BigDecimal.ZERO) <= 0) {
            JOptionPane.showMessageDialog(this, "Số tiền thanh toán phải lớn hơn 0.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (tienKhDua.compareTo(thanhTien) < 0) {
            JOptionPane.showMessageDialog(this, "Số tiền khách đưa không đủ để thanh toán.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        thanhToan.setTienKhDua(tienKhDua);
        thanhToan.setTienThua(tienKhDua.subtract(thanhTien)); // Tính tiền thừa
        thanhToan.setThanhtien(thanhTien);

        // Lấy dữ liệu từ JCalendar
        if (cboNgayTao.getDate() == null || cboNgayThanhToan7.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Ngày tạo và ngày thanh toán không được để trống.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

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
        thanhToan.setSoLuong(Integer.parseInt(txt_soLuong3.getText().trim()));
        thanhToan.setDongia(new BigDecimal(txt_donGia.getText().trim()));
        thanhToan.setThanhtien(thanhTien);  // Không cần thiết phải lặp lại

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
    } catch (NullPointerException e) {
        JOptionPane.showMessageDialog(this, "Có lỗi xảy ra. Vui lòng kiểm tra lại các trường nhập liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btn_thanhToanActionPerformed

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

    private void txt_tienThuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tienThuaActionPerformed
     
    }//GEN-LAST:event_txt_tienThuaActionPerformed

    private void txt_thanhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_thanhTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_thanhTienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btChon;
    private javax.swing.JButton btResset;
    private javax.swing.JButton btTimKiem;
    private javax.swing.JButton btn_huy;
    private javax.swing.JButton btn_thanhToan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
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
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rdTienMat7;
    private javax.swing.JTable tbl_benhNhan;
    private javax.swing.JTable tbl_dichVu;
    private javax.swing.JTable tbl_goiDaChon;
    private javax.swing.JTextField txtIdBN;
    private javax.swing.JTextField txtIdBS;
    private javax.swing.JTextField txtIdDichVu;
    private javax.swing.JTextField txtIdHoaDon;
    private javax.swing.JTextField txtIdLT;
    private javax.swing.JTextField txtTenBn;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txt_diaChi1;
    private javax.swing.JTextField txt_donGia;
    private javax.swing.JTextField txt_donViTinh3;
    private javax.swing.JTextField txt_moTa3;
    private javax.swing.JTextField txt_sdt1;
    private javax.swing.JTextField txt_soLuong3;
    private javax.swing.JTextField txt_tenDV3;
    private javax.swing.JTextField txt_thanhTien;
    private javax.swing.JTextField txt_tienKhachDua;
    private javax.swing.JTextField txt_tienThua;
    // End of variables declaration//GEN-END:variables

    private boolean deleteInvoiceById(long idHoaDon) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
