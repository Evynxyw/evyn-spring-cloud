package com.evyn.springcloud.producer.util;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyHealthCheckHandler
 * @Description:
 * @Author xyw
 * @Date 2019/3/2 12:58
 * @Version 1.0
 */
@Component
public class MyHealthCheckHandler implements HealthCheckHandler {

    @Autowired
    private MyHealthIndicator healthIndicator;

    @Override
    public InstanceInfo.InstanceStatus getStatus(InstanceInfo.InstanceStatus instanceStatus) {
        Status status = healthIndicator.health().getStatus();
        if(status.equals(Status.UP)){
            return InstanceInfo.InstanceStatus.UP;
        }else{
            return InstanceInfo.InstanceStatus.DOWN;
        }
    }
}
