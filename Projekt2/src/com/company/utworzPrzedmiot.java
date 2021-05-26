package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class utworzPrzedmiot extends JFrame implements ActionListener {

    private static JLabel userLabel;
    private static JTextField userText;

    utworzPrzedmiot(){

        JFrame frame = new JFrame("Tworzenie magazynu");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        userLabel = new JLabel("Powierzchnia magazynu");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        userLabel = new JLabel("Powierzchnia magazynu");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
