package com.bing.lan.spring.day1._01_ioc._04_beanCreate;

/**
 * Created by 蓝兵 on 2018/4/20.
 */

public class SomeBeanFactory {

  public SomeBeanFactory() {
    System.out.println("SomeBeanFactory(): 工厂实例 构造方法");
  }

  public static SomeBean staticCreate() {
    System.out.println("staticCreate(): 静态工厂方法构建bean");
    SomeBean someBean = new SomeBean();
    someBean.init();
    return someBean;
  }

  public SomeBean create() {
    System.out.println("create(): 工厂方法构建bean");
    return new SomeBean();
  }
}
