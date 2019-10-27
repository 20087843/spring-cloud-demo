package cn.pri.smilly.orderservice.client;

import cn.pri.smilly.commonservice.bean.RestResult;
import cn.pri.smilly.commonservice.constant.RestStatus;
import cn.pri.smilly.orderservice.bean.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "gateway-service", fallback = UserService.UserServiceFallback.class)
public interface UserService {

    @GetMapping("/user-service/user/info")
    RestResult getUserInfo();

    @PostMapping("/user-service/user/save")
    RestResult saveUser(User user);

    @Slf4j
    class UserServiceFallback implements FallbackFactory<RestResult> {
        @Override
        public RestResult create(Throwable throwable) {
            log.error("user-service dead : " + throwable.getMessage());
            return RestResult.fail(RestStatus.SVRERR, "user-service dead : " + throwable.getMessage());
        }
    }

}
