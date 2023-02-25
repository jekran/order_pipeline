package com.cqry.order_pipeline.core;


import com.cqry.order_pipeline.context.OrderContext;

/**
 * @author: cqry2017
 * @Date: 2021/06/08 16:07
 * @descript:
 */
public interface OrderHandler<T extends OrderContext> {

    /**
     * 是否异步执行
     * @return
     */
    default boolean isAsync(){
        return false;
    }

    /**
     * 是否可用
     * @param context
     * @return
     */
    boolean isEnable(T context);

    /**
     * 处理
     * @param context
     * @return
     */
    default boolean handle(T context){
        return true;
    }

    /**
     * 处理器名
     * @return
     */
    String getName();

    /**
     * 校验
     * @param context
     */
    default void validate(T context){}

}
