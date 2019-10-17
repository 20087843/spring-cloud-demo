package cn.pri.smilly.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RefreshScope
@RequestMapping("/order")
public class OrderController {

    @Autowired
    EurekaDiscoveryClient discoveryClient;

    @GetMapping("/info")
    public String gerServiceInfo() {
        List<ServiceInstance> instances = discoveryClient.getInstances("order-service");
        StringBuilder info = new StringBuilder();
        instances.forEach(instance -> info.append(instance.getUri()).append(";"));
        return info.toString();
    }
}
