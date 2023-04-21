package com.example.foodordersystem.controller;

import com.example.foodordersystem.Service.UserManage;
import com.example.foodordersystem.Service.UserManage;
import com.example.foodordersystem.controller.utils.R;
import com.example.foodordersystem.mapper.SearchDao;
import com.example.foodordersystem.mapper.SearchFood;

import com.example.foodordersystem.pojo.Orders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/user")
public class UserController {
    private final SearchDao searchDao = new SearchDao();
    private final SearchFood searchFood = new SearchFood();
    private final UserManage userManage = new UserManage();

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

    @PostMapping("/upload-image")
    public String uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("path") String path) {
        // 处理上传的图片文件
        // ...
        // 保存上传的图片文件到指定路径
        // ...
        if (!file.isEmpty()) {
            try {
                // 获取上传的图片文件名
                String fileName = file.getOriginalFilename();
                // 获取上传的图片文件的扩展名
                String fileExtension = null;
                if (fileName != null) {
                    fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
                }
                // 生成一个唯一的文件名，避免出现重名的情况
                String newFileName = UUID.randomUUID().toString() + "." + fileExtension;
                // 将上传的图片文件保存到指定路径
                File destFile = new File(path + File.separator + newFileName);
                file.transferTo(destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "success";
    }

    @GetMapping("address/{a}/{n}")
    public R saveAddress(@PathVariable String a,@PathVariable String n) throws SQLException, ClassNotFoundException {
        if(userManage.saveAddress(a,n)){
            return new R(true,userManage.selectOne(n));
        }else return new R(false,"添加失败");
    }

    @PostMapping("/order")
    public R saveOrder(@RequestBody Orders orders) throws SQLException, ClassNotFoundException {
        if(searchFood.saveOrder(orders)){
            return new R(true,"提交成功");
        }else {
            return new R(false,"请稍后再试");
        }
    }

    @GetMapping("/change/{status}/{id}")
    public R change(@PathVariable Integer status,@PathVariable Integer id) throws SQLException, ClassNotFoundException {
        if(searchFood.updateOrder(status,id)){
            return new R(true,"支付成功");
        }else return new R(false,"支付失败");
    }



}
