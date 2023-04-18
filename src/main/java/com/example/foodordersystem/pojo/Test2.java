package com.example.foodordersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Test2 {
    private String userName;
    private String password;
    private String passwordAgain;
    private String number;
}
