package cn.pri.smilly.authservice.mapper;

import cn.pri.smilly.commonservice.bean.po.RolePo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMapper {
    @Select("select * from sys_role right join sys_user_role on sys_role.id = sys_user_role.role_id where sys_user_role.user_id = #{userId}")
    List<RolePo> getRoleByUserId(Integer userId);
}
