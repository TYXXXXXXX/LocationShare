package com.example.foodordersystem.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Oder {

    public int getUser_id(){
        return user_id;
    }
    private int order_id;
    private int user_id;
    private int merchant_id;
    private BigDecimal total_price;
    private int  status;
    private Timestamp creat_time;
    private String levels;

    public void setStatus(int status) {
        this.status = status;
    }
    public void setMerchant_id(int merchant_id) {
        this.merchant_id = merchant_id;
    }
    public void setCreat_time(Timestamp creat_time) {
        this.creat_time = creat_time;
    }
    public Timestamp getCreat_time() {
        return creat_time;
    }
    public int getMerchant_id() {
        return merchant_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public int getStatus() {
        return status;
    }
    public BigDecimal getTotal_price() {
        return total_price;
    }
    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }
    public int getOrder_id() {
        return order_id;
    }

    public String getLevels() {
        return levels;
    }

    public void setLevels(String levels) {
        this.levels = levels;
    }
}
