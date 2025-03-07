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
public class ReposBenhAn {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public ArrayList<BenhAn> getall() {
        sql = "  select*from BenhAn";
        ArrayList<BenhAn> list = new ArrayList<>();
        try {
            con = DBConnect.getConnect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id;
                int mabenhnhan;
                int mabacsi;
                String chandoan;
                String dieutri;
                String ngaykham;
                String ngaylapbenhan;
                String mota;
                String trangthai;
                id = rs.getInt(1);
                mabenhnhan = rs.getInt(2);
                mabacsi = rs.getInt(3);
                chandoan = rs.getString(4);
                dieutri = rs.getString(5);
                ngaykham = rs.getString(6);
                ngaylapbenhan = rs.getString(7);
                mota = rs.getString(8);
                trangthai = rs.getString(9);
                BenhAn m = new BenhAn(id, mabenhnhan, mabacsi, chandoan, dieutri, ngaykham, ngaylapbenhan, mota, trangthai);
                list.add(m);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int them(BenhAn m) {
        sql = "INSERT INTO [dbo].[BenhAn]\n"
                + "           ([BenhNhanID]\n"
                + "           ,[BacSiID]\n"
                + "           ,[ChanDoan]\n"
                + "           ,[DieuTri]\n"
                + "           ,[NgayKham]\n"
                + "           ,[NgayLapBenhAn]\n"
                + "           ,[MoTa]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnect();
            ps = con.prepareStatement(sql);

            ps.setObject(1, m.getMabenhnhan());
            ps.setObject(2, m.getMabacsi());
            ps.setObject(3, m.getChandoan());
            ps.setObject(4, m.getDieutri());
            ps.setObject(5, m.getNgaykham());
            ps.setObject(6, m.getNgaylapbenhan());
            ps.setObject(7, m.getMota());
            ps.setObject(8, m.getTrangthai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int sua(int id, BenhAn m) {
        sql = "UPDATE [dbo].[BenhAn]\n"
                + "   SET [BenhNhanID] = ?\n"
                + "      ,[BacSiID] = ?\n"
                + "      ,[ChanDoan] = ?\n"
                + "      ,[DieuTri] = ?\n"
                + "      ,[NgayKham] = ?\n"
                + "      ,[NgayLapBenhAn] = ?\n"
                + "      ,[MoTa] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE ID = ?";
        try {
            con = DBConnect.getConnect();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getMabenhnhan());
            ps.setObject(2, m.getMabacsi());
            ps.setObject(3, m.getChandoan());
            ps.setObject(4, m.getDieutri());
            ps.setObject(5, m.getNgaykham());
            ps.setObject(6, m.getNgaylapbenhan());
            ps.setObject(7, m.getMota());
            ps.setObject(8, m.getTrangthai());
            ps.setObject(9, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int xoa(int id) {
        sql = "DELETE FROM [dbo].[BenhAn]\n"
                + "      WHERE ID = ?";
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

    public ArrayList<BenhAn> tim(String idcantim) {
        sql = "SELECT [ID]\n"
                + "      ,[BenhNhanID]\n"
                + "      ,[BacSiID]\n"
                + "      ,[ChanDoan]\n"
                + "      ,[DieuTri]\n"
                + "      ,[NgayKham]\n"
                + "      ,[NgayLapBenhAn]\n"
                + "      ,[MoTa]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[BenhAn] WHERE ID LIKE ?";
        ArrayList<BenhAn> list_BenhAn = new ArrayList<>();
        try {
            con = DBConnect.getConnect();
            ps = con.prepareStatement(sql);
            ps.setObject(1, '%' + idcantim + '%');
            rs = ps.executeQuery();
            while (rs.next()) {
                int id, mabenhnhan, mabacsi;
                String chandoan;
                String dieutri;
                String ngaykham;
                String ngaylapbenhan;
                String mota;
                String trangthai;
                id = rs.getInt(1);
                mabenhnhan = rs.getInt(2);
                mabacsi = rs.getInt(3);
                chandoan = rs.getString(4);
                dieutri = rs.getString(5);
                ngaykham = rs.getString(6);
                ngaylapbenhan = rs.getString(7);
                mota = rs.getString(8);
                trangthai = rs.getString(9);
                BenhAn m = new BenhAn(id, mabenhnhan, mabacsi, chandoan, dieutri, ngaykham, ngaylapbenhan, mota, trangthai);
                list_BenhAn.add(m);
            }
            return list_BenhAn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public BenhAn getBenhAnByMaBenhNhan(String maBenhNhan) {
    sql = "SELECT [ID], [BenhNhanID], [BacSiID], [ChanDoan], [DieuTri], [NgayKham], [NgayLapBenhAn], [MoTa], [TrangThai] " +
          "FROM [dbo].[BenhAn] WHERE [BenhNhanID] = ?";
    try {
        con = DBConnect.getConnect();
        ps = con.prepareStatement(sql);
        ps.setString(1, maBenhNhan);
        rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("ID");
            int benhNhanID = rs.getInt("BenhNhanID");
            int bacSiID = rs.getInt("BacSiID");
            String chanDoan = rs.getString("ChanDoan");
            String dieuTri = rs.getString("DieuTri");
            String ngayKham = rs.getString("NgayKham");
            String ngayLapBenhAn = rs.getString("NgayLapBenhAn");
            String moTa = rs.getString("MoTa");
            String trangThai = rs.getString("TrangThai");

            return new BenhAn(id, benhNhanID, bacSiID, chanDoan, dieuTri, ngayKham, ngayLapBenhAn, moTa, trangThai);
        } else {
            return null;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}

}
