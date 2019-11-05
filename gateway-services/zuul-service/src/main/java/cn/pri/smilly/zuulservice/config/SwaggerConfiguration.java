package cn.pri.smilly.zuulservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerConfiguration {
    @Autowired
    private SwaggerProperties properties;

    @Bean
    public Docket CreateRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(properties.getTitle())
                .description(properties.getDescription())
                .version(properties.getVersion())
                .license(properties.getLicence())
                .licenseUrl(properties.getLicenceUrl())
                .contact(properties.getContact())
                .build();
    }
}
