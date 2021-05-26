package com.company;
import java.util.ArrayList;
import java.util.List;

public class Osoba {
    static List<Osoba> osoby = new ArrayList<>();

    static int GeneratoridOsoby = 0;
    int idOsoby;
    String Imie;
    String Naziwsko;
    int Pesel;
    String Adres;
    int IloscWynajetychPomieszczen = 0;
    boolean CzyNajemca = false;
    boolean CzyPosiadaMiejsceParkingowe = false;
    //DataUrodzenia;
    //DataRozpoczeciaNajmu;
    //DataZakonczeniaNajmu;
    //Jeśli najem zostanie odnowiony lub najem zostanie anulowany przez najemcę, pismo dot.
    // zadłużenia zostaje usunięte z akt osoby.

    public Osoba(String imie, String naziwsko, int pesel, String adres) {
        this.Imie = imie;
        this.Naziwsko = naziwsko;
        this.Pesel = pesel;
        this.Adres = adres;
        this.idOsoby = ++GeneratoridOsoby;
        osoby.add(this);
    }


    // Każde pomieszczenie może mieć tylko jednego najemcę w jednym czasie
    public void WynajecieMiejscaParkingowego(){
        if(IloscWynajetychPomieszczen<5 && CzyNajemca==true) {
            CzyPosiadaMiejsceParkingowe=true;
            IloscWynajetychPomieszczen++;
        }
    }
    public void WlozPrzedmiot() {
        if(CzyNajemca==true && CzyPosiadaMiejsceParkingowe==true){

        }
        else {
            System.out.println("Nie jestes najemca, wiec nie mozesz tego zrobic");
        }
    }
    public void WyciagnijPrzedmiot() {
        if(CzyNajemca==true && CzyPosiadaMiejsceParkingowe==true){

        }
        else {
            System.out.println("Nie jestes najemca, wiec nie mozesz tego zrobic");
        }
    }

    public void Zamelduj(){
        if(CzyNajemca==true) {

        }
    }

    //todo nie przenieść tego?
    public void Wymelduj(){
        if(CzyNajemca==true) {

        }
    }

    public int getIdOsoby() {
        return idOsoby;
    }

    public void setIdOsoby(int idOsoby) {
        this.idOsoby = idOsoby;
    }

    @Override
    public boolean equals(Object obj) {
        if(!obj.getClass().equals(this.getClass()))
            return false;
        return ((Osoba)obj).idOsoby == this.idOsoby;
    }

    //todo poprawic na ladniejsze
    @Override
    public String toString() {
        return "Osoba{" +
                "Imie='" + Imie + '\'' +
                ", Naziwsko='" + Naziwsko + '\'' +
                ", Pesel=" + Pesel +
                ", Adres='" + Adres + '\'' +
                ", IloscWynajetychPomieszczen=" + IloscWynajetychPomieszczen +
                ", CzyNajemca=" + CzyNajemca +
                ", CzyPosiadaMiejsceParkingowe=" + CzyPosiadaMiejsceParkingowe +
                '}';
    }


}
