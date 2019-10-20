package cn.pri.smilly.userservice.bean;

import cn.pri.smilly.commonservice.bean.BaseBean;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseBean {
    private String id;
    private String name;
    private String identity;
    private int age;
    private String sex;
}
