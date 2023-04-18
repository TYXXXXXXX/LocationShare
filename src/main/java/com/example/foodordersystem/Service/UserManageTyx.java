package com.example.foodordersystem.Service;

import com.example.foodordersystem.mapper.utils.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManageTyx {
    private final Connection connection = Connect.getDriver();

    public UserManageTyx() throws SQLException, ClassNotFoundException {
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserManageTyx userManageTyx = new UserManageTyx();
        userManageTyx.updateName("Tyx", 1);
//        userManageTyx.updatePassword("123","12345",1);
        userManageTyx.close();
    }

    private boolean update(String param, Integer id) throws SQLException {
        //1.代表 2.提问 3.
        String sql = "UPDATE users SET user_name = ? where user_id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, param);
        pst.setInt(2, id);
        int count = pst.executeUpdate();
        if (count == 1) {
            System.out.println("修改成功");
            pst.close();
            return true;
        } else {
            System.out.println("修改失败");
            pst.close();
            return false;
        }

    }
    public boolean updateName(String name, Integer id) throws SQLException {
       return update(name,id);
    }

    public boolean updatePassword (String oldPassword, String newPassword, Integer id) throws SQLException {
        //输入为空直接返回false
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
                return true;
            }else {
                System.out.println("失败");
                pst2.close();
                pst1.close();
                return false;
            }
        }
        pst1.close();
        return false;
    }

    public void close() throws SQLException {
        connection.close();
    }
}
