package cn.pri.smilly.orderservice.controller;

import cn.pri.smilly.commonservice.bean.RestResult;
import cn.pri.smilly.commonservice.bean.dto.UserDto;
import cn.pri.smilly.commonservice.bean.po.UserPo;
import cn.pri.smilly.orderservice.client.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.*;

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
    public RestResult gerServiceInfo() {
        List<ServiceInstance> instances = discoveryClient.getInstances("order-service");
        StringBuilder info = new StringBuilder();
        instances.forEach(instance -> info.append(instance.getUri()).append(";"));
        return RestResult.success(info.toString());
    }

    @GetMapping("/user")
    public RestResult getUserInfo() {
        return userService.getUserInfo();
    }

    @PostMapping("/user")
    public RestResult saveUser(@RequestBody UserDto user) {
        return userService.saveUser(user.convert(UserPo.class));
    }
}
