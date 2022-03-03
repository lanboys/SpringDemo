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
    public void testDeleteAll() {
        List<Employee> list = employeeAction.list();
        if (list.isEmpty()) {
            return;
        }
        long firstId = list.get(0).getId();
        long lastId = list.get(list.size() - 1).getId();
        for (long i = firstId; i <= lastId; i++) {
            employeeAction.delete(i);
        }
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

    /**
     * 测试没有配置事务时，存在的问题，没有保证原子性
     */
    @Test
    public void updateNoTransaction() {
        testDeleteAll();//清除数据
        testSave();//新增一条数据
        List<Employee> list = employeeAction.list();
        if (list.isEmpty()) {
            return;
        }
        Employee oldEmployee = list.get(0);
        System.out.println("oldEmployee: " + oldEmployee);
        Employee newEmployee = new Employee();
        newEmployee.setPhone(oldEmployee.getPhone() + "1111");
        newEmployee.setName(oldEmployee.getName());
        System.out.println("newEmployee: " + newEmployee);
        try {
            employeeAction.updateNoTransaction(oldEmployee.getId(), newEmployee);
        } catch (Exception e) {
            //  忽略
        }

        testList();// 检查有多少条数据：期望 1 条，实际是 0 条, 加上事务后，期望值正确
    }
}