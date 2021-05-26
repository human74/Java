package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

public class Test3Client implements Runnable{

    private int serverPort;
    private CountDownLatch latch;

    public Test3Client(int serverPort, CountDownLatch latch) {
        this.serverPort = serverPort;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Socket clientSocket = new Socket("172.21.48.135", this.serverPort);
            Test3.incrementContactedServers();

            PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            outToServer.println("5219");
            System.out.println("From port: "+serverPort+" data: "+inFromServer.readLine());

            clientSocket.close();
        } catch (IOException e) {
        } finally {
            latch.countDown();
        }
    }
}
