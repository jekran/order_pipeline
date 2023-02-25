package com.cqry.order_pipeline.core;

/**
 * @author: cqry2017
 * @Date: 2021/06/08 17:46
 * @descript:
 */
public interface OrderPipeLine extends OrderInvoker {

    void addFirst(OrderHandler... handler);

    void addLast(OrderHandler... handler);
}
