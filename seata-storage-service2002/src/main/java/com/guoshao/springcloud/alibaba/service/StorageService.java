package com.guoshao.springcloud.alibaba.service;

/**
 * @author guoshao
 * @create 2021-06-21 9:27
 */
public interface StorageService {
    //扣减库存
    void decrease(Long productId,Integer count);
}
