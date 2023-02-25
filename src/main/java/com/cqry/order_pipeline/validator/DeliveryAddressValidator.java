package com.cqry.order_pipeline.validator;

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
public class DeliveryAddressValidator implements OrderHandler<OrderContext> {

    @Override
    public boolean isEnable(OrderContext context) {
        return true;
    }

    @Override
    public String getName() {
        return "配送地址校验";
    }

    @Override
    public void validate(OrderContext context) {
        log.info("校验配送地址...");
        // todo 校验配送地址是否超出范围
    }
}
