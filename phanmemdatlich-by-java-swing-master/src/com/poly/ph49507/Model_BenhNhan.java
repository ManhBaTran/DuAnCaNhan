/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.ph49507;

import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Model_BenhNhan {
    private String id;
    private String ten;
    private String ngaysinh;
    private String diachi;
    private String sdt;
    private String email;
    private String gioitinh;
    private String ngaytao;
    private String trangthai;

    public Model_BenhNhan(String id, String ten, String ngaysinh, String diachi, String sdt, String email, String gioitinh, String ngaytao, String trangthai) {
        this.id = id;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.email = email;
        this.gioitinh = gioitinh;
        this.ngaytao = ngaytao;
        this.trangthai = trangthai;
    }

    public Model_BenhNhan() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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

    public Object[] todatarow(){
        return new Object[] {
          this.getId(),this.getTen(),this.getNgaysinh(),this.getDiachi(),this.getSdt() ,this.getGioitinh(),this.getNgaytao() 
        };
    }

    
    
}
