package com.lw.springcloud;

import com.lw.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
/**
 * 在启动该微服务式是能去加载我们定义的Ribbon配置类
 * 自定义配置类不能放在@ComponentScan所扫描的当前包以及子包下，
 * 否则我们自定义的这个配置类就会被所有的Ribbon客户端锁共享，达不到特殊定制化的目的
 * @SpringBootApplication 包含了@ComponentScan
 */
@RibbonClient(name="STUDY-SPRINGCLOUD-DEPT",configuration = MySelfRule.class)
public class ConsumerDept80Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDept80Application.class, args);
    }

}
