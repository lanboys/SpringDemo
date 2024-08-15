package com.bing.lan.spring.day2._02_proxy._05_annAop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by 蓝兵 on 2018/4/24.
 */

@Component("txManager")
@Aspect
public class TranscationManager {

  @Pointcut("execution(* com.bing.lan.spring.day2._02_proxy._05_annAop.*ServiceImpl.*(..))")
  public void pc() {

  }

  @Before("pc()")
  public void begin() {
    System.out.println("begin(): 开启事务");
  }

  @AfterReturning("pc()")
  public void commit() {
    System.out.println("commit(): 正常结束之后 提交事务");
  }

  @After("pc()")
  public void finallyInvoke() {
    System.out.println("finallyInvoke(): finally 调用");
  }

  @AfterThrowing(value = "pc()", throwing = "throwable")
  public void rollback(Throwable throwable) {
    System.out.println("rollback(): 出现异常 事务回滚");
    System.out.println("rollback(): 异常是：" + throwable.getLocalizedMessage());
  }

  // 可以与上面同时开启
  // @Around("pc()")
  public void around(ProceedingJoinPoint pjp) {
    System.out.println("--- around(): 环绕通知");

    System.out.println("--- around(): 开启事务");
    try {
      pjp.proceed();
      System.out.println("--- around(): 正常结束之后 提交事务");
    } catch (Throwable throwable) {
      // throwable.printStackTrace();
      System.out.println("--- around(): 出现异常 事务回滚");
      System.out.println("--- around(): 异常是：" + throwable.getLocalizedMessage());
    } finally {
      System.out.println("--- around(): finally 调用");
    }
  }
}
