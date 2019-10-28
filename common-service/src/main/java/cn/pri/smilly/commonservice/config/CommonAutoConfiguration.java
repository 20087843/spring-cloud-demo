package cn.pri.smilly.commonservice.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnBean(EnableCommonAutoConfiguration.class)
public class CommonAutoConfiguration {

}
