package com.poly.repository;

import com.poly.database.DBConnect;
import com.poly.entity.LichLamViec;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @authot manh9
 */
public class RepoLichLamViec {
    public List<LichLamViec> getAll() {
        List<LichLamViec> list = new ArrayList<>();
        String sql = """
                    SELECT  
                               [MaBacSi]
                               ,[Ngay]
                               ,[ThoiGianBatDau]
                               ,[ThoiGianKetThuc]
                               ,[GhiChu]
                               ,[CaLamViec]
                               ,[TrangThai]
                               ,[NgayTao]
                           FROM [dbo].[LichLamViec]
                    """;
        try (Connection con = DBConnect.getConnect();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LichLamViec llv = new LichLamViec();
                
                llv.setMaBacSi(rs.getInt(1));
                llv.setNgay(rs.getDate(2));
                llv.setThoi_gian_bat_dau(rs.getTime(3).toLocalTime());
                llv.setThoi_gian_ket_thuc(rs.getTime(4).toLocalTime());
                llv.setGhiChu(rs.getString(5));
                llv.setCaLamViec(rs.getString(6));
                llv.setTrangThai(rs.getString(7));
                llv.setNgayTao(rs.getDate(8));
                
                list.add(llv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
