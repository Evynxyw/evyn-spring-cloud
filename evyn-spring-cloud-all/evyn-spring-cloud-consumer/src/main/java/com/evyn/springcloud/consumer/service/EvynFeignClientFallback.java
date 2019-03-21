package com.evyn.springcloud.consumer.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName EvynFeignClientFallback
 * @Description:
 * @Author xyw
 * @Date 2019/3/3 15:23
 * @Version 1.0
 */
@Component
public class EvynFeignClientFallback implements EvynFeignClient{
    @Override
    public String home(String name) {
        return "Fallback home: error......";
    }

    @Override
    public String timeOutHome() {
        return "Fallback timeOut: error......";
    }
}
