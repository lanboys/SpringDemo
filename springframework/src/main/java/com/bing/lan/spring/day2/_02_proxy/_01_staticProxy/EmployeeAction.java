package com.bing.lan.spring.day2._02_proxy._01_staticProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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

  @PostConstruct
  public void init() {
    System.out.println("init(): EmployeeAction 初始化");
  }

  @PreDestroy
  public void destroy() {
    System.out.println("destroy(): EmployeeAction 销毁方法");
  }

  public String save(String name, String phone) {
    Employee employee = new Employee();
    employee.setName(name);
    employee.setPhone(phone);
    return employeeService.save(employee);
  }
}
