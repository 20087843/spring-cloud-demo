package cn.pri.smilly.userservice.controller;

import cn.pri.smilly.userservice.bean.User;
import cn.pri.smilly.userservice.config.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RefreshScope
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserProperties user;

    @GetMapping("/current")
    public Principal getPrincipal(Principal principal) {
        return principal;
    }

    @GetMapping("/info")
    public User getUserInfo() {
        return new User("N01", user.getName(), user.getAge(), user.getSex());
    }

}

