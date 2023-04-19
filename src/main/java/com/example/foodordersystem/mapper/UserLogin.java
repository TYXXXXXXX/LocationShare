package com.example.foodordersystem.mapper;

import com.example.foodordersystem.Service.utils.Md5Util;
import com.example.foodordersystem.pojo.User;

import java.sql.*;

public class UserLogin {
        public boolean login(String uname, String pwd) throws Exception {
        String driverName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://192.168.110.30:3306/food_order_system";
        String username = "root";
        String password = "root";Class.forName(driverName);
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "select user_id from users where user_name=? and password=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, uname);
        pst.setString(2, Md5Util.md5(pwd));
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
                return true;
        }
        rs.close();
        pst.close();
        conn.close();
        return false;
    }
}
