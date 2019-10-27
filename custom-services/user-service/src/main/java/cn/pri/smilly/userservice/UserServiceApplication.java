package cn.pri.smilly.userservice;

import cn.pri.smilly.commonservice.config.EnableCommonAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringCloudApplication
@EnableCommonAutoConfiguration
@EnableHystrix
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
