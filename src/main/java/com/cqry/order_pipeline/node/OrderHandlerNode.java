package com.cqry.order_pipeline.node;

import com.cqry.order_pipeline.context.OrderContext;
import com.cqry.order_pipeline.core.OrderHandler;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * @author: cqry2017
 * @Date: 2021/06/08 16:07
 * @descript:
 */
@Slf4j
@Data
@NoArgsConstructor
public class OrderHandlerNode {
    private OrderHandler handler;

    private OrderHandlerNode nextNode;

    public OrderHandlerNode(OrderHandler handler) {
        this.handler = handler;
    }

    public void execute(OrderContext context) {
//        StopWatch stopWatch = pipeLineStopWatchTTL.get();
        boolean success = false;
        boolean hasNext = Objects.nonNull(nextNode);
        // 不可用，执行下一个
        if(!handler.isEnable(context)) {
            if(hasNext) {
                nextNode.execute(context);
            } else {
//                System.out.println(stopWatch.prettyPrint());
//                pipeLineStopWatchTTL.remove();
            }
            // 可用，开始处理
        } else {
//            stopWatch.start(handler.getName());
            if(handler.isAsync()) {
                // 异步处理
            } else {
                success = handler.handle(context);
            }
//            stopWatch.stop();
            if(success && hasNext) {
                nextNode.execute(context);
            } else {
//                System.out.println(stopWatch.prettyPrint());
            }
        }
    }

}
