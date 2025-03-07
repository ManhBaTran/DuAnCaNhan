/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.ph49571;

import com.google.zxing.qrcode.decoder.Mode;
import com.poly.database.DBConnect;
import com.poly.ph49571.ModeDichVu;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class DichVuServices {
    private Connection conn;
    
    public DichVuServices() {
        conn = DBConnect.getConnect();
    }
    
    public ArrayList<ModeDichVu> getdata() throws SQLException{
        ArrayList<ModeDichVu> list = new ArrayList<>();
        String query = " select*from DichVu";
        Statement stm  = conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        while (rs.next()) {
            ModeDichVu dv = new ModeDichVu();
            dv.setStt(rs.getInt(1));
            dv.setTen_dichvu(rs.getString(2));
            dv.setMota(rs.getString(3));
            dv.setChiphi(rs.getDouble(4));
            dv.setSoluong(rs.getInt(5));
            dv.setDonvitinh(rs.getString(6));
            dv.setNgaytao(rs.getString(7));
            dv.setTrangthai(rs.getString(8));
            list.add(dv);
        }
        return list;
    }
    public void add(ModeDichVu dv) throws SQLException {
        String query = "INSERT INTO DichVu (Ten,MoTa,ChiPhi,SoLuong,DonViTinh,NgayTao,TrangThai) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, dv.getTen_dichvu());
        ps.setString(2, dv.getMota());
        ps.setDouble(3, dv.getChiphi());
        ps.setInt(4, dv.getSoluong());
        ps.setString(5, dv.getDonvitinh());
        ps.setString(6,dv.getNgaytao());
        ps.setString(7, dv.getTrangthai());
        ps.execute();
    }
    public void remove (ModeDichVu dv) throws SQLException {
        String query =" DELETE FROM DichVu WHERE ID = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, dv.getStt());
        
        ps.execute();
    }
    public void update(ModeDichVu dv) throws SQLException{
        String query = "UPDATE DichVu SET Ten = ? , MoTa = ?, ChiPhi = ?, SoLuong = ? , DonViTinh = ? , NgayTao = ? , TrangThai =  ? WHERE ID =  ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, dv.getTen_dichvu());
        ps.setString(2, dv.getMota());
        ps.setDouble(3, dv.getChiphi());
        ps.setInt(4, dv.getSoluong());
        ps.setString(5, dv.getDonvitinh());
        ps.setString(6, dv.getNgaytao());
        ps.setString(7, dv.getTrangthai());
        ps.setInt(8 , dv.getStt());
        
        ps.executeUpdate();
    }
    public ArrayList<ModeDichVu> tim(int idcantim) throws SQLException{
        ArrayList<ModeDichVu> list = new ArrayList<>();
        String query = "SELECT  ID ,Ten , MoTa , ChiPhi ,SoLuong , DonViTinh , NgayTao , TrangThai FROM DichVu WHERE ID = ?";
        try {
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idcantim);
        ResultSet rs  = ps.executeQuery();
        while (rs.next()) {
            
            ModeDichVu dv = new ModeDichVu();
            dv.setStt(rs.getInt(1));
            dv.setTen_dichvu(rs.getString(2));
            dv.setMota(rs.getString(3));
            dv.setChiphi(rs.getInt(4));
            dv.setSoluong(rs.getInt(5));
            dv.setDonvitinh(rs.getString(6));
            dv.setNgaytao(rs.getString(7));
            dv.setTrangthai(rs.getString(8));
            list.add(dv);
            
        }
        } catch (Exception e) {
            System.out.println("loi: "+e);
            
        }
        System.out.println("tim - Size of list: " + list.size());
            for (ModeDichVu dv : list) {
            System.out.println(dv);
        }
        return list;
    }
    public ArrayList<ModeDichVu> timcb(String trangthaicantim) throws SQLException{
            ArrayList<ModeDichVu> list = new ArrayList<>();
        String query = "SELECT  ID ,Ten , MoTa , ChiPhi ,SoLuong , DonViTinh , NgayTao , TrangThai FROM DichVu WHERE TrangThai = ?";
        try {
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, trangthaicantim);
        ResultSet rs  = ps.executeQuery();
        while (rs.next()) {
            
            ModeDichVu dv = new ModeDichVu();
            dv.setStt(rs.getInt(1));
            dv.setTen_dichvu(rs.getString(2));
            dv.setMota(rs.getString(3));
            dv.setChiphi(rs.getInt(4));
            dv.setSoluong(rs.getInt(5));
            dv.setDonvitinh(rs.getString(6));
            dv.setNgaytao(rs.getString(7));
            dv.setTrangthai(rs.getString(8));
            list.add(dv);
        }
        } catch (Exception e) {
            System.out.println("loi: "+e);
        }
        return list;
    }    
    public ArrayList<ModeDichVu> timTheoNgay(java.sql.Date startDate, java.sql.Date endDate) {
        ArrayList<ModeDichVu> list = new ArrayList<>();
        String sql = """
                      SELECT * FROM DichVu WHERE NgayTao BETWEEN ? AND ? ;
                     """;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, startDate);
            ps.setDate(2, endDate);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ModeDichVu dv = new ModeDichVu();
                dv.setStt(rs.getInt(1));
                dv.setTen_dichvu(rs.getString(2));
                dv.setMota(rs.getString(3));
                dv.setChiphi(rs.getInt(4));
                dv.setSoluong(rs.getInt(5));
                dv.setDonvitinh(rs.getString(6));
                dv.setNgaytao(rs.getString(7));
                dv.setTrangthai(rs.getString(8));
                list.add(dv);
            }
        } catch (SQLException e) {
            System.out.println("loi: " + e);
        }
        return list;
    }
    public boolean isServiceNameDuplicate(String serviceName) {
        // Thực hiện truy vấn cơ sở dữ liệu để kiểm tra tên dịch vụ đã tồn tại hay chưa
        // Trả về true nếu tên dịch vụ đã tồn tại, ngược lại trả về false
        // Ví dụ giả lập truy vấn SQL:
        String sql = "SELECT COUNT(*) FROM DichVu WHERE Ten = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, serviceName);
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public ArrayList<ModeDichVu> timTheoTen(String tenDichVu) throws SQLException {
        ArrayList<ModeDichVu> list = new ArrayList<>();
        String query = "SELECT ID, Ten, MoTa, ChiPhi, SoLuong, DonViTinh, NgayTao, TrangThai FROM DichVu WHERE Ten LIKE ?";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + tenDichVu + "%"); // Tìm kiếm theo chuỗi có chứa từ khóa
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ModeDichVu dv = new ModeDichVu();
                dv.setStt(rs.getInt(1));
                dv.setTen_dichvu(rs.getString(2));
                dv.setMota(rs.getString(3));
                dv.setChiphi(rs.getDouble(4));
                dv.setSoluong(rs.getInt(5));
                dv.setDonvitinh(rs.getString(6));
                dv.setNgaytao(rs.getString(7));
                dv.setTrangthai(rs.getString(8));
                list.add(dv);
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e);
        }

        System.out.println("timTheoTen - Số lượng kết quả: " + list.size());
        for (ModeDichVu dv : list) {
            System.out.println(dv);
        }
        return list;
    }


}