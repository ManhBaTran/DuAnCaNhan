package com.poly.entity;

import java.util.Date;

/**
 *
 * @author admin
 */
public class BenhAn {

    private int maBenhNhan;
    private int maBacSi;
    private String chanDoan;
    private String dieuTri;
    private Date ngayKham;
    private Date ngayLapBenhAn;
    private String moTa;
    private String trangThai;

    public BenhAn() {
    }

    public BenhAn(int maBenhNhan, int maBacSi, String chanDoan, String dieuTri, Date ngayKham, Date ngayLapBenhAn, String moTa, String trangThai) {
        this.maBenhNhan = maBenhNhan;
        this.maBacSi = maBacSi;
        this.chanDoan = chanDoan;
        this.dieuTri = dieuTri;
        this.ngayKham = ngayKham;
        this.ngayLapBenhAn = ngayLapBenhAn;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public int getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(int maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public int getMaBacSi() {
        return maBacSi;
    }

    public void setMaBacSi(int maBacSi) {
        this.maBacSi = maBacSi;
    }

    public String getChanDoan() {
        return chanDoan;
    }

    public void setChanDoan(String chanDoan) {
        this.chanDoan = chanDoan;
    }

    public String getDieuTri() {
        return dieuTri;
    }

    public void setDieuTri(String dieuTri) {
        this.dieuTri = dieuTri;
    }

    public Date getNgayKham() {
        return ngayKham;
    }

    public void setNgayKham(Date ngayKham) {
        this.ngayKham = ngayKham;
    }

    public Date getNgayLapBenhAn() {
        return ngayLapBenhAn;
    }

    public void setNgayLapBenhAn(Date ngayLapBenhAn) {
        this.ngayLapBenhAn = ngayLapBenhAn;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Object[] rowData(){
        return new Object[]{
            maBenhNhan, maBacSi, chanDoan, dieuTri, ngayKham, ngayLapBenhAn, moTa, trangThai
        };
    }
}
