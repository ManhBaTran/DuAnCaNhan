/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.entity;

/**
 *
 * @author ASUS
 */
public class DichVu {
    private String ten_dichvu;
    private String mota;
    private double chiphi;
    private String ngaytao;
    private String trangthai;

    public DichVu(String ten_dichvu, String mota, double chiphi, String ngaytao, String trangthai) {
        this.ten_dichvu = ten_dichvu;
        this.mota = mota;
        this.chiphi = chiphi;
        this.ngaytao = ngaytao;
        this.trangthai = trangthai;
    }

    public DichVu() {
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
