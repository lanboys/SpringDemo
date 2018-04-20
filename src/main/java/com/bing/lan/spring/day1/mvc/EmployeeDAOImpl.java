package com.bing.lan.spring.day1.mvc;

/**
 * Created by 蓝兵 on 2018/4/20.
 */

public class EmployeeDAOImpl implements IEmployeeDAO {

    @Override
    public String save(Employee e) {
        System.out.println("save(): 存到了数据库");
        return "12";
    }
}
