package com.threads;

public class ShareObject {

    public static int value = 0;


    public static int incrementAndGet() {
        return ++value;
    }

    public static int decrementAndGet() {
        return --value;
    }
}
