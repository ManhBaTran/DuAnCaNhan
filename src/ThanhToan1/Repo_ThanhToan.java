package ThanhToan1;
 
import com.poly.database.DBConnect;
import com.poly.entity.BacSiLichLamViec;
 
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class Repo_ThanhToan {
 private Connection con = null;
 private PreparedStatement ps = null;
 private   ResultSet rs = null;
 private String sql;
     
    
   public List<ThanhToan> getAllDichVu() {
     List<ThanhToan> list = new ArrayList<>();
    String sql = """
                                    SELECT [ID]
                                          ,[Ten]
                                          ,[MoTa]
                                          ,[ChiPhi]
                                          ,[SoLuong]
                                          ,[DonViTinh]
                                          ,[TrangThai]
                                      FROM [dbo].[DichVu]
                  """;

    try (Connection con = DBConnect.getConnect();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            ThanhToan dichVu = new ThanhToan();
            dichVu.setIdDv(rs.getLong(1));
            dichVu.setTenDv(rs.getString(2));
            dichVu.setMotaDv(rs.getString(3));
            dichVu.setChiPhiDv(rs.getBigDecimal(4));
            dichVu.setSoLuong(rs.getInt(5));
            dichVu.setDonVitinhDv(rs.getString(6));
            dichVu.setTrangThaiDv(rs.getString(7));

            list.add(dichVu);
        }
    } catch (Exception e) {
        e.printStackTrace();  
    } 

    return list;
}
public List<ThanhToan> searchDichVu(String keyword) {
    List<ThanhToan> list = new ArrayList<>();
    String sql = """
                  SELECT [ID]
                        ,[Ten]
                        ,[MoTa]
                        ,[ChiPhi]
                        ,[SoLuong]
                        ,[DonViTinh]
                        ,[ChiPhi]
                        ,[TrangThai]
                    FROM [dbo].[DichVu]
                    WHERE [ID] = ? OR [Ten] LIKE ?
                  """;

    try (Connection con = DBConnect.getConnect();
         PreparedStatement ps = con.prepareStatement(sql)) {

        // Kiểm tra nếu keyword có thể là ID (số) hoặc Tên (chuỗi)
        if (keyword.matches("\\d+")) {
            // Tìm kiếm theo ID
            ps.setLong(1, Long.parseLong(keyword));
            ps.setString(2, "%"); // Không cần lọc theo tên
        } else {
            // Tìm kiếm theo tên
            ps.setLong(1, -1); // Đặt một giá trị không hợp lệ cho ID
            ps.setString(2, "%" + keyword + "%"); // Tìm kiếm theo tên
        }

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ThanhToan dichVu = new ThanhToan();
                dichVu.setIdDv(rs.getLong(1));
                dichVu.setTenDv(rs.getString(2));
                dichVu.setMotaDv(rs.getString(3));
                dichVu.setChiPhiDv(rs.getBigDecimal(4));
                dichVu.setSoLuong(rs.getInt(5));
                dichVu.setDonVitinhDv(rs.getString(6));
                dichVu.setChiPhiDv(rs.getBigDecimal(7));
                dichVu.setTrangThaiDv(rs.getString(8));

                list.add(dichVu);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}

public List<ThanhToan> getAllBn() {
    List<ThanhToan> list = new ArrayList<>();
    String sql = """
          SELECT       ID,
                                  [BenhNhanID]
                                  ,[BacSiID]
                                  ,[TenKhachHang]
                                  ,[DiaChi]
                                  ,[SoDienThoai]       
                                  ,[TrangThai]
                              FROM [dbo].[HoaDon]
    """;

    try (Connection con = DBConnect.getConnect();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            ThanhToan tt = new ThanhToan();

            // Map SQL columns to ThanhToan object fields
           tt.setIdHoaDon(rs.getLong("ID"));
            tt.setIdBn(rs.getLong("BenhNhanID"));
            tt.setTenKhachHang(rs.getString("TenKhachHang"));
            tt.setDiaChi(rs.getString("DiaChi"));
            tt.setSoDienThoai(rs.getString("SoDienThoai"));
            tt.setIdBS(rs.getLong("BacSiID"));
            tt.setTrangthaiHd(rs.getString("TrangThai"));

            list.add(tt);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}

public boolean deleteInvoiceById(long idHoaDon) {
    String sql = "DELETE FROM [dbo].[HoaDon] WHERE ID = ?";
    try (Connection con = DBConnect.getConnect();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setLong(1, idHoaDon);

        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0; // Trả về true nếu xóa thành công
    } catch (Exception e) {
        e.printStackTrace();
        return false; // Trả về false nếu có lỗi xảy ra
    }
}



public List<ThanhToan> getAllBnByTrangThai(String trangThai) {
    List<ThanhToan> list = new ArrayList<>();
    String sql = """
          SELECT Id,
              [BenhNhanID],
              [BacSiID],
              [TenKhachHang],
              [DiaChi],
              [SoDienThoai],
              [TrangThai]
          FROM [dbo].[HoaDon]
          WHERE [TrangThai] = ?
          ORDER BY [ID] DESC;
    """;

    try (Connection con = DBConnect.getConnect();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, trangThai);
        
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ThanhToan tt = new ThanhToan();
                tt.setIdHoaDon(rs.getLong("ID"));
                tt.setIdBn(rs.getLong("BenhNhanID"));
                tt.setTenKhachHang(rs.getString("TenKhachHang"));
                tt.setDiaChi(rs.getString("DiaChi"));
                tt.setSoDienThoai(rs.getString("SoDienThoai"));
                tt.setIdBS(rs.getLong("BacSiID"));
                tt.setTrangthaiHd(rs.getString("TrangThai"));

                list.add(tt);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();  
    } 

    return list;
}


public List<ThanhToan> getDichVuByBenhNhanId(long benhNhanId) {
    List<ThanhToan> list = new ArrayList<>();
    String sql = """
        SELECT
            dv.ID AS ID,
            dv.Ten AS TenDichVu,
            dv.MoTa AS MoTaDichVu,
            dv.SoLuong AS SoLuong,
            dv.DonViTinh AS DonViTinh,
            dv.ChiPhi AS ChiPhiDichVu
        FROM LichHen
        INNER JOIN BenhNhan ON LichHen.BenhNhanID = BenhNhan.ID
        INNER JOIN BacSi ON LichHen.BacSiID = BacSi.ID
        INNER JOIN DichVu dv ON LichHen.DichVuID = dv.ID
        WHERE BenhNhan.ID = ?
        ORDER BY LichHen.ID DESC;
    """;

    try (Connection con = DBConnect.getConnect();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setLong(1, benhNhanId);

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ThanhToan dichVu = new ThanhToan();
                dichVu.setIdDv(rs.getLong("ID"));
                dichVu.setTen(rs.getString("TenDichVu"));
                dichVu.setMotaDv(rs.getString("MoTaDichVu"));
                dichVu.setChiPhiDv(rs.getBigDecimal("ChiPhiDichVu"));
                dichVu.setSoLuong(rs.getInt("SoLuong"));
                dichVu.setDonVitinhDv(rs.getString("DonViTinh"));

                list.add(dichVu);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}
public long saveHoaDon(ThanhToan hoaDon) {
    long generatedId = -1;
    String sql = """
        INSERT INTO HoaDon (
            BenhNhanID, BacSiID, LetanID, TenKhachHang, DiaChi,
            SoDienThoai, PhuongThucTT, TienKhDua, TienThua,
            ThanhTien, NgayTao, TrangThai
        ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?);
    """;

    try (Connection con = DBConnect.getConnect();
         PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        
        ps.setLong(1, hoaDon.getBenhnhanid());
        ps.setLong(2, hoaDon.getBacSiId());
        ps.setLong(3, hoaDon.getLeTanID());
        ps.setString(4, hoaDon.getTenKhachHang());
        ps.setString(5, hoaDon.getDiaChi());
        ps.setString(6, hoaDon.getSoDienThoai());
        ps.setString(7, hoaDon.getPhuongThucTT());
        ps.setBigDecimal(8, hoaDon.getTienKhDua());
        ps.setBigDecimal(9, hoaDon.getTienThua());
        ps.setBigDecimal(10, hoaDon.getThanhtien());
        ps.setString(11, hoaDon.getTrangThai());

        int affectedRows = ps.executeUpdate();
        
        if (affectedRows > 0) {
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getLong(1);
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return generatedId;
}


public void saveChiTietHoaDon(long hoaDonId, ThanhToan chiTiet) {
    String sql = """
        INSERT INTO ChiTietHoaDon (
            HoaDonID, DichVuID, TenDichVu, MoTa, DonViTinh,
            SoLuong, DonGia, ThanhTien, TrangThai
        ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);
    """;

    try (Connection con = DBConnect.getConnect();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setLong(1, hoaDonId);
        ps.setLong(2, chiTiet.getIdDv());
        ps.setString(3, chiTiet.getTendichvu());
        ps.setString(4, chiTiet.getMotaDv());
        ps.setString(5, chiTiet.getDonvitinh());
        ps.setInt(6, chiTiet.getSoLuong());
        ps.setBigDecimal(7, chiTiet.getDongia());
        ps.setBigDecimal(8, chiTiet.getThanhtien());
        ps.setString(9, chiTiet.getTrangThai());

        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public boolean them(ThanhToan m2) {
    Connection con = null;
    PreparedStatement psHoaDon = null;
    PreparedStatement psHoaDonChiTiet = null;
    int rowsHoaDon = 0;
    int rowsHoaDonChiTiet = 0;

    String sqlHoaDon = """
                        UPDATE [dbo].[HoaDon]
                           SET [BenhNhanID] = ?,
                               [BacSiID] = ?,
                               [LetanID] = ?,
                               [TenKhachHang] = ?,
                               [DiaChi] = ?,
                               [SoDienThoai] = ?,
                               [PhuongThucTT] = ?,
                               [TienKhDua] = ?,
                               [TienThua] = ?,
                               [ThanhTien] = ?,
                               [NgayTao] = ?,
                               [NgayThanhToan] = ?,
                               [TrangThai] = ?
                         WHERE [ID] = ?;
                        """;

    String sqlHoaDonChiTiet = """
        INSERT INTO ChiTietHoaDon (HoaDonID, DichVuID, TenDichVu, MoTa, DonViTinh, SoLuong, DonGia, ThanhTien, TrangThai)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
    """;

    try {
        con = DBConnect.getConnect();
        con.setAutoCommit(false);

        // Prepare statement for updating HoaDon
        psHoaDon = con.prepareStatement(sqlHoaDon);
        psHoaDon.setLong(1, m2.getBenhnhanid());
        psHoaDon.setLong(2, m2.getBacSiId());
        psHoaDon.setLong(3, m2.getLeTanID());
        psHoaDon.setString(4, m2.getTenKhachHang());
        psHoaDon.setString(5, m2.getDiaChi());
        psHoaDon.setString(6, m2.getSoDienThoai());
        psHoaDon.setString(7, m2.getPhuongThucTT());
        psHoaDon.setBigDecimal(8, m2.getTienKhDua());
        psHoaDon.setBigDecimal(9, m2.getTienThua());
        psHoaDon.setBigDecimal(10, m2.getThanhtien());
        psHoaDon.setDate(11, new java.sql.Date(m2.getNgayTaoHd().getTime()));  // Ensure the conversion is correct
        psHoaDon.setDate(12, new java.sql.Date(m2.getNgaythanhtoan().getTime()));  // Ensure the conversion is correct
        psHoaDon.setString(13, m2.getTrangthaiHd());
        psHoaDon.setLong(14, m2.getIdHoaDon());

        rowsHoaDon = psHoaDon.executeUpdate();

        if (rowsHoaDon > 0) {
            // Prepare statement for inserting into ChiTietHoaDon
            psHoaDonChiTiet = con.prepareStatement(sqlHoaDonChiTiet);
            psHoaDonChiTiet.setLong(1, m2.getIdHoaDon());
            psHoaDonChiTiet.setLong(2, m2.getIdDv());
            psHoaDonChiTiet.setString(3, m2.getTenDv());
            psHoaDonChiTiet.setString(4, m2.getMotaDv());
            psHoaDonChiTiet.setString(5, m2.getDonvitinh());
            psHoaDonChiTiet.setInt(6, m2.getSoLuong());
            psHoaDonChiTiet.setBigDecimal(7, m2.getDongia());
            psHoaDonChiTiet.setBigDecimal(8, m2.getThanhtien());
            psHoaDonChiTiet.setString(9, m2.getTrangthaiHd());  // Ensure all parameters are set

            rowsHoaDonChiTiet = psHoaDonChiTiet.executeUpdate();

            if (rowsHoaDonChiTiet > 0) {
                con.commit();
                return true;
            }
        }

        con.rollback();
        return false;

    } catch (SQLException e) {
        e.printStackTrace();
        if (con != null) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    } finally {
        try {
            if (psHoaDon != null) {
                psHoaDon.close();
            }
            if (psHoaDonChiTiet != null) {
                psHoaDonChiTiet.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}






public boolean updateLichHenStatus(long id, String trangThaiMoi) {
    String sql = "UPDATE LichHen SET TrangThai = ? WHERE ID = ?";
    boolean isUpdated = false;

    try (Connection conn = DBConnect.getConnect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, trangThaiMoi);
        pstmt.setLong(2, id);

        int affectedRows = pstmt.executeUpdate();
        isUpdated = (affectedRows > 0);
    } catch (SQLException e) {
        e.printStackTrace(); // Xử lý lỗi
    }

    return isUpdated;
}


  public boolean huyThanhToan(ThanhToan m2) {
    Connection con = null;
    PreparedStatement psHoaDon = null;
    int rowsHoaDon = 0;

    String sqlHoaDon = """
                        UPDATE [dbo].[HoaDon]
                           SET  
                               [TrangThai] = N'Hủy Thanh Toán'
                         WHERE [ID] = ?;
                        """;  

    try {
        con = DBConnect.getConnect();
        con.setAutoCommit(false);

        // Prepare statement for updating HoaDon
        psHoaDon = con.prepareStatement(sqlHoaDon);
        psHoaDon.setLong(1, m2.getIdHoaDon()); // ID of the invoice to update

        rowsHoaDon = psHoaDon.executeUpdate();

        // Commit the transaction if the update is successful
        if (rowsHoaDon > 0) {
            con.commit();
            return true; // Successfully updated
        } else {
            con.rollback(); // Rollback if no rows were affected
            return false;
        }

    } catch (SQLException e) {
        e.printStackTrace();
        if (con != null) {
            try {
                con.rollback(); // Rollback on error
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    } finally {
        try {
            if (psHoaDon != null) {
                psHoaDon.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

}

 
