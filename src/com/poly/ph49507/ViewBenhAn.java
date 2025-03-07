/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.poly.ph49507;

import com.formdev.flatlaf.json.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class ViewBenhAn extends javax.swing.JFrame {
     private Repositories rp1 = new Repositories();
    private ReposBenhAn rp = new ReposBenhAn();
    private DefaultTableModel mol = new DefaultTableModel();
    private DefaultTableModel mol1 = new DefaultTableModel();
    private int i = -1;
    private String trangthai;

     

    /**
     * Creates new form ViewBenhAn
     */
    public ViewBenhAn() {
        initComponents();
        setLocationRelativeTo(null);
        fillToTable(rp.getall());
        filltoTable1(rp1.getall());
    }

    
      
    void filltoTable1(ArrayList<Model_BenhNhan> list){
        mol1 = (DefaultTableModel)tbl_benhnhan.getModel();
        mol1.setRowCount(0);
        for (Model_BenhNhan model_BenhNhan : list) {
            mol1.addRow(model_BenhNhan.todatarow());
        }
    }
    void fillToTable(ArrayList<BenhAn> list) {
        mol = (DefaultTableModel) tbl_benhan.getModel();
        mol.setRowCount(0);
        for (BenhAn benhAn : list) {
            mol.addRow(benhAn.todatarow());
        }
    }
    void showData(int i) {
    // Kiểm tra giá trị null trước khi sử dụng .toString()
    Object idValue = tbl_benhan.getValueAt(i, 0);
    Object benhNhanValue = tbl_benhan.getValueAt(i, 1);
    Object bacSiValue = tbl_benhan.getValueAt(i, 2);
    Object chanDoanValue = tbl_benhan.getValueAt(i, 3);
    Object dieuTriValue = tbl_benhan.getValueAt(i, 4);
    Object ngayKhamValue = tbl_benhan.getValueAt(i, 5);
    Object ngayLapBenhAnValue = tbl_benhan.getValueAt(i, 6);
    Object moTaValue = tbl_benhan.getValueAt(i, 7);
    Object trangThaiValue = tbl_benhan.getValueAt(i, 8);  // Giả sử cột này chứa trạng thái
    
    txt_id.setText(idValue != null ? idValue.toString() : "");
    txt_benhnhan.setText(benhNhanValue != null ? benhNhanValue.toString() : "");
    txt_bacsi.setText(bacSiValue != null ? bacSiValue.toString() : "");
    txt_chandoan.setText(chanDoanValue != null ? chanDoanValue.toString() : "");
    txt_dieutri.setText(dieuTriValue != null ? dieuTriValue.toString() : "");
    txt_ngaykham.setText(ngayKhamValue != null ? ngayKhamValue.toString() : "");
    txt_ngaylapbenhan.setText(ngayLapBenhAnValue != null ? ngayLapBenhAnValue.toString() : "");
    txt_mota.setText(moTaValue != null ? moTaValue.toString() : "");

    // Kiểm tra và gán giá trị cho radio button
    String trangthai = trangThaiValue != null ? trangThaiValue.toString() : "";
    if (trangthai.equalsIgnoreCase("Hoàn Thành")) {
        rdo_ht.setSelected(true);
    } else {
        rdo_kht.setSelected(true);
    }
}


     BenhAn readform() throws java.text.ParseException {
        int id;
        int mabenhnhan;
        int mabacsi;
        String chandoan;
        String dieutri;
        String ngaykham;
        String ngaylapbenhan;
        String mota;
        String trangthai;

        // Kiểm tra ID
        try {
            id = Integer.parseInt(txt_id.getText());
            if (id <= 0) {
                JOptionPane.showMessageDialog(this, "ID phải là số nguyên dương.");
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID không hợp lệ.");
            return null;
        }

        // Kiểm tra mã bệnh nhân
        try {
            mabenhnhan = Integer.parseInt(txt_benhnhan.getText());
            if (mabenhnhan <= 0) {
                JOptionPane.showMessageDialog(this, "Mã bệnh nhân phải là số nguyên dương.");
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Mã bệnh nhân không hợp lệ.");
            return null;
        }

        // Kiểm tra mã bác sĩ
        try {
            mabacsi = Integer.parseInt(txt_bacsi.getText());
            if (mabacsi <= 0) {
                JOptionPane.showMessageDialog(this, "Mã bác sĩ phải là số nguyên dương.");
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Mã bác sĩ không hợp lệ.");
            return null;
        }

        // Kiểm tra chẩn đoán
        chandoan = txt_chandoan.getText();
        if (chandoan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chẩn đoán không được để trống.");
            return null;
        }

        // Kiểm tra điều trị
        dieutri = txt_dieutri.getText();
        if (dieutri.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Điều trị không được để trống.");
            return null;
        }
        
        // Kiểm tra ngày khám
        ngaykham = txt_ngaykham.getText();
        /*if (!isValidDate(ngaykham)) {
            JOptionPane.showMessageDialog(this, "Ngày khám không hợp lệ.");
            return null;
        }*/

        // Kiểm tra ngày lập bệnh án
        ngaylapbenhan = txt_ngaylapbenhan.getText();
        /*if (!isValidDate(ngaylapbenhan)) {
            JOptionPane.showMessageDialog(this, "Ngày lập bệnh án không hợp lệ.");
            return null;
        }*/

        // Kiểm tra mô tả
        mota = txt_mota.getText();
        if (mota.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mô tả không được để trống.");
            return null;
        }

        // Kiểm tra trạng thái
        if (rdo_ht.isSelected()) {
            trangthai = "Hoàn Thành";
        } else {
            trangthai = "Không Hoàn Thành";
        }
        return new  BenhAn(id, mabenhnhan, mabacsi, chandoan, dieutri, ngaykham, ngaylapbenhan, mota, trangthai);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_benhan = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_timkiem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_benhnhan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_bacsi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_chandoan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_ngaykham = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_ngaylapbenhan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_mota = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        rdo_ht = new javax.swing.JRadioButton();
        rdo_kht = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        txt_dieutri = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_benhnhan = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btn_timkiembn = new javax.swing.JButton();
        txt_timkiem = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_reset = new javax.swing.JButton();
        btXemThongTin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_benhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã Bệnh Nhân", "Mã Bác Sĩ", "Chân Đoán", "Điều Trị", "Ngày Khám", "Ngày Lập Bệnh Án", "Mô Tả", "Trạng Thái"
            }
        ));
        tbl_benhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_benhanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_benhan);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 204, 255));
        jLabel1.setText("BỆNH ÁN");

        btn_them.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_them.setForeground(new java.awt.Color(0, 0, 255));
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/add.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/clear.png"))); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_xoa.setForeground(new java.awt.Color(255, 0, 0));
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/delete.png"))); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_timkiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_timkiem.setForeground(new java.awt.Color(0, 204, 204));
        btn_timkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/filter-filled-tool-symbol.png"))); // NOI18N
        btn_timkiem.setText("Tìm Kiếm");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 204, 255));
        jLabel2.setText("ID");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 204, 255));
        jLabel7.setText("Mã Bệnh Nhân");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 204, 255));
        jLabel9.setText("Mã Bác Sĩ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 204, 255));
        jLabel3.setText("Chẩn Đoán");

        txt_chandoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_chandoanActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 204, 255));
        jLabel5.setText("Ngày Khám");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 204, 255));
        jLabel6.setText("Ngày Lập Bệnh Án");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 204, 255));
        jLabel8.setText("Mô tả");

        txt_mota.setColumns(20);
        txt_mota.setRows(5);
        jScrollPane2.setViewportView(txt_mota);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Trạng Thái", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(51, 204, 255))); // NOI18N

        buttonGroup1.add(rdo_ht);
        rdo_ht.setText("Hoàn Thành");

        buttonGroup1.add(rdo_kht);
        rdo_kht.setText("Không Hoàn Thành");
        rdo_kht.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_khtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(rdo_ht, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rdo_kht)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdo_ht)
                    .addComponent(rdo_kht))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 204, 255));
        jLabel4.setText("Điều Trị");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_chandoan))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_id)
                                    .addComponent(txt_benhnhan)
                                    .addComponent(txt_bacsi))))
                        .addGap(28, 28, 28))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(txt_dieutri, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_ngaylapbenhan, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_ngaykham, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_benhnhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_bacsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_chandoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_dieutri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_ngaykham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_ngaylapbenhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        tbl_benhnhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên", "Ngày Sinh", "Địa Chỉ", "SĐT", "Giới Tính", "Ngày Tạo"
            }
        ));
        tbl_benhnhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_benhnhanMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_benhnhan);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm Bệnh Nhân", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(51, 204, 255))); // NOI18N

        btn_timkiembn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_timkiembn.setForeground(new java.awt.Color(51, 204, 255));
        btn_timkiembn.setText("Tìm Kiếm");
        btn_timkiembn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiembnActionPerformed(evt);
            }
        });

        txt_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btn_timkiembn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_timkiembn)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 204, 255));
        jLabel10.setText("BỆNH ÁN");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 204, 255));
        jLabel11.setText("BỆNH NHÂN");

        btn_reset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(255, 0, 255));
        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/png/refresh.png"))); // NOI18N
        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btXemThongTin.setText("Xem Thông Tin Bệnh Án");
        btXemThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXemThongTinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(501, 501, 501))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(25, 25, 25))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(159, 159, 159))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btXemThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(btn_them)
                                .addGap(70, 70, 70)
                                .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(btn_reset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_xoa)
                                .addGap(61, 61, 61)
                                .addComponent(btn_timkiem)
                                .addGap(56, 56, 56))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btXemThongTin, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_them)
                            .addComponent(btn_sua)
                            .addComponent(btn_xoa)
                            .addComponent(btn_timkiem)
                            .addComponent(btn_reset))))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_benhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_benhanMouseClicked
        // TODO add your handling code here:
        i = tbl_benhan.getSelectedRow();
        this.showData(i);
    }//GEN-LAST:event_tbl_benhanMouseClicked

    private void txt_chandoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_chandoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_chandoanActionPerformed

    private void rdo_khtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_khtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdo_khtActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        int chon = JOptionPane.showConfirmDialog(this, "Bạn có muốn THÊM không");
        if (chon == 0) {
            i = tbl_benhan.getSelectedRow();
            try {
                if (this.readform() != null) {
                    if (rp.them(this.readform()) > 0) {
                        JOptionPane.showMessageDialog(this, "Thêm thành công");
                        this.fillToTable(rp.getall());
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm thất bại");
                    }
                }
            } catch (java.text.ParseException ex) {
                Logger.getLogger( ViewBenhAn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
          // TODO add your handling code here:
        int chon = JOptionPane.showConfirmDialog(this, "Bạn có muốn SỬA không ?? ");
        if (chon == 0) {
            i = tbl_benhan.getSelectedRow();
            int ma = Integer.parseInt(tbl_benhan.getValueAt(i, 0).toString());
            try {
                if (this.readform() != null) {
                    if (rp.sua(ma, this.readform()) > 0) {
                        JOptionPane.showMessageDialog(this, "Sửa thành công");
                        this.fillToTable(rp.getall());
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa thất bại");
                    }
                }
            } catch (java.text.ParseException ex) {
                Logger.getLogger( ViewBenhAn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
         // TODO add your handling code here:
        int chon = JOptionPane.showConfirmDialog(this, "Bạn có muốn XÓA không");
        if (chon == 0) {
            i = tbl_benhan.getSelectedRow();
            if (i > 0) {
                int id = Integer.parseInt(tbl_benhan.getValueAt(i, 0).toString());
                if (rp.xoa(id) > 0) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                    this.fillToTable(rp.getall());
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng xóa");
            }
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed

        String id = JOptionPane.showInputDialog(null, "Mời nhập ID cần tìm", "FORM TÌM KIẾM", 1);
        if (rp.tim(id).isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy ID");
        } else {
            JOptionPane.showMessageDialog(this, "Có tìm thấy ID");
            this.fillToTable(rp.tim(id));
        }

    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void txt_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timkiemActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_timkiemActionPerformed

    private void tbl_benhnhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_benhnhanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_benhnhanMouseClicked

    private void btn_timkiembnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiembnActionPerformed
        // TODO add your handling code here:
        String tencantim = txt_timkiem.getText().trim();
        if (rp1.timkiem(tencantim).isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy tên");
        } else {
            JOptionPane.showMessageDialog(this, "Có tìm thấy tên");
            this.filltoTable1(rp1.timkiem(tencantim));
        }
    }//GEN-LAST:event_btn_timkiembnActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        txt_id.setText("");
        txt_benhnhan.setText("");
        txt_bacsi.setText("");
        txt_chandoan.setText("");
        txt_dieutri.setText("");
        txt_ngaykham.setText("");
        txt_ngaylapbenhan.setText("");
        txt_mota.setText("");
        txt_timkiem.setText("");
        fillToTable(rp.getall());
        filltoTable1(rp1.getall());
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btXemThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXemThongTinActionPerformed
        int selectedRow = tbl_benhnhan.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn một bệnh nhân!");
        return;
    }

    String maBenhNhan = (String) tbl_benhnhan.getValueAt(selectedRow, 0);
    BenhAn benhAn = rp.getBenhAnByMaBenhNhan(maBenhNhan);

    if (benhAn == null) {
        JOptionPane.showMessageDialog(this, "Bệnh nhân chưa có bệnh án!");
        return;
    }

    DefaultTableModel model = (DefaultTableModel) tbl_benhan.getModel();
    model.setRowCount(0);
    model.addRow(new Object[]{
        benhAn.getId(),
        benhAn.getMabenhnhan(),
        benhAn.getMabacsi(),
        benhAn.getChandoan(),
        benhAn.getDieutri(),
        benhAn.getNgaykham(),
        benhAn.getNgaylapbenhan(),
        benhAn.getMota(),
        benhAn.getTrangthai(),
    });
    }//GEN-LAST:event_btXemThongTinActionPerformed

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
            java.util.logging.Logger.getLogger(ViewBenhAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBenhAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBenhAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBenhAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBenhAn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btXemThongTin;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_timkiembn;
    private javax.swing.JButton btn_xoa;
    private javax.swing.ButtonGroup buttonGroup1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rdo_ht;
    private javax.swing.JRadioButton rdo_kht;
    private javax.swing.JTable tbl_benhan;
    private javax.swing.JTable tbl_benhnhan;
    private javax.swing.JTextField txt_bacsi;
    private javax.swing.JTextField txt_benhnhan;
    private javax.swing.JTextField txt_chandoan;
    private javax.swing.JTextField txt_dieutri;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextArea txt_mota;
    private javax.swing.JTextField txt_ngaykham;
    private javax.swing.JTextField txt_ngaylapbenhan;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
