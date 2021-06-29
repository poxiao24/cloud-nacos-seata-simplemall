# cloud-nacos-seata-simplemall
## 友情提示
#####（暂未提供前端页面，暂时只有一个下订单功能，会继续不断完善）

> 1. **快速体验项目**：[在线访问地址](http://113.54.152.77:2001/order/create?userId=1&productId=1&count=10&money=10)
> 1. **nacos服务注册和配置中心**：[在线访问地址](http://113.54.152.77:9000/nacos)
> 3. **Spring Cloud各组件简单示例搭建**：[在线访问地址](https://github.com/poxiao24/springcloud-study.git)

## 项目介绍

`cloud-nacos-seata-simplemall`是一套简单的微服务分布式商城系统（包括订单order、账户account、库存storage三个微服务），采用了 Spring Cloud Hoxton & Alibaba、Spring Boot 2.3、
MyBatis等核心技术，在业务的基础上集成了nacos注册中心、配置中心等系统功能，考虑到业务发展需要，使用seata的分布式事务解决方案处理事务。具体为order微服务作为消费者提供下订单功能，对应调用storage微服务作为提供者执行扣减库存，调用account微服务作为提供者执行扣减余额，订单创建成功。若库存不足或余额不足，会执行事务回滚，订单创建失败。

## 数据库设计
![image](https://user-images.githubusercontent.com/49785231/123651904-6d776a00-d85e-11eb-9913-ffc5168d33b6.png)
![image](https://user-images.githubusercontent.com/49785231/123651933-72d4b480-d85e-11eb-8f6b-4867eaaa7eff.png)
![image](https://user-images.githubusercontent.com/49785231/123651956-77996880-d85e-11eb-8f1a-9b321553cd78.png)

## 程序模块设计
![image](https://user-images.githubusercontent.com/49785231/123652907-466d6800-d85f-11eb-8fe9-60d820142a6f.png)
![image](https://user-images.githubusercontent.com/49785231/123653032-63a23680-d85f-11eb-9464-345da1ea1b84.png)
![image](https://user-images.githubusercontent.com/49785231/123653075-6ef56200-d85f-11eb-8407-760cb3f170e3.png)


## 功能流程逻辑
![image](https://user-images.githubusercontent.com/49785231/123652293-c21ae500-d85e-11eb-8db4-abc4edb3b263.png)


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
| Nacos                  | 服务与注册中心组件     | https://github.com/alibaba/nacos                    |
| Feign                  | 服务接口调用组件     | https://github.com/OpenFeign/feign                    |

## 环境搭建

### 开发环境

| 工具          | 版本号 | 下载                                                         |
| ------------- | ------ | ------------------------------------------------------------ |
| JDK           | 1.8    | https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html |
| Mysql         | 5.7    | https://www.mysql.com/                                       |
| nginx         | 1.20   | http://nginx.org/en/download.html                            |
## Nacos集群搭建
![图片1](https://user-images.githubusercontent.com/49785231/123799082-6ca40e00-d91a-11eb-97ca-40d8a821d9ef.png)

## 运行效果展示

- 查看Nacos集群节点信息，访问地址：http://113.54.152.77:9000/nacos/
![image](https://user-images.githubusercontent.com/49785231/123790450-ec2cdf80-d910-11eb-9d10-eedb98b245b3.png)

- 查看配置中心配置信息，访问地址：http://113.54.152.77:9000/nacos/
![image](https://user-images.githubusercontent.com/49785231/123790503-fe0e8280-d910-11eb-9ca0-2f1b38dc4f49.png)

- 查看注册中心注册服务信息，访问地址：http://113.54.152.77:9000/nacos/
![image](https://user-images.githubusercontent.com/49785231/123790741-462da500-d911-11eb-9005-11ea24684ac1.png)
- 调用获取配置信息功能，访问地址：http://113.54.152.77:2001/config/info
![image](https://user-images.githubusercontent.com/49785231/123800492-ef799880-d91b-11eb-927f-c6369256e908.png)

![image](https://user-images.githubusercontent.com/49785231/123800230-a6c1df80-d91b-11eb-8b71-dd3417865954.png)



- 调用下订单功能，下订单完成，访问地址：http://113.54.152.77:2001/order/create?userId=1&productId=1&count=10&money=10
![image](https://user-images.githubusercontent.com/49785231/123791906-98bb9100-d912-11eb-918e-d6f8de2bc907.png)
- 调用下订单功能，余额不足，Feign调用扣减余额服务超时，事务回滚，下订单失败，访问地址：http://113.54.152.77:2001/order/create?userId=1&productId=1&count=10&money=1000
![image](https://user-images.githubusercontent.com/49785231/123792642-6f4f3500-d913-11eb-9e99-c3da531002fb.png)
![图片2](https://user-images.githubusercontent.com/49785231/123792094-d4565b00-d912-11eb-9c4f-7bda2ab6dfa6.png)
- 调用下订单功能，库存不足，Feign调用扣减库存服务超时，事务回滚，下订单失败，访问地址：http://113.54.152.77:2001/order/create?userId=1&productId=1&count=1000&money=10
![image](https://user-images.githubusercontent.com/49785231/123792542-5181d000-d913-11eb-9bcb-814ea3494240.png)
![图片3](https://user-images.githubusercontent.com/49785231/123792240-fd76eb80-d912-11eb-925c-d04d35cdb5dc.png)
