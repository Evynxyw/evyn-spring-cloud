package com.evyn.springcloud.dashbord;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @ClassName EvynSpringCloudDashBordApplication
 * @Description:
 * @Author xyw
 * @Date 2019/3/3 16:40
 * @Version 1.0
 */
@SpringBootApplication
@EnableHystrixDashboard
public class EvynSpringCloudDashBordApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EvynSpringCloudDashBordApplication.class).properties(
                "server.port=9999").run(args);
    }
}
