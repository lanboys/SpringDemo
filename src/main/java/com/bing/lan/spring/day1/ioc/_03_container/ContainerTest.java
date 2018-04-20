package com.bing.lan.spring.day1.ioc._03_container;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 蓝兵 on 2018/4/19.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ContainerTest {

    private SomeBean someBean;

    /**
     * 使用Spring测试的时候，都是创建 ApplicationContext 这个容器
     * ApplicationContext 启动的时候就实例化了所以需要管理的bean
     * 但是 scope = prototype 时不会初始化
     *
     * 对于ApplicationContext:
     *      1,可以在bean元素配置lazy-init=true来让bean延迟实例化;
     *      2,可以在beans元素配置default-lazy-init=true来让这个beans里面所有的bean延迟实例化;
     */
    @Autowired
    private ApplicationContext mBeanFactory;

    @Test
    public void test() {
        someBean = mBeanFactory.getBean("someBean", SomeBean.class);
        someBean.sayHello();
    }
}
