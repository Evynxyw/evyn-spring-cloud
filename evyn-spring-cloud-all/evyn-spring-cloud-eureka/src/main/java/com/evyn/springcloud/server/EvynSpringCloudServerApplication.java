package com.evyn.springcloud.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EvynSpringCloudServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvynSpringCloudServerApplication.class, args);
    }

}

