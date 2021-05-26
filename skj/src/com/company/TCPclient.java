package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPclient {

    public static void main(String[] args) {

        try {
            Socket clientSocket = new Socket("172.21.48.170", 10006);

            PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader inFromServer =  new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            outToServer.println("s21880");
            outToServer.println("445836");
            outToServer.println();

            String line;
            while((line = inFromServer.readLine()) != null) {
                System.out.println(line);
            }

            clientSocket.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}