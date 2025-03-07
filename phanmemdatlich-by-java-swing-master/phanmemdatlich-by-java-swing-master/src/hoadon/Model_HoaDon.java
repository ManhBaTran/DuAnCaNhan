package hoadon;

public class Model_HoaDon {
    private int id;
    private  int BenhNhanID;
    private int BacSiID;
    private int leTanID;
    private String TenKhachHang;
    private String DiaChi;
    private String soDienThoai;
    private String email;
    private String phuongThucThanhToan;
    private float tienKhachDua;
    private float tienThua;
    private float thanhTien;
    private String ngay;
    private String ngayThanhToan;
    private String trangThai;

    public Model_HoaDon() {
    }

    public Model_HoaDon(int BenhNhanID, int BacSiID, int leTanID, String TenKhachHang, String DiaChi, String soDienThoai, String email, String phuongThucThanhToan, float tienKhachDua, float tienThua, float thanhTien, String ngay, String ngayThanhToan, String trangThai) {
        this.BenhNhanID = BenhNhanID;
        this.BacSiID = BacSiID;
        this.leTanID = leTanID;
        this.TenKhachHang = TenKhachHang;
        this.DiaChi = DiaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.tienKhachDua = tienKhachDua;
        this.tienThua = tienThua;
        this.thanhTien = thanhTien;
        this.ngay = ngay;
        this.ngayThanhToan = ngayThanhToan;
        this.trangThai = trangThai;
    }

    public Model_HoaDon(int id, int BenhNhanID, int BacSiID, int leTanID, String TenKhachHang, String DiaChi, String soDienThoai, String email, String phuongThucThanhToan, float tienKhachDua, float tienThua, float thanhTien, String ngay, String ngayThanhToan, String trangThai) {
        this.id = id;
        this.BenhNhanID = BenhNhanID;
        this.BacSiID = BacSiID;
        this.leTanID = leTanID;
        this.TenKhachHang = TenKhachHang;
        this.DiaChi = DiaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.tienKhachDua = tienKhachDua;
        this.tienThua = tienThua;
        this.thanhTien = thanhTien;
        this.ngay = ngay;
        this.ngayThanhToan = ngayThanhToan;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getLeTanID() {
        return leTanID;
    }

    public void setLeTanID(int leTanID) {
        this.leTanID = leTanID;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public float getTienKhachDua() {
        return tienKhachDua;
    }

    public void setTienKhachDua(float tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public float getTienThua() {
        return tienThua;
    }

    public void setTienThua(float tienThua) {
        this.tienThua = tienThua;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }


    public  Object[] toDataRow(){
        return new Object[]{
            this.getId(),this.getBenhNhanID(),this.getBacSiID(),this.getLeTanID(),
                this.getTenKhachHang(),this.getDiaChi(),this.getSoDienThoai(),
                this.getEmail(),this.getPhuongThucThanhToan(),this.getTienKhachDua(),
                this.getTienThua(),this.getThanhTien(),this.getNgay(),this.getNgayThanhToan(),
                this.getTrangThai()
       };
    }
            
            
}
