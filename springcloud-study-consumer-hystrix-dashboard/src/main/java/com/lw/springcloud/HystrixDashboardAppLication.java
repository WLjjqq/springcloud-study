package com.lw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard   //Hystrix的监控
public class HystrixDashboardAppLication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardAppLication.class, args);
    }

}
