package com.bing.lan.spring.day3.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by 蓝兵 on 2018/4/24.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
public class JdbcTest {

    @Autowired
    private EmployeeAction employeeAction;

    @Test
    public void testSave() {
        employeeAction.save("xiaoming", "13556224434");
    }

    @Test
    public void testDelete() {
        employeeAction.delete(1l);
    }

    @Test
    public void testUpdate() {
        Employee employee = employeeAction.get(5l);
        System.out.println("testUpdate(): " + employee);
        employee.setPhone("12939999399");
        System.out.println("testUpdate(): " + employee);
        employeeAction.update(employee);
    }

    @Test
    public void testGet() {
        Employee employee = employeeAction.get(5l);
        System.out.println("testGet(): " + employee);
    }

    @Test
    public void testList() {
        List<Employee> list = employeeAction.list();
        System.out.println("testList(): " + list);
    }
}