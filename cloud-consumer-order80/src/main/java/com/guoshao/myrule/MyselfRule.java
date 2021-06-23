package com.guoshao.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义负载均衡路由规则类
 * @author guoshao
 * @create 2021-06-08 17:30
 */
@Configuration
public class MyselfRule {
    @Bean
    public IRule myRule(){
        //改变轮巡换成随机模式
        return new RandomRule();
    }
}
