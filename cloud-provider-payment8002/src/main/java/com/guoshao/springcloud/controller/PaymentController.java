package com.guoshao.springcloud.controller;

import com.guoshao.springcloud.entities.CommonResult;
import com.guoshao.springcloud.entities.Payment;
import com.guoshao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author guoshao
 * @create 2021-06-03 22:00
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/insert")
    public CommonResult insertPayment(@RequestBody Payment payment){
        int result=paymentService.insertPayment(payment);
        log.info("******插入结果："+result);
        if (result>0){
            return new CommonResult(200,"插入数据成功,serverPort:"+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据失败",null);//插入失败了就不返回东西给前端了
        }
    }

    @GetMapping(value = "/payment/delete/{id}")
    public CommonResult deletePaymentById(@PathVariable("id") Long id){
        int result =paymentService.deletePaymentById(id);
        log.info("******删除结果："+result);
        if (result>0){
            return new CommonResult(200,"删除数据成功,serverPort:"+serverPort,result);
        }else {
            return new CommonResult(444,"删除数据失败",null);
        }
    }

    @PostMapping(value = "/payment/update")
    public CommonResult updatePaymentById(@RequestBody Payment payment){
        int result=paymentService.updatePaymentById(payment);
        log.info("******更新结果："+result);
        if (result>0){
            return new CommonResult(200,"更新数据成功,serverPort:"+serverPort,result);
        }else {
            return new CommonResult(444,"更新数据失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment= paymentService.getPaymentById(id);
        log.info("******查找结果："+payment);
        if (payment!=null){
            return new CommonResult(200,"查找数据成功,serverPort:"+serverPort,payment);
        }else {
            return new CommonResult(444,"查找数据失败，查询id:"+id,null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element:services){
            log.info("******element:"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance:instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
}
