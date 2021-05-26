package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test3 {

    private static int contactedServers = 0;

    public static void main(String[] args) {
        int currentPortNumber = 34217;
        int maxPortNumber = 34720;
        System.out.println("Starting the client...");
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        while(currentPortNumber <= maxPortNumber) {
            threadPool.submit(new Test3Client(currentPortNumber, latch));
            threadPool.submit(new Test3Client(currentPortNumber, latch));
            threadPool.submit(new Test3Client(currentPortNumber, latch));
            threadPool.submit(new Test3Client(currentPortNumber, latch));
            threadPool.submit(new Test3Client(currentPortNumber, latch));
            threadPool.submit(new Test3Client(currentPortNumber, latch));
            threadPool.submit(new Test3Client(currentPortNumber, latch));
            threadPool.submit(new Test3Client(currentPortNumber, latch));
            threadPool.submit(new Test3Client(currentPortNumber, latch));
            threadPool.submit(new Test3Client(currentPortNumber, latch));
            currentPortNumber++;
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Number of responsive servers: " + Test3.getContactedServers());
        threadPool.shutdown();
    }

    public static synchronized void incrementContactedServers(){
        contactedServers++;
    }

    public static int getContactedServers(){
        return contactedServers;
    }
}