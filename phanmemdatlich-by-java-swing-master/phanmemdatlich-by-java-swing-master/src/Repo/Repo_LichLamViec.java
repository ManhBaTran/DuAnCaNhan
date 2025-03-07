package Repo;
import Model.Model_LichLamViec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import lichlamviec.DBConnect;

public class Repo_LichLamViec {
    private Connection con=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    private String sql;

        public ArrayList<Model_LichLamViec> getAll(){
        ArrayList<Model_LichLamViec> list_LLV=new ArrayList<>();
        sql="select id,bacsiid,ngay,thoigianbatdau,thoigianketthuc,ghichu,calamviec,trangthai,ngaytao from LichLamViec";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                int id,bacSiID;
                String ngay,thoiGianBatDau,thoiGianketThuc,ghiChu,caLamViec,trangThai,ngayTao;
                id=rs.getInt(1);
                bacSiID=rs.getInt(2);
                ngay=rs.getString(3);
                thoiGianBatDau=rs.getString(4);
                thoiGianketThuc=rs.getString(5);
                ghiChu=rs.getString(6);
                caLamViec=rs.getString(7);
                trangThai=rs.getString(8);
                ngayTao=rs.getString(9);
                Model_LichLamViec m1=new Model_LichLamViec(id, bacSiID, ngay, thoiGianBatDau, thoiGianketThuc, ghiChu, caLamViec, trangThai, ngayTao);
                list_LLV.add(m1);
            }
            return list_LLV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        
        public int them(Model_LichLamViec m2){
            sql="insert into LichLamViec(bacsiID,ngay,thoigianbatdau,thoigianketthuc,ghichu,calamviec,trangthai,ngaytao) values(?,?,?,?,?,?,?,?)";
            try {
                con = DBConnect.getConnection();
                ps = con.prepareStatement(sql);
                ps.setObject(1,m2.getBacSiID());
                ps.setObject(2,m2.getNgay());
                ps.setObject(3,m2.getThoiGianBatDau());
                ps.setObject(4,m2.getThoiGianKetThuc());
                ps.setObject(5,m2.getGhiChu());
                ps.setObject(6,m2.getCaLamViec());
                ps.setObject(7,m2.getTrangThai());
                ps.setObject(8,m2.getNgayTao());
            return ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        
        public int xoa(String idXoa){
            sql="delete from LichLamViec where id=?";
            try {
                con = DBConnect.getConnection();
                ps = con.prepareStatement(sql);
                ps.setObject(1,idXoa);
                return ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
                return 0;

            }
        }
        
        public int sua(Model_LichLamViec m3, String idSua){
            sql="  update LichLamViec set BacSiID =?, Ngay=?,ThoiGianBatDau=?,ThoiGianKetThuc=?,GhiChu=?,CaLamViec=?,TrangThai=?,NgayTao=? where ID=?";
            try {
                con = DBConnect.getConnection();
                ps = con.prepareStatement(sql);
                ps.setObject(1,m3.getBacSiID());
                ps.setObject(2,m3.getNgay());
                ps.setObject(3,m3.getThoiGianBatDau());
                ps.setObject(4,m3.getThoiGianKetThuc());
                ps.setObject(5,m3.getGhiChu());
                ps.setObject(6,m3.getCaLamViec());
                ps.setObject(7,m3.getTrangThai());
                ps.setObject(8,m3.getNgayTao());
                ps.setObject(9,idSua);
                return ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        
        public ArrayList<Model_LichLamViec>tim(String idTim){
            sql="select ID,BacSiID,Ngay,ThoiGianBatDau,ThoiGianKetThuc,GhiChu,CaLamViec,TrangThai,NgayTao from LichLamViec where id like ?";
            ArrayList<Model_LichLamViec> list_LLViec=new ArrayList<>();
            try {
                con=DBConnect.getConnection();
                ps=con.prepareStatement(sql);
                ps.setObject(1,'%'+idTim+'%');
                rs=ps.executeQuery();
                while (rs.next()) {
                       int id,bacSiID;
                       String ngay,thoiGianBatDau,thoiGianketThuc,ghiChu,caLamViec,trangThai,ngayTao;
                        id=rs.getInt(1);
                        bacSiID=rs.getInt(2);
                        ngay=rs.getString(3);
                        thoiGianBatDau=rs.getString(4);
                        thoiGianketThuc=rs.getString(5);
                        ghiChu=rs.getString(6);
                        caLamViec=rs.getString(7);
                        trangThai=rs.getString(8);
                        ngayTao=rs.getString(9);
                        Model_LichLamViec m=new Model_LichLamViec(id, bacSiID, ngay, thoiGianBatDau, thoiGianketThuc, ghiChu, caLamViec, trangThai, ngayTao);
                        list_LLViec.add(m);
                }return list_LLViec;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
}
