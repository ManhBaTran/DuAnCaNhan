package com.poly.repository;

import com.poly.database.DBConnect;
import com.poly.entity.BenhAn;
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
public class ReposBenhAn {

    public List<BenhAn> getAll() {
        List<BenhAn> benhAnList = new ArrayList<>();
        String sql = """
                    SELECT  
                            [MaBenhNhan]
                            ,[MaBacSi]
                            ,[ChanDoan]
                            ,[DieuTri]
                            ,[NgayKham]
                            ,[NgayLapBenhAn]
                            ,[MoTa]
                            ,[TrangThai]
                        FROM [dbo].[BenhAn]
                    """;
        try (Connection conn = DBConnect.getConnect();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                BenhAn benhAn = new BenhAn();
                benhAn.setMaBenhNhan(rs.getInt("MaBenhNhan"));
                benhAn.setMaBacSi(rs.getInt("MaBacSi"));
                benhAn.setChanDoan(rs.getString("ChanDoan"));
                benhAn.setDieuTri(rs.getString("DieuTri"));
                benhAn.setNgayKham(rs.getDate("NgayKham"));
                benhAn.setNgayLapBenhAn(rs.getDate("NgayLapBenhAn"));
                benhAn.setMoTa(rs.getString("MoTa"));
                benhAn.setTrangThai(rs.getString("TrangThai"));
                
                benhAnList.add(benhAn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return benhAnList;
    }
}
