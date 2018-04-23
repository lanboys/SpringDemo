package com.bing.lan.spring.day2.proxy._01_staticProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 蓝兵 on 2018/4/20.
 */
@Service("realEmployService")
public class EmployeeServiceImpl implements IEmployeeService {

    private IEmployeeDAO employeeDAO;

    @Autowired
    public void setEmployeeDAO(IEmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
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
