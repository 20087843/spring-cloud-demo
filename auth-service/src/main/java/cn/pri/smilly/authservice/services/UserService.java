package cn.pri.smilly.authservice.services;

import cn.pri.smilly.commonservice.bean.RestResult;

public interface UserService {
    RestResult findByUsername(String username);
}
