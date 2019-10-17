package cn.pri.smilly.userservice.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "user")
@RefreshScope
@Data
public class User {
    private String name;
    private int age;
    private String sex;
}
