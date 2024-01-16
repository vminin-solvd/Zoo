package com.solvd.zoo;

import com.solvd.zoo.threads.CustomThread;
import com.solvd.zoo.threads.RunnableThread;
import com.solvd.zoo.utils.ConnectionPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ThreadMain {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new RunnableThread());
            thread.start();
            threads.add(thread);
        }
        for (int i = 0; i < 2; i++) {
            CustomThread thread = new CustomThread();
            thread.start();
            threads.add(thread);
        }
        for (int i = 0; i < 2; i++) {
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
                CustomThread thread = new CustomThread();
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            completableFuture.join();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}