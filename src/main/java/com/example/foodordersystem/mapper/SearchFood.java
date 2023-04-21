package com.example.foodordersystem.mapper;

import com.example.foodordersystem.mapper.utils.Connect;
import com.example.foodordersystem.pojo.Foods;
import com.example.foodordersystem.pojo.Orders;
import com.example.foodordersystem.pojo.UserToM;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchFood {

//    public UserToM send(Integer m_id) throws SQLException, ClassNotFoundException {
//        Connection connection = Connect.getDriver();
//        String sql = "SELECT user_name ,phone,address FROM users WHERE user_id = (SELECT user_id FROM orders where merchant_id = ?)";
//        String sql1 = "SELECT food_id ,quantity FROM cart_item WHERE cart_id = (SELECT cart_id FROM cart\n" +
//                "WHERE user_id = (SELECT user_id FROM users WHERE user_name = 'Tyx'))";
//        String sql3 = "SELECT food_name FROM foods WHERE food_id = ?";
//        String sql2 = "SELECT total_price,`status` FROM orders\n" +
//                "WHERE user_id = (SELECT user_id FROM users WHERE user_name = 'Tyx')";
//        PreparedStatement pst = connection.prepareStatement(sql);
//
//        List<UserToM> list = new ArrayList<>();
//
//        int count = pst.executeUpdate();
//        if (count == 1) {
//            System.out.println("修改成功");
//            pst.close();
//            connection.close();
//            return true;
//        } else {
//            System.out.println("修改失败");
//            pst.close();
//            connection.close();
//            return false;
//        }
//    }


//    public boolean sendOrder(Integer id) throws SQLException, ClassNotFoundException {
//        Connection connection = Connect.getDriver();
//        String sql = "UPDATE orders SET status = ? where order_id = ?";
//        PreparedStatement pst = connection.prepareStatement(sql);
//        pst.setInt(1, status);
//        pst.setInt(2, id);
//        int count = pst.executeUpdate();
//        if (count == 1) {
//            System.out.println("修改成功");
//            pst.close();
//            connection.close();
//            return true;
//        } else {
//            System.out.println("修改失败");
//            pst.close();
//            connection.close();
//            return false;
//        }
//    }

    public boolean updateOrder(Integer status,Integer id) throws SQLException, ClassNotFoundException {

        //1.代表 2.提问 3.
         Connection connection = Connect.getDriver();

        String sql = "UPDATE orders SET status = ? where order_id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, status);
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

    public boolean saveOrder(Orders orders) throws SQLException, ClassNotFoundException {
        Connection connection = Connect.getDriver();
        String sql = "INSERT into orders(user_id,merchant_id,total_price,`status`,create_time,levels) " +
                "VALUES(?,?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, orders.getUserId());
        pst.setInt(2,orders.getMerchantId());
        pst.setBigDecimal(3,orders.getTotalPrice());
        pst.setInt(4,orders.getStatus());
        pst.setTimestamp(5,new Timestamp(System.currentTimeMillis()));
        pst.setString(6,orders.getLevels());
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
                pst.setInt(4,1);
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
