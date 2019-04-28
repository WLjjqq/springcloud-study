package com.lw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //服务启动后会自动注册进eureka服务
public class ProviderDept8001Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderDept8001Application.class, args);
    }

}
