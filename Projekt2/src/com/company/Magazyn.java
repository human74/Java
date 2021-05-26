package com.company;

import java.util.ArrayList;
import java.util.List;

public class Magazyn {

    private static int GeneratoridMagazynu = 0;
    int idMagazynu;
    int objetoscMagazynu;
    int dostepnaObjetosc;

    static List<Magazyn> magazyn = new ArrayList<>();
    private List<Przedmiot> zawartosc = new ArrayList<>();

    Magazyn (int objetoscMagazynu) {
        this.objetoscMagazynu = objetoscMagazynu;
        this.idMagazynu = ++GeneratoridMagazynu;
        this.dostepnaObjetosc = this.objetoscMagazynu;
        magazyn.add(this);
    }

    public static Magazyn wybierzMagazyn (int id) {
        for (Magazyn magazyny : magazyn) {
            if(magazyny.idMagazynu == id)
                return magazyny;
        }
        return null;
    }

    int getObjetoscMagazynu() {
        return this.objetoscMagazynu;
    }

    String zawartoscToString(){
        StringBuilder result = new StringBuilder("zawartość magazynu o id " + idMagazynu + ":\n");
        for (Przedmiot przedmiot : zawartosc) {
            result.append(przedmiot.toString()).append("\n");
        }
        return result.toString();
    }

    public void wlozPrzedmiot (Przedmiot wybranyPrzedmiot) throws TooManyThingsException {

        if(this.dostepnaObjetosc < wybranyPrzedmiot.getPowierzchniaPrzedmiotu()){
            throw new TooManyThingsException("za mało miejsca w tym magazynie!");
        }

        this.dostepnaObjetosc -= wybranyPrzedmiot.getPowierzchniaPrzedmiotu();
        this.zawartosc.add(wybranyPrzedmiot);
        System.out.println("Przedmiot wlożono");
    }

    void wyjmijPrzedmiot(Przedmiot wybranyPrzedmiot){

        if(!zawartosc.contains(wybranyPrzedmiot)){
            System.out.println("ten magazyn nie zawiera takiego przedmiotu");
            return;
        }

        else {
            this.zawartosc.remove(wybranyPrzedmiot);
            System.out.println("wyjęto wybrany przedmiot z tego magazynu");
        }
    }

    public List<Przedmiot> getZawartosc() {
        return zawartosc;
    }

}
