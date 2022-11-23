package com.threads.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemoMain {
    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new CyclicBarrierAction());


        CyclicBarrierDemo cb1 = new CyclicBarrierDemo("T1", cyclicBarrier);
        CyclicBarrierDemo cb2 = new CyclicBarrierDemo("T2", cyclicBarrier);
        CyclicBarrierDemo cb3 = new CyclicBarrierDemo("T3", cyclicBarrier);

        Thread t1 = new Thread(cb1);
        Thread t2 = new Thread(cb2);
        Thread t3 = new Thread(cb3);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
