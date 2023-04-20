package com.example.foodordersystem.controller;

import com.example.foodordersystem.controller.utils.R;
import com.example.foodordersystem.mapper.SearchDao;
import com.example.foodordersystem.mapper.SearchFood;
import com.example.foodordersystem.pojo.Foods;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    private final SearchDao searchDao = new SearchDao();
    private final SearchFood searchFood = new SearchFood();

    public UserController() throws SQLException, ClassNotFoundException {
    }

    @GetMapping
    public void join() {
        System.out.println("登录成功");
    }

    @GetMapping("/search/{str}")
    public List<String> search(@PathVariable String str) {
        return searchDao.searchFood(str);
    }

    @GetMapping("/searchFood/{id}")
    public R searchFood(@PathVariable Integer id) {
        return new R(true,searchFood.searchFood(id));
    }

//    @PostMapping("/saveFood")
//    public R saveFood(@RequestBody Foods foods){
//
//    }

    @GetMapping("/Merchants")
    public R sendMerchants() throws SQLException, ClassNotFoundException {
       return new R(true,searchDao.getMerchants());
    }


}
