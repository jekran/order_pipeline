package com.cqry.order_pipeline.pipeline;

import com.cqry.order_pipeline.context.OrderContext;
import com.cqry.order_pipeline.core.OrderHandler;
import com.cqry.order_pipeline.core.OrderPipeLine;
import com.cqry.order_pipeline.node.OrderHandlerNode;


/**
 * @author: cqry2017
 * @Date: 2021/06/08 17:58
 * @descript:
 */
public class DefaultOrderPipeLine implements OrderPipeLine {
//    public static TransmittableThreadLocal<StopWatch> pipeLineStopWatchTTL = new TransmittableThreadLocal<>();

    public OrderContext context;
    public OrderHandlerNode head;
    public OrderHandlerNode tail;

    public DefaultOrderPipeLine(OrderContext context) {
        this.context = context;
        head = new OrderHandlerNode();
        tail = head;
//        pipeLineStopWatchTTL.set(new StopWatch("DefaultOrderPipeLine"));
    }

    @Override
    public void addFirst(OrderHandler... handlers) {
        OrderHandlerNode handlerNode;
        for (OrderHandler handler : handlers) {
            OrderHandlerNode preNode = head.getNextNode();
            handlerNode = new OrderHandlerNode(handler);
            handlerNode.setNextNode(preNode);
            head.setNextNode(handlerNode);
        }
    }

    @Override
    public void addLast(OrderHandler... handlers) {
        OrderHandlerNode tailNode = tail;
        OrderHandlerNode handlerNode;
        for (OrderHandler handler : handlers) {
            handlerNode = new OrderHandlerNode(handler);
            tailNode.setNextNode(handlerNode);
            tailNode = handlerNode;
        }
        tail = tailNode;
    }

    @Override
    public void start() {
        head.getNextNode().execute(context);
    }

    @Override
    public void shutDown() {
    }

}
