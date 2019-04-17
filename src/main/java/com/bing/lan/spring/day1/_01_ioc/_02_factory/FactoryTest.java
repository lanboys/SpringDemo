package com.bing.lan.spring.day1._01_ioc._02_factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 蓝兵 on 2018/4/19.
 */

/**
 * 告诉junit 自动开启spring容器，关闭spring容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 设置spring的配置文件，默认为  类名-context.xml
 */
@ContextConfiguration
public class FactoryTest {

    private SomeBean someBean;

    /**
     * spring 会自动将创建好的容器传给这个字段，跟字段名称无关系
     */
    @Autowired
    private BeanFactory mBeanFactory;

    @Test
    public void test() {
        someBean = mBeanFactory.getBean("someBean", SomeBean.class);
        someBean.sayHello();
    }
}
