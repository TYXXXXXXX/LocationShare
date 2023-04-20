package com.example.foodordersystem;


import com.example.foodordersystem.mapper.*;
import com.example.foodordersystem.mapper.utils.Connect;
import com.example.foodordersystem.mapper.utils.ImageUtils;
import com.example.foodordersystem.pojo.Foods;
import com.example.foodordersystem.pojo.Merchants;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LocationShareApplicationTests {

    private final Connection connection = Connect.getDriver();

    LocationShareApplicationTests() throws SQLException, ClassNotFoundException {
    }

    @Test
    void contextLoads() throws SQLException, ClassNotFoundException {
        Connect.getDriver();
    }

    @Test
    void selectUser() throws SQLException {
        List<String> strings = LocationShareApplicationTests.readLine("D:\\WeChat\\history.txt");
        StringBuilder sb = new StringBuilder();
        List<String> rs = new ArrayList<>();
        int count = 0;
        int s = 5;
        for (String string : strings) {
            System.out.println("---------------->" + string.equals(""));
            if (string.equals("")) continue;
            if (count == 1) {
                sb.append(string).append("#");
            } else sb.append(string).append("#");
            if (count == 5 && s == 5) {
                count = 0;
                rs.add(sb.toString());
                sb = new StringBuilder();
                s++;
            } else if (count == 6) {
                count = 0;
                rs.add(sb.toString());
                sb = new StringBuilder();
                s++;
            }
            count++;
        }
        //System.out.println("----------------》"+rs.get(0));
//        System.out.println(rs.get(1));
//        System.out.println(rs.get(2));
//        System.out.println(rs.get(3));
//        System.out.println(rs.get(39));
        for (String r : rs) {
            System.out.println(r);
        }
//        System.out.println(rs.get(1));
//        System.out.println(rs.get(2));
//        for (String s1 : s) {
//            String sql = "INSERT INTO timu(`abk`) VALUE(?)";
//            PreparedStatement pst = connection.prepareStatement(sql);
//            pst.setString(1,s1);
//            System.out.println("0000000000000");
//            pst.executeUpdate();
//            pst.close();
//        }
        connection.close();
//        String sql2 = "SELECT abk FROM `timu`";
//        PreparedStatement pst = connection.prepareStatement(sql2);
//        ResultSet rs = pst.executeQuery();
//        rs.next();
//        rs.next();
//        rs.next();
//        System.out.println(rs.getString(1));
//        pst.close();
//        connection.close();


    }

    public static List<String> readLine(String path) {
        List<String> res = new ArrayList<>();
        try (Stream<String> line = Files.lines(Paths.get(path))) {
            line.forEachOrdered(
                    res::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    private final FoodDao foodDao = new FoodDao();

    @Test
    void picture() throws IOException {
        System.out.println(foodDao.savePicture("static/picture/fish1.jpg"));
    }

    @Test
    void search() throws SQLException, ClassNotFoundException {
        SearchDao searchDao = new SearchDao();
        List<String> strings = searchDao.searchFood("鸡肉");
        for (String string : strings) {
            System.out.println(string);
        }


    }
    SearchFood searchFood = new SearchFood();


    @Test
    void searchFood() {
        List<Foods> list = searchFood.searchFood(1);
        for (Foods foods : list) {
            System.out.println(foods.toString());
        }

    }

    @Test
    void saveFood() {
        System.out.println(searchFood.saveFood(new Foods("丸子", BigDecimal.valueOf(3.3), "好吃不贵",
                6, new Timestamp(System.currentTimeMillis()), "sss")));
    }
    UserRegis regis = new UserRegis();
    @Test
    void isSeta() throws SQLException, ClassNotFoundException {
        System.out.println(regis.isSet("wo"));
    }
    SearchDao searchDao = new SearchDao();
    @Test
    void mer() throws SQLException, ClassNotFoundException {
       List<SearchDao.Merchant> list = searchDao.getMerchants();
        for (SearchDao.Merchant merchant : list) {
            System.out.println(merchant);
        }
    }

    @Test
    void searchFoods() {
        List<Foods> list = searchFood.searchFood(1);
        for (Foods foods : list) {
            System.out.println(foods);
        }
    }

    @Test
    void Mset() throws SQLException, ClassNotFoundException {
        System.out.println(regis.isSetM("老0"));
    }
    @Test
    void insert() throws SQLException, ClassNotFoundException {
        System.out.println(regis.registerM(new Merchants("老六", "蜜雪冰城", "12345"
                , "1325455", new Timestamp(System.currentTimeMillis()))));
    }
    private final UserLogin login = new UserLogin();
    @Test
    void seuse() throws Exception {
        System.out.println(login.login("xxx","12345"));
    }


}
