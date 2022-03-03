package com.bing.lan.spring.day1._01_ioc._04_beanCreate;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by 蓝兵 on 2018/4/20.
 */

public class SomeBeanFactoryBean implements FactoryBean<SomeBean> {

  @Override
  public SomeBean getObject() throws Exception {
    SomeBean someBean = new SomeBean();
    someBean.init();
    return someBean;
  }

  @Override
  public Class<?> getObjectType() {
    return SomeBean.class;
  }

  @Override
  public boolean isSingleton() {
    return false;
  }
}
