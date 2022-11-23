package com.threads.cyclicbarrier;

public class CyclicBarrierAction implements Runnable {
    private int counter = 0;

    @Override
    public void run() {
        System.out.println(counter++ + " Barrier achieved");
    }
}
