package com.bing.lan.spring.day1.ioc._01_helloWorld;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by 蓝兵 on 2018/4/19.
 */
public class HelloWorldTest {

    private IHelloWorld helloWorld;

    public HelloWorldTest() {

        /**
         * 1,创建一个资源文件对象(ClasspathResource);
         * 2,创建一个BeanFactory(Spring的容器);创建一个基于XML的BeanFactory:XmlBeanFactory,传入XML配置文件资源对象;
         * 3,从容器中拿对象:
         *          1,getBean(Class):按照类型拿bean;
         *          2,getBean(String):按照名字拿bean;
         *          3,getBean(String,Class):按照名字和类型拿;(推荐)    【类型需要是接口的类型】
         */
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);

        helloWorld = beanFactory.getBean("_01_helloWorld", HelloWorld.class);
    }

    @Test
    public void test() {
        helloWorld.sayHello();
    }
}
