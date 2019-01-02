package com.keymobile.model;

import lombok.Data;

@Data
public class Sub extends Super1{
    private String name;
    private int age;
    public static final int AGE = 10;
    private final Card card = new Card("james", "123");
    public Sub(){

    }
    public Sub(String name, int age) {
        super(name, age);
    }
    public void getObject(){
        //System.out.println(this);
        //super.getObejct();
        // final修饰的对象不能指向新的对象，但是可以改变已指向对象的本身(有static也一样)
        // 有无static的区别在于new,有static时再new一个新的对象也不会改变，无static时new一个新的对象就会改变
        // 详情看thinking in java p141页
        System.out.println(card);
        card.setPassword("666");
        System.out.println(card);
    }
}
class Super1{
    private String name;
    private int age;
    public Super1(){

    }
    public Super1(String name, int age){
        System.out.println("super constructor");
    }
}