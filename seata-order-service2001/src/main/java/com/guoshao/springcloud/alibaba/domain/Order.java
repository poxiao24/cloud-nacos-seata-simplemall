package com.guoshao.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author guoshao
 * @create 2021-06-20 19:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    //数据库表为`id``user_id``product_id``count``money``status`
    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    private Integer status;//表示订单状态，0为创建中1为已创建完成
}
