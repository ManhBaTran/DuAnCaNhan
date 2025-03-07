/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package letan;
 
import com.poly.database.DBConnect;
import java.sql.*;
import java.util.ArrayList;
 


/**
 *
 * @author admin
 */
public class Repositories {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public ArrayList<Model_Letan> getall() {
        sql = "select*from LeTan";
        ArrayList<Model_Letan> list = new ArrayList<>();
        try {
            con = DBConnect.getConnect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
               int id;
            String ten;
            String email;
            String sodienthoai;
            String matkhau;
            String diachi;
            String ngaysinh;
            String gioitinh;
            String ngaytao;
            String trangthai;
            id=rs.getInt(1);
            ten=rs.getString(2);
            email=rs.getString(3);
            sodienthoai=rs.getString(4);
            matkhau=rs.getString(5);
            diachi=rs.getString(6);
            ngaysinh=rs.getString(7);
            gioitinh=rs.getString(8);
            ngaytao=rs.getString(9);
            trangthai=rs.getString(10);
            Model_Letan m=new Model_Letan(id, ten, email, sodienthoai, matkhau, diachi, ngaysinh, gioitinh, ngaytao, trangthai);
            list.add(m); 
            }
           return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public  int them(Model_Letan m){
        sql="insert into Letan(Ten,Email,SoDienThoai,MatKhau,DiaChi,NgaySinh,GioiTinh,NgayTao,TrangThai) values (?,?,?,?,?,?,?,?,?)";
        try {
            con =  DBConnect.getConnect();
            ps = con.prepareStatement(sql);    
            ps.setObject(1, m.getTen());
            ps.setObject(2, m.getEmail());
            ps.setObject(3, m.getSodienthoai());
            ps.setObject(4, m.getMatkhau());
            ps.setObject(5, m.getDiachi());
            ps.setObject(6, m.getNgaysinh());
            ps.setObject(7, m.getGioitinh());
            ps.setObject(8, m.getNgaytao());
            ps.setObject(9, m.getTrangthai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int xoa(int id){
        sql="delete from Letan where ID=?";
        try {
            con= DBConnect.getConnect();
            ps=con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int sua(Model_Letan m,int id){
        sql="update Letan set Ten=?,NgaySinh=?,DiaChi=?,SoDienThoai=?,Email=?,MatKhau=?,GioiTinh=?,NgayTao=?,TrangThai=? where ID=?";
        try {
            con= DBConnect.getConnect();
            ps=con.prepareStatement(sql);
            ps.setObject(1, m.getTen());
            ps.setObject(2, m.getNgaysinh());
            ps.setObject(3, m.getDiachi());
            ps.setObject(4, m.getSodienthoai());
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
    public ArrayList<Model_Letan> timkiem(String thongtin) {
        sql = "select *from Letan where Ten like ? or Email = ? or SoDienThoai =?";
        ArrayList<Model_Letan> list = new ArrayList<>();
        try {
            con =  DBConnect.getConnect();
            ps = con.prepareStatement(sql);
            ps.setObject(1, '%'+thongtin+'%');
            ps.setString(2, thongtin);

            ps.setObject(3, thongtin);

            rs = ps.executeQuery();
            while (rs.next()) {                
               int id;
            String ten;
            String email;
            String sodienthoai;
            String matkhau;
            String diachi;
            String ngaysinh;
            String gioitinh;
            String ngaytao;
            String trangthai;
            id=rs.getInt(1);
            ten=rs.getString(2);
            email=rs.getString(3);
            sodienthoai=rs.getString(4);
            matkhau=rs.getString(5);
            diachi=rs.getString(6);
            ngaysinh=rs.getString(7);
            gioitinh=rs.getString(8);
            ngaytao=rs.getString(9);
            trangthai=rs.getString(10);
            Model_Letan m=new Model_Letan(id, ten, email, sodienthoai, matkhau, diachi, ngaysinh, gioitinh, ngaytao, trangthai);
            list.add(m); 
            }
           return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Model_Letan> timTrangThai(String trangThai) {
        sql = "Select * from LeTan where TrangThai = ?";
        ArrayList<Model_Letan> listLT = new ArrayList<>();
        try {
            con =  DBConnect.getConnect();
            ps = con.prepareStatement(sql);
            ps.setString(1, trangThai);
            rs = ps.executeQuery();
            while (rs.next()) {                
               int id;
            String ten;
            String email;
            String sodienthoai;
            String matkhau;
            String diachi;
            String ngaysinh;
            String gioitinh;
            String ngaytao;
            String trangthai;
            
            id=rs.getInt(1);
            ten=rs.getString(2);
            email=rs.getString(3);
            sodienthoai=rs.getString(4);
            matkhau=rs.getString(5);
            diachi=rs.getString(6);
            ngaysinh=rs.getString(7);
            gioitinh=rs.getString(8);
            ngaytao=rs.getString(9);
            trangthai=rs.getString(10);
            Model_Letan m=new Model_Letan(id, ten, email, sodienthoai, matkhau, diachi, ngaysinh, gioitinh, ngaytao, trangthai);
            listLT.add(m); 
            }
           return listLT;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
