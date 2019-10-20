package cn.pri.smilly.orderservice.client;

import cn.pri.smilly.orderservice.bean.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserServiceFallback implements UserService {

    @Override
    public User getUserInfo() {
        log.error("getUserInfo call fail");
        return null;
    }
}
