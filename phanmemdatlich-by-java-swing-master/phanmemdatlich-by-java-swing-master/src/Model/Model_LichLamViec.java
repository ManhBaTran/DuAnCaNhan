package Model;

public class Model_LichLamViec {
    private int id;
    private int bacSiID;
    private String ngay;
    private String thoiGianBatDau;
    private String thoiGianKetThuc;
    private String ghiChu;
    private String caLamViec;
    private String trangThai;
    private String ngayTao;

    public Model_LichLamViec() {
    }

    public Model_LichLamViec(int bacSiID, String ngay, String thoiGianBatDau, String thoiGianKetThuc, String ghiChu, String caLamViec, String trangThai, String ngayTao) {
        this.bacSiID = bacSiID;
        this.ngay = ngay;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.ghiChu = ghiChu;
        this.caLamViec = caLamViec;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
    }


    public Model_LichLamViec(int id, int bacSiID, String ngay, String thoiGianBatDau, String thoiGianKetThuc, String ghiChu, String caLamViec, String trangThai, String ngayTao) {
        this.id = id;
        this.bacSiID = bacSiID;
        this.ngay = ngay;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.ghiChu = ghiChu;
        this.caLamViec = caLamViec;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBacSiID() {
        return bacSiID;
    }

    public void setBacSiID(int bacSiID) {
        this.bacSiID = bacSiID;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getCaLamViec() {
        return caLamViec;
    }

    public void setCaLamViec(String caLamViec) {
        this.caLamViec = caLamViec;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

public Object[] toDataRow(){
    return new Object[]{
        this.getId(),this.getBacSiID(),this.getNgay(),this.getThoiGianBatDau(),
    this.getThoiGianKetThuc(),this.getGhiChu(),this.getCaLamViec(),
    this.getTrangThai(),this.getNgayTao()};
    }
}
