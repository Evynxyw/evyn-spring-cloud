package com.evyn.springcloud.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName EvynSpringCloudProducerApplication
 * @Description:
 * @Author xyw
 * @date 2019/1/25 17:22
 * @Version 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class EvynSpringCloudProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EvynSpringCloudProducerApplication.class, args);
    }
}
