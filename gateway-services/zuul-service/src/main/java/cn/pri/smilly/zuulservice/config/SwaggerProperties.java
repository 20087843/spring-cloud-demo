package cn.pri.smilly.zuulservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import springfox.documentation.service.Contact;

@Getter
@Setter
@ConfigurationProperties(prefix = "swagger")
public class SwaggerProperties {
    private String basePackage;
    private String title;
    private String description;
    private String version;
    private String licence;
    private String licenceUrl;
    private Contact contact;
}
