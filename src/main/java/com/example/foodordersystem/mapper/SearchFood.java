package com.example.foodordersystem.mapper;

import com.example.foodordersystem.mapper.utils.Connect;
import com.example.foodordersystem.pojo.Foods;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Author: Tyx
 * Date: 2023/4/19
 */
public class SearchFood {
    public List<Foods> searchFood(Integer id) {
        List<Foods> res = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(Connect.URL,Connect.USERNAME,Connect.PASSWORD)) {
            String sql = "SELECT food_name ,price, description,picture FROM foods WHERE merchant_id = ?;";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,id);
           ResultSet rs = pst.executeQuery();
           while (rs.next()) {
               res.add(new Foods(rs.getString(1),rs.getBigDecimal(2),rs.getString(3)
               ,rs.getString(4)));
           }
           pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public boolean saveFood(Foods foods) {
        try (Connection conn = DriverManager.getConnection(Connect.URL,Connect.USERNAME,Connect.PASSWORD)) {
            String sql = "INSERT INTO foods(food_name,price,description,merchant_id,create_time,picture)" +
                    " VALUES(?,?,?,?,?,?)";
            try(PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1,foods.getFoodName());
                pst.setBigDecimal(2, new BigDecimal(String.valueOf(foods.getPrice())));
                pst.setString(3,foods.getDescription());
                pst.setInt(4,foods.getMerchantId());
                pst.setTimestamp(5,new Timestamp(System.currentTimeMillis()));
                pst.setString(6,foods.getPicture());
                int count = pst.executeUpdate();
                if (count == 1) return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
