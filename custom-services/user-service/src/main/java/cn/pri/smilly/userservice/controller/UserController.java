package cn.pri.smilly.userservice.controller;

import cn.pri.smilly.commonservice.bean.RestResult;
import cn.pri.smilly.userservice.bean.User;
import cn.pri.smilly.userservice.config.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RefreshScope
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserProperties userPrp;

    @GetMapping("/current")
    public RestResult getPrincipal(Principal principal) {
        return RestResult.success(principal);
    }

    @GetMapping("/info")
    public RestResult getUserInfo() {
        User user = new User("N01", userPrp.getName(), userPrp.getIdentity(), userPrp.getAge(), userPrp.getSex());
        return RestResult.success(user);
    }

    @PostMapping("/save")
    public RestResult saveUser(@RequestBody User user) {
        return RestResult.success(user);
    }

}

