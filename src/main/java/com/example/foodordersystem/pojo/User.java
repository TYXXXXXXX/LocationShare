package com.example.foodordersystem.pojo;

import java.sql.Timestamp;

public class User {
    private int user_id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private Timestamp create_time;

    public User(int user_id, String username, String password) {
        this.user_id =  user_id;
        this.username =  username;
        this.password =  password;
    }

    public User(String userName, String password) {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public User() {
        super();
    }

    public User(String username, String password,String phone, Timestamp create_time) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.create_time = create_time;
    }

    public User(int user_id, String username, String password, String phone, String email) {
        super();
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "user{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
