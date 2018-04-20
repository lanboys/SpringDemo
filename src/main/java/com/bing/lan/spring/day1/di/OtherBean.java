package com.bing.lan.spring.day1.di;

import java.net.URL;

/**
 * Created by 蓝兵 on 2018/4/20.
 */

public class OtherBean {

    private String name;
    private long age;
    private String password;
    private URL url;

    public OtherBean(String name, long age) {
        this.name = name;
        this.age = age;
        System.out.println("OtherBean(): 111111111111111");
    }

    public OtherBean(String name, long age, String password, URL url) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.url = url;

        System.out.println("OtherBean(): 222222222222222");
    }

    @Override
    public String toString() {
        return "OtherBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", url=" + url +
                '}';
    }
}
