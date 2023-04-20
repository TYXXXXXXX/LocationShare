package com.example.foodordersystem.mapper;

import com.example.foodordersystem.mapper.utils.Connect;
import com.example.foodordersystem.pojo.Foods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Description:
 * Author: Tyx
 * Date: 2023/4/19
 */
public class FoodDao {

    public boolean savePicture(String path) {
        try (Connection conn = DriverManager.getConnection(Connect.URL,Connect.USERNAME,Connect.PASSWORD)) {
            String sql = "UPDATE foods SET picture = ? WHERE food_id = 1";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,path);
           int a = pst.executeUpdate();
           if(a == 1) return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
