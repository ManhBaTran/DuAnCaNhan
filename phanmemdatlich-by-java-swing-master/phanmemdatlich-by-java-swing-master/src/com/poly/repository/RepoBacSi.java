package com.poly.repository;

import com.poly.database.DBConnect;
import com.poly.entity.BacSi;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.activation.DataSource;

public class RepoBacSi {
    
    // Lấy tất cả bác sĩ
    public List<BacSi> getAll() {
        List<BacSi> bacSiList = new ArrayList<>();
        String sql = """
                     SELECT [ID]
                           ,[Ten]
                     	  ,[ChuyenKhoa]
                     	  ,[SoNamKinhNghiem]
                     	  ,[SoDienThoai]
                           ,[Email]
                           ,[TrangThai]
                       FROM [dbo].[BacSi]
                     """;

        try (Connection con = DBConnect.getConnect();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BacSi bacSi = new BacSi();
                bacSi.setID(rs.getLong("ID")); // Chỉnh sửa từ int thành long
                bacSi.setTen(rs.getString("Ten")); 
                bacSi.setChuyenKhoa(rs.getString("ChuyenKhoa"));
                bacSi.setSoNamKinhNghiem(rs.getInt("SoNamKinhNghiem"));
                bacSi.setSdt(rs.getString("SoDienThoai"));  
                bacSi.setEmail(rs.getString("Email"));  
                bacSi.setTrangThai(rs.getString("TrangThai"));

                bacSiList.add(bacSi);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bacSiList;
    }

  // Lấy danh sách bác sĩ có thời gian rảnh
 public List<BacSi> getAvailableDoctors(Date ngayKham, Time gioKham) throws SQLException {
        List<BacSi> availableDoctors = new ArrayList<>();
        String sql = "SELECT * FROM BacSi WHERE ID NOT IN (" +
                     "SELECT MaBacSi FROM LichHen WHERE NgayKham = ? AND GioKham = ?)";

        try (Connection conn = DBConnect.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, ngayKham);
            pstmt.setTime(2, gioKham);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    BacSi bacSi = new BacSi();
                    bacSi.setID(rs.getLong("ID")); // Chỉnh sửa từ Id thành ID
                    bacSi.setTen(rs.getString("Ten"));
                    availableDoctors.add(bacSi);
                }
            }
        }
        return availableDoctors;
    }
   
}
