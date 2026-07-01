package com.springboot.restaurant.services;

import java.sql.Connection;

import java.sql.DriverManager;

public class DBContext {
    public Connection getConnection() throws Exception {

        // 1. Địa chỉ máy chủ (localhost hoặc IP hoặc gõ tên server máy cá nhân) và Port
        String serverName = "localhost";
        // 2. tên cơ sở dữ liệu
        String databaseName = "QL_NHAHANG_CNJAVA";
        // 3. cổng kết nối
        String portNumber = "1433";
        // 4. tài khoản kết nối
        String user = "sa";
        String password = "1234ngay";
        // chuỗi kết nối đầy đủ

        String stringUrl = "jdbc:sqlserver://" + serverName + ":" + portNumber
                + ";databaseName=" + databaseName
                + ";user=" + user
                + ";password=" + password
                + ";encrypt=true;trustServerCertificate=true;";
        // đăng ký driver (không cần bắt buộc với java mới nhưng nên làm)
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        System.out.println("Fully Connection for copy:" + stringUrl);
        return DriverManager.getConnection(stringUrl);
    }

    public static void main(String[] args) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_GREEN = "\u001B[32m"; // Màu xanh lá cây
        String ANSI_RED = "\u001B[31m";
        try {
            DBContext db = new DBContext();
            if (db.getConnection() != null) {
                System.out.println(ANSI_GREEN + "Connecting Successfully" + ANSI_RESET);

            }

        } catch (Exception e) {
            System.err.println(ANSI_RED + "Error Connecting: " + e + ANSI_RESET);
        }

    }

}
