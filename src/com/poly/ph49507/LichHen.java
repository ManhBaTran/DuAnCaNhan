/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.ph49507;

/**
 *
 * @author admin
 */
public class LichHen {
    private int id;
    private int mabenhnhan;
    private int mabacsi;
    private String ngayhen;
    private String giohen;
    private String ngaydatlich;
    private String trang_thai;
    

    public LichHen() {
    }

    public LichHen(int id, int mabenhnhan, int mabacsi, String ngayhen, String giohen, String ngaydatlich, String trang_thai) {
        this.id = id;
        this.mabenhnhan = mabenhnhan;
        this.mabacsi = mabacsi;
        this.ngayhen = ngayhen;
        this.giohen = giohen;
        this.ngaydatlich = ngaydatlich;
        this.trang_thai = trang_thai;
    }

    public LichHen(int mabenhnhan, int mabacsi, String ngayhen, String giohen, String ngaydatlich, String trang_thai) {
        this.mabenhnhan = mabenhnhan;
        this.mabacsi = mabacsi;
        this.ngayhen = ngayhen;
        this.giohen = giohen;
        this.ngaydatlich = ngaydatlich;
        this.trang_thai = trang_thai;
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

    public String getNgaydatlich() {
        return ngaydatlich;
    }

    public void setNgaydatlich(String ngaydatlich) {
        this.ngaydatlich = ngaydatlich;
    }

    public String getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }


    public Object[] todatarow(){
        return new Object[]{
            this.getId(),this.getMabenhnhan(),this.getMabacsi(),this.getNgayhen(),this.getGiohen(),
            this.getNgaydatlich(),this.getTrang_thai()  
        };
    }
}
