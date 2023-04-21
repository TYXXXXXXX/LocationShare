package com.example.foodordersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserToM {

    private String userName;
    private String phone;
    private String address;
    private List<String> food;
    private Double total;
    private Integer status;
}
