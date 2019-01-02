package com.keymobile.model;

public class InterfaceImpl implements A,B {
    @Override
    public void aa() {
        System.out.println("xx");
    }

    @Override
    public void cc() {

    }

    @Override
    public void bb() {

    }

    //如果同时实现的接口中的default方法名和参数列表相同，是必须要覆盖的
    @Override
    public void uu() {

    }

}
class AA{
    private interface AAA{
        void f();
    }
}
