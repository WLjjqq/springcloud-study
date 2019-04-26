package com.lw.springcloud.Controller;

import com.lw.entities.DeptEntity;
import com.lw.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GongXings
 * @createTime 30 15:07
 * @description
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    /*@Autowired
    private DiscoveryClient discoveryClient;*/

    @PostMapping(value = "/dept/add")
    public boolean addDept(@RequestBody DeptEntity deptEntity) {
        return   deptService.addDept(deptEntity);
    }
    @GetMapping(value = "/dept/findById/{deptNo}")
    public DeptEntity findById(@PathVariable("deptNo") Long deptNo) {
        return  deptService.findById(deptNo);
    }

    @GetMapping(value = "/dept/findAll")
    public List<DeptEntity> findAll() {
        return deptService.findAll();
    }



}