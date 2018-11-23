package com.keymobile.model;

public interface B {
    void aa();
    void cc();
    default void uu(){
        System.out.println("Inteface B");
    }
}
