package com.poly.repository;
import java.sql.Statement; // Đảm bảo rằng bạn đã nhập đúng gói

import com.poly.database.DBConnect;
import static com.poly.database.DBConnect.URL;
import static com.poly.database.DBConnect.USER;
import com.poly.entity.BacSiLichLamViec;
import java.math.BigDecimal;
 import java.time.LocalDate;
import java.sql.Date;
import java.time.ZoneId;
 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import javax.swing.JOptionPane;
public class RepoBsLlv {
     public List<BacSiLichLamViec> getAllBacSiLichLamViec() {
    List<BacSiLichLamViec> list = new ArrayList<>();
    String sql = """
                                    SELECT 
                                          BacSi.ID AS ID,
                                          BacSi.Ten AS TenBacSi,
                                          LichLamViec.Ngay AS NgayLamViec,
                                          LichLamViec.ThoiGianBatDau AS ThoiGianBatDau,
                                          LichLamViec.ThoiGianKetThuc AS ThoiGianKetThuc,
                                          LichLamViec.CaLamViec AS CaLamViec,
                                          LichLamViec.TrangThai AS TrangThai,
                                          COUNT(LichHen.ID) AS SoLuongBenhNhan
                                      FROM 
                                          LichLamViec
                                      INNER JOIN 
                                          BacSi ON LichLamViec.BacSiID = BacSi.ID
                                      LEFT JOIN 
                                          LichHen ON LichLamViec.BacSiID = LichHen.BacSiID
                                          AND LichLamViec.Ngay = LichHen.NgayHen
                                          AND LichHen.GioHen BETWEEN LichLamViec.ThoiGianBatDau AND LichLamViec.ThoiGianKetThuc
                                      GROUP BY 
                                          BacSi.ID, BacSi.Ten, LichLamViec.Ngay, LichLamViec.ThoiGianBatDau, 
                                          LichLamViec.ThoiGianKetThuc, LichLamViec.CaLamViec, LichLamViec.TrangThai
                                      HAVING 
                                          COUNT(LichHen.ID) <=3
                                      ORDER BY 
                                          BacSi.ID, LichLamViec.Ngay, LichLamViec.ThoiGianBatDau;
                  """;

    try (Connection con = DBConnect.getConnect();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            BacSiLichLamViec bsllv = new BacSiLichLamViec();
            bsllv.setIdBS(rs.getLong("ID"));
            bsllv.setTenBacSi(rs.getString("TenBacSi"));
            bsllv.setNgayLamViec(rs.getDate("NgayLamViec").toLocalDate());
            bsllv.setThoiGianBatDau(rs.getTime("ThoiGianBatDau").toLocalTime());
            bsllv.setThoiGianKetThuc(rs.getTime("ThoiGianKetThuc").toLocalTime());
            bsllv.setCaLamViec(rs.getString("CaLamViec"));
            bsllv.setTrangThaiBS(rs.getString("TrangThai"));
            bsllv.setSoLuongbn(rs.getInt("SoLuongBenhNhan")); // thêm số lượng bệnh nhân vào đối tượng
            
            list.add(bsllv);
        }
    } catch (SQLException e) {
        e.printStackTrace();  // Hoặc sử dụng logging framework
    }

    return list;
}

    
 public List<BacSiLichLamViec> getAllLichHen() {
        List<BacSiLichLamViec> lichHenList = new ArrayList<>();
        String sql = """
                             SELECT
                                                            LichHen.ID AS LichHenID,
                                                            BenhNhan.Ten AS TenBenhNhan,
                                                            BenhNhan.SoDienThoai AS SoDienThoai,
                                                            BenhNhan.DiaChi AS DiaChi,
                                                            BenhNhan.NgaySinh AS NgaySinh,
                                                            BenhNhan.GioiTinh AS GioiTinh,
                                                            BacSi.Ten AS TenBacSi,
                                                            LichHen.NgayHen,
                                                            LichHen.GioHen,
                                                            LichHen.NgayDatLich,
                                                            DichVu.Ten AS TenDichVu,
                                                            DichVu.ChiPhi AS ChiPhi,
                                                            LichHen.TrangThai,
                                                        	BenhNhan.ID as IdBenhNhan,
                                                        	DichVu.ID as IDDichVu,
                            								BacSi.ID as IDBacSi
                                                        FROM LichHen
                                                        INNER JOIN BenhNhan ON LichHen.BenhNhanID = BenhNhan.ID
                                                        INNER JOIN BacSi ON LichHen.BacSiID = BacSi.ID
                                                        INNER JOIN DichVu ON LichHen.DichVuID = DichVu.ID
                                                        ORDER BY LichHen.ID DESC;
                      """;

        try (Connection con = DBConnect.getConnect();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                BacSiLichLamViec bsllv = new BacSiLichLamViec();
                bsllv.setIdLH(rs.getLong("LichHenID"));
                bsllv.setTenBacSi(rs.getString("TenBacSi"));
                bsllv.setNgayHen(rs.getDate("NgayHen").toLocalDate());
                Time gioHenSql = rs.getTime("GioHen");
                bsllv.setGioHen(gioHenSql != null ? gioHenSql.toLocalTime() : null);
                bsllv.setNgayDatLich(rs.getDate("NgayDatLich").toLocalDate());
                bsllv.setTenBN(rs.getString("TenBenhNhan"));
                bsllv.setSdtBN(rs.getString("SoDienThoai"));
                bsllv.setDiachi(rs.getString("DiaChi"));
                bsllv.setNgaysinh(rs.getDate("NgaySinh") );
                bsllv.setGioitinh(rs.getString("GioiTinh"));
                bsllv.setCaLamViec("N/A"); // Hoặc từ nguồn khác
                bsllv.setTenDV(rs.getString("TenDichVu"));

                // Đọc giá trị gốc từ SQL và chuyển đổi thành BigDecimal
                BigDecimal chiPhi = rs.getBigDecimal("ChiPhi");
                bsllv.setChiPhi(chiPhi);

                bsllv.setTrangThaiLH(rs.getString("TrangThai"));
                bsllv.setIdBenhNhan(rs.getLong("IdBenhNhan"));
                bsllv.setIdDV(rs.getLong("IDDichVu"));
                bsllv.setIdBS(rs.getLong("IDBacSi"));

                lichHenList.add(bsllv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lichHenList;
    }

 
       public List<BacSiLichLamViec> getBacSiByNgayGio(String ngayLamViec, String thoiGianBatDau) {
    List<BacSiLichLamViec> bacSiList = new ArrayList<>();
    String query = """
            SELECT BacSi.ID AS ID, BacSi.Ten AS TenBacSi, 
                   LichLamViec.Ngay AS NgayLamViec, 
                   LichLamViec.ThoiGianBatDau AS ThoiGianBatDau, 
                   LichLamViec.ThoiGianKetThuc AS ThoiGianKetThuc, 
                   LichLamViec.CaLamViec AS CaLamViec, 
                   LichLamViec.TrangThai AS TrangThai,
                   COUNT(LichHen.ID) AS SoLuongBenhNhan
            FROM BacSi
            INNER JOIN LichLamViec ON BacSi.ID = LichLamViec.BacSiID
            LEFT JOIN LichHen ON LichLamViec.BacSiID = LichHen.BacSiID
                                AND LichLamViec.Ngay = LichHen.NgayHen
                                AND LichHen.GioHen BETWEEN LichLamViec.ThoiGianBatDau AND LichLamViec.ThoiGianKetThuc
            WHERE LichLamViec.Ngay = ? 
              AND LichLamViec.ThoiGianBatDau = CAST(? AS time)
            GROUP BY BacSi.ID, BacSi.Ten, LichLamViec.Ngay, 
                     LichLamViec.ThoiGianBatDau, LichLamViec.ThoiGianKetThuc, 
                     LichLamViec.CaLamViec, LichLamViec.TrangThai
            """;

    try (Connection con = DBConnect.getConnect();
         PreparedStatement statement = con.prepareStatement(query)) {

        java.sql.Date sqlNgayLamViec = java.sql.Date.valueOf(ngayLamViec);
        java.sql.Time sqlThoiGianBatDau = java.sql.Time.valueOf(thoiGianBatDau);

        statement.setDate(1, sqlNgayLamViec);
        statement.setTime(2, sqlThoiGianBatDau);

        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                BacSiLichLamViec bacSiLichLamViec = new BacSiLichLamViec();
                bacSiLichLamViec.setIdBS(resultSet.getLong("ID"));
                bacSiLichLamViec.setTenBacSi(resultSet.getString("TenBacSi"));
                bacSiLichLamViec.setNgayLamViec(resultSet.getDate("NgayLamViec").toLocalDate());
                bacSiLichLamViec.setThoiGianBatDau(resultSet.getTime("ThoiGianBatDau").toLocalTime());
                bacSiLichLamViec.setThoiGianKetThuc(resultSet.getTime("ThoiGianKetThuc").toLocalTime());
                bacSiLichLamViec.setCaLamViec(resultSet.getString("CaLamViec"));
                bacSiLichLamViec.setTrangThaiBS(resultSet.getString("TrangThai"));
                bacSiLichLamViec.setSoLuongbn(resultSet.getInt("SoLuongBenhNhan")); // Cập nhật số lượng bệnh nhân

                bacSiList.add(bacSiLichLamViec);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Log error or handle it properly
    }

    return bacSiList;
}


public long addBenhNhan(BacSiLichLamViec bn) {
    String sql = """
               INSERT INTO [dbo].[BenhNhan]
              ([Ten]
              ,[SoDienThoai]
              ,[DiaChi]
              ,[NgaySinh]
              ,[GioiTinh])
                      VALUES
              (?,?,?,?,?)
                 """;
    long generatedId = -1; // Biến lưu trữ ID tự động sinh ra
    try (Connection conn = DBConnect.getConnect();
         PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        
        pstmt.setString(1, bn.getTenBN());
        pstmt.setString(2, bn.getSdtBN());
        pstmt.setString(3, bn.getDiachi());
        pstmt.setDate(  4, new Date(bn.getNgaysinh().getTime()));
        pstmt.setString(5, bn.getGioitinh());

        int affectedRows = pstmt.executeUpdate();

        if (affectedRows > 0) {
            // Lấy ID của bản ghi mới được thêm vào
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getLong(1);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return generatedId;
}

public void themBenhNhanVaLichHen(BacSiLichLamViec bacSiLichLamViec) {
    try (Connection con = DBConnect.getConnect()) {
        // Chèn bản ghi mới vào bảng BenhNhan
        String sqlBenhNhan = "INSERT INTO BenhNhan (Ten, SoDienThoai, DiaChi, NgaySinh, GioiTinh) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement psBenhNhan = con.prepareStatement(sqlBenhNhan, Statement.RETURN_GENERATED_KEYS)) {
            psBenhNhan.setString(1, bacSiLichLamViec.getTenBN());
            psBenhNhan.setString(2, bacSiLichLamViec.getSdtBN());
            psBenhNhan.setString(3, bacSiLichLamViec.getDiachi());
            psBenhNhan.setDate(4, new Date(bacSiLichLamViec.getNgaysinh().getTime()));
            psBenhNhan.setString(5, bacSiLichLamViec.getGioitinh());
            psBenhNhan.executeUpdate();
            
            // Lấy ID của BenhNhan vừa được thêm
            try (ResultSet generatedKeys = psBenhNhan.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long benhNhanId = generatedKeys.getLong(1);
                    
                    // Chèn bản ghi mới vào bảng LichHen
                    String sqlLichHen = "INSERT INTO LichHen (BenhNhanID, BacSiID, NgayHen, GioHen, NgayDatLich, TrangThai) VALUES (?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement psLichHen = con.prepareStatement(sqlLichHen)) {
                        psLichHen.setLong(1, benhNhanId);
                        psLichHen.setLong(2, bacSiLichLamViec.getIdBS()); // Giả sử bạn có phương thức getIdBacSi()
                        psLichHen.setDate(3, java.sql.Date.valueOf(bacSiLichLamViec.getNgayHen()));
                        psLichHen.setTime(4, java.sql.Time.valueOf(bacSiLichLamViec.getGioHen()));
                        psLichHen.setDate(5, java.sql.Date.valueOf(bacSiLichLamViec.getNgayDatLich()));
                        psLichHen.setString(6, bacSiLichLamViec.getTrangThaiLH());
                        psLichHen.executeUpdate();
                    }
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    

// Phương thức xóa bệnh nhân
    public boolean deleteLichHen(long id) {
    String deleteLichHenSql = "DELETE FROM [dbo].[LichHen] WHERE ID = ?";
    boolean isDeleted = false;
    Connection conn = null;

    try {
        conn = DBConnect.getConnect();
        PreparedStatement deleteLichHenPstmt = conn.prepareStatement(deleteLichHenSql);

        // Bắt đầu giao dịch
        conn.setAutoCommit(false);

        // Xóa bản ghi lịch hẹn
        deleteLichHenPstmt.setLong(1, id);
        int rowsAffected = deleteLichHenPstmt.executeUpdate();

        if (rowsAffected > 0) {
            isDeleted = true;
        }

        // Commit giao dịch
        conn.commit();
    } catch (SQLException e) {
        e.printStackTrace();
        if (conn != null) {
            try {
                // Hủy giao dịch nếu có lỗi xảy ra
                conn.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        }
    } finally {
        if (conn != null) {
            try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }
    }

    return isDeleted;
}





 public boolean updateBenhNhan(long id, BacSiLichLamViec bn) {
    // Câu lệnh SQL để cập nhật thông tin bệnh nhân
    String sql = """
        UPDATE [dbo].[BenhNhan]
        SET [Ten] = ?,
            [SoDienThoai]  = ?,
            [Diachi] = ?,
            [Ngaysinh] = ?,
            [Gioitinh] = ?
        WHERE [ID] = ?
    """;

    boolean isUpdated = false;

    // Kiểm tra giá trị đầu vào
    if (bn == null || id <= 0) {
        System.err.println("Invalid input data.");
        return false;
    }

    try (Connection conn = DBConnect.getConnect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        // Cài đặt các tham số của PreparedStatement
        pstmt.setString(1, bn.getTenBN());
        pstmt.setString(2, bn.getSdtBN());
        pstmt.setString(3, bn.getDiachi());

        // Chuyển đổi từ java.util.Date sang java.sql.Date nếu cần
        java.sql.Date sqlDate = null;
        if (bn.getNgaysinh() != null) {
            sqlDate = new java.sql.Date(bn.getNgaysinh().getTime());
        }
        pstmt.setDate(4, sqlDate);

        pstmt.setString(5, bn.getGioitinh());
        pstmt.setLong(6, id); // Sử dụng giá trị id từ phương thức

        // Thực thi câu lệnh cập nhật
        int affectedRows = pstmt.executeUpdate();

        // Kiểm tra số lượng hàng bị ảnh hưởng
        isUpdated = affectedRows > 0;
    } catch (SQLException e) {
        e.printStackTrace(); // Xử lý lỗi
        // Ghi log hoặc xử lý lỗi thêm nếu cần
    }

    return isUpdated;
}

 

   
public boolean updateDichVu(long oldDichVuID, long newDichVuID) {
    String updateDichVuSql = """
        UPDATE LichHen
        SET DichVuID = ?
        WHERE DichVuID = ?
    """;
    boolean isUpdated = false;
    Connection conn = null;

    try {
        conn = DBConnect.getConnect();
        PreparedStatement updateDichVuPstmt = conn.prepareStatement(updateDichVuSql);

        // Thiết lập các tham số cho câu lệnh cập nhật
        updateDichVuPstmt.setLong(1, newDichVuID);
        updateDichVuPstmt.setLong(2, oldDichVuID);

        int rowsAffected = updateDichVuPstmt.executeUpdate();
        isUpdated = rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    return isUpdated;
}



  public boolean updateLichHen(long id, BacSiLichLamViec bn) {
    String updateLichHenSql = """
        UPDATE LichHen
        SET NgayHen = ?, GioHen = ?, NgayDatLich = ?
        WHERE ID = ?
    """;
    boolean isUpdated = false;
    Connection conn = null;

    try {
        conn = DBConnect.getConnect();
        PreparedStatement updateLichHenPstmt = conn.prepareStatement(updateLichHenSql);

        // Thiết lập các tham số cho câu lệnh cập nhật
        updateLichHenPstmt.setDate(1, java.sql.Date.valueOf(bn.getNgayHen()));
        updateLichHenPstmt.setTime(2, java.sql.Time.valueOf(bn.getGioHen()));
        updateLichHenPstmt.setDate(3, java.sql.Date.valueOf(bn.getNgayDatLich()));
        updateLichHenPstmt.setLong(4, id); // Chỉ số thứ 4

        int rowsAffected = updateLichHenPstmt.executeUpdate();
        isUpdated = rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    return isUpdated;
}


public boolean updateBacSi(long id, BacSiLichLamViec bn) {
    String updateBacSiSql = """
        UPDATE BacSi
        SET Ten = ?
        WHERE ID = ?
    """;
    boolean isUpdated = false;
    Connection conn = null;

    try {
        conn = DBConnect.getConnect();
        PreparedStatement updateBacSiPstmt = conn.prepareStatement(updateBacSiSql);

        // Thiết lập các tham số cho câu lệnh cập nhật
        updateBacSiPstmt.setString(1, bn.getTenBacSi());
        updateBacSiPstmt.setLong(2, id);

        int rowsAffected = updateBacSiPstmt.executeUpdate();
        isUpdated = rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    return isUpdated;
}

 
public List<BacSiLichLamViec> searchByNameOrPhone(String nameOrPhone) {
    String sql = """
        SELECT lh.ID as idLH, 
               bn.Ten as tenBN, 
               bn.SoDienThoai as sdtBN, 
               bn.DiaChi, 
               bn.NgaySinh, 
               bn.GioiTinh, 
               bs.Ten as tenBacSi, 
               lh.NgayHen, 
               lh.GioHen, 
               lh.NgayDatLich, 
               dv.Ten as tenDichVu, 
               dv.ChiPhi as phiDichVu,
               lh.TrangThai as trangThaiLH
                
        FROM BenhNhan bn
        LEFT JOIN LichHen lh ON bn.ID = lh.BenhNhanID
        LEFT JOIN BacSi bs ON lh.BacSiID = bs.ID
        LEFT JOIN DichVu dv ON lh.DichVuID = dv.ID
        WHERE bn.Ten LIKE ? 
           OR bn.SoDienThoai LIKE ?
    """;

    List<BacSiLichLamViec> results = new ArrayList<>();

    try (Connection conn = DBConnect.getConnect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        // Thay thế ký tự '%' để tìm kiếm tên hoặc số điện thoại
        String searchPattern = "%" + nameOrPhone + "%";
        pstmt.setString(1, searchPattern);
        pstmt.setString(2, searchPattern);

        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                BacSiLichLamViec record = new BacSiLichLamViec();
                record.setIdLH(rs.getLong("idLH"));
                record.setTenBN(rs.getString("tenBN"));
                record.setSdtBN(rs.getString("sdtBN"));
                record.setDiachi(rs.getString("DiaChi"));

                // Chuyển đổi từ java.sql.Date sang java.util.Date nếu cần
                java.sql.Date sqlDate = rs.getDate("NgaySinh");
                if (sqlDate != null) {
                    record.setNgaysinh(new java.util.Date(sqlDate.getTime()));
                }

                record.setGioitinh(rs.getString("GioiTinh"));
                record.setTenBacSi(rs.getString("tenBacSi"));

                // Sử dụng getTimestamp để đảm bảo lấy dữ liệu đúng cách
                java.sql.Date ngayHenSql = rs.getDate("NgayHen");
                if (ngayHenSql != null) {
                    record.setNgayHen(ngayHenSql.toLocalDate());
                }

                Time gioHenSql = rs.getTime("GioHen");
                record.setGioHen(gioHenSql != null ? gioHenSql.toLocalTime() : null);

                java.sql.Date ngayDatLichSql = rs.getDate("NgayDatLich");
                if (ngayDatLichSql != null) {
                    record.setNgayDatLich(ngayDatLichSql.toLocalDate());
                }
                 record.setTenDV(rs.getString("tenDichVu"));
                 BigDecimal phiDichVu = rs.getBigDecimal("phiDichVu");
                record.setChiPhi(phiDichVu);
                record.setTrangThaiLH(rs.getString("trangThaiLH"));
                // Thêm các thuộc tính khác nếu cần

                results.add(record);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Xử lý lỗi
    }

    return results;
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

 public boolean checkSDTExists(String sdt) {
        // Thực hiện truy vấn để kiểm tra số điện thoại
        String query = "SELECT COUNT(*) FROM BenhNhan WHERE SoDienThoai = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, sdt);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Trả về true nếu số điện thoại tồn tại
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Trả về false nếu số điện thoại không tồn tại
    }

  public boolean isSdtDuplicate(String sdt) {
        String sql = "SELECT COUNT(*) FROM BenhNhan WHERE SoDienThoai = ?";
        try (Connection conn = DBConnect.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sdt);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

  
    // Phương thức để thêm hóa đơn vào cơ sở dữ liệu
    public boolean addHoaDon(long benhNhanID, long bacSiID, String tenKhachHang, 
                              String diaChi, String soDienThoai, String trangThai) {
        String query = """
            INSERT INTO [dbo].[HoaDon]
               ([BenhNhanID]
               ,[BacSiID]            
               ,[TenKhachHang]
               ,[DiaChi]
               ,[SoDienThoai]
               ,[TrangThai])
         VALUES
            (?,?,?,?,?,?)
        """;

        try (Connection con = DBConnect.getConnect();  // Thay DBConnect.getConnect() bằng phương thức kết nối của bạn
             PreparedStatement statement = con.prepareStatement(query)) {

            // Thiết lập giá trị cho các tham số trong câu lệnh SQL
            statement.setLong(1, benhNhanID);
            statement.setLong(2, bacSiID);
            statement.setString(3, tenKhachHang);
            statement.setString(4, diaChi);
            statement.setString(5, soDienThoai);
            statement.setString(6, trangThai);

            // Thực thi câu lệnh SQL
            int rowsAffected = statement.executeUpdate();

            // Trả về true nếu có ít nhất 1 hàng bị ảnh hưởng (tức là đã chèn thành công)
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            // Ghi log lỗi hoặc xử lý lỗi theo cách khác nếu cần
            return false;
        }
    }
 
   public List<String> getActiveServices() {
    List<String> activeServices = new ArrayList<>();
    String query = "SELECT Ten FROM DichVu WHERE TrangThai = N'Hoạt động'";

    try (Connection con = DBConnect.getConnect(); // Sử dụng phương thức kết nối của bạn
         PreparedStatement statement = con.prepareStatement(query);
         ResultSet resultSet = statement.executeQuery()) {

        // Duyệt qua kết quả trả về và thêm tên dịch vụ vào danh sách
        while (resultSet.next()) {
            activeServices.add(resultSet.getString("Ten"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Xử lý lỗi nếu cần
    }

    return activeServices;
}

    
// Hàm chuyển đổi định dạng thời gian
private String convertToSQLTimeFormat(String time) {
    // Giả sử định dạng đầu vào là hh:mm và bạn muốn chuyển nó thành hh:mm:ss
    if (time.contains("-")) {
        time = time.replace("-", ":");
    }
    if (time.length() == 5) {
        time += ":00"; // Nếu thời gian chỉ có giờ và phút, thêm giây mặc định là 00
    }
    return time;
}


}


