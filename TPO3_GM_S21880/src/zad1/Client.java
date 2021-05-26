package zad1;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class Client {

    public static void main(String args[]) {
        Client client = new Client("localhost", 5000);
    }

    private Socket socketSend = null;
    private Socket czekanienapolacznie = null;
    private ServerSocket socketprzychodzacy = null;
    private DataInputStream input = null;
    private DataInputStream inputprzychodzacy = null;
    private DataOutputStream daneoutput = null;

    public Client(String address, int port) {

        try {
            socketSend = new Socket(address, port);
            System.out.println("Połączono");
            System.out.println("cleint ruszyl");
            input = new DataInputStream(System.in);
            daneoutput = new DataOutputStream(socketSend.getOutputStream());

            String line = "";

            while (!line.equals("Koniec")) {
                //Jezyk slowo i na koncu port
                socketprzychodzacy = new ServerSocket(5004);
                System.out.println("client dziala");
                line = Window.intialize() + ";" + socketprzychodzacy.getLocalPort();
                if (line.length() < 10){
                    line = "Koniec";
                }
                daneoutput.writeUTF(line);
                //Oczekiwanie na odpowiedz
                czekanienapolacznie = socketprzychodzacy.accept();
                inputprzychodzacy = new DataInputStream(
                        new BufferedInputStream(czekanienapolacznie.getInputStream()));

                line = inputprzychodzacy.readUTF();
                JOptionPane.showMessageDialog(null, line, "InfoBox", JOptionPane.INFORMATION_MESSAGE);
                //System.out.println(line);
                // po wypisaniu uzytkownikowi zamykamy socket
                socketprzychodzacy.close();
            }
            inputprzychodzacy.close();
            input.close();
            daneoutput.close();
            socketprzychodzacy.close();
            socketSend.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }
}