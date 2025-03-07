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
    private String vaiTro;
    private long id;
    private String tenNguoi;
    private String email;
    private String soDienThoai;
    private String matKhau;
    private String chuyenKhoa;
    private Integer soNamKinhNghiem;
    private java.sql.Date ngayTao;
    private String trangThai;

    public NguoiDung(String vaiTro, long id, String tenNguoi, String email, String soDienThoai, String matKhau, String chuyenKhoa, Integer soNamKinhNghiem, Date ngayTao, String trangThai) {
        this.vaiTro = vaiTro;
        this.id = id;
        this.tenNguoi = tenNguoi;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.matKhau = matKhau;
        this.chuyenKhoa = chuyenKhoa;
        this.soNamKinhNghiem = soNamKinhNghiem;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public NguoiDung() {
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenNguoi() {
        return tenNguoi;
    }

    public void setTenNguoi(String tenNguoi) {
        this.tenNguoi = tenNguoi;
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

    public String getChuyenKhoa() {
        return chuyenKhoa;
    }

    public void setChuyenKhoa(String chuyenKhoa) {
        this.chuyenKhoa = chuyenKhoa;
    }

    public Integer getSoNamKinhNghiem() {
        return soNamKinhNghiem;
    }

    public void setSoNamKinhNghiem(Integer soNamKinhNghiem) {
        this.soNamKinhNghiem = soNamKinhNghiem;
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

     public Object[] rowDt(){
         return new Object[]{
             vaiTro, id, tenNguoi, email, soDienThoai, matKhau, chuyenKhoa, soNamKinhNghiem, ngayTao, trangThai
         };
     }
}

 
