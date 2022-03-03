package com.bing.lan.spring.day3.jdbc;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 蓝兵 on 2018/4/20.
 */

//@Repository
public class EmployeeDAOImpl extends JdbcDaoSupport implements IEmployeeDAO {

  //JdbcTemplate jdbcTemplate;
  //
  //private JdbcTemplate getJdbcTemplate() {
  //    return jdbcTemplate;
  //}
  //
  //@Autowired
  //public void setDataSource(DataSource dataSource) {
  //    jdbcTemplate = new JdbcTemplate(dataSource);
  //}

  @Override
  public void save(Employee e) {
    getJdbcTemplate().update(
        "INSERT INTO employee(name,phone) VALUES (?,?)",
        e.getName(), e.getPhone());
  }

  @Override
  public void delete(Long id) {
    getJdbcTemplate().update("DELETE FROM employee WHERE id = ?", id);
  }

  @Override
  public void update(Employee e) {
    getJdbcTemplate().update(
        "UPDATE employee SET name = ?, phone =? WHERE id =?",
        e.getName(),
        e.getPhone(),
        e.getId());
  }

  @Override
  public Employee get(Long id) {
    return getJdbcTemplate().query(
        "SELECT * FROM employee WHERE id = ?", new ResultSetExtractor<Employee>() {
          @Override
          public Employee extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            if (resultSet.next()) {
              Employee employee = getEmployee(resultSet);
              return employee;
            }
            return null;
          }
        }, id);
  }

  @Override
  public Employee getByPhone(String phone) {
    return getJdbcTemplate().query(
        "SELECT * FROM employee WHERE phone = ?", new ResultSetExtractor<Employee>() {
          @Override
          public Employee extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            if (resultSet.next()) {
              return getEmployee(resultSet);
            }
            return null;
          }
        }, phone);
  }

  private Employee getEmployee(ResultSet resultSet) throws SQLException {
    Employee employee = new Employee();
    employee.setId(resultSet.getLong("id"));
    employee.setName(resultSet.getString("name"));
    employee.setPhone(resultSet.getString("phone"));
    return employee;
  }

  @Override
  public List<Employee> list() {
    //List<Employee> query = getJdbcTemplate().query(
    //        "SELECT * FROM employee", new ResultSetExtractor<List<Employee>>() {
    //            @Override
    //            public List<Employee> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
    //                List<Employee> list = new ArrayList<>();
    //                while (resultSet.next()) {
    //                    Employee employee = getEmployee(resultSet);
    //                    list.add(employee);
    //                }
    //                return list;
    //            }
    //        });
    List<Employee> query = getJdbcTemplate().query(
        "SELECT * FROM employee", new RowMapper<Employee>() {
          @Override
          public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
            return getEmployee(resultSet);
          }
        });

    return query;
  }

  /**
   * 测试没有配置事务时，存在的问题，没有保证原子性
   */
  @Override
  public void updateNoTransaction(Long id, Employee newEmployee) {
    delete(id);// 执行成功
    int i = 1 / 0;
    save(newEmployee);// 未执行
  }
}
