package com.example.foodordersystem.mapper;

import com.example.foodordersystem.pojo.Foods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class fabucaipin {

	public boolean fabucaipin(Foods foods) throws Exception{
		        // TODO Auto-generated method stub
				Class.forName("com.mysql.jdbc.Driver");
				// 3.获取数据库连接
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_order_system", "root","root");
				// 4.执行查询操作
				// 4.1定义一个sql语句【?号是占位符】
				String sql = "insert into foods values (0,?,?,?,(SELECT merchant_id FROM merchants WHERE merchant_name=?),?);";
				// 4.2得到执行器对象【带有预编译SQL语法功能的PreparedStatement对象】
				PreparedStatement pst = conn.prepareStatement(sql);
				// 4.3如果sql语句有?，那么需要给?号赋值；反之不需要
				// TODO
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date=new Date();
				pst.setString (1,"花雕醉鸡");
				pst.setDouble (2, 63);
				pst.setString (3,"肌肉质感鲜嫩，吃起来可以感觉到酒味");
				pst.setString (4,"花雕醉鸡");
				pst.setString(5,sdf.format(date));
				// 4.4执行SQL语句
				int count = pst.executeUpdate();
				if (count == 1) {
					System.out.println("修改数据成功！！！");
				} else {
					System.out.println("修改数据失败！！！");
				}
				
				// 5.关闭数据库资源【后开先关】

				pst.close();
				conn.close();
				return true;
	}

	private static void xinzengcaipin() throws Exception{
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		
		// 3.获取数据库连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_order_system", "root","root");
		// 4.执行查询操作
		// 4.1定义一个sql语句【?号是占位符】
		
		String sql = "update foods set food_name=?,price=?,description=? where food_name=? AND "
				+ "merchant_id=(SELECT merchant_id FROM merchants WHERE merchant_name=?);";
		// 4.2得到执行器对象【带有预编译SQL语法功能的PreparedStatement对象】
		PreparedStatement pst = conn.prepareStatement(sql);
		// 4.3如果sql语句有?，那么需要给?号赋值；反之不需要
		// TODO
		pst.setString (1,"热干面");
		pst.setDouble (2, 3);
		pst.setString (3,"武汉特产");
		pst.setString (4,"热干面");
		pst.setString (5,"花雕醉鸡");
		// 4.4执行SQL语句
		int count = pst.executeUpdate();
		if (count == 1) {
			System.out.println("修改数据成功！！！");
		} else {
			System.out.println("修改数据失败！！！");
		}
		
		// 5.关闭数据库资源【后开先关】

		pst.close();
		conn.close();
	}

}
