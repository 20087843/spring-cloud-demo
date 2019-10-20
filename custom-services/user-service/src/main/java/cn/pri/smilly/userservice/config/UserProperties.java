package cn.pri.smilly.userservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "user")
@RefreshScope
@Getter
@Setter
public class UserProperties {
    private String name;
    private String identity;
    private int age;
    private String sex;
}
