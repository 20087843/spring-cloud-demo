package cn.pri.smilly.userservice.controller;

import cn.pri.smilly.commonservice.bean.RestResult;
import cn.pri.smilly.commonservice.bean.dto.UserDto;
import cn.pri.smilly.commonservice.bean.vo.UserVo;
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
        UserVo user = userPrp.convert(UserVo.class);
        return RestResult.success(user);
    }

    @PostMapping("/save")
    public RestResult saveUser(@RequestBody UserDto user) {
        return RestResult.success(user);
    }

}

