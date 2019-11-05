package cn.pri.smilly.authservice.mapper;

import cn.pri.smilly.commonservice.bean.po.UserPo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    UserPo findByUsername(String username);
}
