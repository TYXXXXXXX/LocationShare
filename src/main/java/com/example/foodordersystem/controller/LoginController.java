package com.example.foodordersystem.controller;

import com.example.foodordersystem.Service.LoginServer;
import com.example.foodordersystem.pojo.Test2;
import com.example.foodordersystem.pojo.sh;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Resource
    private LoginServer loginServer;
    @PostMapping("/L")
    public Test2 login(@RequestBody Test2 test2) {
        System.out.println(test2);
        System.out.println(test2.getUserName()+","+test2.getPassword());
        return test2;
    }

//    @GetMapping("/SS")
//    public String ss() throws SQLException, ClassNotFoundException, JsonProcessingException {
//        System.out.println("执行了");
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.writeValueAsString(test.testSelectMany());
//    }
}
