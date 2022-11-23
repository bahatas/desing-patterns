package com.threads.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreDemoMain {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(1,true);

        SemaphoreDemo taskInc = new SemaphoreDemo(true, "Incrementor", semaphore);
        SemaphoreDemo taskDec = new SemaphoreDemo(false, "Decrementor", semaphore);

        Thread tInc = new Thread(taskInc);
        Thread tDEc = new Thread(taskDec);

        tInc.start();
        tDEc.start();

        tInc.join();
        tDEc.join();

    }
}
