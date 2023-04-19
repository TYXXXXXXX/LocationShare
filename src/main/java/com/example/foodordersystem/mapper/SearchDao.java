package com.example.foodordersystem.mapper;

import com.example.foodordersystem.mapper.utils.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Author: Tyx
 * Date: 2023/4/19
 */
public class SearchDao {
    public List<String> searchFood(String str) {
        List<String> res = new ArrayList<>();
        try (Connection conn = Connect.getDriver()) {
            str = str.replaceAll("", "|");
            str = str.substring(1,str.length()-1);
            String sql = "SELECT merchant_name FROM merchants WHERE merchant_name REGEXP ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, str);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    res.add(rs.getString(1));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }
}
