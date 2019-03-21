package com.evyn.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ClassName EvynSpringCloudProducerApplication
 * @Description:
 * @Author xyw
 * @date 2019/1/25 17:22
 * @Version 1.0
 */
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class EvynSpringCloudZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(EvynSpringCloudZuulApplication.class, args);
    }
}
