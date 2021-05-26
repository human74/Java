package com.company;
import java.util.*;
import java.io.File;
import java.text.DateFormat;

public class Main  extends Thread{
    static Osoba zalogowanaOsoba = null;
    static Pomieszczenie wybranePomieszczenie = null;
    static Przedmiot wybranyPrzedmiot=null;

    public static void main(String[] args) {
        // W metodzie main należy utworzyć osiedle wraz z co najmniej dziesięcioma gotowymi
        // pomieszczeniami różnego typu i rozmiaru oraz kilka(minimum5) gotowych osób.
        // Ze wstępnie przydzielonymi najmami oraz umiejscowionymi przedmiotami na miejscach parkingowych.

        //uruchomienie czasu
        new Thread(new Czas()).start();

        Osiedle Osiedle1 = new Osiedle(10);     //todo dodawanie mieszkan do osiedla
        Pomieszczenie M1 = new Mieszkanie(80);
        Pomieszczenie M2 = new Mieszkanie(5,5,5);
        Pomieszczenie M3 = new Mieszkanie(7,7,7);
        Pomieszczenie M4 = new Mieszkanie(4,4,4);
        Pomieszczenie M5 = new Mieszkanie(56);
        Pomieszczenie M6 = new MiejsceParkingowe(3,4,5);
        Pomieszczenie M7 = new MiejsceParkingowe(4,5,6);
        Pomieszczenie M8 = new MiejsceParkingowe(66);
        Pomieszczenie M9 = new MiejsceParkingowe(78);
        Pomieszczenie M10 = new MiejsceParkingowe(112);

        Przedmiot kanapa = new Przedmiot("kanapa",13);
        Przedmiot szafa = new Przedmiot("spora szafa", 12);
        Przedmiot auto1 = new Pojazd("ferrari",2,3,4);

        Osoba pierwsza = new Osoba("Maciej", "Guzdek", 123,"warszawa");
        Osoba druga = new Osoba("Adam", "reka", 1234,"bielsko-biala");
        Osoba trzy = new Osoba("Andrzej", "Broda", 12345,"sopot");
        Osoba cztery = new Osoba("Marcin", "Kabzinski", 123456,"gdansk");
        Osoba piata = new Osoba("Janusz", "Kowalski", 1234567,"poznan");

        //lista przedmiotów na osiedlu
        List <Przedmiot> ListaPrzedmiotow = Arrays.asList(
                szafa,auto1,kanapa
        );

        Collections.sort(ListaPrzedmiotow , new PrzedmiotComparator(PrzedmiotCrit.ROZMIAR));
        System.out.println(ListaPrzedmiotow );



        int choice = -1;
        do {
            System.out.println("Jeśli chcesz wyjść naciśnij 1");
            System.out.println("Jeśli chcesz wbrać którą jesteś osobą, wystarczy unikalne ID naciśnij 2");
            System.out.println("Jeśli chcesz dowiedzieć się o swoich danych i wynajętych pomieszczeniach naciśnij 3");
            System.out.println("By wyświetlić wolne pomieszczenia naciśnij 4");
            System.out.println("Jeśli chcesz wynajać pomieszczenie po poprzednim jego wybraniu naciśnij 5");
            System.out.println("Wybierz pomieszczenie które wynajmuje dana osoba oraz wyświetl zawartość pomieszczenia naciśnij 6");
            System.out.println("Jeśli chcesz włożyć przedmiot/pojazd pamiętający by go nie przepełnić pomieszczenia naciśnij 7");
            System.out.println("Jeśli chcesz wyjąć przedmiot lub pojazd naciśnij 8");
            System.out.println("Jeśli chcesz zapisać stan osiedla naciśnij 9");
            Scanner scan = new Scanner(System.in);
            while (choice == -1) {
                try {
                    choice = scan.nextInt();

                    if(choice>9 || choice<1)
                        throw new InputMismatchException();

                } catch (InputMismatchException e) {
                    System.out.println("zły wybór");
                }
            }


            switch (choice) {
                case 1:
                    choice = 1;
                    System.out.println("Miłego dnia");
                    break;

                case 2:
                    System.out.println("Logowanie - podaj swoje ID");
                    int id = new Scanner(System.in).nextInt();          //todo obsługa wyjątku

                    boolean znaleziono = false;
                    for (Osoba osoba : Osoba.osoby) {
                        if(id == osoba.idOsoby){
                            zalogowanaOsoba = osoba;
                            znaleziono = true;
                            System.out.println("zalogowano jako: " + osoba);
                            break;
                        }
                    }
                    if(!znaleziono){
                        System.out.println("Nie znaleziono osoby z tym ID!");
                    }
                    break;


                case 3:
                    if(zalogowanaOsoba == null){
                        System.out.println("nie zalogowałeś się!");
                        break;
                    }
                    System.out.println("Twoje dane:\n" + zalogowanaOsoba);
                    List<Pomieszczenie> pomieszczenia = Pomieszczenie.wynajetePomieszczenia(zalogowanaOsoba);

                    if(pomieszczenia.isEmpty()){
                        System.out.println("nie wynajmujesz zadnych pomieszczen");
                        break;
                    }
                    else {
                        System.out.println("wynajmujesz nastepujące pomieszczenia:\n");
                        pomieszczenia.forEach(System.out::println);
                    }
                    break;
                case 4:
                    List<Pomieszczenie> wolne = Pomieszczenie.wolnePomieszczenia();
                    if(wolne.isEmpty()){
                        System.out.println("nie ma wolnych pomieszczen");
                        break;
                    }
                    else {
                        System.out.println("te pomieszczenia nie mają najemcy:\n");
                        wolne.forEach(System.out::println);
                    }
                    break;
                case 5:
                    if(wybranePomieszczenie == null) {
                        System.out.println("wybierz pomieszczenie, które chcesz wynająć");
                        break;
                    }
                    if(zalogowanaOsoba == null) {
                        System.out.println("zaloguj się, aby wynająć mieszkanie");
                        break;
                    }
                    if(wybranePomieszczenie.ustalWlasciciela(zalogowanaOsoba)){
                        System.out.println("pomyślnie rozpocząłeś najem mieszkania!");
                    }
                    else {
                        System.out.println("nie udało się wynająć mieszkania");
                    }


                    break;
                case 6:
                    System.out.println("podaj id pomieszczenia, które chcesz wybrać: ");

                    int a = new Scanner(System.in).nextInt();
                    Pomieszczenie wybrane = Pomieszczenie.wybierzPomieszczenie(a);
                    if(wybrane == null)
                        System.out.println("nie ma takiego pomieszczenia");
                    else
                        wybranePomieszczenie = wybrane;
                    break;
                case 7:
                    System.out.println("7");
                    break;
                case 8:
                    System.out.println("8");
                    break;
                case 9:

//                    Collections.sort(lista);
                    System.out.println("dane zapisano");
                    //System.out.println(lista);
                    break;
            }
        }
            while (choice != 1) ;
    }
}
