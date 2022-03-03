package com.bing.lan.spring.day1._02_di;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class DiTest {

  @Autowired
  private ApplicationContext mBeanFactory;

  private SomeBean someBean;

  @Test
  public void test() {
    someBean = mBeanFactory.getBean("someBean", SomeBean.class);
    System.out.println("test(): " + someBean.toString());
  }
}
