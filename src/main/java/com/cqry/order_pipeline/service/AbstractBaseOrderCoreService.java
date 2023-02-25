package com.cqry.order_pipeline.service;

import com.cqry.order_pipeline.context.OrderContext;
import com.cqry.order_pipeline.context.OrderPutParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

/**
 * @author: cqry2017
 * @Date: 2021/03/22 23:02
 * @descript: 订单基础服务
 */
@Slf4j
public abstract class AbstractBaseOrderCoreService implements OrderCoreService {

//     @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    @Override
    public OrderContext createOrder(OrderPutParam orderPutParam) {
        StopWatch stopWatch = new StopWatch("createOrder");
        stopWatch.start("创建context");
        // 调用各种rpc接口， 创建投保上下文
        OrderContext context = createContext(orderPutParam);
        stopWatch.stop();
        stopWatch.start("开始校验");
        buildValidator(context);
        stopWatch.stop();
        stopWatch.start("创建订单");
        log.info("创建订单中...");
        stopWatch.stop();
        stopWatch.start("后置处理");
        afterProcess(context);
        stopWatch.stop();
        log.debug(stopWatch.prettyPrint());
        return context;
    }


    /**
     * 创建上下文
     *
     * @param orderPutParam
     * @return
     */
    public abstract OrderContext createContext(OrderPutParam orderPutParam);

    /**
     * 创建校验器
     *
     * @return orderContext
     */
    public abstract void buildValidator(OrderContext orderContext);

    /**
     * 后续处理
     *
     * @param orderContext
     */
    public abstract void afterProcess(OrderContext orderContext);

}
