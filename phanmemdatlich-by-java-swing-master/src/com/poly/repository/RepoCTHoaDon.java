/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.repository;


import com.poly.database.DBConnect;
import com.poly.entity.ChiTietHoaDon;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author ASUS
 */
public class RepoCTHoaDon { 
    public ArrayList<ChiTietHoaDon> getdata()  {
        ArrayList<ChiTietHoaDon> list = new ArrayList<>();
        String sql = """
                       SELECT 
                             [MaHoaDon]
                             ,[MaDichVu]
                             ,[TenDichVu]
                             ,[MoTa]
                             ,[DonViTinh]
                             ,[SoLuong]
                             ,[DonGia]
                             ,[ThanhTien]
                             ,[TrangThai]
                         FROM [dbo].[ChiTietHoaDon]
                       """;
        try (Connection con = DBConnect.getConnect();
                PreparedStatement ps = con.prepareStatement(sql)
                ){
            ResultSet rs = ps.executeQuery();
             while (rs.next()) {
            ChiTietHoaDon cthd = new ChiTietHoaDon();
            cthd.setMahoadon(rs.getInt(1));
            cthd.setMadichvu(rs.getInt(2));
            cthd.setTenDichVu(rs.getString(3));
            cthd.setMoTaDichVu(rs.getString(4));
            cthd.setDonViTinh(rs.getString(5));
            cthd.setSoluong(rs.getInt(6));
            cthd.setDongia(rs.getFloat(7));
            cthd.setThanhTien(rs.getFloat(8));        
            cthd.setTrangthai(rs.getString(9));
            
            list.add(cthd);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
}
