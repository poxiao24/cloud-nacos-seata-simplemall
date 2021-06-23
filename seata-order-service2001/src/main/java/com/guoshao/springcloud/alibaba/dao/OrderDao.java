package com.guoshao.springcloud.alibaba.dao;

import com.guoshao.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author guoshao
 * @create 2021-06-20 19:57
 */
@Mapper
public interface OrderDao {
    //新建订单
    void create(Order order);
    //修改订单状态，若从0到1表示订单创建完毕
    void updateSta(@Param("userId") Long userId, @Param("status") Integer status);
}
