package com.evyn.springcloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName com.evyn.springcloud.consumer.EvynSpringCloudConsumerApplication
 * @Description:
 * @Author xyw
 * @date 2019/1/25 17:48
 * @Version 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EvynSpringCloudConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EvynSpringCloudConsumerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
