package com.zane.utils.Test;

import com.zane.utils.Cal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-Aop.xml");
        //获取代理对象
        Cal proxy = (Cal) applicationContext.getBean("test");
        proxy.add(1, 1);
        proxy.div(6, 2);
        proxy.mul(2, 3);
        proxy.sub(2, 1);
    }
}
