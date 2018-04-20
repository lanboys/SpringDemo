package com.bing.lan.spring.day1.mvc;

/**
 * Created by 蓝兵 on 2018/4/20.
 */

public class EmployeeAction {

    private IEmployeeService employeeService;

    public void setEmployeeService(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public String save(String name, String phone) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setPhone(phone);
        return employeeService.save(employee);
    }
}
