package com.bing.lan.spring.day1.mvc;

/**
 * Created by 蓝兵 on 2018/4/20.
 */

public class EmployeeServiceImpl implements IEmployeeService {

    private IEmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public String save(Employee e) {
        System.out.println("save(): 查询数据库 客户不纯在，新建用户");
        return employeeDAO.save(e);
    }
}
