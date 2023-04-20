package com.example.foodordersystem.controller;

import com.example.foodordersystem.Service.UserManageTyx;
import com.example.foodordersystem.controller.utils.R;
import com.example.foodordersystem.mapper.UserLogin;
import com.example.foodordersystem.mapper.UserRegis;
import com.example.foodordersystem.pojo.Test2;
import com.example.foodordersystem.pojo.User;
import com.example.foodordersystem.pojo.Users;
import com.example.foodordersystem.pojo.sh;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final UserManageTyx userManage = new UserManageTyx();
     private final UserLogin login = new UserLogin();
     private final UserRegis regis = new UserRegis();

    public LoginController() throws SQLException, ClassNotFoundException {
    }

    @PostMapping("/user/{name}/{password}")
    public R login(@PathVariable String name,@PathVariable String password) throws Exception {
        System.out.println(name+""+password);
        if(login.login(name,password)){
            return new R(true,userManage.selectOne(name));
        }
        System.out.println("11111111111111");
        return new R(false,"用户名和密码不正确");
    }

    @PostMapping("/{name}/{password}/{phone}")
    public R regis(@PathVariable String name, @PathVariable String password,@PathVariable String phone) throws Exception {
       if(regis.register(new User(name,password ,phone,new Timestamp(System.currentTimeMillis())))){
           return new R(true,"注册成功");
       }
       return new R(false,"请稍后再试");
    }

    @GetMapping("/isSet/{name}")
    public R isSet(@PathVariable String name) throws SQLException, ClassNotFoundException {
        if(regis.isSet(name)) return new R(false,"用户已存在");
        return new R(true,"");
    }


//    @GetMapping("/SS")
//    public String ss() throws SQLException, ClassNotFoundException, JsonProcessingException {
//        System.out.println("执行了");
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.writeValueAsString(test.testSelectMany());
//    }
}
