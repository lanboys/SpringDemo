package com.bing.lan.spring.day1._01_ioc._04_beanCreate;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by 蓝兵 on 2018/4/20.
 */

public class SomeBeanFactoryBean implements FactoryBean<SomeBean> {

  public SomeBeanFactoryBean() {
    System.out.println("SomeBeanFactoryBean(): 工厂bean 构造方法");
  }

  @Override
  public SomeBean getObject() throws Exception {
    SomeBean someBean = new SomeBean();
    someBean.init();
    System.out.println("getObject(): 这里是使用时才真正创建，注释说也可以提前创建，看到具体案例再验证吧");
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
