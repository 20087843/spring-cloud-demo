package cn.pri.smilly.authservice.services.impl;

import cn.pri.smilly.authservice.services.RoleService;
import cn.pri.smilly.commonservice.bean.RestResult;
import cn.pri.smilly.commonservice.constant.RestStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    @Override
    public RestResult getRoleByUserId(Integer userId) {
        log.info("调用 getRoleByUserId 失败");
        return RestResult.fail(RestStatus.SVRERR, "调用getRoleByUserId失败");
    }
}
