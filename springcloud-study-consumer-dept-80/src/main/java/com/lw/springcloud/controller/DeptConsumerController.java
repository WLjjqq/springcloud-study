package com.lw.springcloud.controller;

import com.lw.entities.DeptEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    private static final String REST_URL_PREFIX="http://localhost:8001";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/dept/findAll")
    public List findAll(){
        //三个参数：url,requestMap ResponseBean.class
        return  restTemplate.getForObject(
                REST_URL_PREFIX+"/dept/findAll",
                List.class);
    }

    @RequestMapping("/consumer/dept/findById/{deptNo}")
    public DeptEntity findById(@PathVariable("deptNo") Long deptNo){
        //三个参数：url,requestMap ResponseBean.class
        return  restTemplate.getForObject(
                REST_URL_PREFIX+"/dept/findById/"+deptNo,
                DeptEntity.class);
    }
    @RequestMapping(value = "/consumer/dept/add")
    public boolean add( @RequestBody DeptEntity deptEntity){
        //三个参数：url,requestMap ResponseBean.class
        return  restTemplate.postForObject(
                REST_URL_PREFIX+"/dept/add",
                deptEntity,
                Boolean.class);
    }
}
