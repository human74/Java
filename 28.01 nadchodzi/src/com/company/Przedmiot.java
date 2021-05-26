package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Przedmiot {
    private static int GeneratoridPrzedmiotu = 0;
    int idPrzedmiotu;
    String Nazwa;
    int PowierzchniaPrzedmiotu;
    int SzerokoscPrzedmiotu;
    int WysokoscPrzedmiotu;
    int DlugoscPrzedmiotu;
    private static List<Przedmiot> przedmioty = new ArrayList<>();

    Przedmiot(String Nazwa, int PowierzchniaPrzedmiotu){
        this.Nazwa=Nazwa;
        this.PowierzchniaPrzedmiotu=PowierzchniaPrzedmiotu;
        this.idPrzedmiotu = ++GeneratoridPrzedmiotu;
        przedmioty.add(this);
    }
    Przedmiot(String Nazwa, int SzerokoscPrzedmiotu, int WysokoscPrzedmiotu, int DlugoscPrzedmiotu) {
        this.Nazwa=Nazwa;
        this.SzerokoscPrzedmiotu=SzerokoscPrzedmiotu;
        this.WysokoscPrzedmiotu=WysokoscPrzedmiotu;
        this.DlugoscPrzedmiotu=DlugoscPrzedmiotu;
        this.PowierzchniaPrzedmiotu=PowierzchniaPrzedmiotu;
        this.idPrzedmiotu = ++GeneratoridPrzedmiotu;
        przedmioty.add(this);
    }
    public static Przedmiot wybierzPrzedmiot(int id) {
        for (Przedmiot przedmiot : przedmioty) {
            if(przedmiot.idPrzedmiotu == id)
                return przedmiot;
        }
        return null;
    }
    public int PowierzchniaPrzedmiotu() {
        return this.PowierzchniaPrzedmiotu;
    }



    public void WlozPrzedmiot() {

    }
}
