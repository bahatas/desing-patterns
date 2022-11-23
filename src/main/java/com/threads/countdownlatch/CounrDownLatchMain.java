package com.threads.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CounrDownLatchMain {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);

        CountDownLatchDemo taskInc = new CountDownLatchDemo(true, "Incrementor", latch);
        CountDownLatchDemo taskDec = new CountDownLatchDemo(false, "Decrementor", latch);

        Thread tInc = new Thread(taskInc);
        Thread tDec = new Thread(taskDec);

        tInc.start();
        tDec.start();

        tInc.join();
        tDec.join();
    }
}
