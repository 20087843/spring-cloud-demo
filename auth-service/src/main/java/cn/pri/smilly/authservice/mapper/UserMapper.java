package cn.pri.smilly.authservice.mapper;

import cn.pri.smilly.commonservice.bean.po.UserPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from sys_user where username = #{username}")
    UserPo findByUsername(String username);

}
