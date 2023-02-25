package com.cqry.order_pipeline;

import com.cqry.order_pipeline.context.OrderPutParam;
import com.cqry.order_pipeline.service.OrderCoreService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;

public class OrderPutTest extends OrderPipelineApplicationTests{

    @Resource
    private OrderCoreService coreService;

    @Test
    void putOrder() {
        OrderPutParam orderPutParam = new OrderPutParam();
        orderPutParam.setNum(1);
        orderPutParam.setSkuId("6666");
        coreService.createOrder(orderPutParam);
    }
}
