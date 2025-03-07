/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package benhnhan;

/**
 *
 * @author admin
 */
public class Model_benhan {
     private int IdBenhAn;
    private int BenhNhanID;
    private int BacSiID;
    private String ChuanDoan;
    private String DieuTri;
    private String NgayKham2;
    private String NgayLap2;
    private String MoTa2;
    private String TrangThai2;

    public Model_benhan() {
    }

    public Model_benhan(int IdBenhAn, int BenhNhanID, int BacSiID, String ChuanDoan, String DieuTri, String NgayKham2, String NgayLap2, String MoTa2, String TrangThai2) {
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
        return "Model_benhan{" + "IdBenhAn=" + IdBenhAn + ", BenhNhanID=" + BenhNhanID + ", BacSiID=" + BacSiID + ", ChuanDoan=" + ChuanDoan + ", DieuTri=" + DieuTri + ", NgayKham2=" + NgayKham2 + ", NgayLap2=" + NgayLap2 + ", MoTa2=" + MoTa2 + ", TrangThai2=" + TrangThai2 + '}';
    }
    
    
}
