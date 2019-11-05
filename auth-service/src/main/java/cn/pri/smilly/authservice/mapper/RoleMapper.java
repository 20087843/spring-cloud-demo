package cn.pri.smilly.authservice.mapper;

import cn.pri.smilly.commonservice.bean.po.RolePo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    List<RolePo> getRoleByUserId(Integer userId);
}
