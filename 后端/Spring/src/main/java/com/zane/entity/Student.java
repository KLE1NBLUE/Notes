package com.zane.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class Student {
    private long  id;
    private String name;
    private int  age;
    private List<Address> addresses;
    public Student(){
        System.out.println("创建了Student");
    }

}
