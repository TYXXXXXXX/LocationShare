package com.example.foodordersystem.mapper;

import com.example.foodordersystem.pojo.Orders;

public interface OrdersMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(Integer orderId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Orders row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Orders row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Orders selectByPrimaryKey(Integer orderId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Orders row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Orders row);
}