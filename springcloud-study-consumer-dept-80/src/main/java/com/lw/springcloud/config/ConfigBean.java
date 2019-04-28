package com.lw.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 相当于Spring中的applicationContext.xml
 */
@Configuration
public class ConfigBean {
    /**
     * 配置RestTemplate
     * 通过RestTemplate调用提供者服务 ，发送rest请求
     * 提供了多种访问http服务的方法，
     * 针对于访问rest服务<strong>客户端</strong>的调用的模板类
     * @return
     */
    @Bean
    @LoadBalanced //ribbon实现的一套 ==客户端、负载均衡的工具
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /*//随机的去访问微服务中的实例（服务提供者）
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }*/
}
