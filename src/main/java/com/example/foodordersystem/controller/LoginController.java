package com.example.foodordersystem.controller;

import com.example.foodordersystem.controller.utils.R;
import com.example.foodordersystem.pojo.LoginCode;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @RequestMapping
    public R login(@RequestBody LoginCode loginCode) {
        System.out.println(loginCode.getCode());
        System.out.println(loginCode.getUserName());
        System.out.println(loginCode.getPassword());
        return new R(true,"登录成功");

    }
}
