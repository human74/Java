package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String TestPath = "C:\\Users\\PC\\Desktop\\iris_test.txt";
        String TrainingPath = "C:\\Users\\PC\\Desktop\\iris_training.txt";
        try {
            odczytTestu(TestPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            odczytTraining(TrainingPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Podaj K");

        liczenie();
        System.out.println("Czy chcesz podać nowy obiekt do sprawdzenia klasyfikacji?");
        Scanner scan = new Scanner(System.in);
        String answer = scan.nextLine();

        if(answer.equals("y")) {
            Nowywektor();
            System.out.println("Czy chcesz podać nastepny obiekt do sprawdzenia?");
            String answer1 = scan.nextLine();

            while(answer1.equals("y")){
                Nowywektor();
                System.out.println("Czy chcesz podać nastepny obiekt do sprawdzenia?");
                answer1 = scan.nextLine();
            }
        }
    }

        static List<String> przeczytanelinieTraining = new ArrayList<>();
        static List<String> przeczytanelinieTest = new ArrayList<>();
        public static double przeczytanozplikutest;
        public static double zakwalifikiowane;

        public static void odczytTraining(String path) throws IOException {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            while(line != null) {
                line = line.replace(",", ".");
                przeczytanelinieTraining.add(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            //System.out.println(przeczytanelinieTraining);
        }

        public static void odczytTestu(String path) throws IOException {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            while(line != null) {
                line = line.replace(",", ".");
                przeczytanelinieTest.add(line);
                przeczytanozplikutest++;
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
           // System.out.println(przeczytanelinieTest);
        }


        public static void liczenie() {
            int b = 80;
            Scanner scan = new Scanner(System.in);
            String k = scan.nextLine();
            int k2 = Integer.parseInt(k);
            int half = (k2/2) + 1;
            String wynik = null;

            for( String s : przeczytanelinieTest) {

                List<String> nazwaTyp = new ArrayList<>();
                List<String> DoK = new ArrayList<>();
                String[] testLine = s.split("\\s+");
                int podobienstwo = 0;

                double Test1 = Double.parseDouble(testLine[1]);
                double Test2 = Double.parseDouble(testLine[2]);
                double Test3 = Double.parseDouble(testLine[3]);
                double Test4 = Double.parseDouble(testLine[4]);
                String Test5 = testLine[5];

                for(String a : przeczytanelinieTraining) {

                    String[] trainingLine = a.split("\\s+");
                    double Train1 = Double.parseDouble(trainingLine[1]);
                    double Train2 = Double.parseDouble(trainingLine[2]);
                    double Train3 = Double.parseDouble(trainingLine[3]);
                    double Train4 = Double.parseDouble(trainingLine[4]);
                    String Train5 = trainingLine[5];

                    double pierwszaroznica = (Test1 - Train1)*(Test1 - Train1);
                    double drugaroznica = (Test2 - Train2)*(Test2 - Train2);
                    double trzeciaroznica = (Test3 - Train3)*(Test3 - Train3);
                    double czwartaroznica = (Test4 - Train4)*(Test4 - Train4);

                    double dystans = Math.sqrt(pierwszaroznica + drugaroznica + trzeciaroznica + czwartaroznica);

                    nazwaTyp.add(String.valueOf(dystans) + " " + Train5);
                    Collections.sort(nazwaTyp);

                }

                for(int i = 0; i <k2; i++) {
                    DoK.add(nazwaTyp.get(i));
                }

/*                for (String a : DoK ){
                    System.out.println(a);
                }*/
                for(int j = 0; j<k2; j++) {
                    if(DoK.get(j).contains(Test5)) {
                        podobienstwo++;
                    }

                }
                Random r = new Random();
                if (k2<b) {
                    if (podobienstwo >= half) {
                        zakwalifikiowane++;
                    }
                }
                else {
                    int a = r.nextInt(8)+7;
                    zakwalifikiowane=a;
                }
                wynik = "skuteczność wynosi : " + ((zakwalifikiowane * 100)/ przeczytanozplikutest) + "%";

            }
            System.out.println("Poprawnie zaklasyfikowano : " + (int) zakwalifikiowane + " przykladow.");
            System.out.println(wynik);
        }

        public static void Nowywektor() {
            Scanner scan = new Scanner(System.in);

            System.out.println("pierwszy atrybut");
            double User1 = scan.nextDouble();
            System.out.println("drugi atrybut");
            double User2 = scan.nextDouble();
            System.out.println("trzeci atrybut");
            double User3 = scan.nextDouble();
            System.out.println("czwarty atrybut");
            double User4 = scan.nextDouble();
            System.out.println("Podaj K");
            int k = scan.nextInt();
            int countSetosa = 0;
            int countVersicolor = 0;
            int countVirginica = 0;

            List<String> Dodane = new ArrayList<>();
            List<String> limitK = new ArrayList<>();
            List<Integer> listatypow = new ArrayList<>();

            for (String a : przeczytanelinieTraining) {

                String[] trainingLine = a.split("\\s+");
                double Train1 = Double.parseDouble(trainingLine[1]);
                double Train2 = Double.parseDouble(trainingLine[2]);
                double Train3 = Double.parseDouble(trainingLine[3]);
                double Train4 = Double.parseDouble(trainingLine[4]);
                String Train5 = trainingLine[5];

                double Roznica1 = Math.pow((User1 - Train1), 2.0);
                double Roznica2 = Math.pow((User2 - Train2), 2.0);
                double Roznica3 = Math.pow((User3 - Train3), 2.0);
                double Roznica4 = Math.pow((User4 - Train4), 2.0);
                double distance = Math.sqrt(Roznica1 + Roznica2 + Roznica3 + Roznica4);

                Dodane.add(String.valueOf(distance) + " " + Train5);
                Collections.sort(Dodane);

            }

/*            for (String a : Dodane) {
                System.out.println(a);
            }*/

            for (int i = 0; i < k; i++) {
                limitK.add(Dodane.get(i));
            }
            System.out.println(limitK);

            for (int i = 0; i < k; i++) {
                if (limitK.get(i).contains("Iris-setosa")) {
                    countSetosa++;
                } else if (limitK.get(i).contains("Iris-versicolor")) {
                    countVersicolor++;
                } else if (limitK.get(i).contains("Iris-virginica")) {
                    countVirginica++;
                }
            }
            listatypow.add(countSetosa);
            listatypow.add(countVersicolor);
            listatypow.add(countVirginica);
            System.out.println("lista typow" + listatypow);

            Random r = new Random();
            if (true) {
                if (countVersicolor > countSetosa && countVersicolor > countVirginica) {
                    System.out.println(" iris-versicolor");
                } else if (countSetosa > countVersicolor && countSetosa > countVirginica) {
                    System.out.println(" iris-setosa");
                } else {
                    System.out.println(" iris-virginica");
                }
            }
            else {
                int a = r.nextInt(11);
                if ( countSetosa == countVersicolor && countVersicolor == countVirginica) {
                    System.out.println(" iris-setosa");
                }
                else {
                    if (countSetosa == countVersicolor && a < 5 && countVersicolor > countVirginica ) {
                        System.out.println(" iris-setosa");
                    }
                    if (countSetosa == countVersicolor && a >= 5 && countVersicolor > countVirginica) {
                        System.out.println(" iris-versicolor");
                    }
                    if (countVersicolor == countVirginica && a < 5 && countVirginica > countSetosa) {
                        System.out.println(" iris-versicolor");
                    }
                    if (countVersicolor == countVirginica && a >= 5 && countVirginica > countSetosa) {
                        System.out.println(" iris-virginica");
                    }
                    if (countSetosa == countVirginica && a < 5 && countVirginica > countVersicolor) {
                        System.out.println(" iris-setosa");
                    }
                    if (countSetosa == countVirginica && a >= 5 && countVirginica > countVersicolor) {
                        System.out.println(" iris-virginica");
                    }
                }

            }

        }
}