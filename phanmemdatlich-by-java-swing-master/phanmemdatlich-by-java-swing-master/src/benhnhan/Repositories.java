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
        sql = "select*from BenhNhan";
        ArrayList<Model_BenhNhan> list = new ArrayList<>();
        try {
            con = DBConnect11.getConnection();
            ps = con.prepareStatement(sql);
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
                id=rs.getInt(1);
                ten=rs.getString(2);
                ngaysinh=rs.getString(3);
                diachi=rs.getString(4);
                sdt=rs.getString(5);
                email=rs.getString(6);
                matkhau=rs.getString(7);
                gioitinh=rs.getString(8);
                ngaytao=rs.getString(9);
                trangthai=rs.getString(10);
                Model_BenhNhan m=new Model_BenhNhan(id, ten, ngaysinh, diachi, sdt, email, matkhau, gioitinh, ngaytao, trangthai);
                list.add(m);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int them(Model_BenhNhan m){
        sql="insert into BenhNhan(Ten,NgaySinh,DiaChi,SoDienThoai,Email,MatKhau,GioiTinh,NgayTao,TrangThai) values (?,?,?,?,?,?,?,?,?)";
        try {
            con=DBConnect11.getConnection();
            ps=con.prepareStatement(sql);
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
    public  int xoa(int id){
        sql="delete from BenhNhan where ID=?";
        try {
            con=DBConnect11.getConnection();
            ps=con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int sua(Model_BenhNhan m,int id){
        sql="update BenhNhan set Ten=?,NgaySinh=?,DiaChi=?,SoDienThoai=?,Email=?,MatKhau=?,GioiTinh=?,NgayTao=?,TrangThai=? where ID=?";
        try {
            con=DBConnect11.getConnection();
            ps=con.prepareStatement(sql);
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
   public ArrayList<Model_BenhNhan> timkiem( String  Id) {
        sql = "select *from BenhNhan where ID like ?";
        ArrayList<Model_BenhNhan> list = new ArrayList<>();
        try {
            con = DBConnect11.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, '%'+Id+'%');
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
                id=rs.getInt(1);
                ten=rs.getString(2);
                ngaysinh=rs.getString(3);
                diachi=rs.getString(4);
                sdt=rs.getString(5);
                email=rs.getString(6);
                matkhau=rs.getString(7);
                gioitinh=rs.getString(8);
                ngaytao=rs.getString(9);
                trangthai=rs.getString(10);
                Model_BenhNhan m=new Model_BenhNhan(id, ten, ngaysinh, diachi, sdt, email, matkhau, gioitinh, ngaytao, trangthai);
                list.add(m);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
