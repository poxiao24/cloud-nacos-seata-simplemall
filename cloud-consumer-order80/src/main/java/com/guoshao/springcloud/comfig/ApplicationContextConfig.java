package com.guoshao.springcloud.comfig;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author guoshao
 * @create 2021-06-04 10:18
 *
 * @LoadBalanced负载均衡
 * RestTemplate 是由 Spring 提供的一个 HTTP 请求工具。在上文的案例中，开发者也可以不使用 RestTemplate ，
 * 使用 Java 自带的 HttpUrlConnection 或者经典的网络访问框架 HttpClient 也可以完成上文的案例，只是在 Spring 项目中，
 * 使用 RestTemplate 显然更方便一些。在传统的项目架构中，因为不涉及到服务之间的调用，大家对 RestTemplate 的使用可能比较少，
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
