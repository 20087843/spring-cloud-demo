package cn.pri.smilly.authservice.mapper;

import cn.pri.smilly.commonservice.bean.po.MenuPo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper {
    List<MenuPo> getRolePermission(Integer roleId);
}
