package cn.pri.smilly.orderservice.client;

import cn.pri.smilly.commonservice.bean.RestResult;
import cn.pri.smilly.commonservice.bean.po.UserPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "zuul-service", fallback = UserServiceFallback.class)
public interface UserService {

    @GetMapping("/user-service/user/info")
    RestResult getUserInfo();

    @PostMapping("/user-service/user/save")
    RestResult saveUser(UserPo user);

}
