/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.entity;

/**
 *
 * @author ASUS
 */
public class ChiTietHoaDon {
    private int mahoadon;
    private int madichvu;
    private String TenDichVu;
    private String MoTaDichVu;
    private String DonViTinh;
    private int soluong;
    private float dongia;
    private float ThanhTien;
    private String trangthai;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int mahoadon, int madichvu, String TenDichVu, String MoTaDichVu, String DonViTinh, int soluong, float dongia, float ThanhTien, String trangthai) {
        this.mahoadon = mahoadon;
        this.madichvu = madichvu;
        this.TenDichVu = TenDichVu;
        this.MoTaDichVu = MoTaDichVu;
        this.DonViTinh = DonViTinh;
        this.soluong = soluong;
        this.dongia = dongia;
        this.ThanhTien = ThanhTien;
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

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getTenDichVu() {
        return TenDichVu;
    }

    public void setTenDichVu(String TenDichVu) {
        this.TenDichVu = TenDichVu;
    }

    public String getMoTaDichVu() {
        return MoTaDichVu;
    }

    public void setMoTaDichVu(String MoTaDichVu) {
        this.MoTaDichVu = MoTaDichVu;
    }

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String DonViTinh) {
        this.DonViTinh = DonViTinh;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

  

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
    
    public Object[] rowData(){
        return new Object[]{
            mahoadon, madichvu, TenDichVu, MoTaDichVu, DonViTinh, soluong, dongia, ThanhTien, trangthai
        };
    }
}
