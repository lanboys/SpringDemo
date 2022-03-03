package com.bing.lan.spring.day2._02_proxy._05_annAop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 蓝兵 on 2018/4/20.
 */

/**
 * 全注解 _03_annMvc 应用
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
public class AnnAopTest {

  @Autowired
  private EmployeeAction employeeAction;

  @Test
  public void test() {

    employeeAction.save("xiaoming", "13556224424");
  }
}
