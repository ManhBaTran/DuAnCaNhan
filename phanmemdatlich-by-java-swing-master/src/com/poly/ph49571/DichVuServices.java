/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.ph49571;

import com.poly.database.DBConnect;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author ASUS
 */
public class DichVuServices {
    private Connection conn;
    
    public DichVuServices() {
        conn = DBConnect.getConnect();
    }
    
    public ArrayList<ModeDichVu> getdata() throws SQLException{
        ArrayList<ModeDichVu> list = new ArrayList<>();
        String query = " select*from DichVu";
        Statement stm  = conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        while (rs.next()) {
            ModeDichVu dv = new ModeDichVu();
            dv.setStt(rs.getInt(1));
            dv.setTen_dichvu(rs.getString(2));
            dv.setMota(rs.getString(3));
            dv.setChiphi(rs.getDouble(4));
            dv.setNgaytao(rs.getString(5));
            dv.setTrangthai(rs.getString(6));
            list.add(dv);
        }
        return list;
    }
    public void add(ModeDichVu dv) throws SQLException {
        String query = "INSERT INTO DichVu (Ten,MoTa,ChiPhi,NgayTao,TrangThai) VALUES (?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, dv.getTen_dichvu());
        ps.setString(2, dv.getMota());
        ps.setDouble(3, dv.getChiphi());
        ps.setString(4,dv.getNgaytao());
        ps.setString(5, dv.getTrangthai());
        ps.execute();
    }
    public void remove (ModeDichVu dv) throws SQLException {
        String query =" DELETE FROM DichVu WHERE ID = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, dv.getStt());
        
        ps.execute();
    }
    public void update(ModeDichVu dv) throws SQLException{
        String query = "UPDATE DichVu SET Ten = ? , MoTa = ?, ChiPhi = ?, NgayTao = ? , TrangThai =  ? WHERE ID =  ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, dv.getTen_dichvu());
        ps.setString(2, dv.getMota());
        ps.setDouble(3, dv.getChiphi());
        ps.setString(4, dv.getNgaytao());
        ps.setString(5, dv.getTrangthai());
        ps.setInt(6 , dv.getStt());
        
        ps.executeUpdate();
    }
    public ArrayList<ModeDichVu> tim(int idcantim) throws SQLException{
        ArrayList<ModeDichVu> list = new ArrayList<>();
        String query = "SELECT  ID ,Ten , MoTa , ChiPhi , NgayTao , TrangThai FROM DichVu WHERE ID LIKE ?";
        try {
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idcantim);
        ResultSet rs  = ps.executeQuery();
        while (rs.next()) {
            
            ModeDichVu dv = new ModeDichVu();
            dv.setStt(rs.getInt(1));
            dv.setTen_dichvu(rs.getString(2));
            dv.setMota(rs.getString(3));
            dv.setChiphi(rs.getInt(4));
            dv.setNgaytao(rs.getString(5));
            dv.setTrangthai(rs.getString(6));
            list.add(dv);
        }
        } catch (Exception e) {
            System.out.println("loi: "+e);
        }
        return list;
    }
    public ArrayList<ModeDichVu> getAll() throws SQLException{
        ArrayList<ModeDichVu> list = new ArrayList<>();
        String query = """
                       SELECT 
                              [Ten]
                             ,[MoTa]
                             ,[ChiPhi]                          
                             ,[TrangThai]
                         FROM [dbo].[DichVu]
                       """;
        Statement stm  = conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        while (rs.next()) {
            ModeDichVu dv = new ModeDichVu();
            dv.setTen_dichvu(rs.getString(1));
            dv.setMota(rs.getString(2));
            dv.setChiphi(rs.getDouble(3));
            dv.setTrangthai(rs.getString(4));
            list.add(dv);
        }
        return list;
    }
}