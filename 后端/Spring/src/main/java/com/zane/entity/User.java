package com.zane.entity;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private long id;
    private String name;
    private int age;
    private List<Address> addresses;
    public User(){
        System.out.println("创建了User");
    }
}
