package com.poly.entity;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Date;
import org.apache.poi.hpsf.Decimal;

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
    private int soLuongbn;

    // lich hen
    private long idLH;
    private long idBenhNhan;
    private LocalDate ngayHen;
    private LocalTime gioHen;
    private LocalDate ngayDatLich;
    private String trangThaiLH;
    // Bệnh nhân
    private String tenBN;
    private Date ngaysinh;
    private String diachi;
    private String sdtBN;
    private String email;
    private String matkhau;
    private String gioitinh;
    private String ngaytao;
    private String trangthaiBN;

    //dịch vụ
    private long idDV;
    private String tenDV;
    private BigDecimal chiPhi;
    public BacSiLichLamViec() {
    }

    // Constructor

    public BacSiLichLamViec(long idBS, String tenBacSi, LocalDate ngayLamViec, LocalTime thoiGianBatDau, LocalTime thoiGianKetThuc, String caLamViec, String trangThaiBS, int soLuongbn, long idLH, long idBenhNhan, LocalDate ngayHen, LocalTime gioHen, LocalDate ngayDatLich, String trangThaiLH, String tenBN, Date ngaysinh, String diachi, String sdtBN, String email, String matkhau, String gioitinh, String ngaytao, String trangthaiBN, long idDV, String tenDV, BigDecimal chiPhi) {
        this.idBS = idBS;
        this.tenBacSi = tenBacSi;
        this.ngayLamViec = ngayLamViec;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.caLamViec = caLamViec;
        this.trangThaiBS = trangThaiBS;
        this.soLuongbn = soLuongbn;
        this.idLH = idLH;
        this.idBenhNhan = idBenhNhan;
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
        this.idDV = idDV;
        this.tenDV = tenDV;
        this.chiPhi = chiPhi;
    }

 

    public long getIdDV() {
        return idDV;
    }

    public void setIdDV(long idDV) {
        this.idDV = idDV;
    }
     

    public String getTenDV() {   
        return tenDV;
    }

    public void setTenDV(String tenDV) {    
        this.tenDV = tenDV;
    }

    public BigDecimal getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(BigDecimal chiPhi) {
        this.chiPhi = chiPhi;
    }

    public int getSoLuongbn() {
        return soLuongbn;
    }

    public void setSoLuongbn(int soLuongbn) {
        this.soLuongbn = soLuongbn;
    }

 
 

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

    public long getIdBenhNhan() {
        return idBenhNhan;
    }

    public void setIdBenhNhan(long idBenhNhan) {
        this.idBenhNhan = idBenhNhan;
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

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
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
            idBS, tenBacSi, ngayLamViec, thoiGianBatDau, thoiGianKetThuc, caLamViec, soLuongbn,trangThaiBS
        };
    }   

        public Object[] rowDtLH() {
            return new Object[]{
                    idLH, idBenhNhan,idBS,tenBN, sdtBN, diachi, ngaysinh, gioitinh, tenBacSi, ngayHen, gioHen, ngayDatLich,tenDV, chiPhi, trangThaiLH
            };
        }

   
        
}
