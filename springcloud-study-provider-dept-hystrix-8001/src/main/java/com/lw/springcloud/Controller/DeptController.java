package com.lw.springcloud.Controller;

import com.lw.entities.DeptEntity;
import com.lw.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    //Eureka服务发现接口
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/dept/add")
    public boolean addDept(@RequestBody DeptEntity deptEntity) {
        return   deptService.addDept(deptEntity);
    }

    /**
     * @HystrixCommand  该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法
     * @param deptNo
     * @return
     */
    //@HystrixCommand(fallbackMethod = "processHystrix_Get")
    @GetMapping(value = "/dept/findById/{deptNo}")
    public DeptEntity findById(@PathVariable("deptNo") Long deptNo) {
        DeptEntity dept = deptService.findById(deptNo);
        if (StringUtils.isEmpty(dept)) {
            throw new RuntimeException("该Id"+deptNo+"用户没有对应的信息");
        }
        return dept;
    }

    public DeptEntity processHystrix_Get(@PathVariable("deptNo") Long deptNo){
        return new DeptEntity().setDeptNo(deptNo).setDeptName("该Id"+deptNo+"没有对应的信息").setDbSource("没有数据库");
    }
    @GetMapping(value = "/dept/findAll")
    public List<DeptEntity> findAll() {
        return deptService.findAll();
    }

    /**
     * 增加自己服务描述的接口
     * @return
     */
    @GetMapping(value = "/dept/discovery")
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        System.out.println("总共有多少个微服务"+list.size());

        //查询STUDY-SPRINGCLOUD-DEPT 服务
        List<ServiceInstance> instances = discoveryClient.getInstances("STUDY-SPRINGCLOUD-DEPT");

        //打印STUDY-SPRINGCLOUD-DEPT服务信息
        for (ServiceInstance element :instances){
            System.out.println(element.getServiceId());
            System.out.println(element.getHost());
            System.out.println(element.getPort());
            System.out.println(element.getUri());
        }
        return this.discoveryClient;
    }

}