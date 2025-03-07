package com.poly.ph49571;

import com.poly.database.DBConnect;
import java.sql.*;
import java.util.ArrayList;

public class CTHoaDonServices {

    private Connection conn;

    public CTHoaDonServices() {
        conn = DBConnect.getConnect();
    }

    public ArrayList<ModeChiTietHoaDon> getdata() throws SQLException{
        ArrayList<ModeChiTietHoaDon> list = new ArrayList<>();
        String query = "SELECT ID , BenhNhanID , BacSiID , LetanID , TenKhachHang , DiaChi , SoDienThoai,  PhuongThucTT ,ThanhTien , NgayTao , NgayThanhToan , TrangThai FROM HoaDon GROUP BY ID , BenhNhanID , BacSiID , LetanID , TenKhachHang , DiaChi , SoDienThoai ,  PhuongThucTT ,ThanhTien , NgayTao , NgayThanhToan , TrangThai";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        while (rs.next()) {
            ModeChiTietHoaDon cthd = new ModeChiTietHoaDon();
            cthd.setMahoadon(rs.getInt(1));
            cthd.setBacSiId(rs.getInt(3));
            cthd.setLeTanID(rs.getInt(4));
            cthd.setBenhnhanid(rs.getInt(2));
            cthd.setTenKhachHang(rs.getString(5));
            cthd.setDiaChi(rs.getString(6));
            cthd.setSoDienThoai(rs.getString(7));
            cthd.setPhuongThucTT(rs.getString(8));
            cthd.setThanhtien(rs.getDouble(9));
            cthd.setNgaytao(rs.getString(10));
            cthd.setNgaythanhtoan(rs.getString(11));
            cthd.setTrangThaiText(rs.getString(12));
//            cthd.setId(rs.getInt(16));
//            cthd.setMadichvu(rs.getInt(18));
//            cthd.setTendichvu(rs.getString(19));
//            cthd.setMota(rs.getString(20));
//            cthd.setDonvitinh(rs.getString(21));
//            cthd.setDongia(rs.getDouble(23));
//            cthd.setSoluong(rs.getInt(22));
//            cthd.setThanhtienchitiet(rs.getString(24));
            list.add(cthd);
        }
        return list;
    }

    public ArrayList<ModeChiTietHoaDon> tim(int idcantim, String tenKhachHang, String soDienThoai) throws SQLException {
        ArrayList<ModeChiTietHoaDon> list = new ArrayList<>();
        StringBuilder query = new StringBuilder(
            "SELECT cthd.HoaDonID, hd.BacSiID, hd.LetanID, hd.BenhNhanID, hd.TenKhachHang, hd.DiaChi, hd.SoDienThoai, hd.PhuongThucTT, hd.ThanhTien, hd.NgayTao, hd.NgayThanhToan, hd.TrangThai, cthd.ID, cthd.TenDichVu, cthd.MoTa, cthd.DonViTinh, cthd.DonGia, cthd.SoLuong, cthd.ThanhTien " +
            "FROM HoaDon hd INNER JOIN ChiTietHoaDon cthd ON hd.ID = cthd.HoaDonID WHERE "
        );

        boolean hasCondition = false;
        if (idcantim != 0) {
            query.append("hd.ID = ?");
            hasCondition = true;
        }
        if (tenKhachHang != null && !tenKhachHang.isEmpty()) {
            if (hasCondition) query.append(" AND ");
            query.append("hd.TenKhachHang LIKE ?");
            hasCondition = true;
        }
        if (soDienThoai != null && !soDienThoai.isEmpty()) {
            if (hasCondition) query.append(" AND ");
            query.append("hd.SoDienThoai LIKE ?");
        }

        try {
            PreparedStatement ps = conn.prepareStatement(query.toString());
            int paramIndex = 1;

            if (idcantim != 0) {
                ps.setInt(paramIndex++, idcantim);
            }
            if (tenKhachHang != null && !tenKhachHang.isEmpty()) {
                ps.setString(paramIndex++, "%" + tenKhachHang + "%");
            }
            if (soDienThoai != null && !soDienThoai.isEmpty()) {
                ps.setString(paramIndex++, "%" + soDienThoai + "%");
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ModeChiTietHoaDon cthd = new ModeChiTietHoaDon();
                cthd.setMahoadon(rs.getInt("HoaDonID"));
                cthd.setBacSiId(rs.getInt("BacSiID"));
                cthd.setLeTanID(rs.getInt("LetanID"));
                cthd.setBenhnhanid(rs.getInt("BenhNhanID"));
                cthd.setTenKhachHang(rs.getString("TenKhachHang"));
                cthd.setDiaChi(rs.getString("DiaChi"));
                cthd.setSoDienThoai(rs.getString("SoDienThoai"));
                cthd.setPhuongThucTT(rs.getString("PhuongThucTT"));
                cthd.setThanhtien(rs.getDouble("ThanhTien"));
                cthd.setNgaytao(rs.getString("NgayTao"));
                cthd.setNgaythanhtoan(rs.getString("NgayThanhToan"));
                cthd.setTrangThaiText(rs.getString("TrangThai"));
                cthd.setId(rs.getInt("ID"));
                cthd.setTendichvu(rs.getString("TenDichVu"));
                cthd.setMota(rs.getString("MoTa"));
                cthd.setDonvitinh(rs.getString("DonViTinh"));
                cthd.setDongia(rs.getDouble("DonGia"));
                cthd.setSoluong(rs.getInt("SoLuong"));
                cthd.setThanhtienchitiet(rs.getString("ThanhTien"));

                list.add(cthd);
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e);
        }
        return list;
    }

    public ArrayList<ModeChiTietHoaDon> timtrangthai(String trangthaicantim) throws SQLException {
        ArrayList<ModeChiTietHoaDon> list = new ArrayList<>();
        String query = "SELECT cthd.HoaDonID, hd.BacSiID, hd.LetanID, hd.BenhNhanID, hd.TenKhachHang, hd.DiaChi, hd.SoDienThoai, hd.PhuongThucTT, hd.ThanhTien, hd.NgayTao, hd.NgayThanhToan, hd.TrangThai, cthd.ID, cthd.TenDichVu, cthd.MoTa, cthd.DonViTinh, cthd.DonGia, cthd.SoLuong, cthd.ThanhTien FROM HoaDon hd INNER JOIN ChiTietHoaDon cthd ON hd.ID = cthd.HoaDonID WHERE hd.TrangThai = ?";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, trangthaicantim);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ModeChiTietHoaDon cthd = new ModeChiTietHoaDon();
                cthd.setMahoadon(rs.getInt("HoaDonID"));
                cthd.setBacSiId(rs.getInt("BacSiID"));
                cthd.setLeTanID(rs.getInt("LetanID"));
                cthd.setBenhnhanid(rs.getInt("BenhNhanID"));
                cthd.setTenKhachHang(rs.getString("TenKhachHang"));
                cthd.setDiaChi(rs.getString("DiaChi"));
                cthd.setSoDienThoai(rs.getString("SoDienThoai"));
                cthd.setPhuongThucTT(rs.getString("PhuongThucTT"));
                cthd.setThanhtien(rs.getDouble("ThanhTien"));
                cthd.setNgaytao(rs.getString("NgayTao"));
                cthd.setNgaythanhtoan(rs.getString("NgayThanhToan"));
                cthd.setTrangThaiText(rs.getString("TrangThai"));
                cthd.setId(rs.getInt("ID"));
                cthd.setTendichvu(rs.getString("TenDichVu"));
                cthd.setMota(rs.getString("MoTa"));
                cthd.setDonvitinh(rs.getString("DonViTinh"));
                cthd.setDongia(rs.getDouble("DonGia"));
                cthd.setSoluong(rs.getInt("SoLuong"));
                cthd.setThanhtienchitiet(rs.getString("ThanhTien"));

                list.add(cthd);
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e);
        }

        return list;
    }
 


    public ArrayList<ModeChiTietHoaDon> timTheoNgay(java.sql.Date startDate, java.sql.Date endDate) {
    ArrayList<ModeChiTietHoaDon> list = new ArrayList<>();
    String sql = """
                  SELECT ID, BenhNhanID, BacSiID, LeTanID, TenKhachHang, DiaChi, SoDienThoai, PhuongThucTT, 
                         ThanhTien, NgayTao, NgayThanhToan, TrangThai
                  FROM HoaDon
                  WHERE NgayThanhToan BETWEEN ? AND ?;
                 """;
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setDate(1, startDate);
        ps.setDate(2, endDate);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ModeChiTietHoaDon cthd = new ModeChiTietHoaDon();
            cthd.setId(rs.getInt("ID"));  // Assuming 'ID' is the primary key
            cthd.setBenhnhanid(rs.getInt("BenhNhanID"));
            cthd.setBacSiId(rs.getInt("BacSiID"));
            cthd.setLeTanID(rs.getInt("LeTanID"));
            cthd.setTenKhachHang(rs.getString("TenKhachHang"));
            cthd.setDiaChi(rs.getString("DiaChi"));
            cthd.setSoDienThoai(rs.getString("SoDienThoai"));
            cthd.setPhuongThucTT(rs.getString("PhuongThucTT"));
            cthd.setThanhtien(rs.getDouble("ThanhTien"));
            cthd.setNgaytao(rs.getString("NgayTao"));
            cthd.setNgaythanhtoan(rs.getString("NgayThanhToan"));
            cthd.setTrangThaiText(rs.getString("TrangThai"));

            list.add(cthd);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}
    public ArrayList<ModeChiTietHoaDon> getChiTietHoaDonByHoaDonID(int hoaDonID) throws SQLException {
                ArrayList<ModeChiTietHoaDon> list = new ArrayList<>();
                String sql = "SELECT * FROM ChiTietHoaDon WHERE HoaDonID = ?";

               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setInt(1, hoaDonID);
               ResultSet rs = ps.executeQuery();

               while (rs.next()) {
                   ModeChiTietHoaDon cthd = new ModeChiTietHoaDon();
                   cthd.setId(rs.getInt("ID"));
                   cthd.setMahoadon(rs.getInt("HoaDonID"));
                   cthd.setMadichvu(rs.getInt("DichVuID"));
                   cthd.setTendichvu(rs.getString("TenDichVu"));
                   cthd.setMota(rs.getString("MoTa"));
                   cthd.setDonvitinh(rs.getString("DonViTinh"));
                   cthd.setSoluong(rs.getInt("SoLuong"));
                   cthd.setDongia(rs.getDouble("DonGia"));
                   cthd.setThanhtien(rs.getDouble("ThanhTien"));                  
                   cthd.setTrangThaiText(rs.getString("TrangThai"));
                   list.add(cthd);
               }

           

           return list;
        }

}
