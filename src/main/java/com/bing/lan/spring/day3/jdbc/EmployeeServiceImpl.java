package com.bing.lan.spring.day3.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 蓝兵 on 2018/4/20.
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private IEmployeeDAO employeeDAO;

    @Autowired
    public void setEmployeeDAO(IEmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void save(Employee e) {
        Employee employee = employeeDAO.getByPhone(e.getPhone());
        if (employee != null) {
            System.out.println("save(): 账号已存在，注册失败");
            return;
        }
        employeeDAO.save(e);
        System.out.println("save(): 注册成功");
    }

    @Override
    public void delete(Long id) {
        employeeDAO.delete(id);
    }

    @Override
    public void update(Employee e) {
        employeeDAO.update(e);
    }

    @Override
    public Employee get(Long id) {
        return employeeDAO.get(id);
    }

    @Override
    public List<Employee> list() {
        return employeeDAO.list();
    }

    @Override
    public void updateNoTransaction(Long id, Employee newEmployee) {
        employeeDAO.updateNoTransaction(id, newEmployee);
    }
}
