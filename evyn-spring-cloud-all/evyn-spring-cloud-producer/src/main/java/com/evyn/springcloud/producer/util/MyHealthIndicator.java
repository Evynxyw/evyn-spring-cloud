package com.evyn.springcloud.producer.util;

import com.evyn.springcloud.producer.controller.EvynEurekaClientController;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyHealthIndicator
 * @Description: 自定义健康解析器
 * @Author xyw
 * @Date 2019/3/2 12:40
 * @Version 1.0
 */
@Component
public class MyHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        if(EvynEurekaClientController.flag){
            return new Health.Builder(Status.UP).build();
        }else{
            return new Health.Builder(Status.DOWN).build();
        }
    }
}
