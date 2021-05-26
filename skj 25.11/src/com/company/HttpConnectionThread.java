package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

public class HttpConnectionThread implements Runnable {

    private String serverName;
    private CountDownLatch latch;
    private int port;

    public HttpConnectionThread(String serverName, CountDownLatch latch, int port) {
        this.serverName = serverName;
        this.latch = latch;
        this.port = port;
    }

    @Override
    public void run() {

        String x;
        try {
            Socket clientSocket = new Socket(serverName, port);
            HttpConnectionCounter.incrementContactedServers();

            PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            outToServer.println("5219");

            String line;
            while (!(line = inFromServer.readLine()).isEmpty()) {
                System.out.println(line);
                x = line;
            }

            clientSocket.close();
            System.out.println("Socket  closed!\n");
        } catch (IOException e) {

        } finally {
            latch.countDown();
        }
    }
}
