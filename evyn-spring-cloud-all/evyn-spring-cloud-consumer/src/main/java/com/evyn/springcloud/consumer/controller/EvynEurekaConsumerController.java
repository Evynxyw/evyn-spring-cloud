package com.evyn.springcloud.consumer.controller;

import com.evyn.springcloud.consumer.service.EvynConsumerService;
import com.evyn.springcloud.consumer.service.EvynFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @ClassName EvynEurekaConsumerController
 * @Description:
 * @Author xyw
 * @date 2019/1/25 17:53
 * @Version 1.0
 */
@RestController
@RequestMapping("/c")
public class EvynEurekaConsumerController {

    @Autowired
    private EvynConsumerService consumerService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private EvynFeignClient evynFeignClient;

    @RequestMapping("/c1")
    public String consumer1(@RequestParam String name) {
        return consumerService.HomeService(name);
    }

    @RequestMapping("/c3")
    public String consumer3(@RequestParam String name) {
        return evynFeignClient.home(name);
    }


    @RequestMapping("/timeout")
    public String consumer4() {
        String result = evynFeignClient.timeOutHome();

        return result;

    }

    @RequestMapping(value = "/c2", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceInstance consumer2(@RequestParam String name) {
        ServiceInstance serviceInstance = loadBalancerClient.choose("EVYN-PRODUCER");
        return serviceInstance;
    }

    @RequestMapping("/c4")
    public String consumer4(@RequestParam String name) {
        return consumerService.HomeService1(name);
    }

    @RequestMapping("/cache")
    public String cacheComsumer(@RequestParam String name) {
        for(int i = 0; i < 3; i++){
            consumerService.cacheService(name);
        }
        return consumerService.cacheService(name);
    }

    @RequestMapping("/testCache")
    public String testCache(@RequestParam String name) {
        consumerService.getCache(name);
        consumerService.getCache(name);

        consumerService.removeCache(name);
        System.out.println("**************clear cache*****************");
        consumerService.getCache(name);
        return consumerService.getCache(name);
    }

    /**
     * @Author xyw
     * @MethodName collReq
     * @Description: 合并请求
     * @Date 2019/3/3 14:35
     * @Param [name]
     * @return java.lang.String
     **/
    @RequestMapping("/coll")
    public String collReq(@RequestParam String name) throws ExecutionException, InterruptedException {
        Future<String> f1 = consumerService.getInfo("evyn1");
        Future<String> f2 = consumerService.getInfo("evyn2");
        Future<String> f3 = consumerService.getInfo("evyn3");
        String s1 = f1.get();
        String s2 = f2.get();
        String s3 = f3.get();
        return "";
    }

    @RequestMapping(value = "/list")
    public String serviceCount(){
        List<String> names = discoveryClient.getServices();
        List<ServiceInstance> instances = new ArrayList<>();
        for(String serviceName: names){
            List<ServiceInstance> instances1 = discoveryClient.getInstances(serviceName);
            instances.addAll(discoveryClient.getInstances(serviceName));
            System.out.println(serviceName + ":" + instances1.size());
        }

        return null;
    }

    @RequestMapping(value = "/meta")
    public String getMetaData(){
        List<String> names = discoveryClient.getServices();
        List<ServiceInstance> instances = new ArrayList<>();
        for(String serviceName: names){
            List<ServiceInstance> instances1 = discoveryClient.getInstances(serviceName);
            instances.addAll(discoveryClient.getInstances(serviceName));
            System.out.println(serviceName + ":" + instances1.size());
        }

        System.out.println("---------------------------------------");

        for(ServiceInstance serviceInstance : instances){
            String companyName = serviceInstance.getMetadata().get("company-name");
            System.out.println(serviceInstance.getServiceId() + ":"
                    + serviceInstance.getPort() + " 元数据：" + companyName);
        }
        return null;
    }





}
