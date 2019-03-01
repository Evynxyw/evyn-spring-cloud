package com.evyn.springcloud.producer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName EvynEurekaClientController
 * @Description:
 * @Author xyw
 * @date 2019/1/25 17:28
 * @Version 1.0
 */
@RestController
public class EvynEurekaClientController {

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/home", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String home(@RequestParam String name)
    {
        return "Hi " + name + ",i am from port:" + port;
    }

}
