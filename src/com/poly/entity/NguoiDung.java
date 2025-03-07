/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.entity;

import java.sql.Date;

/**
 *
 * @author manh9
 */
public class NguoiDung {
 
    private long id;
    private String ten;
    private String email;
    private String soDienThoai;
    private String matKhau;
    private String diaChi;
    private java.sql.Date ngayTao;
    private String trangThai;
    private String gioiTinh;
    private java.sql.Date ngaySinh;

    public NguoiDung(long id, String ten, String email, String soDienThoai, String matKhau, String diaChi, Date ngayTao, String trangThai, String gioiTinh, Date ngaySinh) {
        this.id = id;
        this.ten = ten;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.matKhau = matKhau;
        this.diaChi = diaChi;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
    }

    
    public NguoiDung() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    

     public Object[] rowDt(){
         return new Object[]{
              id, ten, email, soDienThoai, matKhau, diaChi,  ngaySinh, gioiTinh, ngayTao, trangThai
         };
     }
}

 
