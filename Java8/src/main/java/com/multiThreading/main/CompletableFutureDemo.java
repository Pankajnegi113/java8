package com.multiThreading.main;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CompletableFutureDemo {

    public static void main(String args[]) throws ExecutionException, InterruptedException {

        //using runAsync(Runnable) , which uses fork pool for thread running
        CompletableFuture completableFuture = CompletableFuture.runAsync(()->{
            System.out.println("Thread of runAsync method is: "+Thread.currentThread().getName());
            List<Integer> elements = Arrays.asList(10,20,30,40,50);
            elements.forEach(elem->System.out.print(elem+" "));
        });
        completableFuture.get();

        System.out.println();


        //using runAsync(Runnable,Executor) , Using executor pool
        Executor executor = Executors.newFixedThreadPool(3);
        CompletableFuture completableFutureWithExecutor = CompletableFuture.runAsync(()->{
            System.out.println("Thread of runAsync method is: "+Thread.currentThread().getName());
            List<Integer> elements = Arrays.asList(10,20,30,40,50);
            elements.forEach(elem->System.out.print(elem+" "));
        },executor);
        completableFutureWithExecutor.get();

        System.out.println("Main thread");

    }


}
