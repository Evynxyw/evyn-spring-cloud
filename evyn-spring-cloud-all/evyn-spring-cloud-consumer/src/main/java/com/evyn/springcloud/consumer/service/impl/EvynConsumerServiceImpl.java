package com.evyn.springcloud.consumer.service.impl;

import com.evyn.springcloud.consumer.service.EvynConsumerService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName EvynConsumerServiceImpl
 * @Description:
 * @Author xyw
 * @date 2019/1/25 17:56
 * @Version 1.0
 */
@Service
public class EvynConsumerServiceImpl implements EvynConsumerService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String HomeService(String name) {
        return restTemplate.getForObject("http://EVYN-SERVER/home?name=" + name, String.class);
    }
}
