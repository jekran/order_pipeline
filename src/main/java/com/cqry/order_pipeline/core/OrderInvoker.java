package com.cqry.order_pipeline.core;

/**
 * @author: cqry2017
 * @Date: 2021/06/08 15:48
 * @descript:
 */
public interface OrderInvoker {

    void start();

    void shutDown();

//    <T extends OrderContext> T getContext();
}
