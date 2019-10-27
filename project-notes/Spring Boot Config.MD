Spring Boot 配置文件读取 Maven 配置
===

1. 默认使用 @project.version@ 
由于${ }方式会被maven处理。如果 pom 继承了spring-boot-starter-parent，Spring Boot已经将maven-resources-plugins默认的 ${}方式改为了@@方式，如@变量名@。

2. idea 安装插件，使用 ${project.version}
    ```xml
    <plugin>
       <groupId>org.apache.maven.plugins</groupId>
       <artifactId>maven-resources-plugin</artifactId>
       <configuration>
           <encoding>UTF-8</encoding>
           <useDefaultDelimiters>true</useDefaultDelimiters>
       </configuration>
    </plugin>
    ```
