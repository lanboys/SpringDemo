package com.bing.lan.spring.day3.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

/**
 * Created by 蓝兵 on 2018/4/20.
 */

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Employee e) {
        jdbcTemplate.update(
                "INSERT INTO employee(name,phone) VALUES (?,?)",
                e.getName(), e.getPhone());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM employee WHERE id = ?", id);
    }

    @Override
    public void update(Employee e) {
        jdbcTemplate.update(
                "UPDATE employee SET name = ?, phone =? WHERE id =?",
                e.getName(),
                e.getPhone(),
                e.getId());
    }

    @Override
    public Employee get(Long id) {
        return jdbcTemplate.query(
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
        return jdbcTemplate.query(
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
        //List<Employee> query = jdbcTemplate.query(
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
        List<Employee> query = jdbcTemplate.query(
                "SELECT * FROM employee", new RowMapper<Employee>() {
                    @Override
                    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                        return getEmployee(resultSet);
                    }
                });

        return query;
    }
}
