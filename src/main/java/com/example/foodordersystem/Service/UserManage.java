package com.example.foodordersystem.Service;

import com.example.foodordersystem.mapper.utils.Connect;
import com.example.foodordersystem.pojo.Merchants;
import com.example.foodordersystem.pojo.User;

import java.sql.*;

public class UserManage {

    public UserManage() {
    }

    public boolean saveAddress(String param,String name) throws SQLException, ClassNotFoundException {
         Connection connection = Connect.getDriver();
        String sql = "UPDATE users SET address = ? where user_name = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, param);
        pst.setString(2, name);
        int count = pst.executeUpdate();
        if (count == 1) {
            System.out.println("修改成功");
            pst.close();
            connection.close();
            return true;
        } else {
            System.out.println("修改失败");
            pst.close();
            connection.close();
            return false;
        }

    }


    private boolean update(String param, Integer id) throws SQLException, ClassNotFoundException {
        //1.代表 2.提问 3.
        final Connection connection = Connect.getDriver();

        String sql = "UPDATE users SET user_name = ? where user_id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, param);
        pst.setInt(2, id);
        int count = pst.executeUpdate();
        if (count == 1) {
            System.out.println("修改成功");
            pst.close();
            connection.close();
            return true;
        } else {
            System.out.println("修改失败");
            pst.close();
            connection.close();
            return false;
        }

    }
    public boolean updateName(String name, Integer id) throws SQLException, ClassNotFoundException {
       return update(name,id);
    }

    public boolean updatePassword (String oldPassword, String newPassword, Integer id) throws SQLException,
            ClassNotFoundException {
        //输入为空直接返回false
        final Connection connection = Connect.getDriver();

        if (oldPassword == null || newPassword == null) return false;
        //根据id查询password
        String selectPassword = "select `password` from users where user_id = ?";
        PreparedStatement pst1 = connection.prepareStatement(selectPassword);
        pst1.setInt(1,id);
        ResultSet res = pst1.executeQuery();
        res.next();
        String password = res.getString(1);
        if(password.equals(oldPassword)) {
            String updateSql = "update users set `password` = ? where user_id = ?";
            PreparedStatement pst2 = connection.prepareStatement(updateSql);
            pst2.setString(1,newPassword);
            pst2.setInt(2,id);
           int count = pst2.executeUpdate();
            if(count == 1) {
                System.out.println("成功");
                pst2.close();
                pst1.close();
                connection.close();
                return true;
            }else {
                System.out.println("失败");
                pst2.close();
                pst1.close();
                connection.close();
                return false;
            }
        }
        pst1.close();
        connection.close();
        return false;
    }

    public User selectOne(String name) throws SQLException, ClassNotFoundException {
         final Connection connection = Connect.getDriver();

        String sql = "select * from users WHERE user_name = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1,name);
        ResultSet rs = pst.executeQuery();
        rs.next();
        User user = new User(rs.getInt(1),rs.getString(2)
                ,rs.getString(3),rs.getString(4),rs.getString(5)
                ,rs.getTimestamp(6));
        rs.close();
        pst.close();
        connection.close();
        return user;

    }

    public Merchants selectOneM(String name) throws SQLException, ClassNotFoundException {
        final Connection connection = Connect.getDriver();
        String sql = "select * from merchants where user_name = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1,name);
        ResultSet rs = pst.executeQuery();
        rs.next();
        Merchants merchants = new Merchants(rs.getInt(1),rs.getString(2)
        ,rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)
        ,new Timestamp(System.currentTimeMillis()),rs.getString(8),rs.getString(9));
        rs.close();
        pst.close();
        connection.close();
        return merchants;

    }


}
