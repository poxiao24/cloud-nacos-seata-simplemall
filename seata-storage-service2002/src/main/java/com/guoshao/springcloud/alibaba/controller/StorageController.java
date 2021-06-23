package com.guoshao.springcloud.alibaba.controller;

import com.guoshao.springcloud.alibaba.domain.CommonResult;
import com.guoshao.springcloud.alibaba.service.StorageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author guoshao
 * @create 2021-06-21 9:34
 */
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;
    //扣减库存
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId,Integer count){
        storageService.decrease(productId,count);
        return new CommonResult(200,"扣减库存完成");
    }
}
