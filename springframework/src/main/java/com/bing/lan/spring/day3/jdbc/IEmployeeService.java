package com.bing.lan.spring.day3.jdbc;

import java.util.List;

/**
 * Created by 蓝兵 on 2018/4/20.
 */

public interface IEmployeeService {

  void save(Employee e);

  void delete(Long id);

  void update(Employee e);

  Employee get(Long id);

  List<Employee> list();

  void updateNoTransaction(Long id, Employee newEmployee);
}
