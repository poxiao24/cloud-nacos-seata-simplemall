package com.guoshao.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author guoshao
 * @create 2021-06-20 17:56
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源的自动创建，使用seata对数据源进行代理
@EnableDiscoveryClient
@EnableFeignClients
public class SeataOrderMainApplication2001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMainApplication2001.class,args);
    }
}



