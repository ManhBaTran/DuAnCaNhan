/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.repository;

import com.poly.database.DBConnect;
import com.poly.entity.BenhNhan;
import com.poly.entity.LichHen;


import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class RepoBenhNhan {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public ArrayList<BenhNhan> getall() {
        sql = """
              SELECT  *
                    
                FROM [dbo].[BenhNhan]
              """;
        ArrayList<BenhNhan> list = new ArrayList<>();
        try {
            con = DBConnect.getConnect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id_benhnhan;
                String ten;
                String ngaysinh;
                String diachi;
                String Sodienthoai;
                String email;
                String gioitinh;
                String ngaytao;
                String trangthai;
                String matKhau;
                id_benhnhan = rs.getInt(1);
                ten = rs.getString(2);
                ngaysinh = rs.getString(3);
               diachi = rs.getString(4);
                  matKhau = rs.getString(5);
                Sodienthoai = rs.getString(6);
                email = rs.getString(7);
                gioitinh = rs.getString(8);
                ngaytao = rs.getString(9);
                trangthai = rs.getString(10);

                BenhNhan m = new BenhNhan(id_benhnhan, ten, ngaysinh, diachi, trangthai, Sodienthoai, email, gioitinh, ngaytao, trangthai);
                list.add(m);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean addBenhNhan(BenhNhan benhNhan) {
        String sql = "INSERT INTO BenhNhan (Ten, NgaySinh, DiaChi, SoDienThoai, MatKhau, Email, GioiTinh, TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DBConnect.getConnect();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, benhNhan.getTen());
            ps.setDate(2, java.sql.Date.valueOf(benhNhan.getNgaysinh()));
            ps.setString(3, benhNhan.getDiachi());
            ps.setString(4, benhNhan.getSodienthoai());
            ps.setString(5, benhNhan.getMatKhau());
            ps.setString(6, benhNhan.getEmail());
            ps.setString(7, benhNhan.getGioitinh());
            ps.setString(8, benhNhan.getTrangthai());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
