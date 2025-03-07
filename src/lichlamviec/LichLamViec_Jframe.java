package lichlamviec;

import Repo.Repo_bacSiID;
import Repo.Repo_LichLamViec;
import Model.Model_LichLamViec;
import Model.Model_bacSi;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LichLamViec_Jframe extends javax.swing.JFrame {

    private Repo_LichLamViec rp = new Repo_LichLamViec();
    private Repo_bacSiID rpp = new Repo_bacSiID();
    private DefaultTableModel mol = new DefaultTableModel();
    private int LichLamViec_Jframe = -1;
    private ArrayList<Model_LichLamViec> dateSearchResult;

    public LichLamViec_Jframe() {
        initComponents();
        this.setLocationRelativeTo(null);

        cbo_bacSiID.removeAllItems();
        for (Model_bacSi y : rpp.getAll()) {
            cbo_bacSiID.addItem(y.getBacSiID());
        }
        this.fillTable(rp.getAll());
    }

    void fillTable(ArrayList<Model_LichLamViec> list) {
//        list = seaList;
        mol = (DefaultTableModel) tbl_LLV.getModel();
        mol.setRowCount(0);
        for (Model_LichLamViec x : list) {
            mol.addRow(x.toDataRow());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_LLV = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_ghiChu = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rdo_onl = new javax.swing.JRadioButton();
        rdo_off = new javax.swing.JRadioButton();
        trangThai = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        date_ngaytao = new com.toedter.calendar.JDateChooser();
        rdo_sang = new javax.swing.JRadioButton();
        rdo_chieu = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        txt_batDau = new javax.swing.JTextField();
        txt_ketThuc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        date_ngay = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        txt_id = new javax.swing.JTextField();
        cbo_bacSiID = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        date_ngay1 = new com.toedter.calendar.JDateChooser();
        cbo_caLamViec = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btn_them = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Lịch.png"))); // NOI18N
        jLabel1.setText("LỊCH LÀM VIỆC");

        tbl_LLV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID làm việc", "Mã bác sĩ", "Ngày", "Thời gian bắt đầu", "Thời gian kết thúc", "Ghi chú", "Ca làm việc", "Trạng thái", "Ngày tạo"
            }
        ));
        tbl_LLV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_LLVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_LLV);
        if (tbl_LLV.getColumnModel().getColumnCount() > 0) {
            tbl_LLV.getColumnModel().getColumn(0).setMaxWidth(70);
            tbl_LLV.getColumnModel().getColumn(1).setMaxWidth(70);
            tbl_LLV.getColumnModel().getColumn(6).setMaxWidth(70);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txt_ghiChu.setColumns(20);
        txt_ghiChu.setRows(5);
        jScrollPane1.setViewportView(txt_ghiChu);

        jLabel7.setText("Ghi Chú");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        buttonGroup1.add(rdo_onl);
        rdo_onl.setText("Hoạt động");
        rdo_onl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_onlActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdo_off);
        rdo_off.setText("Không hoạt động");

        trangThai.setText("Trạng Thái");

        jLabel10.setText("Ngày Tạo");

        jLabel8.setText("Ca Làm Việc");

        buttonGroup2.add(rdo_sang);
        rdo_sang.setSelected(true);
        rdo_sang.setText("Sáng");

        buttonGroup2.add(rdo_chieu);
        rdo_chieu.setText("Chiều");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel10)
                        .addComponent(trangThai)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rdo_onl, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdo_sang, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdo_chieu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(date_ngaytao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdo_off))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(rdo_sang)
                    .addComponent(rdo_chieu))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(trangThai)
                    .addComponent(rdo_onl, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdo_off)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(date_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txt_batDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_batDauActionPerformed(evt);
            }
        });

        jLabel4.setText("Ngày");

        jLabel5.setText("Thời Gian Bắt Đầu");

        jLabel6.setText("Thời Gian Kết Thúc");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_batDau)
                    .addComponent(txt_ketThuc, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(date_ngay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(date_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_batDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_ketThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbo_bacSiID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("ID  Lịch Làm Việc");

        jLabel3.setText("Mã Bác Sĩ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbo_bacSiID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbo_bacSiID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search2.png"))); // NOI18N
        jButton4.setText("Tìm Kiếm");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        cbo_caLamViec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sáng", "Chiều" }));
        cbo_caLamViec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_caLamViecActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Ca");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_ngay1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbo_caLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbo_caLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(date_ngay1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add3.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        jButton2.setText("Sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_them)
                .addGap(7, 7, 7)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(btn_them))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 34, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2))
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_batDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_batDauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_batDauActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(date_ngay1.getDate());

        // Perform the search using the formatted date
        dateSearchResult = rp.tim(formattedDate);
        if (dateSearchResult.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tìm thất bại");
        } else {
            JOptionPane.showMessageDialog(this, "Tìm thành công");
            fillTable(dateSearchResult);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbl_LLVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_LLVMouseClicked
        // TODO add your handling code here:
        LichLamViec_Jframe = tbl_LLV.getSelectedRow();
        txt_id.setText(tbl_LLV.getValueAt(LichLamViec_Jframe, 0).toString());
        cbo_bacSiID.setSelectedItem(tbl_LLV.getValueAt(LichLamViec_Jframe, 1).toString());
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) mol.getValueAt(LichLamViec_Jframe, 2));
            date_ngay.setDate(date);
        } catch (Exception e) {
        }
        txt_batDau.setText(tbl_LLV.getValueAt(LichLamViec_Jframe, 3).toString());
        txt_ketThuc.setText(tbl_LLV.getValueAt(LichLamViec_Jframe, 4).toString());
        txt_ghiChu.setText(tbl_LLV.getValueAt(LichLamViec_Jframe, 5).toString());

        if (tbl_LLV.getValueAt(LichLamViec_Jframe, 6).toString().equalsIgnoreCase("Sáng")) {
            rdo_sang.setSelected(true);
        } else {
            rdo_chieu.setSelected(true);
        }

        if (tbl_LLV.getValueAt(LichLamViec_Jframe, 7).toString().equalsIgnoreCase("Hoạt động")) {
            rdo_onl.setSelected(true);
        } else {
            rdo_off.setSelected(true);
        }

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) mol.getValueAt(LichLamViec_Jframe, 8));
            date_ngaytao.setDate(date);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tbl_LLVMouseClicked

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        if (this.readForm() != null) {
            if (rp.them(this.readForm()) > 0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                this.fillTable(rp.getAll());
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
        }

    }//GEN-LAST:event_btn_themActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        LichLamViec_Jframe = tbl_LLV.getSelectedRow();
        if (LichLamViec_Jframe == -1) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        } else {
            String idSua = txt_id.getText().toString();
            if (this.readForm() != null) {
                if (rp.sua(this.readForm(), idSua) > 0) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                    this.fillTable(rp.getAll());
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại");
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (this.readForm() != null) {
            String idXoa = txt_id.getText().toString();
            if (rp.xoa(idXoa) > 0) {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                this.fillTable(rp.getAll());
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void rdo_onlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_onlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdo_onlActionPerformed

    private void cbo_caLamViecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_caLamViecActionPerformed
        // TODO add your handling code here:
        String caLam = cbo_caLamViec.getSelectedItem().toString();
        String calam = null;
        if (caLam.equals("Sáng")) {
            calam = "Sáng";
        } else if (caLam.equals("Chiều")) {
            calam = "Chiều";
        }
        if (dateSearchResult != null && !dateSearchResult.isEmpty()) {
            ArrayList<Model_LichLamViec> filteredList = new ArrayList<>();
            for (Model_LichLamViec item : dateSearchResult) {
                if (item.getCaLamViec().equals(calam)) {
                    filteredList.add(item);
                }
            }
            fillTable(filteredList);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng tìm kiếm theo ngày trước.");
        }
//        String caLam=cbo_caLamViec.getSelectedItem().toString();
//        String calam = null;
//        if(caLam.equals("Sáng")){
//            calam="Sáng";
//        }
//        else if(caLam.equals("Chiều")){
//            calam="Chiều";
//        }
//        ArrayList<Model_LichLamViec> list = rp.timCa(calam);
//        fillTable(list); 
    }//GEN-LAST:event_cbo_caLamViecActionPerformed

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
            java.util.logging.Logger.getLogger(LichLamViec_Jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LichLamViec_Jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LichLamViec_Jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LichLamViec_Jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LichLamViec_Jframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_them;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbo_bacSiID;
    private javax.swing.JComboBox<String> cbo_caLamViec;
    private com.toedter.calendar.JDateChooser date_ngay;
    private com.toedter.calendar.JDateChooser date_ngay1;
    private com.toedter.calendar.JDateChooser date_ngaytao;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdo_chieu;
    private javax.swing.JRadioButton rdo_off;
    private javax.swing.JRadioButton rdo_onl;
    private javax.swing.JRadioButton rdo_sang;
    private javax.swing.JTable tbl_LLV;
    private javax.swing.JLabel trangThai;
    private javax.swing.JTextField txt_batDau;
    private javax.swing.JTextArea txt_ghiChu;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_ketThuc;
    // End of variables declaration//GEN-END:variables

    Model_LichLamViec readForm() {
        int bacSiID;
        String ngay, thoiGianBatDau, thoiGianketThuc, ghiChu, caLamViec, trangThai, ngayTao;
        bacSiID = Integer.parseInt(cbo_bacSiID.getSelectedItem().toString());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ngay = dateFormat.format(date_ngay.getDate());

        thoiGianBatDau = txt_batDau.getText().trim();
        if (thoiGianBatDau.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập thời gian bắt đầu");
            txt_batDau.requestFocus();
            return null;
        }
        thoiGianketThuc = txt_ketThuc.getText().trim();
        if (thoiGianketThuc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập thời gian kết thúc");
            txt_ketThuc.requestFocus();
            return null;
        }
        ghiChu = txt_ghiChu.getText().trim();
        if (ghiChu.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập ghi chú");
            txt_ghiChu.requestFocus();
            return null;
        }

        if (rdo_sang.isSelected()) {
            caLamViec = "Sáng";
        } else {
            caLamViec = "Chiều";
        }

        if (rdo_onl.isSelected()) {
            trangThai = "Hoạt động";
        } else {
            trangThai = "Không hoạt động";
        }

        SimpleDateFormat dateFormatt = new SimpleDateFormat("yyyy-MM-dd");
        ngayTao = dateFormatt.format(date_ngaytao.getDate());

        return new Model_LichLamViec(bacSiID, ngay, thoiGianBatDau, thoiGianketThuc, ghiChu, caLamViec, trangThai, ngayTao);
    }
}
