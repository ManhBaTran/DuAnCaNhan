/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.entity;

import java.util.Date;
import org.apache.poi.hpsf.Decimal;

/**
 *
 * @author manh9
 */
public class HoaDon {
    private int MaBenhNhan;
    private int MaNguoiDung;
    private int MaBacSi;
    private String TenKhachHang;
    private String DiaChi;
    private String SoDienThoai;
    private String Email;
    private String PhuongThucTT;
    private float TienKhDua;
    private float TienThua;
    private float ThanhTien;
    private Date NgayTao;
    private Date NgayThanhToan;
    private String TrangThai;

    public HoaDon() {
    }

    public HoaDon(int MaBenhNhan, int MaNguoiDung, int MaBacSi, String TenKhachHang, String DiaChi, String SoDienThoai, String Email, String PhuongThucTT, float TienKhDua, float TienThua, float ThanhTien, Date NgayTao, Date NgayThanhToan, String TrangThai) {
        this.MaBenhNhan = MaBenhNhan;
        this.MaNguoiDung = MaNguoiDung;
        this.MaBacSi = MaBacSi;
        this.TenKhachHang = TenKhachHang;
        this.DiaChi = DiaChi;
        this.SoDienThoai = SoDienThoai;
        this.Email = Email;
        this.PhuongThucTT = PhuongThucTT;
        this.TienKhDua = TienKhDua;
        this.TienThua = TienThua;
        this.ThanhTien = ThanhTien;
        this.NgayTao = NgayTao;
        this.NgayThanhToan = NgayThanhToan;
        this.TrangThai = TrangThai;
    }

    

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

  

   

    public int getMaBenhNhan() {
        return MaBenhNhan;
    }

    public void setMaBenhNhan(int MaBenhNhan) {
        this.MaBenhNhan = MaBenhNhan;
    }

    
    public String getPhuongThucTT() {
        return PhuongThucTT;
    }

    public void setPhuongThucTT(String PhuongThucTT) {
        this.PhuongThucTT = PhuongThucTT;
    }

    public float getTienKhDua() {
        return TienKhDua;
    }

    public void setTienKhDua(float TienKhDua) {
        this.TienKhDua = TienKhDua;
    }

    public float getTienThua() {
        return TienThua;
    }

    public void setTienThua(float TienThua) {
        this.TienThua = TienThua;
    }

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

   

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public Date getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(Date NgayThanhToan) {
        this.NgayThanhToan = NgayThanhToan;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getMaNguoiDung() {
        return MaNguoiDung;
    }

    public void setMaNguoiDung(int MaNguoiDung) {
        this.MaNguoiDung = MaNguoiDung;
    }

    public int getMaBacSi() {
        return MaBacSi;
    }

    public void setMaBacSi(int MaBacSi) {
        this.MaBacSi = MaBacSi;
    }

    public Object[] rowData(){
       return new Object[]{
        MaBenhNhan, MaNguoiDung, MaBacSi,TenKhachHang, DiaChi, SoDienThoai, Email, PhuongThucTT, TienKhDua, TienThua,  ThanhTien, NgayTao, NgayThanhToan, TrangThai
       };
    }
   
}
