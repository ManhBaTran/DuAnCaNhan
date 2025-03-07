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
    private String ngaythanhtoan;
    private String trangthai;
    
    //Them
    private String soDienThoai;
    private String Email;
    private String DiaChi;
    private int bacSiId;
    private int leTanID;
    private int benhnhanid;
    private String tenKhachHang;
    private String PhuongThucTT;
    private String ngaytao;
    private double tienKhDua;
    private double tienThua;
    private String TrangThaiText;
    private String thanhtienchitiet;

    public ModeChiTietHoaDon(int id, int mahoadon, int madichvu, String tendichvu, String mota, String donvitinh, int soluong, double dongia, double thanhtien, String ngaythanhtoan, String trangthai, String soDienThoai, String Email, String DiaChi, int bacSiId, int leTanID, int benhnhanid, String tenKhachHang, String PhuongThucTT, String ngaytao, double tienKhDua, double tienThua, String TrangThaiText , String thanhtienchitiet) {
        this.id = id;
        this.mahoadon = mahoadon;
        this.madichvu = madichvu;
        this.tendichvu = tendichvu;
        this.mota = mota;
        this.donvitinh = donvitinh;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
        this.ngaythanhtoan = ngaythanhtoan;
        this.trangthai = trangthai;
        this.soDienThoai = soDienThoai;
        this.Email = Email;
        this.DiaChi = DiaChi;
        this.bacSiId = bacSiId;
        this.leTanID = leTanID;
        this.benhnhanid = benhnhanid;
        this.tenKhachHang = tenKhachHang;
        this.PhuongThucTT = PhuongThucTT;
        this.ngaytao = ngaytao;
        this.tienKhDua = tienKhDua;
        this.tienThua = tienThua;
        this.TrangThaiText = TrangThaiText;
        this.thanhtienchitiet = thanhtienchitiet;
    }

    public String getThanhtienchitiet() {
        return thanhtienchitiet;
    }

    public void setThanhtienchitiet(String thanhtienchitiet) {
        this.thanhtienchitiet = thanhtienchitiet;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    

    public int getBenhnhanid() {
        return benhnhanid;
    }

    public void setBenhnhanid(int benhnhanid) {
        this.benhnhanid = benhnhanid;
    }
    
    
    
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

//    public ModeChiTietHoaDon(int id,int mahoadon, int madichvu, String tendichvu, String mota, String donvitinh, int soluong, double dongia, double thanhtien, String ngaythanhtoan, String trangthai) {
//        this.id = id;
//        this.mahoadon = mahoadon;
//        this.madichvu = madichvu;
//        this.tendichvu = tendichvu;
//        this.mota = mota;
//        this.donvitinh = donvitinh;
//        this.soluong = soluong;
//        this.dongia = dongia;
//        this.thanhtien = thanhtien;
//        this.ngaythanhtoan = ngaythanhtoan;
//        this.trangthai = trangthai;
//    }

    public String getNgaythanhtoan() {
        return ngaythanhtoan;
    }

    public void setNgaythanhtoan(String ngaythanhtoan) {
        this.ngaythanhtoan = ngaythanhtoan;
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
