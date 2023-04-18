package com.example.foodordersystem.Service;

import com.example.foodordersystem.mapper.OrdersMapper;
import com.example.foodordersystem.mapper.UsersMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class LoginServer {
    @Resource
    private UsersMapper mapper;
    /**
     *Description: 
     *@param 
     *@return 
    **/
    public String getPassword(String name) {
        return mapper.searchUserName(name);
    }
}
