/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.repository;

import com.poly.database.DBConnect;
import com.poly.entity.BacSi;
import com.poly.entity.LichHen;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class ReposLichHen {
    public List<LichHen> getAll() {
        List<LichHen> list = new ArrayList<>();
        String sql = """
                    SELECT 
                          MaBenhNhan
                          ,MaBacSi
                          ,NgayHen
                          ,GioHen
                          ,NgayDatLich
                          ,TrangThai
                    FROM LichHen
                    """;
        try (Connection con = DBConnect.getConnect();
             PreparedStatement ps = con.prepareStatement(sql)) {      
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LichHen lh = new LichHen();
                lh.setMaBenhNhan(rs.getInt("MaBenhNhan"));
                lh.setMaBacSi(rs.getInt("MaBacSi"));
                lh.setNgayhen(rs.getString("NgayHen"));
                lh.setGiohen(rs.getString("GioHen"));
                lh.setNgaydatlich(rs.getDate("NgayDatLich"));
                lh.setTrang_thai(rs.getString("TrangThai"));
                
                list.add(lh);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
      
 
}
