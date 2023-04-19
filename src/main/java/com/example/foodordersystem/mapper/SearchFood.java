package com.example.foodordersystem.mapper;

import com.example.foodordersystem.mapper.utils.Connect;
import com.example.foodordersystem.pojo.Foods;

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
            String sql = "SELECT food_name ,price, description FROM foods WHERE merchant_id = ?;";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,id);
           ResultSet rs = pst.executeQuery();
           while (rs.next()) {
               res.add(new Foods(rs.getString(1),rs.getBigDecimal(2),rs.getString(3)));
           }
           pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
