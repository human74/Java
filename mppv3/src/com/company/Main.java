package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        double a = 0.1;
        String trainSet ="C:\\Users\\PC\\Desktop\\iris_training.txt";
        String testSet ="C:\\Users\\PC\\Desktop\\iris_test.txt";
        Perceptron perceptron=new Perceptron(a,trainSet);
        perceptron.checkTestFile(testSet);
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Podaj wektory oddzielone spacja");
            String vectors=scanner.nextLine();
            StringTokenizer tokenizer=new StringTokenizer(vectors," ");
            List<Double> vectorsT = new ArrayList<>();
            while(tokenizer.hasMoreTokens())
                vectorsT.add(Double.parseDouble(tokenizer.nextToken()));
            if(vectorsT.size()!=perceptron.w.size()){
                System.out.println("Podano nieprawidlowa ilosc argumentow");
                continue;
            }
            Iris irisToTest = new Iris(vectorsT,null);
            System.out.println(perceptron.checkIris(irisToTest));
        }

    }
}
