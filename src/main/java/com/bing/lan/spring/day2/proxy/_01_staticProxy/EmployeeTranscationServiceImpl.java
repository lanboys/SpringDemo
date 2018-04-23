package com.bing.lan.spring.day2.proxy._01_staticProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by 蓝兵 on 2018/4/20.
 */
@Service("employeeService")
public class EmployeeTranscationServiceImpl implements IEmployeeService {

    @Autowired
    @Qualifier("realEmployService")
    EmployeeServiceImpl target;

    @Override
    public String save(Employee e) {
        System.out.println("save(): 存储开始时间：" + System.currentTimeMillis());
        String save = target.save(e);
        System.out.println("save(): 存储结束时间：" + System.currentTimeMillis());
        return save;
    }
}
