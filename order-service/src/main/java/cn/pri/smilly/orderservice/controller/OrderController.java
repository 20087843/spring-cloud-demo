package cn.pri.smilly.orderservice.controller;

import cn.pri.smilly.orderservice.bean.User;
import cn.pri.smilly.orderservice.client.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private EurekaDiscoveryClient discoveryClient;
    @Autowired
    private UserService userService;

    @GetMapping("/info")
    public String gerServiceInfo() {
        List<ServiceInstance> instances = discoveryClient.getInstances("order-service");
        StringBuilder info = new StringBuilder();
        instances.forEach(instance -> info.append(instance.getUri()).append(";"));
        return info.toString();
    }

    @GetMapping("/user")
    public User getUserInfo() {
        return userService.getUserInfo();
    }
}
