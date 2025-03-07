/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.entity;

import java.util.Date;

/**
 *
 * @author manh9
 */
public class TrangChu {
    private String tenBenhNhan;
    private String tenBacSi;
    private Date ngayHen;
    private String gioHen;
    private Date ngayDatLich;
    private String trangThai;
    // Getters and Setters

    private long id;
    private int soNamKinhNghiem;
    private String chuyenKhoa;
    private String sdt;
     
    public TrangChu() {
    }

    public TrangChu(String tenBenhNhan, String tenBacSi, Date ngayHen, String gioHen, Date ngayDatLich, String trangThai, long id, int soNamKinhNghiem, String chuyenKhoa, String sdt) {
        this.tenBenhNhan = tenBenhNhan;
        this.tenBacSi = tenBacSi;
        this.ngayHen = ngayHen;
        this.gioHen = gioHen;
        this.ngayDatLich = ngayDatLich;
        this.trangThai = trangThai;
        this.id = id;
        this.soNamKinhNghiem = soNamKinhNghiem;
        this.chuyenKhoa = chuyenKhoa;
        this.sdt = sdt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSoNamKinhNghiem() {
        return soNamKinhNghiem;
    }

    public void setSoNamKinhNghiem(int soNamKinhNghiem) {
        this.soNamKinhNghiem = soNamKinhNghiem;
    }

    public String getChuyenKhoa() {
        return chuyenKhoa;
    }

    public void setChuyenKhoa(String chuyenKhoa) {
        this.chuyenKhoa = chuyenKhoa;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    
    
    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public String getTenBacSi() {
        return tenBacSi;
    }

    public void setTenBacSi(String tenBacSi) {
        this.tenBacSi = tenBacSi;
    }

    public Date getNgayHen() {
        return ngayHen;
    }

    public void setNgayHen(Date ngayHen) {
        this.ngayHen = ngayHen;
    }

    public String getGioHen() {
        return gioHen;
    }

    public void setGioHen(String gioHen) {
        this.gioHen = gioHen;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    

    public Date getNgayDatLich() {
        return ngayDatLich;
    }

    public void setNgayDatLich(Date ngayDatLich) {
        this.ngayDatLich = ngayDatLich;
    }
    public Object[] rowDtTT(){
        return new Object[]{
            tenBenhNhan, tenBacSi, ngayHen, gioHen, ngayDatLich, trangThai
        };
    }
    
    public Object[] rowDtBs(){
        return new Object[]{
            id, tenBacSi, soNamKinhNghiem, chuyenKhoa, sdt, trangThai
        };
    }
    
}
