package DichVu;
public class Model_dichVu {
    private int IDdichVu;
    private String ten;
    private String moTa;
    private float chiPhi;
    private int soLuong;
    private String donViTinh;
    private String ngayTao;
    private String trangThai;

    public Model_dichVu() {
    }

    public Model_dichVu(String ten, String moTa, float chiPhi, int soLuong, String donViTinh, String ngayTao, String trangThai) {
        this.ten = ten;
        this.moTa = moTa;
        this.chiPhi = chiPhi;
        this.soLuong = soLuong;
        this.donViTinh = donViTinh;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public Model_dichVu(int IDdichVu, String ten, String moTa, float chiPhi, int soLuong, String donViTinh, String ngayTao, String trangThai) {
        this.IDdichVu = IDdichVu;
        this.ten = ten;
        this.moTa = moTa;
        this.chiPhi = chiPhi;
        this.soLuong = soLuong;
        this.donViTinh = donViTinh;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public int getIDdichVu() {
        return IDdichVu;
    }

    public void setIDdichVu(int IDdichVu) {
        this.IDdichVu = IDdichVu;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public float getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(float chiPhi) {
        this.chiPhi = chiPhi;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    
    public Object[]toDataRow1(){
        return new Object[]{
          this.getIDdichVu(),this.getTen(),this.getMoTa(),this.getChiPhi(),
            this.getSoLuong(),this.getDonViTinh(),
                this.getNgayTao(),this.getTrangThai()
        };
    }
        }
