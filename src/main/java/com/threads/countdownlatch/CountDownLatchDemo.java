package com.threads.countdownlatch;

import com.threads.ShareObject;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo implements Runnable {

    private boolean increment;
    private String name;
    private CountDownLatch countDownLatch;

    public CountDownLatchDemo(boolean increment, String name, CountDownLatch countDownLatch) {
        this.increment = increment;
        this.name = name;
        this.countDownLatch = countDownLatch;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            if (increment) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(name + " value : " + ShareObject.decrementAndGet());
                    Thread.sleep(10);

                    countDownLatch.countDown();
                }
            } else {
                countDownLatch.await();

                for (int i = 0; i < 5; i++) {
                    System.out.println(name + " value : " + ShareObject.decrementAndGet());
                    Thread.sleep(10);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

