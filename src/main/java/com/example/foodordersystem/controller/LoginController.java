package com.example.foodordersystem.controller;

import com.example.foodordersystem.Service.UserManageTyx;
import com.example.foodordersystem.controller.utils.R;
import com.example.foodordersystem.mapper.UserLogin;
import com.example.foodordersystem.mapper.UserRegis;
import com.example.foodordersystem.pojo.Merchants;
import com.example.foodordersystem.pojo.User;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.Timestamp;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final UserManageTyx userManage = new UserManageTyx();
     private final UserLogin login = new UserLogin();
     private final UserRegis regis = new UserRegis();

    public LoginController() throws SQLException, ClassNotFoundException {
    }

    @PostMapping("/user")
    public R login(@RequestBody User user) throws Exception {
        if(login.login(user.getUserName(),user.getPassword())){
            return new R(true,userManage.selectOne(user.getUserName()));
        }
        return new R(false,"用户名或密码不正确");
    }

    @PostMapping("/M")
    public R loginM(@RequestBody Merchants merchants) throws SQLException, ClassNotFoundException {
        if(login.loginM(merchants.getUserName(),merchants.getPassword())){
            return new R(true,userManage.selectOneM(merchants.getUserName()));
        }
        return new R(false,"用户名或密码不正确");
    }

    @PostMapping("/{name}/{password}/{phone}")
    public R regis(@PathVariable String name, @PathVariable String password,@PathVariable String phone) throws Exception {
       if(regis.register(new User(name,password ,phone,new Timestamp(System.currentTimeMillis())))){
           return new R(true,"注册成功,即将跳转...");
       }
       return new R(false,"请稍后再试");
    }

    @PostMapping("/R2")
    public R regis2(@RequestBody Merchants merchants) throws SQLException, ClassNotFoundException {
        if(regis.registerM(merchants)) {
            return new R(true,"注册成功,即将跳转...");
        }
        return new R(false,"请稍后再试");
    }

    @GetMapping("/isSet/{name}")
    public R isSet(@PathVariable String name) throws SQLException, ClassNotFoundException {
        System.out.println("执行isSet");
        if(regis.isSet(name)) return new R(false,"用户已存在");
        return new R(true,"");
    }

    @GetMapping("/isSet2/{name}")
    public R isSet2(@PathVariable String name) throws SQLException, ClassNotFoundException {

        if(regis.isSetM(name)) return new R(false,"用户已存在");
        return new R(true,"");
    }


//    @GetMapping("/SS")
//    public String ss() throws SQLException, ClassNotFoundException, JsonProcessingException {
//        System.out.println("执行了");
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.writeValueAsString(test.testSelectMany());
//    }
}
