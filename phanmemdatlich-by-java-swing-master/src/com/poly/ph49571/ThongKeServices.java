/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.ph49571;

import com.poly.database.DBConnect;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class ThongKeServices {
    private Connection conn;
    
    public ThongKeServices(){
        conn = DBConnect.getConnect();
    }
    
    public ArrayList<ModeThongKe> getdata() throws SQLException {
        ArrayList<ModeThongKe> list = new ArrayList<>();
        String query =  "SELECT dv.ID, dv.Ten AS TenDichVu, dv.MoTa, dv.ChiPhi , COALESCE(SUM(cthd.ThanhTien), 0) AS DoanhThu, dv.TrangThai\n" +
                        "FROM DichVu dv\n" +
                        "LEFT JOIN \n" +
                        "    ChiTietHoaDon cthd ON dv.ID = cthd.DichVuID\n" +
                        "GROUP BY \n" +
                        "    dv.ID, dv.Ten, dv.MoTa, dv.ChiPhi ,  dv.TrangThai";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                ModeThongKe tk = new ModeThongKe();
                tk.setIddichvu(rs.getInt(1));
                tk.setTendichvu(rs.getString(2));
                tk.setMota(rs.getString(3));
                tk.setChiphi(rs.getInt(4));
                tk.setDoanhthu(rs.getInt(5));
                tk.setTrangthai(rs.getString(6));
                list.add(tk);
            }
        
       return list;
    }
    public ArrayList<ModeThongKe> getsoluongtrangthai() throws SQLException {
        ArrayList<ModeThongKe> list = new ArrayList<>();
        String query = "SELECT TrangThai, COUNT(*) AS SoLuong FROM DichVu GROUP BY TrangThai";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        while (rs.next()) {
            ModeThongKe tk = new ModeThongKe();
            String trangThai = rs.getString("TrangThai");
            int soLuong = rs.getInt("SoLuong");

            if (trangThai.equalsIgnoreCase("Hoạt động")) {
                tk.setSoluonght(soLuong);
            } else if (trangThai.equalsIgnoreCase("Không hoạt động")) {
                tk.setSoluongkht(soLuong);
            }
            list.add(tk);
        }
        return list;
    }
//        public int getTongSoDichVu() throws SQLException {
//            String query = "SELECT COUNT(*) AS TongSo FROM DichVu";
//            Statement stm = conn.createStatement();
//            ResultSet rs = stm.executeQuery(query);
//            if (rs.next()) {
//                return rs.getInt(1);
//            }
//            return 0;
//        }
        
    public int getTongSoDichVu() throws SQLException {
        String query = "SELECT COUNT(*) AS TongSo FROM DichVu";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        if (rs.next()) {
            return rs.getInt("TongSo");
        }
        return 0;
    }
        public ModeThongKe getDoanhThu() throws SQLException {
    ModeThongKe thongKe = new ModeThongKe();
    String query = "SELECT \n" +
                   "    SUM(CASE WHEN YEAR(hd.NgayThanhToan) = YEAR(GETDATE()) THEN ct.ThanhTien ELSE 0 END) AS DoanhThuNam,\n" +
                   "    SUM(CASE WHEN YEAR(hd.NgayThanhToan) = YEAR(GETDATE()) AND MONTH(hd.NgayThanhToan) = MONTH(GETDATE()) THEN ct.ThanhTien ELSE 0 END) AS DoanhThuThang,\n" +
                   "    SUM(CASE WHEN CAST(hd.NgayThanhToan AS DATE) = CAST(GETDATE() AS DATE) THEN ct.ThanhTien ELSE 0 END) AS DoanhThuHomNay,\n" +
                   "    SUM(CASE WHEN hd.NgayThanhToan >= DATEADD(DAY, -7, GETDATE()) THEN ct.ThanhTien ELSE 0 END) AS DoanhThu7Ngay\n" +
                   "FROM ChiTietHoaDon ct\n" +
                   "JOIN HoaDon hd ON ct.HoaDonID = hd.ID;";

    DecimalFormat df = new DecimalFormat("0.##");

    try (Statement stm = conn.createStatement();
         ResultSet rs = stm.executeQuery(query)) {

        if (rs.next()) {
            // Đọc số từ ResultSet
            double doanhThuNam = rs.getDouble("DoanhThuNam");
            double doanhThuThang = rs.getDouble("DoanhThuThang");
            double doanhThuHomNay = rs.getDouble("DoanhThuHomNay");
            double doanhThu7Ngay = rs.getDouble("DoanhThu7Ngay");

            // Định dạng số để không có phần thập phân không cần thiết
            thongKe.setDoanhThuNam(Double.parseDouble(df.format(doanhThuNam)));
            thongKe.setDoanhThuThang(Double.parseDouble(df.format(doanhThuThang)));
            thongKe.setDoanhThuHomNay(Double.parseDouble(df.format(doanhThuHomNay)));
            thongKe.setDoanhThu7Ngay(Double.parseDouble(df.format(doanhThu7Ngay)));
        }
    }
    return thongKe;
    }
    public ArrayList<ModeThongKe> loadthongketheonam() throws SQLException{
        ArrayList<ModeThongKe> list = new ArrayList<>();
        String query =  "WITH ThongKeThang AS (\n" +
                        "    SELECT \n" +
                        "        YEAR(hd.NgayThanhToan) AS Nam,\n" +
                        "        MONTH(hd.NgayThanhToan) AS Thang,\n" +
                        "        SUM(ct.ThanhTien) AS DoanhThuThang\n" +
                        "    FROM ChiTietHoaDon ct\n" +
                        "    JOIN HoaDon hd ON ct.HoaDonID = hd.ID\n" +
                        "    WHERE YEAR(hd.NgayThanhToan) = 2024 -- Chọn năm cụ thể\n" +
                        "    GROUP BY YEAR(hd.NgayThanhToan), MONTH(hd.NgayThanhToan)\n" +
                        "),\n" +
                        "DoanhThuThang AS (\n" +
                        "    SELECT \n" +
                        "        Nam,\n" +
                        "        Thang,\n" +
                        "        DoanhThuThang,\n" +
                        "        CASE Thang\n" +
                        "            WHEN 1 THEN 'Tháng 1'\n" +
                        "            WHEN 2 THEN 'Tháng 2'\n" +
                        "            WHEN 3 THEN 'Tháng 3'\n" +
                        "            WHEN 4 THEN 'Tháng 4'\n" +
                        "            WHEN 5 THEN 'Tháng 5'\n" +
                        "            WHEN 6 THEN 'Tháng 6'\n" +
                        "            WHEN 7 THEN 'Tháng 7'\n" +
                        "            WHEN 8 THEN 'Tháng 8'\n" +
                        "            WHEN 9 THEN 'Tháng 9'\n" +
                        "            WHEN 10 THEN 'Tháng 10'\n" +
                        "            WHEN 11 THEN 'Tháng 11'\n" +
                        "            WHEN 12 THEN 'Tháng 12'\n" +
                        "        END AS TenThang\n" +
                        "    FROM ThongKeThang\n" +
                        "),\n" +
                        "ThongKeNam AS (\n" +
                        "    SELECT \n" +
                        "        Nam,\n" +
                        "        SUM(DoanhThuThang) AS TongDoanhThuNam,\n" +
                        "        MAX(DoanhThuThang) AS ThangDoanhThuCaoNhat,\n" +
                        "        MIN(DoanhThuThang) AS ThangDoanhThuThapNhat,\n" +
                        "        AVG(DoanhThuThang) AS TrungBinhDoanhThuThang\n" +
                        "    FROM DoanhThuThang\n" +
                        "    GROUP BY Nam\n" +
                        ")\n" +
                        "SELECT \n" +
                        "    tk.Nam,\n" +
                        "    FORMAT(tk.TongDoanhThuNam, '0.##') AS TongDoanhThuNam,\n" +
                        "    tk.ThangDoanhThuCaoNhat,\n" +
                        "    tk.ThangDoanhThuThapNhat,\n" +
                        "    FORMAT(tk.TrungBinhDoanhThuThang, '0.##') AS TrungBinhDoanhThuThang,\n" +
                        "    d1.TenThang AS ThangDoanhThuCaoNhat_TenThang,\n" +
                        "    d2.TenThang AS ThangDoanhThuThapNhat_TenThang\n" +
                        "FROM ThongKeNam tk\n" +
                        "LEFT JOIN DoanhThuThang d1 ON d1.DoanhThuThang = tk.ThangDoanhThuCaoNhat AND d1.Nam = tk.Nam\n" +
                        "LEFT JOIN DoanhThuThang d2 ON d2.DoanhThuThang = tk.ThangDoanhThuThapNhat AND d2.Nam = tk.Nam;";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        while (rs.next()) {
            ModeThongKe tk = new ModeThongKe();
            tk.setNam(rs.getInt(1));
            tk.setDoanhthu(rs.getInt(2));
            tk.setDoanhthuthangcaonhat(rs.getDouble(3));
            tk.setDoanhthuthangthapnhat(rs.getDouble(4));
            tk.setTrungbinhdoanhthu(rs.getDouble(5));
            tk.setThangcodoanhthucaonhat(rs.getString(6));
            tk.setThangcodoanhthuthapnhat(rs.getString(7));
            
            list.add(tk);
            
        }
        
        return list;
    }

    public ArrayList<ModeThongKe> doanhthungay() throws SQLException{
        ArrayList<ModeThongKe> list = new ArrayList<>();
        String query=   "SELECT \n" +
                        "    hd.NgayThanhToan AS Ngay,\n" +
                        "    COUNT(hd.ID) AS SoLuongHoaDon,\n" +
                        "    SUM(ct.ThanhTien) AS DoanhThuNgay\n" +
                        "FROM ChiTietHoaDon ct\n" +
                        "JOIN HoaDon hd ON ct.HoaDonID = hd.ID\n" +
                        "GROUP BY hd.NgayThanhToan\n" +
                        "ORDER BY hd.NgayThanhToan;";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        while (rs.next()) {
            ModeThongKe tk = new ModeThongKe();
            tk.setNgay(rs.getString(1));
            tk.setSohoadon(rs.getInt(2));
            tk.setThunhapngay(rs.getDouble(3));
            
            list.add(tk);
            
        }
        
        return list;
    }
    public ArrayList<ModeThongKe> doanhthuthang() throws SQLException{
        ArrayList<ModeThongKe> list = new ArrayList<>();
        String query=   "SELECT \n" +
                        "    YEAR(hd.NgayThanhToan) AS Nam,\n" +
                        "    MONTH(hd.NgayThanhToan) AS Thang,\n" +
                        "    COUNT(DISTINCT hd.ID) AS SoLuongHoaDon,\n" +
                        "    SUM(ct.ThanhTien) AS DoanhThuThang\n" +
                        "FROM ChiTietHoaDon ct\n" +
                        "JOIN HoaDon hd ON ct.HoaDonID = hd.ID\n" +
                        "GROUP BY YEAR(hd.NgayThanhToan), MONTH(hd.NgayThanhToan)\n" +
                        "ORDER BY Nam, Thang;";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        while (rs.next()) {
            ModeThongKe tk = new ModeThongKe();
            tk.setNam(rs.getInt(1));
            tk.setThang(rs.getInt(2));
            tk.setSohoadon(rs.getInt(3));
            tk.setThunhapngay(rs.getDouble(3));
            tk.setDoanhThuThang(rs.getDouble(4));
            
            list.add(tk);
            
        }
        
        return list;
    }
    public ArrayList<ModeThongKe> timtrangthai(String trangthaicantim) throws SQLException{
        ArrayList<ModeThongKe> list = new ArrayList<>();
        String query =  "SELECT dv.ID, dv.Ten AS TenDichVu, dv.MoTa, dv.ChiPhi, COALESCE(SUM(cthd.ThanhTien), 0) AS DoanhThu, dv.TrangThai\n" +
                        "FROM DichVu dv\n" +
                        "LEFT JOIN ChiTietHoaDon cthd ON dv.ID = cthd.DichVuID\n" +
                        "WHERE dv.TrangThai LIKE ?\n" +
                        "GROUP BY dv.ID, dv.Ten, dv.MoTa, dv.ChiPhi, dv.TrangThai;";
        try {
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, trangthaicantim);
        ResultSet rs  = ps.executeQuery();
        while (rs.next()) {
            ModeThongKe tk = new ModeThongKe();
            tk.setIddichvu(rs.getInt(1));
            tk.setTendichvu(rs.getString(2));
            tk.setMota(rs.getString(3));
            tk.setChiphi(rs.getInt(4));
            tk.setDoanhthu(rs.getInt(5));
            tk.setTrangthai(rs.getString(6));
            list.add(tk);
            
        }
        } catch (Exception e) {
            System.out.println("loi: "+e);
        }
        return list;
    }
    public ArrayList<ModeThongKe> tim(int idcantim , String tenKhachHang) throws SQLException{
        ArrayList<ModeThongKe> list = new ArrayList<>();
        String query = "SELECT dv.ID, dv.Ten AS TenDichVu, dv.MoTa, dv.ChiPhi, COALESCE(SUM(cthd.ThanhTien), 0) AS DoanhThu, dv.TrangThai "
             + "FROM DichVu dv "
             + "LEFT JOIN ChiTietHoaDon cthd ON dv.ID = cthd.DichVuID "
             + "WHERE dv.ID = ? OR dv.Ten LIKE ? "
             + "GROUP BY dv.ID, dv.Ten, dv.MoTa, dv.ChiPhi, dv.TrangThai";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idcantim); // Set the ID parameter
            ps.setString(2, "%" + tenKhachHang + "%"); // Set the name parameter
            ResultSet rs = ps.executeQuery();


        while (rs.next()) {
            ModeThongKe tk = new ModeThongKe();
            tk.setIddichvu(rs.getInt(1));
            tk.setTendichvu(rs.getString(2));
            tk.setMota(rs.getString(3));
            tk.setChiphi(rs.getInt(4));
            tk.setDoanhthu(rs.getInt(5));
            tk.setTrangthai(rs.getString(6));
            
            list.add(tk);
            
        }
        return list;
    }
//    public ArrayList<ModeThongKe> loadthutu(String thutu) throws SQLException {
//        ArrayList<ModeThongKe> list = new ArrayList<>();
//        String query =  "SELECT dv.ID, dv.Ten AS TenDichVu, dv.MoTa, dv.ChiPhi, COALESCE(SUM(cthd.ThanhTien), 0) AS DoanhThu, dv.TrangThai\n" +
//                        "FROM DichVu dv\n" +
//                        "LEFT JOIN ChiTietHoaDon cthd ON dv.ID = cthd.DichVuID\n" +
//                        "GROUP BY dv.ID, dv.Ten, dv.MoTa, dv.ChiPhi, dv.TrangThai\n" +
//                        "ORDER BY DoanhThu ?;";
//            
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setString(1, thutu); // Set the ID parameter
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                ModeThongKe tk = new ModeThongKe();
//                tk.setIddichvu(rs.getInt(1));
//                tk.setTendichvu(rs.getString(2));
//                tk.setMota(rs.getString(3));
//                tk.setChiphi(rs.getInt(4));
//                tk.setDoanhthu(rs.getInt(5));
//                tk.setTrangthai(rs.getString(6));
//                list.add(tk);
//            }
//        
//       return list;
//    }
        public ArrayList<ModeThongKe> loadthutu(String thutu) throws SQLException {
            ArrayList<ModeThongKe> list = new ArrayList<>();

            // Xây dựng truy vấn SQL với phần ORDER BY
            String query = "SELECT dv.ID, dv.Ten AS TenDichVu, dv.MoTa, dv.ChiPhi, COALESCE(SUM(cthd.ThanhTien), 0) AS DoanhThu, dv.TrangThai\n" +
                           "FROM DichVu dv\n" +
                           "LEFT JOIN ChiTietHoaDon cthd ON dv.ID = cthd.DichVuID\n" +
                           "GROUP BY dv.ID, dv.Ten, dv.MoTa, dv.ChiPhi, dv.TrangThai\n" +
                           "ORDER BY DoanhThu " + thutu;

            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ModeThongKe tk = new ModeThongKe();
                tk.setIddichvu(rs.getInt(1));
                tk.setTendichvu(rs.getString(2));
                tk.setMota(rs.getString(3));
                tk.setChiphi(rs.getInt(4));
                tk.setDoanhthu(rs.getInt(5));
                tk.setTrangthai(rs.getString(6));
                list.add(tk);

            }

            return list;
        }
        public ArrayList<ModeThongKe> tktheonam(int so) throws SQLException{
            ArrayList<ModeThongKe> list = new ArrayList<>();
            String query =  "WITH ThongKeThang AS (\n" +
                            "    SELECT \n" +
                            "        YEAR(hd.NgayThanhToan) AS Nam,\n" +
                            "        MONTH(hd.NgayThanhToan) AS Thang,\n" +
                            "        SUM(ct.ThanhTien) AS DoanhThuThang\n" +
                            "    FROM ChiTietHoaDon ct\n" +
                            "    JOIN HoaDon hd ON ct.HoaDonID = hd.ID\n" +
                            "    WHERE YEAR(hd.NgayThanhToan) = ? -- Chọn năm cụ thể\n" +
                            "    GROUP BY YEAR(hd.NgayThanhToan), MONTH(hd.NgayThanhToan)\n" +
                            "),\n" +
                            "DoanhThuThang AS (\n" +
                            "    SELECT \n" +
                            "        Nam,\n" +
                            "        Thang,\n" +
                            "        DoanhThuThang,\n" +
                            "        CASE Thang\n" +
                            "            WHEN 1 THEN 'Tháng 1'\n" +
                            "            WHEN 2 THEN 'Tháng 2'\n" +
                            "            WHEN 3 THEN 'Tháng 3'\n" +
                            "            WHEN 4 THEN 'Tháng 4'\n" +
                            "            WHEN 5 THEN 'Tháng 5'\n" +
                            "            WHEN 6 THEN 'Tháng 6'\n" +
                            "            WHEN 7 THEN 'Tháng 7'\n" +
                            "            WHEN 8 THEN 'Tháng 8'\n" +
                            "            WHEN 9 THEN 'Tháng 9'\n" +
                            "            WHEN 10 THEN 'Tháng 10'\n" +
                            "            WHEN 11 THEN 'Tháng 11'\n" +
                            "            WHEN 12 THEN 'Tháng 12'\n" +
                            "        END AS TenThang\n" +
                            "    FROM ThongKeThang\n" +
                            "),\n" +
                            "ThongKeNam AS (\n" +
                            "    SELECT \n" +
                            "        Nam,\n" +
                            "        SUM(DoanhThuThang) AS TongDoanhThuNam,\n" +
                            "        MAX(DoanhThuThang) AS ThangDoanhThuCaoNhat,\n" +
                            "        MIN(DoanhThuThang) AS ThangDoanhThuThapNhat,\n" +
                            "        AVG(DoanhThuThang) AS TrungBinhDoanhThuThang\n" +
                            "    FROM DoanhThuThang\n" +
                            "    GROUP BY Nam\n" +
                            ")\n" +
                            "SELECT \n" +
                            "    tk.Nam,\n" +
                            "    FORMAT(tk.TongDoanhThuNam, '0.##') AS TongDoanhThuNam,\n" +
                            "    tk.ThangDoanhThuCaoNhat,\n" +
                            "    tk.ThangDoanhThuThapNhat,\n" +
                            "    FORMAT(tk.TrungBinhDoanhThuThang, '0.##') AS TrungBinhDoanhThuThang,\n" +
                            "    d1.TenThang AS ThangDoanhThuCaoNhat_TenThang,\n" +
                            "    d2.TenThang AS ThangDoanhThuThapNhat_TenThang\n" +
                            "FROM ThongKeNam tk\n" +
                            "LEFT JOIN DoanhThuThang d1 ON d1.DoanhThuThang = tk.ThangDoanhThuCaoNhat AND d1.Nam = tk.Nam\n" +
                            "LEFT JOIN DoanhThuThang d2 ON d2.DoanhThuThang = tk.ThangDoanhThuThapNhat AND d2.Nam = tk.Nam;";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, so);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ModeThongKe tk = new ModeThongKe();
                tk.setNam(rs.getInt(1));
                tk.setDoanhthu(rs.getInt(2));
                tk.setDoanhthuthangcaonhat(rs.getDouble(3));
                tk.setDoanhthuthangthapnhat(rs.getDouble(4));
                tk.setTrungbinhdoanhthu(rs.getDouble(5));
                tk.setThangcodoanhthucaonhat(rs.getString(6));
                tk.setThangcodoanhthuthapnhat(rs.getString(7));

                list.add(tk);

            }

            return list;
        }
//        public List<ModeThongKe> loadcbb() throws SQLException {
//            List<ModeThongKe> years = new ArrayList<>();
//            String query = "SELECT DISTINCT YEAR(NgayThanhToan) AS Nam FROM HoaDon ORDER BY Nam ASC;";
//            Statement stm = conn.createStatement();
//            ResultSet rs = stm.executeQuery(query);
//            while (rs.next()) {
//                int nam = rs.getInt("Nam");
//                years.add(new ModeThongKe(nam)); // Tạo đối tượng ModeThongKe và thêm vào danh sách
//            }
//            return years;
//        }
        public ArrayList<ModeThongKe> timtheongay(Date startDate, Date endDate) throws SQLException {
            ArrayList<ModeThongKe> list = new ArrayList<>();
            String query = "SELECT " +
                           "    CAST(hd.NgayThanhToan AS DATE) AS Ngay, " +
                           "    COUNT(hd.ID) AS SoLuongHoaDon, " +
                           "    SUM(ct.ThanhTien) AS DoanhThuNgay " +
                           "FROM ChiTietHoaDon ct " +
                           "JOIN HoaDon hd ON ct.HoaDonID = hd.ID " +
                           "WHERE CAST(hd.NgayThanhToan AS DATE) BETWEEN ? AND ? " +
                           "GROUP BY CAST(hd.NgayThanhToan AS DATE) " +
                           "ORDER BY CAST(hd.NgayThanhToan AS DATE);";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setDate(1, startDate);
            pst.setDate(2, endDate);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ModeThongKe tk = new ModeThongKe();
                tk.setNgay(rs.getString(1));
            tk.setSohoadon(rs.getInt(2));
            tk.setThunhapngay(rs.getDouble(3));

                list.add(tk);
            }
            return list;
        }
        public ArrayList<ModeThongKe> tktheothang(int thang) throws SQLException {
            ArrayList<ModeThongKe> list = new ArrayList<>();
            String query =  "SELECT " +
                            "    YEAR(hd.NgayThanhToan) AS Nam,\n" +
                            "    MONTH(hd.NgayThanhToan) AS Thang, " +
                            "    COUNT(DISTINCT hd.ID) AS SoLuongHoaDon, " +
                            "    SUM(ct.ThanhTien) AS DoanhThuThang " +
                            "FROM ChiTietHoaDon ct " +
                            "JOIN HoaDon hd ON ct.HoaDonID = hd.ID " +
                            "WHERE MONTH(hd.NgayThanhToan) = ? " +  // Tham số cho tháng
                            "GROUP BY YEAR(hd.NgayThanhToan), MONTH(hd.NgayThanhToan)\n" +
                            "ORDER BY Nam, Thang;";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, thang);  // Đặt tháng

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ModeThongKe tk = new ModeThongKe();
                tk.setNam(rs.getInt(1));
                tk.setThang(rs.getInt(2));
                tk.setSohoadon(rs.getInt(3));
                tk.setThunhapngay(rs.getDouble(3));
                tk.setDoanhThuThang(rs.getDouble(4));

                list.add(tk);
            }

            return list;
        }
        public ArrayList<ModeThongKe> tktheonamthang(int nam) throws SQLException {
            ArrayList<ModeThongKe> list = new ArrayList<>();
            String query =  "SELECT " +
                            "    YEAR(hd.NgayThanhToan) AS Nam,\n" +
                            "    MONTH(hd.NgayThanhToan) AS Thang, " +
                            "    COUNT(DISTINCT hd.ID) AS SoLuongHoaDon, " +
                            "    SUM(ct.ThanhTien) AS DoanhThuThang " +
                            "FROM ChiTietHoaDon ct " +
                            "JOIN HoaDon hd ON ct.HoaDonID = hd.ID " +
                            "WHERE YEAR(hd.NgayThanhToan) = ? " +  // Tham số cho nam
                            "GROUP BY YEAR(hd.NgayThanhToan), MONTH(hd.NgayThanhToan)\n" +
                            "ORDER BY Nam, Thang;";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, nam);  // Đặt nam

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ModeThongKe tk = new ModeThongKe();
                tk.setNam(rs.getInt(1));
                tk.setThang(rs.getInt(2));
                tk.setSohoadon(rs.getInt(3));
                tk.setThunhapngay(rs.getDouble(3));
                tk.setDoanhThuThang(rs.getDouble(4));

                list.add(tk);
            }

            return list;
        }


}
