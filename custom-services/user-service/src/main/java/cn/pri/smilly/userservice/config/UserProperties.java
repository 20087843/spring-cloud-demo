package cn.pri.smilly.userservice.config;

import cn.pri.smilly.commonservice.bean.BaseBean;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
@ConfigurationProperties(prefix = "user")
@RefreshScope
@Getter
@Setter
public class UserProperties extends BaseBean {
    private String avatar;
    private String username;
    private String password;
    private String salt;
    private String name;
    private Date birthday;
    private Integer sex;
    private String email;
}
