package com.guoshao.springcloud.alibaba.service.impl;

import com.guoshao.springcloud.alibaba.dao.OrderDao;
import com.guoshao.springcloud.alibaba.domain.Order;
import com.guoshao.springcloud.alibaba.service.AccountService;
import com.guoshao.springcloud.alibaba.service.OrderService;
import com.guoshao.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author guoshao
 * @create 2021-06-20 20:32
 * 创建订单---》调用库存服务，减少库存----》调用账户服务，减少账户余额----》修改订单状态
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;
    @Override
    @GlobalTransactional(name = "guoshao-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("-----开始创建订单---------");
        //创建订单
        orderDao.create(order);

        //调用库存服务，减少库存
        log.info("-----订单微服务开始调用库存服务，减少库存Count-------");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("-----订单微服务调用库存结束--------");


        //调用账户服务，减少账户余额
        log.info("-----订单微服务调用账户服务，减少额度Money--------");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("-----订单微服务调用账户结束------");

        //修改订单状态
        log.info("-----修改订单状态开始-------");
        orderDao.updateSta(order.getUserId(), 0);
        log.info("-----修改订单状态结束-------");

        log.info("-----创建订单结束-------");
    }
}
