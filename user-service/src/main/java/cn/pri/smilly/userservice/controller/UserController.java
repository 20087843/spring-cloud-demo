package cn.pri.smilly.userservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController("/user")
@RefreshScope
public class UserController {

    @Value("user.name")
    private String name;

    @GetMapping("/current")
    public Principal getPrincipal(Principal principal) {
        return principal;
    }

    @GetMapping("/name")
    public String getUserName(){
        return name;
    }

}
