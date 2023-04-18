package com.example.foodordersystem.mapper;

import com.example.foodordersystem.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
@Mapper
public interface UsersMapper {
    @Results(@Result())
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

    //根据用户查询密码
    String searchUserName(String name);
}