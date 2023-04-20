package com.example.foodordersystem.mapper;

import com.example.foodordersystem.mapper.utils.Connect;
import lombok.AllArgsConstructor;
import lombok.Data;

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

    public SearchDao() throws SQLException, ClassNotFoundException {
    }

    public List<String> searchFood(String str) {
        List<String> res = new ArrayList<>();
        try (Connection conn = Connect.getDriver()) {
            str = str.replaceAll("", "|");
            str = str.substring(1, str.length() - 1);
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

    public List<SearchDao.Merchant> getMerchants() throws SQLException, ClassNotFoundException {
        List<SearchDao.Merchant> merchants = new ArrayList<>();
        final Connection connection = Connect.getDriver();
            String sql = "SELECT merchant_name,`describe`,image FROM merchants";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                merchants.add(new Merchant(rs.getString(1), rs.getString(2)
                        , rs.getString(3)));
            }
            rs.close();
            pst.close();
            connection.close();
            return merchants;
    }
    @AllArgsConstructor
    @Data
    public static
    class Merchant {
        private String name ;
        private String describe;
        private String image;

    }


}
