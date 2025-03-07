/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.ph49571;

/**
 *
 * @author ASUS
 */
public class ModeDichVu {
    private int stt;
    private String ten_dichvu;
    private String mota;
    private double chiphi;
    private int soluong;
    private String donvitinh;
    private String ngaytao;
    private String trangthai;

    public ModeDichVu(int stt ,String ten_dichvu, String mota, double chiphi, String ngaytao, String trangthai , int soluong , String donvitinh) {
        this.stt = stt;
        this.ten_dichvu = ten_dichvu;
        this.mota = mota;
        this.chiphi = chiphi;
        this.ngaytao = ngaytao;
        this.trangthai = trangthai;
        this.soluong = soluong;
        this.donvitinh = donvitinh;
    }

    public int getStt() {
        return stt;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getDonvitinh() {
        return donvitinh;
    }

    public void setDonvitinh(String donvitinh) {
        this.donvitinh = donvitinh;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public ModeDichVu() {
    }

    public String getTen_dichvu() {
        return ten_dichvu;
    }

    public void setTen_dichvu(String ten_dichvu) {
        this.ten_dichvu = ten_dichvu;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public double getChiphi() {
        return chiphi;
    }

    public void setChiphi(double chiphi) {
        this.chiphi = chiphi;
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
    

    
}
