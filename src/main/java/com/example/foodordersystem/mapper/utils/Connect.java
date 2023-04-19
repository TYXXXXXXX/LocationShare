package com.example.foodordersystem.mapper.utils;

import org.apache.ibatis.annotations.Param;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    public static Connection getDriver() throws ClassNotFoundException, SQLException {
        // 1.定义数据库连接的基本四项
        String driverName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://192.168.110.30:3306/food_order_system?serverTimezone=UTC";
        String username = "root";
        String password = "root";
        // 2.加载驱动包
        Class.forName(driverName);
        // 3.获取数据库连接
        return DriverManager.getConnection(url, username, password);
    }

    public static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://192.168.110.30:3306/food_order_system?serverTimezone=UTC";
    public static String USERNAME = "root";
    public static String PASSWORD = "root";
}
