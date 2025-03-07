package com.poly.entity;

import java.sql.Date; // Sử dụng java.sql.Date thay vì java.util.Date

public class BacSi {
    private long ID; // Thay đổi kiểu dữ liệu từ int sang long
    private String ten;
    private String email;
    private String sdt;
    private String matkhau;
    private String chuyenKhoa;
    private int soNamKinhNghiem;
    private Date ngayTao; // Thay đổi kiểu dữ liệu từ Date sang java.sql.Date
    private String trangThai;

    public BacSi() {
    }

    public BacSi(long ID, String ten, String email, String sdt, String matkhau, String chuyenKhoa, int soNamKinhNghiem, Date ngayTao, String trangThai) {
        this.ID = ID;
        this.ten = ten;
        this.email = email;
        this.sdt = sdt;
        this.matkhau = matkhau;
        this.chuyenKhoa = chuyenKhoa;
        this.soNamKinhNghiem = soNamKinhNghiem;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public long getID() { // Sửa thành long
        return ID;
    }

    public void setID(long ID) { // Sửa thành long
        this.ID = ID;
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getChuyenKhoa() {
        return chuyenKhoa;
    }

    public void setChuyenKhoa(String chuyenKhoa) {
        this.chuyenKhoa = chuyenKhoa;
    }

    public int getSoNamKinhNghiem() {
        return soNamKinhNghiem;
    }

    public void setSoNamKinhNghiem(int soNamKinhNghiem) {
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

    public Object[] rowData() {
        return new Object[]{
            ID, ten, ngayTao, soNamKinhNghiem, sdt, email, trangThai
        };
    }

    public void setId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getSpecialty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
