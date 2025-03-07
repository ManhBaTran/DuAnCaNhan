/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.entity;

/**
 *
 * @author admin
 */
public class BenhNhan {
    private int id;
    private String ten;
    private String ngaysinh;
    private String diachi;
        private String matKhau;

    private String Sodienthoai;
    private String email;
    private String gioitinh;
    private String ngaytao;
    private String trangthai;

    public BenhNhan() {
    }

    public BenhNhan(int id, String ten, String ngaysinh, String diachi, String matKhau, String Sodienthoai, String email, String gioitinh, String ngaytao, String trangthai) {
        this.id = id;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.matKhau = matKhau;
        this.Sodienthoai = Sodienthoai;
        this.email = email;
        this.gioitinh = gioitinh;
        this.ngaytao = ngaytao;
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

   

   

    

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSodienthoai() {
        return Sodienthoai;
    }

    public void setSodienthoai(String Sodienthoai) {
        this.Sodienthoai = Sodienthoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    
    public Object[] rowData() {
        return new Object[]{
           id,ten, ngaysinh, diachi, matKhau,Sodienthoai,email, gioitinh, ngaytao, trangthai
        };
    }
}
