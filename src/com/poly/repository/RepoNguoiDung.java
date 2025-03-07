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
                     SELECT [ID]
                             ,[Ten]
                             ,[Email]
                             ,[SoDienThoai]
                             ,[MatKhau]
                             ,[DiaChi]
                             ,[NgaySinh]
                             ,[GioiTinh]
                             ,[NgayTao]
                             ,[TrangThai]
                         FROM [dbo].[Letan]
                     """;

        try (Connection con = DBConnect.getConnect();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NguoiDung data = new NguoiDung();
                data.setId(rs.getLong("ID"));
                data.setTen(rs.getString("Ten"));
                data.setEmail(rs.getString("Email"));
                data.setSoDienThoai(rs.getString("SoDienThoai"));
                data.setMatKhau(rs.getString("MatKhau"));
                data.setDiaChi(rs.getString("DiaChi"));
                data.setNgaySinh(rs.getDate("NgaySinh"));
                data.setGioiTinh(rs.getString("GioiTinh"));
                data.setNgayTao(rs.getDate("NgayTao"));
                data.setTrangThai(rs.getString("TrangThai"));

                combinedDataList.add(data);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return combinedDataList;
    }
   public boolean add(NguoiDung nd) {
    String sql = """
                 INSERT INTO [dbo].[Letan]
                                ([Ten]
                                ,[Email]
                                ,[SoDienThoai]
                                ,[MatKhau]
                                ,[DiaChi]
                                ,[NgaySinh]
                                ,[GioiTinh]
                                ,[NgayTao]
                                ,[TrangThai])
                          VALUES
                                (?,?,?,?,?,?,?,?,?)
                 """;
    int check = 0;

    try (Connection con = DBConnect.getConnect();
         PreparedStatement ps = con.prepareStatement(sql)) {

        // Đặt các tham số vào PreparedStatement
        ps.setString(1, nd.getTen());
        ps.setString(2, nd.getEmail());
        ps.setString(3, nd.getSoDienThoai());
        ps.setString(4, nd.getMatKhau());
        ps.setString(5, nd.getDiaChi());
        
        if (nd.getNgaySinh() != null) {
            ps.setDate(6, new java.sql.Date(nd.getNgaySinh().getTime()));
        } else {
            ps.setNull(6, java.sql.Types.DATE);
        }

        ps.setString(7, nd.getGioiTinh());
        
        if (nd.getNgayTao() != null) {
            ps.setDate(8, new java.sql.Date(nd.getNgayTao().getTime()));
        } else {
            ps.setNull(8, java.sql.Types.DATE);
        }

        ps.setString(9, nd.getTrangThai());

        // Thực thi câu lệnh
        check = ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return check > 0;
}
public boolean update(  long id ,NguoiDung nd ) {
    String sql = """
                 UPDATE [dbo].[Letan]
                 SET [Ten] = ?,
                     [Email] = ?,
                     [SoDienThoai] = ?,
                     [MatKhau] = ?,
                     [DiaChi] = ?,
                     [NgaySinh] = ?,
                     [GioiTinh] = ?,
                     [NgayTao] = ?,
                     [TrangThai] = ?
                 WHERE [ID] = ?
                 """;
    int check = 0;

    try (Connection con = DBConnect.getConnect();
         PreparedStatement ps = con.prepareStatement(sql)) {

        // Đặt các tham số vào PreparedStatement
        ps.setString(1, nd.getTen());
        ps.setString(2, nd.getEmail());
        ps.setString(3, nd.getSoDienThoai());
        ps.setString(4, nd.getMatKhau());
        ps.setString(5, nd.getDiaChi());
        
        if (nd.getNgaySinh() != null) {
            ps.setDate(6, new java.sql.Date(nd.getNgaySinh().getTime()));
        } else {
            ps.setNull(6, java.sql.Types.DATE);
        }

        ps.setString(7, nd.getGioiTinh());
        
        if (nd.getNgayTao() != null) {
            ps.setDate(8, new java.sql.Date(nd.getNgayTao().getTime()));
        } else {
            ps.setNull(8, java.sql.Types.DATE);
        }

        ps.setString(9, nd.getTrangThai());
        ps.setLong(10, id);

        // Thực thi câu lệnh
        check = ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return check > 0;
}
public boolean delete(long id) {
    String sql = "DELETE FROM [dbo].[Letan] WHERE [ID] = ?";
    int check = 0;

    try (Connection con = DBConnect.getConnect();
         PreparedStatement ps = con.prepareStatement(sql)) {

        // Đặt tham số vào PreparedStatement
        ps.setLong(1, id);

        // Thực thi câu lệnh
        check = ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return check > 0;
}

 public List<NguoiDung> searchByNameOrPhone(String searchQuery) {
        List<NguoiDung> results = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[LeTan] WHERE [Ten] LIKE ? OR [SoDienThoai] LIKE ?";

        try (Connection con = DBConnect.getConnect();
             PreparedStatement ps = con.prepareStatement(sql)) {

            String searchPattern = "%" + searchQuery + "%";
            ps.setString(1, searchPattern); // Tìm kiếm theo tên
            ps.setString(2, searchPattern); // Tìm kiếm theo số điện thoại

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                NguoiDung nd = new NguoiDung();
                nd.setId(rs.getLong("ID"));
                nd.setTen(rs.getString("Ten"));
                nd.setEmail(rs.getString("Email"));
                nd.setSoDienThoai(rs.getString("SoDienThoai"));
                nd.setMatKhau(rs.getString("MatKhau"));
                nd.setDiaChi(rs.getString("DiaChi"));
                nd.setNgaySinh(rs.getDate("NgaySinh"));
                nd.setGioiTinh(rs.getString("GioiTinh"));
                nd.setNgayTao(rs.getDate("NgayTao"));
                nd.setTrangThai(rs.getString("TrangThai"));
                results.add(nd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }
}
