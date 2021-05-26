package com.company;
public class Osiedle {
    int LiczbaMieszkan;
    int LiczbaMiejscParkingowych;
    Mieszkanie [] mieszkania;

    Osiedle(int liczbaMieszkan) {
        this.LiczbaMieszkan = liczbaMieszkan;
        mieszkania = new Mieszkanie[liczbaMieszkan];
        //todo zrobić dodawanie mieszkań do listy + zliczać ilość miejsc parkingowych
    }

    public String toString() {
        return "Liczba mieszkan to" + LiczbaMieszkan + "Liczba Miejsc Parkingowych to" + LiczbaMiejscParkingowych;
    }
}