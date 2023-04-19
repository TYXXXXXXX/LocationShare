package com.example.foodordersystem.controller;

import com.example.foodordersystem.mapper.SearchDao;
import com.example.foodordersystem.mapper.SearchFood;
import com.example.foodordersystem.pojo.Foods;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    private final SearchDao searchDao = new SearchDao();
    private final SearchFood searchFood = new SearchFood();

    @GetMapping
    public void join() {
        System.out.println("登录成功");
    }

    @GetMapping("/search/{str}")
    public List<String> search(@PathVariable String str) {
        return searchDao.searchFood(str);
    }

    @GetMapping("/searchFood/{id}")
    public List<Foods> searchFood(@PathVariable Integer id) {
        return searchFood.searchFood(id);
    }


}
