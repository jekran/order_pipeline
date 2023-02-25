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
public class DeliveryFeeCalcHandler implements OrderHandler<OrderContext> {

    @Override
    public boolean isEnable(OrderContext context) {
        return true;
    }

    @Override
    public String getName() {
        return "邮费计算器";
    }

    @Override
    public boolean handle(OrderContext context) {
        log.info("计算邮费");
        // todo 计算邮费
        return true;
    }
}
