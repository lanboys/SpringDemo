package com.bing.lan.spring.day1._01_ioc._04_beanCreate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 蓝兵 on 2018/4/20.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class BeanCreateTest {

    private SomeBean someBean1;
    private SomeBean someBean2;
    private SomeBean someBean3;
    private SomeBean someBean4;

    @Autowired
    private ApplicationContext mBeanFactory;

    @Test
    public void test() {
        someBean1 = mBeanFactory.getBean("someBean1", SomeBean.class);
        someBean1.sayHello();
        someBean2 = mBeanFactory.getBean("someBean2", SomeBean.class);
        someBean2.sayHello();
        someBean3 = mBeanFactory.getBean("someBean3", SomeBean.class);
        someBean3.sayHello();
        someBean4 = mBeanFactory.getBean("someBean4", SomeBean.class);
        someBean4.sayHello();
    }
}
