package com.bing.lan.spring.day1.mvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 蓝兵 on 2018/4/20.
 */

/**
 * 传统 mvc 应用
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
public class MvcTest {

    private EmployeeAction employeeAction;

    @Autowired
    private ApplicationContext mBeanFactory;

    @Test
    public void test() {
        employeeAction = mBeanFactory.getBean("employeeAction", EmployeeAction.class);
        employeeAction.save("xiaoming", "13556004824");
    }
}
