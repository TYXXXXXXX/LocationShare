package com.example.foodordersystem.pojo;

import java.sql.Timestamp;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Table: merchants
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Merchants {
    /**
     * Column: merchant_id
     * Type: INT
     */
    private Integer merchantId;

    /**
     * Column: user_name
     * Type: VARCHAR(255)
     */
    private String userName;

    /**
     * Column: merchant_name
     * Type: VARCHAR(50)
     */
    private String merchantName;

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

    /**
     * Column: describe
     * Type: VARCHAR(255)
     */
    private String describe;

    /**
     * Column: image
     * Type: VARCHAR(255)
     */
    private String image;

    public Merchants(String userName, String merchantName, String password, String phone, Timestamp createTime) {
        this.userName = userName;
        this.merchantName = merchantName;
        this.password = password;
        this.phone = password;
        this.createTime = createTime;
    }
}