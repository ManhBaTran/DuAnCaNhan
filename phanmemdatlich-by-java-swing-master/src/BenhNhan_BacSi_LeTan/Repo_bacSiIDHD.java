/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BenhNhan_BacSi_LeTan;
import BenhNhan_BacSi_LeTan.Model_bacSiIDHD;
import BenhNhan_BacSi_LeTan.DBConnectHD1;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Repo_bacSiIDHD {
    private Connection con = null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    private String sql=null;
    public ArrayList<Model_bacSiIDHD> getAll1(){
        sql="select id from BacSi";
        ArrayList<Model_bacSiIDHD> list_BS=new ArrayList<>();
        try {
            con=DBConnectHD1.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {
                String  BacSiID;
                BacSiID=rs.getString(1);
                Model_bacSiIDHD m  =new Model_bacSiIDHD(BacSiID);
                list_BS.add(m);
            }
            return list_BS;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
