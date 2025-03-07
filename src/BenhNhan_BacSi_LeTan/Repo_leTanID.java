/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BenhNhan_BacSi_LeTan;
import BenhNhan_BacSi_LeTan.Model_leTanID;
 
import com.poly.database.DBConnect;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Repo_leTanID {
    private Connection con = null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    private String sql=null;
    public ArrayList<Model_leTanID> getAll3(){
        sql="select ID from Letan";
        ArrayList<Model_leTanID> list_LT=new ArrayList<>();
        try {
            con=DBConnect.getConnect();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                String leTanID;
                leTanID=rs.getString(1);
                Model_leTanID m=new Model_leTanID(leTanID);
                list_LT.add(m);
            }return list_LT;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
