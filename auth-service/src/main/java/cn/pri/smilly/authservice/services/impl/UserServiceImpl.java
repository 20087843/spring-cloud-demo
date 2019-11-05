package cn.pri.smilly.authservice.services.impl;

import cn.pri.smilly.authservice.services.UserService;
import cn.pri.smilly.commonservice.bean.RestResult;
import cn.pri.smilly.commonservice.constant.RestStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Override
    public RestResult findByUsername(String username) {
        log.info("调用 findByUsername 失败");
        return RestResult.fail(RestStatus.SVRERR, "调用findByUsername接口失败");
    }
}
