/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.repository;

import com.poly.database.DBConnect;
import com.poly.entity.HoaDon;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author manh9
 */
public class RepoHoaDon {
    public List<HoaDon> getAll(){
        List<HoaDon> list =  new ArrayList<>();
        String sql = """
                     SELECT  
                           [MaBenhNhan]
                           ,[MaNguoiDung]
                           ,[MaBacSi]
                           ,[TenKhachHang]
                           ,[DiaChi]
                           ,[SoDienThoai]
                           ,[Email]
                           ,[PhuongThucTT]
                           ,[TienKhDua]
                           ,[TienThua]
                           ,[ThanhTien]
                           ,[NgayTao]
                           ,[NgayThanhToan]
                           ,[TrangThai]
                       FROM [dbo].[HoaDon]
                     """;
        try (Connection con = DBConnect.getConnect();
                PreparedStatement ps = con.prepareStatement(sql)
                ){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDon hd = new HoaDon();
                hd.setMaBenhNhan(rs.getInt(1));
                hd.setMaNguoiDung(rs.getInt(2));
                hd.setMaBacSi(rs.getInt(3));
                hd.setTenKhachHang(rs.getString(4));
                hd.setDiaChi(rs.getString(5));
                hd.setSoDienThoai(rs.getString(6));
                hd.setEmail(rs.getString(7));
                hd.setPhuongThucTT(rs.getString(8));
                hd.setTienKhDua(rs.getFloat(9));
                hd.setTienThua(rs.getFloat(10));
                hd.setThanhTien(rs.getFloat(11));
                hd.setNgayTao(rs.getDate(12));
                hd.setNgayThanhToan(rs.getDate(13));
                hd.setTrangThai(rs.getString(14));
                
                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
