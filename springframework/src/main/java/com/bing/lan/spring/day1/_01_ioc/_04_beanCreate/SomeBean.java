package com.bing.lan.spring.day1._01_ioc._04_beanCreate;

/**
 * Created by 蓝兵 on 2018/4/19.
 */

public class SomeBean {

  public static SomeBean create() {
    System.out.println("create(): 自身静态工厂方法构建bean");
    SomeBean someBean = new SomeBean();
    someBean.init();
    return someBean;
  }

  public SomeBean() {
    System.out.println("SomeBean(): 构造方法");
  }

  public void init() {
    System.out.println("init(): 初始化方法");
  }

  public void sayHello(int i) {
    System.out.println("sayHello(): " + i);
  }
}