package com.effectivejava;

public class CacheMain {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {

                }
                System.out.println("HashCode of Lazuy : " + LazyCache.getInstance().hashCode());
                System.out.println("EagerCache of Lazuy : " + EagerCache.getInstance().hashCode());
                System.out.println("EnumCache of Lazuy : " + EnumCache.INSTANCE.hashCode());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("HashCode of Lazuy : " + LazyCache.getInstance().hashCode());
                System.out.println("EagerCache of Lazuy : " + EagerCache.getInstance().hashCode());
                System.out.println("EnumCache of Lazuy : " + EnumCache.INSTANCE.hashCode());

            }
        }).start();


    }
}
