package com.example.foodordersystem.mapper;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class liulan {

	private static void liulanfoot() throws Exception{
				// 3.获取数据库连接
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_order_system", "root","root");
				// 4.执行查询操作
				// 4.1定义一个sql语句【?号是占位符】
				
				String sql = "select * from foods where merchant_id=(select merchant_id from merchants where merchant_name=?)";
				// 4.2得到执行器对象【带有预编译SQL语法功能的PreparedStatement对象】
				PreparedStatement pst = conn.prepareStatement(sql);
				// 4.3如果sql语句有?，那么需要给?号赋值；反之不需要
				// TODO
				pst.setString (1,"花雕醉鸡");
				// 4.4执行SQL语句
				ResultSet rs = pst.executeQuery();
				// 4.5遍历查询结果集
				while (rs.next()) {// 判断有没有下一行
					// 取出每个列的字段值				
					String foodname = rs.getString("food_name");
					double price =rs.getDouble("price");
					String description=rs.getString("description");
					System.out.println(foodname+"----"+String.format("%.2f", price)+"----"+description);
			
				}
				
				// 5.关闭数据库资源【后开先关】
				
				rs.close();
				pst.close();
				conn.close();
				
		
	}
	public static void liulanmerchant() throws Exception {
		// 1.定义数据库连接的基本四项
		String driverName = "com.mysql.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/food_order_system";
		String username = "root";
		String password = "root";
		// 2.加载驱动包
		Class.forName(driverName);
		// 3.获取数据库连接
		Connection conn = DriverManager.getConnection(url, username, password);
		// 4.执行查询操作
		// 4.1定义一个sql语句【?号是占位符】
		String sql = "select * from merchants";
		// 4.2得到执行器对象【带有预编译SQL语法功能的PreparedStatement对象】
		PreparedStatement pst = conn.prepareStatement(sql);
		// 4.3如果sql语句有?，那么需要给?号赋值；反之不需要
		// TODO
		// 4.4执行DQL语句
		ResultSet rs = pst.executeQuery();
		// 4.5遍历查询结果集
		while (rs.next()) {// 判断有没有下一行
			// 取出每个列的字段值
			int id = rs.getInt("merchant_id");
			String uname = rs.getString("merchant_name");
			String phone=rs.getString("phone");
			System.out.println(id + "----" + uname + "----" +phone);
		}
		// 5.关闭数据库资源【后开先关】
		rs.close();
		pst.close();
		conn.close();
	}

}
