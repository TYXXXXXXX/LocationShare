package com.example.foodordersystem.Service;

import com.example.foodordersystem.mapper.utils.Connect;
import com.example.foodordersystem.mapper.utils.ImageUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Description:
 * Author: Tyx
 * Date: 2023/4/18
 */
public class FoodServer {


    public void savePicture(byte[] bytes) throws IOException {
        byte[] bytes1 = ImageUtils.readImage("D:\\food_pictuure\\杨氏手撕烧鸡.png");
        try (Connection conn = DriverManager.getConnection(Connect.URL,Connect.USERNAME,Connect.PASSWORD)) {
            String sql = "INSERT INTO foods (food_name,price,merchant_id,crete_time,picture) VALUES (?,?,?,?,?)";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
