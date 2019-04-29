package com.lw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient  //这个服务启动后添加进Eureka中。一般都是提供者服务
@EnableDiscoveryClient  //服务发现
@EnableCircuitBreaker  //对hystrix熔断机制的支持
public class DeptHystrix8001Application {

    public static void main(String[] args) {
        SpringApplication.run(DeptHystrix8001Application.class, args);
    }

}
