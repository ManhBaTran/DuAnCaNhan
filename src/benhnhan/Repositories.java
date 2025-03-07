/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package benhnhan;

import java.sql.*;
import java.util.ArrayList;
import benhnhan.DBConnect11;

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
        sql = "SELECT dbo.BenhNhan.ID, dbo.BenhNhan.Ten, dbo.BenhNhan.NgaySinh, dbo.BenhNhan.DiaChi, dbo.BenhNhan.SoDienThoai, dbo.BenhNhan.Email, dbo.BenhNhan.MatKhau, dbo.BenhNhan.GioiTinh, dbo.BenhNhan.NgayTao, dbo.BenhNhan.TrangThai, dbo.BenhAn.ID AS Expr1, \n"
                + "             dbo.BenhAn.BenhNhanID, dbo.BenhAn.BacSiID, dbo.BenhAn.ChanDoan, dbo.BenhAn.DieuTri, dbo.BenhAn.NgayKham, dbo.BenhAn.NgayLapBenhAn, dbo.BenhAn.MoTa, dbo.BenhAn.TrangThai AS Expr2\n"
                + "FROM   dbo.BenhNhan  left JOIN\n"
                + "             dbo.BenhAn ON dbo.BenhNhan.ID = dbo.BenhAn.BenhNhanID";
        ArrayList<Model_BenhNhan> list = new ArrayList<>();
        try {
            con = DBConnect11.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id;
                String ten;
                String ngaysinh;
                String diachi;
                String sdt;
                String email;
                String matkhau;
                String gioitinh;
                String ngaytao;
                String trangthai;
                int IdBenhAn;
                int BenhNhanID;
                int BacSiID;
                String ChuanDoan;
                String DieuTri;
                String NgayKham2;
                String NgayLap2;
                String MoTa2;
                String TrangThai2;
                id = rs.getString(1);
                ten = rs.getString(2);
                ngaysinh = rs.getString(3);
                diachi = rs.getString(4);
                sdt = rs.getString(5);
                email = rs.getString(6);
                matkhau = rs.getString(7);
                gioitinh = rs.getString(8);
                ngaytao = rs.getString(9);
                trangthai = rs.getString(10);
                IdBenhAn = rs.getInt(11);
                BenhNhanID = rs.getInt(12);
                BacSiID = rs.getInt(13);
                ChuanDoan = rs.getString(14);
                DieuTri = rs.getString(15);
                NgayKham2 = rs.getString(16);
                NgayLap2 = rs.getString(17);
                MoTa2 = rs.getString(18);
                TrangThai2 = rs.getString(19);

                Model_BenhNhan m = new Model_BenhNhan(id, ten, ngaysinh, diachi, sdt, email, matkhau, gioitinh, ngaytao, trangthai, IdBenhAn, BenhNhanID, BacSiID, ChuanDoan, DieuTri, NgayKham2, NgayLap2, MoTa2, TrangThai2);
                list.add(m);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Model_benhan> getBA(String Idbenhnhan) {
        ArrayList<Model_benhan> list = new ArrayList<>();
        String sql = "select ID,BenhNhanID,BacSiID,ChanDoan,DieuTri,NgayKham,NgayLapBenhAn,MoTa,TrangThai  from BenhAn where BenhNhanID = ?";
        try (Connection con = DBConnect11.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, Idbenhnhan);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int IdBenhAn;
                int BenhNhanID;
                int BacSiID;
                String ChuanDoan;
                String DieuTri;
                String NgayKham2;
                String NgayLap2;
                String MoTa2;
                String TrangThai2;

                IdBenhAn = rs.getInt("ID");
                BenhNhanID = rs.getInt("BenhNhanID");
                BacSiID = rs.getInt("BacSiID");
                ChuanDoan = rs.getString("ChanDoan");
                DieuTri = rs.getString("DieuTri");
                NgayKham2 = rs.getString("NgayKham");
                NgayLap2 = rs.getString("NgayLapBenhAn");
                MoTa2= rs.getString("MoTa");
                TrangThai2 = rs.getString("TrangThai");
               
                list.add(new Model_benhan(IdBenhAn, BenhNhanID, BacSiID, ChuanDoan, DieuTri, NgayKham2, NgayLap2, MoTa2, TrangThai2));
            }
            return list;

        } catch (Exception e) {

            return null;
        }
    }

    public int them(Model_BenhNhan m) {
        sql = "insert into BenhNhan(Ten,NgaySinh,DiaChi,SoDienThoai,Email,MatKhau,GioiTinh,NgayTao,TrangThai) values (?,?,?,?,?,?,?,?,?)";
        try {
            con = DBConnect11.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getTen());
            ps.setObject(2, m.getNgaysinh());
            ps.setObject(3, m.getDiachi());
            ps.setObject(4, m.getSdt());
            ps.setObject(5, m.getEmail());
            ps.setObject(6, m.getMatkhau());
            ps.setObject(7, m.getGioitinh());
            ps.setObject(8, m.getNgaytao());
            ps.setObject(9, m.getTrangthai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int xoa(int id) {
        sql = "delete from BenhNhan where ID=?";
        try {
            con = DBConnect11.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int sua(Model_BenhNhan m, int id) {
        sql = "update BenhNhan set Ten=?,NgaySinh=?,DiaChi=?,SoDienThoai=?,Email=?,MatKhau=?,GioiTinh=?,NgayTao=?,TrangThai=? where ID=?";
        try {
            con = DBConnect11.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getTen());
            ps.setObject(2, m.getNgaysinh());
            ps.setObject(3, m.getDiachi());
            ps.setObject(4, m.getSdt());
            ps.setObject(5, m.getEmail());
            ps.setObject(6, m.getMatkhau());
            ps.setObject(7, m.getGioitinh());
            ps.setObject(8, m.getNgaytao());
            ps.setObject(9, m.getTrangthai());
            ps.setObject(10, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList<Model_BenhNhan> timkiem(String Id) {
        sql = "select *from BenhNhan where ID like ?";
        ArrayList<Model_BenhNhan> list = new ArrayList<>();
        try {
            con = DBConnect11.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, '%' + Id + '%');
            rs = ps.executeQuery();
            while (rs.next()) {
                int id;
                String ten;
                String ngaysinh;
                String diachi;
                String sdt;
                String email;
                String matkhau;
                String gioitinh;
                String ngaytao;
                String trangthai;
                id = rs.getInt(1);
                ten = rs.getString(2);
                ngaysinh = rs.getString(3);
                diachi = rs.getString(4);
                sdt = rs.getString(5);
                email = rs.getString(6);
                matkhau = rs.getString(7);
                gioitinh = rs.getString(8);
                ngaytao = rs.getString(9);
                trangthai = rs.getString(10);
                Model_BenhNhan m = new Model_BenhNhan(Id, ten, ngaysinh, diachi, sdt, email, matkhau, gioitinh, ngaytao, trangthai);
                list.add(m);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
