package com.bing.lan.spring.day1._02_di;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by 蓝兵 on 2018/4/20.
 */

public class SomeBean {

  private String name;
  private long age;
  private String password;
  private URL url;
  private OtherBean otherBean;
  private List list;
  private Map map;

  private Properties properties;

  public void setProperties(Properties properties) {
    this.properties = properties;
  }

  public void setMap(Map map) {
    this.map = map;
  }

  public void setList(List list) {
    this.list = list;
  }

  public void setOtherBean(OtherBean otherBean) {
    this.otherBean = otherBean;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(long age) {
    this.age = age;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setUrl(URL url) {
    this.url = url;
  }

  @Override
  public String toString() {
    return "SomeBean{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", password='" + password + '\'' +
        ", url=" + url +
        ", otherBean=" + otherBean +
        ", list=" + list +
        ", map=" + map +
        ", properties=" + properties +
        '}';
  }
}
