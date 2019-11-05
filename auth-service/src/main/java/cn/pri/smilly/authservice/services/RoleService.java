package cn.pri.smilly.authservice.services;

import cn.pri.smilly.commonservice.bean.RestResult;

public interface RoleService {
    RestResult getRoleByUserId(Integer userId);
}
