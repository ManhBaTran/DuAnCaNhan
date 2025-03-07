/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.entity;

import java.util.Date;

/**
 *
 * @author admin
 */
public class LichHen {

    private int maBenhNhan;
    private int maBacSi;
    private String ngayhen;
    private String giohen;
    private Date ngaydatlich;
    private String trang_thai;

    public LichHen() {
    }

    public LichHen(int maBenhNhan, int maBacSi, String ngayhen, String giohen, Date ngaydatlich, String trang_thai) {
        this.maBenhNhan = maBenhNhan;
        this.maBacSi = maBacSi;
        this.ngayhen = ngayhen;
        this.giohen = giohen;
        this.ngaydatlich = ngaydatlich;
        this.trang_thai = trang_thai;
    }

    public String getNgayhen() {
        return ngayhen;
    }

    public void setNgayhen(String ngayhen) {
        this.ngayhen = ngayhen;
    }

    public String getGiohen() {
        return giohen;
    }

    public void setGiohen(String giohen) {
        this.giohen = giohen;
    }

    public String getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
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

    public Date getNgaydatlich() {
        return ngaydatlich;
    }

    public void setNgaydatlich(Date ngaydatlich) {
        this.ngaydatlich = ngaydatlich;
    }

    public Object[] rowData(){
        return new Object[]{
            maBenhNhan, maBacSi, ngayhen, giohen, ngaydatlich, trang_thai
        };
    }
}
