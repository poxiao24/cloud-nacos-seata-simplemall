package com.guoshao.springcloud.alibaba.controller;

import com.guoshao.springcloud.alibaba.domain.CommonResult;
import com.guoshao.springcloud.alibaba.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author guoshao
 * @create 2021-06-21 10:24
 */
@RestController
public class AccountController {
    @Resource
    private AccountService accountService;
    //扣减账户额度
    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId")Long userId, @RequestParam("money")BigDecimal money){
        accountService.decrease(userId, money);
        return new CommonResult(200,"扣减账户额度完成");
    }
}
