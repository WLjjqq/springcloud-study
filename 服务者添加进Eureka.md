先注册一个Eureka服务器
=================
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.lw</groupId>
        <artifactId>springcloud-study</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <artifactId>springcloud-study-euraka-7001</artifactId>

    <dependencies>
        <!--eureka-server 服务端-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
        <!--热部署 修改后立即生效-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>springloaded</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
        </dependency>

    </dependencies>

</project>
```
2:在启动类上加上注解@EnableEurekaServer
====================
```
@SpringBootApplication
@EnableEurekaServer
public class Euraka7001Application {

    public static void main(String[] args) {
        SpringApplication.run(Euraka7001Application.class, args);
    }

}
```
3.1：给服务者加上Eureka的客户端
================
```
<!--将微服务provider注册进eureka-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
```
3.2:修改服务者的yml文件
===============
```
#客户端注册进eureka服务列表
eureka:
  client:
    service-url:
      defaultZone: http://localhost:7001/eureka
```
