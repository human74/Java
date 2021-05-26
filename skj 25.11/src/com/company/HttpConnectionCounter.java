package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class HttpConnectionCounter {


    private static int contactedServers = 0;


    public static void main(String[] args) {

        int a =504;
        int liczba=0;
        for (int i =1; i<= 3; i++){
            if (a%i==0) {
                liczba++;
            }

        }
        System.out.print(liczba+" ");

        System.out.println("Starting the client...");


        for (int port = 34217; port<= 34720 ; port++) {

            CountDownLatch latch = new CountDownLatch(4);
            ExecutorService threadPool = Executors.newFixedThreadPool(4);
            threadPool.submit(new HttpConnectionThread("172.21.48.135", latch, port));
            threadPool.submit(new HttpConnectionThread("172.21.48.135", latch, ++port));
            threadPool.submit(new HttpConnectionThread("172.21.48.135", latch, ++port));
            threadPool.submit(new HttpConnectionThread("172.21.48.135", latch, ++port));

            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Number of responsive servers: " + HttpConnectionCounter.getContactedServers());
            threadPool.shutdown();
        }
    }

    public static synchronized void incrementContactedServers() {
        contactedServers++;
    }

    public static int getContactedServers() {
        return contactedServers;
    }




}