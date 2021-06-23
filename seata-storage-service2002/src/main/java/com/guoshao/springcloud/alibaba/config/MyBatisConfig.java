package com.guoshao.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author guoshao
 * @create 2021-06-20 21:43
 */
@Configuration
@MapperScan({"com.guoshao.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
