package com.example.foodordersystem.Service;

import java.math.BigDecimal;
import java.sql.*;


public class OrderDao {
    private static final String URL = "jdbc:mysql://192.168.110.30:3306/food_order_system";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public void addOder(int user_id, int merchant_id, BigDecimal total_price, int status, Timestamp create_time,String levels) throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO orders(user_id, merchant_id, total_price,status,create_time,levels) VALUES(?, ?, ? ,? ,?,?)");
            pstmt.setInt(1, user_id);
            pstmt.setInt(2, merchant_id);
            pstmt.setBigDecimal(3, total_price);
            pstmt.setInt(4, status);
            pstmt.setTimestamp(5, create_time);
            pstmt.setString(6,levels);
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOrder(int user_id, int merchant_id, BigDecimal total_price, int status, Timestamp create_time,int order_id,String levels) throws SQLException {
        try (Connection conn1 = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement pstmt = conn1.prepareStatement("UPDATE orders SET user_id = ?, merchant_id = ?, total_price = ?, status = ? , create_time = ? ,levels = ? WHERE order_id = ?");

            pstmt.setInt(1, user_id);
            pstmt.setInt(2, merchant_id);
            pstmt.setBigDecimal(3, total_price);
            pstmt.setInt(4, status);

            pstmt.setTimestamp(5, create_time);
            pstmt.setInt(6, order_id);
            pstmt.setString(7,levels);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Order updated in the orders table.");
            } else {

                System.out.println("Order not found in the orders table.");
            }

            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteOrder(int order_id) throws SQLException {
        try (Connection conn1 = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement pstmt = conn1.prepareStatement("DELETE FROM orders WHERE order_id = ?");

            pstmt.setInt(1,order_id);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Order 已经被删除.");
            } else {
                System.out.println("Order not found in the order table.");
            }
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
