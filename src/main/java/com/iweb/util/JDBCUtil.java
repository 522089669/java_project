package com.iweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author Cjl
 * @Description:
 * @Date 2023/7/17 16:24
 */
public class JDBCUtil {
    private static final String USER_NAME="long";
    private static final String PASSWORD ="a12345";
    private static final String URL = "jdbc:mysql://47.113.196.69:3306/shop?characterEncoding=utf8";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER_NAME,PASSWORD);
    }
}
