package hoadon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Repo_HoaDon {
    private Connection con=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    private String sql;

    public ArrayList<Model_HoaDon> getAll(){
        ArrayList<Model_HoaDon> list_HD=new ArrayList<>();
        sql="select id,benhnhanid,bacsiid,letanid,tenkhachhang,diachi,sodienthoai,email,phuongthuctt,tienkhdua,tienthua,thanhtien,ngaytao,ngaythanhtoan,trangthai from HoaDon";
        try {
            con = DBConnect.getConnect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                int id,BenhNhanID,BacSiID,leTanID;
                String tenKhachHang,diaChi,soDienThoai,email,phuongThucThanhToan;
                float tienKhachDua,tienThua,thanhTien;
                String ngay,ngayThanhToan,trangThai;
                id=rs.getInt(1);
                BenhNhanID=rs.getInt(2);
                BacSiID=rs.getInt(3);
                leTanID=rs.getInt(4);
                tenKhachHang=rs.getString(5);
                diaChi=rs.getString(6);
                soDienThoai=rs.getString(7);
                email=rs.getString(8);
                phuongThucThanhToan=rs.getString(9);
                tienKhachDua=rs.getFloat(10);
                tienThua=rs.getFloat(11);
                thanhTien=rs.getFloat(12);
                ngay=rs.getString(13);
                ngayThanhToan=rs.getString(14);
                trangThai=rs.getString(15);
                Model_HoaDon m1=new Model_HoaDon(id, BenhNhanID, BacSiID, leTanID, tenKhachHang, diaChi, soDienThoai, email, phuongThucThanhToan, tienKhachDua, tienThua, thanhTien, ngay, ngayThanhToan, trangThai);
                list_HD.add(m1);
            }return list_HD;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
    public int them(Model_HoaDon m2){
        sql="insert into HoaDon(BenhNhanID,BacSiID,LetanID,TenKhachHang,DiaChi,SoDienThoai,Email,PhuongThucTT,\n" +
"TienKhDua,TienThua,ThanhTien,NgayTao,NgayThanhToan,TrangThai) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnect();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m2.getBenhNhanID());
            ps.setObject(2, m2.getBacSiID());
            ps.setObject(3, m2.getLeTanID());
            ps.setObject(4, m2.getTenKhachHang());
            ps.setObject(5, m2.getDiaChi());
            ps.setObject(6, m2.getSoDienThoai());
            ps.setObject(7, m2.getEmail());
            ps.setObject(8, m2.getPhuongThucThanhToan());
            ps.setObject(9, m2.getTienKhachDua());
            ps.setObject(10, m2.getTienThua());
            ps.setObject(11, m2.getThanhTien());
            ps.setObject(12, m2.getNgay());
            ps.setObject(13, m2.getNgayThanhToan());
            ps.setObject(14, m2.getTrangThai());    
        return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public ArrayList<Model_HoaDon>tim(String idTim){
        sql="select id,BenhNhanID,BacSiID,LetanID,TenKhachHang,DiaChi,SoDienThoai,Email,PhuongThucTT,TienKhDua,TienThua,ThanhTien,NgayTao,\n" +
"NgayThanhToan,TrangThai from HoaDon where id like ?";
        ArrayList<Model_HoaDon> list_HoaDon=new ArrayList<>();
        try {
            con=DBConnect.getConnect();
            ps=con.prepareStatement(sql);
            ps.setObject(1,'%'+idTim+'%');
            rs=ps.executeQuery();
            while(rs.next()){
                int id,BenhNhanID,BacSiID,leTanID;
                String tenKhachHang,diaChi,soDienThoai,email,phuongThucThanhToan;
                float tienKhachDua,tienThua,thanhTien;
                String ngay,ngayThanhToan,trangThai;
                id=rs.getInt(1);
                BenhNhanID=rs.getInt(2);
                BacSiID=rs.getInt(3);
                leTanID=rs.getInt(4);
                tenKhachHang=rs.getString(5);
                diaChi=rs.getString(6);
                soDienThoai=rs.getString(7);
                email=rs.getString(8);
                phuongThucThanhToan=rs.getString(9);
                tienKhachDua=rs.getFloat(10);
                tienThua=rs.getFloat(11);
                thanhTien=rs.getFloat(12);
                ngay=rs.getString(13);
                ngayThanhToan=rs.getString(14);
                trangThai=rs.getString(15);
                Model_HoaDon m=new Model_HoaDon(id, BenhNhanID, BacSiID, leTanID, tenKhachHang, diaChi, soDienThoai, email, phuongThucThanhToan, tienKhachDua, tienThua, thanhTien, ngay, ngayThanhToan, trangThai);
                list_HoaDon.add(m);
            }
            return list_HoaDon;
       } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }
}
