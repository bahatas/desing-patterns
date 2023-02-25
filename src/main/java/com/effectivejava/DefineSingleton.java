package com.effectivejava;

public class DefineSingleton {
    public static DefineSingleton singletonObj = new DefineSingleton(); // even if it okay best is creating a method instead

    private DefineSingleton() {

    }


    public static DefineSingleton getSingletonObj(){
        return singletonObj;
    }

}
