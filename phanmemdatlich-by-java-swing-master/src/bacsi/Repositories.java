/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bacsi;

import java.sql.*;
import java.util.ArrayList;
import bacsi.DBConnect1;

/**
 *
 * @author admin
 */
public class Repositories {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public ArrayList<Model_bacsi> getall() {
        sql = "select*from BacSi";
        ArrayList<Model_bacsi> list = new ArrayList<>();
        try {
            con = DBConnect1.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id;
                String ten;
                String email;
                String sdt;
                String matkhau;
                String chuyenkhoa;
                String sonamkinhnghiem;
                String ngaytao;
                String trangthai;
                id = rs.getInt(1);
                ten = rs.getString(2);
                email = rs.getString(3);
                sdt = rs.getString(4);
                matkhau = rs.getString(5);
                chuyenkhoa = rs.getString(6);
                sonamkinhnghiem = rs.getString(7);
                ngaytao = rs.getString(8);
                trangthai = rs.getString(9);
                Model_bacsi m = new Model_bacsi(id, ten, email, sdt, matkhau, chuyenkhoa, sonamkinhnghiem, ngaytao, trangthai);
                list.add(m);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int them(Model_bacsi m) {
        sql = "insert into BacSi(Ten,Email,SoDienThoai,MatKhau,ChuyenKhoa,SoNamKinhNghiem,NgayTao,TrangThai) values (?,?,?,?,?,?,?,?) ";
        try {
            con = DBConnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getTen());
            ps.setObject(2, m.getEmail());
            ps.setObject(3, m.getSdt());
            ps.setObject(4, m.getMatkhau());
            ps.setObject(5, m.getChuyenkhoa());
            ps.setObject(6, m.getSonamkinhnghiem());
            ps.setObject(7, m.getNgaytao());
            ps.setObject(8, m.getTrangthai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int xoa(int id) {
        sql = "delete from BacSi where ID=?";
        try {
            con = DBConnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int sapxep(Model_bacsi m, int id) {
        sql = " update BacSi set Ten=?,Email=?,SoDienThoai=?,MatKhau=?,ChuyenKhoa=?,SoNamKinhNghiem=?,NgayTao=?,TrangThai=? where ID=? ";
        try {
            con = DBConnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getTen());
            ps.setObject(2, m.getEmail());
            ps.setObject(3, m.getSdt());
            ps.setObject(4, m.getMatkhau());
            ps.setObject(5, m.getChuyenkhoa());
            ps.setObject(6, m.getSonamkinhnghiem());
            ps.setObject(7, m.getNgaytao());
            ps.setObject(8, m.getTrangthai());
            ps.setObject(9, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList<Model_bacsi> timkiem(String ID) {
        sql = "    select*from BacSi where ID like ?";
        ArrayList<Model_bacsi> list = new ArrayList<>();
        try {
            con = DBConnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, '%'+ID+'%');
            rs = ps.executeQuery();
            while (rs.next()) {
                int id;
                String ten;
                String email;
                String sdt;
                String matkhau;
                String chuyenkhoa;
                String sonamkinhnghiem;
                String ngaytao;
                String trangthai;
                id = rs.getInt(1);
                ten = rs.getString(2);
                email = rs.getString(3);
                sdt = rs.getString(4);
                matkhau = rs.getString(5);
                chuyenkhoa = rs.getString(6);
                sonamkinhnghiem = rs.getString(7);
                ngaytao = rs.getString(8);
                trangthai = rs.getString(9);
                Model_bacsi m = new Model_bacsi(id, ten, email, sdt, matkhau, chuyenkhoa, sonamkinhnghiem, ngaytao, trangthai);
                list.add(m);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
