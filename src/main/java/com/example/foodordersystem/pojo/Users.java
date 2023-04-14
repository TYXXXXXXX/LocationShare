package com.example.foodordersystem.pojo;

import java.util.Date;
import lombok.Data;

/**
 * Table: users
 */
@Data
public class Users {
    /**
     * Column: user_id
     * Type: INT
     */
    private Integer userId;

    /**
     * Column: user_name
     * Type: VARCHAR(50)
     */
    private String userName;

    /**
     * Column: password
     * Type: VARCHAR(50)
     */
    private String password;

    /**
     * Column: email
     * Type: VARCHAR(50)
     */
    private String email;

    /**
     * Column: phone
     * Type: VARCHAR(20)
     */
    private String phone;

    /**
     * Column: create_time
     * Type: DATETIME
     */
    private Date createTime;
}