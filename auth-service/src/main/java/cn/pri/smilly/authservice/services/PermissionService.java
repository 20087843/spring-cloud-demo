package cn.pri.smilly.authservice.services;

import cn.pri.smilly.commonservice.bean.RestResult;

public interface PermissionService {
    RestResult getRolePermission(Integer roleId);
}
