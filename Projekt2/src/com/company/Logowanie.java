package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logowanie extends JFrame implements ActionListener {

    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel success;

    public Logowanie() {

        JFrame frame = new JFrame("Logowanie");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

    userLabel = new JLabel("Nick");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

    userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

    passwordLabel = new JLabel("Hasło");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

    passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

    button = new JButton("Zaloguj");
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(new Menu());
        panel.add(button);
        button.addActionListener(this::actionPerformed);

    success = new JLabel("");
        success.setBounds(10,110,300,25);
        panel.add(success);

        frame.setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = passwordText.getText();
        System.out.println(user + "," + password);

        if(user.equals("Macius") && password.equals("haslo123")) {
            success.setText("Logowanie pomyslne");
            Menu menu = new Menu();
            dispose();
        }
        else{
            success.setText("wlamywacz");
            //System.exit();
        }

    }
}
