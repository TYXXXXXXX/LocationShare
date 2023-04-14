package com.example.foodordersystem.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginCode {
    private String userName;
    private String password;
    private String code;
}
