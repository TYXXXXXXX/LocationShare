package com.example.foodordersystem.mapper;

import com.example.foodordersystem.Service.utils.Md5Util;
import com.example.foodordersystem.mapper.utils.Connect;
import com.example.foodordersystem.pojo.Merchants;
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

    public boolean registerM(Merchants merchant) throws SQLException, ClassNotFoundException {
        final Connection connection = Connect.getDriver();
        String sql = "INSERT INTO merchants(user_name,merchant_name,`password`,phone,create_time)" +
                "VALUES(?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1,merchant.getUserName());
        pst.setString(2,merchant.getMerchantName());
        pst.setString(3,Md5Util.md5(merchant.getPassword()));
        pst.setString(4, merchant.getPhone());
        pst.setTimestamp(5,new Timestamp(System.currentTimeMillis()));
        int count = pst.executeUpdate();
        pst.close();
        connection.close();
        return count == 1;
    }

    public boolean isSetM(String name) throws SQLException, ClassNotFoundException {
        final Connection connection = Connect.getDriver();
        String sql = "select merchant_id from merchants where user_name = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1,name);
        ResultSet rs =  pst.executeQuery();
        boolean flag = rs.next();
        rs.close();
        pst.close();
        connection.close();
        return flag;
    }
}
