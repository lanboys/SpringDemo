package com.bing.lan.spring.day2._01_annotation._03_annMvc;

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
    System.out.println("init(): 初始化");
  }

  @PreDestroy
  public void destroy() {
    System.out.println("destroy(): 销毁方法");
  }

  public String save(String name, String phone) {
    Employee employee = new Employee();
    employee.setName(name);
    employee.setPhone(phone);
    return employeeService.save(employee);
  }
}
