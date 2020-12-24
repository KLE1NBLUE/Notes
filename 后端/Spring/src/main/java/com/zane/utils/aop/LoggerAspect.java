package com.zane.utils.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component//将该类对象注入IoC容器中
@Aspect//该类是切面类

public class LoggerAspect {
    //非业务代码

    @Before(value = "execution(public int com.zane.utils.CalImpl.* (..))")
    //表示方法执行的具体位置和时机
    public void before(JoinPoint joinPoint) {
        //获取方法名
        String name = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(name + "方法的参数是：" + args);
    }

    @After(value = "execution(public int com.zane.utils.CalImpl.* (..))")
    public void after(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法执行完毕");
    }

    @AfterReturning(value = "execution(public int com.zane.utils.CalImpl.* (..))", returning = "x")
    public void afterReturning(JoinPoint joinPoint, Object x) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法的结果是" + x);
    }

    @AfterThrowing(value = "execution(public int com.zane.utils.CalImpl.* (..))", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        //获取方法名
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法抛出的异常：" + exception);
    }

}
