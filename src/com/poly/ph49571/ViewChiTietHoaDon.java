/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.poly.ph49571;


import com.poly.entity.ChiTietHoaDon;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.DataFormat;
/**
 *
 * @author ASUS
 */
public class ViewChiTietHoaDon extends javax.swing.JPanel {
   ArrayList<ModeChiTietHoaDon> globalList  = new ArrayList<>();
    DefaultTableModel mode = new DefaultTableModel();
    CTHoaDonServices svcthd = new CTHoaDonServices();
    public ViewChiTietHoaDon() throws SQLException {
        initComponents();
         getdatacthoadon();
//         
        
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        cbongaybatdau.setDateFormat(dateFormat);
        cbongayketthuc.setDateFormat(dateFormat);
    }
     public void getdatacthoadon() throws SQLException {
        globalList  = svcthd.getdata();
        this.displayToTable(svcthd.getdata());

    }

   public void displayToTable(ArrayList<ModeChiTietHoaDon> list) {
    globalList = list;
    DefaultTableModel model = (DefaultTableModel) tbtable.getModel();
    model.setRowCount(0);
    for (ModeChiTietHoaDon cthoadon : list) {
        Object[] row = {
            cthoadon.getMahoadon(),
            cthoadon.getBacSiId(),
            cthoadon.getLeTanID(),
            cthoadon.getBenhnhanid(),
            cthoadon.getTenKhachHang(),
            cthoadon.getDiaChi(),
            cthoadon.getSoDienThoai(),
            cthoadon.getPhuongThucTT(),
            cthoadon.getThanhtien(),
            cthoadon.getNgaytao(),
            cthoadon.getNgaythanhtoan(),
            cthoadon.getTrangThaiText()
        };
        model.addRow(row);
    }
}


    public void displaycontrol(int index) {
        ModeChiTietHoaDon cthd = globalList .get(index);
//        txtemail.setText(Double.toString(cthd.getThanhtien()));
//        if (cthd.getTrangthai().equalsIgnoreCase("Hoàn Thành")) {
//            rdohoanthanh.setSelected(true);
//        }else if (cthd.getTrangthai().equalsIgnoreCase("Chưa toàn thành")) {
//            rdochuahoanthanh.setSelected(true);
//        }
            
    }
//    public void getLoadText() {
//        CTHoaDonServices repo = new CTHoaDonServices();
//        ListText = repo.getAllText();
//    }
            

//    public void showDeTail() {
//        int index = tbtable.getSelectedRow();
//        ModeChiTietHoaDon model = ListText.get(index);
//        txtidbacsi.setText(String.valueOf(model.getBacSiId()));
//        txtletan.setText(String.valueOf(model.getLeTanID()));
//        txttenkhachhang.setText(model.getTenKhachHang());
//        txtdiaachi.setText(model.getDiaChi());
//        txtsdt.setText(model.getSoDienThoai());
//        txtemail.setText(model.getEmail());
//        txtptthanhtoan.setText(String.valueOf(model.getPhuongThucTT()));
//        txttienkhachdua.setText(String.valueOf(model.getTienKhDua()));
//        txtngaytao.setText(String.valueOf(model.getTienThua()));
//        txtthanhtien.setText(String.valueOf(model.getThanhtien()));
////        cbongaythanhtoan.set(model.getNgaythanhtoan());        cbongaythanhtoan.setDate();
//        String ngayThanhToanStr = model.getNgaythanhtoan();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // Định dạng ngày của bạn
//        try {
//            Date ngayThanhToan = sdf.parse(ngayThanhToanStr);
//        cbongaythanhtoan.setDate(ngayThanhToan);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            // Xử lý lỗi nếu ngày không hợp lệ
//        }
//        txtngaythanhtoan.setText(model.getNgaythanhtoan());
//        if (model.getTrangThaiText().equals("Đã thanh toán")) {
//            cbodahoanthanh.setSelected(true);
//        }
//        else {
//            cbochuahoanthanh.setSelected(true);
//        }
//        
//    }
        private void onTableRowSelect() {
        int index = tbtable.getSelectedRow();
        if (index >= 0) {
            // Assuming the ID of the invoice is in the first column (index 0)
            int hoaDonID = (int) tbtable.getValueAt(index, 0); // Adjust column index if necessary

            try {
                // Load data for the selected HoaDonID
                ArrayList<ModeChiTietHoaDon> details = svcthd.getChiTietHoaDonByHoaDonID(hoaDonID);

                // Update tbtable2
                DefaultTableModel detailModel = (DefaultTableModel) tbtable2.getModel();
                detailModel.setRowCount(0);  // Clear the detail table
                
                for (ModeChiTietHoaDon detail : details) {
                    detailModel.addRow(new Object[] {
                        detail.getId(),
                        detail.getMahoadon(),
                        detail.getMadichvu(),
                        detail.getTendichvu(),
                        detail.getMota(),
                        detail.getDonvitinh(),
                        detail.getSoluong(),
                        detail.getDongia(),
                        detail.getThanhtien(),
                    
                        detail.getTrangThaiText()
                    });
                }
            } catch (SQLException ex) {
                System.out.println("Lỗi: " + ex.getMessage());
            }
        } else {
            System.out.println("Chỉ mục ngoài phạm vi hoặc không hợp lệ: " + index);
        }
        }
private void loadtb() throws SQLException {
    DefaultTableModel model = (DefaultTableModel) tbtable.getModel();
    model.setRowCount(0);
    List<ModeChiTietHoaDon> list = svcthd.getdata();
    for (ModeChiTietHoaDon cthoaDon : list) {
        model.addRow(new Object[]{
            cthoaDon.getId(),
            cthoaDon.getMahoadon(),
            cthoaDon.getMadichvu(),
            cthoaDon.getTendichvu(),
            cthoaDon.getMota(),
            cthoaDon.getDonvitinh(),
            cthoaDon.getSoluong(),
            cthoaDon.getDongia(),
            cthoaDon.getThanhtien(),
            cthoaDon.getNgaythanhtoan(),
            cthoaDon.getTrangThaiText()
        });
    }
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtable = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();
        txttimkiem = new javax.swing.JTextField();
        btntimkiem = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbtable2 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cbongaybatdau = new de.wannawork.jcalendar.JCalendarComboBox();
        jPanel4 = new javax.swing.JPanel();
        cbongayketthuc = new de.wannawork.jcalendar.JCalendarComboBox();
        btnloctheongay = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        cbbtrangthai = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Hóa Đơn"));

        tbtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "IDHDon", "IDBSi", "IDLTan", "IDBệnh Nhân", "Tên Bệnh Nhân", "Địa Chỉ", "Số Điện Thoại", "PT ThanhToan", "Thành Tiền", "Ngày Tạo ", "Ngày TT", "Trạng Thái"
            }
        ));
        tbtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbtable);

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/refresh.png"))); // NOI18N
        btnReset.setText("Reset Table");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btntimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search2.png"))); // NOI18N
        btntimkiem.setText("Tìm Kiếm");
        btntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(362, 362, 362)
                .addComponent(btnReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btntimkiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntimkiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi Tiết Hóa Đơn"));

        tbtable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "ID Hóa Đơn", "ID Dịch Vụ", "Tên Dịch Vụ", "Mô Tả", "Đơn Vị Tính", "Số Lượng", "Đơn Giá", "Thành Tiền", "Trạng Thái"
            }
        ));
        tbtable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbtable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 255, 102));
        jLabel11.setText("Hóa Đơn");

        jButton1.setText("Xem Chi Tiết Hóa Đơn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Ngày Bắt Đầu"));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(cbongaybatdau, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(cbongaybatdau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Ngày Kết Thúc"));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(cbongayketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(cbongayketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnloctheongay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/filter-filled-tool-symbol.png"))); // NOI18N
        btnloctheongay.setText("Lọc Theo Ngày");
        btnloctheongay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloctheongayActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc Theo Trạng Thái"));

        cbbtrangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã thanh toán", "Chưa thanh toán" }));
        cbbtrangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbtrangthaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbtrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(cbbtrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel1.setText("Đến");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnloctheongay)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(86, 86, 86)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18)
                        .addComponent(btnloctheongay))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(243, 243, 243)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(536, 536, 536)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtableMouseClicked

    }//GEN-LAST:event_tbtableMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
       try {
           // TODO add your handling code here:
           displayToTable(svcthd.getdata());
       } catch (SQLException ex) {
           Logger.getLogger(ViewChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_btnResetActionPerformed

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
       try {
            String searchText = txttimkiem.getText();
            int id = 0;
            String name = null;
            String phoneNumber = null;

            // Phân tích chuỗi tìm kiếm để xác định ID, tên, hoặc số điện thoại
            try {
                id = Integer.parseInt(searchText);
            } catch (NumberFormatException e) {
                // Nếu không thể phân tích thành số, thử tìm kiếm theo tên hoặc số điện thoại
                if (searchText.contains("@") || searchText.matches(".*\\d{10,}.*")) {
                    phoneNumber = searchText;
                } else {
                    name = searchText;
                }
            }

            globalList = svcthd.tim(id, name, phoneNumber);
            displayToTable(globalList);
            System.out.println("list " + globalList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ViewCTHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btntimkiemActionPerformed

    private void tbtable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtable2MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tbtable2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        onTableRowSelect();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnloctheongayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloctheongayActionPerformed
        // TODO add your handling code here:
    Date startDate = cbongaybatdau.getDate();
    Date endDate = cbongayketthuc.getDate();
    
    // Kiểm tra nếu ngày bắt đầu và ngày kết thúc không null
    if (startDate != null && endDate != null) {
        // Chuyển đổi từ java.util.Date sang java.sql.Date
        java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());

        // Gọi phương thức timTheoNgay để lấy danh sách hóa đơn trong khoảng ngày
        List<ModeChiTietHoaDon> hoaDonList = svcthd.timTheoNgay(sqlStartDate, sqlEndDate);

        // Xử lý danh sách hóa đơn để hiển thị trong bảng hoặc nơi bạn muốn
        DefaultTableModel model = (DefaultTableModel) tbtable.getModel();
        model.setRowCount(0); // Xóa tất cả các dòng hiện tại
        for (ModeChiTietHoaDon hoaDon : hoaDonList) {
            Object[] row = {
                hoaDon.getMahoadon(),
                hoaDon.getBacSiId(),
                hoaDon.getLeTanID(),
                hoaDon.getBenhnhanid(),
                hoaDon.getTenKhachHang(),
                hoaDon.getDiaChi(),
                hoaDon.getSoDienThoai(),               
                hoaDon.getPhuongThucTT(),
                hoaDon.getThanhtien(),
                hoaDon.getNgaytao(),
                hoaDon.getNgaythanhtoan(),
                hoaDon.getTrangThaiText(),
                hoaDon.getTendichvu(),
                hoaDon.getMota(),
                hoaDon.getDonvitinh(),
                hoaDon.getDongia(),
                hoaDon.getSoluong(),
                hoaDon.getThanhtienchitiet()
            };
            model.addRow(row);
        }
    } else {
        // Thông báo lỗi nếu ngày bắt đầu hoặc ngày kết thúc null
        JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày bắt đầu và ngày kết thúc hợp lệ.");
    }           
    }//GEN-LAST:event_btnloctheongayActionPerformed

    private void cbbtrangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbtrangthaiActionPerformed
       try {
            // TODO add your handling code here:
            String trangthai  = cbbtrangthai.getSelectedItem().toString();
            String trangthaivalue = null;
            if (trangthai.equals("Đã thanh toán")) {
                trangthaivalue = "Đã thanh toán";
            }else if(trangthai.equals("Chờ thanh toán")){
                trangthaivalue = "Chờ thanh toán";
            }
            displayToTable(svcthd.timtrangthai(trangthaivalue));
        } catch (SQLException ex) {
            Logger.getLogger(ViewCTHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbbtrangthaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnloctheongay;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JComboBox<String> cbbtrangthai;
    private de.wannawork.jcalendar.JCalendarComboBox cbongaybatdau;
    private de.wannawork.jcalendar.JCalendarComboBox cbongayketthuc;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbtable;
    private javax.swing.JTable tbtable2;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}
