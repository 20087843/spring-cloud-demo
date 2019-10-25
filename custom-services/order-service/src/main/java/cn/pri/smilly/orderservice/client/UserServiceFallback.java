package cn.pri.smilly.orderservice.client;

import cn.pri.smilly.commonservice.bean.RestResult;
import cn.pri.smilly.commonservice.constant.RestStatus;
import cn.pri.smilly.orderservice.bean.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserServiceFallback implements UserService {

    @Override
    public RestResult getUserInfo() {
        log.error("getUserInfo call fail");
        return RestResult.fail(RestStatus.VRFFAIL, "fail");
    }

    @Override
    public RestResult saveUser(User user) {
        log.error("save User error");
        return RestResult.fail(RestStatus.VRFFAIL, "fail");
    }
}
