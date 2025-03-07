/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.entity;

import java.time.LocalTime;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author manh9
 */
public class LichLamViec {
    private int MaBacSi;
    private Date Ngay;
    private String CaLamViec;
    private LocalTime thoi_gian_bat_dau;
    private LocalTime thoi_gian_ket_thuc;
    private String GhiChu;
    private String TrangThai;
    private Date NgayTao;


    public LichLamViec() {
    }

    public LichLamViec(int MaNhanVien, Date Ngay, String CaLamViec, LocalTime thoi_gian_bat_dau, LocalTime thoi_gian_ket_thuc, String GhiChu, String TrangThai, Date NgayTao) {
        this.MaBacSi = MaNhanVien;
        this.Ngay = Ngay;
        this.CaLamViec = CaLamViec;
        this.thoi_gian_bat_dau = thoi_gian_bat_dau;
        this.thoi_gian_ket_thuc = thoi_gian_ket_thuc;
        this.GhiChu = GhiChu;
        this.TrangThai = TrangThai;
        this.NgayTao = NgayTao;
    }

    public int getMaBacSi() {
        return MaBacSi;
    }

    public void setMaBacSi(int MaBacSi) {
        this.MaBacSi = MaBacSi;
    }

 

  

    public Date getNgay() {
        return Ngay;
    }

    public void setNgay(Date Ngay) {
        this.Ngay = Ngay;
    }

    public String getCaLamViec() {
        return CaLamViec;
    }

    public void setCaLamViec(String CaLamViec) {
        this.CaLamViec = CaLamViec;
    }

    public LocalTime getThoi_gian_bat_dau() {
        return thoi_gian_bat_dau;
    }

    public void setThoi_gian_bat_dau(LocalTime thoi_gian_bat_dau) {
        this.thoi_gian_bat_dau = thoi_gian_bat_dau;
    }

    public LocalTime getThoi_gian_ket_thuc() {
        return thoi_gian_ket_thuc;
    }

    public void setThoi_gian_ket_thuc(LocalTime thoi_gian_ket_thuc) {
        this.thoi_gian_ket_thuc = thoi_gian_ket_thuc;
    }

   
    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }


    public Object[] rowData(){
        return new Object[]{
            MaBacSi, Ngay,  thoi_gian_bat_dau, thoi_gian_ket_thuc, GhiChu, CaLamViec,TrangThai,  NgayTao
        };
    }
}
