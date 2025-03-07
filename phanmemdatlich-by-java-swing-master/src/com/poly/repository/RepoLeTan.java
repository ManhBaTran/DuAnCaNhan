/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.repository;

import com.poly.database.DBConnect;
import com.poly.entity.LeTan;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author ASUS
 */
public class RepoLeTan {
    private Connection conn;
    
    public RepoLeTan() {
        conn = DBConnect.getConnect();
    }
    
    public ArrayList<LeTan> getdata() throws SQLException{
        ArrayList<LeTan> list = new ArrayList<>();
        String query = "select*from LeTan";
        Statement stm  = conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        while (rs.next()) {
            LeTan nd = new LeTan();
            nd.setId(rs.getInt(1));
            nd.setTen(rs.getString(2));
            nd.setEmail(rs.getString(3));
            nd.setSodienthoai(rs.getInt(4));
            nd.setMatkhau(rs.getString(5));                    
            nd.setDiachi(rs.getString(6));
            nd.setNgaySinh(rs.getDate(7));
            nd.setGioiTinh(rs.getString(8));
            nd.setNgaytao(rs.getString(9));
            nd.setTrangthai(rs.getString(10));
            
            
            list.add(nd);
        }
        return list;
    }
}
