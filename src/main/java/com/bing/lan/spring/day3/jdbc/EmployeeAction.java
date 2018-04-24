package com.bing.lan.spring.day3.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

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

    //@PostConstruct
    public void init() {
        System.out.println("init(): EmployeeAction 初始化");
    }

    //@PreDestroy
    public void destroy() {
        System.out.println("destroy(): EmployeeAction 销毁方法");
    }

    public void save(String name, String phone) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setPhone(phone);
        employeeService.save(employee);
    }

    public void delete(Long id) {
        employeeService.delete(id);
    }

    public void update(Employee e) {
        employeeService.update(e);
    }

    public Employee get(Long id) {
        return employeeService.get(id);
    }

    public List<Employee> list() {
        return employeeService.list();
    }
}
