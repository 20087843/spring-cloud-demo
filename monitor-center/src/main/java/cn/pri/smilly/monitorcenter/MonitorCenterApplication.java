package cn.pri.smilly.monitorcenter;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
@EnableHystrixDashboard
public class MonitorCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitorCenterApplication.class, args);
    }

}
