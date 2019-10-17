package cn.pri.smilly.orderservice.client;

import cn.pri.smilly.orderservice.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user-service", fallback = UserServiceFallback.class)
public interface UserService {

    @GetMapping("/user/info")
    public User getUserInfo();

}
