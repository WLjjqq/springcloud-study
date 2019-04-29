package com.lw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderDept8003Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderDept8003Application.class, args);
    }

}
