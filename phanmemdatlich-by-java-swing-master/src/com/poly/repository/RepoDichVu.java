/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.repository;

import com.poly.database.DBConnect;
import com.poly.entity.DichVu;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author ASUS
 */
public class RepoDichVu {
    private Connection conn;
    
    public RepoDichVu() {
        conn = DBConnect.getConnect();
    }
    
    public ArrayList<DichVu> getdata() throws SQLException{
        ArrayList<DichVu> list = new ArrayList<>();
        String query = " select*from DichVu";
        Statement stm  = conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        while (rs.next()) {
            DichVu dv = new DichVu();
            dv.setTen_dichvu(rs.getString(2));
            dv.setMota(rs.getString(3));
            dv.setChiphi(rs.getDouble(4));
            dv.setNgaytao(rs.getString(5));
            dv.setTrangthai(rs.getString(6));
            list.add(dv);
        }
        return list;
    }
}
