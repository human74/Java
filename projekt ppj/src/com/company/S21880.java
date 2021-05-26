package com.company;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class S21880 {
    public static void main(String[] args) throws IOException {

        /*
        if (args[0].equals(("load"))){
                load(5);
        }
        if (args[1].equals(("save"))){
                Zapis(obj);
        }
        */

        SiłyWojskowe W1 = new SiłyWojskowe(1, 0, 16, 0, 25,5, 5, 9 );
        SiłyWojskowe W2 = new SiłyWojskowe(1, 0, 16, 0, 25,5, 5, 9 );
        SiłyWojskowe W3 = new SiłyWojskowe(1, 0, 16, 0, 25,5, 5, 9 );
        SiłyWojskowe W4 = new SiłyWojskowe(1, 0, 16, 0, 25,5, 5, 9 );
        Sportowcy S1 = new Sportowcy(0,0,16, 1, 78, 2, 3, 8);
        Sportowcy S2 = new Sportowcy(0,0,16, 1, 78, 2, 3, 8);
        Sportowcy S3 = new Sportowcy(0,0,16, 1, 78, 2, 3, 8);
        Modelarze M1 = new Modelarze(3,1,16, 0, 74, 5, 2, 78);
        Modelarze M2 = new Modelarze(3,1,16, 0, 74, 5, 2, 78);
        Modelarze M3 = new Modelarze(3,1,16, 0, 74, 5, 2, 77);

        PrzestrzenPowietrzna obj[] = {W1,W2,W3,W4, S1,S2,S3, M1,M2,M3};
        int razy=4;
        Load(razy);
    }

    public static class PrzestrzenPowietrzna {
        int PozycjaX;
        int PozycjaY;
        int WektorRuchu;
        int pulap;
        int Predkosc;
        int Dlugosc;
        int Szerokosc;
        int liczba;
        int Odleglosc;

        public PrzestrzenPowietrzna(int PozycjaX, int PozycjaY, int pulap, int wektorRuchu, int predkosc, int dlugosc, int szerokosc) {
            this.PozycjaX = PozycjaX;
            this.PozycjaY = PozycjaY;
            this.WektorRuchu = wektorRuchu;
            this.pulap = pulap;
            this.Predkosc = predkosc;
            this.Dlugosc = dlugosc;
            this.Szerokosc = szerokosc;
            this.liczba = PozycjaX*PozycjaX+PozycjaY*PozycjaY+pulap*pulap;
            this.Odleglosc = (int) Math.sqrt(this.liczba);
        }

        public int getOdleglosc() {
            return Odleglosc;
        }

    }

    public static class SiłyWojskowe extends PrzestrzenPowietrzna {

        int Gruboscblachy;
        static int count =0;
        int ID;

        public SiłyWojskowe(int PozycjaX, int PozycjaY, int pulap, int wektorRuchu, int predkosc, int dlugosc, int szerokosc, int Gruboscblachy) {
            super(PozycjaX, PozycjaY,pulap, wektorRuchu, predkosc, dlugosc, szerokosc);
            this.Gruboscblachy = Gruboscblachy;
            ID=count++;
        }

        @Override
        public String toString() {
            return "SiłyWojskowe {" +
                    "PozycjaX=" + PozycjaX +
                    ", PozycjaY=" + PozycjaY +
                    ", pulap=" + pulap +
                    ", WektorRuchu='" + WektorRuchu + '\'' +
                    ", Predkosc=" + Predkosc +
                    ", Dlugosc=" + Dlugosc +
                    ", Szerokosc=" + Szerokosc +
                    ", Odleglosc=" + Odleglosc +
                    ", Gruboscblachy=" + Gruboscblachy +
                    '}';

        }
    }

    public static class Sportowcy extends PrzestrzenPowietrzna {

        int OporPowietrza;
        static int count =0;
        int ID;

        public Sportowcy(int PozycjaX, int PozycjaY, int pulap, int wektorRuchu, int predkosc, int dlugosc, int szerokosc, int OporPowietrza) {
            super(PozycjaX, PozycjaY,pulap, wektorRuchu, predkosc, dlugosc, szerokosc);
            this.OporPowietrza=OporPowietrza;
            ID=count++;
        }

        @Override
        public String toString() {
            return "Sportowcy {" +
                    "PozycjaX=" + PozycjaX +
                    ", PozycjaY=" + PozycjaY +
                    ", pulap=" + pulap +
                    ", WektorRuchu='" + WektorRuchu + '\'' +
                    ", Predkosc=" + Predkosc +
                    ", Dlugosc=" + Dlugosc +
                    ", Szerokosc=" + Szerokosc +
                    ", Odleglosc=" + Odleglosc +
                    ", OporPowietrza=" + OporPowietrza +
                    '}';

        }
    }

    public static class Modelarze extends PrzestrzenPowietrzna {

        int maksymalnapredkosc;
        static int count =0;
        int ID;

        public Modelarze(int PozycjaX, int PozycjaY, int pulap, int wektorRuchu, int predkosc, int dlugosc, int szerokosc, int maksymalnapredkosc) {
            super(PozycjaX, PozycjaY,pulap, wektorRuchu, predkosc, dlugosc, szerokosc);
            this.maksymalnapredkosc=maksymalnapredkosc;
            ID=count++;
        }

        @Override
        public String toString() {
            return "Modelarze {" +
                    "PozycjaX=" + PozycjaX +
                    ", PozycjaY=" + PozycjaY +
                    ", pulap=" + pulap +
                    ", WektorRuchu='" + WektorRuchu + '\'' +
                    ", Predkosc=" + Predkosc +
                    ", Dlugosc=" + Dlugosc +
                    ", Szerokosc=" + Szerokosc +
                    ", Odleglosc=" + Odleglosc +
                    ", maksymalnapredkosc=" + maksymalnapredkosc +
                    '}';

        }
    }

    public static void Load (int ilerazy) throws FileNotFoundException {
        String path = "C:\\\\Users\\\\PC\\\\Desktop\\\\ppj.txt";
        File file = new File(path);
        Scanner sc;
        file = new File(path);
        sc = new Scanner(file);
        PrzestrzenPowietrzna obj3[] = new PrzestrzenPowietrzna[10+10*ilerazy];

        int licznik =0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] words = line.split(" ");
            Random r = new Random();
            int zmienna = r.nextInt(100) + 1;
            int zmienna2 = r.nextInt(100) + 1;
            int zmienna3 = r.nextInt(100) + 1;
            if (words[0].equals("SW")){
                obj3[licznik] =  new SiłyWojskowe(Integer.parseInt(words[2]),Integer.parseInt(words[3]),Integer.parseInt(words[4]),Integer.parseInt(words[5])
                        ,Integer.parseInt(words[6]),Integer.parseInt(words[7]),Integer.parseInt(words[8]),Integer.parseInt(words[9]));
                licznik++;
                for (int z=0;z<ilerazy;z++){
                    zmienna = r.nextInt(100) + 1;
                    zmienna2 = r.nextInt(100) + 1;
                    zmienna3 = r.nextInt(100) + 1;
                    obj3[licznik] =  new SiłyWojskowe(zmienna,zmienna2,zmienna3,Integer.parseInt(words[5])
                            ,Integer.parseInt(words[6]),Integer.parseInt(words[7]),Integer.parseInt(words[8]),Integer.parseInt(words[9]));
                    licznik++;
                }
            }
            if (words[0].equals("S")){
                obj3[licznik]= new Sportowcy(Integer.parseInt(words[2]),Integer.parseInt(words[3]),Integer.parseInt(words[4]),Integer.parseInt(words[5])
                        ,Integer.parseInt(words[6]),Integer.parseInt(words[7]),Integer.parseInt(words[8]),Integer.parseInt(words[9]));
                licznik++;
                for (int z=0;z<ilerazy;z++){
                    zmienna = r.nextInt(100) + 1;
                    zmienna2 = r.nextInt(100) + 1;
                    zmienna3 = r.nextInt(100) + 1;
                    obj3[licznik] =  new Sportowcy(zmienna,zmienna2,zmienna3,Integer.parseInt(words[5])
                            ,Integer.parseInt(words[6]),Integer.parseInt(words[7]),Integer.parseInt(words[8]),Integer.parseInt(words[9]));
                    licznik++;
                }
            }
            if (words[0].equals("M")){
                obj3[licznik] = new Modelarze(Integer.parseInt(words[2]),Integer.parseInt(words[3]),Integer.parseInt(words[4]),Integer.parseInt(words[5])
                        ,Integer.parseInt(words[6]),Integer.parseInt(words[7]),Integer.parseInt(words[8]),Integer.parseInt(words[9]));
                licznik++;
                for (int z=0;z<ilerazy;z++){
                    zmienna = r.nextInt(100) + 1;
                    zmienna2 = r.nextInt(100) + 1;
                    zmienna3 = r.nextInt(100) + 1;
                    obj3[licznik] =  new Modelarze(zmienna,zmienna2,zmienna3,Integer.parseInt(words[5])
                            ,Integer.parseInt(words[6]),Integer.parseInt(words[7]),Integer.parseInt(words[8]),Integer.parseInt(words[9]));
                    licznik++;
                }
            }
        }
        System.out.println();
        System.out.println("przed włożeniem do dwuwymiarowej");
        for (int i=0;i<10+10*ilerazy;i++){
            System.out.print(obj3[i].getOdleglosc()+" ");
        }
        System.out.println();

        PrzestrzenPowietrzna obj2[][] = new PrzestrzenPowietrzna[5][10+10*ilerazy];
        int var=0;
        int var2=0;
        int var3=0;
        int var4=0;
        int var5=0;
        int var6=0;
        for (int i=0;i<10+10*ilerazy;i++){
            if ( obj3[i].getOdleglosc()<=3) {
                obj2[0][var]=obj3[i];
                var++;
            }
            if ( obj3[i].getOdleglosc()<=9 && obj3[i].getOdleglosc()>3) {
                obj2[1][var2]=obj3[i];
                var2++;
            }
            if ( obj3[i].getOdleglosc()<=27  && obj3[i].getOdleglosc()>9) {
                obj2[2][var3]=obj3[i];
                var3++;

            }
            if ( obj3[i].getOdleglosc()<=81  && obj3[i].getOdleglosc()>27) {
                obj2[3][var4]=obj3[i];
                var4++;

            }
            if ( obj3[i].getOdleglosc()<=243  && obj3[i].getOdleglosc()>81) {
                obj2[4][var5]=obj3[i];
                var5++;
            }
            if ( obj3[i].getOdleglosc()<=729  && obj3[i].getOdleglosc()>243) {
                obj2[5][var6]=obj3[i];
                var6++;
            }
        }

        System.out.println();
        System.out.print("po włożeniu do dwuwymiarowej");
        for (int i=0;i<var;i++){
            System.out.print(obj2[0][i].getOdleglosc()+" ");
        }
        System.out.println();
        for (int i=0;i<var2;i++){
            System.out.print(obj2[1][i].getOdleglosc()+" ");
        }
        System.out.println();
        for (int i=0;i<var3;i++){
            System.out.print(obj2[2][i].getOdleglosc()+" ");
        }
        System.out.println();
        for (int i=0;i<var4;i++){
            System.out.print(obj2[3][i].getOdleglosc()+" ");
        }
        System.out.println();
        for (int i=0;i<var5;i++){
            System.out.print(obj2[4][i].getOdleglosc()+" ");
        }
        System.out.println();
        for (int i=0;i<var6;i++){
            System.out.print(obj2[5][i].getOdleglosc()+" ");
        }
    }

    public static void Save (PrzestrzenPowietrzna obj[]) throws IOException {
        File output = new File("output.txt");
        FileWriter writer = new FileWriter (output);
        for (int i=0;i<obj.length;i++){
            writer.write(obj[i].toString());
            writer.write("\n");
        }
        writer.flush();
        writer.close();
    }
}