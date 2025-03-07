/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.repository;

import com.poly.database.DBConnect;
import com.poly.entity.TrangChu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author manh9
 */
public class RepoTrangChu {
    
    public List<TrangChu> getAllTT() {
        List<TrangChu> lichHenList = new ArrayList<>();
        String sql = """
                          SELECT    
                         BenhNhan.Ten AS TenBenhNhan,  
                         BacSi.Ten AS TenBacSi,
                         LichHen.NgayHen AS NgayHen,
                         LichHen.GioHen AS GioHen,
                         LichHen.NgayDatLich AS NgayDatLich,
                     	LichHen.TrangThai AS TrangThai
                     FROM LichHen
                     INNER JOIN BenhNhan ON LichHen.BenhNhanID = BenhNhan.ID
                     INNER JOIN BacSi ON LichHen.BacSiID = BacSi.ID;
                     """;

        try (Connection con = DBConnect.getConnect();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                TrangChu lichHenDTO = new TrangChu();
                lichHenDTO.setTenBenhNhan(rs.getString("TenBenhNhan"));
                lichHenDTO.setTenBacSi(rs.getString("TenBacSi"));
                lichHenDTO.setNgayHen(rs.getDate("NgayHen"));
                lichHenDTO.setGioHen(rs.getString("GioHen"));
                lichHenDTO.setNgayDatLich(rs.getDate("NgayDatLich"));
                lichHenDTO.setTrangThai(rs.getString("TrangThai"));
                lichHenList.add(lichHenDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lichHenList;
    }
    
     public List<TrangChu> getAllBs() {
        List<TrangChu> bacsiList = new ArrayList<>();
        String sql = """
                       SELECT [ID]
                           ,[Ten]
                            ,[SoNamKinhNghiem]            
                           ,[ChuyenKhoa]
                     	  ,[SoDienThoai]
                           ,[TrangThai]
                       FROM [dbo].[BacSi]
                     """;

        try (Connection con = DBConnect.getConnect();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                TrangChu bacsiDTO = new TrangChu();
                bacsiDTO.setId(rs.getLong("Id"));
                bacsiDTO.setTenBacSi(rs.getString("Ten"));
                bacsiDTO.setSoNamKinhNghiem(rs.getInt("SoNamKinhNghiem"));
                bacsiDTO.setChuyenKhoa(rs.getString("ChuyenKhoa"));
                bacsiDTO.setTrangThai(rs.getString("TrangThai"));
                 
                bacsiList.add(bacsiDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return bacsiList;
    }
}
