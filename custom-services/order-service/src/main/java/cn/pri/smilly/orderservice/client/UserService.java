package cn.pri.smilly.orderservice.client;

import cn.pri.smilly.commonservice.bean.RestResult;
import cn.pri.smilly.orderservice.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "gateway-service", fallback = UserServiceFallback.class)
public interface UserService {

    @GetMapping("/user-service/user/info")
    public RestResult getUserInfo();

    @PostMapping("/user-service/user/save")
    public RestResult saveUser(User user);

}
