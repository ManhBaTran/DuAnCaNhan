/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HoaDon_id;
 
import com.poly.database.DBConnect;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Repo_hoaDon {
    private Connection con = null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    private String sql=null;
    public ArrayList<Model_hoaDon> getAll4(){
        sql="select id from HoaDon";
        ArrayList<Model_hoaDon> list_HD=new ArrayList<>();
        try {
            con=DBConnect.getConnect();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {
                String  HoaDonID;
                HoaDonID=rs.getString(1);
                Model_hoaDon m  =new Model_hoaDon(HoaDonID);
                list_HD.add(m);
            }
            return list_HD;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
