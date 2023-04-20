package com.example.foodordersystem.pojo;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * Table: foods
 */
@Data
public class Foods {
    /**
     * Column: food_id
     * Type: INT
     */
    private Integer foodId;

    /**
     * Column: food_name
     * Type: VARCHAR(50)
     */
    private String foodName;

    /**
     * Column: price
     * Type: DECIMAL
     */
    private BigDecimal price;

    /**
     * Column: description
     * Type: VARCHAR(500)
     */
    private String description;

    /**
     * Column: merchant_id
     * Type: INT
     */
    private Integer merchantId;

    /**
     * Column: create_time
     * Type: DATETIME
     */
    private Date createTime;

    /**
     * Column: picture
     * Type: BLOB
     */
    private String picture;

//    public Foods(String foodName, BigDecimal price, String description,String picture) {
//        this.foodName = foodName;
//        this.price = price;
//        this.description = description;
//        this.picture = picture;
//    }

    public Foods(String foodName, BigDecimal price, String description, Integer merchantId, Date createTime,
                 String picture) {
        this.foodName = foodName;
        this.price = price;
        this.description = description;
        this.merchantId = merchantId;
        this.createTime = createTime;
        this.picture = picture;
    }
    public Foods(String foodName, BigDecimal price, String description,String picture) {
        this.foodName = foodName;
        this.price = price;
        this.description = description;
        this.picture = picture;
    }
}