package com.task;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

public class CeramicStore {
    public static void runAndWait(List<Runnable> runnables) {


//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//
//        executorService.submit(runnables.get(0));
//        executorService.submit(runnables.get(1));
//
//        executorService.invokeAll()

//        runnables.stream().forEach(runnable -> {
//            new Thread(runnable).start();
//        });

        Thread t1 = new Thread(runnables.get(0));
        Thread t2 = new Thread(runnables.get(1));

        t1.start();
        t2.start();


        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        CountDownLatch countDownLatch = new CountDownLatch(2);

        //current thread will get notified if all chidren's are done
        // and thread will resume from wait() mode.
        new Thread(runnables.get(0)).start(); // time in millis.. 2 secs
        new Thread(runnables.get(1)).start();

    }

    public static void main(String[] args) {
        List<Runnable> runnables = Arrays.asList(() -> {
            try {
                Thread.sleep(800);
                System.out.println("Slow function");
            } catch (Exception e) {
            }
        }, () -> {
            try {
                Thread.sleep(700);
                System.out.println("Fast function");
            } catch (Exception e) {
            }
        });

        // Expected output:
        // Fast function
        // Slow function
        // Returned from the method!
        runAndWait(runnables);
        System.out.println("Returned from the method!");
    }
}