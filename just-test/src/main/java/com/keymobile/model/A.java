package com.keymobile.model;

public interface A {
    void aa();
    void bb();
    default void uu(){
        System.out.println("Interface A");
    }
}
