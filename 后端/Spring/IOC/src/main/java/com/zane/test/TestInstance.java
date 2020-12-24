package com.zane.test;
import com.zane.entity.Car;
import  com.zane.factory.InstanceCarFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInstance {
    public static void main(String[] args) {
//        InstanceCarFactory instanceCarFactory = new InstanceCarFactory();
//        Car car =instanceCarFactory.getCar(1L);
//        System.out.println(car);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-factory.xml");
        Car car = (Car) applicationContext.getBean("car2");
        System.out.println(car);
    }
}
