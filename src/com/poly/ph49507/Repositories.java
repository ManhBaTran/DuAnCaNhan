/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.ph49507;

import java.sql.*;
import java.util.ArrayList;
import com.poly.database.DBConnect;

/**
 *
 * @author admin
 */
public class Repositories {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public ArrayList<Model_BenhNhan> getall() {
        sql = "SELECT [ID]\n" +
"      ,[Ten]\n" +
"      ,[NgaySinh]\n" +
"      ,[DiaChi]\n" +
"      ,[SoDienThoai]\n" +
"      ,[Email]\n" +
"      ,[GioiTinh]\n" +
"      ,[NgayTao]\n" +
"      ,[TrangThai]\n" +
"  FROM [dbo].[BenhNhan]";
        ArrayList<Model_BenhNhan> list = new ArrayList<>();
        try {
            con = DBConnect.getConnect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id;
                String ten;
                String ngaysinh;
                String diachi;
                String sdt;
                String email;
       
                String gioitinh;
                String ngaytao;
                String trangthai;
                
                id = rs.getString(1);
                ten = rs.getString(2);
                ngaysinh = rs.getString(3);
                diachi = rs.getString(4);
                sdt = rs.getString(5);
                email = rs.getString(6);
                
                gioitinh = rs.getString(7);
                ngaytao = rs.getString(8);
                trangthai = rs.getString(9);
                

                Model_BenhNhan m = new Model_BenhNhan(id, ten, ngaysinh, diachi, sdt, email, gioitinh, ngaytao, trangthai);
                list.add(m);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Model_BenhNhan> timkiem(String tencantim) {
        sql = "SELECT [ID]\n" +
"      ,[Ten]\n" +
"      ,[NgaySinh]\n" +
"      ,[DiaChi]\n" +
"      ,[SoDienThoai]\n" +
"      ,[Email]\n" +
"      ,[GioiTinh]\n" +
"      ,[NgayTao]\n" +
"      ,[TrangThai]\n" +
"  FROM [dbo].[BenhNhan] WHERE TEN LIKE ?";
        ArrayList<Model_BenhNhan> list = new ArrayList<>();
        try {
            con = DBConnect.getConnect();
            ps = con.prepareStatement(sql);
            ps.setObject(1, '%' + tencantim + '%');
            rs = ps.executeQuery();
            while (rs.next()) {
                String id;
                String ten;
                String ngaysinh;
                String diachi;
                String sdt;
                String email;
                String gioitinh;
                String ngaytao;
                String trangthai;
                id = rs.getString(1);
                ten = rs.getString(2);
                ngaysinh = rs.getString(3);
                diachi = rs.getString(4);
                sdt = rs.getString(5);
                email = rs.getString(6);
                gioitinh = rs.getString(7);
                ngaytao = rs.getString(8);
                trangthai = rs.getString(9);
                Model_BenhNhan m = new Model_BenhNhan(id, ten, ngaysinh, diachi, sdt, email, gioitinh, ngaytao, trangthai);
                list.add(m);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
