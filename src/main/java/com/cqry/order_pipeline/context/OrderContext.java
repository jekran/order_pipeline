package com.cqry.order_pipeline.context;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: cqry2017
 * @Date: 2021/06/08 16:07
 * @descript:
 */
@Data
public class OrderContext {
    private String skuId;
    private String goodsName;
    private BigDecimal amount;
}
