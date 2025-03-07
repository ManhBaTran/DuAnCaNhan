package com.poly.repository;

import com.poly.database.DBConnect;
import com.poly.entity.NguoiDung;
import com.poly.entity.NguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepoNguoiDung {
    public List<NguoiDung> getAll() {
        List<NguoiDung> combinedDataList = new ArrayList<>();
        String sql = """
                     SELECT 
                           'BacSi' AS VaiTro, 
                           ID, 
                           Ten AS TenNguoi, 
                           Email, 
                           SoDienThoai, 
                           MatKhau, 
                           ChuyenKhoa, 
                           SoNamKinhNghiem, 
                           NgayTao, 
                           TrangThai
                       FROM BacSi
                       
                       UNION ALL
                       
                       SELECT 
                           'Letan' AS VaiTro,
                           ID, 
                           Ten AS TenNguoi, 
                           Email, 
                           SoDienThoai, 
                           MatKhau, 
                           NULL AS ChuyenKhoa, 
                           NULL AS SoNamKinhNghiem,
                           NgayTao, 
                           TrangThai
                       FROM Letan;
                     """;

        try (Connection con = DBConnect.getConnect();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NguoiDung data = new NguoiDung();
                data.setVaiTro(rs.getString("VaiTro"));
                data.setId(rs.getLong("ID"));
                data.setTenNguoi(rs.getString("TenNguoi"));
                data.setEmail(rs.getString("Email"));
                data.setSoDienThoai(rs.getString("SoDienThoai"));
                data.setMatKhau(rs.getString("MatKhau"));
                data.setChuyenKhoa(rs.getString("ChuyenKhoa"));
                data.setSoNamKinhNghiem((Integer) rs.getObject("SoNamKinhNghiem"));
                data.setNgayTao(rs.getDate("NgayTao"));
                data.setTrangThai(rs.getString("TrangThai"));

                combinedDataList.add(data);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return combinedDataList;
    }
  public boolean add(NguoiDung nguoiDung) {
          String insertBacSi = """
        INSERT INTO BacSi (Ten, Email, SoDienThoai, MatKhau, ChuyenKhoa, SoNamKinhNghiem, NgayTao, TrangThai)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?);
    """;

    String insertLetan = """
        INSERT INTO Letan (Ten, Email, SoDienThoai, MatKhau, NgayTao, TrangThai)
        VALUES (?, ?, ?, ?, ?, ?);
    """;

    try (Connection con = DBConnect.getConnect()) {
        PreparedStatement ps = null;
        if ("BacSi".equals(nguoiDung.getVaiTro())) {
            ps = con.prepareStatement(insertBacSi);
            ps.setString(1, nguoiDung.getTenNguoi());
            ps.setString(2, nguoiDung.getEmail());
            ps.setString(3, nguoiDung.getSoDienThoai());
            ps.setString(4, nguoiDung.getMatKhau());
            ps.setString(5, nguoiDung.getChuyenKhoa());
            ps.setInt(6, nguoiDung.getSoNamKinhNghiem());
            ps.setDate(7, new java.sql.Date(nguoiDung.getNgayTao().getTime()));
            ps.setString(8, nguoiDung.getTrangThai());
        } else if ("Letan".equals(nguoiDung.getVaiTro())) {
            ps = con.prepareStatement(insertLetan);
            ps.setString(1, nguoiDung.getTenNguoi());
            ps.setString(2, nguoiDung.getEmail());
            ps.setString(3, nguoiDung.getSoDienThoai());
            ps.setString(4, nguoiDung.getMatKhau());
            ps.setDate(5, new java.sql.Date(nguoiDung.getNgayTao().getTime()));
            ps.setString(6, nguoiDung.getTrangThai());
        }

        if (ps != null) {
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return false;
    }
 public boolean updateNguoiDung(NguoiDung nguoiDung) {
    String updateBacSi = """
                         UPDATE BacSi 
                         SET Ten=?, Email=?, SoDienThoai=?, MatKhau=?, ChuyenKhoa=?, SoNamKinhNghiem=?, NgayTao=?, TrangThai=?
                         WHERE ID=?;
                         """;

    String updateLetan = """
                         UPDATE Letan 
                         SET Ten=?, Email=?, SoDienThoai=?, MatKhau=?, NgayTao=?, TrangThai=?
                         WHERE ID=?;
                         """;

    try (Connection con = DBConnect.getConnect()) {
        PreparedStatement ps = null;
        if ("BacSi".equals(nguoiDung.getVaiTro())) {
            ps = con.prepareStatement(updateBacSi);
            ps.setString(1, nguoiDung.getTenNguoi());
            ps.setString(2, nguoiDung.getEmail());
            ps.setString(3, nguoiDung.getSoDienThoai());
            ps.setString(4, nguoiDung.getMatKhau());
            ps.setString(5, nguoiDung.getChuyenKhoa());
            ps.setInt(6, nguoiDung.getSoNamKinhNghiem());
            ps.setDate(7, new java.sql.Date(nguoiDung.getNgayTao().getTime()));
            ps.setString(8, nguoiDung.getTrangThai());
            ps.setLong(9, nguoiDung.getId());
        } else if ("Letan".equals(nguoiDung.getVaiTro())) {
            ps = con.prepareStatement(updateLetan);
            ps.setString(1, nguoiDung.getTenNguoi());
            ps.setString(2, nguoiDung.getEmail());
            ps.setString(3, nguoiDung.getSoDienThoai());
            ps.setString(4, nguoiDung.getMatKhau());
            ps.setDate(5, new java.sql.Date(nguoiDung.getNgayTao().getTime()));
            ps.setString(6, nguoiDung.getTrangThai());
            ps.setLong(7, nguoiDung.getId());
        }

        if (ps != null) {
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return false;
}
public boolean deleteNguoiDung(Long id, String vaiTro) {
        String deleteBacSi = "DELETE FROM BacSi WHERE ID = ?";
        String deleteLetan = "DELETE FROM Letan WHERE ID = ?";

        try (Connection con = DBConnect.getConnect()) {
            PreparedStatement ps = null;
            if ("BacSi".equals(vaiTro)) {
                ps = con.prepareStatement(deleteBacSi);
                ps.setLong(1, id);
            } else if ("Letan".equals(vaiTro)) {
                ps = con.prepareStatement(deleteLetan);
                ps.setLong(1, id);
            }

            if (ps != null) {
                int rowsAffected = ps.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean isIDUnique(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean isEmailUnique(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
