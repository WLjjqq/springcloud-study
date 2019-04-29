package com.lw.service;

import com.lw.entities.DeptEntity;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 统一处理DeptClientService这个类中的熔断
 * @Component 把这个类添加进IOC容器中
 */

@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {


    @Override
    public DeptClientService create(Throwable throwable) {
           Logger logger = LoggerFactory.getLogger(DeptClientService.class);
        return new DeptClientService() {

            @Override
            public DeptEntity findById(Long deptNo) {
                logger.error("进入回退方法，异常",throwable);
               return new DeptEntity().setDeptNo(deptNo)
                        .setDeptName("该deptNo没有对应的信息，Consumer客户端提供的降级信息，此刻服务provider已经关闭")
                        .setDbSource("没有这个数据库");
            }

            @Override
            public List findAll() {
                return null;
            }
        };
    }
}