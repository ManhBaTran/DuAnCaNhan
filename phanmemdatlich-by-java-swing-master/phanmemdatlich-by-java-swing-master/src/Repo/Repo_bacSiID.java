package Repo;
import Model.Model_bacSi;
import java.sql.*;
import java.util.ArrayList;
import lichlamviec.DBConnect;

public class Repo_bacSiID {
    private Connection con = null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    private String sql=null;
    public ArrayList<Model_bacSi> getAll(){
        sql="select ID from BacSi";
        ArrayList<Model_bacSi> list_BS=new ArrayList<>();
        try {
            con=DBConnect.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {
                String  id;
                id=rs.getString(1);
                Model_bacSi m  =new Model_bacSi(id);
                list_BS.add(m);
            }
            return list_BS;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
