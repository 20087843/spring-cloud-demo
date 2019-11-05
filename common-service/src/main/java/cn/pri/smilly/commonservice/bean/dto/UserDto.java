package cn.pri.smilly.commonservice.bean.dto;

import cn.pri.smilly.commonservice.bean.BaseBean;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class UserDto extends BaseBean {
    private String avatar;
    private String username;
    private String password;
    private String salt;
    private String name;
    private Date birthday;
    private Integer sex;
    private String email;
    private String phone;
    private Integer status;
}
