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
    private int id;
    private String ten;
    private String ngaysinh;
    private String diachi;
    private String sdt;
    private String email;
    private String matkhau;
    private String gioitinh;
    private String ngaytao;
    private String trangthai;

    public Model_BenhNhan() {
    }

    public Model_BenhNhan(int id, String ten, String ngaysinh, String diachi, String sdt, String email, String matkhau, String gioitinh, String ngaytao, String trangthai) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    public Object[] todatarow(){
        return new Object[]{
            this.getId(),this.getTen(),this.getNgaysinh(),this.getDiachi(),this.getSdt(),this.getEmail(),
            this.getMatkhau(),this.getGioitinh(),this.getNgaytao(),this.getTrangthai()
        };
    }
    
    
}
