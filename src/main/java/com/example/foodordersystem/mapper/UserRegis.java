package com.example.foodordersystem.mapper;

import com.example.foodordersystem.Service.utils.Md5Util;
import com.example.foodordersystem.mapper.utils.Connect;
import com.example.foodordersystem.pojo.User;

import java.sql.*;

//zxr
public class UserRegis {

    public UserRegis() throws SQLException, ClassNotFoundException {
    }

    public boolean register(User user) throws Exception {
        String driverName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://192.168.110.30:3306/food_order_system";
        String user_name = "root";
        String password = "root";
        Class.forName(driverName);
        Connection conn = DriverManager.getConnection(url, user_name, password);
        String sql = "insert into users(user_name,password,email,phone,create_time) values(?, ?, ?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        pst.setString(1,user.getUsername() );
        pst.setString(2, Md5Util.md5(user.getPassword()));
        pst.setString(3,user.getEmail() );
        pst.setString(4,user.getPhone() );
        pst.setTimestamp(5,user.getCreate_time());
        int count = pst.executeUpdate();
        pst.close();

        conn.close();
        return count == 1;
    }

    public boolean isSet(String name) throws SQLException, ClassNotFoundException {
        final Connection connection = Connect.getDriver();
        String sql = "select user_name from users where user_name = ?";
        PreparedStatement pst2 = connection.prepareStatement(sql);
        pst2.setString(1,name);
        ResultSet rs =  pst2.executeQuery();
        boolean flag = rs.next();
        rs.close();
        pst2.close();
        connection.close();
        return flag;
    }
}
