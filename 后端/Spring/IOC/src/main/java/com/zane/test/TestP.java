package com.zane.test;

import com.zane.entity.Address;
import com.zane.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestP {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p.xml");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
    }
}
