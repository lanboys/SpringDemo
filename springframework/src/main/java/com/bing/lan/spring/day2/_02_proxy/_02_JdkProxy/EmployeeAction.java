package com.bing.lan.spring.day2._02_proxy._02_JdkProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
    //this.employeeService = employeeService;
    this.employeeService = (IEmployeeService) Proxy.newProxyInstance(employeeService.getClass().getClassLoader(),
        new Class[]{IEmployeeService.class}, new InvocationHandler() {

          @Override
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //proxy为动态生成的代理employeeService的对象
            System.out.println("invoke(): jdk动态代理 开启事务：" + System.currentTimeMillis());
            Object invoke = method.invoke(employeeService, args);
            System.out.println("invoke(): jdk动态代理 提交事务：" + System.currentTimeMillis());
            return invoke;
          }
        });
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
