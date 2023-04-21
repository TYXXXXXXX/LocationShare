package com.example.foodordersystem.pojo;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Table: orders
 */
@Data
public class Orders {
    /**
     * Column: order_id
     * Type: INT
     */
    private Integer orderId;

    /**
     * Column: user_id
     * Type: INT
     */
    private Integer userId;

    /**
     * Column: merchant_id
     * Type: INT
     */
    private Integer merchantId;

    /**
     * Column: total_price
     * Type: DECIMAL
     */
    private BigDecimal totalPrice;

    /**
     * Column: status
     * Type: INT
     */
    private Integer status;

    /**
     * Column: create_time
     * Type: DATETIME
     */
    private Date createTime;

    /**
     * Column: levels
     * Type: VARCHAR(255)
     */
    private String levels;

    public Orders(Integer userId, Integer merchantId, BigDecimal totalPrice, Integer status, Date createTime,
                  String levels) {
        this.userId = userId;
        this.merchantId = merchantId;
        this.totalPrice = totalPrice;
        this.status = status;
        this.createTime = createTime;
        this.levels = levels;
    }
}