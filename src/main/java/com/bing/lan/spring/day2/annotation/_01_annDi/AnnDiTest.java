package com.bing.lan.spring.day2.annotation._01_annDi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AnnDiTest {

    //@Autowired
    //private ApplicationContext mBeanFactory;

    @Autowired
    private SomeBean someBean;

    @Test
    public void test() {
        //someBean = mBeanFactory.getBean("someBean", SomeBean.class);
        System.out.println("test(): " + someBean.toString());
    }
}
