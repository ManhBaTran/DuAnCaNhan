/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.repository;

import com.poly.database.DBConnect;
import com.poly.entity.BacSiLichLamViec;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manh9
 */
public class RepoBuoiKham {
    public List<BacSiLichLamViec> getAllLichHen() {
        List<BacSiLichLamViec> lichHenList = new ArrayList<>();
        String sql = """
                            SELECT
                                LichHen.ID AS LichHenID,
                                BenhNhan.Ten AS TenBenhNhan,
                                BenhNhan.SoDienThoai AS SoDienThoai,
                                BenhNhan.DiaChi AS DiaChi,
                                BenhNhan.NgaySinh AS NgaySinh,
                                BenhNhan.GioiTinh AS GioiTinh,
                                BacSi.Ten AS TenBacSi,
                                LichHen.NgayHen,
                                LichHen.GioHen,
                                LichHen.NgayDatLich,
                                DichVu.Ten AS TenDichVu,
                                DichVu.ChiPhi AS ChiPhi,
                                LichHen.TrangThai,
                            	BenhNhan.ID as IdBenhNhan,
                            	DichVu.ID as IDDichVu
                            FROM LichHen
                            INNER JOIN BenhNhan ON LichHen.BenhNhanID = BenhNhan.ID
                            INNER JOIN BacSi ON LichHen.BacSiID = BacSi.ID
                            INNER JOIN DichVu ON LichHen.DichVuID = DichVu.ID
                            ORDER BY LichHen.ID DESC;
                      """;

        try (Connection con = DBConnect.getConnect();
             java.sql.PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                BacSiLichLamViec bsllv = new BacSiLichLamViec();
                bsllv.setIdLH(rs.getLong("LichHenID"));
                bsllv.setTenBacSi(rs.getString("TenBacSi"));
                bsllv.setNgayHen(rs.getDate("NgayHen").toLocalDate());
                Time gioHenSql = rs.getTime("GioHen");
                bsllv.setGioHen(gioHenSql != null ? gioHenSql.toLocalTime() : null);
                bsllv.setNgayDatLich(rs.getDate("NgayDatLich").toLocalDate());
                bsllv.setTenBN(rs.getString("TenBenhNhan"));
                bsllv.setSdtBN(rs.getString("SoDienThoai"));
                bsllv.setDiachi(rs.getString("DiaChi"));
                bsllv.setNgaysinh(rs.getDate("NgaySinh") );
                bsllv.setGioitinh(rs.getString("GioiTinh"));
                bsllv.setCaLamViec("N/A"); // Hoặc từ nguồn khác
                bsllv.setTenDV(rs.getString("TenDichVu"));

                // Đọc giá trị gốc từ SQL và chuyển đổi thành BigDecimal
                BigDecimal chiPhi = rs.getBigDecimal("ChiPhi");
                bsllv.setChiPhi(chiPhi);

                bsllv.setTrangThaiLH(rs.getString("TrangThai"));
                bsllv.setIdBenhNhan(rs.getLong("IdBenhNhan"));
                bsllv.setIdDV(rs.getLong("IDDichVu"));
                lichHenList.add(bsllv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lichHenList;
    }
}
