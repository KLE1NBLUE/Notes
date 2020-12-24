package com.zane.test;

import com.zane.entity.Car;
import com.zane.factory.StaticCarFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactory {
    public static void main(String[] args) {
        //Car car = StaticCarFactory.getCar(1L);
        //System.out.println(car);

        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("spring-factory.xml");
        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);
    }
}
