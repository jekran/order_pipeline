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
public class NotifyUserHandler implements OrderHandler<OrderContext> {

    @Override
    public boolean isEnable(OrderContext context) {
        return true;
    }

    @Override
    public String getName() {
        return "用户通知处理器";
    }

    @Override
    public boolean handle(OrderContext context) {
        log.info("发短信通知用户成功下单");
        // todo 通知用户已经成功下单
        return true;
    }
}
