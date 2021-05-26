package com.company;

public class Czas implements Runnable{
    static int dzien = 0;               //todo czas
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            dzien++;

            if(dzien > 0 && dzien%2 == 0){
                Pomieszczenie.sprawdzStan();
            }
        }
    }
}
