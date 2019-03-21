package com.evyn.springcloud.consumer.service.impl;

import com.evyn.springcloud.consumer.service.EvynConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @ClassName EvynConsumerServiceImpl
 * @Description:
 * @Author xyw
 * @date 2019/1/25 17:56
 * @Version 1.0
 */
@Service
//@DefaultProperties(defaultFallback = "dealErrorDefault") //默认会对方法，不要填写参数
public class EvynConsumerServiceImpl implements EvynConsumerService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String HomeService(String name) {
        return restTemplate.getForObject("http://EVYN-PRODUCER/home?name=" + name, String.class);
    }

    @Override
    @HystrixCommand(fallbackMethod = "dealError",commandKey = "evyn-command",
            groupKey = "evyn-group",
            commandProperties = {
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                        value = "2000")
            },
            threadPoolProperties = {
                @HystrixProperty(name = "coreSize", value = "2")
            })
    public String HomeService1(String name) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return restTemplate.getForObject("http://EVYN-PRODUCER/home?name=" + name,
                String.class);
    }

    @CacheResult
    @HystrixCommand()
    public String cacheService(String name) {
        System.out.println("**************调用cacheService缓存****************");
        return restTemplate.getForObject("http://EVYN-PRODUCER/home?name=" + name,
                String.class);
    }


    public String dealError(String name) throws InterruptedException {
        return name + ": Error.......";
    }

    public String dealErrorDefault() throws InterruptedException {
        return ": Error.......";
    }


    @Override
    @CacheResult
    @HystrixCommand(commandKey = "cachekey")
    public String getCache(String name) {
        System.out.println("*************执行方法***************");
        return "创建缓存";
    }

    @Override
    @CacheRemove(commandKey = "cachekey")
    @HystrixCommand(commandKey = "cachekey")
    public String removeCache(String name) {
        System.out.println("*************清除缓存***************");
        return "清除缓存";
    }

    @Override
    @HystrixCollapser(batchMethod = "getInfos",
        collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds", value = "1000")
        }
    )

    public Future<String> getInfo(String name) {
        System.out.println("执行单次请求方法");
        return null;
    }

    @Override
    @HystrixCommand
    public List<String> getInfos(List<String> names) {
        List<String> list = new ArrayList<String>();
        for(String name : names){
            list.add(name);
            System.out.println(name);
        }
        return list;
    }
}
