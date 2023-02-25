package com.cqry.order_pipeline.service;


import com.cqry.order_pipeline.context.OrderContext;
import com.cqry.order_pipeline.context.OrderPutParam;

/**
 * @author: cqry2017
 * @Date: 2021/03/22 23:30
 * @descript: 投保处理接口
 */
public interface OrderCoreService {

    /**
     * 创建订单
     * @param orderPutParam
     * @return
     */
    OrderContext createOrder(OrderPutParam orderPutParam);

}
