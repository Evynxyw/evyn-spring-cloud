package com.evyn.springcloud.consumer.service;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @ClassName EvynConsumerService
 * @Description:
 * @Author xyw
 * @date 2019/1/25 17:56
 * @Version 1.0
 */
public interface EvynConsumerService {
    public String HomeService(String name);

    public String HomeService1(String name);

    public String cacheService(String name);

    public String getCache(String name);

    public String removeCache(String name);

    public Future<String> getInfo(String name);

    public List<String> getInfos(List<String> names);
}
