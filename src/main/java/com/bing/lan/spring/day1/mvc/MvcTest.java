package com.bing.lan.spring.day1.mvc;

import org.junit.Test;

/**
 * Created by 蓝兵 on 2018/4/20.
 */

/**
 * 传统 mvc 应用
 */
public class MvcTest {

    @Test
    public void test() {
        EmployeeAction employeeAction = new EmployeeAction();
        employeeAction.save("xiaoming", "13556004824");
    }
}
