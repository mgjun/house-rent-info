package com.example.houserentinfo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class DemoTest {


    @Test
    public void test() throws ExecutionException, InterruptedException {

        System.out.println("start");
        List<CompletableFuture> completableFutureList = new ArrayList<>();
        AtomicInteger integer = new AtomicInteger(10000);
        for(int i=0;i<10;i++) {
            completableFutureList.add(CompletableFuture.supplyAsync(() -> {
                int increment = integer.incrementAndGet();
                System.out.println("sync"+increment);
                return increment;
            }));
        }

        System.out.println("end");
        completableFutureList.forEach(completableFuture -> {
            try {
                System.out.println(completableFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
