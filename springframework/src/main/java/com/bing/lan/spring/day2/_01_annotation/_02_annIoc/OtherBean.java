package com.bing.lan.spring.day2._01_annotation._02_annIoc;

import org.springframework.stereotype.Component;

import java.net.URL;

/**
 * Created by 蓝兵 on 2018/4/20.
 */
@Component
public class OtherBean {

  private String name = "xiaobing";
  private long age = 18;
  private String password = "password";
  private URL url;

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
