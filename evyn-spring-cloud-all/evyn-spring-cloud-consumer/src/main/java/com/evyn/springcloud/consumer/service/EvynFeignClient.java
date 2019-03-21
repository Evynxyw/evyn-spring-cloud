package com.evyn.springcloud.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName EvynFeginClient
 * @Description:
 * @Author xyw
 * @Date 2019/3/2 19:25
 * @Version 1.0
 */
@FeignClient(name = "EVYN-PRODUCER", fallback = EvynFeignClientFallback.class)
public interface EvynFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/home")
    String home(@RequestParam("name") String name);

    @RequestMapping(method = RequestMethod.GET, value = "/timeOutHome")
    String timeOutHome();


}
