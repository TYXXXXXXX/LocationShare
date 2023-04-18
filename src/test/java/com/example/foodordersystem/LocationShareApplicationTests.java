package com.example.foodordersystem;


import com.example.foodordersystem.mapper.utils.Connect;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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
//        List<String> strings = LocationShareApplicationTests.readLine("D:\\WeChat\\Test.txt");
//        List<String> rs = new ArrayList<>();
//        StringBuilder sb = new StringBuilder();
//        for (String string : strings) {
//            sb.append(string);
//        }
//        String[] s = sb.toString().split("/");
//        for (String s1 : s) {
//            String sql = "INSERT INTO timu(`abk`) VALUE(?)";
//            PreparedStatement pst = connection.prepareStatement(sql);
//            pst.setString(1,s1);
//            System.out.println("0000000000000");
//            pst.executeUpdate();
//            pst.close();
//        }
//        connection.close();
        String sql2 = "SELECT abk FROM `timu`";
        PreparedStatement pst = connection.prepareStatement(sql2);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        pst.close();
        connection.close();




    }

    public static List<String> readLine(String path) {
        List<String> res = new ArrayList<>();
        try (Stream<String> line = Files.lines(Paths.get(path))) {
            line.forEachOrdered(
                    s -> {
                        if (res.size() > 400) line.close();
                        res.add(s);
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }


}
