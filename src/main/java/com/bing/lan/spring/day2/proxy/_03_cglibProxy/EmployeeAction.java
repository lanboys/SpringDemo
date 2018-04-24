package com.bing.lan.spring.day2.proxy._03_cglibProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.stereotype.Controller;

import java.lang.reflect.Method;

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
        //this.employeeService = (EmployeeServiceImpl) Proxy.newProxyInstance(employeeService.getClass().getClassLoader(),
        //        new Class[]{EmployeeServiceImpl.class},
        //        new InvocationHandler() {
        //            @Override
        //            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //                System.out.println("invoke(): jdk动态代理 开启事务：" + System.currentTimeMillis());
        //                Object invoke = method.invoke(employeeService, args);
        //                System.out.println("invoke(): jdk动态代理 提交事务：" + System.currentTimeMillis());
        //                return invoke;
        //            }
        //        });

        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(employeeService.getClass().getClassLoader());
        //设置父类
        enhancer.setSuperclass(IEmployeeService.class);
        //拦截器
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("invoke(): cglib动态代理 开启事务：" + System.currentTimeMillis());
                Object invoke = method.invoke(employeeService, objects);
                System.out.println("invoke(): cglib动态代理 提交事务：" + System.currentTimeMillis());
                return invoke;
            }
        });
        Object o = enhancer.create();
        this.employeeService = (IEmployeeService) o;
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
