package com.guoshao.springcloud.alibaba.service.impl;

import com.guoshao.springcloud.alibaba.dao.AccountDao;
import com.guoshao.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author guoshao
 * @create 2021-06-21 10:08
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("-----开始扣减额度-------");
        if (accountDao.searchAccountResidue(userId).compareTo(money)==-1) {
            try {
                log.info("------额度不足--------");
                TimeUnit.SECONDS.sleep(20);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        accountDao.decrease(userId, money);
        log.info("-----扣减额度完成-------");
    }
}
