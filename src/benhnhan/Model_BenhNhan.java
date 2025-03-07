/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package benhnhan;

import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Model_BenhNhan {
    private String id;
    private String ten;
    private String ngaysinh;
    private String diachi;
    private String sdt;
    private String email;
    private String matkhau;
    private String gioitinh;
    private String ngaytao;
    private String trangthai;
    private int IdBenhAn;
    private int BenhNhanID;
    private int BacSiID;
    private String ChuanDoan;
    private String DieuTri;
    private String NgayKham2;
    private String NgayLap2;
    private String MoTa2;
    private String TrangThai2;

    public Model_BenhNhan() {
    }

    public Model_BenhNhan(String ten, String ngaysinh, String diachi, String sdt, String email, String matkhau, String gioitinh, String ngaytao, String trangthai) {
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.email = email;
        this.matkhau = matkhau;
        this.gioitinh = gioitinh;
        this.ngaytao = ngaytao;
        this.trangthai = trangthai;
    }
    

    public Model_BenhNhan(String  id, String ten, String ngaysinh, String diachi, String sdt, String email, String matkhau, String gioitinh, String ngaytao, String trangthai) {
        this.id = id;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.email = email;
        this.matkhau = matkhau;
        this.gioitinh = gioitinh;
        this.ngaytao = ngaytao;
        this.trangthai = trangthai;
    }

    public Model_BenhNhan(String id, String ten, String ngaysinh, String diachi, String sdt, String email, String matkhau, String gioitinh, String ngaytao, String trangthai, int IdBenhAn, int BenhNhanID, int BacSiID, String ChuanDoan, String DieuTri, String NgayKham2, String NgayLap2, String MoTa2, String TrangThai2) {
        this.id = id;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.email = email;
        this.matkhau = matkhau;
        this.gioitinh = gioitinh;
        this.ngaytao = ngaytao;
        this.trangthai = trangthai;
        this.IdBenhAn = IdBenhAn;
        this.BenhNhanID = BenhNhanID;
        this.BacSiID = BacSiID;
        this.ChuanDoan = ChuanDoan;
        this.DieuTri = DieuTri;
        this.NgayKham2 = NgayKham2;
        this.NgayLap2 = NgayLap2;
        this.MoTa2 = MoTa2;
        this.TrangThai2 = TrangThai2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public int getIdBenhAn() {
        return IdBenhAn;
    }

    public void setIdBenhAn(int IdBenhAn) {
        this.IdBenhAn = IdBenhAn;
    }

    public int getBenhNhanID() {
        return BenhNhanID;
    }

    public void setBenhNhanID(int BenhNhanID) {
        this.BenhNhanID = BenhNhanID;
    }

    public int getBacSiID() {
        return BacSiID;
    }

    public void setBacSiID(int BacSiID) {
        this.BacSiID = BacSiID;
    }

    public String getChuanDoan() {
        return ChuanDoan;
    }

    public void setChuanDoan(String ChuanDoan) {
        this.ChuanDoan = ChuanDoan;
    }

    public String getDieuTri() {
        return DieuTri;
    }

    public void setDieuTri(String DieuTri) {
        this.DieuTri = DieuTri;
    }

    public String getNgayKham2() {
        return NgayKham2;
    }

    public void setNgayKham2(String NgayKham2) {
        this.NgayKham2 = NgayKham2;
    }

    public String getNgayLap2() {
        return NgayLap2;
    }

    public void setNgayLap2(String NgayLap2) {
        this.NgayLap2 = NgayLap2;
    }

    public String getMoTa2() {
        return MoTa2;
    }

    public void setMoTa2(String MoTa2) {
        this.MoTa2 = MoTa2;
    }

    public String getTrangThai2() {
        return TrangThai2;
    }

    public void setTrangThai2(String TrangThai2) {
        this.TrangThai2 = TrangThai2;
    }

    @Override
    public String toString() {
        return "Model_BenhNhan{" + "id=" + id + ", ten=" + ten + ", ngaysinh=" + ngaysinh + ", diachi=" + diachi + ", sdt=" + sdt + ", email=" + email + ", matkhau=" + matkhau + ", gioitinh=" + gioitinh + ", ngaytao=" + ngaytao + ", trangthai=" + trangthai + ", IdBenhAn=" + IdBenhAn + ", BenhNhanID=" + BenhNhanID + ", BacSiID=" + BacSiID + ", ChuanDoan=" + ChuanDoan + ", DieuTri=" + DieuTri + ", NgayKham2=" + NgayKham2 + ", NgayLap2=" + NgayLap2 + ", MoTa2=" + MoTa2 + ", TrangThai2=" + TrangThai2 + '}';
    }

   

    
   

    
    
}
