package com.example.foodordersystem.pojo;

import java.sql.Date;
import java.sql.Timestamp;

public class User {
    private Integer userId;
    private String userName;
    private String password;
    private String email;
    public User() {

    }


    public User(Integer userId, String userName, String password, String email, String phone, Timestamp createTime) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    private String phone;
    private Timestamp createTime;


    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }




    public User(String username, String password,String phone, Timestamp create_time) {
        this.userName = username;
        this.password = password;
        this.phone = phone;
        this.createTime = create_time;
    }





    @Override
    public String toString() {
        return "user{" +
                "user_id=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", create_time='" + createTime + '\'' +
                '}';
    }
}
