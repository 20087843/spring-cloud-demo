package cn.pri.smilly.userservice.controller;

import cn.pri.smilly.userservice.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController("/user")
@RefreshScope
public class UserController {

    @Autowired
    private User user;

    @GetMapping("/current")
    @ResponseBody
    public Principal getPrincipal(Principal principal) {
        return principal;
    }

    @GetMapping("/info")
    @ResponseBody
    public User getUserInfo() {
        return user;
    }

}
