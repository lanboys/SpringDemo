package com.bing.lan.spring.day1.mvc;

/**
 * Created by 蓝兵 on 2018/4/20.
 */

public class EmployeeAction {

    private IEmployeeService service = new EmployeeServiceImpl();

    public String save(String name, String phone) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setPhone(phone);
        return service.save(employee);
    }
}
