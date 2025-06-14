package com.java.concurrency;

import java.util.concurrent.*;

public class RateLimitExecutor {

    Semaphore s = new Semaphore(50);
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    ExecutorService workers = Executors.newFixedThreadPool(10);

    public RateLimitExecutor() {

        scheduler.scheduleAtFixedRate(() -> {
           int permits = 50 -s.availablePermits();
           if(permits > 0)
               s.release(permits);

        }, 1, 1, TimeUnit.MINUTES);

    }

    public void submitTask(Runnable t) {

        workers.submit(() -> {
            try {
                s.acquire();
                t.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
    }

    public void shutdown() {
        workers.shutdown();
        scheduler.shutdown();
    }

    public static void main(String[] args) {

        RateLimitExecutor r = new RateLimitExecutor();

        Runnable t = () -> System.out.println("Run");

        Thread tr = new Thread(()->
                System.out.println("run"));
    }
}
