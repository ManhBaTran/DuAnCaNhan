/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.ph49571;

import com.poly.database.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CTHoaDonServices {

    private Connection conn;

    public CTHoaDonServices() {
        conn = DBConnect.getConnect();
    }

    public ArrayList<ModeChiTietHoaDon> getdata() throws SQLException {
        ArrayList<ModeChiTietHoaDon> list = new ArrayList<>();
        String query = "select*from ChiTietHoaDon";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        while (rs.next()) {
            ModeChiTietHoaDon cthd = new ModeChiTietHoaDon();
            cthd.setId(rs.getInt(1));
            cthd.setMadichvu(rs.getInt(3));
            cthd.setMahoadon(rs.getInt(2));
            cthd.setTendichvu(rs.getString(4));
            cthd.setMota(rs.getString(5));
            cthd.setDonvitinh(rs.getString(6));
            cthd.setSoluong(rs.getInt(7));
            cthd.setDongia(rs.getDouble(8));
            cthd.setThanhtien(rs.getDouble(8));
            cthd.setTrangthai(rs.getString(10));

            list.add(cthd);
        }
        return list;
    }

    public List<ModeChiTietHoaDon> getAllText() {
        List<ModeChiTietHoaDon> list = new ArrayList<>();
        String sql = "select BacSiID, leTanID, tenKhachHang, diaChi, SoDienThoai, Email, PhuongThucTT, TienKhDua, tienThua,thanhTien, TrangThai from HoaDon";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ModeChiTietHoaDon model = new ModeChiTietHoaDon();
                model.setBacSiId(rs.getInt(1));
                model.setLeTanID(rs.getInt(2));
                model.setTenKhachHang(rs.getString(3));
                model.setDiaChi(rs.getString(4));
                model.setSoDienThoai(rs.getString(5));
                model.setEmail(rs.getString(6));
                model.setPhuongThucTT(rs.getString(7));
                model.setTienKhDua(rs.getDouble(8));
                model.setTienThua(rs.getDouble(9));
                model.setThanhtien(rs.getDouble(10));
                model.setTrangThaiText(rs.getString(11));
                list.add(model);
            }

        } catch (Exception e) {
            System.out.println("hien thi text SQL " + e.getMessage());
        }
        return list;
    }
    public ArrayList<ModeChiTietHoaDon> tim(int idcantim) throws SQLException{
        ArrayList<ModeChiTietHoaDon> list = new ArrayList<>();
        String query = "SELECT ID , HoaDonID , DichVuID , TenDichVu , MoTa , DonViTinh , SoLuong , DonGia , ThanhTien , NgayThanhToan , TrangThai FROM ChiTietHoaDon WHERE ID = ?";
        try {
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idcantim);
        ResultSet rs  = ps.executeQuery();
        while (rs.next()) {
            ModeChiTietHoaDon cthd = new ModeChiTietHoaDon();
            cthd.setId(rs.getInt(1));
            cthd.setMahoadon(rs.getInt(2));
            cthd.setMadichvu(rs.getInt(3));
            cthd.setTendichvu(rs.getString(4));
            cthd.setMota(rs.getString(5));
            cthd.setDonvitinh(rs.getString(6));
            cthd.setSoluong(rs.getInt(7));
            cthd.setDongia(rs.getDouble(8));
            cthd.setThanhtien(rs.getDouble(9));
            cthd.setTrangthai(rs.getString(10));
            list.add(cthd);
        }
        } catch (Exception e) {
            System.out.println("loi: "+e);
        }
        return list;
    }

}
