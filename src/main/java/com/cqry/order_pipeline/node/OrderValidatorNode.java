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
public class OrderValidatorNode {

    private OrderHandler validator;

    private OrderValidatorNode nextNode;

    public OrderValidatorNode(OrderHandler validator) {
        this.validator = validator;
    }

    public void execute(OrderContext context) {
        boolean hasNext = Objects.nonNull(nextNode);
        // 不可用，执行下一个
        if (!validator.isEnable(context)) {
            if (hasNext) {
                nextNode.execute(context);
            }
        } else {
            validator.validate(context);
            if (hasNext) {
                nextNode.execute(context);
            }
        }
    }

}
