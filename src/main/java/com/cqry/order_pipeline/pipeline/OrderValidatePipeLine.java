package com.cqry.order_pipeline.pipeline;

import com.cqry.order_pipeline.context.OrderContext;
import com.cqry.order_pipeline.core.OrderHandler;
import com.cqry.order_pipeline.core.OrderPipeLine;
import com.cqry.order_pipeline.node.OrderValidatorNode;


/**
 * @author: cqry2017
 * @Date: 2021/06/08 17:58
 * @descript:
 */
public class OrderValidatePipeLine implements OrderPipeLine {

    public OrderContext context;
    public OrderValidatorNode head;
    public OrderValidatorNode tail;

    public OrderValidatePipeLine(OrderContext context) {
        this.context = context;
        head = new OrderValidatorNode();
        tail = head;
    }

    @Override
    public void addFirst(OrderHandler... validators) {
        OrderValidatorNode validatorNode;
        for (OrderHandler validator : validators) {
            OrderValidatorNode preNode = head.getNextNode();
            validatorNode = new OrderValidatorNode(validator);
            validatorNode.setNextNode(preNode);
            head.setNextNode(validatorNode);
        }
    }

    @Override
    public void addLast(OrderHandler... handlers) {
        OrderValidatorNode tailNode = tail;
        OrderValidatorNode handlerNode;
        for (OrderHandler handler : handlers) {
            handlerNode = new OrderValidatorNode(handler);
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


//    @Override
//    public <T extends OrderContext> T getContext() {
//        return (T) context;
//    }
}
