package cn.pri.smilly.orderservice.client;

import cn.pri.smilly.commonservice.bean.RestResult;
import cn.pri.smilly.commonservice.constant.RestStatus;
import cn.pri.smilly.orderservice.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserServiceFallback implements UserService {

    @Override
    public RestResult getUserInfo() {
        return RestResult.fail(RestStatus.SVRERR, "user service fail");
    }

    @Override
    public RestResult saveUser(User user) {
        return RestResult.fail(RestStatus.SVRERR, "user service fail");
    }
}
