package com.poly.entity;

import java.time.LocalTime;
import java.time.LocalDate;

/**
 *
 * @author manh9
 */
public class BacSiLichLamViec {
    private long idBS;
    private String tenBacSi;
    private LocalDate ngayLamViec;
    private LocalTime thoiGianBatDau;
    private LocalTime thoiGianKetThuc;
    private String caLamViec;
    private String trangThaiBS;

    // lich hen
    private long idLH;
    private long idBN;
    private LocalDate ngayHen;
    private LocalTime gioHen;
    private LocalDate ngayDatLich;
    private String trangThaiLH;
    // Bệnh nhân
    private String tenBN;
    private String ngaysinh;
    private String diachi;
    private String sdtBN;
    private String email;
    private String matkhau;
    private String gioitinh;
    private String ngaytao;
    private String trangthaiBN;

    public BacSiLichLamViec() {
    }

    // Constructor

    public BacSiLichLamViec(long idBS, String tenBacSi, LocalDate ngayLamViec, LocalTime thoiGianBatDau, LocalTime thoiGianKetThuc, String caLamViec, String trangThaiBS, long idLH, long idBN, LocalDate ngayHen, LocalTime gioHen, LocalDate ngayDatLich, String trangThaiLH, String tenBN, String ngaysinh, String diachi, String sdtBN, String email, String matkhau, String gioitinh, String ngaytao, String trangthaiBN) {
        this.idBS = idBS;
        this.tenBacSi = tenBacSi;
        this.ngayLamViec = ngayLamViec;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.caLamViec = caLamViec;
        this.trangThaiBS = trangThaiBS;
        this.idLH = idLH;
        this.idBN = idBN;
        this.ngayHen = ngayHen;
        this.gioHen = gioHen;
        this.ngayDatLich = ngayDatLich;
        this.trangThaiLH = trangThaiLH;
        this.tenBN = tenBN;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.sdtBN = sdtBN;
        this.email = email;
        this.matkhau = matkhau;
        this.gioitinh = gioitinh;
        this.ngaytao = ngaytao;
        this.trangthaiBN = trangthaiBN;
    }

   
     

    // Getter and Setter methods

    public long getIdBS() {
        return idBS;
    }

    public void setIdBS(long idBS) {
        this.idBS = idBS;
    }

    public String getTenBacSi() {
        return tenBacSi;
    }

    public void setTenBacSi(String tenBacSi) {
        this.tenBacSi = tenBacSi;
    }

    public LocalDate getNgayLamViec() {
        return ngayLamViec;
    }

    public void setNgayLamViec(LocalDate ngayLamViec) {
        this.ngayLamViec = ngayLamViec;
    }

    public LocalTime getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(LocalTime thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public LocalTime getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(LocalTime thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getCaLamViec() {
        return caLamViec;
    }

    public void setCaLamViec(String caLamViec) {
        this.caLamViec = caLamViec;
    }

    public String getTrangThaiBS() {
        return trangThaiBS;
    }

    public void setTrangThaiBS(String trangThaiBS) {
        this.trangThaiBS = trangThaiBS;
    }

    public String getTrangthaiBN() {
        return trangthaiBN;
    }

    public void setTrangthaiBN(String trangthaiBN) {
        this.trangthaiBN = trangthaiBN;
    }

    

    public long getIdLH() {
        return idLH;
    }

    public void setIdLH(long idLH) {
        this.idLH = idLH;
    }

    public long getIdBN() {
        return idBN;
    }

    public void setIdBN(long idBN) {
        this.idBN = idBN;
    }

    public LocalDate getNgayHen() {
        return ngayHen;
    }

    public void setNgayHen(LocalDate ngayHen) {
        this.ngayHen = ngayHen;
    }

    public LocalTime getGioHen() {
        return gioHen;
    }

    public void setGioHen(LocalTime gioHen) {
        this.gioHen = gioHen;
    }

    public LocalDate getNgayDatLich() {
        return ngayDatLich;
    }

    public void setNgayDatLich(LocalDate ngayDatLich) {
        this.ngayDatLich = ngayDatLich;
    }

    public String getTenBN() {
        return tenBN;
    }

    public void setTenBN(String tenBN) {
        this.tenBN = tenBN;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdtBN() {
        return sdtBN;
    }

    public void setSdtBN(String sdtBN) {
        this.sdtBN = sdtBN;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getTrangThaiLH() {
        return trangThaiLH;
    }

    public void setTrangThaiLH(String trangThaiLH) {
        this.trangThaiLH = trangThaiLH;
    }

    

    // Methods for returning data as Object arrays
    public Object[] rowDtBsLlv() {
        return new Object[]{
            idBS, tenBacSi, ngayLamViec, thoiGianBatDau, thoiGianKetThuc, caLamViec, trangThaiBS
        };
    }   

    public Object[] rowDtLH() {
        return new Object[]{
             idLH, tenBN, sdtBN, email, diachi, ngaysinh, gioitinh, tenBacSi, ngayHen, gioHen, ngayDatLich, trangThaiLH
        };
    }
}
