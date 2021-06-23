package com.guoshao.springcloud.alibaba.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author guoshao
 * @create 2021-06-21 10:06
 */
public interface AccountService {
    //扣减额度
    void decrease(@RequestParam("userId")Long userId, @RequestParam("money")BigDecimal money);
}
