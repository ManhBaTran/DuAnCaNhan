/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.ph49571;

/**
 *
 * @author ASUS
 */
public class ModeChiTietHoaDon {
    private int id;
    private int mahoadon;
    private int madichvu;
    private String tendichvu;
    private String mota;
    private String donvitinh;
    private int soluong;
    private double dongia;
    private double thanhtien;
    private String trangthai;
    
    //Them
    private String soDienThoai;
    private String Email;
    private String DiaChi;
    private int bacSiId;
    private int leTanID;
    private String tenKhachHang;
    private String PhuongThucTT;
    private double tienKhDua;
    private double tienThua;
    private String TrangThaiText;

    public String getTrangThaiText() {
        return TrangThaiText;
    }

    public void setTrangThaiText(String TrangThaiText) {
        this.TrangThaiText = TrangThaiText;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public int getBacSiId() {
        return bacSiId;
    }

    public void setBacSiId(int bacSiId) {
        this.bacSiId = bacSiId;
    }

    public int getLeTanID() {
        return leTanID;
    }

    public void setLeTanID(int leTanID) {
        this.leTanID = leTanID;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getPhuongThucTT() {
        return PhuongThucTT;
    }

    public void setPhuongThucTT(String PhuongThucTT) {
        this.PhuongThucTT = PhuongThucTT;
    }

    public double getTienKhDua() {
        return tienKhDua;
    }

    public void setTienKhDua(double tienKhDua) {
        this.tienKhDua = tienKhDua;
    }

    public double getTienThua() {
        return tienThua;
    }

    public void setTienThua(double tienThua) {
        this.tienThua = tienThua;
    }
       
    //them
    

    public ModeChiTietHoaDon() {
    }

    public ModeChiTietHoaDon(int id,int mahoadon, int madichvu, String tendichvu, String mota, String donvitinh, int soluong, double dongia, double thanhtien, String trangthai) {
        this.id = id;
        this.mahoadon = mahoadon;
        this.madichvu = madichvu;
        this.tendichvu = tendichvu;
        this.mota = mota;
        this.donvitinh = donvitinh;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
        this.trangthai = trangthai;
    }

    public int getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(int mahoadon) {
        this.mahoadon = mahoadon;
    }

    public int getMadichvu() {
        return madichvu;
    }

    public void setMadichvu(int madichvu) {
        this.madichvu = madichvu;
    }

    public String getTendichvu() {
        return tendichvu;
    }

    public void setTendichvu(String tendichvu) {
        this.tendichvu = tendichvu;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getDonvitinh() {
        return donvitinh;
    }

    public void setDonvitinh(String donvitinh) {
        this.donvitinh = donvitinh;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
