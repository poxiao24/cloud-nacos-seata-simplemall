# cloud-nacos-seata-simplemall
## 友情提示
#####（暂未提供前端页面，暂时只有一个下订单功能，会继续不断完善）

> 1. **快速体验项目**：[在线访问地址](http://113.54.153.189:2001/order/create?userId=1&productId=1&count=10&money=10)
> 1. **nacos服务注册和配置中心**：[在线访问地址](http://113.54.153.189:9000/nacos)
> 3. **Spring Cloud各组件简单示例搭建**：[在线访问地址](https://github.com/poxiao24/springcloud-study.git)

## 项目介绍

`cloud-nacos-seata-simplemall`是一套简单的微服务分布式商城系统（包括订单order、账户account、库存storage三个微服务），采用了 Spring Cloud Hoxton & Alibaba、Spring Boot 2.3、
MyBatis等核心技术，在业务的基础上集成了注册中心、配置中心等系统功能，考虑到业务发展需要，使用seata的分布式事务解决方案处理事务。

## 系统架构图

![系统架构图](http://img.macrozheng.com/mall/project/mall_micro_service_arch.jpg)


## 项目文档

- 项目文档`mall`系列教程：[http://www.macrozheng.com](http://www.macrozheng.com)

## 项目演示

- 后台管理系统： [http://www.macrozheng.com/admin/index.html](http://www.macrozheng.com/admin/index.html)  
- 移动端商城系统：[http://www.macrozheng.com/app/index.html](http://www.macrozheng.com/app/index.html)

## 技术选型

### 后端技术

| 技术                   | 说明                 | 官网                                                 |
| ---------------------- | -------------------- | ---------------------------------------------------- |
| Spring Cloud           | 微服务框架           | https://spring.io/projects/spring-cloud              |
| Spring Cloud Alibaba   | 微服务框架           | https://github.com/alibaba/spring-cloud-alibaba      |
| Spring Boot            | 容器+MVC框架         | https://spring.io/projects/spring-boot               |
| MyBatis                | ORM框架              | http://www.mybatis.org/mybatis-3/zh/index.html       |
| Druid                  | 数据库连接池         | https://github.com/alibaba/druid                     |
| Lombok                 | 简化对象封装工具     | https://github.com/rzwitserloot/lombok               |
| Seata                  | 全局事务管理框架     | https://github.com/seata/seata                       |

## 环境搭建

### 开发环境

| 工具          | 版本号 | 下载                                                         |
| ------------- | ------ | ------------------------------------------------------------ |
| JDK           | 1.8    | https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html |
| Mysql         | 5.7    | https://www.mysql.com/                                       |
| nginx         | 1.20   | http://nginx.org/en/download.html                            |


## 运行效果展示

- 查看注册中心注册服务信息，访问地址：http://113.54.153.189:9000/nacos/

![](http://img.macrozheng.com/mall/project/mall_swarm_run_01.png)
