/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BenhNhan_BacSi_LeTan;
 
import com.poly.database.DBConnect;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Repo_benhNhanID {
    private Connection con = null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    private String sql=null;
    public ArrayList<Model_benhNhanID> getAll2(){
        sql="select id from BenhNhan";
        ArrayList<Model_benhNhanID> list_BN=new ArrayList<>();
        try {
            con=DBConnect.getConnect();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {
                String  benhNhanID;
                benhNhanID=rs.getString(1);
                Model_benhNhanID m  =new Model_benhNhanID(benhNhanID);
                list_BN.add(m);
            }
            return list_BN;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
