/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package letan;

/**
 *
 * @author admin
 */
public class Model_Letan {
    private int id;
    private String ten;
    private String email;
    private String sodienthoai;
    private String matkhau;
    private String diachi;
    private String ngaysinh;
    private String gioitinh;
    private String ngaytao;
    private String trangthai;

    public Model_Letan() {
    }

    public Model_Letan(int id, String ten, String email, String sodienthoai, String matkhau, String diachi, String ngaysinh, String gioitinh, String ngaytao, String trangthai) {
        this.id = id;
        this.ten = ten;
        this.email = email;
        this.sodienthoai = sodienthoai;
        this.matkhau = matkhau;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.ngaytao = ngaytao;
        this.trangthai = trangthai;
    }

    public Model_Letan(String ten, String email, String sodienthoai, String matkhau, String diachi, String ngaysinh, String gioitinh, String ngaytao, String trangthai) {
        this.ten = ten;
        this.email = email;
        this.sodienthoai = sodienthoai;
        this.matkhau = matkhau;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
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
            this.getId(),this.getTen(),this.getEmail(),this.getSodienthoai(),this.getMatkhau(),
            this.getDiachi(),this.getNgaysinh(),this.getGioitinh(),this.getNgaytao(),
            this.getTrangthai()
        };
    }
    
}
