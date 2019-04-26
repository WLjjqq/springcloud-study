package com.lw.springcloud.service.Impl;

import com.lw.entities.DeptEntity;
import com.lw.springcloud.dao.DeptDao;
import com.lw.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GongXings
 * @createTime 30 15:04
 * @description
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptDao deptDao;
    @Override
    public boolean addDept(DeptEntity deptEntity) {
      return   deptDao.addDept(deptEntity);
    }

    @Override
    public DeptEntity findById(Long deptNo) {
        return  deptDao.findById(deptNo);
    }

    @Override
    public List<DeptEntity> findAll() {
        return deptDao.findAll();
    }
}