package com.bing.lan.spring.day2._01_annotation._01_annDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Properties;

/**
 * Created by 蓝兵 on 2018/4/20.
 */

public class SomeBean {

  /**
   * required = false 非必须的
   */
  @Autowired(required = false)
  /**
   * resource 也能自动注入，1.按照字段名字
   */
  //@Resource
  /**
   * 默认为字段名，可更改为注解中的值
   */
  @Qualifier("otherBean")
  private OtherBean other;

  private Properties properties;

  @Override
  public String toString() {
    return "SomeBean{" +
        "otherBean=" + other +
        ", properties=" + properties +
        '}';
  }
}
