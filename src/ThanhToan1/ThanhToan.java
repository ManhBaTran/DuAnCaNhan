package ThanhToan1;

import com.github.weisj.jsvg.attributes.filter.LayoutBounds;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class ThanhToan {
    //BenhNhan 
    private long idBn;
    private String Ten;
    private String ngaySinh;
    private String DiaChi;
    private String soDienThoai;
    private String email;
    private String gioiTinh;
    private String ngayTaoBn;
    private String trangThai;
    
    //Dịch vụ
    private long idDv;
    private String tenDv;
    private String motaDv;
    private BigDecimal chiPhiDv;
    private int soLuong;
    private String donVitinhDv;
    private String trangThaiDv;
    private Date  ngayTaoDv;

    //Hoa don ct
     private long idCtHd;
    private long mahoadon;
    private long madichvu;
    private String tendichvu;
    private String donvitinh;
    private int soLuongHdct;
    private BigDecimal dongia;
    private BigDecimal thanhtien;
    private Date ngaythanhtoan;
    private String trangthaiCthd;
    
    //hoa don
    private long idHoaDon;
    private long bacSiId;
    private long leTanID;
    private long benhnhanid;
    private String tenKhachHang;
    private String PhuongThucTT;
    private String ngaytao;
    private BigDecimal tienKhDua;
    private BigDecimal tienThua;
    private String TrangThaiText;
    private Date ngayTaoHd;
    private String trangthaiHd;

    //Lich hen
    private String trangThaiLh;
    private long  idLh;
    private Date ngayHen;
    public ThanhToan() {
    }

    //Bác sĩ
    private long idBS;

    public ThanhToan(long idBn, String Ten, String ngaySinh, String DiaChi, String soDienThoai, String email, String gioiTinh, String ngayTaoBn, String trangThai, long idDv, String tenDv, String motaDv, BigDecimal chiPhiDv, int soLuong, String donVitinhDv, String trangThaiDv, Date ngayTaoDv, long idCtHd, long mahoadon, long madichvu, String tendichvu, String donvitinh, int soLuongHdct, BigDecimal dongia, BigDecimal thanhtien, Date ngaythanhtoan, String trangthaiCthd, long idHoaDon, long bacSiId, long leTanID, long benhnhanid, String tenKhachHang, String PhuongThucTT, String ngaytao, BigDecimal tienKhDua, BigDecimal tienThua, String TrangThaiText, Date ngayTaoHd, String trangthaiHd, String trangThaiLh, long idLh, Date ngayHen, long idBS) {
        this.idBn = idBn;
        this.Ten = Ten;
        this.ngaySinh = ngaySinh;
        this.DiaChi = DiaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.ngayTaoBn = ngayTaoBn;
        this.trangThai = trangThai;
        this.idDv = idDv;
        this.tenDv = tenDv;
        this.motaDv = motaDv;
        this.chiPhiDv = chiPhiDv;
        this.soLuong = soLuong;
        this.donVitinhDv = donVitinhDv;
        this.trangThaiDv = trangThaiDv;
        this.ngayTaoDv = ngayTaoDv;
        this.idCtHd = idCtHd;
        this.mahoadon = mahoadon;
        this.madichvu = madichvu;
        this.tendichvu = tendichvu;
        this.donvitinh = donvitinh;
        this.soLuongHdct = soLuongHdct;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
        this.ngaythanhtoan = ngaythanhtoan;
        this.trangthaiCthd = trangthaiCthd;
        this.idHoaDon = idHoaDon;
        this.bacSiId = bacSiId;
        this.leTanID = leTanID;
        this.benhnhanid = benhnhanid;
        this.tenKhachHang = tenKhachHang;
        this.PhuongThucTT = PhuongThucTT;
        this.ngaytao = ngaytao;
        this.tienKhDua = tienKhDua;
        this.tienThua = tienThua;
        this.TrangThaiText = TrangThaiText;
        this.ngayTaoHd = ngayTaoHd;
        this.trangthaiHd = trangthaiHd;
        this.trangThaiLh = trangThaiLh;
        this.idLh = idLh;
        this.ngayHen = ngayHen;
        this.idBS = idBS;
    }

    

   

    public long getIdBS() {
        return idBS;
    }

    public void setIdBS(long idBS) {
        this.idBS = idBS;
    }
    
     

    

    public Date getNgayHen() {
        return ngayHen;
    }

    public void setNgayHen(Date ngayHen) {
        this.ngayHen = ngayHen;
    }

 

   
    public String getTrangThaiLh() {
        return trangThaiLh;
    }

    public void setTrangThaiLh(String trangThaiLh) {
        this.trangThaiLh = trangThaiLh;
    }

    public long getIdLh() {
        return idLh;
    }

    public void setIdLh(long idLh) {
        this.idLh = idLh;
    }

  
 
  

    public long getIdBn() {
        return idBn;
    }

    public void setIdBn(long idBn) {
        this.idBn = idBn;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
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

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgayTaoBn() {
        return ngayTaoBn;
    }

    public void setNgayTaoBn(String ngayTaoBn) {
        this.ngayTaoBn = ngayTaoBn;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public long getIdDv() {
        return idDv;
    }

    public void setIdDv(long idDv) {
        this.idDv = idDv;
    }

    public String getTenDv() {
        return tenDv;
    }

    public void setTenDv(String tenDv) {
        this.tenDv = tenDv;
    }

    public String getMotaDv() {
        return motaDv;
    }

    public void setMotaDv(String motaDv) {
        this.motaDv = motaDv;
    }

 

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

   

    public String getTrangThaiDv() {
        return trangThaiDv;
    }

    public void setTrangThaiDv(String trangThaiDv) {
        this.trangThaiDv = trangThaiDv;
    }

  

    public Date getNgayTaoDv() {
        return ngayTaoDv;
    }

    public void setNgayTaoDv(Date ngayTaoDv) {
        this.ngayTaoDv = ngayTaoDv;
    }

 
  
    public void setIdCtHd(int idCtHd) {
        this.idCtHd = idCtHd;
    }

   

    public void setMahoadon(int mahoadon) {
        this.mahoadon = mahoadon;
    }

    public long getIdCtHd() {
        return idCtHd;
    }

    public void setIdCtHd(long idCtHd) {
        this.idCtHd = idCtHd;
    }

    public long getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(long mahoadon) {
        this.mahoadon = mahoadon;
    }

    public long getMadichvu() {
        return madichvu;
    }

    public void setMadichvu(long madichvu) {
        this.madichvu = madichvu;
    }

    
    public void setMadichvu(int madichvu) {
        this.madichvu = madichvu;
    }

    public String getTendichvu() {
        return tendichvu;
    }

    public void setTendichvu(String tendichvu) {
        this.tendichvu = tendichvu;
    }

    public String getDonvitinh() {
        return donvitinh;
    }

    public void setDonvitinh(String donvitinh) {
        this.donvitinh = donvitinh;
    }

    public int getSoLuongHdct() {
        return soLuongHdct;
    }

    public void setSoLuongHdct(int soLuongHdct) {
        this.soLuongHdct = soLuongHdct;
    }

    public BigDecimal getDongia() {
        return dongia;
    }

    public void setDongia(BigDecimal dongia) {
        this.dongia = dongia;
    }
 
   

    public BigDecimal getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(BigDecimal thanhtien) {
        this.thanhtien = thanhtien;
    }

   

    public Date getNgaythanhtoan() {
        return ngaythanhtoan;
    }

    public void setNgaythanhtoan(Date ngaythanhtoan) {
        this.ngaythanhtoan = ngaythanhtoan;
    }

    public String getTrangthaiCthd() {
        return trangthaiCthd;
    }

    public void setTrangthaiCthd(String trangthaiCthd) {
        this.trangthaiCthd = trangthaiCthd;
    }

    public long getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(long idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public long getBacSiId() {
        return bacSiId;
    }

    public void setBacSiId(long bacSiId) {
        this.bacSiId = bacSiId;
    }

    public long getLeTanID() {
        return leTanID;
    }

    public void setLeTanID(long leTanID) {
        this.leTanID = leTanID;
    }

    public long getBenhnhanid() {
        return benhnhanid;
    }

    public void setBenhnhanid(long benhnhanid) {
        this.benhnhanid = benhnhanid;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getPhuongThucTT() {
        return PhuongThucTT;
    }

    public void setPhuongThucTT(String PhuongThucTT) {
        this.PhuongThucTT = PhuongThucTT;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public BigDecimal getTienKhDua() {
        return tienKhDua;
    }

    public void setTienKhDua(BigDecimal tienKhDua) {
        this.tienKhDua = tienKhDua;
    }

    public BigDecimal getTienThua() {
        return tienThua;
    }

    public void setTienThua(BigDecimal tienThua) {
        this.tienThua = tienThua;
    }

    

    public String getTrangThaiText() {
        return TrangThaiText;
    }

    public void setTrangThaiText(String TrangThaiText) {
        this.TrangThaiText = TrangThaiText;
    }

    public Date getNgayTaoHd() {
        return ngayTaoHd;
    }

    public void setNgayTaoHd(Date ngayTaoHd) {
        this.ngayTaoHd = ngayTaoHd;
    }

    

    public String getTrangthaiHd() {
        return trangthaiHd;
    }

    public void setTrangthaiHd(String trangthaiHd) {
        this.trangthaiHd = trangthaiHd;
    }

    public BigDecimal getChiPhiDv() {
        return chiPhiDv;
    }

    public void setChiPhiDv(BigDecimal chiPhiDv) {
        this.chiPhiDv = chiPhiDv;
    }

    public String getDonVitinhDv() {
        return donVitinhDv;
    }

    public void setDonVitinhDv(String donVitinhDv) {
        this.donVitinhDv = donVitinhDv;
    }
    //
            public Object[] rowdtDv(){
                return new Object[]{
                  idDv, tenDv, motaDv, chiPhiDv, soLuong, donVitinhDv,chiPhiDv, trangThaiDv
                    
                };
            }
              public Object[] rowdtHd(){
                return new Object[]{
                idHoaDon,  idBn, idBS, tenKhachHang, DiaChi , soDienThoai,trangthaiHd
                    
                };
            }
              
             public Object[] rowdtDvdd(){
                return new Object[]{
                  idDv,tenDv, motaDv, chiPhiDv, donVitinhDv , thanhtien
                    
                };
            }
              
              
              
    void setNgayTao(java.sql.Date date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

      
}
