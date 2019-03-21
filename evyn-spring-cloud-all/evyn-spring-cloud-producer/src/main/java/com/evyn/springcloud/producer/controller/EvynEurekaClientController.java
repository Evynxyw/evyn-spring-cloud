package com.evyn.springcloud.producer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    public static boolean flag = true;

    @RequestMapping(value = "/home", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String home(@RequestParam String name) {
        return "Hi " + name + ",i am from port:" + port;
    }

    @RequestMapping(value = "/timeOutHome", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String timeOutService() throws InterruptedException {
        Thread.sleep(1000);
        return "------请求超时";
    }

    @RequestMapping(value = "/hel/{can}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void helFlag(@PathVariable boolean can) {
        flag = can;
    }


}
