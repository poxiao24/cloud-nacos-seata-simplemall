package com.guoshao.springcloud.alibaba.service.impl;

import com.guoshao.springcloud.alibaba.dao.StorageDao;
import com.guoshao.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author guoshao
 * @create 2021-06-21 9:29
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("-----------开始扣减库存----------");
        if(storageDao.searchProductResidue(productId).compareTo(count)==-1){
            try {
                log.info("------库存不足--------");
                TimeUnit.SECONDS.sleep(20);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        storageDao.decrease(productId, count);
        log.info("-----------扣减库存结束----------");
    }
}
