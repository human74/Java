package zad1;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class Francuski {

    public static void main(String[] arg){
        int FRServerPort = 5002;
        Francuski francuski = new Francuski();
        francuski.server(FRServerPort);
    }

    private Socket socket = null;
    private Socket socketSend = null;
    private ServerSocket serversocket = null;
    private DataInputStream inDataInputServer = null;
    private DataInputStream inputdataServer = null;
    private DataOutputStream outputdataServer = null;

    private Map<String, String> mapWords = Map.of
            ("auto", "voiture",
            "rower", "bicyclette",
            "samolot", "avion",
            "tir", "un camion");

    public void server(int port) {

        try {
            serversocket = new ServerSocket(port);
            System.out.println("Server francuski wystartował");
            System.out.println("Oczekiwanie na klienta");

            String line = "";
            while (!line.equals("Over")) {
                socket = serversocket.accept();
                System.out.println("Akceptacja klienta");
                inDataInputServer = new DataInputStream(
                        new BufferedInputStream(socket.getInputStream()));
                line = inDataInputServer.readUTF();
                String[] splitLine = line.split(";");
                socketSend = new Socket("localhost", Integer.parseInt(splitLine[1]));
                inputdataServer = new DataInputStream(System.in);
                outputdataServer = new DataOutputStream(socketSend.getOutputStream());
                try {
                    outputdataServer.writeUTF(mapWords.get(splitLine[0]));
                }catch (NullPointerException a){
                    outputdataServer.writeUTF("Slowa nie znaleziono w slowniku Francuskim");
                }
            }
            System.out.println("Koniec połączenia");
            socket.close();
            inDataInputServer.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }
}