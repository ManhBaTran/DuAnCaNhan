package DichVu;
 
import com.poly.database.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Repo_DichVu {
    private Connection con=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    private String sql;
    
    public ArrayList<Model_dichVu> getAllDV(){
        ArrayList<Model_dichVu> list_DV=new ArrayList<>();
        sql="select*from DichVu";
        try {
            con = DBConnect.getConnect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                int id,soLuong;
                String ten,moTa,donViTinh,ngayTao,trangThai;
                float chiPhi;
                id=rs.getInt(1);
                ten=rs.getString(2);
                moTa=rs.getString(3);
                chiPhi=rs.getFloat(4);
                soLuong=rs.getInt(5);
                donViTinh=rs.getString(6);
                ngayTao=rs.getString(7);
                trangThai=rs.getString(8);
                Model_dichVu m1=new Model_dichVu(id, ten, moTa, chiPhi, soLuong, donViTinh, ngayTao, trangThai);
                list_DV.add(m1);
            }
            return list_DV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
    public ArrayList<Model_dichVu>timDV(String tenTim){
        sql="select * from DichVu where Ten like ?";
        ArrayList<Model_dichVu> list_DV=new ArrayList<>();
        try {
            con=DBConnect.getConnect();
            ps=con.prepareStatement(sql);
            ps.setObject(1,'%'+tenTim+'%');
            rs=ps.executeQuery();
            while (rs.next()){
                int id,soLuong;
                String ten,moTa,donViTinh,ngayTao,trangThai;
                float chiPhi;
                id=rs.getInt(1);
                ten=rs.getString(2);
                moTa=rs.getString(3);
                chiPhi=rs.getFloat(4);
                soLuong=rs.getInt(5);
                donViTinh=rs.getString(6);
                ngayTao=rs.getString(7);
                trangThai=rs.getString(8);
                Model_dichVu m=new Model_dichVu(id, ten, moTa, chiPhi, soLuong, donViTinh, ngayTao, trangThai);
                list_DV.add(m);
            }return list_DV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
}
