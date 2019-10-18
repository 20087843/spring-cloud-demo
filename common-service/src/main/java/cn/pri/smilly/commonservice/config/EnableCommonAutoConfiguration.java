package cn.pri.smilly.commonservice.config;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface EnableCommonAutoConfiguration {
}
