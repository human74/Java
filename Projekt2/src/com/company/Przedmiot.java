package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Przedmiot {

    private static int GeneratoridPrzedmiotu = 0;
    int idPrzedmiotu;
    String Nazwa;
    private int PowierzchniaPrzedmiotu;
    JFrame frame = new JFrame("Przedmioty");
    JList <Przedmiot> Jprzedmioty = new JList<>();
    DefaultListModel <Przedmiot> p1 = new DefaultListModel<>();
    JLabel label = new JLabel();
    JPanel panel = new JPanel();

    static List <Przedmiot> przedmioty = new ArrayList<>();

    Przedmiot(String Nazwa, int PowierzchniaPrzedmiotu) {
        this.Nazwa = Nazwa;
        this.PowierzchniaPrzedmiotu = PowierzchniaPrzedmiotu;
        this.idPrzedmiotu = ++GeneratoridPrzedmiotu;
        przedmioty.add(this);

        Jprzedmioty.setModel( p1 );
        p1.addElement(new Przedmiot("Auto", 20));
        p1.addElement(new Przedmiot("Auto2", 202));
        panel.add(label);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel.add(label);


    }

    public static Przedmiot wybierzPrzedmiot(int id) {
        for (Przedmiot przedmiot : przedmioty) {
            if (przedmiot.idPrzedmiotu == id)
                return przedmiot;
        }
        return null;
    }

    int getPowierzchniaPrzedmiotu() {
        return this.PowierzchniaPrzedmiotu;
    }

    @Override
    public String toString() {
        return "idPrzedmiotu=" + idPrzedmiotu + ", "+
                Nazwa  +
                ", PowierzchniaPrzedmiotu=" + PowierzchniaPrzedmiotu;
    }

}
