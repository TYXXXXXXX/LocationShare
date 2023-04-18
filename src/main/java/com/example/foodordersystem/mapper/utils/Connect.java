package com.example.foodordersystem.mapper.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    public static Connection getDriver() throws ClassNotFoundException, SQLException {
        // 1.定义数据库连接的基本四项
        String driverName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://192.168.110.30:3306/gui_db?serverTimezone=UTC";
        String username = "root";
        String password = "root";
        // 2.加载驱动包
        Class.forName(driverName);
        // 3.获取数据库连接
        return DriverManager.getConnection(url, username, password);
    }
}
