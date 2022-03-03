package com.bing.lan.spring.day1._01_ioc._03_container;

/**
 * Created by 蓝兵 on 2018/4/19.
 */

public class SomeBean {

  public SomeBean() {
    System.out.println("SomeBean(): 构造方法");
  }

  public void sayHello() {
    System.out.println("sayHello(): ");
  }
}