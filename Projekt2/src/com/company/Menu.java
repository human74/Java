package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JButton jb1 = new JButton("Lista magazynow wraz z poziomem zapełnienia");
    JButton jb2 = new JButton("Wyświetl listę przedmiotów oraz informacje o nich");
    JButton jb3 = new JButton("Dodaj magazyn");
    JButton jb4 = new JButton("Utwórz przedmiot");
    JButton jb5 = new JButton("Dodaj przedmiot do wybranego magazynu");
    JButton jb6 = new JButton("Wyświetl listę magazynów wraz z przedmiotami");
    JButton jb7 = new JButton("Zapis stanów magazynó do pliku");
    JButton jb8 = new JButton("Wczytaj stan magazynów z pliku");

    public Menu() {

        JFrame frame = new JFrame("Menu");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        jb1.setBounds(170, 70, 350, 20);
        jb2.setBounds(170, 110, 350, 20);
        jb3.setBounds(170, 150, 350, 20);
        jb4.setBounds(170, 190, 350, 20);
        jb5.setBounds(170, 230, 350, 20);
        jb6.setBounds(170, 270, 350, 20);
        jb7.setBounds(170, 310, 350, 20);
        jb8.setBounds(170, 350, 350, 20);

        panel.add(jb1);
        panel.add(jb2);
        panel.add(jb3);
        panel.add(jb4);
        panel.add(jb5);
        panel.add(jb6);
        panel.add(jb7);
        panel.add(jb8);





}

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
