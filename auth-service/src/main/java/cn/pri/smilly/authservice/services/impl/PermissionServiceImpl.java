package cn.pri.smilly.authservice.services.impl;

import cn.pri.smilly.authservice.services.PermissionService;
import cn.pri.smilly.commonservice.bean.RestResult;
import cn.pri.smilly.commonservice.constant.RestStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PermissionServiceImpl implements PermissionService {
    @Override
    public RestResult getRolePermission(Integer roleId) {
        log.info("调用 getRolePermission 失败");
        return RestResult.fail(RestStatus.SVRERR, "调用getRolePermission失败");
    }
}
