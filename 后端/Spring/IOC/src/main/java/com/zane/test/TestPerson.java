package com.zane.test;

import com.zane.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerson {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("autowire.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }
}
