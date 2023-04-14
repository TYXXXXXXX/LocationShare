package com.example.foodordersystem.mapper;

import com.example.foodordersystem.pojo.Users;

public interface UsersMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Users row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Users row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Users selectByPrimaryKey(Integer userId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Users row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Users row);
}