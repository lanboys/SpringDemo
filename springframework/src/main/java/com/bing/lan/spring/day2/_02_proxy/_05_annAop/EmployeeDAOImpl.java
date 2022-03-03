package com.bing.lan.spring.day2._02_proxy._05_annAop;

import org.springframework.stereotype.Repository;

/**
 * Created by 蓝兵 on 2018/4/20.
 */

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {

  @Override
  public String save(Employee e) {
    System.out.println("save(): 存到了数据库");
    return "12";
  }
}
