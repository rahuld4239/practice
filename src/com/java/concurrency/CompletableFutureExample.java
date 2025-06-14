package com.java.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1. Creating a CompletableFuture
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 1 running in thread: " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Hello";
        });

        // 2. Chaining CompletableFutures with thenApply
        CompletableFuture<String> future2 = future1.thenApply(result -> {
            System.out.println("Task 2 running in thread: " + Thread.currentThread().getName());
            return result + " World";
        });

        // 3. Handling results with thenAccept
        future2.thenAccept(result -> System.out.println("Task 3 running in thread: " + Thread.currentThread().getName() + ", Result: " + result));

        // 4. Executing a task without returning a result using thenRun
        future2.thenRun(() -> System.out.println("Task 4 running in thread: " + Thread.currentThread().getName() + ", Task completed"));

        // 5. Combining two CompletableFutures with thenCombine
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 5 running in thread: " + Thread.currentThread().getName());
            return "!";
        });
        CompletableFuture<String> combinedFuture = future2.thenCombine(future3, (str1, str2) -> str1 + str2);
        combinedFuture.thenAccept(result -> System.out.println("Task 6 running in thread: " + Thread.currentThread().getName() + ", Combined Result: " + result));

        // 6. Handling exceptions with exceptionally
        CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 7 running in thread: " + Thread.currentThread().getName());
            if (true) {
                throw new RuntimeException("Something went wrong");
            }
            return 100;
        });

        CompletableFuture<Integer> future5 = future4.exceptionally(ex -> {
            System.out.println("Task 8 running in thread: " + Thread.currentThread().getName() + ", Handling Exception: " + ex.getMessage());
            return -1;
        });

        future5.thenAccept(result -> System.out.println("Task 9 running in thread: " + Thread.currentThread().getName() + ", Result after exception: " + result));

        // 7. Using handle for both successful and exceptional completion
        CompletableFuture<Integer> future6 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 10 running in thread: " + Thread.currentThread().getName());
            if(true){
                throw new RuntimeException("Exception in task 10");
            }
            return 200;
        });

        CompletableFuture<Integer> future7 = future6.handle((result, ex) -> {
            System.out.println("Task 11 running in thread: " + Thread.currentThread().getName());
            if (ex != null) {
                System.out.println("Handling exception in handle: " + ex.getMessage());
                return -2;
            } else {
                return result;
            }
        });

        future7.thenAccept(result -> System.out.println("Task 12 running in thread: " + Thread.currentThread().getName() + ", Result after handle: " + result));

        // 8. Using runAsync for tasks that don't return a value
        CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(() -> {
            System.out.println("Task 13 running in thread: " + Thread.currentThread().getName() + ", RunAsync task started");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Task 13 running in thread: " + Thread.currentThread().getName() + ", RunAsync task finished");
        });
        runAsyncFuture.thenRun(() -> System.out.println("Task 14 running in thread: " + Thread.currentThread().getName() + ", RunAsync task completed"));

        // 9. Get result of a completable future
        String finalResult = combinedFuture.get();
        System.out.println("Task 15 running in thread: " + Thread.currentThread().getName() + ", Final Result: " + finalResult);
    }
}
