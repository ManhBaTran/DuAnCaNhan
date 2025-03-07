/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.ph49507;

/**
 *
 * @author admin
 */
public class BenhAn {

    private int id;
    private int mabenhnhan;
    private int mabacsi;
    private String chandoan;
    private String dieutri;
    private String ngaykham;
    private String ngaylapbenhan;
    private String mota;
    private String trangthai;

    public BenhAn() {
    }

    public BenhAn(int id, int mabenhnhan, int mabacsi, String chandoan, String dieutri, String ngaykham, String ngaylapbenhan, String mota, String trangthai) {
        this.id = id;
        this.mabenhnhan = mabenhnhan;
        this.mabacsi = mabacsi;
        this.chandoan = chandoan;
        this.dieutri = dieutri;
        this.ngaykham = ngaykham;
        this.ngaylapbenhan = ngaylapbenhan;
        this.mota = mota;
        this.trangthai = trangthai;
    }

    public BenhAn(int mabenhnhan, int mabacsi, String chandoan, String dieutri, String ngaykham, String ngaylapbenhan, String mota, String trangthai) {
        this.mabenhnhan = mabenhnhan;
        this.mabacsi = mabacsi;
        this.chandoan = chandoan;
        this.dieutri = dieutri;
        this.ngaykham = ngaykham;
        this.ngaylapbenhan = ngaylapbenhan;
        this.mota = mota;
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMabenhnhan() {
        return mabenhnhan;
    }

    public void setMabenhnhan(int mabenhnhan) {
        this.mabenhnhan = mabenhnhan;
    }

    public int getMabacsi() {
        return mabacsi;
    }

    public void setMabacsi(int mabacsi) {
        this.mabacsi = mabacsi;
    }

    public String getChandoan() {
        return chandoan;
    }

    public void setChandoan(String chandoan) {
        this.chandoan = chandoan;
    }

    public String getDieutri() {
        return dieutri;
    }

    public void setDieutri(String dieutri) {
        this.dieutri = dieutri;
    }

    public String getNgaykham() {
        return ngaykham;
    }

    public void setNgaykham(String ngaykham) {
        this.ngaykham = ngaykham;
    }

    public String getNgaylapbenhan() {
        return ngaylapbenhan;
    }

    public void setNgaylapbenhan(String ngaylapbenhan) {
        this.ngaylapbenhan = ngaylapbenhan;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public Object[] todatarow() {
        return new Object[]{
            this.getId(), this.getMabenhnhan(), this.getMabacsi(), this.getChandoan(), this.getDieutri(), this.getNgaykham(), this.getNgaylapbenhan(),
            this.getMota(), this.getTrangthai()
        };
    }
}
