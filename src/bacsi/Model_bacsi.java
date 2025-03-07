/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bacsi;

/**
 *
 * @author admin
 */
public class Model_bacsi {
    private int id;
    private String ten;
    private String email;
    private String sdt;
    private String matkhau;
    private String chuyenkhoa;
    private String sonamkinhnghiem;
    private String ngaytao;
    private String trangthai;

    public Model_bacsi() {
    }

    public Model_bacsi(String ten, String email, String sdt, String matkhau, String chuyenkhoa, String sonamkinhnghiem, String ngaytao, String trangthai) {
        this.ten = ten;
        this.email = email;
        this.sdt = sdt;
        this.matkhau = matkhau;
        this.chuyenkhoa = chuyenkhoa;
        this.sonamkinhnghiem = sonamkinhnghiem;
        this.ngaytao = ngaytao;
        this.trangthai = trangthai;
    }

    public Model_bacsi(int id, String ten, String email, String sdt, String matkhau, String chuyenkhoa, String sonamkinhnghiem, String ngaytao, String trangthai) {
        this.id = id;
        this.ten = ten;
        this.email = email;
        this.sdt = sdt;
        this.matkhau = matkhau;
        this.chuyenkhoa = chuyenkhoa;
        this.sonamkinhnghiem = sonamkinhnghiem;
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getChuyenkhoa() {
        return chuyenkhoa;
    }

    public void setChuyenkhoa(String chuyenkhoa) {
        this.chuyenkhoa = chuyenkhoa;
    }

    public String getSonamkinhnghiem() {
        return sonamkinhnghiem;
    }

    public void setSonamkinhnghiem(String sonamkinhnghiem) {
        this.sonamkinhnghiem = sonamkinhnghiem;
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
    public Object[]todatarow(){
    return new Object[]{
        this.getId(),this.getTen(),this.getEmail(),this.getSdt(),this.getMatkhau(),
        this.getChuyenkhoa(),this.getSonamkinhnghiem(),this.getNgaytao(),this.getTrangthai(),
    };
}
    
}
