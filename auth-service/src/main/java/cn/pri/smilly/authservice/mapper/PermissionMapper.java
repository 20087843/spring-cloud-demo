package cn.pri.smilly.authservice.mapper;

import cn.pri.smilly.commonservice.bean.po.MenuPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PermissionMapper {

    @Select("select * from from sys_menu right join sys_privilege on sys_menu.id = sys_privilege.munu_id where sys_privilege.role_id = #{roleId}")
    List<MenuPo> getRolePermission(Integer roleId);

}
