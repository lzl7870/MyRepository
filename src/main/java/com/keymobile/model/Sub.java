package com.keymobile.model;

import lombok.Data;

@Data
public class Sub extends Super{
    private String name;

    public Sub(){
        System.out.println(111);
    }
    public Sub(String name) {
        this.name = name;
    }
    public void getObject(){
        System.out.println(this);
        super.getObejct();
    }
}
