package com.cqry.order_pipeline.service;

import com.cqry.order_pipeline.context.OrderContext;
import com.cqry.order_pipeline.context.OrderPutParam;
import com.cqry.order_pipeline.handler.DeliveryFeeCalcHandler;
import com.cqry.order_pipeline.handler.NotifyUserHandler;
import com.cqry.order_pipeline.handler.OrderAmountCalcHandler;
import com.cqry.order_pipeline.pipeline.DefaultOrderPipeLine;
import com.cqry.order_pipeline.pipeline.OrderValidatePipeLine;
import com.cqry.order_pipeline.validator.DeliveryAddressValidator;
import com.cqry.order_pipeline.validator.ProductStatusValidator;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: cqry2017
 * @Date: 2021/03/23 08:41
 * @descript: 默认订单服务处理类
 */
@Service
@Slf4j
@Setter(onMethod_ = {@Autowired})
public class DefaultOrderProcessService extends AbstractBaseOrderCoreService {
    private DeliveryAddressValidator deliveryAddressValidator;
    private ProductStatusValidator productStatusValidator;
    private NotifyUserHandler notifyUserHandler;
    private DeliveryFeeCalcHandler deliveryFeeCalcHandler;
    private OrderAmountCalcHandler orderAmountCalcHandler;


    @Override
    public OrderContext createContext(OrderPutParam orderPutParam) {
        log.info("创建订单上下文");
        // 调用远程rpc查询商品信息或者其他信息组装上下文，涉及多个系统可并行查询提高效率
        OrderContext context = new OrderContext();
        // 订单金额计算，运费计算
        DefaultOrderPipeLine pipeLine = new DefaultOrderPipeLine(context);
        // 构建需要执行的管道对象
        pipeLine.addLast(deliveryFeeCalcHandler);
        pipeLine.addLast(orderAmountCalcHandler);
        // 责任链执行
        pipeLine.start();
        return context;
    }

    @Override
    public void buildValidator(OrderContext context) {
        // 创建管道
        OrderValidatePipeLine pipeLine = new OrderValidatePipeLine(context);
        // 构建需要执行的管道对象
        pipeLine.addLast(deliveryAddressValidator);
        pipeLine.addLast(productStatusValidator);
        // 责任链执行
        pipeLine.start();
    }

    @Override
    public void afterProcess(OrderContext context) {
        // 创建管道
        DefaultOrderPipeLine pipeLine = new DefaultOrderPipeLine(context);
        // 构建需要执行的管道对象
        pipeLine.addLast(notifyUserHandler);
        // 责任链执行
        pipeLine.start();
    }

}
