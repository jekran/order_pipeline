package com.cqry.order_pipeline.handler;

import com.cqry.order_pipeline.context.OrderContext;
import com.cqry.order_pipeline.core.OrderHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: cqry2017
 * @Date: 2021/03/26 14:07
 */
@Slf4j
@Component
public class OrderAmountCalcHandler implements OrderHandler<OrderContext> {

    @Override
    public boolean isEnable(OrderContext context) {
        return true;
    }

    @Override
    public String getName() {
        return "订单商品金额计算器";
    }

    @Override
    public boolean handle(OrderContext context) {
        log.info("计算订单金额");
        // todo 计算订单金额
        return true;
    }
}
