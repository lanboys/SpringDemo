package com.bing.lan.spring.day1.hello;

/**
 * Created by 蓝兵 on 2018/4/19.
 */

public class HelloWorld implements IHelloWorld {

    @Override
    public void sayHello() {
        System.out.println("sayHello(): ");
    }
}
