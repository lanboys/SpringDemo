package com.bing.lan.spring.day1._01_ioc._06_init_destroy;

/**
 * Created by 蓝兵 on 2018/4/19.
 */

public class SomeBean {

  public static SomeBean create() {
    System.out.println("create(): 工厂方法构建bean");
    SomeBean someBean = new SomeBean();
    someBean.init();
    System.out.println("create(): 工厂方法构建bean");
    return someBean;
  }

  public SomeBean() {
    System.out.println("SomeBean(): 构造方法");
  }

  public void init() {
    System.out.println("init(): 初始化方法");
  }

  public void close() {
    System.out.println("close(): 销毁方法");
  }

  public void sayHello() {
    System.out.println("sayHello(): ");
  }
}