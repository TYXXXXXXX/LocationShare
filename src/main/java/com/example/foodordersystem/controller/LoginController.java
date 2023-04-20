package com.example.foodordersystem.controller;

import com.example.foodordersystem.Service.UserManageTyx;
import com.example.foodordersystem.controller.utils.R;
import com.example.foodordersystem.mapper.UserLogin;
import com.example.foodordersystem.pojo.Test2;
import com.example.foodordersystem.pojo.User;
import com.example.foodordersystem.pojo.Users;
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
    private final UserManageTyx userManage = new UserManageTyx();
     private final UserLogin login = new UserLogin();

    public LoginController() throws SQLException, ClassNotFoundException {
    }

    @PostMapping("/user/{name}/{password}")
    public R login(@PathVariable String name,@PathVariable String password) throws Exception {
        if(login.login(name,password)){
            return new R(true,userManage.selectOne(name));
        }
        return new R(false,"用户名和密码不正确");
    }

//    @GetMapping("/SS")
//    public String ss() throws SQLException, ClassNotFoundException, JsonProcessingException {
//        System.out.println("执行了");
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.writeValueAsString(test.testSelectMany());
//    }
}
