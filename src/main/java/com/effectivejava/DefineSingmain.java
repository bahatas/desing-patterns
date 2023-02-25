package com.effectivejava;

public class DefineSingmain {


    public static void main(String[] args) {

        /***
         * Those all methods complie error as constructor is private
         *
         */
//    DefineSingleton defineSingleton = new DefineSingleton();
//    DefineSingleton defineSingleton2 = new DefineSingleton();
//    DefineSingleton defineSingleton3 = new DefineSingleton();

//        DefineSingleton singleton = DefineSingleton.singletonObj;
//        DefineSingleton singleton2 = DefineSingleton.singletonObj;

        DefineSingleton singleton = DefineSingleton.getSingletonObj();
        DefineSingleton singleton2 = DefineSingleton.getSingletonObj();


        System.out.println(singleton.hashCode());
        System.out.println(singleton2.hashCode());
        System.out.println(singleton==singleton2);
        /**
         * Same hascode for different objcreattion shows they are singletoon same obj
         */


    }
}
