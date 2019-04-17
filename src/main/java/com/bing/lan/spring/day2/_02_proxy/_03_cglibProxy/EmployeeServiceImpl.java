package com.bing.lan.spring.day2._02_proxy._03_cglibProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 蓝兵 on 2018/4/20.
 */
@Service
public class EmployeeServiceImpl extends IEmployeeService {

    private IEmployeeDAO employeeDAO;

    @Autowired
    public void setEmployeeDAO(IEmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public String save(Employee e) {
        System.out.println("save(): 查询数据库 客户不纯在，新建用户");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        return employeeDAO.save(e);
    }
}
