/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.ph49507;

import com.poly.database.DBConnect;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author admin
 */
public class ReposLichHen {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public ArrayList<LichHen> getAll() {
        sql = "select * from LichHen";
        ArrayList<LichHen> list = new ArrayList<>();
        try {
            con = DBConnect.getConnect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id;
                int mabenhnhan;
                int mabacsi;
                String ngayhen;
                String giohen;
                String ngaydatlich;
                String trang_thai;

                id = rs.getInt(1);
                mabenhnhan = rs.getInt(2);
                mabacsi = rs.getInt(3);
                ngayhen = rs.getString(4);
                giohen = rs.getString(5);
                ngaydatlich = rs.getString(6);
                trang_thai = rs.getString(7);

                LichHen m = new LichHen(id, mabenhnhan, mabacsi, ngayhen, giohen, ngaydatlich, trang_thai);
                list.add(m);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int them(LichHen m) {
        sql = "INSERT INTO [dbo].[LichHen]\n" +
"           ([BenhNhanID]\n" +
"           ,[BacSiID]\n" +
"           ,[NgayHen]\n" +
"           ,[GioHen]\n" +
"           ,[NgayDatLich]\n" +
"           ,[TrangThai])\n" +
"     VALUES\n" +
"           (?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnect();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getMabenhnhan());
            ps.setObject(2, m.getMabacsi());
            ps.setObject(3, m.getNgayhen());
            ps.setObject(4, m.getGiohen());
            ps.setObject(5, m.getNgaydatlich());
            ps.setObject(6, m.getTrang_thai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }  
    }

    public int sua(int id, LichHen m) {
        sql = "UPDATE [dbo].[LichHen]\n" +
"   SET [BenhNhanID] = ?\n" +
"      ,[BacSiID] = ?\n" +
"      ,[NgayHen] = ?\n" +
"      ,[GioHen] = ?\n" +
"      ,[NgayDatLich] = ?\n" +
"      ,[TrangThai] = ?\n" +
" WHERE ID = ?";
        try {
            con = DBConnect.getConnect();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getMabenhnhan());
            ps.setObject(2, m.getMabacsi());
            ps.setObject(3, m.getNgayhen());
            ps.setObject(4, m.getGiohen());
            ps.setObject(5, m.getNgaydatlich());
            ps.setObject(6, m.getTrang_thai());
            ps.setObject(7, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int xoa(int id) {
        sql = "DELETE FROM [dbo].[LichHen]\n" +
"      WHERE ID = ?";
        try {
            con = DBConnect.getConnect();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public ArrayList<LichHen> tim(String idcantim){
        sql = "select * from LichHen where id like ?";
        ArrayList<LichHen> list_LichHen = new ArrayList<>();
        try {
            con = DBConnect.getConnect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id;
                int mabenhnhan;
                int mabacsi;
                String ngayhen;
                String giohen;
                String ngaydatlich;
                String trang_thai;

                id = rs.getInt(1);
                mabenhnhan = rs.getInt(2);
                mabacsi = rs.getInt(3);
                ngayhen = rs.getString(4);
                giohen = rs.getString(5);
                ngaydatlich = rs.getString(6);
                trang_thai = rs.getString(7);

                LichHen m = new LichHen(id, mabenhnhan, mabacsi, ngayhen, giohen, ngaydatlich, trang_thai);
                list_LichHen.add(m);
            }
            return list_LichHen;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
