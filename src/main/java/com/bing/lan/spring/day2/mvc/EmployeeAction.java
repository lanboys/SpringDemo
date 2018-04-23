package com.bing.lan.spring.day2.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by 蓝兵 on 2018/4/20.
 */

@Controller
public class EmployeeAction {

    private IEmployeeService employeeService;

    @Autowired
    public void setEmployeeService(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public String save(String name, String phone) {
        /**
         * 模拟请求参数
         */
        Employee employee = new Employee();
        employee.setName(name);
        employee.setPhone(phone);
        return employeeService.save(employee);
    }
}
