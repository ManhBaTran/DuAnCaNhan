/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoadon;

import com.poly.database.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HangNT169
 */
public class DBConnect {
//
//    public static final String HOSTNAME = "localhost";
//    public static final String PORT = "1433";
//    public static final String DBNAME = "LONG_HUNG_NGHIA3_Yen_Luat4";
//    public static final String USERNAME = "sa";
//    public static final String PASSWORD = "123456";
//
//    /**
//     * Get connection to MSSQL Server
//     *
//     * @return Connection
//     */
//    public static Connection getConnection() {
//
//        // Create a variable for the connection string.
//        String connectionUrl = "jdbc:sqlserver://" + HOSTNAME + ":" + PORT + ";"
//                + "databaseName=" + DBNAME + ";encrypt=true;trustservercertificate=true";
//
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            return DriverManager.getConnection(connectionUrl, USERNAME, PASSWORD);
//        } // Handle any errors that may have occurred.
//        catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace(System.out);
//        }
//        return null;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(getConnection());
//    }
    
    public static String USER = "sa";
    public static String PASS = "123456";
    public static String URL = "jdbc:sqlserver://localhost;databaseName=Nhom4_DuAn1__11;user=sa ;password=123456; encrypt=true;trustServerCertificate=true;";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Connection getConnect() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static void main(String[] args) {
        Connection con1 = getConnect();
        if (con1 != null) {
            System.out.println("DONE");
        } else {
            System.out.println("FAIL");
        }
    }
}
