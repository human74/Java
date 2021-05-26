package com.company;

import java.util.ArrayList;
import java.util.List;

abstract class Pomieszczenie implements Comparable <Pomieszczenie> {
    private Osoba wlasciciel = null;
    private static List<Pomieszczenie> pomieszczenia = new ArrayList<>();

     private static int GeneratoridPomieszczenia = 0;
     int idPomieszczenia;
     int PowierzchniaPomieszczenia;
     int SzerokoscPomieszczenia;
     int DlugoscPomieszczenia;
     int WysokoscPomieszczenia;
     int JakDlugoNajem;

        Pomieszczenie(int objetoscPomieszczenia) {
            //todo podzielic przez wysokosc
            this.PowierzchniaPomieszczenia = objetoscPomieszczenia;
            this.idPomieszczenia = ++GeneratoridPomieszczenia;
            pomieszczenia.add(this);
        }
        Pomieszczenie(int SzerokoscPomieszczenia, int DlugoscPomieszczenia, int WysokoscPomieszczenia){
            this.SzerokoscPomieszczenia = SzerokoscPomieszczenia;
            this.DlugoscPomieszczenia = DlugoscPomieszczenia;
            this.WysokoscPomieszczenia = WysokoscPomieszczenia;
            this.idPomieszczenia = ++GeneratoridPomieszczenia;
            PowierzchniaPomieszczenia = SzerokoscPomieszczenia * DlugoscPomieszczenia * WysokoscPomieszczenia;
            pomieszczenia.add(this);
        }

    static List<Pomieszczenie> wynajetePomieszczenia(Osoba zalogowanaOsoba) {
        List<Pomieszczenie> pom = new ArrayList<>();

        for (Pomieszczenie pomieszczenie : pomieszczenia) {
                if(pomieszczenie.wlasciciel == zalogowanaOsoba)
                    pom.add(pomieszczenie);
        }

        return pom;
    }

    static List<Pomieszczenie> wolnePomieszczenia() {
            List<Pomieszczenie> wynik = new ArrayList<>();
        for (Pomieszczenie pomieszczenie : pomieszczenia) {
            if (pomieszczenie.wlasciciel == null)
                wynik.add(pomieszczenie);
        }
        return wynik;
    }

    public static Pomieszczenie wybierzPomieszczenie(int id) {
        for (Pomieszczenie pomieszczenie : pomieszczenia) {
            if(pomieszczenie.idPomieszczenia == id)
                return pomieszczenie;
        }
        return null;
    }

    public static void sprawdzStan() {
            //todo zaimplementowac sprawdzanie jak wyglada najem na ten dzien
    }

    int PowierzchniaPomieszczenia() {
         return this.PowierzchniaPomieszczenia;
     }

     @Override
     public String toString() {
         return "Pomieszczenie" + "idPomieszczenia=" +"\n"+ idPomieszczenia +
                 ", \nPowierzchniaPomieszczenia=" + PowierzchniaPomieszczenia +
                 ", \nSzerokoscPomieszczenia=" + SzerokoscPomieszczenia +
                 ", \nDlugoscPomieszczenia=" + DlugoscPomieszczenia +
                 ", \nWysokoscPomieszczenia=" + WysokoscPomieszczenia +
                 '}';
     }

    public void WlozPrzedmiot() {

    }

    public boolean ustalWlasciciela(Osoba osoba){
        if(osoba == null){
            System.out.println("zaloguj się by wynająć mieszkanie!");
            return false;
        }

        if(wlasciciel != null) {
            System.out.println("to mieszkanie jest juz wynajmowane!");
            return false;
        }

        //todo sprawdzenie czy wlasciciel nie ma za duzo mieszkań

        wlasciciel = osoba;
        return true;
    }

    public Osoba getWlasciciel() {
        return wlasciciel;
    }

    @Override
     public int compareTo(Pomieszczenie P1) {
        if (this.PowierzchniaPomieszczenia() > P1.PowierzchniaPomieszczenia())
            return 1;
        else
            return -1;
     }

 }
