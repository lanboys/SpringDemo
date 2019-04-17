package com.bing.lan.spring.day1._01_ioc._06_init_destroy;

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
public class InitDestroyMethodTest {

    private SomeBean someBean;

    @Autowired
    private ApplicationContext mBeanFactory;

    @Test
    public void test() {
        someBean = mBeanFactory.getBean("someBean", SomeBean.class);
    }
}
