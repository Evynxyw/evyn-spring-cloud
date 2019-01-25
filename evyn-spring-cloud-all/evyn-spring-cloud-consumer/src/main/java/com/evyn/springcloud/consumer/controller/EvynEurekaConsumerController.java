package com.evyn.springcloud.consumer.controller;

import com.evyn.springcloud.consumer.service.EvynConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName EvynEurekaConsumerController
 * @Description:
 * @Author xyw
 * @date 2019/1/25 17:53
 * @Version 1.0
 */
@RestController
public class EvynEurekaConsumerController {

    @Autowired
    private EvynConsumerService consumerService;

    @RequestMapping("/c1")
    public String consumer1(@RequestParam String name)
    {
        return consumerService.HomeService(name);
    }

}
