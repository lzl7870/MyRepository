package com.keymobile.model;

import lombok.Data;

@Data
public class Super {
    private String name;
    private int age;
    public void getObejct(){
        System.out.println(this);
    }
    public Super(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println("super constructor");
    }
    public Super(){

    }
    private final void doWork(){
        System.out.println("super");
    }
}
