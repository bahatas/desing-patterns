package com.example.designpatterns.completebleFuture;

import java.util.concurrent.*;

public class Basics {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Basics n = new Basics();
        n.calculateAsync();
        n.calculateAsync2();
        n.calculateAsync3();
    }

    public Future<String> calculateAsync() {

        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return null;
        });
        return completableFuture;

    }

    public CompletableFuture<String> calculateAsync2() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");

        System.out.println(future.get());
        return future;
    }

    public CompletableFuture<String> calculateAsync3() throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");

        System.out.println("Completed and Sending To another Future");
        System.out.println("thenApply() : We can use this method to work with the result of the previous call. However, " +
                "a key point to remember is that the return type will be combined of all calls.");
        CompletableFuture future = completableFuture.thenApply(e -> e + "World");


        System.out.println(future.get());

        CompletableFuture supplyFuture = completableFuture.thenAccept(s -> System.out.print("Computation completed" + s));

        System.out.println("supplyFuture : " + supplyFuture.get());

        return future;

    }
    /**
     * The best part of the CompletableFuture API is the ability to
     * combine CompletableFuture instances in a chain of computation steps
     * The result of this chaining is itself a CompletableFuture that allows further chaining and combining.
     * This approach is ubiquitous in functional languages and is often referred to as a monadic design pattern.
     */

    /**
     *
     */

    public Future<String> getAsyncString() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "World "));

        return completableFuture;

    }

    public Future<String> getAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beatiful");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");


        CompletableFuture<Void> combined = CompletableFuture.allOf(future1, future2, future3);

        combined.get();

        return null;

        // Bu methd void dondderiyor bu buyk limitations Databse gotur kaydet dyeniriz
    }

    public Future<String> getAsync2(){
        return null;
    }
}


