package com.cqry.order_pipeline.context;

import lombok.Data;

/**
 * @author: cqry2017
 * @Date: 2021/06/08 16:07
 * @descript: 下单参数
 */
@Data
public class OrderPutParam {
    private String skuId;
    private Integer num;
}
