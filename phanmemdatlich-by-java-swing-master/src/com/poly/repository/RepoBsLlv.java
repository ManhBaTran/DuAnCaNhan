package com.poly.repository;

import com.poly.database.DBConnect;
import com.poly.entity.BacSiLichLamViec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.Time;
import java.time.LocalTime;
import javax.swing.JOptionPane;
public class RepoBsLlv {
     public List<BacSiLichLamViec> getAllBacSiLichLamViec() {
    List<BacSiLichLamViec> list = new ArrayList<>();
    String sql = """
                   SELECT 
                       BacSi.ID AS ID,
                       BacSi.Ten AS TenBacSi,
                       LichLamViec.Ngay AS NgayLamViec,
                       LichLamViec.ThoiGianBatDau AS ThoiGianBatDau,
                       LichLamViec.ThoiGianKetThuc AS ThoiGianKetThuc,
                       LichLamViec.CaLamViec AS CaLamViec,
                       LichLamViec.TrangThai AS TrangThai
                   FROM LichLamViec
                   INNER JOIN BacSi ON LichLamViec.BacSiID = BacSi.ID
                   ORDER BY BacSi.Ten, LichLamViec.ThoiGianBatDau;
                  """;

    try (Connection con = DBConnect.getConnect();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            BacSiLichLamViec bsllv = new BacSiLichLamViec();
            bsllv.setIdBS(rs.getLong("ID"));
            bsllv.setTenBacSi(rs.getString("TenBacSi"));
            bsllv.setNgayLamViec(rs.getDate("NgayLamViec").toLocalDate());
            bsllv.setThoiGianBatDau(rs.getTime("ThoiGianBatDau").toLocalTime());
            bsllv.setThoiGianKetThuc(rs.getTime("ThoiGianKetThuc").toLocalTime());
            bsllv.setCaLamViec(rs.getString("CaLamViec"));
            bsllv.setTrangThaiBS(rs.getString("TrangThai"));

            list.add(bsllv);
        }
    } catch (SQLException e) {
        e.printStackTrace();  // Hoặc sử dụng logging framework
    }

    return list;
}

    
public List<BacSiLichLamViec> getAllLichHen() {
    List<BacSiLichLamViec> lichHenList = new ArrayList<>();
    String sql = """
                 SELECT
                      LichHen.ID AS LichHenID,
                      BenhNhan.Ten AS TenBenhNhan,
                      BenhNhan.SoDienThoai AS SoDienThoai,
                      BenhNhan.Email AS Email,
                      BenhNhan.DiaChi AS DiaChi,
                      BenhNhan.NgaySinh AS NgaySinh,
                      BenhNhan.GioiTinh AS GioiTinh,
                      BacSi.Ten AS TenBacSi,
                      LichHen.NgayHen,
                      LichHen.GioHen,
                      LichHen.NgayDatLich,
                      LichHen.TrangThai
                  FROM LichHen
                  INNER JOIN BenhNhan ON LichHen.BenhNhanID = BenhNhan.ID
                  INNER JOIN BacSi ON LichHen.BacSiID = BacSi.ID;
                  """;

    try (Connection con = DBConnect.getConnect();
         PreparedStatement ps = con.prepareStatement(sql);
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
            bsllv.setEmail(rs.getString("Email"));
            bsllv.setDiachi(rs.getString("DiaChi"));
            bsllv.setNgaysinh(rs.getString("NgaySinh"));
            bsllv.setGioitinh(rs.getString("GioiTinh"));
            bsllv.setCaLamViec("N/A"); // Hoặc từ nguồn khác
            bsllv.setTrangThaiLH(rs.getString("TrangThai"));

            lichHenList.add(bsllv);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lichHenList;
}

public List<BacSiLichLamViec> getBacSiByNgayGio(String ngayLamViec, String thoiGianBatDau) {
    List<BacSiLichLamViec> bacSiList = new ArrayList<>();
    String query = """
                 SELECT BacSi.ID AS ID, BacSi.Ten, LichLamViec.Ngay AS NgayLamViec, 
                            LichLamViec.ThoiGianBatDau, LichLamViec.ThoiGianKetThuc, 
                            LichLamViec.CaLamViec, LichLamViec.TrangThai
                     FROM BacSi
                     INNER JOIN LichLamViec ON BacSi.ID = LichLamViec.BacSiID
                     WHERE LichLamViec.Ngay = ? 
                       AND LichLamViec.ThoiGianBatDau = CAST(? AS time)
                   """;

    try (Connection con = DBConnect.getConnect();
         PreparedStatement statement = con.prepareStatement(query)) {

        java.sql.Date sqlNgayLamViec = java.sql.Date.valueOf(ngayLamViec);
        java.sql.Time sqlThoiGianBatDau = java.sql.Time.valueOf(thoiGianBatDau);

        statement.setDate(1, sqlNgayLamViec);
        statement.setTime(2, sqlThoiGianBatDau);

        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                BacSiLichLamViec bacSiLichLamViec = new BacSiLichLamViec();
                bacSiLichLamViec.setIdBS(resultSet.getLong("ID"));
                bacSiLichLamViec.setTenBacSi(resultSet.getString("Ten"));
                bacSiLichLamViec.setNgayLamViec(resultSet.getDate("NgayLamViec").toLocalDate());
                bacSiLichLamViec.setThoiGianBatDau(resultSet.getTime("ThoiGianBatDau").toLocalTime());
                bacSiLichLamViec.setThoiGianKetThuc(resultSet.getTime("ThoiGianKetThuc").toLocalTime());
                bacSiLichLamViec.setCaLamViec(resultSet.getString("CaLamViec"));
                bacSiLichLamViec.setTrangThaiBS(resultSet.getString("TrangThai"));

                bacSiList.add(bacSiLichLamViec);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Log error or handle it properly
    }

    return bacSiList;
    
}


public boolean addLichHen(BacSiLichLamViec lichHen) {
    String sql = """
                 INSERT INTO [dbo].[LichHen]
                            ([BenhNhanID]
                            ,[BacSiID]
                            ,[NgayHen]
                            ,[GioHen]
                            ,[NgayDatLich]
                            ,[TrangThai])
                 VALUES
                            (?, ?, ?, ?, ?, ?)
                 """;
    int check = 0;
    try (Connection conn = DBConnect.getConnect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setLong(1, lichHen.getIdBN());
        pstmt.setLong(2, lichHen.getIdBS());
        pstmt.setDate(3, Date.valueOf(lichHen.getNgayHen()));
        pstmt.setTime(4, Time.valueOf(lichHen.getGioHen()));
        pstmt.setDate(5, Date.valueOf(lichHen.getNgayDatLich()));
        pstmt.setString(6, lichHen.getTrangThaiLH());
        check = pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return check > 0;
}



// Hàm chuyển đổi định dạng thời gian
private String convertToSQLTimeFormat(String time) {
    // Giả sử định dạng đầu vào là hh:mm và bạn muốn chuyển nó thành hh:mm:ss
    if (time.contains("-")) {
        time = time.replace("-", ":");
    }
    if (time.length() == 5) {
        time += ":00"; // Nếu thời gian chỉ có giờ và phút, thêm giây mặc định là 00
    }
    return time;
}


}


